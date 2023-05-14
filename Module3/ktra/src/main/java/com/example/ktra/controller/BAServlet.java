package com.example.ktra.controller;

import com.example.ktra.model.BenhNhan;
import com.example.ktra.service.IService;
import com.example.ktra.service.ServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BAServlet", value ={"/benhAn",""})
public class BAServlet extends HttpServlet {
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
                //showEdit(request,response);
                break;
            case "detail":
//                detailProduct(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                deleteBA(request,response);
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

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBenhNhan=request.getParameter("maBenhNhan");
        BenhNhan benhNhan=service.timBN(maBenhNhan);
        request.setAttribute("benhNhan",benhNhan);
        request.getRequestDispatcher("benhAn/sua.jsp").forward(request,response);
    }
    private void deleteBA(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maBenhNhan=request.getParameter("maBenhNhan");
        service.xoa(maBenhNhan);
        response.sendRedirect("/benhAn");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("benhNhanList",service.hienThiBN());

        request.getRequestDispatcher("benhAn/list.jsp").forward(request,response);
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
               // createProduct(request,response);
                break;
            case "detail":
//                detailProduct(request,response);
                break;
            case "edit":
                editBA(request,response);
                break;
            case "delete":
                //deleteBA(request,response);
                break;
            case "searchName":
               // searchingName(request,response);
                break;
            case "descName":
//                showDesc(request,response);
                break;
            default:
                showList(request,response);
        }
    }



    private void editBA(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maBenhAn=request.getParameter("maBenhAn");
        String maBenhNhan=request.getParameter("maBenhNhan");
        String tenBenhNhan=request.getParameter("tenBenhNhan");
        String ngayNhap=request.getParameter("ngayNhap");
        String ngayRa=request.getParameter("ngayRa");
        String liDo=request.getParameter("liDo");

        BenhNhan benhNhan=new BenhNhan(maBenhNhan,tenBenhNhan,ngayNhap,ngayRa,liDo,maBenhAn);
        service.sua(benhNhan);
        response.sendRedirect("/benhAn");
    }
}
