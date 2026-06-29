package student_db.model;

import java.util.ArrayList;

class School {
    private String schoolName;
    private SchoolClass classes[] = new SchoolClass[12];

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public void initClass(int currentClass) throws ArrayIndexOutOfBoundsException {
        if (currentClass < 1 || currentClass >= 12)
            throw new ArrayIndexOutOfBoundsException("The value should be in the range 1 <= x <= 12");
        SchoolClass c = new SchoolClass(currentClass);
        classes[currentClass - 1] = c;
    }

    // Idk what variable to use ,
    public SchoolClass getSchoolClass(int currentClass) {
        if (currentClass < 1 || currentClass >= 12)
            throw new ArrayIndexOutOfBoundsException("The value should be in the range 1 <= x <= 12");
        return classes[currentClass - 1];
    }

    // later
    public void promotion() {

    }
}
