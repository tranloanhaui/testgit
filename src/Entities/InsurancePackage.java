package Entities;

import java.util.Random;

public class InsurancePackage {
    private int IDinsurance;
    private String Packagetype;
    private String Cartype;
    private String timelimit;
    private String dateofissue;

    public InsurancePackage() {
    }

    public InsurancePackage(int id) {
        this.IDinsurance=id;
    }

    public InsurancePackage(int IDinsurance, String packagetype, String cartype, String timelimit, String dateofissue) {
        this.IDinsurance = IDinsurance;
        Packagetype = packagetype;
        Cartype = cartype;
        this.timelimit = timelimit;
        this.dateofissue = dateofissue;
    }

    public int getIDinsurance() {
        return IDinsurance;
    }

    public void setIDinsurance(int IDinsurance) {
        this.IDinsurance = IDinsurance;
    }

    public String getPackagetype() {
        return Packagetype;
    }

    public void setPackagetype(String packagetype) {
        Packagetype = packagetype;
    }

    public String getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit;
    }

    public String getDateofissue() {
        return dateofissue;
    }

    public void setDateofissue(String dateofissue) {
        this.dateofissue = dateofissue;
    }

    public String getCartype() {
        return Cartype;
    }

    public void setCartype(String cartype) {
        Cartype = cartype;
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
