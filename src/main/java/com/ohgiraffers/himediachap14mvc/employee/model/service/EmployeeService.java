package com.ohgiraffers.himediachap14mvc.employee.model.service;

import com.ohgiraffers.himediachap14mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.himediachap14mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;

import static com.ohgiraffers.himediachap14mvc.common.jdbc.JDBCTemplate.close;
import static com.ohgiraffers.himediachap14mvc.common.jdbc.JDBCTemplate.getConnection;

public class EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public EmployeeDTO selectOneEmployeeID(String empId) {

        /*커넥션 생성*/
        Connection connection = getConnection();
        /*정보전달 및 조회*/
        EmployeeDTO selectedEmpId = employeeDAO.selectOneId(connection, empId);
        /*커넥션 닫기*/
        close(connection);
        /*결과 반환*/
        return selectedEmpId;
    }
}
