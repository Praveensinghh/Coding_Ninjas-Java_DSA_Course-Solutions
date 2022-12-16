/**
 * LastIndexOfElementInArray
 */
public class LastIndexOfElementInArray {

    public static int lastIndex(int input[], int x) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        return lastIndex(input, x, input.length - 1);
    }

    public static int lastIndex(int input[], int x, int si) {
        if (si == 0) {
            if (input[si] == x) {
                return si;
            } else {
                return -1;
            }
        }

        if (input[si] == x) {
            return si;
        }

        return lastIndex(input, x, si - 1);

    }
}