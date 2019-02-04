<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phonebook</title>
</head>
<body>
    <h1>Your contacts</h1>
    <ol>
        <c:forEach var="contact" items="${contactsList}">
            <li>
                <strong>${contact.name}</strong>
                <span>${contact.telephone}</span>
                <a href="editContact?id=${contact.id}">Edit</a>
                <a href="deleteContact?id=${contact.id}">Delete</a>
            </li>
        </c:forEach>
    </ol>
    <a href="createContact">Create new contact</a>
</body>
</html>