package structures;

public abstract class ACar {
    
    private String brand;
    private String model;
    private int powEngine;
    private int price;
    
    public ACar(String brand, String model, int powEngine, int price) {
        this.brand = brand;
        this.model = model;
        this.powEngine = powEngine;
        this.price = price;
    }
    
    public String printCarStrBuilder(String middle) {
        
        StringBuilder str = new StringBuilder();
        str.append(this.brand);
        str.append(", ");
        str.append(this.model);
        str.append(", ");
        str.append(middle);
        str.append(", ");
        str.append(this.price);
        str.append(" euro");
        
        return str.toString();
    }
    
    public String printCarStrFormat(String middle) {
        
        return String.format("%s, %s, %s, %d euro",this.brand,this.model, middle, this.price);
        
    }
    
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getPowEngine() {
        return powEngine;
    }
    public void setPowEngine(int powEngine) {
        this.powEngine = powEngine;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
     
}

