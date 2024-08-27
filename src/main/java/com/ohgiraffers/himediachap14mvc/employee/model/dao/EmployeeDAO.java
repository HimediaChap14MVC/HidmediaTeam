package com.ohgiraffers.himediachap14mvc.employee.model.dao;

import com.ohgiraffers.himediachap14mvc.employee.model.dto.EmployeeDTO;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class EmployeeDAO {

    private Properties prop = new Properties();

    public List<EmployeeDTO> selectAllEmlList(Connection connection) {

        Statement pstmt = null;
        ResultSet rset = null;

        List<EmployeeDTO> employeeDTOList = null;

        String query = prop.getProperty("selectAllEmpList");


        return null;

    }


    public EmployeeDTO selectOneEmployeeID(Connection connection, String empId) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        EmployeeDTO selectedEmpId = null;

        String query = prop.getProperty("selectEmpById");

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, empId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                selectedEmpId = new EmployeeDTO();

                selectedEmpId.setEmpId(resultSet.getString("EMP_ID"));
                selectedEmpId.setEmpName(resultSet.getString("EMP_NAME"));
                selectedEmpId.setDeptCode(resultSet.getString("DEPT_CODE"));
                selectedEmpId.setJobCode(resultSet.getString("JOB_CODE"));
                selectedEmpId.setSalary(resultSet.getInt("SALARY"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


}
