cmake_minimum_required(VERSION 3.13)
project(hahhaha)
# 版本号.
set (Tutorial_VERSION_MAJOR 1)
set (Tutorial_VERSION_MINOR 0)

#========================变量名字=========================
#PROJECT_BINARY_DIR, CMAKE_BINARY_DIR ： build目录
message("project binary dir is ${PROJECT_BINARY_DIR}")
message("cmake binary dir is ${CMAKE_BINARY_DIR}")
#PROJECT_SOURCE_DIR, CMAKE_SOURCE_DIR
message("project source dir is ${PROJECT_SOURCE_DIR}")
message("cmake source dir is ${CMAKE_SOURCE_DIR}")
#CMAKE_CURRENT_SOURCE_DIR
message("cmake current source dir is ${CMAKE_CURRENT_SOURCE_DIR}")

#PROJECT_NAME 通过PROJECT 指令定义的项目名称
message("project name is ${PROJECT_NAME}")
#========================变量名字=========================

#========================系统信息=========================
message("cmake minor version is ${CMAKE_MINOR_VERSION}")
message("cmake major version is ${CMAKE_MAJOR_VERSION}")
#========================系统信息=========================

#========================编译选项=========================
# CMAKE_C_FLAGS	设置 C 编译选项,也可以通过指令 ADD_DEFINITIONS()添加。
# CMAKE_CXX_FLAGS	设置 C++编译选项,也可以通过指令 ADD_DEFINITIONS()添加。
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Os -Werror -DNDEBUG")
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Os -Wno-everything -DNDEBUG")
#========================编译选项=========================

#========================常用指令=========================

#*********  ADD_DEFINITIONS  *********
# 语法 : ADD_DEFINITIONS(-DENABLE_DEBUG -DABC)
# 向 C/C++编译器添加 -D 定义. 如果你的代码中定义了#ifdef ENABLE_DEBUG #endif,这个代码块就会生效。

#*********  add_executable  *********
#add_executable(<name> [source1] [source2])

#*********  add_library  *********
#add_library(<name> [STATIC | SHARED | MODULE] [srouce1] [source2])
#根据源码文件生成目标库
#SHARED库是动态链接的， 并在运行时加载  

#*********  add_subdirectory  *********
#add_subdirectory(name)
#添加一个文件夹进行编译，该文件夹下的CMakeLists.txt负责编译该文件夹下的源码， name是相对于调用add_subdirectory的CMakeList.txt的相对路径

#*********  AUX_SOURCE_DIRECTORY  *********
# AUX_SOURCE_DIRECTORY
# 语法 : AUX_SOURCE_DIRECTORY(dir VARIABLE)

# 作用是发现一个目录下所有的源代码文件并将列表存储在一个变量中,这个指令临时被用来自动构建源文件列表。因为目前 cmake 还不能自动发现新添加的源文件。

# 比如 :

# AUX_SOURCE_DIRECTORY(. SRC_LIST)
# ADD_EXECUTABLE(main ${SRC_LIST})
#demo
# AUX_SOURCE_DIRECTORY(src/main/cpp/libmp3lame/src/ MP3_LAME_SRC_LIST)

# add_library( # Sets the name of the library.
#         lamemp3

#         # Sets the library as a shared library.
#         SHARED

#         # Provides a relative path to your source file(s).
#         ${MP3_LAME_SRC_LIST}
#         )

#*********  CMAKE_MINIMUM_REQUIRED  *********
# CMAKE_MINIMUM_REQUIRED
# 语法 : CMAKE_MINIMUM_REQUIRED 定义 cmake 的最低兼容版本 比如 CMAKE_MINIMUM_REQUIRED(VERSION 2.5 FATAL_ERROR) 如果 cmake 版本小与 2.5,则出现严重错误,整个过程中止。


#*********  file  *********
# FILE(WRITE filename "message to write"... )
# FILE(APPEND filename "message to write"... )
# FILE(READ filename variable)
# FILE(GLOB variable [RELATIVE path] [globbing expression_r_rs]...)
# FILE(GLOB_RECURSE variable [RELATIVE path] [globbing expression_r_rs]...)
# FILE(REMOVE [directory]...)
# FILE(REMOVE_RECURSE [directory]...)
# FILE(MAKE_DIRECTORY [directory]...)
# FILE(RELATIVE_PATH variable directory file)
# FILE(TO_CMAKE_PATH path result)
# FILE(TO_NATIVE_PATH path result)

#*********  if  *********
# if(<condition>)
#   <commands>
# elseif(<condition>) # optional block, can be repeated
#   <commands>
# else()              # optional block
#   <commands>
# endif()

# #####

# IF(var),如果变量不是:空,0,N, NO, OFF, FALSE, NOTFOUND 或<var>_NOTFOUND 时,表达式为真。
# IF(NOT var ),与上述条件相反。
# IF(var1 AND var2),当两个变量都为真是为真。
# IF(var1 OR var2),当两个变量其中一个为真时为真。
# IF(COMMAND cmd),当给定的 cmd 确实是命令并可以调用是为真。
# IF(EXISTS dir)或者 IF(EXISTS file),当目录名或者文件名存在时为真。
# IF(file1 IS_NEWER_THAN file2),当 file1 比 file2 新,或者 file1/file2 其中有一个不存在时为真,文件名请使用完整路径。
# IF(IS_DIRECTORY dirname),当 dirname 是目录时,为真。
# IF(variable MATCHES regex)
# IF(string MATCHES regex)


#*********  foreach  *********
# foreach(<loop_var> <items>)
#   <commands>
# endforeach()

#*********  while  *********
# while(<condition>)
#   <commands>
# endwhile()


# # CMake 最低版本号要求
# cmake_minimum_required (VERSION 2.8)
# # 项目信息
# project (Demo4)
# # 加入一个配置头文件，用于处理 CMake 对源码的设置
# configure_file (
#   "${PROJECT_SOURCE_DIR}/config.h.in"
#   "${PROJECT_BINARY_DIR}/config.h"
#   )
# # 是否使用自己的 MathFunctions 库
# option (USE_MYMATH
#        "Use provided math implementation" ON)
# # 是否加入 MathFunctions 库
# if (USE_MYMATH)
#   include_directories ("${PROJECT_SOURCE_DIR}/math")
#   add_subdirectory (math)  
#   set (EXTRA_LIBS ${EXTRA_LIBS} MathFunctions)
# endif (USE_MYMATH)
# # 查找当前目录下的所有源文件
# # 并将名称保存到 DIR_SRCS 变量
# aux_source_directory(. DIR_SRCS)
# # 指定生成目标
# add_executable(Demo ${DIR_SRCS})
# target_link_libraries (Demo  ${EXTRA_LIBS})
#========================常用指令=========================


#set用法 后面可跟着多个变量，变量之间用分号隔开
set (SRC_LIST main.c other.c)
message("src_list is ${SRC_LIST}")

 # 配置一个头文件来传递一些CMake设置到源代码
configure_file (
    "${PROJECT_SOURCE_DIR}/TutorialConfig.h.in"
    "${PROJECT_BINARY_DIR}/TutorialConfig.h"
    )
# 添加TutorialConfig.h的路径到头文件的搜索路径
include_directories("${PROJECT_BINARY_DIR}")



add_library(myfuns mysqrt.cc)
# 编译源码生成目标
add_executable(mystudy tutorial.cc)
target_link_libraries(mystudy myfuns)
