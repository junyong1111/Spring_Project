<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href ="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>List Todos Page</title>
    </head>
    <body>
        <div class ="container">
            <h1>Your Todos </h1>
            <table class="table">
                <tr>
                    <th>Id</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done?</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items = "${todos}" var = "mylist">
                <tr>
                    <td>${mylist.id}</td>
                    <td>${mylist.description}</td>
                    <td>${mylist.targetDate}</td>
                    <td>${mylist.done}</td>
                    <td><a href="delete-todo?id=${mylist.id}" class="btn btn-warning">Delete${mylist.id}</td>
                    <td><a href="update-todo?id=${mylist.id}" class="btn btn-success">Update${mylist.id}</td>
                <tr>
                </c:forEach>
            </table>
            <a href="add-todo" class="btn btn-success"> Add Todo </a>
        <div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    </body>
</html>