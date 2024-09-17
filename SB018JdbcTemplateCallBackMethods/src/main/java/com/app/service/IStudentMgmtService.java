package com.app.service;

import com.app.dto.StudentDTO;

import java.util.List;

public interface IStudentMgmtService {
	public StudentDTO fetchStudentByNo(int no);
	public List<StudentDTO> fetchStudentByName(String name1,String name2);
}
