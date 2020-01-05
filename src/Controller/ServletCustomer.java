package Controller;

import Entities.Customer;
import Model.ModelCustomer;
import com.sun.xml.internal.ws.api.server.AbstractInstanceResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCustomer")
public class ServletCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("Actioncus");
            if (action.equals("addcustomer")) {
                request.getRequestDispatcher("forms-advanced-customer.jsp").forward(request, response);
            }
            if (action.equals("Updatecustomer")) {
                request.getRequestDispatcher("updatecustomer.jsp").forward(request, response);
            }if(action.equals("index")) {

                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if(action.equals("tablecustomeradd")){
                insertcustomer(request,response);
            }
            if (action.equals("tablecustomerupdate")) {
                updatecustomer(request,response);
            }
            if(action.equals("tablecustomerdelete")){
                deletecustomer(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void insertcustomer(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        ModelCustomer mcu= new ModelCustomer();
        String id = request.getParameter("txtid");
        int phone = Integer.parseInt(request.getParameter("txtphone"));
        String name = request.getParameter("txtmane");
        String fullname = request.getParameter("txtfullname");
        String birthday = request.getParameter("txtbirthday");
        Double homephone = Double.parseDouble(request.getParameter("txthomephone"));
        String email = request.getParameter("txtemail");
        String adress = request.getParameter("txtadress");
        String job = request.getParameter("txtjob");
        String note = request.getParameter("txtnote");
        String roles = request.getParameter("txtroles");
        Customer customer = new Customer(id,phone,name,fullname, birthday,homephone,email,adress,job,note,roles);
        mcu.addCustoer(customer);
        request.getRequestDispatcher("tables-data-customor.jsp").forward(request, response);
    }
    public void updatecustomer(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        ModelCustomer mcu= new ModelCustomer();
        String id = request.getParameter("txtid");
        int phone = Integer.parseInt(request.getParameter("txtphone"));
        String name = request.getParameter("txtmane");
        String fullname = request.getParameter("txtfullname");
        String birthday = request.getParameter("txtbirthday");
        Double homephone = Double.parseDouble(request.getParameter("txthomephone"));
        String email = request.getParameter("txtemail");
        String adress = request.getParameter("txtadress");
        String job = request.getParameter("txtjob");
        String note = request.getParameter("txtnote");
        String roles = request.getParameter("txtroles");
        Customer customer = new Customer(id,phone,name,fullname, birthday,homephone,email,adress,job,note,roles);
        mcu.updateCustomer(customer);
        request.getRequestDispatcher("tables-data-customor.jsp").forward(request, response);
    }

    public void deletecustomer(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        ModelCustomer mcu= new ModelCustomer();
        String id= request.getParameter("id");
        Customer car= new Customer(id);
        mcu.delCustomer(car);
        request.getRequestDispatcher("tables-data-customor.jsp").forward(request,response);
    }
}
