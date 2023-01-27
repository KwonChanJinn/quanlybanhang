package com.vti.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class ConfigSecurityFilter extends OncePerRequestFilter {
    @Qualifier("userService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("Authorization");

        Claims claims;
        if (token == null || !token.startsWith("Bearer ")) {
            claims = null;
        } else {
            token = token.replace("Bearer ", "");

            try {
                claims = Jwts.parser().setSigningKey("supersecret").parseClaimsJws(token).getBody();
            } catch (Exception ex) {
                claims = null;
            }
        }

        if (claims == null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // Kiểm tra hạn token
        Date expiration = claims.getExpiration();
        if (expiration.before(new Date())) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // Tạo object Authentication
        String username = claims.getSubject();
        if (username != null) {
            UserDetails user = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authenticationObject = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            // Xác thực thành công, lưu object Authentication vào SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authenticationObject);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }

    }

}
