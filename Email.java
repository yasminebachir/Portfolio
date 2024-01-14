package EmailAdministrationApplication;

import java.util.Scanner;

public class Email{
    private String firstName; // must be private so it is not accessed by other users
    private String lastName;
    private String email;
    private String password;
    private String department;
    private int defaultPasswordLength = 10; // we must set a password length so it can generate a random password within that length. this length can be changed at all times
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "companyname.com";

    // Constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        
        // Call a method asking for the department and it will return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength); 
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    // Ask for the department
    private String setDepartment() 
    {
        System.out.print( "Staff Name: "+ firstName +" " + lastName + " \nDepartment Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in); // Scanner object to read the department
        int departmentChoice = in.nextInt(); // the user will enter one of the numbers and based on that we will set the department

        if (departmentChoice == 1) {
            return "sales";
        }

        else if (departmentChoice == 2) {
            return "development";
        }

        else if (departmentChoice == 3) {
            return "accounting";
        }

        else {
            return "" ; 
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[] password = new char[length];
        
        for (int i=0; i <length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
        // This code generates a random number within the scope of the passwordSet. It will then take a random character 
        // and pass it to the array which will generate it one at a time and it will then return the new password.
    }



    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }


    // Set the alternate email 
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail= altEmail;
    }


    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity () {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }


    public String showInfo() { // display email, name and mail capacity
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailBox Capacity: " + mailboxCapacity + "mb";

    }
}