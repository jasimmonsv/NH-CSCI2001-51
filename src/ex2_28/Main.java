/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ex2_28;

import java.util.Scanner; //program uses class Scanner

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in ); //create scanner to obtain input from command line
        int cirRadius; //User input of Circle Radius

        System.out.print("Enter Circle Radius: "); //prompt
        cirRadius = input.nextInt();

        System.out.printf("Circle Diameter is %.2f\n", cirRadius*2.0 ); //Forced float point number with 2.0 as constant.
        System.out.printf("Circle Circumference is %.2f\n", cirRadius*2*Math.PI);
        System.out.printf("Circle Area is %.2f\n", cirRadius*Math.PI*cirRadius);
    }//end method Main

}// End class Main
