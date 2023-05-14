package com.example.hokhau.controller;

import com.example.hokhau.model.HoKhau;
import com.example.hokhau.service.IService;
import com.example.hokhau.service.ServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "hoKhauServlet", value = {"/hoKhau",""})
public class HoKhauServlet extends HttpServlet {
    IService service=new ServiceImpl();
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
//                showCreatePage(request,response);
                break;
            case "detail":
//                detailProduct(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
//                removeUser(request,response);
                break;
            case "showHK":
               showHK(request,response);
                break;
            case "descName":
//                showDesc(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void showHK(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maHk=request.getParameter("maHk");
        request.setAttribute("thanhVienList",service.showTV(maHk));
        request.getRequestDispatcher("hoKhau/listTV.jsp").forward(request,response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maHk=request.getParameter("maHk");
        HoKhau hoKhau=service.findMaHK(maHk);
        request.setAttribute("hoKhau",hoKhau);

        request.getRequestDispatcher("hoKhau/edit.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hokhauList",service.findAllHK());
        request.getRequestDispatcher("hoKhau/list.jsp").forward(request,response);
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
//                showCreatePage(request,response);
                break;
            case "detail":
//                detailProduct(request,response);
                break;
            case "edit":
                editHK(request,response);
                break;
            case "delete":
//                removeUser(request,response);
                break;
            case "ascName":
//                showAsc(request,response);
                break;
            case "descName":
//                showDesc(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void editHK(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maHk=request.getParameter("maHk");
        String tenChuHo=request.getParameter("tenChuHo");
        String ngaylap=request.getParameter("ngaylap");
        String diaChi=request.getParameter("diaChi");
        HoKhau hoKhau=new HoKhau(maHk,tenChuHo,ngaylap,diaChi);
        service.edit(hoKhau);
        response.sendRedirect("/hoKhau");
    }
}
