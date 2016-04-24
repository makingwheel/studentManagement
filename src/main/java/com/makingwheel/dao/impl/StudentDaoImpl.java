package com.makingwheel.dao.impl;

import org.springframework.stereotype.Repository;

import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.StudentDao;
import com.makingwheel.dao.entity.Student;

@Repository
public class StudentDaoImpl extends BasicDao<Student>implements StudentDao {

}
