package com.app.dao;

import java.util.List;

import com.app.bo.EmployeeBO;

public interface IEmployeeDao {
	public  List<EmployeeBO>  getEmpsByDesg(String cond)throws Exception;
}
