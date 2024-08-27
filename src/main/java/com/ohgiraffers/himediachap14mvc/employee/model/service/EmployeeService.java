package com.ohgiraffers.himediachap14mvc.employee.model.service;

import com.ohgiraffers.himediachap14mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.himediachap14mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.himediachap14mvc.common.jdbc.JDBCTemplate.getConnection;

import static com.ohgiraffers.himediachap14mvc.common.jdbc.JDBCTemplate.close;
import static com.ohgiraffers.himediachap14mvc.common.jdbc.JDBCTemplate.getConnection;

public class EmployeeService {

<<<<<<< HEAD
    private final EmployeeDAO employeeDAO;


    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
    }

    public EmployeeDTO selectOneEmplyeeID(String empId) {
        return null;
    }

    public List<EmployeeDTO> selectAllEmp() {
        Connection connection = getConnection();

        List<EmployeeDTO> employeeDTOList = employeeDAO.selectAllEmlList(connection);

        return employeeDTOList;
    }

    public EmployeeDTO selectOneEmployeeID(String empId) {
        return null;

=======
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
>>>>>>> 904815f2549a0ef0245ffe7e8dfd39ac7ef0866b
    }
}
