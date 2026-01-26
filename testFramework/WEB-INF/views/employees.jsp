<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="testFramework.com.testframework.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= String.valueOf(request.getAttribute("title")) %></title>
    <style>
        body { font-family: Arial, sans-serif; padding: 24px; }
        table { border-collapse: collapse; width: 100%; max-width: 820px; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background: #f0f0f0; text-align: left; }
        .muted { color: #666; }
    </style>
</head>
<body>
<h1><%= String.valueOf(request.getAttribute("title")) %></h1>
<%
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>
<% if (employees == null || employees.isEmpty()) { %>
    <p class="muted">Aucun employe.</p>
<% } else { %>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Prenom</th>
                <th>Nom</th>
                <th>Email</th>
                <th>Role</th>
            </tr>
        </thead>
        <tbody>
        <% for (Employee e : employees) { %>
            <tr>
                <td><%= e.getId() %></td>
                <td><%= e.getFirstName() %></td>
                <td><%= e.getLastName() %></td>
                <td><%= e.getEmail() %></td>
                <td><%= e.getRole() %></td>
            </tr>
        <% } %>
        </tbody>
    </table>
<% } %>
</body>
</html>
