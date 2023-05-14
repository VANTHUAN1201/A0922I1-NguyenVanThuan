package controller;

import entities.House;
import entities.HouseDao;
import service.HouseServiceImpl;
import service.IService;
import service.PersonService;
import utils.Valid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "HouseServlet", urlPatterns = "/houseServlet")
public class HouseServlet extends HttpServlet {

    IService<HouseDao> houseService = new HouseServiceImpl();
    PersonService personService = new PersonService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Vao do post: " + LocalTime.now());
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action){
            case "doSave":
                save(request,response);
                break;
            default:
                findAll(request,response);
        } }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String hhName = request.getParameter("hhName");
        Date hhDate = Date.valueOf(request.getParameter("hhDate"));
        String address = request.getParameter("address");
        HouseDao houseDao = new HouseDao(id,hhName,hhDate,address);
        Map<String, String> error = Valid.getValidate(houseDao);
        if (error.isEmpty()){
            houseService.save(houseDao);
            response.sendRedirect("/houseServlet?message=Update successfully!!!");
            return;
        }
        request.setAttribute("error",error);
        request.setAttribute("persons",personService.findAll());
        request.setAttribute("item",houseDao);
        request.getRequestDispatcher("/views/save.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Vao do get: " + LocalTime.now());
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action){
            case "goUpdatePage":
                goUpdatePage(request,response);
                break;
            case "goCreatePage":
                break;
            case "delete":
                delete(request,response);
            default:
                findAll(request,response);
        }
    }

    private void goUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("persons",personService.findAll());
        request.setAttribute("item",houseService.findById(id));
        request.getRequestDispatcher("/views/save.jsp").forward(request,response);
    }

    private void goCreatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("persons",personService.findAll());
        request.getRequestDispatcher("/views/save.jsp").forward(request,response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = Optional.ofNullable(request.getParameter("index")).orElse("1");
        String message = request.getParameter("message");
        String searchName = Optional.ofNullable(request.getParameter("searchName")).orElse("");
        request.setAttribute("index",index);
        request.setAttribute("message",message);
        request.setAttribute("searchName",searchName);
        request.setAttribute("pages",houseService.pages());
        request.setAttribute("houses",houseService.findAll(searchName, index));
        request.setAttribute("persons",personService.findAll());
        request.getRequestDispatcher("/views/list.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        request.setAttribute("info",personService.findByIdHH(id));
    }
}
