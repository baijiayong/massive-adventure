package com.bodejidi.hellojdbc;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class MemberServlet extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse resp)
  
              throws ServletException,java.io.IOException
	          {
                resp.getWriter().println("This is a simple servlet program");
	          }
  

  public void doPost(HttpServletRequest req,HttpServletResponse resp)
              throws ServletException,java.io.IOException
              {
                resp.getWriter().println(req.getParameter("first_name")
                                         + " "
                                         + req.getParameter("last_name"));
              }
  
}



