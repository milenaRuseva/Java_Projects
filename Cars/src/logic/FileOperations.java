package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import structures.Catalogue;

public class FileOperations {
    
    public static ArrayList<String> readFromFileByRow(String path){
        
        ArrayList<String> rows = new ArrayList<>();
        
        try(BufferedReader br = Files.newBufferedReader(Paths.get(path))){
            
            rows = (ArrayList<String>) br.lines().collect(Collectors.toList());
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
        return rows;
        
    } 
    
    public static void writeToFile(String path, Catalogue cat) {
        
        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))){
            
            for(int i = 0; i < cat.getList().size() -1; i++) {
                bw.write(cat.getList().get(i).toString());
                bw.newLine();
            }
            bw.write(cat.getList().get(cat.getList().size()-1).toString());
            bw.flush();
        } catch (IOException e) { 
            e.printStackTrace();
        }
        
    }  
}
