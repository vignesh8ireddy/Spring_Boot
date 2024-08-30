package com.app.controller;

import java.util.List;

import com.app.vo.EmployeeVO;

public interface IEmployeeController {

	String save(EmployeeVO vo);

	List<EmployeeVO> findAllEmployees();

	EmployeeVO findById(Integer eid);

	String updateById(Integer eid);

	String deleteById(Integer eid);

}
