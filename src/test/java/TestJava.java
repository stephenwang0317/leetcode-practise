import java.util.Comparator;
import java.util.PriorityQueue;

public class TestJava {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);
    }

}
