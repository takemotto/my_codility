package codility.light;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");



/*
    Please be noted that this code shows the answer of a problem at codility.
    I don't have any special relationship with the site.
    I would delete this file from githab as soon as possible.
 */





class Solution {

    char[] light;

    public int solution(String S) {
        light = S.toCharArray();
        int total = 0;

        int currentLength;
        for (int i = 0; i < light.length; i++) {
            int[] counts = new int[10];
            count(counts, i);
            total++;
            currentLength = 1;

            for (int j = i + 1; j < light.length; j++) {
                count(counts, j);
                currentLength++;
                if (isAppropriate(counts, currentLength)) {
                    total++;
                }
            }

        }

        return total;
    }

    /**
     * count the element into counts.
     * @param counts
     * @param index
     */
    private void count(int[] counts , int index) {

        char color = light[index];

        if (color == '0') {
            counts[0]++;
        }
        else if (color == '1') {
            counts[1]++;
        }
        else if (color == '2') {
            counts[2]++;
        }
        else if (color == '3') {
            counts[3]++;
        }
        else if (color == '4') {
            counts[4]++;
        }
        else if (color == '5') {
            counts[5]++;
        }
        else if (color == '6') {
            counts[6]++;
        }
        else if (color == '7') {
            counts[7]++;
        }
        else if (color == '8') {
            counts[8]++;
        }
        else if (color == '9') {
            counts[9]++;
        }

    }

    /**
     * determine whether to buy this segment.
     *
     * @param counts
     * @param length
     * @return
     */
    private boolean isAppropriate(int[] counts, int length) {

        if (length % 2 == 0) {
            for (int count : counts) {
                if (count != 0 && count % 2 == 1) {
                    return false;
                }
            }
        }
        else {
            int oddCount = 0;
            for (int count : counts) {
                if (count != 0 && count % 2 == 1) {
                    if (++oddCount > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
