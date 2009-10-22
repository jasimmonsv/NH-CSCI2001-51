
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class LabelFrame  extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 327343626426356919L;
	private JPanel firstScreen, econDisplay, mainDisplay, controlDisplay, firstClassDisplay;
	private JButton btnFirstClass, btnEconClass, btnFirstScreen;
	private JButton[] seat;
	private ButtonHandler handler;
	private SeatData seatData;
	
	//****** Constructor Method ************
	public LabelFrame()
	{
		//TODO init seating array from outside source(file or database)
		
		super( "Simmons Air Reservation System" );
		handler = new ButtonHandler(); //action handler
		mainDisplay = new JPanel();
		mainDisplay.setLayout( new FlowLayout() );
		seatData = new SeatData();
		setLayout( new FlowLayout() );//set frame layout
		btnFirstScreen = new JButton("Return");
		btnFirstScreen.addActionListener(handler);
		initFirstScreen(); //initalize JPanel that will be welcome screen
		initEconDisplay(); //initalize econDisplay Panel
		initFirstClassDisplay(); //initalizes firstClass Display Panel
		
		mainDisplay.add( firstScreen );
		add(mainDisplay); //add firstScreen panel to the JFrame
		
	}//end constructor method
	
	private void initFirstScreen()
	{		
		firstScreen = new JPanel();
		firstScreen.setLayout( new BorderLayout() );//set frame layout
		
		JPanel btnPanel = new JPanel();//create panel component to hold seat selection buttons
		btnPanel.setLayout( new BoxLayout(btnPanel, BoxLayout.Y_AXIS) );
		Icon companyLogo = new ImageIcon( getClass().getResource( "./SimmonsAirLogo.jpg"));//retrieve companyLogo
		JLabel lblAirLogo = new JLabel( companyLogo ); //Save logo to JLabel
		//setup buttons
		//TODO setup Graphic Buttons
		btnFirstClass = new JButton( "First Class" );
		btnEconClass = new JButton( "Econ Class" );
		//add listeners
		btnFirstClass.addActionListener( handler );
		btnEconClass.addActionListener( handler );
		
		//add buttons to btnPanel
		btnPanel.add(Box.createRigidArea( new Dimension(12,8)));
		btnPanel.add( btnFirstClass );
		btnPanel.add(Box.createRigidArea( new Dimension(12,8)));
		btnPanel.add( btnEconClass );
		
		//add components to frame
		firstScreen.add( lblAirLogo, BorderLayout.CENTER);
		firstScreen.add( btnPanel, BorderLayout.EAST );
	}//end init method */
	
	public void repaintFirstScreen()
	{
		mainDisplay.removeAll();
		mainDisplay.add(firstScreen);
		mainDisplay.validate();
		mainDisplay.repaint();
	}//end repaintFirstScreen */
	
	public void initFirstClassDisplay()
	{
		checkFirstClassSeats();
		if (!SeatData.vacantSeatsExistFirstClass())
		{
			String[] options = { "Yes", "No" };
			int n = JOptionPane.showOptionDialog(AirlineTicketSystem.labelFrame, "There are no seats available in First Class. Would you like to check Economy Class?", "Seats unavailable", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Yes" );
			if (n==0) JOptionPane.showMessageDialog(AirlineTicketSystem.labelFrame, "n=0");
			if (n==1) JOptionPane.showMessageDialog(AirlineTicketSystem.labelFrame, "n=1");
			if (n==-1) JOptionPane.showMessageDialog(AirlineTicketSystem.labelFrame, "n=-1");
		}
		seat = new JButton[10]; //init JButton array
		//init EconDisplay
		firstClassDisplay = new JPanel();
		firstClassDisplay.setLayout(new BorderLayout() );
		
		//setup left side aircraftDisplay panel
		JPanel aircraftDisplay = new JPanel();
		aircraftDisplay.setLayout(new GridLayout(6 , 2));
		//grab graphic for seats
		Icon icoEmptySeat = new ImageIcon( getClass().getResource( "./emptySeat.jpg"));//retrieve emptySeat Graphic

		//loop through all the seats in SeatData
		for (int i = 0; i < 10; i++)
		{
			if (i == 4 || i == 9) aircraftDisplay.add(new JLabel("Restroom")); //add breakers for seperating first and econ classes
			if (SeatData.flightSeat[i]==true) 
			{
				seat[i] = new JButton(icoEmptySeat);
				seat[i].setEnabled(false); //if seat is already occupied disable the button
			}//end if
			else {seat[i] = new JButton(icoEmptySeat);}//ortherwise add the button as usual
			seat[i].addActionListener(handler); //add handler
			if (i>4) seat[i].setEnabled(false); //Disable Econ Class seats
			aircraftDisplay.add(seat[i]);//add seat to aircraft display panel
		}//end for loop
		
		//setup controlDisplay panel on right
		setupControlDisplay();
		
		//add panels to main econDisplay panel
		firstClassDisplay.add( aircraftDisplay, BorderLayout.CENTER );
		firstClassDisplay.add( controlDisplay, BorderLayout.EAST );
	}//end setupFirstClassDisplay method */
	
	public void repaintFirstClassScreen()
	{
		if (checkFirstClassSeats())
		{
		mainDisplay.removeAll();
		firstClassDisplay.removeAll();
		JPanel aircraftDisplay = new JPanel();
		aircraftDisplay.setLayout(new GridLayout(6 , 2));
		//grap graphics for seats
		Icon icoEmptySeat = new ImageIcon( getClass().getResource( "./emptySeat.jpg"));//retrieve emptySeat Graphic

		seat = new JButton[10];
		for (int i = 0; i < 10; i++)
		{
			if (i == 4 || i == 9) aircraftDisplay.add(new JLabel("Restroom"));
			if (SeatData.flightSeat[i]==true)
				{
				seat[i] = new JButton(icoEmptySeat);
				seat[i].setEnabled(false);
				}
			else seat[i] = new JButton(icoEmptySeat);
			seat[i].addActionListener(handler);
			if (i>4) seat[i].setEnabled(false); //Disable Econ Class seats
			aircraftDisplay.add(seat[i]);
		}
		
		//setup controlDisplay panel on right
		setupControlDisplay();
		//add panels to main econDisplay panel
		firstClassDisplay.add( aircraftDisplay, BorderLayout.CENTER );
		firstClassDisplay.add( controlDisplay, BorderLayout.EAST );
		firstClassDisplay.validate();
		firstClassDisplay.repaint();
		}
		else {repaintFirstScreen();}
	}//end repaintFirstClassScreen */
	
	public void initEconDisplay()
	{
		checkEconSeats();
		seat = new JButton[10]; //init JButton array
		//init EconDisplay
		econDisplay = new JPanel();
		econDisplay.setLayout(new BorderLayout() );
		
		//setup left side aircraftDisplay panel
		JPanel aircraftDisplay = new JPanel();
		aircraftDisplay.setLayout(new GridLayout(6 , 2));
		//grab graphic for seats
		Icon icoEmptySeat = new ImageIcon( getClass().getResource( "./emptySeat.jpg"));//retrieve emptySeat Graphic

		//loop through all the seats in SeatData
		for (int i = 0; i < 10; i++)
		{
			if (i == 4 || i == 9) 
				aircraftDisplay.add(new JButton("Restroom")); //add breakers for seperating first and econ classes
			if (SeatData.flightSeat[i]==true) 
			{
				seat[i] = new JButton(icoEmptySeat);
				seat[i].setEnabled(false); //if seat is already occupied disable the button
			}//end if
			else {seat[i] = new JButton(icoEmptySeat);}//ortherwise add the button as usual
			seat[i].addActionListener(handler); //add handler
			if (i<5) seat[i].setEnabled(false); //Disable First Class seats
			aircraftDisplay.add(seat[i]);//add seat to aircraft display panel
		}//end for loop
		
		//setup controlDisplay panel on right
		setupControlDisplay();
		
		//add panels to main econDisplay panel
		econDisplay.add( aircraftDisplay, BorderLayout.CENTER );
		econDisplay.add( controlDisplay, BorderLayout.EAST );
	}//end setupEconDisplay method */
	
	public void setupControlDisplay()
	{
		controlDisplay = new JPanel();
		controlDisplay.setLayout( new FlowLayout() );
		controlDisplay.add(btnFirstScreen);
	}//end setupEconControlDisplay method
	
	private boolean checkEconSeats()
	{
		if (!SeatData.vacantSeatsExistEcon())
		{
			String[] options = { "Yes", "No" };
			int n = JOptionPane.showOptionDialog(AirlineTicketSystem.labelFrame, "There are no seats available in the Economy Class. Would you like to check First Class?", "Seats unavailable", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Yes" );
			//yes = 0 no=1 -1 = canceled 
			if (n==0) 
				{
				return false;
				}
			if (n==1) 
				{JOptionPane.showMessageDialog(AirlineTicketSystem.labelFrame, "Next flight is in 3 hours.");repaintFirstScreen();return false;}
			if (n==-1) 
				{JOptionPane.showMessageDialog(AirlineTicketSystem.labelFrame, "Next flight is in 3 hours");repaintFirstScreen();return false;}
		}
		return true;
	}//end checkEconSeats method */
	
	private boolean checkFirstClassSeats()
	{
		if (!SeatData.vacantSeatsExistFirstClass())
		{
			String[] options = { "Yes", "No" };
			int n = JOptionPane.showOptionDialog(AirlineTicketSystem.labelFrame, "There are no seats available in First Class. Would you like to check Economy Class?", "Seats unavailable", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Yes" );
			//yes = 0 no=1 -1 = canceled 
			if (n==0) return false;
			if (n==1) 
				{JOptionPane.showMessageDialog(AirlineTicketSystem.labelFrame, "Next flight is in 3 hours.");repaintFirstScreen();return false;}
			if (n==-1) 
				{JOptionPane.showMessageDialog(AirlineTicketSystem.labelFrame, "Next flight is in 3 hours");repaintFirstScreen();return false;}
		}
		return true;
	}//end checkFirstClassSeats method */
	
	public void repaintEconScreen()
	{
		
		if (checkEconSeats())
		{
		mainDisplay.removeAll();
		econDisplay.removeAll();
		JPanel aircraftDisplay = new JPanel();
		aircraftDisplay.setLayout(new GridLayout(6 , 2));
		//grap graphics for seats
		Icon icoEmptySeat = new ImageIcon( getClass().getResource( "./emptySeat.jpg"));//retrieve emptySeat Graphic

		seat = new JButton[10];
		for (int i = 0; i < 10; i++)
		{
			if (i == 4 || i == 9) aircraftDisplay.add(new JLabel("Restroom"));
			if (SeatData.flightSeat[i]==true)
				{
				seat[i] = new JButton(icoEmptySeat);
				seat[i].setEnabled(false);
				}
			else seat[i] = new JButton(icoEmptySeat);
			seat[i].addActionListener(handler);
			if (i<5) seat[i].setEnabled(false); //Disable First Class seats
			aircraftDisplay.add(seat[i]);
		}
		
		//setup controlDisplay panel on right
		setupControlDisplay();
		//add panels to main econDisplay panel
		econDisplay.add( aircraftDisplay, BorderLayout.CENTER );
		econDisplay.add( controlDisplay, BorderLayout.EAST );
		econDisplay.validate();
		econDisplay.repaint();
		}//end if
		else {repaintFirstScreen();}
	}//end repaintEconScreen */
	
	//************************
	//************************    Button Handler
	//************************
	private class ButtonHandler implements ActionListener
	{
		public void  actionPerformed (ActionEvent ae)
		{
			Object obj = ae.getSource();
			if (obj == btnFirstScreen)repaintFirstScreen();
			
			if (obj == btnFirstClass)
			{
				mainDisplay.removeAll();
				repaintFirstClassScreen();
				mainDisplay.add(firstClassDisplay);
				mainDisplay.validate();
				mainDisplay.repaint();
			}//end btnFirstClass submit action
			
			if (obj == btnEconClass)
			{
				mainDisplay.removeAll();
				repaintEconScreen();
				mainDisplay.add(econDisplay);
				mainDisplay.validate();
				mainDisplay.repaint();
			}//end btnFirstClass submit action
			
			if (obj == seat[0])
			{
				SeatData.flightSeat[0]=true;
				repaintFirstScreen();
			}//end seat[0] */
			if (obj == seat[1])
			{
				SeatData.flightSeat[1]=true;
				repaintFirstScreen();
			}//end seat[1] */
			if (obj == seat[2])
			{
				SeatData.flightSeat[2]=true;
				repaintFirstScreen();
			}//end seat[2] */
			if (obj == seat[3])
			{
				SeatData.flightSeat[3]=true;
				repaintFirstScreen();
			}//end seat[3] */
			if (obj == seat[4])
			{
				SeatData.flightSeat[4]=true;
				repaintFirstScreen();
			}//end seat[4] */
			if (obj == seat[5])
			{
				SeatData.flightSeat[5]=true;
				repaintFirstScreen();
			}//end seat[5] */
			if (obj == seat[6])
			{
				SeatData.flightSeat[6]=true;
				repaintFirstScreen();
			}//end seat[6] */
			if (obj == seat[7])
			{
				SeatData.flightSeat[7]=true;
				repaintFirstScreen();
			}//end seat[7] */
			if (obj == seat[8])
			{
				SeatData.flightSeat[8]=true;
				repaintFirstScreen();
			}//end seat[8] */
			if (obj == seat[9])
			{
				SeatData.flightSeat[9]=true;
				repaintFirstScreen();
			}//end seat[9] */
		}//end private method actionPerformed */
	}//end private class ButtonHandler*/

}
