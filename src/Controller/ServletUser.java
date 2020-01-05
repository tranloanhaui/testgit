package Controller;

import Entities.UserCar;
import Model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletUser")
public class ServletUser extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            String action = request.getParameter("Actionuser");
            if(action.equals("login")){
                login(request,response);
            }
            if (action.equals("adduser")) {
                request.getRequestDispatcher("forms-advanced-user.jsp").forward(request, response);
            }
            if (action.equals("Updateuser")) {
                request.getRequestDispatcher("updateuser.jsp").forward(request, response);
            }if(action.equals("index")) {

                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if(action.equals("tableuseradd")){
                insertuser(request,response);
            }
            if (action.equals("tableuserupdate")) {
                updateuser(request,response);
            }
            if(action.equals("tableuserdelete")){
                deleteuser(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String user =request.getParameter("UserName");
        String pass =request.getParameter("Pass");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        UserModel mu= new UserModel();
        boolean check = mu.login(user,pass);
        if(check){
            RequestDispatcher rd =request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
        else{
            out.print("Sorry username or password error");
            RequestDispatcher rd=request.getRequestDispatcher("loginuser.jsp");
            rd.include(request,response);
        }

        out.close();
    }

    public void insertuser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        UserModel um= new UserModel();
        String name = request.getParameter("txtname");
        String pass = request.getParameter("txtpass");
        String fullname = request.getParameter("txtfullname");
        String email = request.getParameter("txtemail");
        String date = request.getParameter("txtdate");
        Double phone = Double.parseDouble(request.getParameter("txtphone"));
        String note = request.getParameter("txtnote");
        int roles = Integer.parseInt(request.getParameter("txtroles"));
        int id=Integer.parseInt(request.getParameter("txtid"));
        UserCar uc = new UserCar(name,pass,email,date,phone,note,roles,fullname,id);
        um.addUser(uc);
        request.getRequestDispatcher("tables-data-user.jsp").forward(request, response);
    }
    public void updateuser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        UserModel um= new UserModel();
        String name = request.getParameter("txtname");
        String pass = request.getParameter("txtpass");
        String fullname = request.getParameter("txtfullname");
        String email = request.getParameter("txtemail");
        String date = request.getParameter("txtdate");
        Double phone = Double.parseDouble(request.getParameter("txtphone"));
        String note = request.getParameter("txtnote");
        int roles = Integer.parseInt(request.getParameter("txtroles"));
        int id=Integer.parseInt(request.getParameter("txtid"));
        UserCar uc = new UserCar(name,pass,email,date,phone,note,roles,fullname,id);
        um.updateUser(uc);
        request.getRequestDispatcher("tables-data-user.jsp").forward(request, response);
    }

    public void deleteuser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        UserModel um= new UserModel();
        int id=Integer.parseInt(request.getParameter("id"));
        UserCar uc= new UserCar(id);
        um.delUser(uc);
        request.getRequestDispatcher("tables-data-user.jsp").forward(request,response);
    }
}
