cmake_minimum_required(VERSION 3.13)

project(cmake)
# 设置
set(CMAKE_CXX_STANDARD 11)

# 编译源码生成目标
add_executable(cmake src/main.cc)