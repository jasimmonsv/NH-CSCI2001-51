/**
 * @author J.A. Simmons V
 * @version 1.0
 * @date Sep 24, 2009
 * This class is the structure for the Employee data and any other needed methods
 */

public class EmployeeDB 
{
	private static EmployeeData[] employeeData; //array of Employee Data
	
	//no Argument employeeDB constructor for testing
	public EmployeeDB()
	{
		employeeData = new EmployeeData[2]; // 2 default accounts for testing
		employeeData[0] = new EmployeeData(001, "Doe","John",25.0);
		employeeData[1] = new EmployeeData(002, "Public","John",10.0);
	}//end Constructor
	
	public EmployeeData[] getEmployeeData()
	{
		return employeeData;
	}//end method getEmployeeData
	
	

}
