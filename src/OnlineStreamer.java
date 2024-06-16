public class OnlineStreamer

{
    int N;
    int[] subscriber, Tree, maxTree, minTree;

    public void init(int N, int mSubscriber[]) {
        this.N = N;
        subscriber = new int[N + 1];
        for (int i = 1;i <= N;i ++) {
            subscriber[i] = mSubscriber[i - 1];
        }
        Tree = new int[N * 4 + 10];
        maxTree = new int[N * 4 + 10];
        minTree = new int[N * 4 + 10];
        bulid(1, 1, N);
        int t = 0;
    }
    /**
     * 初始化线段树
     */
    private void bulid(int root, int l, int r) {
        if (l == r) {
            Tree[root] = subscriber[l];
            minTree[root] = subscriber[l];
            maxTree[root] = subscriber[l];
            return;
        }
        int mid = l + r >> 1;
        bulid(root * 2, l, mid);
        bulid(root * 2 + 1, mid + 1, r);
        Tree[root] = Tree[root * 2] + Tree[root * 2 + 1];
        maxTree[root] = Math.max(maxTree[root * 2], maxTree[root * 2 + 1]);
        minTree[root] = Math.min(minTree[root * 2], minTree[root * 2 + 1]);
    }

    /**
     * 更新线段树
     */
    private void update(int root, int l, int r, int mId, int v) {
        if (l == r) {
            Tree[root] = v;
            subscriber[l] = v;
            minTree[root] = v;
            maxTree[root] = v;
            return;
        }
        int mid = l + r >> 1;
        if (mid < mId) update(root * 2 + 1, mid + 1, r, mId, v);
        else update(root * 2, l, mid, mId, v);
        Tree[root] = Tree[root * 2] + Tree[root * 2 + 1];
        maxTree[root] = Math.max(maxTree[root * 2], maxTree[root * 2 + 1]);
        minTree[root] = Math.min(minTree[root * 2], minTree[root * 2 + 1]);
    }
    public int subscribe(int mId, int mNum) {
        update(1, 1, N, mId, mNum + subscriber[mId]);
        return subscriber[mId];
    }

    public int unsubscribe(int mId, int mNum) {
        update(1, 1,N, mId, subscriber[mId] - mNum);
        return subscriber[mId];
    }

    /**
     * 查询总和
     * @param root
     * @param l
     * @param r
     * @param sId
     * @param eId
     * @return
     */
    private int querySum(int root, int l, int r, int sId, int eId) {
        if (sId <= l && eId >= r) return Tree[root];
        int mid = l + r >> 1, sum = 0;
        if (sId <= mid)   sum += querySum(root * 2 , l, mid, sId, eId);
        if (mid + 1 <= eId) sum += querySum(root * 2 + 1, mid + 1, r, sId, eId);
        return sum;
    }

    public int count(int sId, int eId) {
        return querySum(1, 1, N, sId, eId);
    }


    public int calculate(int sId, int eId) {
        int min = queryMin(1, 1, N, sId, eId);
        int max = queryMax(1, 1, N, sId, eId);
        return max - min;
    }

    private int queryMax(int root, int l, int r, int sId, int eId) {
        if (sId <= l && eId >= r) return maxTree[root];
        int mid = l + r >> 1, max = 0;
        if (sId <= mid) max = Math.max(max, queryMax(root * 2 , l, mid, sId, eId));
        if (eId >= mid + 1 ) max = Math.max(max, queryMax(root * 2 + 1 , mid + 1, r, sId, eId));
        return max;
    }

    private int queryMin(int root, int l, int r, int sId, int eId) {
        if (sId <= l && eId >= r) return minTree[root];
        int mid = l + r >> 1, min = Integer.MAX_VALUE;
        if (sId <= mid) min = Math.min(min, queryMin(root * 2 , l, mid, sId, eId));
        if (eId >= mid + 1 ) min = Math.min(min, queryMin(root * 2 + 1 , mid + 1, r, sId, eId));
        return min;
    }
}
