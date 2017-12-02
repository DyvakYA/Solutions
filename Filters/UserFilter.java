package com.dy.controller.filters;

import com.dy.model.entities.Role;
import com.dy.model.entities.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.dy.model.constants.AttributesHolder.USER_SESSION_ATTRIBUTE;
import static com.dy.model.constants.MsgHolder.ACCESS_DENIED;
import static com.dy.model.constants.UrlHolder.ADMIN;
import static com.dy.model.constants.UrlHolder.USER;

public class UserFilter extends BaseFilter {

    /**
     * There is no need to implement the method
     */
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (isAuthorize(request, response)) {
            chain.doFilter(request, response);
        }
    }

    private boolean isAuthorize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute(USER_SESSION_ATTRIBUTE);
        String uri=request.getRequestURI();
        if(isAdmin(user, uri) || (isUser(user, uri))) {
            accessDenied(request, response, ACCESS_DENIED);
            return false;
        }
        return true;
    }

    private boolean isAdmin(User user, String uri){
        return (user.getRole().equals(Role.ROLE_ADMIN) && uri.startsWith(USER));
    }

    private boolean isUser(User user, String uri){
        return (!user.getRole().equals(Role.ROLE_USER) && uri.startsWith(ADMIN));
    }
}








