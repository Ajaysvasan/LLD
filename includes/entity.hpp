#pragma once

#include <iostream>
using std::string;
namespace entity {
struct books {
  short book_id;
  string title;
  string author_name;
  inline books() : book_id(0) {}
  inline books(short book_id, std::string title, std::string author_name) {
    this->book_id = book_id;
    this->title = title;
    this->author_name = author_name;
  }
};

struct copy_book {
  short copy_book_id;
  bool isAvaliable;
  short book_id;
  inline copy_book() : copy_book_id(0), isAvaliable(false), book_id(0) {}
  inline copy_book(short copy_book_id, short book_id) {
    this->copy_book_id = copy_book_id;
    this->book_id = book_id;
    isAvaliable = true;
  }
};

struct member {
  short member_id;
  string member_name;
  inline member() : member_id(0) {}
  inline member(short member_id, string name) {
    this->member_id = member_id;
    this->member_name = name;
  }
};

//  status true -> retunred , false -> borrowed
struct book_borrowed {
  short member_id;
  short copy_book_id;
  bool status;
  inline book_borrowed() : member_id(0), copy_book_id(0), status(false) {}
  inline book_borrowed(short member_id, short copy_book_id) {
    this->member_id = member_id;
    this->copy_book_id = copy_book_id;
    this->status = false;
  }
};
} // namespace entity
