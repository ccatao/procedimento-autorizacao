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

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Procedimentos atuais</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/novo" class="btn btn-success">Novo procedimento</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Procedimento</th>
                                <th>Idade</th>
                                <th>Sexo</th>
                                <th>Autorização</th>
                                <th>O que deseja?</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="procedimento" items="${listarProcedimentos}">

                                <tr>
                                    <td>
                                        <c:out value="${procedimento.procedimento}" />
                                    </td>
                                    <td>
                                        <c:out value="${procedimento.idade}" />
                                    </td>
                                    <td>
                                        <c:out value="${procedimento.sexo}" />
                                    </td>
                                    <td>
                                        <c:out value="${procedimento.autorizado}" />
                                    </td>
                                    <td><a href="editar?id=<c:out value='${procedimento.procedimento}' />&idade=<c:out value='${procedimento.idade}' />&sexo=<c:out value='${procedimento.sexo}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; 
                                    <a href="excluir?id=<c:out value='${procedimento.procedimento}' />&idade=<c:out value='${procedimento.idade}' />&sexo=<c:out value='${procedimento.sexo}' />">Excluir</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>