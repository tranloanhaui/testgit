package Entity;

import java.util.Random;

public class InsurancePackage {
    private int IDInsurance;
    private String Packagetype;
    private String CarType;
    private String namePackage;

    public InsurancePackage() {
    }

    public InsurancePackage(int IDInsurance, String packagetype, String carType, String namePackage) {
        this.IDInsurance = IDInsurance;
        Packagetype = packagetype;
        CarType = carType;
        this.namePackage=namePackage;

    }

    public InsurancePackage(String packagetype, String carType) {
        Packagetype = packagetype;
        CarType = carType;
    }

    public InsurancePackage(int IDInsurance) {
        this.IDInsurance = IDInsurance;
    }

    public int getIDInsurance() {
        return IDInsurance;
    }

    public void setIDInsurance(int IDInsurance) {
        this.IDInsurance = IDInsurance;
    }

    public String getPackagetype() {
        return Packagetype;
    }

    public void setPackagetype(String packagetype) {
        Packagetype = packagetype;
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String carType) {
        CarType = carType;
    }

    public String getNamePackage() {
        return namePackage;
    }

    public void setNamePackage(String namePackage) {
        this.namePackage = namePackage;
    }

    @Override
    public String toString() {
        return "InsurancePackage{" +
                "IDInsurance=" + IDInsurance +
                ", Packagetype='" + Packagetype + '\'' +
                ", CarType='" + CarType + '\'' +
                '}';
    }

    public String randomPackage() {
        Random rd = new Random();
        String[] arrpk = new String[]{"A", "B", "C"};
        int number = rd.nextInt(arrpk.length);
        return arrpk[number];
    }

    public String rdpk(String ID) {

        if (ID.equals("A")) {
            return "Modern Car";
        } else if (ID.equals("B")) {
            return "Medium Car";
        } else
            return "Old Car";

    }
}
