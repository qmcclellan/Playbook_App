package dev.football.playbook.DataConfig;

import dev.football.playbook.Entity.Users;
import dev.football.playbook.Service.implementation.UsersServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UsersServiceImpl usersService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        System.out.println("\n\nIn customAuthenticationSuccessHandler\n\n");

        String userName = authentication.getName();

        System.out.println("userName=" + userName);

        Users theUser = usersService.findByUserName(userName);

        // now place in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", theUser);

        String page = "";

//        if (theUser.getRole().equals("ROLE_ADMIN")) {
//            // forward to home page
//            if (usersService.findAdminByUsersId(theUser.getId()) != null) {
//
//                page = "/Admin/GetAdmin";
//
//                response.sendRedirect(request.getContextPath() + page);
//
//            }
//
//            page = "/Admin/NewAdmin";
//
//        } else if (theUser.getRole().equals("ROLE_AUTHOR")) {
//
//            if (usersService.findAuthorByUsersId(theUser.getId()) != null) {
//                page = "/Author/Home";
//
//
//                response.sendRedirect(request.getContextPath() + page);
//
//
//            } else if (theUser.getRole().equals("ROLE_SUBSCRIBER")) {
//
//                if (usersService.findSubscriberByUsersId(theUser.getId()) != null) {
//                    page = "/Subscriber/Home";
//
//
//                    response.sendRedirect(request.getContextPath() + page);
//
//
//                }
//
//                page = "/Subscriber/NewCustomer";
//
//
//            } else {
//                response.sendRedirect(request.getContextPath() + page);
//            }
//
//        }
//    }
    }
}
