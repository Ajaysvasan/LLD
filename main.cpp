#include "includes/lib_exceptions.hpp"
#include "includes/library.hpp"
#include <iostream>
#include <limits>

void print_menu() {
  std::cout << "\n===== Library Book Manager =====\n"
             << "1. Add book\n"
             << "2. Add copy of a book\n"
             << "3. Add member\n"
             << "4. Display available books\n"
             << "5. Find book by id\n"
             << "6. Find member by id\n"
             << "7. Borrow a book\n"
             << "8. Return a book\n"
             << "9. Exit\n"
             << "Choose an option: ";
}

short read_short() {
  short value;
  while (!(std::cin >> value)) {
    std::cin.clear();
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    std::cout << "Invalid input, please enter a number: ";
  }
  return value;
}

void run() {
  library lib;
  bool running = true;

  while (running) {
    print_menu();
    short choice = read_short();

    try {
      switch (choice) {
      case 1: {
        std::cout << "Enter book id: ";
        short book_id = read_short();
        std::cin.ignore();
        std::cout << "Enter title: ";
        string title;
        std::getline(std::cin, title);
        std::cout << "Enter author name: ";
        string author_name;
        std::getline(std::cin, author_name);
        lib.add_book(book_id, title, author_name);
        std::cout << "Book added successfully.\n";
        break;
      }
      case 2: {
        std::cout << "Enter copy id: ";
        short copy_id = read_short();
        std::cout << "Enter book id: ";
        short book_id = read_short();
        lib.add_copy_book(copy_id, book_id);
        std::cout << "Copy added successfully.\n";
        break;
      }
      case 3: {
        std::cout << "Enter member id: ";
        short member_id = read_short();
        std::cin.ignore();
        std::cout << "Enter member name: ";
        string member_name;
        std::getline(std::cin, member_name);
        lib.add_member(member_id, member_name);
        std::cout << "Member added successfully.\n";
        break;
      }
      case 4:
        lib.display_books();
        break;
      case 5: {
        std::cout << "Enter book id: ";
        short book_id = read_short();
        lib.find_by_book_id(book_id);
        break;
      }
      case 6: {
        std::cout << "Enter member id: ";
        short member_id = read_short();
        lib.find_by_member_id(member_id);
        break;
      }
      case 7: {
        std::cout << "Enter copy id: ";
        short copy_id = read_short();
        std::cout << "Enter member id: ";
        short member_id = read_short();
        lib.book_borrowed(copy_id, member_id);
        std::cout << "Book borrowed successfully.\n";
        break;
      }
      case 8: {
        std::cout << "Enter copy id: ";
        short copy_id = read_short();
        lib.return_book(copy_id);
        std::cout << "Book returned successfully.\n";
        break;
      }
      case 9:
        running = false;
        std::cout << "Goodbye!\n";
        break;
      default:
        std::cout << "Invalid option, please try again.\n";
      }
    } catch (const InvalidBookId &e) {
      std::cout << "Error: " << e.what() << "\n";
    } catch (const InvalidMemberId &e) {
      std::cout << "Error: " << e.what() << "\n";
    }
  }
}

int main(int argc, char *argv[]) {
  run();
  return 0;
}
