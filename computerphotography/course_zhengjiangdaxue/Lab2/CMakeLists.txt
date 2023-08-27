cmake_minimum_required(VERSION 3.10)
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)
project(assign2)
find_package(OpenCV 3 REQUIRED HINTS /usr/local/opt/opencv@3) 

add_executable(assign2 assign_2.cpp)

target_link_libraries(assign2 ${OpenCV_LIBS})
