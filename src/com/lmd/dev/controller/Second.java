package com.lmd.dev.controller;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lmd.dev.ejb.session.ManageStudentSessionBean;
import com.lmd.dev.ejb.session.ManageStudentSessionBeanLocal;
import com.lmd.dev.ejb.domain.Student;

/**
 * 
 * @author Sameera Jayasekara
 * 
 */
public class Second extends HttpServlet {

 private static final long serialVersionUID = 1L;
 private ManageStudentSessionBeanLocal manageStudentSessionBeanLocal;

 public void init(ServletConfig config) throws ServletException {
  super.init(config);
  try {
   Context context = new InitialContext();
   manageStudentSessionBeanLocal = (ManageStudentSessionBeanLocal) context
     .lookup("ManageStudentSessionBean/local");
  } catch (NamingException e) {
   e.printStackTrace();
  }

 }

 protected void doGet(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {

 }

 protected void doPost(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {

  String message = "Cool";  
  Student student = new Student();
  student.setEmail("sansa@gmail.com");
  student.setFirstName("Sansa");
  student.setLastName("Stark");
  
  if (manageStudentSessionBeanLocal.addStudent(student)) {  
   message = "Student Successfuly Added";  
  } else {  
   message = "Student Adding Failed";  
  }  
  request.setAttribute("message", message);
  RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
  rd.forward(request, response);
 }

}
