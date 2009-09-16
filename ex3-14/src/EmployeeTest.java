/**
 * 
 * @author J.A. Simmons V
 * @version 1.0 15 Sep 2009
 * 
 */

public class EmployeeTest {

	public static void main(String[] args) 
	{
	//**********Declarations*********************
		Employee employee1 = new Employee("John", "Galt", 7000);
		Employee employee2 = new Employee("Howard", "Roark", 4500);
		
	//**********End Declarations*****************
		System.out.printf("%s, %s : %.2f\n", employee1.getLastName(), employee1.getFirstName(), employee1.getMonthlySalary()*12);
		System.out.printf("%s, %s : %.2f\n", employee2.getLastName(), employee2.getFirstName(), employee2.getMonthlySalary()*12);
		System.out.printf("Adding 10%% raise...\n");
		employee1.setMonthlySalary(employee1.getMonthlySalary()*1.1);
		employee2.setMonthlySalary(employee2.getMonthlySalary()*1.1);
		System.out.printf("%s, %s : %.2f\n", employee1.getLastName(), employee1.getFirstName(), employee1.getMonthlySalary()*12);
		System.out.printf("%s, %s : %.2f\n", employee2.getLastName(), employee2.getFirstName(), employee2.getMonthlySalary()*12);
	}

}
