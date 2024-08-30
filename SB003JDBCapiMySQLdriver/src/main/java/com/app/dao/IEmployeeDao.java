package com.app.dao;

import java.util.List;

import com.app.bo.EmployeeBO;

public interface IEmployeeDao {
	
	String save(EmployeeBO bo);

	List<EmployeeBO> findAllEmployees();

	EmployeeBO findById(Integer eid);

	String updateById(Integer eid);

	String deleteById(Integer eid);

}
