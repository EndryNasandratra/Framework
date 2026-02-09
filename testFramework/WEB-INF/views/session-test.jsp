<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Session</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 32px; }
        .card { border: 1px solid #ddd; padding: 16px; border-radius: 8px; max-width: 640px; }
        .muted { color: #666; }
        a.button { display: inline-block; padding: 8px 12px; background: #1976d2; color: #fff; border-radius: 4px; text-decoration: none; }
    </style>
    </head>
<body>
<div class="card">
    <h1>Test de Session</h1>
    <p>ID de session: <strong><%= String.valueOf(request.getAttribute("sid")) %></strong></p>
    <p>Compteur: <strong><%= String.valueOf(request.getAttribute("count")) %></strong></p>
    <p><a class="button" href="<%= request.getContextPath() %>/session/test">Incrémenter</a></p>
    <p class="muted">Rechargez la page ou cliquez pour incrémenter le compteur côté session.</p>
    <p><a href="<%= request.getContextPath() %>">Accueil</a></p>
</div>
</body>
</html>
