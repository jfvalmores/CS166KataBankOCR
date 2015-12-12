/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs166katabankocr;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Justine Francis
 */
public class CS166KataBankOCR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileManager fm = new FileManager();
        EntryParser ep = new EntryParser();
        
        ArrayList<String> array = fm.readFile("input.txt");
        ep.parseEntries(array);
        System.out.println(ep.parseEntries(array));
        
        fm.fileWrite(ep.parseEntries(array));
    }
    
}
