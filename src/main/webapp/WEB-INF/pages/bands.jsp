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
    <link rel="stylesheet" type="text/css" href="resources/datepicker/jquery.datetimepicker.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"/>
    <script src="resources/datepicker/jquery.js"></script>

</head>
<body>

<a href="../../index.jsp">Back to main menu</a>

<h1>Band list</h1>

<c:if test="${!empty listBand}">
    <table class="tg">
        <tr>
            <th width="60">ID</th>
            <th width="100">DATE</th>
            <th width="170">NAME OF BAND</th>
            <th width="100">START TIME</th>
            <th width="100">END TIME</th>
            <th width="50">COUNT HOURS</th>
            <th width="170">COMMENT</th>
        </tr>

        <c:forEach items="${listBand}" var="band">

            <tr>
                <td>${band.id}</td>
                <td>${band.dataBand}</td>
                <td>${band.nameBand}</td>
                <td>${band.startTime}</td>
                <td>${band.endTime}</td>
                <td>${band.countHours}</td>
                <td>${band.comment}</td>
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
        <c:if test="${!empty band.nameBand}">
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
                <form:label path="dataBand">
                    <spring:message text="DATA"/>
                </form:label>
            </td>
            <td>
                <form:input path="dataBand" id="datetimepicker"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="nameBand">
                    <spring:message text="Name Group"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameBand"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="startTime">
                    <spring:message text="Start Time"/>
                </form:label>
            </td>
            <td>
                <form:input path="startTime"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="endTime">
                    <spring:message text="End Time"/>
                </form:label>
            </td>
            <td>
                <form:input path="endTime"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="countHours">
                    <spring:message text="Count Hours"/>
                </form:label>
            </td>
            <td>
                <form:input path="countHours"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="comment">
                    <spring:message text="Comment"/>
                </form:label>
            </td>
            <td>
                <form:input path="comment"/>
            </td>
        </tr>


        <tr>
            <td colspan="2">
                <c:if test="${!empty band.nameBand}">
                    <input type="submit"
                           value="<spring:message text="Edit Band"/>"/>
                </c:if>
                <c:if test="${empty band.nameBand}">
                    <input type="submit"
                           value="<spring:message text="Add Band"/>"/>
                </c:if>
            </td>
        </tr>
    </table>

</form:form>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
<script src="../../resources/datepicker/build/jquery.datetimepicker.full.min.js"></script>
<script>
    $('#datetimepicker').datetimepicker();
</script>
</body>
</html>
