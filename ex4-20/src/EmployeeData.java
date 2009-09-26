/**
 * @author J.A. Simmons V
 * @version 1.0
 * @date Sep 24, 2009
 * This class is the structure for the Employee data and any other needed methods
 */
public class EmployeeData 
{
	private int employeeNum;
	private String lastName;
	private String firstName;
	private double hrRate;

	//***********Constructor*************
	public EmployeeData(int theEmployeeNum, String theLastName, String theFirstName, double theHrRate)
	{
		employeeNum = theEmployeeNum;
		lastName = theLastName;
		firstName = theFirstName;
		hrRate = theHrRate;
	}//ENd constructor
	
	public String getLastName()
	{
		return lastName;
	}//End get LastName Method
	
	public String getFirstName()
	{
		return firstName;	
	}//end getFirstName Method
	
	public int getEmployeeNum()
	{
		return employeeNum; 
	}//end getEmployeeNum Method
	
	public double getHrRate()
	{
		return hrRate;
	}//end getHrRate
}//End Class EmployeeData
