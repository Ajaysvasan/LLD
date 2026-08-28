cmake_minimum_required(VERSION 3.10)
project(lib_book_manager CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/bin)

add_executable(lib_book_manager main.cpp)
target_include_directories(lib_book_manager PRIVATE includes)
