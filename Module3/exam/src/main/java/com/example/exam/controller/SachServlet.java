package com.example.exam.controller;

import com.example.exam.model.Sach;
import com.example.exam.model.TheMuonSach;
import com.example.exam.service.IServiceSach;
import com.example.exam.service.ServiceSachImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SachServlet", value = {"/sach",""})
public class SachServlet extends HttpServlet {
    IServiceSach serviceSach=new ServiceSachImpl();
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
            case "muon":
               hienThiMuonSach(request,response);
                break;
            case "detail":
//                detailProduct(request,response);
                break;
            case "edit":
              //  showEdit(request,response);
                break;
            case "delete":
     //           removeUser(request,response);
                break;
            case "ascName":
//                showAsc(request,response);
                break;
            case "descName":
//                showDesc(request,response);
                break;
            default:
                hienThiSach(request,response);
        }
    }

    private void hienThiMuonSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSach=request.getParameter("maSach");
        Sach sach=serviceSach.findMaSach(maSach);
        request.setAttribute("sach",sach);
        request.setAttribute("hocSinhList",serviceSach.hienThiHS());
        request.getRequestDispatcher("sach/muonSach.jsp").forward(request,response);
    }

    private void hienThiSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("sachList",serviceSach.hienThiSach());
        request.getRequestDispatcher("sach/list.jsp").forward(request,response);
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
            case "muon":
                muonSach(request,response);
                break;
            case "detail":
//                detailProduct(request,response);
                break;
            case "edit":
                //  showEdit(request,response);
                break;
            case "delete":
                //           removeUser(request,response);
                break;
            case "ascName":
//                showAsc(request,response);
                break;
            case "descName":
//                showDesc(request,response);
                break;
            default:
                hienThiSach(request,response);
        }
    }

    private void muonSach(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maMuonSach=request.getParameter("maMuonSach");
        String maSach=request.getParameter("maSach");
        String maHS=request.getParameter("maHS");
        String ngayMuon=request.getParameter("ngayMuon");
        String ngayTra=request.getParameter("ngayTra");
        TheMuonSach theMuonSach=new TheMuonSach(maMuonSach,maSach,maHS,ngayMuon,ngayTra);
        serviceSach.muonSach(theMuonSach);
        response.sendRedirect("/sach");

    }
}
