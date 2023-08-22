#include <opencv2/opencv.hpp>
#include <iostream>
#include <vector>
#include <string>

using namespace cv;

int main(int argc, char* argv[]) {
    Mat image = imread("/Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/Lab1/opencv_demo_1/img.webp"); // 载入名为 "opencv-logo.png" 的图片
    std::cout << "image size: " << image.size() << std::endl;
    namedWindow("hello"); // 创建一个标题为 "hello" 的窗口
    imshow("hello", image); // 在窗口 "hello" 中显示图片
    waitKey(0); // 等待用户按下键盘
    destroyWindow("hello"); // 销毁窗口 "hello"
    return 0;
}