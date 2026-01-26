<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="testFramework.com.testframework.model.UploadForm" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Upload</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 32px; }
        .field { margin-bottom: 12px; }
        label { display: block; font-weight: bold; }
        input { padding: 6px; width: 260px; }
    </style>
</head>
<body>
<h1>Test Upload</h1>

<%
    UploadForm form = (UploadForm) request.getAttribute("form");
    if (form == null) form = new UploadForm();
    String title = form.getTitle() == null ? "" : form.getTitle();
%>

<h2>Upload via @RequestParam</h2>
<form method="post" action="<%= request.getContextPath() %>/aiza/request-param" enctype="multipart/form-data">
    <div class="field">
        <label for="title1">Title</label>
        <input type="text" id="title1" name="title" value="<%= title %>">
    </div>
    <div class="field">
        <label for="file1">File</label>
        <input type="file" id="file1" name="file">
    </div>
    <button type="submit">Upload (@RequestParam)</button>
</form>

<hr>

<h2>Upload via @ModelAttribute</h2>
<form method="post" action="<%= request.getContextPath() %>/aiza/model-attribute" enctype="multipart/form-data">
    <div class="field">
        <label for="title2">Title</label>
        <input type="text" id="title2" name="title" value="<%= title %>">
    </div>
    <div class="field">
        <label for="file2">File</label>
        <input type="file" id="file2" name="file">
    </div>
    <button type="submit">Upload (@ModelAttribute)</button>
</form>

</body>
</html>
