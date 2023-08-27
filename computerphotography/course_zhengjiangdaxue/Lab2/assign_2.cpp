#include <opencv2/opencv.hpp>
#include <iostream>
#include <vector>
#include <string>

using namespace cv;
using namespace std;

int main(int argc, char *argv[])
{
      // root Path
    std::string filePath = std::string(__FILE__);
    size_t pos = filePath.find_last_of("/\\");
    std::string rootPath = filePath.substr(0, pos); // string path = string(__BASE_FILE__)+"/img.webp";
    cout << rootPath;
    Mat image = imread(rootPath+"/img.webp",IMREAD_COLOR);
    /**
     * 一、imread
     **/ 

    //! Imread flags
    // enum ImreadModes {
    //        IMREAD_UNCHANGED            = -1, //!< If set, return the loaded image as is (with alpha channel, otherwise it gets cropped). Ignore EXIF orientation.
    //        IMREAD_GRAYSCALE            = 0,  //!< If set, always convert image to the single channel grayscale image (codec internal conversion).
    //        IMREAD_COLOR                = 1,  //!< If set, always convert image to the 3 channel BGR color image.
    //        IMREAD_ANYDEPTH             = 2,  //!< If set, return 16-bit/32-bit image when the input has the corresponding depth, otherwise convert it to 8-bit.
    //        IMREAD_ANYCOLOR             = 4,  //!< If set, the image is read in any possible color format.
    //        IMREAD_LOAD_GDAL            = 8,  //!< If set, use the gdal driver for loading the image.
    //        IMREAD_REDUCED_GRAYSCALE_2  = 16, //!< If set, always convert image to the single channel grayscale image and the image size reduced 1/2.
    //        IMREAD_REDUCED_COLOR_2      = 17, //!< If set, always convert image to the 3 channel BGR color image and the image size reduced 1/2.
    //        IMREAD_REDUCED_GRAYSCALE_4  = 32, //!< If set, always convert image to the single channel grayscale image and the image size reduced 1/4.
    //        IMREAD_REDUCED_COLOR_4      = 33, //!< If set, always convert image to the 3 channel BGR color image and the image size reduced 1/4.
    //        IMREAD_REDUCED_GRAYSCALE_8  = 64, //!< If set, always convert image to the single channel grayscale image and the image size reduced 1/8.
    //        IMREAD_REDUCED_COLOR_8      = 65, //!< If set, always convert image to the 3 channel BGR color image and the image size reduced 1/8.
    //        IMREAD_IGNORE_ORIENTATION   = 128 //!< If set, do not rotate the image according to EXIF's orientation flag.
    //      };
    // IMREAD_UNCHANGED, 无alpha通道
    // Mat image = imread("/Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/opencv-logo.png",IMREAD_UNCHANGED);
    // IMREAD_GRAYSCALE 灰度图
    // Mat image = imread("/Users/sunquan/coding/MyCode/computerphotography/course_zhengjiangdaxue/opencv-logo.png",IMREAD_GRAYSCALE);
    // IMREAD_COLOR

    // root Path
    // std::string filePath = std::string(__FILE__);
    // size_t pos = filePath.find_last_of("/\\");
    // std::string rootPath = filePath.substr(0, pos); // string path = string(__BASE_FILE__)+"/img.webp";
    // cout << rootPath;
    // Mat image = imread(rootPath+"/img.webp",IMREAD_GRAYSCALE);

    // namedWindow("IMREAD_GRAYSCALE");    // 创建一个标题为 "hello" 的窗口
    // imshow("IMREAD_GRAYSCALE", image); // 在窗口 "hello" 中显示图片
    // waitKey(0);              // 等待用户按下键盘
    // destroyWindow("IMREAD_GRAYSCALE");  // 销毁窗口 "hello"



    /**
     * 二、色彩空间
     * */
    //红色
    // vector<Mat> channels;
    // split(image, channels);//bgr
    // channels[0] = Mat::zeros(image.rows, image.cols, CV_8UC1); // blue
    // channels[2] = Mat::zeros(image.rows, image.cols, CV_8UC1); // green
    // Mat red;
    // merge(channels, red);




    /**
     * 三、色彩空间
     **/
    Mat hsv;
    cvtColor(image,hsv,COLOR_BGR2HSV);

    Mat rgb;
    cvtColor(image,rgb,COLOR_BGR2RGB);
    
    Mat yuv;
    cvtColor(image,yuv,COLOR_BGR2YUV);
    
    namedWindow("yuv");    // 创建一个标题为 "hello" 的窗口
    imshow("yuv", yuv); // 在窗口 "hello" 中显示图片
    waitKey(0);              // 等待用户按下键盘
    destroyWindow("yuv");  // 销毁窗口 "hello"
    return 0;
}