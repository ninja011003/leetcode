import java.util.Arrays;

public class HeapAlgorithm {
    public static void main(String[] args) {
        int[] elements = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15};
        generatePermutations(elements.length, elements);
        
    }

    public static void generatePermutations(int size, int[] elements) {
        if (size == 1) {
            System.out.println(Arrays.toString(elements));
        } else {
            for (int i = 0; i < size; i++) {
                generatePermutations(size - 1, elements);

                if (size % 2 == 0) {
                    swap(elements, i, size - 1);
                } else {
                    swap(elements, 0, size - 1);
                }
            }
        }
    }

    public static void swap(int[] elements, int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
