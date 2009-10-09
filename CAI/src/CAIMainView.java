/**
 *  
* @(#)CAIMainView.java 
* 
* @author J.A. Simmons V
* @version 1.00 7Oct2009 
* 
* CSci 2001 01 Fall 2009 
* 
*/
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

public class CAIMainView extends JFrame implements ActionListener
{
	/**
	 * @param args
	 */
	private static final long serialVersionUID = -2096621244652611235L;
	
	//Declarations
	public static ButtonHandler handler;
	private static JButton btnSubmit631, btnSubmit635, btnAgain;
	public static JPanel mathPane, guessPane, answerPane, borderPane;
	private static JLabel quest631, lblMath;
	private static JTextField userGuess,mathGuess;
	public static int guessedNum, answerNum, timesGuessed, int1, int2, ans;
	public static ArrayList<JLabel> wrongAnswers;
	private boolean answerRight;
	private static Random random;
	
	
	//*************CAIMainView Constructor*****************
	public CAIMainView()
	{
		super( "CAI Application");
		handler = new ButtonHandler();
		//setup Buttons
		//setup components
		random = new Random();
		btnSubmit631 = new JButton("Submit");
		btnSubmit635 = new JButton("Submit");
		btnAgain = new JButton("Play Again?");
		btnAgain.addActionListener(handler);
		btnSubmit631.addActionListener(handler);
		btnSubmit635.addActionListener(handler);
		
		JTabbedPane tabbedPane = new JTabbedPane();//create JTabbedPane
		
		//setupPanels
		guessDisplaySetup();
		mathDisplaySetup();
		tabbedPane.addTab("Guessing Game", null, guessPane, "Guessing Game");
		tabbedPane.addTab("Math Game", null, mathPane, "Math Game");
		add(tabbedPane);
	}//end Constructor */
	
	//setup Display for guessing game -ex6.31
	public static void guessDisplaySetup()
	{		
		answerNum = random.nextInt(1000);
		borderPane = new JPanel(); //create fancy panel for design
		borderPane.setLayout(new BorderLayout());
		//setup guessDisplay
		guessPane = new JPanel();//Create JPanel
		answerPane = new JPanel();//Create JPanel to hold answers
		guessPane.removeAll();
		answerPane.removeAll();
		guessPane.setLayout(new FlowLayout());//set guessPanelayout	
		answerPane.setLayout(new BoxLayout(answerPane, BoxLayout.Y_AXIS));//set answerPane layout
		wrongAnswers = new ArrayList<JLabel>();
		quest631 = new JLabel("Guess the Number: ");
		userGuess = new JTextField(10);
		guessPane.add(quest631);
		guessPane.add(userGuess);
		guessPane.add(btnSubmit631);
		guessPane.add(answerPane);
		guessPane.validate();
		guessPane.repaint();
		answerPane.validate();
		answerPane.repaint();
	}//end method 631Display */
	
	public static void guessDisplayRestart()
	{
		//reset all needed variables and re-initalize the random number
		Random random = new Random();
		answerNum = random.nextInt(1000);
		guessPane.removeAll();
		answerPane.removeAll();
		wrongAnswers.clear();
		timesGuessed = 0;
		//setup guessPane
		guessPane.add(quest631);
		guessPane.add(userGuess);
		guessPane.add(btnSubmit631);
		guessPane.add(answerPane);
		guessPane.validate();
		answerPane.validate();
		guessPane.repaint();
		answerPane.repaint();
	}//end method 631Display */
	
	public static void guessDisplayRedraw()
	{
		guessPane.removeAll();
		//setup components
		btnSubmit631 = new JButton("Submit");
		btnSubmit631.addActionListener(handler);
		guessPane.add(quest631);
		guessPane.add(userGuess);
		guessPane.add(btnSubmit631);
		guessPane.add(answerPane);
		guessPane.validate();
		guessPane.repaint();
	}//end method 631Display */
	
	//redraw gussing game Display -ex6.31
	public static void mathDisplaySetup()
	{
		//setup guessDisplay
		mathPane = new JPanel();//Create JPanel
		mathPane.setLayout(new FlowLayout());//set layout	
		//setup components
		int1 = random.nextInt(100);
		int2 = random.nextInt(100);
		ans=int1*int2;
		mathGuess = new JTextField(10);
		btnSubmit635 = new JButton("Submit");
		btnSubmit635.addActionListener(handler);
		lblMath = new JLabel("What is " + int1 + " times "+ int2 +" ?");
		//add to components to pane
		mathPane.add(lblMath);
		mathPane.add(mathGuess);
		mathPane.add(btnSubmit635);
	}//end method mathDisplaySetup */
	
	//to redraw math Display -ex65
	public static void mathDisplayRedraw()
	{
		//setup components
		quest631 = new JLabel("Guess the Number: ");
		guessPane.add(quest631);
	}//end method mathDisplayRedraw */
	
	public void mathDisplayRestart()
	{
		
	}//end method MathDisplay Restart */
	
	
	
	//*************************ACTION LISTENER SECTION*******************************
	public class ButtonHandler implements ActionListener
    {
	
            public void  actionPerformed (ActionEvent ae)
            {
            	Object obj = ae.getSource();
        		if (obj == btnSubmit631)
        		{
        			answerRight = CAIController.guessGame( answerNum, Integer.parseInt(userGuess.getText()) );
        			if (answerRight == true)
        			{
        				answerPane.add(btnAgain);
        				guessDisplayRedraw();
        			}
        			else 
        			{
        				guessDisplayRedraw();        				
        			}
        		}//end btnSubmit631 if statement
        		
        		if(obj == btnAgain)
        		{
        			guessDisplayRestart();
        		}//end btnAgain if statement
        		
        		if(obj== btnSubmit635)
        		{
        			CAIController.mathGame();
        		}//end btnSubmit635 if statement
            }//end private method actionPerformed
    }//end private class ButtonHandler
	
}//end Class CAIMainView */
