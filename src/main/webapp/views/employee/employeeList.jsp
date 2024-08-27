<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>employeeList Title</title>
</head>
<body>
    <h1>직원 전체 조회</h1>
    <table>
        <tr>
            <th>사원ID</th>
            <th>사원Name</th>
            <th>사원No</th>
            <th>사원Email</th>
            <th>사원Phone</th>
            <th>사원DEPT_Code</th>
            <th>사원JOB_Code</th>
            <th>사원Sal_Level</th>
            <th>사원Salary</th>
            <th>사원Bonus</th>
            <th>사원ManagerID</th>
            <th>사원EntDate</th>
        </tr>
        <c:forEach var="emp" items="${ requestScope.empList }" varStatus="empList">
            <li>
            </li>
        </c:forEach>
    </table>
</body>
</html>
