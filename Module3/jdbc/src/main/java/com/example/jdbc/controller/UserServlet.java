package com.example.jdbc.controller;

import com.example.jdbc.model.User;
import com.example.jdbc.service.IUserService;
import com.example.jdbc.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = {"/user",""})
public class UserServlet extends HttpServlet {
    IUserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set lại font
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreatePage(request,response);
                break;
            case "detail":
//                detailProduct(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                removeUser(request,response);
                break;
            case "ascName":
                showAsc(request,response);
                break;
            case "descName":
                showDesc(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void showDesc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list =service.descendingName();
        request.setAttribute("userList",list);
        request.getRequestDispatcher("user/userList.jsp").forward(request,response);
    }

    private void showAsc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list =service.ascendingName();
        request.setAttribute("userList",list);
        request.getRequestDispatcher("user/userList.jsp").forward(request,response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        User user=service.findById(id);

        request.setAttribute("user",user);
        request.getRequestDispatcher("user/edit.jsp").forward(request,response);
    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("user/create.jsp");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userList",service.findAll());
        request.getRequestDispatcher("user/userList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set lại font
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                createUser(request,response);
                break;
            case "edit":
                editUser(request,response);
                break;
            case "findByCountry":
                findByCountry(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void findByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("str");
        List<User> list = service.findByCountry(country);
        request.setAttribute("userList", list);
        request.getRequestDispatcher("user/userList.jsp").forward(request,response);
    }

    private void removeUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        service.remove(id);
        response.sendRedirect("/user");
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        User user=new User(id,name,email,country);
        service.edit(user);
       response.sendRedirect("user");

    }
    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        User user=new User(name,email,country);
        service.save(user);
        response.sendRedirect("/user");
    }
}
