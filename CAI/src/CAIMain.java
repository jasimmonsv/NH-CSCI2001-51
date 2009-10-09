/**
 *  
* @(#)CAIMain.java 
* 
* @author J.A. Simmons V
* @version 1.00 7Oct2009 
* 
* CSci 2001 01 Fall 2009 
* 
*/
import javax.swing.*;

public class CAIMain
{
	//Declarations	
	private static final long serialVersionUID = -1467134787061032084L;
	
	public static void main(String[] args) 
	{
		CAIMainView mainFrame = new CAIMainView();
		//create a new frame to hold the panel
		//set the frame to exit when it is closed
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize( 400, 300);// set the size of the frame
		mainFrame.setVisible( true );// make the frame visible
		
	}//end method main */	
}//end class CAIMain */
