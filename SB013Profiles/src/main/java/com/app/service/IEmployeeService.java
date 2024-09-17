package com.app.service;

import java.util.List;

import com.app.dto.EmployeeDTO;

public interface IEmployeeService {
	public List<EmployeeDTO>  fetchEmpsByDesgs(String desgs[])throws Exception;
}
