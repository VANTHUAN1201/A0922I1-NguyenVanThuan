package com.example.demoproduct.controller;

import com.example.demoproduct.model.Category;
import com.example.demoproduct.model.Product;
import com.example.demoproduct.service.IProductService;
import com.example.demoproduct.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", value = {"/product",""})
public class productServlet extends HttpServlet {
    IProductService service=new ProductServiceImpl();
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
        int id=Integer.parseInt(request.getParameter("id"));
        Product product=service.findIdProduct(id);
        request.setAttribute("product",product);
        request.setAttribute("listCategory",service.findAllCategory());

        request.getRequestDispatcher("product/edit.jsp").forward(request,response);
    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("listCategory",service.findAllCategory());
        request.getRequestDispatcher("product/create.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listProduct",service.findAllProduct());
        request.setAttribute("listCategory",service.findAllCategory());

        request.getRequestDispatcher("product/list.jsp").forward(request,response);
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
                createProduct(request,response);
                break;
            case "detail":
//                detailProduct(request,response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            case "delete":
//                removeUser(request,response);
                break;
            case "searchName":
                searchingName(request,response);
                break;
            case "descName":
//                showDesc(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void removeUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        service.remove(id);
        response.sendRedirect("/product");
    }

    private void searchingName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("str");
        List<Product> list=service.findName(name);
        request.setAttribute("listProduct",list);
        request.getRequestDispatcher("/product/list.jsp").forward(request,response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        int price=Integer.parseInt( request.getParameter("price"));
        int amount=Integer.parseInt( request.getParameter("amount"));
        int id_category=Integer.parseInt(request.getParameter("id_category"));
        Product product=new Product(id,name,price,amount,id_category);
        service.edit(product);
        response.sendRedirect("/product");
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name=request.getParameter("name");
        int price=Integer.parseInt( request.getParameter("price"));
        int amount=Integer.parseInt( request.getParameter("amount"));
        int id_category=Integer.parseInt(request.getParameter("id_category"));
       // System.out.println(id_category);
        Product product=new Product(name,price,amount,id_category);
        service.save(product);
        response.sendRedirect("/product");
    }
}
