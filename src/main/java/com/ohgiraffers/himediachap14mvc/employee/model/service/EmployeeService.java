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
        /* Connection 생성 */
        Connection con = getConnection();

        /* Connection과 함께 정보를 전달하여 조회한다. */
        EmployeeDTO selectedEmp = employeeDAO.selectOneEmployeeID(con, empId);

        /* connection 닫기 */
        close(con);

        /* 조회 결과를 반환한다. */
        return selectedEmp;
    }


    public String selectNewEmpId() {

        /* Connection 생성 */
        Connection con = getConnection();

        /* 비지니스 로직 */
        /* 1. dao 호출하여 조회 */
        String newEmpId = employeeDAO.selectNewEmpId(con);

        /* Connection 닫기 */
        close(con);

        /* 수행 결과 반환 */
        return newEmpId;
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

    public int insertEmp(EmployeeDTO emp) {

        Connection con = getConnection();

        int result = employeeDAO.insertEmp(con, emp);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }


    public int deleteEmp(String empId) {

        Connection con = getConnection();

        int result = employeeDAO.deleteEmp(con, empId);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }
}
