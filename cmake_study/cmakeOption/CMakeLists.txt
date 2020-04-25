cmake_minimum_required(VERSION 3.13)
#需要用自定义的数学函数么？
option (USE_MYMATH
            "Use tutorial provided math implementation" ON)
project(hahhaha)
# 版本号.
set (Tutorial_VERSION_MAJOR 1)
set (Tutorial_VERSION_MINOR 0)

 # 配置一个头文件来传递一些CMake设置到源代码
configure_file (
    "${PROJECT_SOURCE_DIR}/TutorialConfig.h.in"
    "${PROJECT_BINARY_DIR}/TutorialConfig.h"
    )
# 添加TutorialConfig.h的路径到头文件的搜索路径
include_directories("${PROJECT_BINARY_DIR}")



# add the MathFunctions library?
if (USE_MYMATH)
  include_directories ("${PROJECT_SOURCE_DIR}/MathFunctions")
  add_subdirectory (MathFunctions)
  set (EXTRA_LIBS ${EXTRA_LIBS} myfuns)
endif (USE_MYMATH)
# 编译源码生成目标
add_executable(mystudy tutorial.cc)
target_link_libraries(mystudy ${EXTRA_LIBS})
