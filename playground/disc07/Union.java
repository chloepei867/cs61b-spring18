import java.util.HashSet;

/**直接看的答案。没想到用HashSet。主要是对set还比较陌生*/
public class Union {
    public static int[] union(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        for (int a: A) {
            set.add(a);
        }
        for (int b: B) {
            set.add(b);
        }
        int[] unionArray = new int[set.size()];
        int index = 0;
        for (int num: set) {
            unionArray[index] = num;
            index++;
        }
        return unionArray;
    }
}
