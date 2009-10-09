import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.*;

public class CAI631View extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2121756237112327169L;
	
	
	
	//***************CAI631View Constructor***********
	public CAI631View()
	{
		//setup panel
		CAIMainView.cai631Pane = new JPanel();//Create JPanel
		cai631Pane.setLayout(new FlowLayout());//set layout
		mainDisplay();
		add(cai631Pane); //add the pane to the frame			
	}//end CAI631View constructor

	
}//end class CAI631View */
