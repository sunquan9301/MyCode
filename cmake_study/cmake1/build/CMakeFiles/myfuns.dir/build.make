# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/local/Cellar/cmake/3.17.0_1/bin/cmake

# The command to remove a file.
RM = /usr/local/Cellar/cmake/3.17.0_1/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/sunquan/project/cmake_study/cmake1

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/sunquan/project/cmake_study/cmake1/build

# Include any dependencies generated for this target.
include CMakeFiles/myfuns.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/myfuns.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/myfuns.dir/flags.make

CMakeFiles/myfuns.dir/mysqrt.cc.o: CMakeFiles/myfuns.dir/flags.make
CMakeFiles/myfuns.dir/mysqrt.cc.o: ../mysqrt.cc
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/sunquan/project/cmake_study/cmake1/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/myfuns.dir/mysqrt.cc.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/myfuns.dir/mysqrt.cc.o -c /Users/sunquan/project/cmake_study/cmake1/mysqrt.cc

CMakeFiles/myfuns.dir/mysqrt.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/myfuns.dir/mysqrt.cc.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/sunquan/project/cmake_study/cmake1/mysqrt.cc > CMakeFiles/myfuns.dir/mysqrt.cc.i

CMakeFiles/myfuns.dir/mysqrt.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/myfuns.dir/mysqrt.cc.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/sunquan/project/cmake_study/cmake1/mysqrt.cc -o CMakeFiles/myfuns.dir/mysqrt.cc.s

# Object files for target myfuns
myfuns_OBJECTS = \
"CMakeFiles/myfuns.dir/mysqrt.cc.o"

# External object files for target myfuns
myfuns_EXTERNAL_OBJECTS =

libmyfuns.a: CMakeFiles/myfuns.dir/mysqrt.cc.o
libmyfuns.a: CMakeFiles/myfuns.dir/build.make
libmyfuns.a: CMakeFiles/myfuns.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/sunquan/project/cmake_study/cmake1/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX static library libmyfuns.a"
	$(CMAKE_COMMAND) -P CMakeFiles/myfuns.dir/cmake_clean_target.cmake
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/myfuns.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/myfuns.dir/build: libmyfuns.a

.PHONY : CMakeFiles/myfuns.dir/build

CMakeFiles/myfuns.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/myfuns.dir/cmake_clean.cmake
.PHONY : CMakeFiles/myfuns.dir/clean

CMakeFiles/myfuns.dir/depend:
	cd /Users/sunquan/project/cmake_study/cmake1/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/sunquan/project/cmake_study/cmake1 /Users/sunquan/project/cmake_study/cmake1 /Users/sunquan/project/cmake_study/cmake1/build /Users/sunquan/project/cmake_study/cmake1/build /Users/sunquan/project/cmake_study/cmake1/build/CMakeFiles/myfuns.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/myfuns.dir/depend
