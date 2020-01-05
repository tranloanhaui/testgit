package Model;

import Connection.ConnectionDB;

import Entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelCustomer {
    public List<Customer> getCustomerList() {
        List<Customer> ListCustomer = new ArrayList<>();
        String sql = "select * from customer";
        try {
            Connection conn = ConnectionDB.getConnection();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);

            if (rs != null) {
                try {
                    while (rs.next()) {
                        Customer item = new Customer();
                        item.setCustomer_id(rs.getString("Customer_id"));
                        item.setCustomer_name(rs.getString("Customer_name"));
                        item.setCustomer_phone(rs.getInt("Customer_phone"));
                        item.setCustomer_fullname(rs.getString("Customer_fullname"));
                        item.setCustomer_birthday(rs.getString("Customer_birthday"));
                        item.setCustomer_homephone(rs.getDouble("Customer_homephone"));
                        item.setCustomer_email(rs.getString("Customer_email"));
                        item.setCustomer_address(rs.getString("Customer_address"));
                        item.setCustomer_job(rs.getString("Customer_job"));
                        item.setCustomer_note(rs.getString("Customer_note"));
                        item.setCustomer_roles(rs.getString("Customer_roles"));

                        ListCustomer.add(item);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListCustomer;
    }

    //select customer where id
    public Customer getCustomerByid(String id) {
        Customer item = new Customer();
//        List<Car> ListCar= new ArrayList<>();
        String sql = "select * from Customer where Customer_id=?";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    item.setCustomer_id(rs.getString("Customer_id"));
                    item.setCustomer_name(rs.getString("Customer_name"));
                    item.setCustomer_phone(rs.getInt("Customer_phone"));
                    item.setCustomer_fullname(rs.getString("Customer_fullname"));
                    item.setCustomer_birthday(rs.getString("Customer_birthday"));
                    item.setCustomer_homephone(rs.getDouble("Customer_homephone"));
                    item.setCustomer_email(rs.getString("Customer_email"));
                    item.setCustomer_address(rs.getString("Customer_address"));
                    item.setCustomer_job(rs.getString("Customer_job"));
                    item.setCustomer_note(rs.getString("Customer_note"));
                    item.setCustomer_roles(rs.getString("Customer_roles"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private boolean isExisting(Customer item) {
        boolean flag = false;
        String sql = "select Customer_id from customer";
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

    public boolean addCustoer(Customer item) {
        if (this.isExisting(item) == false) {
            return false;
        }
        String sql = "insert into customer( ";
        sql += "Customer_id,Customer_phone,Customer_name,Customer_fullname,Customer_birthday,Customer_homephone,Customer_email,Customer_address,Customer_job,Customer_note,Customer_roles) ";
        sql += "values(?,?,?,?,?,?,?,?,?,?,?)";


        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setString(1,item.getCustomer_id());
            pre.setInt(2,item.getCustomer_phone());
            pre.setString(3,item.getCustomer_name());
            pre.setString(4,item.getCustomer_fullname());
            pre.setString(5,item.getCustomer_birthday());
            pre.setDouble(6,item.getCustomer_homephone());
            pre.setString(7,item.getCustomer_email());
            pre.setString(8,item.getCustomer_address());
            pre.setString(9,item.getCustomer_job());
            pre.setString(10,item.getCustomer_note());
            pre.setString(11,item.getCustomer_roles());

            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            //check=false;
        }
        return false;
    }

    public boolean updateCustomer(Customer item) {
        String sql = "update Customer set Customer_phone=?,Customer_name=?,Customer_fullname=?,Customer_birthday=?,Customer_homephone=?,Customer_email=?,Customer_address=?,Customer_job=?,Customer_note=?,Customer_roles=? where Customer_id=?";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham
            pre.setInt(1,item.getCustomer_phone());
            pre.setString(2,item.getCustomer_name());
            pre.setString(3,item.getCustomer_fullname());
            pre.setString(4,item.getCustomer_birthday());
            pre.setDouble(5,item.getCustomer_homephone());
            pre.setString(6,item.getCustomer_email());
            pre.setString(7,item.getCustomer_address());
            pre.setString(8,item.getCustomer_job());
            pre.setString(9,item.getCustomer_note());
            pre.setString(10,item.getCustomer_roles());

            pre.setString(11,item.getCustomer_id());

            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

    public boolean delCustomer(Customer item) {
        // TODO Auto-generated method stub
        String sql = "delete from customer where Customer_id = ? ";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, item.getCustomer_id());

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
