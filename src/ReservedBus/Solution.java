package ReservedBus;



import java.util.Scanner;

/**
 * @author Z God
 */
public class Solution {
    private static final UserSolution usersolution = new UserSolution();

    private final static int CMD_INIT = 1;
    private final static int CMD_ADD = 2;
    private final static int CMD_FIND = 3;

    static final int MAX_K = 1000;
    static final int MAX_M = 5;

    static int mRoadAs[] = new int[MAX_K];
    static int mRoadBs[] = new int[MAX_K];
    static int mLens[] = new int[MAX_K];
    static int mStops[] = new int[MAX_M];

    private static boolean run(Scanner sc) throws Exception {

        int query_num = sc.nextInt();
        boolean ok = false;

        for (int q = 0; q < query_num; q++) {
            int query = sc.nextInt();

            if (query == CMD_INIT) {
                int N = sc.nextInt();
                int K = sc.nextInt();
                for (int i = 0; i < K; i++) mRoadAs[i] = sc.nextInt();
                for (int i = 0; i < K; i++) mRoadBs[i] = sc.nextInt();
                for (int i = 0; i < K; i++) mLens[i] = sc.nextInt();
                usersolution.init(N, K, mRoadAs, mRoadBs, mLens);
                ok = true;
            } else if (query == CMD_ADD) {
                int mRoadA = sc.nextInt();
                int mRoadB = sc.nextInt();
                int mLen = sc.nextInt();
                usersolution.addRoad(mRoadA, mRoadB, mLen);
            } else if (query == CMD_FIND) {
                int mStart = sc.nextInt();
                int mEnd = sc.nextInt();
                int M = sc.nextInt();
                for (int i = 0; i < M; i++) mStops[i] = sc.nextInt();
                int ret = usersolution.findPath(mStart, mEnd, M, mStops);
                int ans = sc.nextInt();
                if (ans != ret) {
                    ok = false;
                }
            }
        }
        return ok;
    }

    public static void main(String[] args) throws Exception {
        int T, MARK;

        // System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        MARK = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int score = run(sc) ? MARK : 0;
            System.out.println("#" + tc + " " + score);
        }
        sc.close();
    }
}
