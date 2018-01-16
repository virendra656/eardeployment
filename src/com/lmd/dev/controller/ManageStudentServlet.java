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

import com.lmd.dev.ejb.domain.Student;
import com.lmd.dev.ejb.session.ManageStudentSessionBeanLocal;

/**
 * 
 * @author Sameera Jayasekara
 * 
 */
public class ManageStudentServlet extends HttpServlet {

 private static final long serialVersionUID = 1L;
 
 private ManageStudentSessionBeanLocal manageStudentSessionBeanLocal = null;

 public void init(ServletConfig config) throws ServletException {

  super.init(config);
  try {

   Context context = new InitialContext();
   manageStudentSessionBeanLocal = (ManageStudentSessionBeanLocal) context
		     .lookup("ManageStudentSessionBean/local");
  } catch (NamingException e) {
	  manageStudentSessionBeanLocal = null;
   System.out.print(e.getMessage());
  }

 }

 protected void doGet(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {

 }

 protected void doPost(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {

  String message = "";

  String firstName = request.getParameter("fname");
  String lastName = request.getParameter("lname");
  String email = request.getParameter("email");

  Student student = new Student();
  student.setFirstName(firstName);
  student.setLastName(lastName);
  student.setEmail(email);

  if (manageStudentSessionBeanLocal != null && manageStudentSessionBeanLocal.addStudent(student)) {
	  message = "Student Successfuly Added";
  } else {
	  message = "Student Adding Failed";
  }

  request.setAttribute("message", message);
  RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
  rd.forward(request, response);

 }

}
