/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jake
 */
public class DailyPlanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ParseFile csv = new ParseFile("foods.csv");
        csv.openFile();
    }
    
}
