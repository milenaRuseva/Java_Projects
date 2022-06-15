package structures;

import java.util.ArrayList;
import java.util.Comparator;

import logic.FileOperations;
import logic.Parser;

public class Catalogue {
    
    private ArrayList<ACar> list = new ArrayList<ACar>();
    
    public Catalogue(String path) {
        
        ArrayList<String> stringsFromFile = FileOperations.readFromFileByRow(path);
        for(String row : stringsFromFile) {
            list.add(Parser.getCarFromString(row));
        }
        System.out.println("Loading from file is finished");
    }
    
    
    
    public ArrayList<ACar> getList() {
        return list;
    }



    public void printCatalogue() {
        for(ACar car : list) {
            System.out.println(car);
        }
    }
    
    public void addCar(ACar car) {
        list.add(car);
    }
    
    public void sortByBrand() {
        Comparator<ACar> sortByBrand = (ACar one, ACar two) -> one.getBrand().compareTo(two.getBrand());
        list.sort(sortByBrand); 
    }

}
