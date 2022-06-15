package logic;

import structures.ACar;
import structures.Constants;
import structures.ElectricCar;
import structures.GasCar;
import structures.HybridCar;

public class Parser {
    
    public static ACar getCarFromString(String row) {
        
        int index = row.indexOf(" ");
        String beginWith = row.substring(0, index);
        row = row.substring(index + 1);
        
        switch(beginWith) {
        case Constants.ELECTRIC_CAR : return createElectricCar(row);
        case Constants.GAS_CAR : return createGasCar(row);
        case Constants.HYBRID_CAR : return createHybridCar(row);
            default : return null;
        }
        
    } 
    
    private static ElectricCar createElectricCar(String data) {
        String[] parts = data.split(", ");
        String brand = parts[0];
        String model = parts[1];
        int powEng = Integer.parseInt(parts[2].substring(0, parts[2].length()-2));
        int capacity = Integer.parseInt(parts[3].substring(0, parts[3].length()-2));
        int price = Integer.parseInt(parts[4].substring(0, parts[4].length()-5));
        
        return new ElectricCar(brand, model, powEng, capacity, price);
    }
    
    private static GasCar createGasCar(String data) {
        String[] parts = data.split(", ");
        String brand = parts[0];
        String model = parts[1];
        float engDis = Float.parseFloat(parts[2].substring(0, parts[2].length()-1));
        int powEng = Integer.parseInt(parts[3].substring(0, parts[3].length()-2));
        int price = Integer.parseInt(parts[4].substring(0, parts[4].length()-5));
        
        return new GasCar(brand, model, engDis, powEng, price);
    }
    
    private static HybridCar createHybridCar(String data) {
        String[] parts = data.split(", ");
        String brand = parts[0];
        String model = parts[1];
        float engDis = Float.parseFloat(parts[2].substring(0, parts[2].length()-1));
        int powEng = Integer.parseInt(parts[3].substring(0, parts[3].length()-2));
        int capacity = Integer.parseInt(parts[4].substring(0, parts[4].length()-2));
        int price = Integer.parseInt(parts[5].substring(0, parts[5].length()-5));
        
        return new HybridCar(brand, model, engDis, powEng, capacity, price);
    }

}//end class

