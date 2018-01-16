package com.lmd.dev.ejb.session;  
  
import javax.ejb.Local;  
  
import com.lmd.dev.ejb.domain.Student;  
  
/** 
 *  
 * @author Sameera Jayasekara 
 *  
 */  
@Local  
public interface ManageStudentSessionBeanLocal {  
 public boolean addStudent(Student Student);  
} 