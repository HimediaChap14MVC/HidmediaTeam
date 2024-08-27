package com.ohgiraffers.himediachap14mvc.employee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/select")
public class SelectOneEmpByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*전달된 파라미터 추출*/
        String empId = req.getParameter("empId");
        /*empID로 조회하기 비즈니스로직 작성*/
        /*뷰로 전송하기*/
    }
}
