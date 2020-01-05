package Model;

import Entities.InsurancePackage;
import Connection.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelPackage {

    //----------------------------------Package---------------------------------------//
    public List<InsurancePackage> getPackageList(String pk) {
        List<InsurancePackage> ListPackage = new ArrayList<>();
        String sql = "select * from insurancepackage where Packagetype=? order by IDInsurance ASC";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, pk);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                try {
                    while (rs.next()) {
                        InsurancePackage item = new InsurancePackage();
                        item.setIDinsurance(rs.getInt("IDinsurance"));
                        item.setPackagetype(rs.getString("Packagetype"));
                        item.setCartype(rs.getString("Cartype"));
                        item.setCartype(rs.getString("timelimit"));
                        item.setCartype(rs.getString("dateofissue"));

                        ListPackage.add(item);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListPackage;
    }

    public List<InsurancePackage> getPackageList1() {
        List<InsurancePackage> ListPackage = new ArrayList<>();
        String sql = "select * from insurancepackage order by IDInsurance ASC";
        try {
            Connection conn = ConnectionDB.getConnection();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            if (rs != null) {
                try {
                    while (rs.next()) {
                        InsurancePackage item = new InsurancePackage();
                        item.setIDinsurance(rs.getInt("IDinsurance"));
                        item.setPackagetype(rs.getString("Packagetype"));
                        item.setCartype(rs.getString("Cartype"));
                        item.setTimelimit(rs.getString("timelimit"));
                        item.setDateofissue(rs.getString("dateofissue"));

                        ListPackage.add(item);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListPackage;
    }

    public String getPackagetypecar(int year) {
        if (year >= 2005) {
            return "A";
        } else if (year >= 1998 && year <= 2004) {
            return "B";
        } else {
            return "C";
        }
    }

    public InsurancePackage getPackgebyip(int IP) {

        InsurancePackage item = new InsurancePackage();
        String sql = "select * from insurancepackage where IDInsurance=?";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, IP);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    item.setPackagetype(rs.getString("Packagetype"));
                    item.setCartype(rs.getString("Cartype"));
                    item.setCartype(rs.getString("timelimit"));
                    item.setCartype(rs.getString("dateofissue"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private boolean isExisting(InsurancePackage item) {
        boolean flag = false;
        String sql = "select IDInsurance from InsurancePackage where IDInsurance='" + item.getIDinsurance() + "' ";
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

    public boolean addPackage(InsurancePackage item) {
//        if (this.isExisting(item)==false) {
//            return false;
//        }
        String sql = "insert into InsurancePackage ( ";
        sql += "IDInsurance,CarType,Packagetype, timelimit, dateofissue) ";
        sql += "values(?,?,?,?,?)";


        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setInt(1,item.getIDinsurance());
            pre.setString(2, item.getCartype());
            pre.setString(3, item.getPackagetype());
            pre.setString(4, item.getTimelimit());
            pre.setString(5, item.getDateofissue());


            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            //check=false;
        }
        return false;
    }

    public boolean updatepackage(InsurancePackage item) {
        String sql = "update InsurancePackage set Cartype=?, Packagetype=?, timelimit=?, dateofissue=? where IDInsurance=?";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setString(1, item.getCartype());
            pre.setString(2, item.getPackagetype());
            pre.setString(3, item.getTimelimit());
            pre.setString(4, item.getDateofissue());

            pre.setInt(5, item.getIDinsurance());

            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean delpackage(InsurancePackage item) {
        // TODO Auto-generated method stub
        String sql = "delete from InsurancePackage where IDInsurance = ? ";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, item.getIDinsurance());
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
