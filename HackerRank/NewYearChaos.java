static void minimumBribes(int[] q) {
    int flag = 0;
    for (int i = q.length - 1; i >= 0; i--) {
        if (q[i] - (i + 1) > 2) {
            flag = -1;
            break;
        }
        for (int j = Math.max(0, q[i] - 2); j < i; j++ ) {
            if (q[i] < q[j]) {
                flag++;
            }
        }
    }
    if (flag == -1) {
        System.out.println("Too chaotic");
    } else {
        System.out.println(flag);
    }
}