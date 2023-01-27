import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    int row, col;
    public static int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        UF uf = new UF(row*col);
        //预处理出所有的边
        //edge中保存的[x, y, w]表示的是点x到y的effort
        //虽然可以向上下左右四个方向移动，但实际只需要添加每个点向下和向右两条边
        //即可覆盖所有的边
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < row; i += 1) {
            for(int j = 0; j < col; j += 1) {
                //这里是将二维坐标(i,j)转换成一维坐标
                int index = getIndex(i, j);
                //先添加与下边相邻节点之间的边
                if (i + 1 < row) {
                    int x = index, y = getIndex(i+1, j);
                    int w = Math.abs(heights[i][j] - heights[i+1][j]);
                    edges.add(new int[]{x, y, w});
                }
                //添加与右边节点之间的边
                if (j + 1 < col) {
                    int x = index, y = index + 1;
                    int w = Math.abs(heights[i][j] - heights[i][j+1]);
                    edges.add(new int[]{x, y, w});
                }
            }
        }
        //将所有边按照边权从小到大排列
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        //开始执行Kruskal算法
        //从权值较小的边开始添加，如果添加某一条边之后起点（0,0）和终点（row-1, col-1）
        //连通，则表明找到了【最短路径】中权重最大的边
        //这里也是与最小生成树不一样的地方：不需要考虑是否成环
        int start = getIndex(0, 0);
        int end = getIndex(row-1, col-1);
        for (int[] edge: edges) {
            int x = edge[0], y = edge[1], w = edge[2];
            //添加x与y之间的边
            uf.union(x, y);
            if (uf.connected(start, end)) {
                return w;
            }
        }
        return 0;
    }

    class UF {
        private int count;
        private int[] parent;
        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i += 1) {
                parent[i] = i;
            }
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count -= 1;
            // parent[find(p)] = parent[find(q)];
        }
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
            // return parent[find(p)] == parent[find(q)];
        }
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public int count() {
            return count;
        }
    }
    //将二维坐标转换成一维
    public int getIndex(int x, int y) {
        return x*col + y;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{{1,2,2}, {3,8,2}, {5,3,5}};
        Solution.minimumEffortPath(heights);
    }
}
