package codility.binarian;

/*
    Please be noted that this code shows the answer of a problem at codility.
    I don't have any special relationship with the site.
    I would delete this file from githab as soon as possible.
 */







class Solution {

    public int solution(int[] A) {
        // check argument
        if (A == null || A.length < 1) {
            return -1;
        }

        // start main
        int temp, current, count = 0;

        temp = calcTotal(A);
        for ( ; 0 < temp; ) {
            current = getMaximumBin(temp);
            temp = temp - current;
            count++;
        }

        return count;
    }

    /**
     * calc the total of given binarian
     * @param A
     * @return int
     */
    private int calcTotal(int[] A) {
        int total = 0, base = 1;
        for (int a : A) {
            total += base << a;
        }
        //System.out.print("DEBUG: given total is " + total);
        return total;
    }

    /**
     * calc the maximum number that can be included in binarian
     * @param binarian
     * @return
     */
    private int getMaximumBin(int binarian) {
        int current = 1;

        while (current <= binarian) {
            current = current << 1;
        }

        if (current > 1) {
            current = current >> 1;
        }
        return current;
    }

    public static void main(String[] args) {
        int test = 1;
        System.out.println(test << 0);

        int[] tests = {1, 0, 2, 0, 0, 2};
        test = 13;
        while (test > 0) {
            if (test % 2 == 0) {

            }
        }
    }
}
