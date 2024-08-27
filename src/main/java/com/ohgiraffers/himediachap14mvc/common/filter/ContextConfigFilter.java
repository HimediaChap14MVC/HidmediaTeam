package com.ohgiraffers.himediachap14mvc.common.filter;

import com.ohgiraffers.himediachap14mvc.common.config.ConfigLocation;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


// 컴파일시에 먼저 실행되므로 경로가 설정된다.
@WebFilter("/*")
public class ContextConfigFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null) {
            String headRoot = request.getServletContext().getRealPath("/");
            String connectionInfoPath = request.getServletContext().getInitParameter("connection-info");

            ConfigLocation.CONNECTION_CONFIG_LOCATION = headRoot + "/" + connectionInfoPath;
        }

        if(ConfigLocation.MAPPER_LOCATION== null) {
            String headRoot = request.getServletContext().getRealPath("/");
            String connectionInfoPath = request.getServletContext().getInitParameter("mapper-location");

            ConfigLocation.CONNECTION_CONFIG_LOCATION = headRoot + "/" + connectionInfoPath;
        }

        chain.doFilter(request, response);
    }
}
