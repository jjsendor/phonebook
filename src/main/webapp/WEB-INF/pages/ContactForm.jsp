<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact</title>
</head>
<body>
    <h1>Create or edit a contact</h1>
    <form:form action="contact" method="post" modelAttribute="contact">
        <form:hidden path="id" />
        <ul>
            <li>
                <label for="name">name</label>
                <form:input path="name" />
            </li>
            <li>
                <label for="telephone">telephone</label>
                <form:input path="telephone" />
            </li>
        </ul>
        <input type="submit" value="Create/Update" />
    </form:form>
</body>
</html>