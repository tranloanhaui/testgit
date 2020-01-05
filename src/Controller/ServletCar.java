package Controller;

import Entities.Car;
import Model.ModelCar;
import Model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCar")
public class ServletCar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("Actioncar");
            if (action.equals("addcar")) {
                request.getRequestDispatcher("forms-advanced.jsp").forward(request, response);
            }
            if (action.equals("Updatecar")) {
               request.getRequestDispatcher("updatecar.jsp").forward(request, response);
            }if(action.equals("index")) {

                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if(action.equals("tablecaradd")){
                insertcar(request,response);
            }
            if (action.equals("tablecarupdate")) {
                updatecar(request,response);
            }
            if(action.equals("tablecardelete")){
                deletecar(request,response);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void insertcar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        ModelCar cm= new ModelCar();
        String name = request.getParameter("txtnamecar");
        String type = request.getParameter("txtcartype");
        String color = request.getParameter("txtcarcolor");
        int seat = Integer.parseInt(request.getParameter("txtcarseat"));
        String num = request.getParameter("txtcarnum");
        String brand = request.getParameter("txtcarbrand");
        String year = request.getParameter("txtcaryear");
        double price = Double.parseDouble(request.getParameter("txtcarprice"));
        int tax = Integer.parseInt(request.getParameter("txtcartax"));
        boolean have = Boolean.parseBoolean(request.getParameter("txtcarhave"));
        String user = request.getParameter("txtcaruser");
        String engine = request.getParameter("txtcarengine");
        String gear = request.getParameter("txtcargear");
        String fuel = request.getParameter("txtcarfuel");
        Car car = new Car(name,type,color,seat,num,brand,year,price,tax,have,user,engine,gear,fuel);
        cm.addCar(car);
        request.getRequestDispatcher("tables-data.jsp").forward(request, response);
    }
    public void updatecar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        ModelCar mc = new ModelCar();
        String name = request.getParameter("txtnamecar");
        String type = request.getParameter("txtcartype");
        String color = request.getParameter("txtcarcolor");
        int seat = Integer.parseInt(request.getParameter("txtcarseat"));
        String num = request.getParameter("txtcarnum");
        String brand = request.getParameter("txtcarbrand");
        String year = request.getParameter("txtcaryear");
        double price = Double.parseDouble(request.getParameter("txtcarprice"));
        int tax = Integer.parseInt(request.getParameter("txtcartax"));
        boolean have = Boolean.parseBoolean(request.getParameter("txtcarhave"));
        String user = request.getParameter("txtcaruser");
        String engine = request.getParameter("txtcarengine");
        String gear = request.getParameter("txtcargear");
        String fuel = request.getParameter("txtcarfuel");
        Car car = new Car(name,type,color,seat,num,brand,year,price,tax,have,user,engine,gear,fuel);
        mc.updateCar(car);
        request.getRequestDispatcher("tables-data.jsp").forward(request, response);
    }

    public void deletecar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        ModelCar cm= new ModelCar();
        String num= request.getParameter("numberplate");
        Car car= new Car(num);
        cm.delCar(car);
        request.getRequestDispatcher("tables-data.jsp").forward(request,response);
    }
}
