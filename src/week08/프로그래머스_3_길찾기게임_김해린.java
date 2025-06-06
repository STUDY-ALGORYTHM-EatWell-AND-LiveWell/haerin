package week08;

import java.util.*;
import java.io.*;
public class 프로그래머스_3_길찾기게임_김해린 {
    static int[][] answer;
    static int idx;
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y == o2.y) return o1.x - o2.x;
                return o2.y - o1.y;
            }
        }); //정렬

        Node root = nodes[0];

        for (int i = 1; i < nodeinfo.length; i++) {
            insertNode(root, nodes[i]);
        } // 트리 완성

        answer = new int[nodeinfo.length][nodeinfo.length];

        idx = 0;
        preorder(nodes[0]);

        idx = 0;
        postorder(nodes[0]);


        return answer;
    }

    private void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else if (parent.x < child.x) {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }

    private void preorder(Node root) {
        answer[0][idx++] = root.data;

        if (root.left != null) preorder(root.left);
        if (root.right != null) preorder(root.right);
    }
    private void postorder(Node root) {
        if (root.left != null) {
            postorder(root.left);
        }
        if (root.right != null) {
            postorder(root.right);
        }
        answer[1][idx++] = root.data;
    }
}

class Node {
    Node left;
    Node right;
    int data;
    int x, y;

    public Node(int data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }
}
