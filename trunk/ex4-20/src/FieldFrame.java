/**
 * @author J.A. Simmons V
 * @version 1.0
 * @date Sep 24, 2009
 */
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class FieldFrame extends JFrame implements ActionListener
{
	private JPanel inputPanel;
	private BorderLayout borderLayout1;
	private JTextField txtLName, txtFName, txtHrRate, txtEmployeeNum;
	private JButton butSubmit;
	private JTable table;
	private String[] colHeadings={ "Employee Number" , "Last Name" , "First Name" , "Hourly Rate" };
	private EmployeeData[] employeeData;
	
	//TextFieldConstructor******************
	public FieldFrame()
	{
		super("Employee Calculations");
		inputPanel = new JPanel();
		inputPanel.setLayout (new GridLayout(4,1));
		borderLayout1 = new BorderLayout(3,3);
		setLayout( borderLayout1);
		txtLName = new JTextField("Enter Surname Here");
		txtFName = new JTextField("Enter First Name Here");
		txtHrRate = new JTextField("Hourly Rate in USD");
		butSubmit = new JButton("Submit");
		//table = new JTable( EmployeeDB.employeeData,colHeadings );	
		inputPanel.add( txtLName, BorderLayout.EAST);
		inputPanel.add(txtFName, BorderLayout.EAST); 
		inputPanel.add(txtHrRate,BorderLayout.EAST);
		inputPanel.add(butSubmit,BorderLayout.EAST);
		add(inputPanel, BorderLayout.EAST);
		butSubmit.addActionListener(
				//Process Submit Button event
				new ActionListener()//anonymous inner class
				{
					public void actionPerformed(ActionEvent ae)
					{
						for (employeeData.employeeNum : employeeData[])
						{
							/**
							 * txtLPhoto = lPhoto.getText();
			txtWPhoto = wPhoto.getText();
			int intLPhoto = Integer.parseInt(txtLPhoto.trim());
			int intWPhoto = Integer.parseInt(txtWPhoto.trim());
			CostOfFraming()
							 */
						}
						
							get
						};
						JOptionPane.showMessageDialog(FieldFrame.this, "Submit test complete.");
					}//end method actionPerformed
				}//end anonymous innerclass for submit button
		);//end call to addaCTIONlISTNER
	}//end Method fieldFrame
	
}//End class FieldFrame
