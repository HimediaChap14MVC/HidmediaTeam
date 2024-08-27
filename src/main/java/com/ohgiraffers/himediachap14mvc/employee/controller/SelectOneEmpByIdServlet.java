package com.ohgiraffers.himediachap14mvc.employee.controller;

import com.ohgiraffers.himediachap14mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.himediachap14mvc.employee.model.service.EmployeeService;
import jakarta.servlet.RequestDispatcher;
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

        System.out.println("empId = " + empId);

        /*empID로 조회하기 비즈니스로직 작성*/
        /*1. 서비스 객체 생성*/
        EmployeeService employeeService = new EmployeeService();
        /*DTO타입으로 변수명 생성 후  서비스 영역에 메소드 추가하기*/
        EmployeeDTO selectOneId = employeeService.selectOneEmplyeeID(empId);

        System.out.println("selectOneId = " + selectOneId);
        /*뷰로 전송하기*/
        /*1. 조건문으로 빈칸인지 아닌지 확인하여 일어나는 현상에 대한 응답 파일 경로를 설정*/
        String path = "";
        if(selectOneId != null) {
            /*성공시*/
            path = "webapp/views/employee/showEmpInfo.jsp";
            req.setAttribute("selectOneId",selectOneId);
        } else {
            /*실패시*/
            path = "webapp/views/common/errorPage.jsp";
            req.setAttribute("message","직원 정보 조회가 실패 하였습니다.");
        }

        /*다른 서블릿 또는 JSP로 보내기 위한 구문 작성*/
         RequestDispatcher requestDispatcher= req.getRequestDispatcher(path);
         requestDispatcher.forward(req,resp);
    }
}
