#include "main.h"
string Main::GRAPH_FILE = "../Ginput.txt";

Main::Main()
{
    in.open(Main::GRAPH_FILE);
    int v, m;
    in >> v;
    in >> m;
    graph.init(v, m);
}

void Main::start()
{

    while (!in.eof())
    {
        int v, m;
        double weight;
        in >> v;
        in >> m;
        in >> weight;
        graph.addEdge(v, m, weight);
    }
  
    graph.toString();
    DijkstraSp sp(graph.V());
    sp.init(&graph,1);
    sp.toString();
    // sp.init(0);
    // sp.toString();

    // while (true)
    // {
    //     string command;
    //     cout << ">";
    //     cin >> command;
    //     if (command.compare("S") == 0)
    //     {
    //         break;
    //     }
    //     else if (command.compare("R") == 0)
    //     {
    //         if (!in.eof())
    //         {
    //             int v, m;
    //             double weight;
    //             in >> v;
    //             in >> m;
    //             in >> weight;
    //             graph.addEdge(v, m, weight);
    //         }
    //     }
    //     else if (command.compare("W") == 0)
    //     {
    //         cout << "command is W" << endl;
    //         graph.toString();
    //     }
    //     // else if (Util::startWith(command, "F"))
    //     // {
    //     //     int sVertice, targetVertice, flag;
    //     //     cin >> sVertice;
    //     //     cin >> targetVertice;
    //     //     cin >> flag;
    //     //     cout << "s: " << sVertice << "; t: " << targetVertice << "; flag: " << flag << endl;
    //     // }
    //     else
    //         cout << "please input correct command." << command << endl;
    // }

    in.close();
}
int main()
{
    Main main;
    main.start();

    // int *qp;
    // qp = new int[10];
    // for (int i = 0; i <= 10; i++)
    // {
    //     qp[i] = i;
    // }
    // cout << qp[3] << endl;

    return 0;
}