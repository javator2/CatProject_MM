<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<form action="/cats" method="post">
    Give race: <input type="text" name="race"/> <br><br>
    Give name: <input type="text" name="name"/> <br><br>
    Give Owner name: <input type="text" name="owner"/> <br><br>
    <input type="submit" name="commit" value="Commit"/>
</form>

<form action="/cats" method="get">
    Wyszukaj po:
    <input type="text" name="searchParam"/>
    <select name="option">
        <option>race</option>
        <option>name</option>
        <option>owner</option>
    </select>
    <input type="submit" value="search"/>

</form>
KOT: <br>
<c:forEach var="cat" items="${allCats}">
    <c:out value="${cat.race}"/> <br>
    <c:out value="${cat.name}"/> <br>
    <c:out value="${cat.owner}"/> <br>
</c:forEach>
</body>
</html>