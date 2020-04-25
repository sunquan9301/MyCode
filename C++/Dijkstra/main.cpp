#include "main.h"
string Main::GRAPH_FILE = "Ginput1.txt";

Main::Main()
{
}

void Main::start()
{

    // in.open(Main::GRAPH_FILE);
    // int v, m;
    // in >> v;
    // in >> m;
    // graph.init(v, m);
    // while (!in.eof())
    // {
    //     int v, m;
    //     double weight;
    //     in >> v;
    //     in >> m;
    //     in >> weight;
    //     graph.addEdge(v, m, weight);
    // }
    // graph.toString();
    // DijkstraSp sp(graph.V());
    // sp.init(&graph, 1);
    // sp.toString();
    // sp.toPathString(6);

    while (true)
    {
        string command;
        cout << "COMMAND: ";
        cin >> command;
        if (command.compare("S") == 0)
        {
            break;
        }
        else if (command.compare("R") == 0)
        {
            in.open(Main::GRAPH_FILE);
            int v, m;
            in >> v;
            in >> m;
            graph.init(v, m);
            while (!in.eof())
            {
                int v, m;
                double weight;
                in >> v;
                in >> m;
                in >> weight;
                graph.addEdge(v, m, weight);
            }
        }
        else if (command.compare("W") == 0)
        {
            if (graph.V() == 0)
            {
                cout << "Error: graph not initialized" << endl;
            }
            else
            {
                graph.toString();
            }
        }
        else if (Util::startWith(command, "F"))
        {
            int sVertice, targetVertice, flag;
            cin >> sVertice;
            cin >> targetVertice;
            cin >> flag;
            if (graph.V() == 0)
            {
                cout << "Error: graph not initialized" << endl;
            }
            else
            {
                if (sVertice < 1 || sVertice > graph.V() || targetVertice < 1 || targetVertice > graph.V())
                {
                    cout << "one or more invalid nodes" << endl;
                }
                else
                {
                    DijkstraSp sp(graph.V());
                    sp.init(&graph, sVertice);
                    // sp.toString();
                    if (!sp.hassPathTo(targetVertice))
                    {
                        cout << "Error: node" << targetVertice << " not reachable from node "<<sVertice<<endl;
                    }
                    else
                    {
                        if (flag == 1)
                        {
                            cout << "LENGTH: " << sp.queryDistTo(targetVertice) << endl;
                        }
                        else if (flag == 0)
                        {
                            sp.toPathString(targetVertice);
                        }
                        else
                        {
                            cout << "invalid flag value" << endl;
                        }
                    }
                }
            }
        }
        else
            cout << "please input correct command." << command << endl;
    }

    in.close();
}
int main()
{
    Main main;
    main.start();
    return 0;
}