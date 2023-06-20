package br.com.procedimentos.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.jdbc.ScriptRunner;

import br.com.procedimentos.model.Procedimento;
import br.com.procedimentos.model.Sexo;

public class ProcedimentoDao {
    
 	private String jdbcURL = "jdbc:mysql://localhost:3306/procedimento";
    private String jdbcUsername = "root";
    private String jdbcPassword = "amanha";
    private String jdbcDriver = "com.mysql.jdbc.Driver";

/*
 	private String jdbcURL = "jdbc:h2:mem:test";
    private String jdbcUsername = "";
    private String jdbcPassword = "";	    
    private String jdbcDriver = "org.h2.Driver";
*/

	    private static final String INSERT_PROCEDIMENTO_SQL = "INSERT INTO procedimento" + "  (procedimento, idade, sexo, autorizado) VALUES " +
	        " (?, ?, ?, ?);";

	    private static final String SELECT_PROCEDIMENTO_BY_ID = "select procedimento, idade, sexo, autorizado from procedimento where procedimento =? and idade ? and sexo =?";
	    private static final String SELECT_ALL_PROCEDIMENTOS = "select * from procedimento";
	    private static final String DELETE_PROCEDIMENTOS_SQL = "delete from procedimento where procedimento = ?;";
	    private static final String UPDATE_PROCEDIMENTOS_SQL = "update procedimento set idade = ?, sexo = ?, autorizado = ? where procedimento = ?;";
	    private static final String AUTORIZAR_PROCEDIMENTOS_SQL = "select * from procedimento where procedimento = ? and idade = ? and sexo= ?";	    
	    

	    public ProcedimentoDao() {}
	   
	    protected Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName(jdbcDriver);
	            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	         
	            // Após várias tentativas, desisti de tentar popular a base.
	            /*
	            ScriptRunner sr = new ScriptRunner(connection);
	            //Creating a reader object
	            Reader reader = new BufferedReader(new FileReader("src\\main\\import.sql"));
	            //Running the script
	            sr.runScript(reader);
	            */

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	       // } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
	//			e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return connection;
	    }

	    public void insertProcedimento(Procedimento user) throws SQLException {
	        System.out.println(INSERT_PROCEDIMENTO_SQL);

	        try{
	        	Connection connection = getConnection();
	        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROCEDIMENTO_SQL);
	        
	            preparedStatement.setInt(1, user.getProcedimento());
	            preparedStatement.setInt(2, user.getIdade());
	            preparedStatement.setString(3, user.getSexo().getDescricao());
	            preparedStatement.setBoolean(4, user.getAutorizado());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }

	    public Procedimento selectProcedimento(Integer procedimento, Integer idade, String sexo) {
	    	Procedimento procedimentoEditar = null;

	        try {
	        	Connection connection = getConnection();
	        	
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROCEDIMENTO_BY_ID);
	            preparedStatement.setInt(1, procedimento);
	            preparedStatement.setInt(2, idade);
	            preparedStatement.setString(3, Sexo.valueOf(sexo).getDescricao());	            
	            System.out.println(preparedStatement);

	            ResultSet rs = preparedStatement.executeQuery();


	            while (rs.next()) {
	                Boolean autorizado = rs.getBoolean("autorizado");
	                procedimentoEditar = new Procedimento(procedimento, idade, Sexo.valueOf(sexo).getDescricao(), autorizado);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return procedimentoEditar;
	    }

	    
	    public Procedimento selectAutorizarProcedimento(Integer procedimentoAutorizar, Integer idade, String sexo) {
	    	Procedimento procedimento = null;
	        // Step 1: Establishing a Connection
	        try {
	        	Connection connection = getConnection();
	        	
	        	Sexo sexoEnum = Sexo.valueOf(sexo);

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(AUTORIZAR_PROCEDIMENTOS_SQL);
	            preparedStatement.setInt(1, procedimentoAutorizar);
	            preparedStatement.setInt(2, idade);
	            preparedStatement.setString(3, Sexo.valueOf(Sexo.class, sexo).getDescricao());
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                Boolean autorizacao = rs.getBoolean("autorizado");
	                procedimento = new Procedimento(procedimentoAutorizar, idade, sexo, autorizacao);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return procedimento;
	    }
	    
	    public List<Procedimento> selectAllProcedimentos() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List <Procedimento> procedimentos = new ArrayList<Procedimento>();
	        // Step 1: Establishing a Connection
	        try {
	        	Connection connection = getConnection();
	        

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROCEDIMENTOS);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int procedimento = rs.getInt("procedimento");
	                Integer idade = rs.getInt("idade");
	                String sexo = rs.getString("sexo");
	                Boolean autorizado = rs.getBoolean("autorizado");
	                procedimentos.add(new Procedimento(procedimento, idade, sexo, autorizado));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return procedimentos;
	    }

	    public boolean deleteProcedimento(int id) throws SQLException {
	        boolean rowDeleted = false;
	        try {
	        	Connection connection = getConnection(); 
	
	      		PreparedStatement statement = connection.prepareStatement(DELETE_PROCEDIMENTOS_SQL);
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return rowDeleted;
	    }

	    public boolean updateProcedimento(Procedimento procedimento) throws SQLException {
	        boolean rowUpdated = false;
	        try {
	        	Connection connection = getConnection(); 

	       		PreparedStatement statement = connection.prepareStatement(UPDATE_PROCEDIMENTOS_SQL);
	            statement.setInt(1, procedimento.getIdade());
	            statement.setString(2, procedimento.getSexo().getDescricao());
	            statement.setBoolean(3, procedimento.getAutorizado());
	            statement.setInt(4, procedimento.getProcedimento());

	            rowUpdated = statement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return rowUpdated;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}
	