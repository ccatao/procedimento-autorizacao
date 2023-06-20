package br.com.procedimentos.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class InicioServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1;
    
    public void init() {

    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			if (request.getMethod().equals("GET")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("/");
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
