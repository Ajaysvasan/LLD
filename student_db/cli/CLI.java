package student_db.cli;

import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        // School - > class -> Student -> Grade
        Scanner sc = new Scanner(System.in);
        String schoolName = sc.nextLine();
        School school = new School(schoolName);
        for (int i = 1; i <= 12; i++) {
            school.initClass(i);
        }
        int noTestCases = sc.nextInt();
        while (noTestCases > 0) {
            // The number of classes that I want to modify
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int studentClass = sc.nextInt();
                SchoolClass currentSchoolClass = school.getSchoolClass(studentClass);
                String name = sc.nextLine();
                char gender = sc.next().charAt(0);
                int rollNo = sc.nextInt();
                char currentSection = sc.next().charAt(0);
                Student newStudent = new Student(name, gender, rollNo, currentSection, studentClass);
                currentSchoolClass.addStudent(newStudent, currentSection);
                String testName = sc.nextLine();
                String testType = sc.nextLine();
                float totalMarks = sc.nextFloat();
                float totalMarksObtained = sc.nextFloat();
                Float grade = null;
                System.out.println("Does this exam has grades ? (1-> yes , 0 -> no)");
                int choice = sc.nextInt();
                if (choice == 1) {
                    grade = sc.nextFloat();
                }
                newStudent.addGrade(studentClass, totalMarks, totalMarksObtained, grade, testName, testType);
            }
            --noTestCases;
        }
    }
}
