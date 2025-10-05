package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.User;
import DAO.UserDB;

@WebServlet("/emailList")
public class EmailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/new.jsp"; // Mặc định là trang đăng ký

        // Lấy action từ request
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // Action mặc định
        }

        if (action.equals("join")) {
            url = "/new.jsp";    // Trang "join"
        } 
        else if (action.equals("add")) {
            // Lấy các tham số
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // Tạo đối tượng User
            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            
            request.setAttribute("user", user);

            String message;
            if (UserDB.emailExists(user.getEmail())) {
                message = "This email address already exists. Please enter another email address.";
                url = "/new.jsp"; // Quay lại trang đăng ký nếu email trùng
            } else {
                message = "";
                UserDB.insert(user);
                url = "/thanks.jsp"; // Chuyển đến trang cảm ơn khi thành công
            }
            request.setAttribute("message", message);
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
