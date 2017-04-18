package com.example.android.dictionary;

/**
 * Created by SHREYA on 4/16/2017.
 */
public class ClassNode {
    public Node root;

    public void put(String key, String mean) {
        root = put(root, key, mean, 0);

    }

    private Node put(Node x, String key, String mean, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c)
            x.left = put(x.left, key, mean, d);
        else if (c > x.c)
            x.right = put(x.right, key, mean, d);
        else if (d < key.length() - 1)
            x.mid = put(x.mid, key, mean, d + 1);
        else if (d == key.length() - 1) {

            x.mean = mean;
        } else return x;
        return null;
    }

    public String contains(String key) {
        Node g = get(key);
        return g.mean;
    }

    public Node get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return x;
    }

    public Node get(Node x, String key, int d) {
        if (x == null) return null;
        char c = key.charAt(d);
        if (c < x.c)
            return get(x.left, key, d);
        else if (c > x.c)
            return get(x.right, key, d);
        else if (d < key.length() - 1)
            return get(x.mid, key, d + 1);
        else return x;
    }

    public class Node {

        public String mean;
        public char c;
        public Node left, mid, right;
    }
}
