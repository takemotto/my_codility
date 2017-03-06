package codility.hawk;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
    Please be noted that this code shows the answer of a problem at codility.
    I don't have any special relationship with the site.
    I would delete this file from githab as soon as possible.
 */









import java.util.Arrays;

class Solution {

    private int[] left;

    private int[] right;

    private int center = -1;

    public int solution(int[] H) {
        // write your code in Java SE 8
        int result = 0;

        if (H.length % 2 == 0) {
            left = Arrays.copyOfRange(H, 0, H.length /2 -1);
            right  = Arrays.copyOfRange(H, H.length / 2 -1, H.length);
        }
        else {
            left = Arrays.copyOfRange(H, 0, H.length /2);
            right  = Arrays.copyOfRange(H, H.length / 2 + 1, H.length);
            center = H.length / 2 - 1;
        }

        System.out.println(left[0]);
        System.out.println(right[0]);


        if (center != -1) {
            result += toLeft(center);
            result += toRight(center);
            result--;
        }

        for (int current : left) {
            System.out.println(current);
            result += toRight(current);
        }

        for (int current : right) {
            System.out.println(current);
            result += toLeft(current);
        }

        return result;
    }

    private int toLeft(int current) {
        int count = 1;
        for (int nest : left) {
            if (nest > current) {
                System.out.println(nest);
                count += toRight(nest);
            }
        }

        if (center > current) {
            count += toLeft(center);
            count += toRight(center);
            count--;
        }
        return count;
    }

    private int toRight(int current) {
        int count = 1;
        for (int nest : right) {
            if (nest > current) {
                System.out.println(nest);
                count += toLeft(nest);
            }
        }
        if (center > current) {
            count += toLeft(center);
            count += toRight(center);
            count--;
        }
        return count;
    }


}
