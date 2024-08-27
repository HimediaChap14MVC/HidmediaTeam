<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SuccessPage</title>
</head>
<body>
    <script>
        (function () {
            const successCode = '${ requestScope.successCode }';

            let successMessage = "";
            let movePath = "";
            let absolutePath = pageContext.servletContext.contextPath;

            switch (successCode) {
                case "DeleteEmp" :
                    successMessage = "신규 직원 삭제 성공."
                    movePath = absolutePath + "/employee/controller/DeleteEmpServlet.java";
                    break;
                case "InsertEmp" :
                    successMessage = "신규 직원 등록 성공."
                    movePath = absolutePath + "/employee/controller/InsertEmpServlet.java";
                    break;
                case "UpdateEmp" :
                    successMessage = "신규 직원 수정 성공."
                    movePath = absolutePath + "/employee/controller/UpdateEmpServlet.java";
                    break;
            }

            alert(successMessage);
            location.href = movePath;
        })
    </script>
</body>
</html>
