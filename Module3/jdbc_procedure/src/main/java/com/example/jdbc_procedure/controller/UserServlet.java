package com.example.jdbc_procedure.controller;

import com.example.jdbc_procedure.model.User;
import com.example.jdbc_procedure.service.IUserService;
import com.example.jdbc_procedure.service.UserServiceImpl;
import com.sun.org.apache.bcel.internal.generic.SWITCH;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = {"/user",""})
public class UserServlet extends HttpServlet {
    IUserService service=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set lại font
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action= request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action) {
            case "create":
                showCreate(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                removeUser(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void removeUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        service.remove(id);
        response.sendRedirect("/user");
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("user/create.jsp");
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        User user=service.findById(id);

        request.setAttribute("user",user);
        request.getRequestDispatcher("user/edit.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("list",service.findAll());
            request.getRequestDispatcher("user/userList.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set lại font
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action= request.getParameter("action");
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
            default:


        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        User user=new User(name,email,country);
        service.save(user);
        response.sendRedirect("/user");
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        User user=new User(id,name,email,country);
        service.edit(user);
        response.sendRedirect("/user");
    }
}
