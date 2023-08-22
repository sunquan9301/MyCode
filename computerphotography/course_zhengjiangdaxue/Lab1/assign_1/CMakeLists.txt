cmake_minimum_required(VERSION 3.10)
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)
project(assign1)
find_package(OpenCV 3 REQUIRED HINTS /usr/local/opt/opencv@3) 

add_executable(assign1 assign_1.cpp)

target_link_libraries(assign1 ${OpenCV_LIBS})
