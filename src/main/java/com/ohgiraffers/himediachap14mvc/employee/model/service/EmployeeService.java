package com.ohgiraffers.himediachap14mvc.employee.model.service;

import com.ohgiraffers.himediachap14mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.himediachap14mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.himediachap14mvc.common.jdbc.JDBCTemplate.*;

public class EmployeeService {

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

    }

    public String selectNewEmpId() {

        return null;
    }


    public int updateEmp(EmployeeDTO emp) {
        Connection con = getConnection();
        int result = employeeDAO.updateEmp(con, emp);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return result;
    }
}
