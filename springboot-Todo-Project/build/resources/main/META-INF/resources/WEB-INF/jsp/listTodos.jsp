<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class ="container">
    <h1>Your Todos </h1>
    <table class="table">
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items = "${todos}" var = "mylist">
            <tr>
                <td>${mylist.description}</td>
                <td>${mylist.targetDate}</td>
                <td>${mylist.done}</td>
                <td><a href="delete-todo?id=${mylist.id}" class="btn btn-warning">Delete</td>
                <td><a href="update-todo?id=${mylist.id}" class="btn btn-success">Update</td>
            <tr>
        </c:forEach>
    </table>
    <a href="add-todo" class="btn btn-success"> Add Todo </a>
</div>
<%@ include file="common/footer.jspf" %>