<%--
  Created by IntelliJ IDEA.
  User: bert
  Date: 8/4/17
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Band page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>

</head>
<body>

<a href="../../index.jsp">Back to main menu</a>

<h1>Band list</h1>

<c:if test="${!empty listBand}">
    <table class="tg">
        <tr>
            <th width="60">ID</th>
            <th width="100">DATA</th>
            <th width="120">NAME GROUP</th>

        </tr>

        <c:forEach items="${listBand}" var="band">

            <tr>
                <td>${band.id}</td>
                <td>${band.dates}</td>
                <td>${band.nameGroup}</td>
                <td><a href="<c:url value='/edit/${band.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${band.id}'/>">Delete</a></td>
            </tr>

        </c:forEach>
    </table>
</c:if>


<h2>Register group</h2>

<c:url var="addAction" value="/bands/add"/>

<form:form action="${addAction}" commandName="band">

    <table>
        <c:if test="${!empty band.nameGroup}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>

        <tr>
            <td>
                <form:label path="dates">
                    <spring:message text="Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="dates"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="nameGroup">
                    <spring:message text="Name Group"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameGroup"/>
            </td>
        </tr>


        <tr>
            <td colspan="2">
                <c:if test="${!empty band.nameGroup}">
                    <input type="submit"
                           value="<spring:message text="Edit Band"/>"/>
                </c:if>
                <c:if test="${empty band.nameGroup}">
                    <input type="submit"
                           value="<spring:message text="Add Band"/>"/>
                </c:if>
            </td>
        </tr>
    </table>

</form:form>

</body>
</html>
