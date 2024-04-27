import java.util.Vector;

public class Question2 {
    private static class Node {
        Node children_[];
        boolean end_;
        public Node () {
            children_ = new Node[26];
            for (int i = 0; i < 26; i++) children_[i] = null;
            end_ = false;
        }
    }

    private static void insert (int i, int j, Node node, String products[]) {
        if (j == products[i].length()) {
            node.end_ = true;
            return;
        }
        int index = products[i].charAt(j) - 'a';
        if (node.children_[index] == null) node.children_[index] = new Node();
        insert(i, j + 1, node.children_[index], products);
    }

    private static Node find (int i, int j, Node node, String queries[]) {
        if (node == null) return null;
        if (j == queries[i].length()) return node;
        return find(i, j + 1, node.children_[queries[i].charAt(j) - 'a'], queries);
    }

    private static void dfs (Node node, String s, Vector<String> vec) {
        if (node == null) return;
        if (node.end_) vec.add(s + " ");
        for (int i = 0; i < 26; i++) dfs(node.children_[i], s + (char)(i + 'a'), vec);
    }

    private static void output ( Vector<Vector<String>> vec, String queries[]) {
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(queries[i] + " : ");
            for (int j = 0; j < vec.get(i).size(); j++) System.out.print(vec.get(i).get(j) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String products[] = {"mobile","mouse","moneypot","monitor","mousepad"}, queries[] = {"m", "mon", "t", "mouse"};
        Node root = new Node();
        Vector<Vector<String>> ans = new Vector<>(); 
        for (int i = 0; i < products.length; i++) insert(i, 0, root, products);
        for (int i = 0; i < queries.length; i++) {
            Node node = find(i, 0, root, queries);
            ans.add(new Vector<>());
            dfs(node, queries[i], ans.get(i));
        }
        output(ans, queries);
    }
}