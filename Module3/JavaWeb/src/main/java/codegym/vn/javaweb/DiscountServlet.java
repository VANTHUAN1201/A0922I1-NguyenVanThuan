package codegym.vn.javaweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String description =request.getParameter("description");
     int price= Integer.parseInt(request.getParameter("price")) ;
     double discount=Double.parseDouble(request.getParameter("discount"));
     double amount= price * discount*0.01;
     double lastPrice=price-amount;
     PrintWriter writer=response.getWriter();
     writer.println("<html>");
     writer.println("<h1>Product Discount Calculator</h1>");
     writer.println("<p>Product Descriptio: " + description + "</p>");
     writer.println("<p>List Price:  " + price + "</p>");
     writer.println("<p>Discount Percent: " + discount + "</p>");
     writer.println("<p>Discount Amount: " + amount + "</p>");
     writer.println("<p>Discount Price: " + lastPrice + "</p>");
     writer.println("</html>");
    }
}
