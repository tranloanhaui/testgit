package Model;

import Connection.ConnectionDB;
import Entities.Car;
import Entities.InsuranceCar;
import Entities.InsurancePackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelCar {

    public List<Car> getCarList() {
        List<Car> ListCar = new ArrayList<>();
        String sql = "select * from car";
        try {
            Connection conn = ConnectionDB.getConnection();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);

            if (rs != null) {
                try {
                    while (rs.next()) {
                        Car item = new Car();
                        item.setNamecar(rs.getString("Namecar"));
                        item.setCartype(rs.getString("Cartype"));
                        item.setColor(rs.getString("Color"));
                        item.setNumberofseats(rs.getInt("Numberofseats"));
                        item.setNumberplate(rs.getString("Numberplate"));
                        item.setBrand(rs.getString("Brand"));
                        item.setYearofmanufacture(rs.getString("Yearofmanufacture"));
                        item.setPrice(rs.getDouble("Price"));
                        item.setTax(rs.getInt("Tax"));
                        item.setHaveinsurancecar(rs.getBoolean("Haveinsurancecar"));
                        item.setUsername(rs.getString("Username"));
                        item.setEngine(rs.getString("Engine"));
                        item.setGear(rs.getString("Gear"));
                        item.setFuel(rs.getString("Fuel"));

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
        String sql = "select * from Car where Numberplate=?";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, num);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    item.setNamecar(rs.getString("Namecar"));
                    item.setCartype(rs.getString("Cartype"));
                    item.setColor(rs.getString("Color"));
                    item.setNumberofseats(rs.getInt("Numberofseats"));
                    item.setNumberplate(rs.getString("Numberplate"));
                    item.setBrand(rs.getString("Brand"));
                    item.setYearofmanufacture(rs.getString("Yearofmanufacture"));
                    item.setPrice(rs.getDouble("Price"));
                    item.setTax(rs.getInt("Tax"));
                    item.setHaveinsurancecar(rs.getBoolean("Haveinsurancecar"));
                    item.setUsername(rs.getString("Username"));
                    item.setEngine(rs.getString("Engine"));
                    item.setGear(rs.getString("Gear"));
                    item.setFuel(rs.getString("Fuel"));
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
            Connection conn = ConnectionDB.getConnection();
//            PreparedStatement pre= conn.prepareStatement(sql);
//            pre.setString(1,String.valueOf(have));
//            ResultSet rs=pre.executeQuery();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Car item = new Car();
                    item.setNamecar(rs.getString("Namecar"));
                    item.setCartype(rs.getString("Cartype"));
                    item.setColor(rs.getString("Color"));
                    item.setNumberofseats(rs.getInt("Numberofseats"));
                    item.setNumberplate(rs.getString("Numberplate"));
                    item.setBrand(rs.getString("Brand"));
                    item.setYearofmanufacture(rs.getString("Yearofmanufacture"));
                    item.setPrice(rs.getDouble("Price"));
                    item.setTax(rs.getInt("Tax"));
                    item.setHaveinsurancecar(rs.getBoolean("Haveinsurancecar"));
                    item.setUsername(rs.getString("Username"));
                    item.setEngine(rs.getString("Engine"));
                    item.setGear(rs.getString("Gear"));
                    item.setFuel(rs.getString("Fuel"));

                    ListCar.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListCar;
    }

    public List<Car> getlistcarPrice() {
        List<Car> ListCar = new ArrayList<>();
        String sql = "select price,DateBuy from car where MONTH(DateBuy) group by MONTH(DateBuy)";
        try {
            Connection conn = ConnectionDB.getConnection();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Car item = new Car();
                    item.setPrice(rs.getDouble("Price"));
                    item.setDateBuy(rs.getString("DateBuy"));

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
        String sql = "select NumberPlate from car";
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

    public boolean addCar(Car item) {
        if (this.isExisting(item) == false) {
            return true;
        }
        String sql = "insert into car( ";
        sql += " Namecar,Cartype,Color,Numberofseats,NumberPlate,Brand,Yearofmanufacture,Price,Tax,Haveinsurancecar,Username,Engine,Gear,Fuel ) ";
        sql += "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setString(1,item.getNamecar());
            pre.setString(2,item.getCartype());
            pre.setString(3,item.getColor());
            pre.setInt(4,item.getNumberofseats());
            pre.setString(5,item.getNumberplate());
            pre.setString(6,item.getBrand());
            pre.setString(7,item.getYearofmanufacture());
            pre.setDouble(8,item.getPrice());
            pre.setInt(9,item.getTax());
            pre.setBoolean(10,item.isHaveinsurancecar());
            pre.setString(11, item.getUsername());
            pre.setString(12, item.getEngine());
            pre.setString(13, item.getGear());
            pre.setString(14, item.getFuel());

            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            //check=false;
        }
        return false;
    }

    public boolean updateCar(Car  item) {
        String sql = "update car set Namecar=?,Cartype=?,Color=?,Numberofseats=?,Brand=?,Yearofmanufacture=?,Price=?,Tax=?,Haveinsurancecar=?,Username=?,Engine=?,Gear=?,Fuel=? where Numberplate=?";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setString(1, item.getNamecar());
            pre.setString(2,item.getCartype());
            pre.setString(3,item.getColor());
            pre.setInt(4,item.getNumberofseats());
            pre.setString(5,item.getBrand());
            pre.setString(6,item.getYearofmanufacture());
            pre.setDouble(7,item.getPrice());
            pre.setInt(8,item.getTax());
            pre.setBoolean(9,item.isHaveinsurancecar());
            pre.setString(10, item.getUsername());
            pre.setString(11, item.getEngine());
            pre.setString(12, item.getGear());
            pre.setString(13, item.getFuel());

            pre.setString(14, item.getNumberplate());

            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatehave(String num) {
        String sql = "update car set Haveinsurance=1 where NumberPlate=?";
        try {
            Connection conn = ConnectionDB.getConnection();
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
        String sql = "delete from car where Numberplate = ? ";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, item.getNumberplate());

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
    private boolean isExisting(InsuranceCar item) {
        boolean flag = false;
        String sql = "select IDInsurance from InsuranceCar";
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
    public boolean addInsu(InsuranceCar item) {
        if (this.isExisting(item) == false) {
            return true;
        }
        String sql = "insert into InsuranceCar( ";
        sql += "IDInsurance,NumberPlate) ";
        sql += "values(?,?)";

        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            //truyá»�n giÃ¡ trá»‹ cho cac tham sá»‘
            pre.setInt(1, item.getIDinsurance());
            pre.setString(2, item.getNumberplate());
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
            Connection conn = ConnectionDB.getConnection();
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
