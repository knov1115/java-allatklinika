<%--
  Created by IntelliJ IDEA.
  User: novak
  Date: 2025. 03. 27.
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="g" uri="/WEB-INF/tlds/globalIdentifier.tld" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page Welcome="Pet List">
    <table class="pet-list-table">
        <thead>
        <tr>
            <td><h2>ID</h2></td>
            <td><h2>Name</h2></td>
            <td><h2>Chip code</h2></td>
            <td><h2>Address</h2></td>
            <td><h2>Species</h2></td>
            <td><h2>Global identifier</h2></td>
            <td><h2>Action</h2></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${petList}" var="pet">
            <tr>
                <td>
                    <c:out value="${pet.id}"/>
                </td>
                <td>
                    <c:out value="${pet.name}"/>
                </td>
                <td>
                    <c:out value="${pet.chipCode}"/>
                </td>
                <td>
                    <c:out value="${pet.address}"/>
                </td>
                <td>
                    <c:out value="${pet.species}"/>
                </td>
                <td>
                    <g:GlobalIdentifier pet="${pet}"/>
                </td>
                <td>
                    <form method="post" action="${pageContext.request.contextPath}/petList">
                        <button type="submit" name="action" value="delete">Delete</button>
                        <input type="hidden" name="petId" value="${pet.id}">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</t:page>
