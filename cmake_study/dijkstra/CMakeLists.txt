# cmake 最低版本需求
cmake_minimum_required(VERSION 3.13)

# 工程名称
project(hahah)

# 设置
set(CMAKE_CXX_STANDARD 11)

# 编译源码生成目标
add_executable(dijkstra 
src/main.cpp
src/graph.cpp
src/heap.cpp
src/dijkstraSp.cpp
src/util.cpp
)