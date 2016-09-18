package com.fh.test.thread;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * FIXME : Document this class<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/24/16 6:05 PM<br>
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class TestServlet extends HttpServlet
{
    private int count = 0;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.getWriter().println("<HTML><BODY>");
        response.getWriter().println(this + " ==> ");
        response.getWriter().println(Thread.currentThread() + ": <br>");
        for(int i=0;i<5;i++){
            response.getWriter().println("count = " + count + "<BR>");
            try {
                Thread.sleep(1000);
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.getWriter().println("</BODY></HTML>");
    }
}
