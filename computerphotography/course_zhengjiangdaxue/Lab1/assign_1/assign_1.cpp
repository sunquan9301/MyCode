#include <opencv2/opencv.hpp>
#include <iostream>
#include <vector>
#include <string>

using namespace cv;
using namespace std;

int main(int argc, char *argv[])
{
    // 1. 读取图片
    Mat image = imread("/Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/opencv-logo.png"); // 载入名为 "opencv-logo.png" 的图片

    // 2. opencv基本数据类型
    cout << "image size 1: " << image.size() << endl;
    cout << "image 行数: " << image.rows << endl;
    cout << "image 列数: " << image.cols << endl;
    cout << "image 通道数: " << image.channels() << endl;
    cout << "image type: " << image.type() << endl;
    cout << "CV_8UC1:" << CV_8UC1 << endl;
    cout << "CV_8UC2:" << CV_8UC2 << endl;
    cout << "CV_8UC3:" << CV_8UC3 << endl;
    cout << "CV_8UC4:" << CV_8UC4 << endl;
    cout << "CV_8UC5:" << CV_8UC(5) << endl;

    cout << "CV_8SC1:" << CV_8SC1 << endl;
    cout << "CV_8SC2:" << CV_8SC2 << endl;
    cout << "CV_8SC3:" << CV_8SC3 << endl;
    cout << "CV_8SC4:" << CV_8SC4 << endl;
    cout << "CV_8SC5:" << CV_8SC(5) << endl;

    cout << "CV_16UC1:" << CV_16UC1 << endl;
    cout << "CV_16UC2:" << CV_16UC2 << endl;
    cout << "CV_16UC3:" << CV_16UC3 << endl;
    cout << "CV_16UC4:" << CV_16UC4 << endl;
    cout << "CV_16UC5:" << CV_16UC(5) << endl;

    cout << "CV_16SC1:" << CV_16SC1 << endl;
    cout << "CV_32SC1:" << CV_32SC1 << endl;
    cout << "CV_32FC1:" << CV_32FC1 << endl;
    cout << "CV_64FC1:" << CV_64FC1 << endl;

    // 3. 获取某一个像素值
    cout << "image at 0: " << image.at<Vec3b>(0) << endl;
    cout << "image at 10000000: " << image.at<Vec3b>(10000000) << endl;
    cout << "image at 39999: " << image.at<Vec3b>(39999) << endl;
    cout << "image at 199,199: " << image.at<Vec3b>(199, 199) << endl;

    // 4. 判断一个像素是否是白色
    Vec3b white(255, 255, 255);
    Vec3b black(0, 0, 0);

    cout << "white" << white << endl;

    cout << "isEqual white" << (image.at<Vec3b>(0) == white) << endl;

    // //5. 遍历图片像素，方法1，便利，判断是白色，赋值为黑色
    // for(int i = 0;i<image.rows;i++){
    //     for(int j=0;j<image.cols;j++){
    //         if(image.at<Vec3b>(i,j) == white){
    //             image.at<Vec3b>(i,j) = black;
    //         }
    //     }
    // }

    // 6. 将图片反色
    //  for(int i = 0;i<image.rows;i++){
    //      for(int j=0;j<image.cols;j++){
    //          image.at<Vec3b>(i,j) = white - image.at<Vec3b>(i,j);
    //      }
    //  }
    // 7. 将图片反色， 矩阵减法
    //  Mat m(image.rows,image.cols,CV_8UC3,Scalar(255,255,255));
    //  image = m-image;

    Mat origin(10, 10, CV_32FC1, Scalar(0));
    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            if (i == j)
            {
                cout << "i=" << i << "j=" << j << endl;
                origin.at<float>(i, j) = 2.0;
            }
            else if ((i == j - 1) || (i == j + 1))
            {
                origin.at<float>(i, j) = -1.0;
            }
        }
    }
    // 矩阵 的逆
    Mat invert = origin.inv();
    cout << "origin mat:"<<endl;
    print(origin);
    cout << endl<<"invert mat:"<<endl;
    print(invert);
    //矩阵加法
    cout << endl<< "add mat:"<<endl;
    origin = origin+invert;
    print(origin);
    //矩阵乘法
    cout << endl<< "multiply mat:"<<endl;
    origin = origin*invert;
    print(origin);
    //初始化对角线
    cout << endl<< "eye mat:"<<endl;
    Mat eye = Mat::eye(10,10,CV_32FC1);
    print(eye);
    cout << endl<< "normalize mat:"<<endl;
    Mat result;
    //归一化，最大的位白色，最小的为黑色
    normalize(invert, result, 1.0, 0.0, CV_MINMAX);
    // 现实窗口逻辑
    print(result);
    cout << endl;
    // namedWindow("hello");    // 创建一个标题为 "hello" 的窗口
    // imshow("hello", result); // 在窗口 "hello" 中显示图片
    // waitKey(0);              // 等待用户按下键盘
    // destroyWindow("hello");  // 销毁窗口 "hello"
    // return 0;
}