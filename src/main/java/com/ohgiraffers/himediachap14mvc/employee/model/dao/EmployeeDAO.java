package com.ohgiraffers.himediachap14mvc.employee.model.dao;

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


    public String selectNewEmpId(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String newEmpId = null;

        String query = prop.getProperty("selectNewEmpId");

        try {
            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                newEmpId = rset.getString("EMP_ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return newEmpId;
    }

    public int insertEmp(Connection con, EmployeeDTO emp) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertEmp");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, emp.getEmpId());
            pstmt.setString(2, emp.getEmpName());
            pstmt.setString(3, emp.getEmpNo());
            pstmt.setString(4, emp.getEmail());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getDeptCode());
            pstmt.setString(7, emp.getJobCode());
            pstmt.setString(8, emp.getSalLevel());
            pstmt.setInt(9, emp.getSalary());
            pstmt.setDouble(10, emp.getBonus());
            pstmt.setString(11, emp.getManagerId());
            pstmt.setDate(12, emp.getHireDate());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }
}
