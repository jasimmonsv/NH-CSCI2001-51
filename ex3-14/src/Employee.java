/**
 * @author J.A. Simmons V
 * @version 1.0 15 Sep 2009 
 */
public class Employee {

	//***************Declarations*********************
	private String lastName; //instance var that stores Last Name
	private String firstName;//instance var that stores First Name
	private double monthlySalary;//instance var that stores monthly salary
	//**************End Declarations******************
	
	//Constructor initializes lastName, firstName, and monthlySalary
	public Employee(String fName, String lName, double mSalary)
	{
		lastName = lName;
		firstName = fName;
		monthlySalary = mSalary;
		
	}//end CONSTRUCTOR
	
	public String getLastName ()
	{
		return lastName;
	}//end method getLastName
	
	public void setLastName ( String lName)
	{
	lastName = lName;//Stores last name from called method
	}//end method setLastName
	
	public String getFirstName ()
	{
		return firstName;
	}//end method getFirstName
	
	public void setFirstName (String fName)
	{
	firstName = fName; //stores firstName from called method
	}//end method setFirstName
	
	public double getMonthlySalary()
	{
		return monthlySalary;
	}//end method getMonthlySalary
	
	public void setMonthlySalary (double mSalary)
	{
		if (mSalary > 0.0)
			monthlySalary = mSalary;
	}//end method setMonthlySalary
}//end class Employee
