package student_db.model;

import java.util.ArrayList;

public class Student {
    public String name;
    public char gender;
    public int rollNo;
    public char sections[] = new char[12];
    public String currentSection;
    private ArrayList<ExamRecord> examRecords = new ArrayList<>();

    public Student(String name, char gender, int rollNo, char currentSection, int currentClass) {
        this.name = name;
        this.gender = gender;
        this.rollNo = rollNo;
        sections[currentClass - 1] = currentSection;
    }

    public void addGrade(int currentClass, float totalMarks, float totalMarksObtained, Float grade, String testName,
            String testType) {
        TestType type = TestType.valueOf(testType);
        ExamRecord newGrade = new ExamRecord(currentClass,
                testName, type, totalMarksObtained, grade, totalMarks);
        examRecords.add(newGrade);
    }

    public void getGrade(int studentClass, String testType) {
        for (ExamRecord grade : examRecords) {
            if (grade.studentClass == studentClass && grade.testType == TestType.valueOf(testType)) {
                if (grade.grade == null) {
                    System.out.println("No grades for this exam");
                }
                System.out.println(
                        "The test name is " + grade.testName + ".\nThe grade of the student is : " + grade.grade);
            }
        }
    }
}
