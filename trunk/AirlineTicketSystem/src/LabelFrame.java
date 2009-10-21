
import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.*;

public class LabelFrame  extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 327343626426356919L;
	private JPanel firstScreen;
	private JButton btnFirstClass, btnEconClass;
	private ButtonHandler handler;
	
	//****** Constructor Method ************
	public LabelFrame()
	{
		super( "Simmons Air Reservation System" );
		handler = new ButtonHandler(); //action handler
		setLayout( new FlowLayout() );//set frame layout
		initFirstScreen(); //initalize JPanel that will be welcome screen
		add(firstScreen); //add firstScreen panel to the JFrame
		
	}//end constructor method
	
	private void initFirstScreen()
	{		
		firstScreen = new JPanel();
		firstScreen.setLayout( new BorderLayout() );//set frame layout
		
		//TODO initalize images
		JPanel btnPanel = new JPanel();//create panel component to hold seat selection buttons
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
		btnPanel.add( btnFirstClass );
		btnPanel.add( btnEconClass );
		
		//add components to frame
		firstScreen.add( lblAirLogo, BorderLayout.CENTER);
		firstScreen.add( btnPanel, BorderLayout.EAST );
	}//end init method */
	
	
	//************************
	//************************    Button Handler
	//************************
	private class ButtonHandler implements ActionListener
	{
		public void  actionPerformed (ActionEvent ae)
		{
			Object obj = ae.getSource();
			if (obj == btnFirstClass)
			{
				JOptionPane.showMessageDialog( null, "btnFirstClass pressed", "Testing", JOptionPane.PLAIN_MESSAGE);
			}//end btnFirstClass submit action
			if (obj == btnEconClass)
			{
				JOptionPane.showMessageDialog( null, "btnEconClass pressed", "Testing", JOptionPane.PLAIN_MESSAGE);
			}//end btnFirstClass submit action
		}//end private method actionPerformed */
	}//end private class ButtonHandler*/

}
