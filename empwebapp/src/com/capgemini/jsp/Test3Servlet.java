package com.capgemini.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("Test3Servlet")
public class Test3Servlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        String email=request.getParameter("email");  
	        String sal=request.getParameter("salary");
	        int salary=Integer.parseInt(sal);
	        String designation=request.getParameter("designation");  
	          
	        Employee e=new Employee();  
	        e.setId(id);  
	        e.setName(name);  
	        e.setPassword(password);  
	        e.setEmail(email);  
	        e.setSalary(salary);  
	        e.setDesignation(designation);
	          
	        int status=EmployeeDao.update(e);  
	        if(status>0){  
	            response.sendRedirect("TestServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	    }  
	  
	}  
	


