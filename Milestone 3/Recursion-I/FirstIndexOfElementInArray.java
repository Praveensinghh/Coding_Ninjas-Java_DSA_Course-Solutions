/**
 * FirstIndexOfElementInArray
 */
public class FirstIndexOfElementInArray {

    public static int firstIndex(int input[], int x) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        return firstIndex(input, x, 0);
    }

    public static int firstIndex(int input[], int x, int si) {
        if (si == input.length - 1) {
            if (input[si] == x) {
                return si;
            } else {
                return -1;
            }
        }

        if (input[si] == x) {
            return si;
        }

        return firstIndex(input, x, si + 1);
    }
}