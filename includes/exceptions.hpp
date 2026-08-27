#pragma once
#include <exception>
#include <string>

class InvalidSubArgument : public std::exception {
private:
  std::string message;

public:
  inline InvalidSubArgument(const std::string msg) : message(msg) {}
  const char *what() const noexcept override { return message.c_str(); }
};

class InvalidRollNumber : public std::exception {
private:
  std::string message;

public:
  inline InvalidRollNumber(const std::string msg) : message(msg) {}
  const char *what() const noexcept override { return message.c_str(); }
};
class InvalidMark : public std::exception {
private:
  std::string message;

public:
  inline InvalidMark(const std::string msg) : message(msg) {}
  const char *what() const noexcept override { return message.c_str(); }
};
