package com.example.mvc.controller;

import com.example.mvc.model.Product;
import com.example.mvc.service.IproductService;
import com.example.mvc.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = {"/product",""})
public class ProductServlet extends HttpServlet {
    IproductService iproductService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreatePage(request,response);
                break;
            case "detail":
                detailProduct(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                showRemove(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void showRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Product product=this.iproductService.findById(id);

        request.setAttribute("product",product);
        request.getRequestDispatcher("product/delete.jsp").forward(request,response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Product product=this.iproductService.findById(id);

        request.setAttribute("product",product);
        request.getRequestDispatcher("product/edit.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productList",iproductService.findAll());
        request.getRequestDispatcher("product/productList.jsp").forward(request,response);
    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("product/create.jsp");
    }
    private void detailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Product product=this.iproductService.findById(id);

        request.setAttribute("product",product);
        request.getRequestDispatcher("product/detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                creatProduct(request,response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            case "delete":
                removeProduct(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void removeProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Product product=this.iproductService.findById(id);
        this.iproductService.remove(id);
        response.sendRedirect("/product");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idP=Integer.parseInt(request.getParameter("id"));
        String newName=request.getParameter("newName");
        String newBrand=request.getParameter("newBrand");
        int newPrice=Integer.parseInt(request.getParameter("newPrice"));
        String newImage=request.getParameter("newImage");
        Product product=new Product(idP,newName,newBrand,newPrice,newImage);
        iproductService.edit(product);

        response.sendRedirect("/product");
    }


    private void creatProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idP=Integer.parseInt(request.getParameter("id"));
        String nameP=request.getParameter("name");
        String brandP=request.getParameter("brand");
        int priceP=Integer.parseInt(request.getParameter("price"));
        String imageP=request.getParameter("image");
        Product product=new Product(idP,nameP,brandP,priceP,imageP);
        iproductService.save(product);
        response.sendRedirect("/product");

    }
}
