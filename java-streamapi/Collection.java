import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Stream;

class Collection {
        public static void main(String [] args) {
                /* list */
                System.out.println("#### LIST ####");
                List<Integer> list = List.of(1,2,3,4,5);
                System.out.println("sum list : " + result(list.stream()));

                List<Integer> arrayList = new ArrayList<>(List.of(1,2,3,4,5));
                System.out.println("sum array list : " + result(arrayList.stream()));

                List<Integer> listLinked = new ArrayList<>(List.of(1,2,3,4,5));
                System.out.println("sum linked list : " + result(listLinked.stream()));

                List<Integer> vector = new Vector<>(List.of(1, 2, 3, 4, 5));
                System.out.println("sum vector : " + result(vector.stream()));

                List<Integer> stack = new Stack<>();
                stack.addAll(List.of(1,2,3,4,5));
                System.out.println("sum stack : " + result(stack.stream()));

                System.out.println();
                System.out.println();
                System.out.println();


                /* set */
                System.out.println("#### SET ####");
                Set<Integer> set = Set.of(1,2,3,4,5);
                System.out.println("sum set : " + result(set.stream()));

                Set<Integer> hashSet = new HashSet<>(Set.of(1,2,3,4,5));
                System.out.println("sum hashSet : " + result(set.stream()));

                Set<Integer> linkedHashSet = new LinkedHashSet<>(Set.of(1,2,3,4,5));
                System.out.println("sum linkedHashSet : " + result(set.stream()));

                Set<Integer> treeSet = new TreeSet<>(Set.of(1,2,3,4,5));
                System.out.println("sum treeSet : " + result(set.stream()));

                System.out.println();
                System.out.println();
                System.out.println();


                /* queue */
                System.out.println("#### QUEUE ####");

                Queue<Integer> queueLinkedList = new LinkedList<>(List.of(1, 2, 3, 4, 5));
                System.out.println("sum linkedList : " +  result(queueLinkedList.stream()));

                Queue<Integer> queue = new PriorityQueue<>(List.of(1,2,3,4,5));
                System.out.println("sum queue : " + result(queue.stream()));

                Queue<Integer> deque = new ArrayDeque<>(List.of(1,2,3,4,5));
                System.out.println("sum deque : " + result(deque.stream()));
        }

        public static Integer result(Stream<Integer> stream) {
                return stream.filter(n -> n % 2 == 0)
                        .mapToInt(Integer::intValue)
                        .sum();
        }
}
