package com.bodejidi.hellojdbc;

imoprt java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class MemberServlet extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse resp)
              throws ServletException.java.io.IOException
  {
    resp.getWriter().println("This is a simple servlet program");
  }
}
