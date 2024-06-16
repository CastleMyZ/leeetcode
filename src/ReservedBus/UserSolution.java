package ReservedBus;

import java.util.*;

class UserSolution {
    public final int MAX_NUMS = 510;
    public class node implements Comparable<node>{
        City city;
        int dis;

        public node(City city, int dis) {
            this.city = city;
            this.dis = dis;
        }

        @Override
        public int compareTo(node o) {
            return Integer.compare(this.dis, o.dis);
        }
    }
    public class City {
        int k, dis; // 存从起点到这个城市的距离
        ArrayList<node> roads = new ArrayList<node>();
        HashMap<City, Integer> map = new HashMap<>();  // 存取从这座城市到其他城市的距离
    }
    PriorityQueue<node> q = new PriorityQueue<>();
    City[] cities = new City[MAX_NUMS];
    boolean[] st = new boolean[10];


    public void init(int N, int K, int mRoadAs[], int mRoadBs[], int mLens[])
    {
        for (int i =0 ;i < N;i ++) {
            cities[i] = new City();
        }
        for (int i =0 ;i < K;i ++) {
            addRoad(mRoadAs[i], mRoadBs[i], mLens[i]);
        }
    }

    public void addRoad(int mRoadA, int mRoadB, int mLen)
    {
        cities[mRoadA].roads.add(new node(cities[mRoadB], mLen));
        cities[mRoadB].roads.add(new node(cities[mRoadA], mLen));
    }

    public int findPath(int mStart, int mEnd, int M, int mStops[])
    {
        int result = -1;
        int[] stops = new int[M + 2];
        stops[0] = mEnd;
        stops[1] = mStart;
        for (int i= 0 ;i < M;i ++) {
            stops[i + 2] = mStops[i];
        }
        // dijkstra
        for (int i = 1;i < M;i ++) {
            
        }
        return result;
    }





}