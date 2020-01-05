package Entity;

public class InsuranceCar {
    private int IDInsurance;
    private String NumberPlate;

    public InsuranceCar() {
    }

    public InsuranceCar(int IDInsurance, String numberPlate) {
        this.IDInsurance = IDInsurance;
        NumberPlate = numberPlate;
    }

    public int getIDInsurance() {
        return IDInsurance;
    }

    public void setIDInsurance(int IDInsurance) {
        this.IDInsurance = IDInsurance;
    }

    public String getNumberPlate() {
        return NumberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        NumberPlate = numberPlate;
    }
}
