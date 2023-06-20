package br.com.procedimentos.web;

import java.io.IOException;
import java.sql.SQLException;

import br.com.procedimentos.dao.ProcedimentoDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
    private static final long serialVersionUID = 1;
    private ProcedimentoDao procedimentoDao;
    
    public void init() {
    	procedimentoDao = new ProcedimentoDao();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			if (request.getMethod().equals("POST")) {
				deleteProcedimento(request, response);
			} else {
				response.sendRedirect("/");
			}
				
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void deleteProcedimento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("procedimento"));
		procedimentoDao.deleteProcedimento(id);
		response.sendRedirect("listar");

		    }
}