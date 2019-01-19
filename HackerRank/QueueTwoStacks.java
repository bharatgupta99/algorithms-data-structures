private static void reverseStack(Stack<Integer> source, Stack<Integer> destination) {
    while (!source.empty()) {
        destination.push(source.pop());
    }
}

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        int type = sc.nextInt();
        if (type == 1) {
            int e = sc.nextInt();
            s1.push(e);
        } else if (type == 2) {
            if (s2.empty()) {
                reverseStack(s1, s2);
            }
            s2.pop();
        } else if (type == 3) {
            if (s2.empty()) {
                reverseStack(s1, s2);
            }
            System.out.println(s2.peek());
        }

    }