<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag dynamic-attributes="params" language="java" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>${params.get("Welcome")}</title>
        <style>
            .pet-list-table td {
                border:1px solid black;
            }
        </style>
    </head>

    <body>
        <div>
            <h1>Welcome here!</h1>
            <h3>Menu</h3>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/addPet">Add new pet</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/petList">Pet list</a>
        </div>
        
        <div>
            <jsp:doBody/>
        </div>
    </body>

</html>