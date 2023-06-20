package br.com.procedimentos.web;

import java.io.IOException;
import java.sql.SQLException;

import br.com.procedimentos.dao.ProcedimentoDao;
import br.com.procedimentos.model.Procedimento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/adicionar")
public class AdicionarServlet extends HttpServlet{
	
    private static final long serialVersionUID = 1;
    private ProcedimentoDao procedimentoDao;
    
    public void init() {
    	procedimentoDao = new ProcedimentoDao();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			if (request.getMethod().equals("POST")) {
				insertProcedimento(request, response);
			} else {
				response.sendRedirect("/");
			}
				
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
 
	private void insertProcedimento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Integer procedimento = Integer.parseInt(request.getParameter("procedimento"));
		Integer idade = Integer.parseInt(request.getParameter("idade"));
		String sexo = request.getParameter("sexo");
		Boolean autorizado = Boolean.parseBoolean(request.getParameter("autorizado"));
		Procedimento novoProcedimento = new Procedimento(procedimento, idade, sexo, autorizado);
		procedimentoDao.insertProcedimento(novoProcedimento);
		response.sendRedirect("listar");
	}
			
}
