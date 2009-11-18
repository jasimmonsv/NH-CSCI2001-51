/**
 * 
 * @author J.A. Simmons V
 * @version 1.0 17Nov2009
 * 
 * This class builds the frame and handles all events
 */
import java.awt.*;
import javax.swing.*;
import sun.audio.AudioPlayer;
import java.awt.event.*;


public class MainFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7145892307744911073L;
	private JLabel lblResult;
	private ButtonHandler handler;
	JPanel pnlCenterPanel, pnlDiceRoll;
	private JButton btnRoll;
	private Dice dice;
	private int dice1, dice2;
	
	//Constructor
	public MainFrame()
	{
	super("Dice Roll");
	handler = new ButtonHandler();
	setLayout( new BorderLayout() );//setBorderLayout
	
	//initalize components
	dice = new Dice();
	pnlCenterPanel = new JPanel();
	pnlCenterPanel.setLayout( new BorderLayout() );
	pnlDiceRoll = new JPanel();
	pnlDiceRoll.setLayout( new GridLayout() );
	JLabel lblTitle = new JLabel("Dice Roll", JLabel.CENTER);
	lblResult = new JLabel("2", JLabel.CENTER);
	btnRoll = new JButton("Roll!");
	btnRoll.addActionListener(handler);
	
	//add components to frame and Panels
	add( lblTitle, BorderLayout.NORTH );
	add( btnRoll, BorderLayout.SOUTH );
	add( pnlCenterPanel, BorderLayout.CENTER );
	pnlCenterPanel.add( lblResult, BorderLayout.SOUTH );
	pnlCenterPanel.add( pnlDiceRoll, BorderLayout.CENTER );
	pnlDiceRoll.add( new JLabel( dice.getFace( 1 ) ) );
	pnlDiceRoll.add( new JLabel( dice.getFace( 1 ) ) );
	
	}//end Constructor
	
	/**
	 * This method sets the rolldice and 
	 */
	private void rollDice()
	{
		//initialize	
		dice1 = dice.rollDice();
		dice2 = dice.rollDice();
		//remove all from panels
		pnlDiceRoll.removeAll();
		//rebuild
		dice.getFace(dice1);
		dice.getFace(dice2);
		lblResult.setText(Integer.toString(dice1+dice2));
		pnlDiceRoll.add( new JLabel( dice.getFace( dice1 ) ) );
		pnlDiceRoll.add( new JLabel( dice.getFace( dice2 ) ) );
		//validate and repaint
		pnlDiceRoll.validate();
		pnlDiceRoll.repaint();
	}//end method rollDice */
	
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent ae) 
		{
			Object obj = ae.getSource();
			if (obj == btnRoll)
				try
				{
					AudioPlayer.player.start(dice.getSound(0));
					
				}//end try block
				catch(Exception exception)
				{
					exception.printStackTrace();
				}//end catch
				for (int i =0;i<50000;i++)
				{
					for (int j=0;j < 70000;j++);
				}
				rollDice();		
				if (dice1+dice2 == 7)
					{
					try{
						AudioPlayer.player.start(dice.getSound(1));
					}
					catch(Exception exception){}
					}
			
		}//end method actionPerformed */
		
	}//end anonymous class ButtonHandler */

}//end Class MainFrame
