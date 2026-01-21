<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= String.valueOf(request.getAttribute("title")) %></title>
    <style>
        body { font-family: Arial, sans-serif; padding: 24px; }
        .card { border: 1px solid #ddd; padding: 16px; border-radius: 8px; max-width: 640px; }
        label { display: block; margin: 8px 0 4px; }
        input[type=text], input[type=number] { padding: 6px 8px; width: 100%; box-sizing: border-box; }
        .row { margin-bottom: 12px; }
        button { padding: 8px 12px; }
        .muted { color: #666; }
    </style>
</head>
<body>
<div class="card">
    <h1><%= String.valueOf(request.getAttribute("title")) %></h1>
    <form method="get" action="<%= request.getContextPath() %>/admin/echo">
        <div class="row">
            <label for="msg">Message</label>
            <input type="text" id="msg" name="msg" placeholder="Hello" required>
        </div>
        <div class="row">
            <label for="count">Count</label>
            <input type="number" id="count" name="count" value="1" min="1">
        </div>
        <button type="submit">Echo</button>
    </form>
    <p class="muted">Submitting will call GET /admin/echo with query parameters 'msg' and 'count'.</p>
</div>
</body>
</html>
