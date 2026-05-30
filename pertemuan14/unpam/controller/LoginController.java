package com.unpam.controller;

import com.unpam.model.Enkripsi;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String userParam = request.getParameter("username");
        String passParam = request.getParameter("password");
        
        try (PrintWriter out = response.getWriter()) {
            String passwordTerenskripsi = Enkripsi.getMD5(passParam);
            String passwordValidMD5 = Enkripsi.getMD5("admin123"); // Password asli: admin123
            
            if ("admin".equals(userParam) && passwordValidMD5.equals(passwordTerenskripsi)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", userParam);
                response.sendRedirect("index.jsp");
            } else {
                out.println("<script>alert('Username atau Password Salah!');window.history.back();</script>");
            }
        }
    }
}