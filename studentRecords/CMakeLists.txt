cmake_minimum_required(VERSION 3.16)

project(studentRecords LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

if(NOT CMAKE_BUILD_TYPE AND NOT CMAKE_CONFIGURATION_TYPES)
  set(CMAKE_BUILD_TYPE Debug CACHE STRING "Build type" FORCE)
endif()

add_executable(studentRecords main.cpp)

target_include_directories(studentRecords PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/includes)

set_target_properties(studentRecords PROPERTIES
  RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/bin)

if(MSVC)
  target_compile_options(studentRecords PRIVATE /W4)
else()
  target_compile_options(studentRecords PRIVATE -Wall -Wextra)
endif()
