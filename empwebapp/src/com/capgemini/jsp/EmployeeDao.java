package com.capgemini.jsp;
import java.util.*;  
import java.sql.*;

public class EmployeeDao {
	  
	  
	 
	  
	    public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/employee_db","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(Employee e){  
	        int status=0;  
	        try{  
	            Connection con=EmployeeDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into employee_info(id,name,email,password,salary,designation) values (?,?,?,?,?,?)");  
	            ps.setInt(1,e.getId());
	            ps.setString(2,e.getName());
	            ps.setString(3,e.getEmail());  
	            ps.setString(4,e.getPassword());  
	           ps.setInt(5,e.getSalary());
	            ps.setString(6,e.getDesignation());
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int update(Employee e){  
	        int status=0;  
	        try{  
	            Connection con=EmployeeDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update employee_info set name=?,password=?,email=?,salary=? where id=?");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getPassword());  
	            ps.setInt(3,e.getSalary());  
	           
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=EmployeeDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from employee_info where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static Employee getEmployeeById(int id){  
	        Employee e=new Employee();  
	          
	        try{  
	            Connection con=EmployeeDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from employee_info where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setEmail(rs.getString(3));
	                e.setPassword(rs.getString(4));  
	                  e.setSalary(rs.getInt(5));
	                e.setDesignation(rs.getString(6));
	               
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	    public static List<Employee> getAllEmployees(){  
	        List<Employee> list=new ArrayList<Employee>();  
	          
	        try{  
	            Connection con=EmployeeDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from employee_info");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Employee e=new Employee();  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setEmail(rs.getString(3));
	                e.setPassword(rs.getString(4));  
	                  e.setSalary(rs.getInt(5));
	                e.setDesignation(rs.getString(6));
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	}  


