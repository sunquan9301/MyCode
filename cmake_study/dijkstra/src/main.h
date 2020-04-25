#include <fstream>
#include <iostream>
#include "graph.h"
#include "util.h"
#include "dijkstraSp.h"
using namespace std;
class Main
{
public:
    Main();
    static string GRAPH_FILE;
    void start();
    
    Graph graph;

private:
    ifstream in;
};
