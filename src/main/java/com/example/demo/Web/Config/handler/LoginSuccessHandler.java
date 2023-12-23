package com.example.demo.Web.Config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {





    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

//        List<String> roleList = new ArrayList<>();
//        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        for (final GrantedAuthority grantedAuthority : authorities) {
//            String authorityName = grantedAuthority.getAuthority();
//            roleList.add(authorityName);
        //}
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        String name = userDetails.getUsername();
//        Integer id = userService.findByName(name).getId();
//        String forUrl = id.toString();
        Set<String> roleSet = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if(roleSet.contains("admin")) {
            httpServletResponse.sendRedirect("/admin");
        } else {
            httpServletResponse.sendRedirect("/user");
        }
    }
}