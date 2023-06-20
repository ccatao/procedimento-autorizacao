package br.com.procedimentos.web;

import java.io.IOException;
import java.sql.SQLException;

import br.com.procedimentos.dao.ProcedimentoDao;
import br.com.procedimentos.model.Procedimento;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/autorizar")
public class AutorizarServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1;
    private ProcedimentoDao procedimentoDao;
    
    public void init() {
    	procedimentoDao = new ProcedimentoDao();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			if (request.getMethod().equals("POST")) {
				autorizarProcedimento(request, response);
			} else {
				System.out.println(request.getContextPath() );
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
				
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

    private void autorizarProcedimento(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	Integer procedimento = Integer.parseInt(request.getParameter("procedimento"));
    	Integer idade = Integer.parseInt(request.getParameter("idade"));
        String sexo = request.getParameter("sexo");
        Procedimento autorizarProcedimento = procedimentoDao.selectAutorizarProcedimento(procedimento, idade, sexo);
        request.setAttribute("autorizarProcedimento", autorizarProcedimento);
        response.sendRedirect("validar");
    }

}
