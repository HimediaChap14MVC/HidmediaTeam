package com.ohgiraffers.himediachap14mvc.employee.model.dao;

import com.ohgiraffers.himediachap14mvc.employee.controller.UpdateEmpServlet;
import com.ohgiraffers.himediachap14mvc.employee.model.dto.EmployeeDTO;

import java.sql.*;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.himediachap14mvc.common.jdbc.JDBCTemplate.close;

public class EmployeeDAO {

    private Properties prop = new Properties();

    public List<EmployeeDTO> selectAllEmlList(Connection connection) {

        Statement pstmt = null;
        ResultSet rset = null;

        List<EmployeeDTO> employeeDTOList = null;

        String query = prop.getProperty("selectAllEmpList");



        return null;

    }


    public EmployeeDTO selectOneId(Connection connection, String empId) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        EmployeeDTO selectedEmpId = null;

        String query = prop.getProperty("selectEmpById");

        preparedStatement = connection.prepareStatement()

        return  null;
    }

    public int updateEmp(Connection con, EmployeeDTO emp) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("updateEmp");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setDate(1, emp.getEntDate());
            pstmt.setString(2, emp.getEmpName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }

}
