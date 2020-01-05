package Entity;

import java.util.Random;

public class Car {
    private String NumberPlate;
    private int Yearofmanufacture;
    private String Brand;
    private boolean HaveInsurance;
    private String Email;
    private String Status;
    private double Price;
    private int Number;
   // private String NameCar;

    public Car() {
    }

    public Car(boolean haveInsurance){
        HaveInsurance=haveInsurance;
    }
    
    public Car(String NumberPlate,int Yearofmanufacture,String Brand, boolean HaveInsurance,String Email,String Status, double Price,int Number) {
    	this.NumberPlate=NumberPlate;
    	this.Yearofmanufacture=Yearofmanufacture;
    	this.Brand=Brand;
    	this.HaveInsurance=HaveInsurance;
    	this.Email=Email;
    	this.Status=Status;
    	this.Price=Price;
    	this.Number=Number;
    }
    public String getNumberPlate() {
		return NumberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		NumberPlate = numberPlate;
	}

	public int getYearofmanufacture() {
		return Yearofmanufacture;
	}

	public void setYearofmanufacture(int yearofmanufacture) {
		Yearofmanufacture = yearofmanufacture;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public boolean isHaveInsurance() {
		return HaveInsurance;
	}

	public void setHaveInsurance(boolean haveInsurance) {
		HaveInsurance = haveInsurance;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	@Override
    public String toString() {
        return "Car{" +
                "NumberPlate='" + NumberPlate + '\'' +
                ", Yearofmanufacture=" + Yearofmanufacture +
                ", Brand='" + Brand + '\'' +
                ", HaveInsurance=" + HaveInsurance +
                ", Email='" + Email + '\'' +
                ", Status='" + Status + '\'' +
                ", Price='" + Price + '\'' +
                ", Number='" + Number + '\'' +
                '}';
    }

    public String brand() {
        String s = null;
        String[] Brandarr = new String[]{"TOYOTA", "BMW", "HUYNDAI"};
        Random rd = new Random();
        //hÃ£ng sx
        return this.Brand = Brandarr[rd.nextInt(Brandarr.length)];
    }
    public int year(){
        Random rd = new Random();
        //nÄƒm
        return 1980+rd.nextInt(2012-1980);
    }
    public Boolean have(){
        Random rd = new Random();
        //báº£o hiá»ƒm
        return this.HaveInsurance = rd.nextBoolean();
    }
    public String numberplate(){
        Random rd = new Random();

        //biá»ƒn sá»‘
        final String NP = "0123456789ABCDEFGHIJKLNMOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i <= 4; i++) {
            sb.append(NP.charAt(rd.nextInt(NP.length())));
        }
        return this.NumberPlate= sb.toString();
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
            return "Xe đời mới(Modern Car)";
        } else if (Package.equals("B")) {
            return "Xe đời trung(Medium Car)";
        } else {
            return "Xe đời cũ(Old Car)";
        }
    }

    public int randomYearlh() {
        Random random = new Random();
        return 5 + random.nextInt(20 - 5);
    }

    public String Note(boolean note) {
        if (note == true) {
            return "Ä�Ã£ Ä‘Äƒng kÃ­";
        } else {
            return "ChÆ°a Ä‘Äƒng kÃ­";
        }
    }
}
