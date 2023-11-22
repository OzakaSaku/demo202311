package com.example.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.AntPathMatcher;

import com.alibaba.fastjson.JSON;
import com.example.common.R;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
	
    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	System.out.println("init 初始化方法执行了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    	System.out.println("LoginCheckFilter 放行前逻辑.....");
    	
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1、获取本次请求的URI
        String requestURL = request.getRequestURI().toString();
        //定义不需要处理的请求路径  比如静态资源(静态页面我们不需要拦截,因为此时的静态页面是没有数据的)
        String[] urls = new String[]{
                "/login",
                "/logout",
                "/api"
        };

        //做调试用的
        log.info("请求路径：{}", requestURL);
        log.info("userId:{}", request.getSession().getAttribute("userId"));

        //2、判断本次请求是否需要处理
        boolean check = check(urls, requestURL);
        //3、如果不需要处理，则直接放行
        if(check){
            log.info("本次请求{}不需要处理",requestURL);
            filterChain.doFilter(request,response);
            return;
        }
        
        if (requestURL.contains("login.html") && request.getSession().getAttribute("userId") != null) {
        	response.sendRedirect(request.getContextPath() + "/stock.html");
        	return;
		}
        
        //4-1、判断登录状态，如果已登录，则直接放行
        if(request.getSession().getAttribute("userId") != null){
            log.info("用户已登录，用户id为：{}",request.getSession().getAttribute("userId"));
            filterChain.doFilter(request,response);
            return;
        }

        //log.info("用户未登录");
        //5、如果未登录则返回未登录结果，通过输出流方式向客户端页面响应数据,具体响应什么数据，看前端的需求，然后前端会根据登陆状态做页面跳转
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        response.sendRedirect(request.getContextPath() + "/login.html");
        return;
    }
    
    @Override //销毁方法, 只调用一次
    public void destroy() {
        System.out.println("destroy 销毁方法执行了");
    }


    public boolean check(String[] urls,String requestURI) {
        for (String url : urls) {
            if (requestURI.contains(url)) {
                return true;
            }
        }
        return false;
    }

}
