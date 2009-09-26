/**
 * @author J.A. Simmons V
 * @version 1.0
 * @date Sep 24, 2009
 */
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class FieldFrame extends JFrame implements ActionListener
{
	private JPanel inputPanel, dispPanel;
	private BorderLayout borderLayout1;
	private JTextField txtLName, txtFName, txtHrRate;
	private JButton butSubmit,hrsWorked;
	private JLabel lblLName, lblFName, lblHrRate;
	private EmployeeDB employeeDB;
	private JTable emplTable;
	private String[][] employeeData;
	private String[] colHeadings={ "Employee Number" , "Last Name" , "First Name" , "Hourly Rate", "Weekly Pay" };
	
	//TextFieldConstructor******************
	public FieldFrame()
	{
		super("Employee Calculations");
		//setup panels and general layout of the screen.
		inputPanel = new JPanel();
		inputPanel.setLayout (new GridLayout(4,1));
		dispPanel = new JPanel();
		dispPanel.setLayout(new FlowLayout());
		borderLayout1 = new BorderLayout(3,3);
		setLayout( borderLayout1);
		
		//setup components
		employeeDB = new EmployeeDB();
		txtLName = new JTextField();
		txtLName.setBorder(BorderFactory.createLineBorder(Color.black));
		txtFName = new JTextField();
		txtFName.setBorder(BorderFactory.createLineBorder(Color.black));
		txtHrRate = new JTextField();
		txtHrRate.setBorder(BorderFactory.createLineBorder(Color.black));
		butSubmit = new JButton("Submit");
		hrsWorked = new JButton("Submit TimeSheet");
		lblFName = new JLabel("Enter first name: ");
		lblHrRate = new JLabel("Enter hourly rate in USD:");
		lblLName = new JLabel("Enter surname:");
		employeeData = new String[EmployeeDB.getCustomerCount()-1][4];
		employeeData=EmployeeDB.getEmployeeData();
		emplTable = new JTable( employeeData,colHeadings );	
		emplTable.setPreferredScrollableViewportSize( new Dimension(200,100));

		//add components to the input panel
		inputPanel.add(lblLName, BorderLayout.EAST );
		inputPanel.add( txtLName, BorderLayout.EAST );
		inputPanel.add( lblFName, BorderLayout.EAST );
		inputPanel.add( txtFName, BorderLayout.EAST );
		inputPanel.add( lblHrRate, BorderLayout.EAST );
		inputPanel.add( txtHrRate,BorderLayout.EAST );
		inputPanel.add( butSubmit,BorderLayout.EAST );
		inputPanel.add( hrsWorked,BorderLayout.EAST );
		
		//add components to the dispPanel
		dispPanel.add(emplTable);
		//Add inputPanel into main JPanel
		add( inputPanel, BorderLayout.EAST );
		add( dispPanel, BorderLayout.WEST );
		
		//Process Actions and Events
		butSubmit.addActionListener(
				//Process Submit Button event
				new ActionListener()//anonymous inner class
				{
					public void actionPerformed(ActionEvent ae)
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
						displayEmployeeData();
					}//end method actionPerformed
				}//end anonymous innerclass for submit button
		);//end call to butSubmit.addActionListner
		
		hrsWorked.addActionListener(
				//Process Submit Button event
				new ActionListener()//anonymous inner class
				{
					public void actionPerformed(ActionEvent ae)
					{
						int empIDNum = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID Number: "));
				        double empWorkHrs = Double.parseDouble(JOptionPane.showInputDialog("Enter Hours Worked: "));
				        double weekPay = EmployeeDB.getWeeklyPay(empIDNum,empWorkHrs);
				        JOptionPane.showMessageDialog(null,"Weekly Pay is: $"+ weekPay);
					}//end method actionPerformed
				}//end anonymous innerclass for hrsWorked button
		);//end call to hrsWorked.addActionListner
		
	}//end Method fieldFrame
	
	public void displayEmployeeData()
	{
		employeeData=EmployeeDB.getEmployeeData();
		inputPanel.repaint();
		dispPanel.validate();
	}//end method displayEmployeeData
	
}//End class FieldFrame
