 private static class Node {
    int d;
    Node left;
    Node right;
    int level;
    Node(int d, int level) {
        this.left = null;
        this.right = null;
        this.level = level;
        this.d = d;
    }
}

private static void swap(Node head, int query) {
    if (head == null) {
        return;
    }
    if (head.level % query == 0) {
        Node temp = head.left;
        head.left = head.right;
        head.right = temp;
    }
    swap(head.left, query);
    swap(head.right, query);
}

private static void inorder(Node head, int i, int[][] res) {
    if (head == null) {
        return;
    }
    inorder(head.left, i, res);
    res[i][index++] = head.d;
    inorder(head.right, i, res);
}
    /*
     * Complete the swapNodes function below.
     */
    static int index = 0;
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        Node head = new Node(1, 1);
        Queue<Node> q = new LinkedList<>();
        q.add(head);
        int sz = 0;
        for (int i = 0; i < indexes.length; i++) {
            Node temp = q.poll();
            sz++;
            if (indexes[i][0] != -1) {
                temp.left = new Node(indexes[i][0], temp.level + 1);
                q.add(temp.left);
            }
            if (indexes[i][1] != -1) {
                temp.right = new Node(indexes[i][1], temp.level + 1);
                q.add(temp.right);
            }
        }
        int res[][] = new int[queries.length][sz];
        for (int i = 0; i < queries.length; i++) {
            index = 0;
            swap(head, queries[i]);
            inorder(head, i, res);
        }
        return res;
    }