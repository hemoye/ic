package com.jsu.ic.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 木木
 *
 */
public class EncodingFilter implements Filter {

	private String charset = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.charset = filterConfig.getInitParameter("charset");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;  
        if ("GET".equals(httprequest.getMethod())) {
        	//将httpRequest进行包装  
            EncodingHttpServletRequest wrapper = new EncodingHttpServletRequest(httprequest, charset);   
            chain.doFilter(wrapper, response);
        }
        else {
        	request.setCharacterEncoding(charset);  
            response.setContentType("text/html;charset=" + charset);  
            chain.doFilter(request, response);
        }
	}

	@Override
	public void destroy() {
		this.charset = null;
	}

}
