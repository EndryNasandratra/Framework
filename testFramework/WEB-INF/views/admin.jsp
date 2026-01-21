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
        code { background: #f5f5f5; padding: 2px 4px; border-radius: 4px; }
    </style>
</head>
<body>
<div class="card">
    <h1><%= String.valueOf(request.getAttribute("title")) %></h1>
    <p><%= String.valueOf(request.getAttribute("message")) %></p>
    <p class="muted">Count: <strong><%= String.valueOf(request.getAttribute("count")) %></strong></p>

    <h3>Debug</h3>
    <ul>
        <li>view.prefix: <code>/WEB-INF/views/</code></li>
        <li>view.suffix: <code>.jsp</code></li>
        <li>Rendered JSP: <code>/WEB-INF/views/admin.jsp</code></li>
    </ul>
</div>
</body>
</html>
