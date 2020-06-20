package com.capgemini.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("Test5Servlet")
public class Test5Servlet {
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)   
              throws ServletException, IOException {  
       response.setContentType("text/html");  
       PrintWriter out=response.getWriter();  
       out.println("<a href='index.html'>Add New Employee</a>");  
       out.println("<h1>Employees List</h1>");  
         
       List<Employee> list=EmployeeDao.getAllEmployees();  
         
       out.print("<table border='1' width='100%'");  
       out.print("<table><tr><th>Id</th> <th>Name</th> <th>Password</th><th>Email</th><th>salary</th><th>designation</th></tr></table  ");   
       
      
    
       for(Employee e:list){  
        out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+ 
                "<td>"+e.getSalary()+"</td>+ <td>"+e.getDesignation()+" </td></td>"+e.getId()+"</td><td><a href='EditServlet?id="+e.getId() 
                );  
       }  
       out.print("</table>");  
         
       out.close();  
   }  

}
