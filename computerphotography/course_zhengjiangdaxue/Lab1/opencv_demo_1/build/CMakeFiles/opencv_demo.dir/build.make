# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.21

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

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /opt/homebrew/Cellar/cmake/3.21.1/bin/cmake

# The command to remove a file.
RM = /opt/homebrew/Cellar/cmake/3.21.1/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1/build

# Include any dependencies generated for this target.
include CMakeFiles/opencv_demo.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/opencv_demo.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/opencv_demo.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/opencv_demo.dir/flags.make

CMakeFiles/opencv_demo.dir/opencv_1.cpp.o: CMakeFiles/opencv_demo.dir/flags.make
CMakeFiles/opencv_demo.dir/opencv_1.cpp.o: ../opencv_1.cpp
CMakeFiles/opencv_demo.dir/opencv_1.cpp.o: CMakeFiles/opencv_demo.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/opencv_demo.dir/opencv_1.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/opencv_demo.dir/opencv_1.cpp.o -MF CMakeFiles/opencv_demo.dir/opencv_1.cpp.o.d -o CMakeFiles/opencv_demo.dir/opencv_1.cpp.o -c /Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1/opencv_1.cpp

CMakeFiles/opencv_demo.dir/opencv_1.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/opencv_demo.dir/opencv_1.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1/opencv_1.cpp > CMakeFiles/opencv_demo.dir/opencv_1.cpp.i

CMakeFiles/opencv_demo.dir/opencv_1.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/opencv_demo.dir/opencv_1.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1/opencv_1.cpp -o CMakeFiles/opencv_demo.dir/opencv_1.cpp.s

# Object files for target opencv_demo
opencv_demo_OBJECTS = \
"CMakeFiles/opencv_demo.dir/opencv_1.cpp.o"

# External object files for target opencv_demo
opencv_demo_EXTERNAL_OBJECTS =

opencv_demo: CMakeFiles/opencv_demo.dir/opencv_1.cpp.o
opencv_demo: CMakeFiles/opencv_demo.dir/build.make
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_stitching.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_superres.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_videostab.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_aruco.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_bgsegm.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_bioinspired.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_ccalib.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_dnn_objdetect.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_dpm.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_face.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_freetype.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_fuzzy.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_hfs.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_img_hash.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_line_descriptor.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_optflow.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_reg.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_rgbd.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_saliency.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_sfm.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_stereo.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_structured_light.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_surface_matching.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_tracking.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_xfeatures2d.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_ximgproc.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_xobjdetect.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_xphoto.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_highgui.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_videoio.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_shape.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_phase_unwrapping.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_dnn.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_video.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_datasets.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_ml.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_plot.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_imgcodecs.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_objdetect.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_calib3d.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_features2d.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_flann.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_photo.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_imgproc.3.4.16.dylib
opencv_demo: /opt/homebrew/opt/opencv@3/lib/libopencv_core.3.4.16.dylib
opencv_demo: CMakeFiles/opencv_demo.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable opencv_demo"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/opencv_demo.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/opencv_demo.dir/build: opencv_demo
.PHONY : CMakeFiles/opencv_demo.dir/build

CMakeFiles/opencv_demo.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/opencv_demo.dir/cmake_clean.cmake
.PHONY : CMakeFiles/opencv_demo.dir/clean

CMakeFiles/opencv_demo.dir/depend:
	cd /Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1 /Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1 /Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1/build /Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1/build /Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1/build/CMakeFiles/opencv_demo.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/opencv_demo.dir/depend

