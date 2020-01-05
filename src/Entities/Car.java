package Entities;

import java.util.Random;

public class Car {
    private String Namecar;
    private String Cartype;
    private String Color;
    private int Numberofseats;
    private String Numberplate;
    private String Brand;
    private String Yearofmanufacture;
    private double Price;
    private int Tax;
    private boolean Haveinsurancecar;
    private String Username;
    private String engine;
    private String gear;
    private String fuel;
    private String DateBuy;

    public Car() {
    }
    public Car(String num){
        Numberplate=num;
    }

    public Car(String namecar, String cartype, String color, int numberofseats, String brand, String yearofmanufacture, double price, int tax, boolean haveinsurancecar, String username, String engine, String gear, String fuel) {
        Namecar = namecar;
        Cartype = cartype;
        Color = color;
        Numberofseats = numberofseats;
        Brand = brand;
        Yearofmanufacture = yearofmanufacture;
        Price = price;
        Tax = tax;
        Haveinsurancecar = haveinsurancecar;
        Username = username;
        this.engine = engine;
        this.gear = gear;
        this.fuel = fuel;
    }

    public Car(String namecar, String cartype, String color, int numberofseats, String numberplate, String brand, String yearofmanufacture, double price, int tax, boolean haveinsurancecar, String username, String engine, String gear, String fuel) {
        Namecar = namecar;
        Cartype = cartype;
        Color = color;
        Numberofseats = numberofseats;
        Numberplate = numberplate;
        Brand = brand;
        Yearofmanufacture = yearofmanufacture;
        Price = price;
        Tax = tax;
        Haveinsurancecar = haveinsurancecar;
        Username = username;
        this.engine = engine;
        this.gear = gear;
        this.fuel = fuel;
    }

    public String getNamecar() {
        return Namecar;
    }

    public void setNamecar(String namecar) {
        Namecar = namecar;
    }

    public String getCartype() {
        return Cartype;
    }

    public void setCartype(String cartype) {
        Cartype = cartype;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getNumberofseats() {
        return Numberofseats;
    }

    public void setNumberofseats(int numberofseats) {
        Numberofseats = numberofseats;
    }

    public String getNumberplate() {
        return Numberplate;
    }

    public void setNumberplate(String numberplate) {
        Numberplate = numberplate;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getYearofmanufacture() {
        return Yearofmanufacture;
    }

    public void setYearofmanufacture(String yearofmanufacture) {
        Yearofmanufacture = yearofmanufacture;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getTax() {
        return Tax;
    }

    public void setTax(int tax) {
        Tax = tax;
    }

    public boolean isHaveinsurancecar() {
        return Haveinsurancecar;
    }

    public void setHaveinsurancecar(boolean haveinsurancecar) {
        Haveinsurancecar = haveinsurancecar;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getDateBuy() {
        return DateBuy;
    }

    public void setDateBuy(String dateBuy) {
        DateBuy = dateBuy;
    }

    public String brand() {
        String s = null;
        String[] Brandarr = new String[]{"TOYOTA", "BMW", "HYUDAI","VINFAT","HONDA","MERCEDES","LANCIA","JAGUAR","SUBARU","KOENIGSEGG","AUDI","LAMBORGHINI","FORD","FERRARI"};
        Random rd = new Random();
        //hang sx
        return this.Brand = Brandarr[rd.nextInt(Brandarr.length)];
    }
    public String color(){
        String s=null;
        String[] color= new String[]{"RED","YELLOW","BLACK","GRAY","BLUE","BROWN","WHITE","GREEN","VIOLET","PINK","ORANGE"};
        Random rd= new Random();
        return this.Color= color[rd.nextInt(color.length)];
    }
    public int year(){
        Random rd = new Random();
        //nam san xuat
        return 1980+rd.nextInt(2012-1980);
    }
    public Boolean have(){
        Random rd = new Random();
        //tinh trang bao hiem
        return this.Haveinsurancecar = rd.nextBoolean();
    }
    public String numberplate(){
        Random rd = new Random();
        //bien so
        final String NP = "0123456789ABCDEFGHIJKLNMOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i <= 4; i++) {
            sb.append(NP.charAt(rd.nextInt(NP.length())));
        }
        return this.Numberplate= sb.toString();
    }

    public String phanloai(int Yearofmanufacture) {
        if (Yearofmanufacture >= 2005) {
            return "Modern Car";
        } else if (1996 < Yearofmanufacture && Yearofmanufacture < 2004) {
            return "Medium Car";
        } else {
            return "Old Car";
        }
    }

    public String phanloaipk(int Yearofmanufacture) {
        if (Yearofmanufacture >= 2005) {
            return "A";
        } else if (1996 < Yearofmanufacture && Yearofmanufacture < 2004) {
            return "B";
        } else {
            return "C";
        }
    }

    public String phanloaipackage(String Package) {
        if (Package.equals("A")) {
            return "Xe doi moi(Modern Car)";
        } else if (Package.equals("B")) {
            return "Xe doi trung(Medium Car)";
        } else {
            return "Xe doi cu (Old Car)";
        }
    }

    public int randomYearlh() {
        Random random = new Random();
        return 5 + random.nextInt(20 - 5);
    }

    public String Note(boolean note) {
        if (note == true) {
            return "Da dang ki";
        } else {
            return "Chua dang ki";
        }
    }
}
