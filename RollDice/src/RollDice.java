/*
 * @author J.A. Simmons V
 * @version 1.0 17Nov2009
 * 
 * A simple app that will roll two dice and display the dice and the result number.
 * The appication uses an array for the images of the dice, and an array for the 
 * sounds of dice rolling, and a dissapointed moan when 7s are rolled.
 */
import javax.swing.JFrame;

public class RollDice {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		MainFrame frame1 = new MainFrame();
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize( 400, 300);
		frame1.setVisible(true);

	}

}
