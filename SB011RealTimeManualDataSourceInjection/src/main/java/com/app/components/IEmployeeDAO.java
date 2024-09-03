package com.app.components;

import java.util.List;

import com.app.dto.Employee;

public interface IEmployeeDAO {
	public List<Employee> findAllEmployees() throws Exception;
}
