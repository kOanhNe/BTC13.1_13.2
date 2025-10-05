package controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.User;
import DAO.UserDB;

@WebServlet("/userAdmin")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String url = "/index.jsp"; // Trang mặc định

        String action = request.getParameter("action");
        if (action == null) {
            action = "display_users";  // Action mặc định
        }

        if (action.equals("display_users")) {
            List<User> users = UserDB.selectUsers();
            request.setAttribute("users", users);
        } 
        else if (action.equals("display_user")) {
            String emailAddress = request.getParameter("email");
            User user = UserDB.selectUser(emailAddress);
            session.setAttribute("user", user);
            url = "/user.jsp";
        } 
        else if (action.equals("update_user")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            User user = (User) session.getAttribute("user");
            user.setFirstName(firstName);
            user.setLastName(lastName);
            UserDB.update(user);

            List<User> users = UserDB.selectUsers();
            request.setAttribute("users", users);
        } 
        else if (action.equals("delete_user")) {
            String email = request.getParameter("email");
            User user = UserDB.selectUser(email);

            // SỬA LỖI: Luôn kiểm tra user != null trước khi xóa
            if (user != null) {
                UserDB.delete(user);
            }

            List<User> users = UserDB.selectUsers();
            request.setAttribute("users", users);
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
