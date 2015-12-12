/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs166katabankocr;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Justine Francis
 */
public class EntryParserTest {
    
    public EntryParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLines method, of class EntryParser.
     */
    @Test
    public void testGetLines() throws IOException {
        System.out.println("getLines");
        
        FileManager fm = new FileManager();
        ArrayList<String> instance = fm.readFile("input.txt");
        
        EntryParser ep = new EntryParser();
        ep.getLines(instance);
        System.out.println(ep.line1);
        System.out.println(ep.line2);
        System.out.println(ep.line3);
        
        assertEquals("    _  _     _  _  _  _  _", ep.line1);
        assertEquals("  | _| _||_||_ |_   ||_||_|", ep.line2);
        assertEquals("  ||_  _|  | _||_|  ||_| _|", ep.line3);
        
    }
    
    @Test
    public void testGenerateOne(){
        EntryParser ep = new EntryParser();
        
        String top = "   ";
        String mid = "  |";
        String bot = "  |";
        
        assertEquals("1", ep.generateNumber(top, mid, bot));
        
    }
    
    @Test
    public void testGenerateTwo(){
        EntryParser ep = new EntryParser();
        
        String top = " _ ";
        String mid = " _|";
        String bot = "|_ ";
        
        assertEquals("2", ep.generateNumber(top, mid, bot));
    }
    
    @Test
    public void testGenerateThree(){
        EntryParser ep = new EntryParser();
        
        String top = " _ ";
        String mid = " _|";
        String bot = " _|";
        
        assertEquals("3", ep.generateNumber(top, mid, bot));
    }
    
    @Test
    public void testGenerateFour(){
        EntryParser ep = new EntryParser();
        
        String top = "   ";
        String mid = "|_|";
        String bot = "  |";
        
        assertEquals("4", ep.generateNumber(top, mid, bot));
    }
    
    @Test
    public void testGenerateFive(){
        EntryParser ep = new EntryParser();
        
        String top = " _ ";
        String mid = "|_ ";
        String bot = " _|";
        
        assertEquals("5", ep.generateNumber(top, mid, bot));
    }
    
    
    @Test
    public void testGenerateSix(){
        EntryParser ep = new EntryParser();
        
        String top = " _ ";
        String mid = "|_ ";
        String bot = "|_|";
        
        assertEquals("6", ep.generateNumber(top, mid, bot));
    }
    
    @Test
    public void testGenerateSeven(){
        EntryParser ep = new EntryParser();
        
        String top = " _ ";
        String mid = "  |";
        String bot = "  |";
        
        assertEquals("7", ep.generateNumber(top, mid, bot));
    }
    
    @Test
    public void testGenerateEight(){
        EntryParser ep = new EntryParser();
        
        String top = " _ ";
        String mid = "|_|";
        String bot = "|_|";
        
        assertEquals("8", ep.generateNumber(top, mid, bot));
    }
    
    @Test
    public void testGenerateNine(){
        EntryParser ep = new EntryParser();
        
        String top = " _ ";
        String mid = "|_|";
        String bot = " _|";
        
        assertEquals("9", ep.generateNumber(top, mid, bot));
    }
    
    @Test
    public void testGenerateZero(){
        EntryParser ep = new EntryParser();
        
        String top = " _ ";
        String mid = "| |";
        String bot = "|_|";
        
        assertEquals("0", ep.generateNumber(top, mid, bot));
    }
    
    @Test
    public void testParseDigits(){
        EntryParser ep = new EntryParser();
        String top = "    _  _     _  _  _  _  _";
        String mid = "  | _| _||_||_ |_   ||_||_|";
        String bot = "  ||_  _|  | _||_|  ||_| _|";
        
        assertEquals("123456789", ep.parseDigits(top, mid, bot));
    }
    
    @Test
    public void testParseEntries() throws IOException{
        FileManager fm = new FileManager();
        EntryParser em = new EntryParser();
        
        ArrayList<String> entries = fm.readFile("input.txt");
        
        ArrayList<String> results = em.parseEntries(entries);
        System.out.println(results);
    }
    
   
    
  
}
