package GL.Lab;

import java.util.*;

public class Employee {

	String firstName = "";
	String lastName = "";
	String department = "";

	public String getDepart() {
		return department;
	}

	public void setDepart(String d) {
		department = d;
	}

	Employee(String f, String l) {
		firstName = f;
		lastName = l;
	}

	public static char[] generatePassword(int length) {

		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + Small_chars + numbers + symbols;

		Random rndm_method = new Random();

		char[] password = new char[length];

		for (int i = 0; i < length; i++) {

			password[i] = values.charAt(rndm_method.nextInt(values.length()));

		}
		return password;
	}

	public String generateEmailAddress(String f, String l) {
		String emailID = f + l + "@" + getDepart() + ".infosys.com";
		return emailID;
	}

	public void showCredentials() {
		System.out.println("Dear " + firstName + " your generated credentials are as follows:");
		String mail = generateEmailAddress(firstName, lastName);
		System.out.println("Email   ----> " + mail);
		char[] pass = generatePassword(8);
		System.out.println("Password ---> " +String.valueOf( pass));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner obj = new Scanner(System.in);
		System.out.println(
				"Please enter the department from the following: \n 1. Technical \n 2. Admin \n 3. Human Resource \n 4. Legal");
		int depart = obj.nextInt();
		String department = "";

		switch (depart) {
		case 1:
			department = "Tech";
			break;
		case 2:
			department = "Admin";
			break;
		case 3:
			department = "HR";
			break;
		case 4:
			department = "Legal";
			break;
		default:
			System.out.println("Invalid Choice");
			System.exit (0);
		}

		System.out.println("Enter your First Name and Last Name: ");

		String[] string = new String[2];
		// consuming the <enter> from input above
		obj.nextLine();
		for (int i = 0; i < string.length; i++) {
			string[i] = obj.nextLine();
		}
		String firstName = string[0];
		String lastName = string[1];
		Employee e = new Employee(firstName, lastName);
		e.setDepart(department);
		e.showCredentials();
		obj.close();
	}

}
