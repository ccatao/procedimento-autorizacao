package br.com.procedimentos.web;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/novo")
public class NovoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1;

	public void init() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			if (request.getMethod().equals("GET")) {
				showNewForm(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-procedimento.jsp");
		dispatcher.forward(request, response);
	}

}
