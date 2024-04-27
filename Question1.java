public class Question1 {
    private static void dfs (int node, int adjList[][], boolean visited[]) {
        if (visited[node]) return;
        visited[node] = true;
        for (int i = 0; i < adjList[node].length; i++) dfs(adjList[node][i], adjList, visited);
    }
    
    public static int findCCCount(int adjList[][], int n) { // findConnectedComponentCount
        int ans = 0;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) visited[i] = false;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                ans++;
                dfs(i, adjList, visited);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // test cases
        int adjList[][] = {{1}, {0,2}, {1}, {4}, {3}}; // TC1
        // int adjList[][] = {{4,9}, {8,11,14}, {6,13}, {}, {0,9}, {10,13}, {2,10}, {12}, {1,14}, {0,4}, {5,6}, {1,14}, {7}, {2,5}, {1,8,11}}; // TC2
        // int adjList[][] = {{1,2}, {0,2}, {0,1,3}, {2}}; // TC3
        
        System.out.println(findCCCount(adjList, adjList.length));
    }
}
