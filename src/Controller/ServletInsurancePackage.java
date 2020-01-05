package Controller;

import Entities.Customer;
import Entities.InsurancePackage;
import Model.ModelCustomer;
import Model.ModelPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletInsurancePackage")
public class ServletInsurancePackage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("Actionpackage");
//            if(action.equals("login1")){
//                login(request,response);
//            }
            if (action.equals("addpackage")) {
                request.getRequestDispatcher("forms-advanced-package.jsp").forward(request, response);
            }
            if (action.equals("Updatepackage")) {
                request.getRequestDispatcher("updatepackage.jsp").forward(request, response);
            }if(action.equals("index")) {

                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if(action.equals("tablepackageadd")){
                insertpackage(request,response);
            }
            if (action.equals("tablepackageupdate")) {
                updatepackage(request,response);
            }
            if(action.equals("tablepackagedelete")){
                deletepackage(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void insertpackage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        ModelPackage mcu= new ModelPackage();
        int id =  Integer.parseInt(request.getParameter("txtid"));
        String packagetype =request.getParameter("txtpackagetype");
        String typecar = request.getParameter("txtcartype");
        String limit = request.getParameter("txtlimit");
        String issue = request.getParameter("txtissue");
        InsurancePackage insurancePackage = new InsurancePackage(id,packagetype,typecar,limit,issue);
        mcu.addPackage(insurancePackage);
        request.getRequestDispatcher("tables-data-package.jsp").forward(request, response);
    }
    public void updatepackage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        ModelPackage mcu= new ModelPackage();
        int id =  Integer.parseInt(request.getParameter("txtid"));
        String packagetype =request.getParameter("txtpackagetype");
        String typecar = request.getParameter("txtcartype");
        String limit = request.getParameter("txtlimit");
        String issue = request.getParameter("txtissue");
        InsurancePackage insurancePackage = new InsurancePackage(id,packagetype,typecar,limit,issue);
        mcu.updatepackage(insurancePackage);
        request.getRequestDispatcher("tables-data-package.jsp").forward(request, response);
    }

    public void deletepackage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        ModelPackage mcu= new ModelPackage();
        int id= Integer.parseInt(request.getParameter("id"));
        InsurancePackage insurancePackage= new InsurancePackage(id);
        mcu.delpackage(insurancePackage);
        request.getRequestDispatcher("tables-data-package.jsp").forward(request,response);
    }
}
