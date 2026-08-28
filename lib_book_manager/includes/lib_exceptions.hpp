
#pragma once
#include <exception>
#include <iostream>
#include <string.h>
using std::string;

class InvalidBookId : public std::exception {
private:
  string message;

public:
  inline InvalidBookId(string msg) : message(msg) {}
  const char *what() const noexcept override { return message.c_str(); }
};

class InvalidMemberId : public std::exception {
private:
  string message;

public:
  inline InvalidMemberId(string msg) : message(msg) {}
  const char *what() const noexcept override { return message.c_str(); }
};
