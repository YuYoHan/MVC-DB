package com.example.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        // req = org.apache.catalina.connector.RequestFacade@58abdb91
        System.out.println("req = " + request);
        // resp = org.apache.catalina.connector.ResponseFacade@566c2ef4
        System.out.println("resp = " + response);

        // 쿼리 파라미터 조회
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // HTTP body에 담김
        response.getWriter().write("hello " + username);
    }
}
