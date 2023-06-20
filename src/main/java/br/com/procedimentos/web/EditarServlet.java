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
			if (request.getMethod().equals("POST")) {
				showEditForm(request, response);
			} else {
				response.sendRedirect("/");
			}
				
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Procedimento deletaProcedimento = procedimentoDao.selectProcedimento(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-procedimento.jsp");
		request.setAttribute("procedimento", deletaProcedimento);
		dispatcher.forward(request, response);

	}

}
