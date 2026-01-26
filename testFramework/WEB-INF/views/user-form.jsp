<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="testFramework.com.testframework.model.UserForm" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Collections" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test User Form</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 32px; }
        .field { margin-bottom: 12px; }
        label { display: block; font-weight: bold; }
        input { padding: 6px; width: 260px; }
        .error { color: #b00020; font-size: 0.9em; }
        .success { color: #2e7d32; margin-bottom: 16px; }
    </style>
</head>
<body>

<h1>Inscription utilisateur</h1>

<%
    UserForm user = (UserForm) request.getAttribute("user");
    if (user == null) user = new UserForm();

    Map<String,String> errors = (Map<String,String>) request.getAttribute("errors");
    if (errors == null) errors = Collections.emptyMap();

    Boolean valid = (Boolean) request.getAttribute("valid");

    String u = user.getUsername() == null ? "" : user.getUsername();
    String e = user.getEmail() == null ? "" : user.getEmail();
    String p = user.getPassword() == null ? "" : user.getPassword();
%>

<% if (valid != null && valid) { %>
    <div class="success">Utilisateur validé avec succès !</div>
<% } %>

<form method="post" action="<%= request.getContextPath() %>/users/register">

    <div class="field">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" value="<%= u %>">
        <div class="error"><%= errors.getOrDefault("username", "") %></div>
    </div>

    <div class="field">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" value="<%= e %>">
        <div class="error"><%= errors.getOrDefault("email", "") %></div>
    </div>

    <div class="field">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" value="<%= p %>">
        <div class="error"><%= errors.getOrDefault("password", "") %></div>
    </div>

    <button type="submit">Valider</button>
</form>

</body>
</html>
