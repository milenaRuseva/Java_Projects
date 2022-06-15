package structures;

public class ElectricCar extends ACar{
private int capacity;
    
    public ElectricCar(String brand, String model, int powEngine, int capacity, int price) {
        super(brand, model, powEngine, price);
        this.capacity = capacity;
    }
    
    @Override
    public String toString() {
        
        String middle =  String.format("%dKW, %dAh", getPowEngine(), getCapacity());
        return String.format("%s %s", Constants.ELECTRIC_CAR, printCarStrBuilder(middle));
        
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
