package program;

import logic.FileOperations;
import structures.Catalogue;

public class MainClass {

    public static void main(String[] args) {
        
        Catalogue cat = new Catalogue("C:\\Users\\admin\\Desktop");
        cat.printCatalogue();
        
        FileOperations.writeToFile("C:\\Users\\admin\\Desktop", cat);
    }

}
