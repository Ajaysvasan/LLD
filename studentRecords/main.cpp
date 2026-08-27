#include "includes/manage_students.hpp"
#include <iostream>
#include <limits>
#include <string>

static void print_menu() {
  std::cout << "\n===== Student Records =====\n"
            << "1. Add student\n"
            << "2. Add marks\n"
            << "3. Remove student\n"
            << "4. Find student by roll number\n"
            << "5. Highest mark\n"
            << "6. Lowest mark\n"
            << "7. Average mark\n"
            << "0. Exit\n"
            << "Enter your choice : ";
}

static uint read_roll_number() {
  uint roll_number;
  std::cout << "Enter the roll number : ";
  std::cin >> roll_number;
  if (!std::cin) {
    throw InvalidRollNumber("Roll number must be a positive number");
  }
  if (students.find(roll_number) == students.end()) {
    throw InvalidRollNumber("Student with this roll number does not exits");
  }
  return roll_number;
}

void run() {
  int choice = -1;
  while (choice != 0) {
    print_menu();
    if (!(std::cin >> choice)) {
      std::cin.clear();
      std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
      std::cout << "Invalid choice, please enter a number\n";
      choice = -1;
      continue;
    }

    try {
      switch (choice) {
      case 1: {
        add_student();
        std::cout << "Student added\n";
        break;
      }
      case 2: {
        uint roll_number = read_roll_number();
        int number_of_subs;
        std::cout << "Enter the number of subjects : ";
        std::cin >> number_of_subs;
        if (!std::cin || number_of_subs <= 0) {
          throw InvalidSubArgument("Number of subjects must be positive");
        }
        add_marks(roll_number, number_of_subs);
        std::cout << "Marks added\n";
        break;
      }
      case 3: {
        uint roll_number;
        std::cout << "Enter the roll number : ";
        std::cin >> roll_number;
        remove_student(roll_number);
        std::cout << "Student removed\n";
        break;
      }
      case 4: {
        uint roll_number = read_roll_number();
        student s = find_studentByRollNumber(roll_number);
        std::cout << "Roll number : " << s.get_roll_number() << "\n"
                  << "Name        : " << s.get_student_name() << "\n";
        break;
      }
      case 5: {
        uint roll_number = read_roll_number();
        stats mark = get_highest_marks(roll_number);
        std::cout << "Highest : " << mark.sub_name << " - " << mark.marks
                  << "\n";
        break;
      }
      case 6: {
        uint roll_number = read_roll_number();
        stats mark = get_lowest_marks(roll_number);
        std::cout << "Lowest : " << mark.sub_name << " - " << mark.marks
                  << "\n";
        break;
      }
      case 7: {
        uint roll_number = read_roll_number();
        std::cout << "Average : " << get_avergae_marks(roll_number) << "\n";
        break;
      }
      case 0: {
        std::cout << "Bye\n";
        break;
      }
      default:
        std::cout << "Unknown choice, try again\n";
      }
    } catch (const std::exception &e) {
      std::cin.clear();
      std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
      std::cout << "Error : " << e.what() << "\n";
    }
  }
}

int main() {
  run();
  return 0;
}
