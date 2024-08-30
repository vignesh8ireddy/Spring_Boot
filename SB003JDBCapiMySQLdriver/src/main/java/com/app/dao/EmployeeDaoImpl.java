package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.bo.EmployeeBO;

@Repository("dao")
public class EmployeeDaoImpl implements IEmployeeDao {

	static {
		System.out.println("EmployeeDaoImpl.class file loaded.");
	}
	public EmployeeDaoImpl() {
		System.out.println("EmployeeDaoImpl object is instantiated:: Zero param constructor");
	}

	private static final String SQL_INSERT_QUERY = "INSERT INTO employee001(`ename`,`eage`,`eaddress`) values(?,?,?)";
	private static final String SQL_SELECT_QUERY = "SELECT ename,eage,eaddress FROM employee001";
	
	@Autowired
	private DataSource dataSource;

	@Override
	public String save(EmployeeBO bo) {
		int rowcount = 0;
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT_QUERY)) {

			pstmt.setString(1, bo.getEname());
			pstmt.setInt(2, bo.getEage());
			pstmt.setString(3, bo.getEaddress());
			rowcount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowcount == 1 ? "Record inserted succesfully" : "Record insertion failed";
	}

	@Override
	public List<EmployeeBO> findAllEmployees() {
		
		ArrayList<EmployeeBO> empListBO = null;
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			 ResultSet resultSet = pstmt.executeQuery()) {

			empListBO = new ArrayList<EmployeeBO>();
			while (resultSet.next()) {

				EmployeeBO employeeBO = new EmployeeBO();

				employeeBO.setEname(resultSet.getString(1));
				employeeBO.setEage(resultSet.getInt(2));
				employeeBO.setEaddress(resultSet.getString(3));

				empListBO.add(employeeBO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empListBO;
	}

	@Override
	public EmployeeBO findById(Integer eid) {
		try (Connection connection = dataSource.getConnection()) {
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateById(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "EmployeeDaoImpl [dataSource=" + dataSource + "]";
	}

}
