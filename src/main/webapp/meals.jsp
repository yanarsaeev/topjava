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
            <%
                List<MealTo> list = (List<MealTo>) request.getAttribute("meals");
                if (list != null) {
                    for (MealTo meal : list) {
            %>
            <tr>
                <td><%=meal.getDate()%> <%=meal.getTime()%></td>
                <td><%=meal.getDescription()%></td>
                <td><%=meal.getCalories()%></td>
            </tr>
            <%
                    }
                }  else {
            %>
            <tr>
                <td colspan="2">Нет данных</td>
            </tr>
            <%}%>
        </table>
    </section>
</body>
</html>
