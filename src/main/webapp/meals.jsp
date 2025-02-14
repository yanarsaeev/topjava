<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.javawebinar.topjava.model.MealTo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Meals List</title>
</head>
<body>
    <section>
        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <th>Дата/Время</th>
                <th>Описание</th>
                <th>Калории</th>
            </tr>

            <jsp:useBean id="meals" scope="request" type="java.util.List"/>
            <c:forEach var="meal" items="${meals}">
                <tr style="color: ${meal.isExcess() ? 'red' : 'green'}">
                    <td>${meal.getDate()} ${meal.getTime()}</td>
                    <td>${meal.getDescription()}</td>
                    <td>${meal.getCalories()}</td>
                </tr>
            </c:forEach>

        </table>
    </section>
</body>
</html>
