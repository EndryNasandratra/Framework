<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Result</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 32px; }
        table { border-collapse: collapse; }
        td { padding: 6px 12px; border-bottom: 1px solid #ddd; }
    </style>
</head>
<body>
<h1>Upload Result</h1>

<p>Mode: <strong><%= request.getAttribute("mode") %></strong></p>

<table>
    <tr>
        <td>Title</td>
        <td><%= String.valueOf(request.getAttribute("title")) %></td>
    </tr>
    <tr>
        <td>File name</td>
        <td><%= String.valueOf(request.getAttribute("fileName")) %></td>
    </tr>
    <tr>
        <td>File size</td>
        <td><%= String.valueOf(request.getAttribute("fileSize")) %> bytes</td>
    </tr>
    <tr>
        <td>Content-Type</td>
        <td><%= String.valueOf(request.getAttribute("contentType")) %></td>
    </tr>
</table>

<p><a href="<%= request.getContextPath() %>/aiza/form">Retour au formulaire</a></p>

</body>
</html>
