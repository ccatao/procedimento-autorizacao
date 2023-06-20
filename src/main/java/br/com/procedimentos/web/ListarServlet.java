package br.com.procedimentos.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import br.com.procedimentos.dao.ProcedimentoDao;
import br.com.procedimentos.model.Procedimento;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listar")
public class ListarServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1;
    private ProcedimentoDao procedimentoDao;
    
    public void init() {
    	procedimentoDao = new ProcedimentoDao();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			if (request.getMethod().equals("GET")) {
				listarProcedimentos(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/");
			}
				
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void listarProcedimentos(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Procedimento > listarProcedimentos = procedimentoDao.selectAllProcedimentos();
        request.setAttribute("listarProcedimentos", listarProcedimentos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("lista-procedimento.jsp");
        dispatcher.forward(request, response);
    }
}
