import java.util.ArrayList;
import java.util.List;

public class S1 {


    Given two sorted integer arrays, find their intersection. For example:

    a1 = [2, 3, 9, 13], n
    a2 = [3, 6, 13, 15], m

    a1 = []
    a2 = [3,4]
    out = [3, 13]

    a1 = [1, 2, 3]
    a2 = [1, 2, 3]

    a1 = [1, 1, 3]
    a2 = [1, 1, 3]
    out = [1, 3]

    O (min (m,n))

    List<Integer> itersection(int[] a1, int[] a2) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int prev1 = Integer.MAX_VALUE;
        int prev2 = Integer.MAX_VALUE;
        while (i < a1.length && j < a2.length) {
            if (a1[i] >= a2[j]) {
                if (a1[i] == a2[j]) {
                    if (prev1 == a1[i] && prev1 != prev2) {
                    }
                    result.add(a1[i]);
                    prev1 = a1[i];
                    prev2 = a2[j];
                }
                j++;
            } else {
                i++
            }
        }
        return result;
    }
}



    Array product except element at input[i]
        Description: we have an array called input, and it contains N elements. I would like you to return an array called output, such that output[i] is equal to the product of all the elements of input except input[i].
        Example: [5, 6, 1] output: [6, 5, 30]
        [4, 5, 0] exp [ 0, 0, 20]
        [0, 5, 0] exp [0, 0, 0]
        [] exp []

        cpu O(n)
        mem O(n)

        int[] product(int[] input) {
        int [] result = new [input.length];
        long product = 1;
        int zirro = 0;
        for (int i =0 ; i < input.length; i++) {
        if (input[i] != 0) {
        product *= input[i];
        } else {
        zirro ++;
        }
        }
        if (zirro > 1) {
        return result;
        }
        for (int i = 0; i < result.length; i++) {
        if (zirro > 0) {
        if (input[i] != 0) {
        result[i]=0;
        } else {
        result[i]]=product;
        }
        } else {
        result[i] = product/input[i];
        }
        }
        return result;
        }




        Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

        Binary Tree:

        1            <---
        /   \
        2     3         <---
        /  \
        6   5             <---
        \
        7
        output:[1, 3, 5, 7]

        Tree {
        int value;
        Tree left;
        Tree right;
        }

        List<Integer> rightView(Tree root) {
        List<Integer> result = new ArrayList<>();
        traverse(result, 0, root);
        return result;
        }

        void traverse(List<Integer> result, int level, Tree head) {
        if (head == null) return;
        if (level >= result.size()) {
        result.add(head.value);
        } else {
        result.set(level, head.value);
        }
        traverse(result, level + 1, head.left);
        traverse(result, level + 1, head.right);
        }


        [1]
        [1, 2]
        [1, 2, 6]
        [1, 2, 6, 7]
        [1, 2, 5, 7]
        [1, 3, 5, 7]

        [1]
        [1, 2]
        [1, 2, 6]
        [1, 2, 5]
        [1, 2, 5, 7]
        [1, 3, 5, 7]

        Cpu O(n)
        mem O(n)