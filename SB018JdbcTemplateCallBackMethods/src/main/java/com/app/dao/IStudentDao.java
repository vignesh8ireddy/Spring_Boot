package com.app.dao;

import com.app.bo.StudentBO;

import java.util.List;


public interface IStudentDao {
	public StudentBO getStudentByNo(int sno);
	public List<StudentBO> getStudentByName(String name1,String name2);
}
