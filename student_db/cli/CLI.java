package student_db.cli;

import student_db.model.School;

import student_db.model.SchoolClass;
import student_db.model.Student;
import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        // School - > class -> Student -> Grade
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the school name:");
        String schoolName = sc.nextLine();
        School school = new School(schoolName);
        for (int i = 1; i <= 12; i++) {
            school.initClass(i);
        }
        System.out.println("Enter the number of test cases");
        int noTestCases = sc.nextInt();
        while (noTestCases > 0) {
            // The number of classes that I want to modify
            //
            System.out.println("Enter the number of classes");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                try {

                    System.out.println("Enter the current class:");
                    int studentClass = sc.nextInt();
                    SchoolClass currentSchoolClass = school.getSchoolClass(studentClass);

                    System.out.println("Enter the name of the student:");
                    String name = sc.nextLine();

                    System.out.println("Enter the gender : (M male , F female) : ");
                    char gender = sc.next().charAt(0);

                    System.out.println("Enter the roll number of the student:");
                    int rollNo = sc.nextInt();

                    System.out.println("Enter the current section of the student:");
                    char currentSection = sc.next().charAt(0);
                    Student newStudent = new Student(name, gender, rollNo, currentSection, studentClass);
                    currentSchoolClass.addStudent(newStudent, currentSection);

                    System.out.println("Enter the name of the test:");
                    String testName = sc.nextLine();

                    System.out.println("Enter the type of test:");
                    String testType = sc.nextLine();

                    System.out.println("Enter the total marks:");
                    float totalMarks = sc.nextFloat();

                    System.out.println("Enter the total marks obtained:");
                    float totalMarksObtained = sc.nextFloat();
                    Float grade = null;
                    System.out.println("Does this exam has grades ? (1-> yes , 0 -> no)");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        grade = sc.nextFloat();
                    }
                    newStudent.addGrade(studentClass, totalMarks, totalMarksObtained, grade, testName, testType);
                } catch (Exception e) {
                    System.out.println("The following exception occured" + e);
                }
            }
            --noTestCases;
            sc.close();
        }
    }
}
