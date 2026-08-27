# studentRecords

A small command-line application in C++ for keeping track of students and their
subject marks. Records live in memory for the duration of a run — this is a
learning project, so there is no file or database persistence yet.

## What it does

Each student is identified by a unique roll number and holds a set of
subject/mark pairs. From an interactive menu you can:

- Add a student (name + roll number, duplicates rejected)
- Add marks for a student, one subject at a time
- Remove a student
- Look up a student by roll number
- Show the highest-scoring subject for a student
- Show the lowest-scoring subject for a student
- Show a student's average across all subjects

Invalid input is reported through custom exceptions — a negative roll number, a
negative mark, a duplicate subject, or an unknown roll number produces an error
message and returns you to the menu instead of crashing.

## Project layout

```
main.cpp                     entry point and the run() menu loop
includes/student.hpp         the student class: marks, average, highest, lowest
includes/manage_students.hpp the student registry and operations on it
includes/exceptions.hpp      InvalidRollNumber, InvalidMark, InvalidSubArgument
CMakeLists.txt               build configuration
bin/                         where the built executable is placed
```

The logic is header-only, so `main.cpp` is the only translation unit.

## Requirements

- A C++17 compiler (structured bindings are used in `student.hpp`)
- CMake 3.16 or newer

On macOS: `brew install cmake` (Apple's Command Line Tools supply the compiler).

## Building and running

```sh
cmake -S . -B build
cmake --build build
./bin/studentRecords
```

The executable is written to `bin/studentRecords`.

If you would rather skip CMake, a direct compile works just as well:

```sh
c++ -std=c++17 -Wall -Wextra -Iincludes -o bin/studentRecords main.cpp
```

## Using it

The program prints a numbered menu and waits for a choice:

```
===== Student Records =====
1. Add student
2. Add marks
3. Remove student
4. Find student by roll number
5. Highest mark
6. Lowest mark
7. Average mark
0. Exit
Enter your choice :
```

A typical session — add a student, give them two subjects, then ask for the
average:

```
Enter your choice : 1
Enter the student name and roll_number Ajay 12
Student added

Enter your choice : 2
Enter the roll number : 12
Enter the number of subjects : 2
Enter the subject name : math
Enter the subject mark : 90
Enter the subject name : physics
Enter the subject mark : 75
Marks added

Enter your choice : 7
Enter the roll number : 12
Average : 82.5
```

Choose `0` to exit.

## Contributing

Feel free to contribute! This is a learning project, so improvements of any
size are welcome — bug fixes, cleaner error handling, persistence to disk,
tests, or just better prompts. Open an issue or send a pull request.
