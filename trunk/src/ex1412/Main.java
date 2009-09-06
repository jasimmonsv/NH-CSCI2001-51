package ex1412;

/**
 *
 * @author J.A. Simmons V
 * Class CSci 2001-51
 * Notes: user input is not sanitised
 */
import javax.swing.JOptionPane; //program uses JOptionPane

public class Main {

    public static void main(String[] args)
    {
       //obtain user input from JOption Pane input dialogs
        String fhTemp = JOptionPane.showInputDialog("Enter temperature in Fahrenheit: ");
        int intFhTemp = Integer.parseInt( fhTemp); //Convert string to INT

        int celTemp = (5 * (intFhTemp - 32)/9); //formula converting fahrenheit to celsius
        JOptionPane.showMessageDialog(null, "The temperature in Celsius is: " + celTemp, "Celsius Converted", JOptionPane.PLAIN_MESSAGE);
    }//End method Main

}//End class Main
