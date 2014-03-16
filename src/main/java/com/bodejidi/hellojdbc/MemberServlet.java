package com.bodejidi.hellojdbc;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class MemberServlet extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse resp)
  
              throws ServletException,java.io.IOException
	          {
                resp.setContentType("text/html;charset=UTF-8");
                try
                {
                  Class.forName("com.mysql.jdbc.Driver").newInstance();
                } catch(Exception ex)
                {
                
                } 
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                try
                {
                  conn = DriverManager.getConnection("jdbc:mysql://localhost/test?"
                                                     + "user=root"
                                                     + "&password=");
                  stmt = conn.createStatement();
                  String sql = "SELECT * from member";
                  System.out.println("SQL:" + sql);
                  rs = stmt.executeQuery(sql);
                  while(rs.next())
                  {
                    long id = rs.getLong("id");
                    String firstName =  rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    resp.getWriter().println(id + " : " + firstName + " " + lastName + "\n");
                  }
                    resp.getWriter().println("<br/><a href=\".\">Back</a>");
                }catch (SQLException ex)
                {
                  System.out.println("SQLException: " + ex.getMessage());
                  System.out.println("SQLState: " + ex.getSQLState());
                  System.out.println("VendorError: " + ex.getErrorCode());
                  resp.getWriter().println("Error!");
                } finally 
                {
                  if (rs != null)
                  {
                    try
                    {
                      rs.close();
                    } catch(SQLException sqlEx)
                    {
                    
                    }
                    rs = null;
                  }
                  if (conn != null)
                  {
                    try 
                    {
                      conn.close();
                    } catch (SQLException sqlEx)
                    {
                    
                    }
                    conn = null;
                  }
                  if (stmt != null)
                  {
                    try
                    {
                      stmt.close();
                    } catch (SQLException sqlEx)
                    {
                       
                    }
                    stmt = null;
                  }
                }
	          }
  

  public void doPost(HttpServletRequest req,HttpServletResponse resp)
              throws ServletException,java.io.IOException
              {
                resp.setContentType("text/html;charset=UTF-8");
                String firstName = req.getParameter("first_name");
                String lastName = req.getParameter("last_name");
                
                try
                {
                  Class.forName("com.mysql.jdbc.Driver").newInstance();                
                } catch (Exception ex)
                {
                
                }
                Connection conn = null;
                Statement stmt = null;
                 
                try 
                {
                  conn = DriverManager.getConnection("jdbc:mysql://localhost/test?"
                                                       + "user=root"
                                                       + "&password=");
                  stmt = conn.createStatement();
                  String sql = "INSERT INTO member(first_name,last_name,created_date,updated_time)" 
                               + "VALUES('" + firstName + "','" + lastName + "',now(),now());";
                  System.out.println("SQL: " + sql); 
                  stmt.execute(sql);
                  resp.getWriter().println("Add " + firstName + " " + lastName + " success!");  
                  resp.getWriter().println(" <br/><a href=\"\"> Member List </a>");                  
                } catch(SQLException ex) 
                {
                  System.out.println("SQLException: " + ex.getMessage());
                  System.out.println("SQLState: " + ex.getSQLState());
                  System.out.println("VendorError: " + ex.getErrorCode());
                  resp.getWriter().println("Error!");
                }finally 
                {
                  if (stmt != null)
                  {
                    try
                    {
                      stmt.close();
                    } catch (SQLException sqlEx)
                    {
                    
                    }
                    stmt = null;
                  }
                  if (conn != null)
                  {
                    try
                    {
                      conn.close();
                    } catch (SQLException sqlEx)
                    {
                      
                    }
                    conn = null;
                  }
                }
              }
  
}



