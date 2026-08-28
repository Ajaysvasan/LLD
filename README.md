# Library Book Manager

A small console-based library management system written in C++. It lets you
manage books, physical copies of books, members, and borrow/return activity
through an interactive text menu.

## Features

- Add books (title, author)
- Add copies of a book (a book can have multiple physical copies)
- Add members
- Display all books that currently have an available copy
- Look up a book by id
- Look up a member by id (shows their borrowed/returned copies)
- Borrow a copy of a book
- Return a copy of a book

## Project structure

```
.
├── CMakeLists.txt
├── main.cpp                 # entry point / interactive menu (run())
├── includes/
│   ├── entity.hpp            # data structs: books, copy_book, member, book_borrowed
│   ├── lib_exceptions.hpp    # InvalidBookId / InvalidMemberId exceptions
│   └── library.hpp           # library class: core business logic
└── bin/                       # build output (created by CMake)
```

## Building

Requires CMake (>= 3.10) and a C++17 compiler.

```sh
cmake -S . -B build
cmake --build build
```

The compiled binary is placed in `bin/lib_book_manager`.

## Running

```sh
./bin/lib_book_manager
```

You'll be shown a menu:

```
===== Library Book Manager =====
1. Add book
2. Add copy of a book
3. Add member
4. Display available books
5. Find book by id
6. Find member by id
7. Borrow a book
8. Return a book
9. Exit
Choose an option:
```

Follow the prompts to enter ids/names as needed. Invalid ids (e.g. borrowing
a copy that doesn't exist, or reusing an existing book/member id) raise an
error message and return you to the menu instead of crashing.
