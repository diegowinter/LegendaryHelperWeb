<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" 
                href="<%=application.getContextPath() %>/res/styles.css" >
<title>Conectar Spotify ao LegendaryHelper</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon" />
</head>
<body>
<div class="header">
	<h1>LegendaryHelper</h1>
</div>
<div id="container">
	<div id="content">
		<c:if test="${(param.user_id != null)}">
			<h2>Expanda as funcionalidades do LegendaryHelper</h2>
			<div id="images">
				 <img src="<%=request.getContextPath()%>/res/images/spotify.png" width=75 height=75>
				 <p class="plus">+</p>
				 <h2>LegendaryHelper</h2>
			</div>
			<h3>Conecte sua conta do Spotify e controle a reprodução através de comandos direto no seu
			servidor no Discord!</h3>
			<button onclick="location.href='https://accounts.spotify.com/pt-BR/authorize?client_id=28869d92fb98412690edc8314975f690&response_type=code&redirect_uri=http:%2F%2Flocalhost:8080%2FLegendaryHelperWeb%2Fspotify%2Fconfirm&state=<%=request.getParameter("user_id")%>&scope=user-modify-playback-state'"
				class="button">Conectar Spotify</button>
		</c:if>
		<c:if test="${(param.user_id == null)}">
			<c:if test="${(param.status == 'success')}">
				<img src="<%=request.getContextPath()%>/res/images/ok.png" width=100 height=100>
				<h2>Sucesso</h2>
				<h3>Experimente os comandos diretamente do seu servidor Discord!</h3>
				<p>Para uma lista de comandos, digite <i>!spotify help</i></p>
			</c:if>
			<c:if test="${(param.status == 'error')}">
				<img src="<%=request.getContextPath()%>/res/images/error.png" width=100 height=100>
				<h2>Algo deu errado (<c:out value = "${param.message}"/>)</h2>
				<h3>Tente novamente. Se o erro persistir, informe-nos.</h3>
			</c:if>
		</c:if>
		<c:if test="${(param.user_id == null) && (param.status == null)}">
			<img src="<%=request.getContextPath()%>/res/images/error.png" width=100 height=100>
			<h2>Algo deu errado (missing_parameters)</h2>
			<h3>Tente novamente. Se o erro persistir, informe-nos.</h3>
		</c:if>
	</div>
</div>
<div class="footer">
	<p>©2020 DiegoWinter.dev</p>
</div>
</body>
</html>