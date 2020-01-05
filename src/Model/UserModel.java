package Model;

import Connection.ConnectionDB;
import Entities.Car;
import Entities.UserCar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

    public boolean login(String username, String pass){
        String sql ="select * from user where Username=? and Password=?";
        boolean status = false;
        try {
            Connection con = ConnectionDB.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,username);
            pre.setString(2,pass);
            ResultSet rs =pre.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<UserCar> getUserList() {
        List<UserCar> ListUserCar = new ArrayList<>();
        String sql = "select * from user";
        try {
            Connection conn = ConnectionDB.getConnection();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);

            if (rs != null) {
                try {
                    while (rs.next()) {
                        UserCar item = new UserCar();
                        item.setUsername(rs.getString("Username"));
                        item.setPassword(rs.getString("Password"));
                        item.setUser_fullname(rs.getString("User_fullname"));
                        item.setEmail(rs.getString("Email"));
                        item.setDate(rs.getString("Date"));
                        item.setPhone(rs.getDouble("Phone"));
                        item.setNote(rs.getString("Note"));
                        item.setUser_roles(rs.getInt("User_roles"));
                        item.setUser_id(rs.getInt("User_id"));

                        ListUserCar.add(item);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListUserCar;
    }

    //select car where NumberPlate
    public UserCar getUserByid(int id) {
        UserCar item = new UserCar();
        String sql = "select * from user where User_id=?";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    item.setUsername(rs.getString("Username"));
                    item.setPassword(rs.getString("Password"));
                    item.setUser_fullname(rs.getString("User_fullname"));
                    item.setEmail(rs.getString("Email"));
                    item.setDate(rs.getString("Date"));
                    item.setPhone(rs.getDouble("Phone"));
                    item.setNote(rs.getString("Note"));
                    item.setUser_roles(rs.getInt("User_roles"));
                    item.setUser_id(rs.getInt("User_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private boolean isExisting(UserCar item) {
        boolean flag = false;
        String sql = "select User_id from user";
        try {
            Connection conn = ConnectionDB.getConnection();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            if (rs != null) {
                try {
                    if (rs.next()) {
                        flag = true;//cÃ³ báº£n ghi
                    }
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean addUser(UserCar item) {
        if (this.isExisting(item) == false) {
            return true;
        }
        String sql = "insert into user( ";
        sql += " Username,Password,User_fullname,Email,Date,Phone,Note,User_roles,User_id ) ";
        sql += "values(?,?,?,?,?,?,?,?,?)";


        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setString(1,item.getUsername());
            pre.setString(2,item.getPassword());
            pre.setString(3,item.getUser_fullname());
            pre.setString(4,item.getEmail());
            pre.setString(5,item.getDate());
            pre.setDouble(6,item.getPhone());
            pre.setString(7,item.getNote());
            pre.setInt(8,item.getUser_roles());
            pre.setInt(9,item.getUser_id());

            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            //check=false;
        }
        return false;
    }

    public boolean updateUser(UserCar  item) {
        String sql = "update user set Username=?,Password=?,Email=?,User_fullname=?,Date=?,Phone=?,Note=?,User_roles=? where User_id=?";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setString(1,item.getUsername());
            pre.setString(2,item.getPassword());
            pre.setString(3,item.getEmail());
            pre.setString(4,item.getUser_fullname());
            pre.setString(5,item.getDate());
            pre.setDouble(6,item.getPhone());
            pre.setString(7,item.getNote());
            pre.setInt(8,item.getUser_roles());

            pre.setInt(9,item.getUser_id());



            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delUser(UserCar item) {
        // TODO Auto-generated method stub
        String sql = "delete from user where User_id = ? ";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setInt(1, item.getUser_id());

            pre.executeUpdate();
            return true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e);
        }

        return false;
    }
}
