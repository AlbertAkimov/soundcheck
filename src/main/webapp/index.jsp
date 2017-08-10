<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/datepicker/jquery.datetimepicker.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"/>
    <script src="resources/datepicker/jquery.js"></script>
</head>
<body>
<input id="datetimepicker">

<a href="<c:url value="/main"/>" target="_blank">Привет</a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
<script src="resources/datepicker/build/jquery.datetimepicker.full.min.js"></script>
<script>
    $('#datetimepicker').datetimepicker();
</script>

</body>
</html>
