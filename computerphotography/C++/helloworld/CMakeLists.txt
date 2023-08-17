cmake_minimum_required(VERSION 3.10)
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)
project(opencv_demo)
find_package(OpenCV 3 REQUIRED HINTS /usr/local/opt/opencv@3) 

add_executable(opencv_demo opencv_1.cpp)

target_link_libraries(opencv_demo ${OpenCV_LIBS})
