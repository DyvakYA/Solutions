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

/**
 * Created by User on 7/16/2017.
 */
public class UserBanFilter extends BaseFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        if (isBaned(request, response)) {
            chain.doFilter(request, response);
        }
    }

    private boolean isBaned(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute(USER_SESSION_ATTRIBUTE);
        if (user != null && user.getRole() == Role.ROLE_BLOCKED) {
            accessDenied(request, response, ACCESS_DENIED);
            return false;
        }
        return true;
    }
}
