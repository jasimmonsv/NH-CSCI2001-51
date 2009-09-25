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
	JTextField txtLName, txtFName, txtHrRate, txtEmployeeNum;;
	JButton butSubmit;
	JTable table;
	String[] colHeadings={ "Employee Number" , "Last Name" , "First Name" , "Hourly Rate" };
	EmployeeData[] employeeData;
	
	//TextFieldConstructor******************
	public FieldFrame()
	{
		super("Testing Buttons");
		employeeData = EmployeeDB.getEmployeeData();
		setLayout( new FlowLayout());
		txtLName = new JTextField("Enter Surname Here");
		txtFName = new JTextField("Enter First Name Here");
		txtHrRate = new JTextField("Hourly Rate in USD");
		butSubmit = new JButton("Submit");
		//table = new JTable( EmployeeDB.employeeData,colHeadings );	
		butSubmit.addActionListener(this);
		add( txtLName); add(txtFName); add(txtHrRate);add(butSubmit);
		//construct txtField
	}//end method TxtFieldFrame
	
	//inner class for button event handling
	public void actionPerformed (ActionEvent event)
	{
		Object obj = event.getSource();
		if (obj == butSubmit)
		{
			System.out.printf("Great");
		}//end If for butSubmit Click
	}//end method actionPerformed
}//End class FieldFrame
