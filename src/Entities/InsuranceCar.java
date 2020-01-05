package Entities;

public class InsuranceCar {
    private int IDinsurance;
    private String Numberplate;

    public InsuranceCar() {
    }

    public InsuranceCar(int IDInsurance, String numberPlate) {
        this.IDinsurance = IDInsurance;
        this.Numberplate = numberPlate;
    }

    public int getIDinsurance() {
        return IDinsurance;
    }

    public void setIDinsurance(int IDinsurance) {
        this.IDinsurance = IDinsurance;
    }

    public String getNumberplate() {
        return Numberplate;
    }

    public void setNumberplate(String numberplate) {
        Numberplate = numberplate;
    }
}
