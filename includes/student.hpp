#pragma once
#include "exceptions.hpp"
#include <iostream>
#include <limits>
#include <string>
#include <unordered_map>
#define FLOAT_MIN std::numeric_limits<float>::min();
#define FLOAT_MAX std::numeric_limits<float>::max();
#define uint unsigned int
typedef struct stats {
  std::string sub_name;
  float marks;
} highest_mark, lowest_mark;
class student {
private:
  std::unordered_map<std::string, float> marks;
  uint student_roll_no;
  std::string student_name;

public:
  inline student() : student_roll_no(0) {}
  inline student(uint student_roll_no, std::string student_name) {
    this->student_roll_no = student_roll_no;
    this->student_name = student_name;
  }

  inline void set_student_marks(int number_of_subs) {
    for (int i = 0; i < number_of_subs; i++) {
      std::string sub_name;
      float mark;
      std::cout << "Enter the subject name : \n";
      std::cin >> sub_name;
      std::cout << "Enter the subject mark : \n";
      std::cin >> mark;
      if (mark < 0) {
        throw InvalidMark("Marks can't be negative");
      }
      if (marks.find(sub_name) == marks.end()) {
        marks[sub_name] = mark;
      } else {
        throw InvalidSubArgument("The subject already exists");
      }
    }
  }
  inline uint get_roll_number() { return this->student_roll_no; }
  inline std::string get_student_name() { return this->student_name; }
  inline float get_average() {
    float total = 0;
    short number_of_subs = marks.size();
    for (const auto &[sub_name, mark] : this->marks) {
      total += mark;
    }
    return total / number_of_subs;
  }
  inline stats get_highest_mark() {
    highest_mark mark;
    mark.sub_name = "";
    mark.marks = FLOAT_MIN;
    for (const auto &[sub_name, curr_sub_mark] : this->marks) {
      if (curr_sub_mark >= mark.marks) {
        mark.sub_name = sub_name;
        mark.marks = curr_sub_mark;
      }
    }
    return mark;
  }

  inline stats get_lowest_mark() {
    lowest_mark mark;
    mark.sub_name = "";
    mark.marks = FLOAT_MAX;
    for (const auto &[sub_name, curr_sub_mark] : this->marks) {
      if (curr_sub_mark <= mark.marks) {
        mark.sub_name = sub_name;
        mark.marks = curr_sub_mark;
      }
    }
    return mark;
  }
};
