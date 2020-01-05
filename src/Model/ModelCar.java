package Model;

import ConnecDB.ConnectDB;
import Entity.Car;
import Entity.InsuranceCar;
import Entity.InsurancePackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelCar {

    public List<Car> getCarList() {
        List<Car> ListCar = new ArrayList<>();
        String sql = "select * from Car";
        try {
            Connection conn = ConnectDB.getConnection();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);

            if (rs != null) {
                try {
                    while (rs.next()) {
                        Car item = new Car();
                        //item.setNameCar(rs.getString("NameCar"));
                        item.setNumberPlate(rs.getString("NumberPlate"));
                        item.setYearofmanufacture(rs.getInt("Yearofmanufacture"));
                        item.setBrand(rs.getString("Brand"));
                        item.setHaveInsurance(rs.getBoolean("HaveInsurance"));
                        item.setEmail(rs.getString("Email"));
                        item.setStatus(rs.getString("Status"));

                        ListCar.add(item);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListCar;
    }

    //select car where NumberPlate
    public Car getCarByNum(String num) {
        Car item = new Car();
//        List<Car> ListCar= new ArrayList<>();
        String sql = "select * from Car where NumberPlate=?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, num);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                   // item.setNameCar(rs.getString("NameCar"));
                    item.setNumberPlate(rs.getString("NumberPlate"));
                    item.setYearofmanufacture(rs.getInt("Yearofmanufacture"));
                    item.setBrand(rs.getString("Brand"));
                    item.setHaveInsurance(rs.getBoolean("HaveInsurance"));
                    item.setEmail(rs.getString("Email"));
                    item.setStatus(rs.getString("Status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public List<Car> getlistcarbyhave() {
        List<Car> ListCar = new ArrayList<>();
        String sql = "select * from Car where HaveInsurance=0 ";
        try {
            Connection conn = ConnectDB.getConnection();
//            PreparedStatement pre= conn.prepareStatement(sql);
//            pre.setString(1,String.valueOf(have));
//            ResultSet rs=pre.executeQuery();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Car item = new Car();
                   // item.setNameCar(rs.getString("NameCar"));
                    item.setNumberPlate(rs.getString("NumberPlate"));
                    item.setYearofmanufacture(rs.getInt("Yearofmanufacture"));
                    item.setBrand(rs.getString("Brand"));
                    item.setHaveInsurance(rs.getBoolean("HaveInsurance"));
                    item.setEmail(rs.getString("Email"));
                    item.setStatus(rs.getString("Status"));

                    ListCar.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListCar;
    }

    private boolean isExisting(Car item) {
        boolean flag = false;
        String sql = "select NumberPlate from car where Number='" + item.getNumber()+ "' ";
        try {
            Connection conn = ConnectDB.getConnection();
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

    public boolean addCar(Car item) {
        if (this.isExisting(item) == false) {
            return false;
        }
        String sql = "insert into car( ";
        sql += "NumberPlate,Yearofmanufacture,Brand,HaveInsurance,Email,Status,NameCar) ";
        sql += "values(?,?,?,?,?,?,?)";


        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setString(1, item.getNumberPlate());
            pre.setInt(2, item.getYearofmanufacture());
            pre.setString(3, item.getBrand());
            pre.setBoolean(4, item.isHaveInsurance());
            pre.setString(5, item.getEmail());
            pre.setString(6, item.getStatus());
            //pre.setString(7, item.getNameCar());

            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            //check=false;
        }
        return false;
    }

    public boolean updateCar(Car item) {
        String sql = "update car set NameCar=?, Yearofmanufacture=?, Brand=?,HaveInsurance=?,Email=?,Status=? where NumberPlate=?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
          //  pre.setString(1, item.getNameCar());
            pre.setInt(2, item.getYearofmanufacture());
            pre.setString(3, item.getBrand());
            pre.setBoolean(4, item.isHaveInsurance());
            pre.setString(5, item.getEmail());
            pre.setString(6, item.getStatus());

            pre.setString(7, item.getNumberPlate());

            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

    public boolean updatehave(String num) {
        String sql = "update car set HaveInsurance=1 where NumberPlate=?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, num);
            pre.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean delCar(Car item) {
        // TODO Auto-generated method stub
        String sql = "delete from car where NumberPlate = ? ";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, item.getNumberPlate());

            pre.executeUpdate();
            return true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e);
        }

        return false;
    }

    //----------------------------------Package---------------------------------------//

    public List<InsurancePackage> getPackageList(String pk) {
        List<InsurancePackage> ListPackage = new ArrayList<>();
        String sql = "select * from insurancepackage where Packagetype=? order by IDInsurance ASC";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, pk);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                try {
                    while (rs.next()) {
                        InsurancePackage item = new InsurancePackage();
                        item.setIDInsurance(rs.getInt("IDInsurance"));
                        item.setNamePackage(rs.getString("namePackage"));
                        item.setCarType(rs.getString("CarType"));
                        item.setPackagetype(rs.getString("Packagetype"));

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
            Connection conn = ConnectDB.getConnection();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            if (rs != null) {
                try {
                    while (rs.next()) {
                        InsurancePackage item = new InsurancePackage();
                        item.setNamePackage(rs.getString("namePackage"));
                        item.setCarType(rs.getString("CarType"));
                        item.setPackagetype(rs.getString("Packagetype"));

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
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, IP);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    item.setNamePackage(rs.getString("namePackage"));
                    item.setCarType(rs.getString("CarType"));
                    item.setPackagetype(rs.getString("Packagetype"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private boolean isExisting(InsurancePackage item) {
        boolean flag = false;
        String sql = "select IDInsurance from InsurancePackage where IDInsurance='" + item.getIDInsurance() + "' ";
        try {
            Connection conn = ConnectDB.getConnection();
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
        String sql = "insert into InsurancePackage( ";
        sql += "IDInsurance,namePackage,CarType,Packagetype) ";
        sql += "values(?,?,?,?)";


        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setInt(1,item.getIDInsurance());
            pre.setString(2, item.getNamePackage());
            pre.setString(3, item.getCarType());
            pre.setString(4, item.getPackagetype());


            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            //check=false;
        }
        return false;
    }

    public boolean updatepackage(InsurancePackage item) {
        String sql = "update InsurancePackage set namePackage=?, CarType=?, Packagetype=? where IDInsurance=?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setString(1, item.getNamePackage());
            pre.setString(2, item.getCarType());
            pre.setString(3, item.getPackagetype());

            pre.setInt(4, item.getIDInsurance());

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
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, item.getIDInsurance());
            pre.executeUpdate();
            return true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e);
        }

        return false;
    }

    //---------------------------------INSURANCE-----------------------------
    public boolean addInsu(InsuranceCar item) {
        String sql = "insert into InsuranceCar( ";
        sql += "IDInsurance,NumberPlate) ";
        sql += "values(?,?)";

        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setInt(1, item.getIDInsurance());
            pre.setString(2, item.getNumberPlate());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean login(String username, String userpass) {
        String sql = "select * from UserCar where username=? and password=? ";
        boolean status = false;
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, userpass);
            ResultSet rs = pre.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

}
