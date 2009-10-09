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
	public static ButtonHandler handler; //Defined at bottom of code
	private static JButton btnSubmit631, btnSubmit635, btnAgain, btnAgainMath; //all buttons on GUI
	public static JPanel mathPane, //panel that holds math game 
						answerMathPane, //panel that holds status messages during math game (exists within mathPane)
						guessPane, //panel that hold the guessing game 
						answerPane, //panel that holds status messages during guessing game (exists within guessPane) 
						guessingBorderPane; //panel to add decorations to guessing game
	private static JLabel quest631, lblMath;
	public static JTextField txtUserGuess,txtMathGuess;
	public static int guessedNum, answerNum, timesGuessed, int1, int2, ans, timesGuessedMath;
	public static ArrayList<JLabel> wrongAnswers;
	private boolean answerRight, answerRightMath;
	private static Random random;
	
	
	//*************CAIMainView Constructor*****************
	public CAIMainView()
	{
		super( "CAI Application"); //sets title of application
		
		//setup components
		handler = new ButtonHandler(); //buttonHandler for actions
		
		//setup Buttons
		btnSubmit631 = new JButton("Submit");
		btnSubmit635 = new JButton("Submit");
		btnAgain = new JButton("Play Again?");
		btnAgainMath = new JButton("Try Again?");

		//setup button Action Listeners
		btnAgain.addActionListener(handler);
		btnSubmit631.addActionListener(handler);
		btnSubmit635.addActionListener(handler);
		btnAgainMath.addActionListener(handler);
		
		//initalize random Method
		random = new Random();
		
		//declare tabbed Pane
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//setupPanels
		guessDisplaySetup(); //call guess game setup method 
		mathDisplaySetup(); //call math game setup method
		
		//add seperate panels to teh tabbed panel
		tabbedPane.addTab("Guessing Game", null, guessPane, "Guessing Game");
		tabbedPane.addTab("Math Game", null, mathPane, "Math Game");

		//add tabbedPanel to the main frame
		add(tabbedPane);
	}//end Constructor */
	
	//setup Display for guessing game -ex6.31
	public static void guessDisplaySetup()
	{		
		answerNum = random.nextInt(1000);
		guessingBorderPane = new JPanel(); //create fancy panel for design
		guessingBorderPane.setLayout(new BorderLayout());
		
		//setup guessDisplay
		guessPane = new JPanel();//Create JPanel to hold guessing game
		answerPane = new JPanel();//Create JPanel to hold answers
		guessPane.setLayout(new FlowLayout());//set guessPanelayout	
		answerPane.setLayout(new BoxLayout(answerPane, BoxLayout.Y_AXIS));//set answerPane layout
		wrongAnswers = new ArrayList<JLabel>(); //ArrayList to hold previous guessed answers
		quest631 = new JLabel("Guess the Number: "); //user instructions
		txtUserGuess = new JTextField(10); //txtField for user to input guess
		
		//add components to the GuessPanel
		guessPane.add(quest631);
		guessPane.add(txtUserGuess);
		guessPane.add(btnSubmit631);
		guessPane.add(answerPane);
	}//end method guessDisplay initial Setup */
	
	//this method will redraw all the components to reflect any changes.
	public static void guessDisplayRedraw()
	{
		guessPane.removeAll();
		//setup components
		txtUserGuess.setText("");//blank out previous guess
		//add changed components back to guessPane
		guessPane.add(quest631);
		guessPane.add(txtUserGuess);
		guessPane.add(btnSubmit631);
		guessPane.add(answerPane);
		
		//validate changes and repaint
		guessPane.validate();
		guessPane.repaint();
	}//end method 631Display */
	
	//this method will redraw the Guessing game for a new round
	public static void guessDisplayRestart()
	{
		//reset all needed variables and re-initalize the random number
		answerNum = random.nextInt(1000); //new number to guess
		//re-initalize all needed variables
		guessPane.removeAll();
		answerPane.removeAll();
		wrongAnswers.clear();
		timesGuessed = 0;
		txtUserGuess.setEditable(true);//reset disabled txtField
		btnSubmit631.setEnabled(true);//reset disabled button
		
		//re-add all changed components to guessPane
		guessPane.add(quest631);
		guessPane.add(txtUserGuess);
		guessPane.add(btnSubmit631);
		guessPane.add(answerPane);
		
		//validate and repaint
		guessPane.validate();
		answerPane.validate();
		guessPane.repaint();
		answerPane.repaint();
	}//end method 631Display */
	

	
	//initalize math game display
	public static void mathDisplaySetup()
	{
		//setup guessDisplay
		mathPane = new JPanel();//Create JPanel that will house math game
		answerMathPane = new JPanel(); // create JPanel that will house status messages (containted within mathPane) 
		//set layouts for both JPanels
		mathPane.setLayout(new FlowLayout());//set layout	
		answerMathPane.setLayout(new BoxLayout(answerMathPane, BoxLayout.Y_AXIS));
		
		//setup and initalize components
		int1 = random.nextInt(100);
		int2 = random.nextInt(100);
		ans=int1*int2;
		txtMathGuess = new JTextField(10);
		
		//setup math question Label
		lblMath = new JLabel("What is " + int1 + " times "+ int2 +" ?");
		
		//add to components to pane
		mathPane.add(lblMath);
		mathPane.add(txtMathGuess);
		mathPane.add(btnSubmit635);
		mathPane.add(answerMathPane);
	}//end method mathDisplaySetup */
	
	//this method will redraw changed componets during the game
	public static void mathDisplayRedraw()
	{
		//setup components
		mathPane.removeAll();
		txtMathGuess.setText("");
		
		//readd changed components to mathPane
		mathPane.add(lblMath);
		mathPane.add(txtMathGuess);
		mathPane.add(btnSubmit635);
		mathPane.add(answerMathPane);
		
		//validate and repaint
		mathPane.validate();
		mathPane.repaint();
	}//end method mathDisplayRedraw */
	
	//this method will restart the math game for a new round.
	public void mathDisplayRestart()
	{	
		//reinitalize components and variables
		mathPane.removeAll();
		answerMathPane.removeAll();
		int1 = random.nextInt(100);
		int2 = random.nextInt(100);
		ans=int1*int2;
		txtMathGuess.setText("");
		txtMathGuess.setEditable(true);
		btnSubmit635.setEnabled(true);
		timesGuessedMath=0;
		lblMath.setText("What is " + int1 + " times "+ int2 +" ?");//reset label with new numbers
		
		//add to components to pane
		mathPane.add(lblMath);
		mathPane.add(txtMathGuess);
		mathPane.add(btnSubmit635);	
		mathPane.add(answerMathPane);
		
		//validate and repaint
		mathPane.validate();
		answerMathPane.validate();
		mathPane.repaint();
		answerMathPane.repaint();
	}//end method MathDisplay Restart */
	
	
	
	//*************************ACTION LISTENER SECTION*******************************
	public class ButtonHandler implements ActionListener
    {
	
            public void  actionPerformed (ActionEvent ae)
            {
            	Object obj = ae.getSource();
        		if (obj == btnSubmit631)
        		{
        			answerRight = CAIController.guessGame( answerNum, Integer.parseInt(txtUserGuess.getText()) );
        			if (answerRight == true)
        			{
        				txtMathGuess.setEditable(false);
        				btnSubmit631.setEnabled(false);
        				answerPane.add(btnAgain);
        				guessDisplayRedraw();
        			}
        			else 
        			{
        				guessDisplayRedraw();        				
        			}
        		}//end btnSubmit631 if statement        		
        		
        		if(obj== btnSubmit635)
        		{
        			answerRightMath = CAIController.mathGame(Integer.parseInt(txtMathGuess.getText()),ans);
        			if (answerRightMath == true)
        			{
        				answerMathPane.add(btnAgainMath);
        				mathDisplayRedraw();
        			}
        			if(answerRightMath == false)mathDisplayRedraw();
        		}//end btnSubmit635 if statement
        		
        		if(obj == btnAgain) guessDisplayRestart(); //restart Guess Game
        		if(obj == btnAgainMath)mathDisplayRestart(); //restart Math Game
            }//end private method actionPerformed
    }//end private class ButtonHandler
	
}//end Class CAIMainView */
