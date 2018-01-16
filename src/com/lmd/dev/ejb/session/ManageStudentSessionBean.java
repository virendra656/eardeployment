package com.lmd.dev.ejb.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lmd.dev.ejb.domain.Student;

/**
 * Session Bean implementation class ManageStudentSessionBean
 * 
 * @author Sameera Jayasekara
 */
@Stateless
public class ManageStudentSessionBean implements ManageStudentSessionBeanLocal {

 @PersistenceContext
 private EntityManager entityManager;

 public boolean addStudent(Student student) {
	 System.out.println("Trying .............");
  entityManager.persist(student);
  return true;
 }

}


