<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <title>Gerenciar Procedimentos</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
                        <c:if test="${procedimento != null}">
                            <form action="atualizar" method="post">
                        </c:if>
                        <c:if test="${procedimento == null}">
                            <form action="inserir" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${procedimento != null}">
                                    Editar Procedimento
                                </c:if>
                                <c:if test="${procedimento == null}">
                                    Adicionar Procedimento
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${procedimento != null}">
                            <label>Procedimento Nº</label> <input type="text" name="procedimento" value="<c:out value='${procedimento.procedimento}' />" />
                        </c:if>

                        <fieldset class="form-group">
                        	<label>Procedimento</label> <input type="text" value="<c:out value='${procedimento.procedimento}' />" class="form-control" name="idade" required="required">
                        	
                            <label>Idade</label> <input type="text" value="<c:out value='${procedimento.idade}' />" class="form-control" name="idade" required="required">

                            <label>Sexo</label> <input type="text" value="<c:out value='${procedimento.sexo}' />" class="form-control" name="sexo" required="required">

                            <label>Autorização</label> <input type="text" value="${procedimento.autorizado ? 'SIM' : 'NÃO'}" class="form-control" name="autorizacao" required="required">

						</fieldset>
                        <button type="submit" class="btn btn-success">Salvar</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>