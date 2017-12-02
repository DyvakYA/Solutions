package com.dy.controller.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * This class represents character encoding filter.
 * It changes charset encoding of request and response to specified.
 *
 *  @author dyvakyurii@gmail.com
 */
public class CharacterEncodingFilter extends BaseFilter {
    private static final String ENCODING = "utf-8";
    private static final Logger logger = Logger.getLogger(CharacterEncodingFilter.class);

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            request.setCharacterEncoding(ENCODING);
            response.setCharacterEncoding(ENCODING);
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }
        chain.doFilter(request,response);
    }
}
