package com.example.servlet.basic.request;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*   1. 파라미터 전송 기능
*   http://localhost:8080/requst-param?userName=hello&age=20
*
* */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
@Slf4j
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                // paramName : userName
                // request.getParameter(paramName) : hello → userName에 담겨져있는 값
                .forEachRemaining(paramName -> log.info(paramName + "=" + request.getParameter(paramName)));
        log.info("[전체 파라미터 조회] - end");

        String userName = request.getParameter("userName");
        String age = request.getParameter("age");

        log.info("userName = " + userName);
        log.info("age = " + age);

        log.info("[이름이 같은 복수 파라미터 조회]");
        String[] userNames = request.getParameterValues("userName");
        for (String name: userNames
             ) {
            log.info("userName = " + name);
        }

        response.getWriter().write("ok");
    }
}
