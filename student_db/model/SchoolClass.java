package student_db.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.lang.Character;
import java.util.Collections;

class NullObjectException extends Exception {
    public NullObjectException(String errorMessage) {
        super(errorMessage);
    }
}

class ValueExistsException extends Exception {
    public ValueExistsException(String errorMessage) {
        super(errorMessage);
    }
}

class ValueNotExistsException extends Exception {
    public ValueNotExistsException(String errorMessage) {
        super(errorMessage);
    }
}

class SchoolClass {
    int currentClass;
    private HashMap<Character, ArrayList<Student>> studentsRecord;

    public SchoolClass(int currentClass) {
        this.currentClass = currentClass;
        this.studentsRecord = new HashMap<>();
    }

    public int getCurrentClass() {
        return this.currentClass;
    }

    private int findStudent(ArrayList<Student> students, int rollNo) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).rollNo == rollNo) {
                return i;
            }
        }
        return -1;
    }

    public void addStudent(Student student, char section) throws NullObjectException, ValueExistsException {
        if (student == null) {
            throw new NullObjectException("Student cannot be empty");
        }
        if (findStudent(this.studentsRecord.get(section), student.rollNo) != -1) {
            throw new ValueExistsException("The student value already exists");
        }
        if (!this.studentsRecord.containsKey(section)) {
            this.studentsRecord.put(section, new ArrayList<>());
        }
        this.studentsRecord.get(section).add(student);
    }

    public Student getStudent(int rollNo, char section) throws ValueNotExistsException {
        int idx = findStudent(studentsRecord.get(section), rollNo);
        if (idx == -1) {
            throw new ValueNotExistsException("The student was not found in the section");
        }
        return studentsRecord.get(section).get(idx);
    }

    public Student getStudent(int rollNo) throws ValueNotExistsException {
        for (Map.Entry<Character, ArrayList<Student>> entry : studentsRecord.entrySet()) {

            int idx = findStudent(studentsRecord.get(entry.getKey()), rollNo);
            char section = entry.getKey();
            if (idx != -1) {
                return studentsRecord.get(section).get(idx);
            }
        }
        throw new ValueNotExistsException("The student was not found in the section");
    }

    public ArrayList<Student> getStudents(char section) {
        return studentsRecord.get(section);
    }
}
