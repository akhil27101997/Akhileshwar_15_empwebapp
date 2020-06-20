package com.capgemini.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("TestServlet")
public class TestServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	         int id=Integer.parseInt(request.getParameter("id")); 
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        String email=request.getParameter("email");  
	        int salary=Integer.parseInt(request.getParameter("salary"));
	        String designation=request.getParameter("designation");
	        
	          
	        Employee e=new Employee();
	        e.setId(id);
	        e.setName(name);  
	        e.setPassword(password);  
	        e.setEmail(email);  
	        e.setSalary( salary);  
	        e.setDesignation(designation);
	          
	        int status=EmployeeDao.save(e);  
	        if(status>0){  
	            out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("index.html").include(request, response);;  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
	    }  

}
