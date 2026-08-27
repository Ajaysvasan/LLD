#pragma once
#include "student.hpp"
#include <iostream>
#include <string>
#include <unordered_map>
#define uint unsigned int

inline std::unordered_map<uint, student> students;
inline void add_student() {
  std::string student_name;
  uint student_roll_number;
  std::cout << "Enter the student name and roll_number";
  std::cin >> student_name >> student_roll_number;
  if (student_roll_number <= 0) {
    throw InvalidRollNumber("Roll number can't be negative");
  }
  if (students.find(student_roll_number) == students.end()) {

    student s(student_roll_number, student_name);
    students[student_roll_number] = s;
  } else
    throw InvalidRollNumber("Student with this roll number already exits");
}

inline void add_marks(uint student_roll_number, int number_of_subs) {
  students[student_roll_number].set_student_marks(number_of_subs);
}

inline void remove_student(uint student_roll_number) {

  if (students.find(student_roll_number) != students.end())
    students.erase(student_roll_number);
  else
    throw InvalidRollNumber("Student with this roll number does not exits");
}

inline stats get_highest_marks(uint student_roll_number) {
  return students[student_roll_number].get_highest_mark();
}

inline stats get_lowest_marks(uint student_roll_number) {

  return students[student_roll_number].get_lowest_mark();
}

inline float get_avergae_marks(uint student_roll_number) {

  return students[student_roll_number].get_average();
}

inline student find_studentByRollNumber(uint roll_number) {
  return students[roll_number];
}
