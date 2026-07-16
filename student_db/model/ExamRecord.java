package student_db.model;

public class ExamRecord {
    String testName;
    int studentClass;
    TestType testType;
    float totalMarksObtained;
    float totalMarks;
    // for the some exams there won't be any grade calculations like the daily
    // revision/ assessment test , so they can also be null
    Float grade;

    public ExamRecord(int studentClass, String testName, TestType testType,
            float totalMarksObtained, Float grade, float totalMarks) {
        this.studentClass = studentClass;
        this.testName = testName;
        this.testType = testType;
        this.totalMarksObtained = totalMarksObtained;
        this.grade = grade;
        this.totalMarks = totalMarks;
    }
}
