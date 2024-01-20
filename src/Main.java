import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.*;
import java.util.*;
import java.sql.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int INF=Integer.MAX_VALUE;
    static ArrayList<Edge> USAnetwork[];
    static ArrayList<Edge> Cost239[];
    static ArrayList<Edge> NSFnetwork[];
    static ArrayList<Edge> Opticalnetwork[];

    //node degree of each node
    static int Cost239_nodaldeg[] ={-1,4,4,5,5,5,5,5,6,5,4,4};
    static int NSFnetwork_nodaldeg[] = {-1,3,3,3,3,3,4,3,3,4,3,3,3,3,3};
    static int Opticalnetwork_nodaldeg[] = {3,3,4,3,5,3,3,3,4,3,4,4,3,3};
    static int USnetwork_nodaldeg[] = {3,3,4,3,3,5,5,3,5,4,5,4,4,3,3,5,5,3,2,3,3,4,3,2};

    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.weight = wt;
        }
    }

    static void createGraph1(ArrayList<Edge> g1[]) {
        for (int i = 0; i < g1.length; i++)
            g1[i] = new ArrayList<>();

        g1[0].add(new Edge(0, 1, 800));
        g1[0].add(new Edge(0, 5, 1000));

        g1[1].add(new Edge(1, 2, 1100));
        g1[1].add(new Edge(1, 5, 950));

        g1[2].add(new Edge(2, 1, 1100));
        g1[2].add(new Edge(2, 3, 250));
        g1[2].add(new Edge(2, 4, 800));
        g1[2].add(new Edge(2, 6, 1000));

        g1[3].add(new Edge(3, 2, 250));
        g1[3].add(new Edge(3, 4, 800));
        g1[3].add(new Edge(3, 6, 850));

        g1[4].add(new Edge(4, 2, 800));
        g1[4].add(new Edge(4, 3, 800));
        g1[4].add(new Edge(4, 7, 1200));

        g1[5].add(new Edge(5, 0, 1000));
        g1[5].add(new Edge(5, 1, 950));
        g1[5].add(new Edge(5, 6, 1000));
        g1[5].add(new Edge(5, 8, 1200));
        g1[5].add(new Edge(5, 10, 1900));

        g1[6].add(new Edge(6, 2, 1000));
        g1[6].add(new Edge(6, 3, 850));
        g1[6].add(new Edge(6, 5, 1000));
        g1[6].add(new Edge(6, 7, 1150));
        g1[6].add(new Edge(6, 8, 1000));

        g1[7].add(new Edge(7, 4, 1200));
        g1[7].add(new Edge(7, 6, 1150));
        g1[7].add(new Edge(7, 9, 900));

        g1[8].add(new Edge(8, 5, 1200));
        g1[8].add(new Edge(8, 6, 1000));
        g1[8].add(new Edge(8, 9, 1000));
        g1[8].add(new Edge(8, 10, 1400));
        g1[8].add(new Edge(8, 11, 1000));

        g1[9].add(new Edge(9, 7, 900));
        g1[9].add(new Edge(9, 8, 1000));
        g1[9].add(new Edge(9, 12, 950));
        g1[9].add(new Edge(9, 13, 850));

        g1[10].add(new Edge(10, 5, 1900));
        g1[10].add(new Edge(10, 8, 1400));
        g1[10].add(new Edge(10, 11, 900));
        g1[10].add(new Edge(10, 14, 1300));
        g1[10].add(new Edge(10, 18, 2600));

        g1[11].add(new Edge(11, 8, 1000));
        g1[11].add(new Edge(11, 10, 900));
        g1[11].add(new Edge(11, 12, 900));
        g1[11].add(new Edge(11, 15, 1000));

        g1[12].add(new Edge(12, 9, 950));
        g1[12].add(new Edge(12, 11, 900));
        g1[12].add(new Edge(12, 13, 650));
        g1[12].add(new Edge(12, 16, 1100));

        g1[13].add(new Edge(13, 9, 850));
        g1[13].add(new Edge(13, 12, 650));
        g1[13].add(new Edge(13, 17, 1200));

        g1[14].add(new Edge(14, 10, 1300));
        g1[14].add(new Edge(14, 15, 600));
        g1[14].add(new Edge(14, 19, 1300));

        g1[15].add(new Edge(15, 11, 1000));
        g1[15].add(new Edge(15, 14, 600));
        g1[15].add(new Edge(15, 16, 1000));
        g1[15].add(new Edge(15, 20, 1000));
        g1[15].add(new Edge(15, 21, 800));

        g1[16].add(new Edge(16, 12, 1100));
        g1[16].add(new Edge(16, 15, 1000));
        g1[16].add(new Edge(16, 17, 800));
        g1[16].add(new Edge(16, 21, 850));
        g1[16].add(new Edge(16, 22, 1000));

        g1[17].add(new Edge(17, 13, 1200));
        g1[17].add(new Edge(17, 16, 800));
        g1[17].add(new Edge(17, 23, 900));

        g1[18].add(new Edge(18, 10, 2600));
        g1[18].add(new Edge(18, 19, 1200));

        g1[19].add(new Edge(19, 14, 1300));
        g1[19].add(new Edge(19, 18, 1200));
        g1[19].add(new Edge(19, 20, 700));

        g1[20].add(new Edge(20, 15, 1000));
        g1[20].add(new Edge(20, 19, 700));
        g1[20].add(new Edge(20, 21, 300));

        g1[21].add(new Edge(21, 15, 800));
        g1[21].add(new Edge(21, 16, 850));
        g1[21].add(new Edge(21, 20, 300));
        g1[21].add(new Edge(21, 22, 600));

        g1[22].add(new Edge(22, 16, 1000));
        g1[22].add(new Edge(22, 21, 600));
        g1[22].add(new Edge(22, 23, 900));

        g1[23].add(new Edge(23, 17, 900));
        g1[23].add(new Edge(23, 22, 900));

    }

    static void createGraph2(ArrayList<Edge> g2[]) {
        for (int i = 0; i < g2.length; i++)
            g2[i] = new ArrayList<>();

        g2[1].add(new Edge(1, 2, 1310));
        g2[1].add(new Edge(1, 3, 760));
        g2[1].add(new Edge(1, 4, 390));
        g2[1].add(new Edge(1, 7, 740));

        g2[2].add(new Edge(2, 1, 1310));
        g2[2].add(new Edge(2, 3, 550));
        g2[2].add(new Edge(2, 5, 390));
        g2[2].add(new Edge(2, 8, 450));

        g2[3].add(new Edge(3, 1, 760));
        g2[3].add(new Edge(3, 2, 550));
        g2[3].add(new Edge(3, 4, 660));
        g2[3].add(new Edge(3, 5, 210));
        g2[3].add(new Edge(3, 6, 390));

        g2[4].add(new Edge(4, 1, 390));
        g2[4].add(new Edge(4, 3, 660));
        g2[4].add(new Edge(4, 7, 340));
        g2[4].add(new Edge(4, 8, 1090));
        g2[4].add(new Edge(4, 10, 660));

        g2[5].add(new Edge(5, 2, 390));
        g2[5].add(new Edge(5, 3, 210));
        g2[5].add(new Edge(5, 6, 220));
        g2[5].add(new Edge(5, 8, 300));
        g2[5].add(new Edge(5, 11, 930));

        g2[6].add(new Edge(6, 3, 390));
        g2[6].add(new Edge(6, 5, 220));
        g2[6].add(new Edge(6, 7, 730));
        g2[6].add(new Edge(6, 8, 400));
        g2[6].add(new Edge(6, 9, 350));

        g2[7].add(new Edge(7, 1, 740));
        g2[7].add(new Edge(7, 4, 340));
        g2[7].add(new Edge(7, 6, 730));
        g2[7].add(new Edge(7, 9, 565));
        g2[7].add(new Edge(7, 10, 320));

        g2[8].add(new Edge(8, 2, 450));
        g2[8].add(new Edge(8, 4, 1090));
        g2[8].add(new Edge(8, 5, 300));
        g2[8].add(new Edge(8, 6, 400));
        g2[8].add(new Edge(8, 9, 600));
        g2[8].add(new Edge(8, 11, 820));

        g2[9].add(new Edge(9, 6, 350));
        g2[9].add(new Edge(9, 7, 565));
        g2[9].add(new Edge(9, 8, 600));
        g2[9].add(new Edge(9, 10, 730));
        g2[9].add(new Edge(9, 11, 320));

        g2[10].add(new Edge(10, 4, 660));
        g2[10].add(new Edge(10, 7, 320));
        g2[10].add(new Edge(10, 9, 730));
        g2[10].add(new Edge(10, 11, 820));

        g2[11].add(new Edge(11, 5, 930));
        g2[11].add(new Edge(11, 9, 320));
        g2[11].add(new Edge(11, 8, 820));
        g2[11].add(new Edge(11, 10, 820));
    }

    static void createGraph3(ArrayList<Edge> g3[]) {
        for (int i = 0; i < g3.length; i++)
            g3[i] = new ArrayList<>();

        g3[1].add(new Edge(1, 2, 1100));
        g3[1].add(new Edge(1, 3, 600));
        g3[1].add(new Edge(1, 4, 1000));

        g3[1].add(new Edge(2, 1, 1100));
        g3[2].add(new Edge(2, 3, 600));
        g3[2].add(new Edge(2, 8, 2800));

        g3[3].add(new Edge(3, 1, 600));
        g3[3].add(new Edge(3, 2,600));
        g3[3].add(new Edge(3, 6, 2000));

        g3[4].add(new Edge(4, 1, 1000));
        g3[4].add(new Edge(4, 5, 600));
        g3[4].add(new Edge(4, 11, 2400));

        g3[5].add(new Edge(5, 4, 600));
        g3[5].add(new Edge(5, 6, 1100));
        g3[5].add(new Edge(5, 7, 800));

        g3[6].add(new Edge(6, 3, 2000));
        g3[6].add(new Edge(6, 5, 1100));
        g3[6].add(new Edge(6, 10, 1200));
        g3[6].add(new Edge(6, 14, 2000));

        g3[7].add(new Edge(7, 5, 800));
        g3[7].add(new Edge(7, 8, 700));
        g3[7].add(new Edge(7, 10, 1300));

        g3[8].add(new Edge(8, 2, 2800));
        g3[8].add(new Edge(8, 7, 700));
        g3[8].add(new Edge(8, 9, 700));

        g3[9].add(new Edge(9, 8, 700));
        g3[9].add(new Edge(9, 10, 900));
        g3[9].add(new Edge(9, 12, 500));
        g3[9].add(new Edge(9, 13, 500));

        g3[10].add(new Edge(10, 6, 1200));
        g3[10].add(new Edge(10, 7, 1300));
        g3[10].add(new Edge(10, 9, 900));

        g3[11].add(new Edge(11, 4, 2400));
        g3[11].add(new Edge(11, 12, 800));
        g3[11].add(new Edge(11, 13, 1000));

        g3[12].add(new Edge(12, 9, 500));
        g3[12].add(new Edge(12, 11, 800));
        g3[12].add(new Edge(12, 14, 500));

        g3[13].add(new Edge(13, 9, 500));
        g3[13].add(new Edge(13, 11, 1000));
        g3[13].add(new Edge(13, 14, 300));

        g3[14].add(new Edge(14, 6, 2000));
        g3[14].add(new Edge(14, 12, 500));
        g3[14].add(new Edge(14, 13, 300));

    }

    static void createGraph4(ArrayList<Edge> g4[]) {
        for (int i = 0; i < g4.length; i++)
            g4[i] = new ArrayList<>();

        g4[0].add(new Edge(0, 1, 238));
        g4[0].add(new Edge(0, 3, 408));
        g4[0].add(new Edge(0, 4, 744));

        g4[1].add(new Edge(1, 0, 238));
        g4[1].add(new Edge(1, 2, 687));
        g4[1].add(new Edge(1, 5, 1153));

        g4[2].add(new Edge(2, 1, 687));
        g4[2].add(new Edge(2, 3, 77));
        g4[2].add(new Edge(2, 8,980 ));
        g4[2].add(new Edge(2, 9, 1479));

        g4[3].add(new Edge(3, 0, 408));
        g4[3].add(new Edge(3, 2, 77));
        g4[3].add(new Edge(3, 4, 601));

        g4[4].add(new Edge(4, 0, 744));
        g4[4].add(new Edge(4, 3, 601));
        g4[4].add(new Edge(4, 5, 549));
        g4[4].add(new Edge(4, 9, 1416));
        g4[4].add(new Edge(4, 12, 839));

        g4[5].add(new Edge(5, 1, 1153));
        g4[5].add(new Edge(5, 4, 549));
        g4[5].add(new Edge(5, 6, 545));

        g4[6].add(new Edge(6, 5, 545));
        g4[6].add(new Edge(6, 7, 163));
        g4[6].add(new Edge(6, 8, 1987));

        g4[7].add(new Edge(7, 6, 163));
        g4[7].add(new Edge(7, 11, 835));
        g4[7].add(new Edge(7, 13, 1221));

        g4[8].add(new Edge(8, 2, 980));
        g4[8].add(new Edge(8, 6, 1987));
        g4[8].add(new Edge(8, 9, 1081));
        g4[8].add(new Edge(8, 10, 1676));

        g4[9].add(new Edge(9, 2, 1479));
        g4[9].add(new Edge(9, 4, 1416));
        g4[9].add(new Edge(9, 8, 1081));

        g4[10].add(new Edge(10, 8, 1676));
        g4[10].add(new Edge(10, 11, 331));
        g4[10].add(new Edge(10, 12, 688));
        g4[10].add(new Edge(10, 13, 684));

        g4[11].add(new Edge(11, 7, 835));
        g4[11].add(new Edge(11, 10, 331));
        g4[11].add(new Edge(11, 12, 562));
        g4[11].add(new Edge(11, 13, 533));

        g4[12].add(new Edge(12, 4, 839));
        g4[12].add(new Edge(12, 10, 688));
        g4[12].add(new Edge(12, 11, 562));

        g4[13].add(new Edge(13, 7, 1221));
        g4[13].add(new Edge(13, 10, 684));
        g4[13].add(new Edge(13, 11, 533));

    }

    static class Pair implements Comparable<Pair>
    {
        int n;
        int path;
        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }
    public static int[][] dijkstra(ArrayList<Edge> graph[], int src)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        int parent[]=new int[graph.length];
        int answer[][]=new int[2][graph.length];
        for(int i=0; i<dist.length; i++)
        {
            if(i != src)
            {
                dist[i] = INF;
                parent[i]=-1;
            }
            else
            {
                dist[i]=0;
                parent[i]=i;
            }
        }
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty())
        {
            Pair curr = pq.remove();
            if(!vis[curr.n])
            {
                vis[curr.n] = true;
                for(int i=0; i<graph[curr.n].size(); i++)
                {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(!vis[v] && dist[u]+e.weight < dist[v])
                    {
                        dist[v] = dist[u] + e.weight;
                        parent[v]=u;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        answer[0]=parent;
        answer[1]=dist;
        return answer;
    }
    static void delEdge(ArrayList<Edge> adj[],int u, int v)
    {
        // Traversing through the first vector list
        // and removing the second element from it
        for (int i = 0; i < adj[u].size(); i++)
        {
            Edge e=adj[u].get(i);
            if (e.dest== v)
            {
                adj[u].remove(i);
                break;
            }
        }

        // Traversing through the second vector list
        // and removing the first element from it
        for (int i = 0; i < adj[v].size(); i++)
        {
            Edge e=adj[v].get(i);
            if (e.dest == u)
            {
                adj[v].remove(i);
                break;
            }
        }
    }
    static void generateRequestMenu(String NetworkName[], int startInd[], int endInd[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("------Category Of Request-------");
            System.out.println("1.LSD");
            System.out.println("2.MSD");
            System.out.println("3.HSD");
            System.out.println("4.VSD");
            System.out.println("5.Exit");
            System.out.println("---------------------------------");
            System.out.println("Enter Your Choice: ");
            int n = sc.nextInt();
            int datarate;

            switch (n) {
                case 1:
                    datarate = 60;
                    for (int i = 0; i < NetworkName.length; i++)
                        generateRequest(NetworkName[i], startInd[i], endInd[i], datarate, "LSD");
                    break;
                case 2:
                    datarate = 120;
                    for (int i = 0; i < NetworkName.length; i++)
                        generateRequest(NetworkName[i], startInd[i], endInd[i], datarate, "MSD");
                    break;
                case 3:
                    datarate = 180;
                    for (int i = 0; i < NetworkName.length; i++)
                        generateRequest(NetworkName[i], startInd[i], endInd[i], datarate, "HSD");
                    break;
                case 4:
                    datarate = 30;
                    for (int i = 0; i < NetworkName.length; i++)
                        generateRequest(NetworkName[i], startInd[i], endInd[i], datarate, "VSD");
                    break;

                case 5:
                    flag = false;
                    break;

            }
        } while (flag == true);

    }

    static void generateRequest(String NetworkName, int startInd, int endInd, int dataRate, String categoryOfDemand) throws IOException {
        Random rand = new Random();
        int noOfRequest;
        for (noOfRequest = 50; noOfRequest <= 300; noOfRequest += 50) {
            try {
                File fileObj = new File(String.format("%s_%s_%d", NetworkName, categoryOfDemand, noOfRequest));
                fileObj.createNewFile();
                FileWriter fileob = new FileWriter(String.format("%s_%s_%d", NetworkName, categoryOfDemand, noOfRequest), false);
                for (int j = 1; j <= noOfRequest; j++) {
                    String source = String.valueOf(rand.nextInt(startInd, endInd + 1));
                    String dest = String.valueOf(rand.nextInt(startInd, endInd + 1));
                    String data;
                    while (source.equals(dest)) {
                        dest = String.valueOf(rand.nextInt(startInd, endInd));
                    }
                    if (categoryOfDemand.equals("VSD")) {
                        int x = rand.nextInt(2, 7);
                        data = String.valueOf(dataRate * x);
                    } else {
                        data = String.valueOf(dataRate);
                    }
                    String s = source + "," + dest + "," + data;
                    fileob.write(s + "\n");

                }
                fileob.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    static void generateAllPath(String NetworkName[],int startInd[],int endInd[])
    {
        try{
            //Intialization

            ArrayList<Edge> graph[];
            //Load the driver

            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url="jdbc:mysql://localhost:3306/all_path";
            Connection con=DriverManager.getConnection(url,"root","");

            for(int network=0;network<NetworkName.length;network++) {
                int start = startInd[network];
                int V = endInd[network] + 1;
                int src;
                int ShortestPath[][] = new int[2][V];
                int parent[] = new int[V];
                int parent2[] = new int[V];
                int distance[] = new int[V];
                int distance2[] = new int[V];
                String p1="";
                String p2="";
                String p3="";
                String q1,q2,q3;
                PreparedStatement pstmt1;
                PreparedStatement pstmt2;
                PreparedStatement pstmt3;

                ArrayList<Integer> path1 = new ArrayList<>();
                ArrayList<Integer> path2 = new ArrayList<>();
                graph=new ArrayList[V];
                switch (network)
                {
                    case 0:

                        createGraph1(graph);
                        break;
                    case 1:
                        //graph=new ArrayList[V];
                        createGraph2(graph);
                        break;
                    case 2:
                        //graph=new ArrayList[V];
                        createGraph3(graph);
                        break;
                    case 3:
                        //graph=new ArrayList[V];
                        createGraph4(graph);
                        break;

                }

                for (src = start; src < V; src++) {
                    ShortestPath = dijkstra(graph, src);
                    System.arraycopy(ShortestPath[0], 0, parent, 0, V);
                    System.arraycopy(ShortestPath[1], 0, distance, 0, V);

                    int node;
                    for (int i = start; i < V; i++) {
                        node = i;
                        path1.add(i);
                        p1="";
                        p1=p1+i+',';
                        while (parent[node] != node) {
                            if (parent[node] == -1) {
                                //System.out.println("not reachable");
                                break;
                            }
                            path1.add(parent[node]);
                            p1=p1+parent[node]+',';
                            node = parent[node];
                        }

                        String key = String.format("%s,%s", src, i);
                        //key = key + ",0";
                        if(network==0) {

                            q1="insert into usa_network(pair,path1,distance1) values (?,?,?)";

                            //get the PreparedStatment object
                            pstmt1=con.prepareStatement(q1);
                            pstmt1.setString(1,key);
                            pstmt1.setString(2,p1);
                            pstmt1.setInt(3,distance[i]);

                            pstmt1.executeUpdate();
                        }
                        else if(network==1)
                        {
                            q1="insert into cost239_network(pair,path1,distance1) values (?,?,?)";

                            //get the PreparedStatment object
                            pstmt1=con.prepareStatement(q1);
                            pstmt1.setString(1,key);
                            pstmt1.setString(2,p1);
                            pstmt1.setInt(3,distance[i]);

                            pstmt1.executeUpdate();
                        }
                        else if(network==2)
                        {

                            q1="insert into nsf_network(pair,path1,distance1) values (?,?,?)";

                            //get the PreparedStatment object
                            pstmt1=con.prepareStatement(q1);
                            pstmt1.setString(1,key);
                            pstmt1.setString(2,p1);
                            pstmt1.setInt(3,distance[i]);

                            pstmt1.executeUpdate();
                        }
                        else if(network==3)
                        {
                            q1="insert into optical_network(pair,path1,distance1) values (?,?,?)";

                            //get the PreparedStatment object
                            pstmt1=con.prepareStatement(q1);
                            pstmt1.setString(1,key);
                            pstmt1.setString(2,p1);
                            pstmt1.setInt(3,distance[i]);

                            pstmt1.executeUpdate();
                        }

                        for (int len = path1.size() - 1; len > 0; len--)
                            delEdge(graph, path1.get(len), path1.get(len - 1));

                        path1.clear();
                        ShortestPath = dijkstra(graph, src);
                        System.arraycopy(ShortestPath[0], 0, parent2, 0, V);
                        System.arraycopy(ShortestPath[1], 0, distance2, 0, V);
                        node = i;
                        p2="";
                        path2.add(i);
                        p2+=i+",";
                        while (parent2[node] != node) {
                            if (parent2[node] == -1) {
                                //System.out.println("not reachable");
                                break;
                            }
                            path2.add(parent2[node]);
                            p2+=parent2[node]+",";
                            node = parent2[node];
                        }

                        String key2 = String.format("%s,%s", src, i);
                        //key2 += ",1";
                        if(network==0) {
                            q2="update usa_network set path2=?,distance2=? where pair=?";

                            //get the PreparedStatment object
                            pstmt2=con.prepareStatement(q2);
                            pstmt2.setString(1,p2);
                            pstmt2.setInt(2,distance2[i]);
                            pstmt2.setString(3,key2);

                            pstmt2.executeUpdate();
                        }
                        else if(network==1)
                        {

                            q2="update cost239_network set path2=?,distance2=? where pair=?";

                            //get the PreparedStatment object
                            pstmt2=con.prepareStatement(q2);
                            pstmt2.setString(1,p2);
                            pstmt2.setInt(2,distance2[i]);
                            pstmt2.setString(3,key2);

                            pstmt2.executeUpdate();
                        }
                        else if(network==2)
                        {
                            q2="update nsf_network set path2=?,distance2=? where pair=?";

                            //get the PreparedStatment object
                            pstmt2=con.prepareStatement(q2);
                            pstmt2.setString(1,p2);
                            pstmt2.setInt(2,distance2[i]);
                            pstmt2.setString(3,key2);

                            pstmt2.executeUpdate();
                        }
                        else if(network==3)
                        {
                            q2="update optical_network set path2=?,distance2=? where pair=?";

                            //get the PreparedStatment object
                            pstmt2=con.prepareStatement(q2);
                            pstmt2.setString(1,p2);
                            pstmt2.setInt(2,distance2[i]);
                            pstmt2.setString(3,key2);

                            pstmt2.executeUpdate();
                        }
                        for (int len = path2.size() - 1; len > 0; len--)
                            delEdge(graph, path2.get(len), path2.get(len - 1));
                        path2.clear();
                        ShortestPath = dijkstra(graph, src);
                        System.arraycopy(ShortestPath[0], 0, parent2, 0, V);
                        System.arraycopy(ShortestPath[1], 0, distance2, 0, V);
                        node = i;
                        p3="";
                        path2.add(i);
                        p3+=i+",";
                        while (parent2[node] != node) {
                            if (parent2[node] == -1) {
                                //System.out.println("not reachable");
                                break;
                            }
                            path2.add(parent2[node]);
                            p3+=parent2[node]+",";
                            node = parent2[node];
                        }

                        String key3 = String.format("%s,%s", src, i);
                        //key3 += ",2";
                        if(network==0) {
                            q3="update usa_network set path3=?,distance3=? where pair=?";

                            //get the PreparedStatment object
                            pstmt3=con.prepareStatement(q3);
                            pstmt3.setString(1,p3);
                            pstmt3.setInt(2,distance2[i]);
                            pstmt3.setString(3,key3);

                            pstmt3.executeUpdate();
                        }
                        else if(network==1)
                        {
                            q3="update cost239_network set path3=?,distance3=? where pair=?";

                            //get the PreparedStatment object
                            pstmt3=con.prepareStatement(q3);
                            pstmt3.setString(1,p3);
                            pstmt3.setInt(2,distance2[i]);
                            pstmt3.setString(3,key3);

                            pstmt3.executeUpdate();
                        }
                        else if(network==2)
                        {
                            q3="update nsf_network set path3=?,distance3=? where pair=?";

                            //get the PreparedStatment object
                            pstmt3=con.prepareStatement(q3);
                            pstmt3.setString(1,p3);
                            pstmt3.setInt(2,distance2[i]);
                            pstmt3.setString(3,key3);

                            pstmt3.executeUpdate();
                        }
                        else if(network==3)
                        {
                            q3="update optical_network set path3=?,distance3=? where pair=?";

                            //get the PreparedStatment object
                            pstmt3=con.prepareStatement(q3);
                            pstmt3.setString(1,p3);
                            pstmt3.setInt(2,distance2[i]);
                            pstmt3.setString(3,key3);

                            pstmt3.executeUpdate();
                        }
                        path2.clear();
                        for (int j = 0; j < graph.length; j++)
                            graph[j].clear();

                        switch(network)
                        {
                            case 0:
                                createGraph1(graph);
                                break;
                            case 1:
                                createGraph2(graph);
                                break;
                            case 2:
                                createGraph3(graph);
                                break;
                            case 3:
                                createGraph4(graph);
                                break;

                        }

                        System.arraycopy(parent, 0, ShortestPath[0], 0, V);
                        System.arraycopy(distance, 0, ShortestPath[1], 0, V);

                    }

                }

            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Connection Failed");
        }
    }
    public static  int getWeight(ArrayList<Edge> adj[],int u, int v)
    {
        // Traversing through the first vector list
        // and  get the weight of the edge to the destination
        for (int i = 0; i < adj[u].size(); i++)
        {
            Edge e=adj[u].get(i);
            if (e.dest== v)
            {
                return e.weight;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        //Creating graph 1 whose number of nodes is 24 but we are creating an array of 25 as node number starts with 1
        USAnetwork= new ArrayList[24];
        createGraph1(USAnetwork);
        //Creating graph 2 whose number of node is 11 but we are creating an array of of 12 as node number start with 1
        Cost239 = new ArrayList[12];
        createGraph2(Cost239);
        //Creating graph 3 whose number of node is 14 and start index=0
        NSFnetwork = new ArrayList[15];
        createGraph3(NSFnetwork);
        //Creating graph 4 whose number of nodes is 14 but we are creating an array of 15 as node number starts with 1
        Opticalnetwork = new ArrayList[14];
        createGraph4(Opticalnetwork);
        String NetworkName[] = {"USAnetwork", "Cost239", "NSFnetwork", "Opticalnetwork"};
        int startIndex[] = {0, 1, 1, 0};
        int endIndex[] = {23, 11, 14, 13};
        int noOFNodes[] = {24, 11, 14, 14};

        // generateRequestMenu(NetworkName, startIndex, endIndex);
       //generateAllPath(NetworkName,startIndex,endIndex);
        //System.out.println(getWeight(USAnetwork,0,1));
        EnergyCalculate obj=new EnergyCalculate();
       // obj.caculateTotalEnergy("USAnetwork",);
    }
}
class EnergyCalculate extends Main
{
    static final int drop_degree=50;
    static final int total_slots=500;
    static double cal_e_m(double s_m)
    {
        double em=1.683*s_m+91.333;
        return em;
    }
    static double cal_N(int D, double S_m, double g)
    {
        double n = (float)Math.ceil(D/(S_m));
        return  n + g;
    }

    static double cal_Ebvt(double e_m, double cal_N)
    {
        return (2* e_m *cal_N);
    }
    public static double calculateSm(int dist) {

        if (dist < 500) {
            return 50;
        } else if (dist > 500 && dist < 1000) {
            return 37.5;
        } else if (dist > 1000 && dist < 2000) {
            return 25;
        } else if (dist > 2000 && dist < 4000) {
            return 12.5;
        }
        return -1;
    }
    static double[] cal_EOXCandEDFA(String network_name,ArrayList<Integer> path,int Data)
    {
        int n=path.size();
        double eoxc=0.0d;
        double edfa=0.0d;
        double ea=0.0d;
        int eo=0;
        for(int i=n-1;i>=1;i--)
        {
            int j=i-1;
            int weight=0;
            if(network_name.equals("USAnetwork")) {
                eo = 85 * USnetwork_nodaldeg[i] + 100 * drop_degree + 150;
                //Number of frequency slots used
                weight = getWeight(USAnetwork, i, j);
            }
            else if(network_name.equals("Cost239")) {
                eo = 85 * Cost239_nodaldeg[i] + 100 * drop_degree + 150;
                //Number of frequency slots used
                weight = getWeight(Cost239, i, j);
            }
            else if(network_name.equals("NSFnetwork")) {
                eo = 85 * NSFnetwork_nodaldeg[i] + 100 * drop_degree + 150;
                //Number of frequency slots used
                weight = getWeight(NSFnetwork, i, j);
            }
            else if(network_name.equals("Opticalnetwork")) {
                eo = 85 * Opticalnetwork_nodaldeg[i] + 100 * drop_degree + 150;
                //Number of frequency slots used
                weight = getWeight(Opticalnetwork, i, j);
            }
            ea=Math.abs((weight/80)+1)*100;
            double S_m=calculateSm(weight);
            double N=cal_N(Data,S_m,2);
            eoxc+=((N*eo)/total_slots);
            edfa+=((N*ea)/total_slots);

        }
        return new double[]{eoxc,edfa};
    }
    static void caculateTotalEnergy(String NetworkName,ArrayList<Integer> Path,int Data,int Distance)
    {
        double  ebvt=0.0;
        double  eoxc=0.0;
        double  edfa=0.0;
        double total=0.0;
        double S_m=calculateSm(Distance);
        double em=cal_e_m(S_m);
        int slot_used=(int)cal_N(Data,S_m,2.0);
        ebvt=cal_Ebvt(em,slot_used);
        double eoxc_edfa[]=new double[2];
        eoxc_edfa=cal_EOXCandEDFA(NetworkName,Path,Data);
        eoxc=eoxc_edfa[0];
        edfa=eoxc_edfa[1];
        total=(ebvt+eoxc+edfa)/1000;
        System.out.println("Energy: "+total);
    }
}