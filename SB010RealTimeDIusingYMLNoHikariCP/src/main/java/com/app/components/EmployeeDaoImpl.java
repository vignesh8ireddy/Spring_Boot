package com.app.components;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dto.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDAO {

	private static final String SQL_SELECT_QUERY = "SELECT ename,eage,eaddress FROM employee001";
	
	@Autowired
	private DataSource dataSource;

	@Override
	public List<Employee> findAllEmployees() throws Exception {
		System.out.println("DataSource Connection is :: " + dataSource.getClass().getName());

		List<Employee> empList = new ArrayList<Employee>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
				ResultSet resultSet = pstmt.executeQuery()) {

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEname(resultSet.getString(1));
				employee.setEage(resultSet.getInt(2));
				employee.setEaddress(resultSet.getString(3));

				empList.add(employee);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return empList;
	}
}
