<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.JavaBeans" %>


<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/title_agenda.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<a class="btn btn_green" href="novo.html">Adcionar Contato</a>
	<a class="btn btn_blue" href="report">Gerar Relatório</a>
	<br /><br />
	<table>
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th>FONE</th>
			<th>EMAIL</th>
			<th>OPÇÕES</th>
		</tr>
		<% for(int i = 0; i < lista.size(); i++) {%>
		<tr class="line_table">
			<td><%=lista.get(i).getIdcon()%></td>
			<td><%=lista.get(i).getNome()%></td>
			<td><%=lista.get(i).getFone()%></td>
			<td><%=lista.get(i).getEmail()%></td>
			<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="btn btn_green">EDITAR</a>
			<a onclick="javascript:confirmarExclusao(<%=lista.get(i).getIdcon()%>);" class="btn btn_red">DELETAR</a></td>
		</tr>
		<% }%>
		
	</table>
	<script src="scripts/btn_dynamic_color_green.js"></script>
	<script src="scripts/btn_dynamic_color_red.js"></script>
	<script src="scripts/btn_dynamic_color_blue.js"></script>
	<script src="scripts/sanitizador.js"></script>
</body>
</html>