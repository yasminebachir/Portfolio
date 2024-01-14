package StudentDatabaseApplication;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String courses;
    private String studentID;
    private int gradeLevel;
    private int tuitionBalance;
    private static int costOfCourse = 600; 
    private static int id = 1000;



    // Constructor: prompt user to enter student's name and year
    // It will print out the name and the year of the student
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: " );
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: " );
        this.lastName = in.nextLine();

        System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student grade level: " );
        this.gradeLevel = in.nextInt();

        setStudentID();

        System.out.println(firstName + " " + lastName + " " + gradeLevel + " " + studentID);
        
    
    }


    // Generate an ID
    private void setStudentID() {
        // Grade Level + ID
        id++;
        this.studentID = gradeLevel + "" + id;

    }



    // Enroll in courses
    public void enroll() {
        // we want to get inside a loop, user hits Q to get out of the loop but they can keep enrolling as they wish
         do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();

            if (!course.equals("Q")) {
                courses = courses + "\n  " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } 
            
            else {
                break; 
            }

        } 

        while (1 != 0);
        System.out.println("ENROLLED IN: " + courses);
    }


    // View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }


    // Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }




    // Show status
    public String toString() {
        return "Name: " + firstName + " " + lastName + 
                "\nGrade Level: " + gradeLevel +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses + 
                "\nBalance: $" + tuitionBalance;
    }


}
