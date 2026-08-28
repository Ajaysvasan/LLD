#pragma once
#include "entity.hpp"
#include "lib_exceptions.hpp"
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace entity;
using std::unordered_map;
using std::vector;

class library {
private:
  unordered_map<short, entity::books> books;
  unordered_map<short, entity::copy_book> copy_books_map;
  unordered_map<short, entity::member> members;
  unordered_map<short, entity::book_borrowed> borrowed_books;
  void display_borrowed_books(short member_id) {
    for (const auto &[copy_id, bb] : borrowed_books) {
      if (bb.member_id == member_id) {
        string book_name = books[copy_books_map[bb.copy_book_id].book_id].title;
        std::cout << copy_books_map[bb.copy_book_id].copy_book_id << " - "
                  << book_name << " - " << (bb.status ? "returned" : "borrowed")
                  << "\n";
      }
    }
  }

public:
  void add_book(short book_id, string title, string author_name) {
    if (books.find(book_id) == books.end()) {

      entity::books new_book(book_id, title, author_name);
      books[book_id] = new_book;
    } else {
      throw InvalidBookId("The book id already exists");
    }
  }

  void add_copy_book(short copy_book_id, short book_id) {
    if (books.find(book_id) == books.end()) {
      throw InvalidBookId("The book with the given id is not found");
    }
    if (copy_books_map.find(copy_book_id) == copy_books_map.end()) {

      entity::copy_book new_copy(copy_book_id, book_id);
      copy_books_map[copy_book_id] = new_copy;
    } else {
      throw InvalidBookId("The copy book id already exists");
    }
  }
  void add_member(short member_id, string member_name) {
    if (members.find(member_id) == members.end()) {
      members[member_id] = entity::member(member_id, member_name);
    } else {
      throw InvalidMemberId("The member with this id already exists");
    }
  }
  void display_books() {
    short i = 1;
    // Display those books to which copies are there and it avaliable
    for (const auto &[book_id, book] : books) {
      if (is_copy_avaliable(book_id)) {
        std::cout << i++ << ". " << book.title << " by " << book.author_name
                  << "\n";
      }
    }
  }
  bool is_copy_avaliable(short book_id) {
    for (const auto &[copy_id, copy_book] : copy_books_map) {
      if (copy_book.book_id == book_id && copy_book.isAvaliable) {
        return true;
      }
    }
    return false;
  }
  short book_borrowed(short copy_id, short member_id) {
    if (members.find(member_id) == members.end()) {
      throw InvalidMemberId("The member with the given id is not found");
    }
    if (copy_books_map.find(copy_id) != copy_books_map.end() &&
        copy_books_map[copy_id].isAvaliable) {
      copy_books_map[copy_id].isAvaliable = false;
      borrowed_books[copy_id] = (entity::book_borrowed(member_id, copy_id));
      return copy_id;
    } else {
      throw InvalidBookId("The id you have entered is not found");
    }
  }
  void find_by_book_id(short book_id) {
    if (books.find(book_id) != books.end()) {
      std::cout << books[book_id].book_id << "\n"
                << books[book_id].title << "\n"
                << books[book_id].author_name << "\n"
                << (is_copy_avaliable(book_id) ? "available" : "borrowed")
                << "\n";
    } else {
      throw InvalidBookId("The book with the given id is not found");
    }
  }
  bool return_book(short copy_id) {

    if (borrowed_books.find(copy_id) != borrowed_books.end()) {
      if (borrowed_books[copy_id].status) {
        throw InvalidBookId("This copy has already been returned");
      }
      copy_books_map[copy_id].isAvaliable = true;
      borrowed_books[copy_id].status = true;
      return true;
    } else {
      throw InvalidBookId("The id you have entered is not found");
    }
  }
  void find_by_member_id(short member_id) {
    if (members.find(member_id) != members.end()) {
      std::cout << members[member_id].member_name << "\n"
                << members[member_id].member_id;
      std::cout << "\nbooks borrowed:\n";
      display_borrowed_books(member_id);
    } else {
      throw InvalidMemberId("The member with the given id is not found");
    }
  }
};
