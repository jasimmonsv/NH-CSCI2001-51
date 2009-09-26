/**
 * @author J.A. Simmons V
 * @version 1.0
 * @date Sep 24, 2009
 * This class is the structure for the Employee data and any other needed methods
 */

import java.text.DecimalFormat;
import java.util.*;

public class EmployeeDB 
{
	private static ArrayList<EmployeeData> employeeData; //arrayList of Employee Data
	
	//no Argument employeeDB constructor for testing
	public EmployeeDB()
	{
		employeeData = new ArrayList<EmployeeData>(); // initalizing ArrayList of EmployeeData
		employeeData.add(new EmployeeData(001, "Doe","John",25.0));
		employeeData.add(new EmployeeData(002, "Public","John",10.0));
		employeeData.add(new EmployeeData(003, "Smith","Bob",7.50));
	}//end Constructor
		
	//method ot add another employee
	public static void addEmployee(String lName, String fName, double hrRate)
	{
		int employeeNum = employeeData.size()+1;
		employeeData.add(new EmployeeData(employeeNum,lName,fName,hrRate));
		return;
	}//end method addEmployee
	
	//Method to grab total number of customers
	public static int getCustomerCount()
	{
		return employeeData.size();
	}//end method getCustomerCount
	
	//convert all employeedata to a 2D array for printing
	public static String[][] getEmployeeData()
	{
		String data[][];
		data = new String[employeeData.size()][5];
		//for loop to transfer data to 2d array
		for (int i=0; i<=(employeeData.size()-1);i++)
		{
			data[i][0]=Integer.toString(employeeData.get(i).getEmployeeNum());
			data[i][1]=employeeData.get(i).getLastName();
			data[i][2]=employeeData.get(i).getFirstName();
			data[i][3]=Double.toString(employeeData.get(i).getHrRate());
		}//end for loop
		
		return data;
	}//end method getEmployeeData

	public static double getWeeklyPay( int employeeID,double wkHours )
	{
		Formatter fmt = new Formatter();
		int i=0;
		while (employeeData.get(i).getEmployeeNum() != employeeID)
		{
			i++;
		}
		double hrRate=employeeData.get(i).getHrRate();
		double total;
		if (wkHours > 40) 
		{
			total=40*hrRate;
			wkHours-=40;
			total=total+(wkHours*hrRate*1.5);
			DecimalFormat twoDForm = new DecimalFormat("#.##");
			return Double.valueOf(twoDForm.format(total));
		}//End IF Statement
		total = wkHours*hrRate;
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(total));
	}//End Get WeeklyPay
	
}//ENd Class EmployeeDB
