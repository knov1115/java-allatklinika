<%--
  Created by IntelliJ IDEA.
  User: novak
  Date: 2025. 03. 30.
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="g" uri="/WEB-INF/tlds/globalIdentifier.tld" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page Welcome="Add Pet">
    <form method="post" action="${pageContext.request.contextPath}/addPet">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Chip code:</td>
                <td><input type="text" name="chipCode"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td>Species:</td>
                <td><input type="text" name="species"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit" name="action" value="save">Save</button>
                    <button type="submit" name="action" value="back">Back</button>
                </td>
            </tr>
        </table>
    </form>
</t:page>
