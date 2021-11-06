<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans" %>
<% JavaBeans contato = (JavaBeans) request.getAttribute("contato");%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Contatos</title>
<link rel="icon" href="imagens/title_agenda.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form name="frm_editor" action="editar">
		<table>
			<tr>
				<td class="td_frm"><input type="text" class="input_a input_c input_d"
					placeholder="ID" name="idcon" autocomplete="off"
					value = "<%out.println(contato.getIdcon());%>"></td>
			</tr>
			<tr>
				<td class="td_frm"><input type="text" class="input_a input_b"
					placeholder="Nome" name="nome" autocomplete="off" 
					value = "<%out.println(contato.getNome());%>"></td>
			</tr>
			<tr>
				<td class="td_frm"><input type="text" class="input_a input_c "
					placeholder="Fone" name="fone" autocomplete="off"
					value = "<%out.println(contato.getFone());%>"></td>
			</tr>
			<tr>
				<td class="td_frm"><input type="text" class="input_a input_b"
					placeholder="E-mail" name="email" autocomplete="off"
					value = "<%out.println(contato.getEmail());%>"></td>
			</tr>
			<tr>
				<td class="td_frm"><input type="button" id="btn_edit" value="Editar" class="btn btn_green" onclick="javascript:confirmarEdicao();"></td>
			</tr>
		</table>
	</form>
	<script src="scripts/sanitizador.js"></script>
	<script src="scripts/btn_dynamic_color_green.js"></script>
</body>
</html>