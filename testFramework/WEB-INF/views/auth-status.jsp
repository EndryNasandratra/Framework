<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentification Status</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; padding: 40px; background-color: #f4f7f6; }
        .container { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); max-width: 600px; margin: auto; }
        h1 { color: #2c3e50; border-bottom: 2px solid #eee; padding-bottom: 10px; }
        .message { padding: 15px; background: #e8f4fd; border-left: 5px solid #3498db; margin: 20px 0; color: #2980b9; }
        .nav { margin-top: 30px; display: flex; flex-wrap: wrap; gap: 10px; }
        .nav a { text-decoration: none; background: #3498db; color: white; padding: 10px 15px; border-radius: 4px; font-size: 14px; transition: background 0.3s; }
        .nav a:hover { background: #2980b9; }
        .nav a.logout { background: #e74c3c; }
        .nav a.logout:hover { background: #c0392b; }
        .nav a.admin { background: #f39c12; }
        .nav a.admin:hover { background: #e67e22; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Statut d'Authentification</h1>
        <div class="message">
            ${message}
        </div>

        <div class="nav">
            <a href="${pageContext.request.contextPath}/auth/login">Se connecter (User)</a>
            <a href="${pageContext.request.contextPath}/auth/login-admin" class="admin">Se connecter (Admin)</a>
            <a href="${pageContext.request.contextPath}/auth/protected">Page Protégée</a>
            <a href="${pageContext.request.contextPath}/auth/admin" class="admin">Page Admin</a>
            <a href="${pageContext.request.contextPath}/auth/logout" class="logout">Se déconnecter</a>
        </div>
        
        <p style="margin-top: 20px;"><a href="${pageContext.request.contextPath}/">Retour à l'accueil</a></p>
    </div>
</body>
</html>
