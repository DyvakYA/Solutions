package com.dy.controller.filters;

import com.dy.model.entities.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.dy.model.constants.AttributesHolder.USER_SESSION_ATTRIBUTE;
import static com.dy.model.constants.MsgHolder.USER_NOT_AUTHORIZED;

/**
 * Created by User on 7/16/2017.
 */
public class UserAuthorizationFilter extends BaseFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (isAuthorize(request, response)) {
            chain.doFilter(request, response);
        }
    }

    private boolean isAuthorize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute(USER_SESSION_ATTRIBUTE);
        if (user == null) {
            accessDenied(request, response, USER_NOT_AUTHORIZED);
            return false;
        }
        return true;
    }
}
