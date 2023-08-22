#include <opencv2/opencv.hpp>
#include <iostream>
#include <vector>
#include <string>

using namespace cv;
using namespace std;

int main(int argc, char* argv[]) {
    Mat image = imread("/Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/opencv-logo.png"); // 载入名为 "opencv-logo.png" 的图片
    cout << "image size 1: " << image.size() << endl;
    cout << "image rows 1: " << image.rows << endl;


    // cout << "image size 1: " << image.row() << endl;




    namedWindow("hello"); // 创建一个标题为 "hello" 的窗口
    imshow("hello", image); // 在窗口 "hello" 中显示图片
    waitKey(0); // 等待用户按下键盘
    destroyWindow("hello"); // 销毁窗口 "hello"
    return 0;
}