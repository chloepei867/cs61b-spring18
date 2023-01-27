import java.util.HashSet;

/**直接看的答案。本来想用HashMap的，结果半天没写出来。*/
public class Intersect {
    public static int[] intersect(int[] A, int[] B) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int num: A) {
            setA.add(num);
        }
        for (int num: B) {
            if (setA.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] intersectArray = new int[intersectionSet.size()];
        int index = 0;
        for (int num: intersectionSet) {
            intersectArray[index] = num;
            index += 1;
        }
        return intersectArray;
    }
}
