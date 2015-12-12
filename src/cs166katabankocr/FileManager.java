/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs166katabankocr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Justine Francis
 */
public class FileManager {
    
    public ArrayList<String> readFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        ArrayList<String> content = new ArrayList();
        try (BufferedReader br = new BufferedReader(fr)) {
            String temp;
            while((temp = br.readLine()) != null) {
                content.add(temp);
            }
        }
        return content;
    }    
    
    public void fileWrite(ArrayList<String> outputs) throws IOException{
        File file = new File("output.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)){
            for(String s : outputs){
                bw.write(s);
                bw.newLine();
            }
        }
    }
}
