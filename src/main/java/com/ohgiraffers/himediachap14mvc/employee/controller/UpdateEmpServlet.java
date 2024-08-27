package com.ohgiraffers.himediachap14mvc.employee.controller;

import com.ohgiraffers.himediachap14mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.himediachap14mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String empId = req.getParameter("empId");
        java.sql.Date entDate = java.sql.Date.valueOf(req.getParameter("empId"));

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(empId);
        emp.setEntDate(entDate);

        int result = new EmployeeService().updateEmp(emp);

        String path = "";
        if(result > 0) {
            path = "webapp/views/common/successPage.jsp";
            req.setAttribute("success", "updateEmp");
        } else {
            path = "webapp/views/common/errorPage.jsp";
            req.setAttribute("error", "퇴사여부수정실패");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
