package com.dy.controller.filters;

import com.dy.model.extras.Localization;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.dy.model.constants.AttributesHolder.RESULT_ATTRIBUTE;
import static com.dy.model.constants.UrlHolder.INDEX;

/**
 * Created by User on 7/15/2017.
 */
public abstract class BaseFilter implements Filter {

    private static final Logger logger=Logger.getLogger(BaseFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);

    }

    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // NOP
    }

    @Override
    public void destroy() {
        // NOP
    }

    protected void accessDenied(HttpServletRequest request, HttpServletResponse response, String message)
            throws ServletException, IOException {
        logger.info(message);
        request.setAttribute(RESULT_ATTRIBUTE,
                Localization.getInstance().getLocalizedMessage
                        (request, message));
        request.getRequestDispatcher(INDEX).forward(request, response);
    }
}
