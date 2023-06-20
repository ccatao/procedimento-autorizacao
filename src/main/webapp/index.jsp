<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <html>

        <head>
            <title>Gerenciar Procedimentos</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/listar" class="nav-link">Procedimentos</a></li>
                    </ul>
                </nav>
            </header>
            <br>
         <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${procedimentoAutorizar != null}">
                        
                        		<c:if test="${procedimentoAutorizar.autorizacao == false}" >
	                                O procedimento <c:out value="${procedimentoAutorizar.autorizacao}" /> não é autorizado para pacientes com idade  <c:out value="${procedimentoAutorizar.idade}" /> e sexo <c:out value="${procedimentoAutorizar.sexo}" />	                            	 
								</c:if>
                        
                           
	                             <c:if test="${procedimentoAutorizar.autorizacao != false}" >
	                                O procedimento <c:out value="${procedimentoAutorizar.autorizacao}" /> é autorizado para pacientes com idade  <c:out value="${procedimentoAutorizar.idade}" /> e sexo <c:out value="${procedimentoAutorizar.sexo}" />	                            	 
								</c:if>
								
						</c:if> 
						<form action="autorizar" method="post"> 
							<fieldset class="form-group">
	                            <label>Procedimento</label> <input type="text" value="<c:out value='${procedimento.procedimento}' />" class="form-control" name="procedimento" required="required">

	                         
	                            <label>Idade</label> <input type="text" value="<c:out value='${procedimento.idade}' />" class="form-control" name="idade" required="required">

	

	                            <label>Sexo</label> <input type="text" value="<c:out value='${procedimento.sexo}' />" class="form-control" name="sexo" required="required">
	                        </fieldset>
							 
							<button type="submit" class="btn btn-success">Autorizar</button>						
                                                           	
						</form>
                    </div>
                </div>
            </div>
        </body>
        </html>