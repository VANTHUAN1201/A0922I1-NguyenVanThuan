package com.example.jsp_istl.controllers;

import com.example.jsp_istl.model.KhachHang;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "KhachHangServlet", value = "/khachHang")
public class KhachHangServlet extends HttpServlet {
    private static List<KhachHang> khachHangList;
    static {
        khachHangList=new ArrayList<>();
        khachHangList.add(new KhachHang("Mai Văn Hoàn","1983-08-20","Hà Nội","anh1.jpeg"));
        khachHangList.add(new KhachHang("Nguyễn Văn Nam","1983-08-21","Bắc Giang","anh2.jpeg"));
        khachHangList.add(new KhachHang("Nguyễn Thái Hòa","1983-08-22","Nam Định","anh3.jpg"));
        khachHangList.add(new KhachHang("Trần Đăng Khoa","1983-08-17","Hà Tây","anh4.jpg"));
        khachHangList.add(new KhachHang("Nguyễn Đình Thi","1983-08-19","Hà Nội","anh5.jpg"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("khachHangList",khachHangList);
        request.getRequestDispatcher("khachHang/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
