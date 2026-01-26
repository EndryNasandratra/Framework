<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire Employé</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 32px; }
        .field { margin-bottom: 12px; }
        label { display: block; font-weight: bold; margin-bottom: 4px; }
        input, select { padding: 6px; width: 260px; }
        .message { color: #2e7d32; margin-bottom: 16px; }
    </style>
</head>
<body>
<h1>Formulaire Employé</h1>

<%
    testFramework.com.testframework.model.EmployeDTO employe = (testFramework.com.testframework.model.EmployeDTO) request.getAttribute("employe");
    if (employe == null) {
        employe = new testFramework.com.testframework.model.EmployeDTO();
    }
    String message = (String) request.getAttribute("message");
%>

<% if (message != null) { %>
    <div class="message"><%= message %></div>
<% } %>

<form action="<%= request.getContextPath() %>/employe/save" method="POST">
    <div class="field">
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" value="<%= employe.getNom() == null ? "" : employe.getNom() %>" />
    </div>

    <div class="field">
        <label for="age">Âge:</label>
        <input type="number" id="age" name="age" value="<%= employe.getAge() == null ? "" : employe.getAge() %>" />
    </div>

    <div class="field">
        <label for="dept">Département:</label>
        <select id="dept" name="dept">
            <option value="">-- Sélectionner --</option>
            <option value="1" <%= (employe.getDept() != null && employe.getDept().getId() != null && employe.getDept().getId() == 1L) ? "selected" : "" %>>Informatique</option>
            <option value="2" <%= (employe.getDept() != null && employe.getDept().getId() != null && employe.getDept().getId() == 2L) ? "selected" : "" %>>Ressources Humaines</option>
            <option value="3" <%= (employe.getDept() != null && employe.getDept().getId() != null && employe.getDept().getId() == 3L) ? "selected" : "" %>>Marketing</option>
        </select>
    </div>

    <div class="field">
        <label for="lieu">Lieu:</label>
        <select id="lieu" name="lieu">
            <option value="">-- Sélectionner --</option>
            <option value="1" <%= (employe.getLieu() != null && employe.getLieu().getId() != null && employe.getLieu().getId() == 1L) ? "selected" : "" %>>Paris, France</option>
            <option value="2" <%= (employe.getLieu() != null && employe.getLieu().getId() != null && employe.getLieu().getId() == 2L) ? "selected" : "" %>>Lyon, France</option>
            <option value="3" <%= (employe.getLieu() != null && employe.getLieu().getId() != null && employe.getLieu().getId() == 3L) ? "selected" : "" %>>Marseille, France</option>
        </select>
    </div>

    <button type="submit">Enregistrer</button>
</form>

</body>
</html>
