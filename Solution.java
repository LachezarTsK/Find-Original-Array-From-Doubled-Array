
public class Solution {

    public int[] findOriginalArray(int[] changed) {
        int[] emptyArray = new int[]{};

        if (changed.length % 2 == 1) {
            return emptyArray;
        }

        int maxLength = (int) Math.pow(10, 5) + 1;
        int[] frequency = new int[maxLength];
        for (int n : changed) {
            frequency[n]++;
        }

        if (frequency[0] % 2 == 1) {
            return emptyArray;
        }

        int index = 0;
        int[] original = new int[changed.length / 2];
        for (int i = 0; i < maxLength; i++) {
            while (i * 2 < maxLength && frequency[i] > 0 && frequency[2 * i] > 0) {
                original[index++] = i;
                frequency[i]--;
                frequency[2 * i]--;
            }
        }

        return (index == changed.length / 2) ? original : emptyArray;
    }
}
