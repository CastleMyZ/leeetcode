package Picture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static BufferedReader br;
    private static UserSolution userSolution = new UserSolution();

    private final static int CMD_INIT = 100;
    private final static int CMD_SAVE = 200;
    private final static int CMD_FILTER = 300;
    private final static int CMD_DELETE = 400;

    private static String[] initDatas = new String[10000];
    private static String[] newDatas = new String[100];


    private static boolean run() throws Exception {
        StringTokenizer stdin = new StringTokenizer(br.readLine(), " ");

        int query_num = Integer.parseInt(stdin.nextToken());

        int ret, ans;
        boolean ok = false;

        for (int q = 0; q < query_num; q++)
        {
            int query, n, m, k;
            stdin = new StringTokenizer(br.readLine(), " ");
            query = Integer.parseInt(stdin.nextToken());

            if (query == CMD_INIT)
            {
                n = Integer.parseInt(stdin.nextToken());
                for(int i=0;i<n;i++)
                    initDatas[i] = stdin.nextToken();

                userSolution.init(n, initDatas);
                ok = true;
            }
            else if (query == CMD_SAVE)
            {
                m = Integer.parseInt(stdin.nextToken());

                for(int i=0;i<m;i++)
                    newDatas[i] = stdin.nextToken();

                userSolution.savePictures(m, newDatas);
            }
            else if (query == CMD_FILTER)
            {
                String mFilter = stdin.nextToken();
                k = Integer.parseInt(stdin.nextToken());

                ret = userSolution.filterPictures(mFilter, k);
                ans = Integer.parseInt(stdin.nextToken());

                if(ret != ans)
                    ok = false;
            }
            else if (query == CMD_DELETE)
            {
                ret = userSolution.deleteOldest();
                ans = Integer.parseInt(stdin.nextToken());

                if (ret != ans)
                    ok = false;

            }
        }
        return ok;
    }

    public static void main(String[] args) throws Exception {
        int T, MARK;

//        System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stinit = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(stinit.nextToken());
        MARK = Integer.parseInt(stinit.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            int score = run() ? MARK : 0;
            System.out.println("#" + tc + " " + score);
        }

        br.close();
    }
}

