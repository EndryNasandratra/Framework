<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= String.valueOf(request.getAttribute("title")) %></title>
    <style>
        body { font-family: Arial, sans-serif; padding: 24px; }
        .card { border: 1px solid #ddd; padding: 16px; border-radius: 8px; max-width: 640px; }
        .muted { color: #666; }
        dt { font-weight: bold; }
        dd { margin: 0 0 8px 0; }
    </style>
</head>
<body>
<div class="card">
    <h1><%= String.valueOf(request.getAttribute("title")) %></h1>
    <dl>
        <dt>ID</dt>
        <dd><%= String.valueOf(request.getAttribute("id")) %></dd>
        <dt>Nom</dt>
        <dd><%= String.valueOf(request.getAttribute("name")) %></dd>
        <dt>Prix</dt>
        <dd><%= String.valueOf(request.getAttribute("price")) %></dd>
    </dl>
    <p class="muted">Rendered JSP: /WEB-INF/views/produit-detail.jsp</p>
</div>
</body>
</html>
