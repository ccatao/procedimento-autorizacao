package br.com.procedimentos.web;

import java.io.IOException;
import java.sql.SQLException;


import br.com.procedimentos.dao.ProcedimentoDao;
import br.com.procedimentos.model.Procedimento;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editar")
public class EditarServlet extends HttpServlet{
	
    private static final long serialVersionUID = 1;
    private ProcedimentoDao procedimentoDao;
    
    public void init() {
    	procedimentoDao = new ProcedimentoDao();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			if (request.getMethod().equals("GET")) {
				showEditForm(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/");
			}
				
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		
		if ( request.getParameter("id") == null ||
				request.getParameter("idade") == null	||
				request.getParameter("sexo") == null) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("listar");
			dispatcher.forward(request, response);			
		}
		
		Integer procedimento = Integer.parseInt(request.getParameter("id"));
		Integer idade = Integer.parseInt(request.getParameter("idade"));
		String sexo = request.getParameter("sexo");
		Procedimento editaProcedimento = procedimentoDao.selectProcedimento(procedimento, idade, sexo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-procedimento.jsp");
		request.setAttribute("procedimento", editaProcedimento);
		dispatcher.forward(request, response);

	}

}
