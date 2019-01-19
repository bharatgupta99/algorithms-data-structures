void decode(String s, Node root) {

    StringBuilder strbldr = new StringBuilder();
    for (int i = 0; i < s.length();) {
        Node temp = root;
        while (temp.left != null || temp.right != null) {
            if (s.charAt(i) == '0') {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
            i++;
        }
        strbldr.append(temp.data);
    }
    System.out.println(strbldr.toString());   
}