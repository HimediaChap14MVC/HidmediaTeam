package com.ohgiraffers.himediachap14mvc.employee.model.dao;

import com.ohgiraffers.himediachap14mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
}
