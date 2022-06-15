package structures;

public class HybridCar extends ACar{
    private int capacity;
    private float engDis;
    
    public HybridCar(String brand, String model, float engDis, int powEngine, int capacity, int price) {
        super(brand, model, powEngine, price);
        this.capacity = capacity;
        this.engDis = engDis;
    }
    
    @Override
    public String toString() { 
        String middle =  String.format("%.1fL, %dKW, %dAh", getEngDis(), getPowEngine(), getCapacity());
        return String.format("%s %s", Constants.HYBRID_CAR, printCarStrFormat(middle)); 
    }
    
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public float getEngDis() {
        return engDis;
    }
    public void setEngDis(float engDis) {
        this.engDis = engDis;
    }
}
