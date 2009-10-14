/**
 * @author J.A. Simmons V
 * @version 1.0
 * @date Sep 24, 2009
 */
import java.awt.*;
import javax.swing.*;
//import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.table.AbstractTableModel;

/*
 * TODO Setup read/write to backup file
 */

public class FieldFrame extends JFrame implements ActionListener
{
	private JPanel inputPanel, employeeDataPanel;//display panels
	private JTextField txtLName, txtFName, txtHrRate;//txt fields for user input
	private JButton butSubmit,hrsWorked; //action buttons
	private JLabel lblLName, lblFName, lblHrRate;//labels for user input
	private EmployeeDB employeeDB;//need this DB for referencing
	private static String[][] employeeData; //store employeeData
	private ButtonHandler handler;//button Action handler
	private String[] colHeadings={ "Employee Number" , "Last Name" , "First Name" , "Hourly Rate", "Weekly Pay" };//headings for 2d array
	
	//TextFieldConstructor******************
	public FieldFrame()
	{
		super("Employee Calculations");
		//setup panels and general layout of the screen.
		handler = new ButtonHandler();
		employeeDB = new EmployeeDB(); //setup employeeDB for reference
		//setup reference data
		employeeData = new String[EmployeeDB.getCustomerCount()-1][4];
		employeeData=EmployeeDB.getEmployeeData();
		
		//call methods to setup Panels
		setupInputPanel();
		employeeDisplaySetup();
				
		//Add inputPanel into main JPanel
		add( inputPanel, BorderLayout.EAST );
		add( employeeDataPanel, BorderLayout.CENTER );
		
	}//end Constructor fieldFrame*/
	
	//this methods initalizes components that will be in the inputPanel
	private void setupInputPanel()
	{
		//initalize inputPanel
		inputPanel = new JPanel();	
		inputPanel.setLayout (new GridLayout(4,1));
		
		//***initalize components***
		//setup textFields
		txtLName = new JTextField();
		txtLName.setBorder(BorderFactory.createLineBorder(Color.black));
		txtFName = new JTextField();
		txtFName.setBorder(BorderFactory.createLineBorder(Color.black));
		txtHrRate = new JTextField();
		txtHrRate.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//setup labels
		lblFName = new JLabel("Enter first name: ");
		lblHrRate = new JLabel("Enter hourly rate in USD:");
		lblLName = new JLabel("Enter surname:");
		
		//setup buttons
		butSubmit = new JButton("Submit");
		hrsWorked = new JButton("Submit TimeSheet");
		butSubmit.addActionListener(handler);//end call to butSubmit.addActionListner
		hrsWorked.addActionListener(handler);//end call to hrsWorked.addActionListner*/
		
		//add components to the input panel
		inputPanel.add( lblLName, BorderLayout.EAST );
		inputPanel.add( txtLName, BorderLayout.EAST );
		inputPanel.add( lblFName, BorderLayout.EAST );
		inputPanel.add( txtFName, BorderLayout.EAST );
		inputPanel.add( lblHrRate, BorderLayout.EAST );
		inputPanel.add( txtHrRate,BorderLayout.EAST );
		inputPanel.add( butSubmit,BorderLayout.EAST );
		inputPanel.add( hrsWorked,BorderLayout.EAST );
		
		
	}//end method setupInputPanel
	
	//setup EmployeeDisplay table
	private void employeeDisplaySetup()
	{
		employeeDataPanel = new JPanel();
		employeeDataPanel.setLayout(new GridLayout());
		/*
		 * TODO  populate employeeDataPanel with existing employee data
		 */
	}//end method employeDisplaySetup */
	
	public void reDisplayEmployeeData()
	{
		/*
		 * TODO re-engineer employeeDataRedraw
		 */
		employeeData = new String[EmployeeDB.getCustomerCount()-1][4];
		employeeData=EmployeeDB.getEmployeeData();
		//emplTable.removeAll();
		//emplTable= new JTable( employeeData,colHeadings );	
		scrollPane.removeAll();
		scrollPane.add(emplTable);
		add( scrollPane, BorderLayout.CENTER );
		//validate and repaint
		emplTable.validate();
		scrollPane.validate();
		emplTable.repaint();
		scrollPane.repaint();
	}//end method displayEmployeeData*/
	
	//********************ButtonHandler********************
	private class ButtonHandler implements ActionListener
    {
            public void  actionPerformed (ActionEvent ae)
            {
                    Object obj = ae.getSource();
                    if (obj == butSubmit)
                    {
                    	String lName = txtLName.getText();
						String fName = txtFName.getText();
						String hrRate = txtHrRate.getText();
						double dblHrRate;
						dblHrRate = Double.parseDouble(hrRate);
						if (lName.equals("") || fName.equals("") || hrRate.equals(""))//if informaion is missing, throw error and drop out.
						{
							JOptionPane.showMessageDialog(FieldFrame.this, "Error! Please enter all information");
							return;
						}//endif
						EmployeeDB.addEmployee(lName,fName,dblHrRate);
						JOptionPane.showMessageDialog(FieldFrame.this, "User Added Successfully");
						//After successful adding, clear prior information.
						txtLName.setText("");
						txtFName.setText("");
						txtHrRate.setText("");
						lName="";
						fName="";
						hrRate="";
						dblHrRate=0;
						reDisplayEmployeeData();
                    }//end butSubmit if statement
                    
                    if (obj == hrsWorked)
                    {
                    	int empIDNum = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID Number: "));
				        double empWorkHrs = Double.parseDouble(JOptionPane.showInputDialog("Enter Hours Worked: "));
				        double weekPay = EmployeeDB.getWeeklyPay(empIDNum,empWorkHrs);
				        JOptionPane.showMessageDialog(null,"Weekly Pay is: $"+ weekPay);
                    }//end hrsWorked if statement
                    
            }//end private method actionPerformed
    }//end private class ButtonHandler	
	
}//End class FieldFrame*/
