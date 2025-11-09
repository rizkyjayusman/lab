import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionBenchmarkList {
    public static void main(String[] args) {
        int size = 1_000_00; // jumlah data (100 ribu)

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> vectorList = new Vector<>();
        List<Integer> stackList = new Stack<>();
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        System.out.println("=== ADD (di akhir) ===");
        measureTime("ArrayList", () -> fillList(arrayList, size));
        measureTime("LinkedList", () -> fillList(linkedList, size));
        measureTime("Vector", () -> fillList(vectorList, size));
        measureTime("Stack", () -> fillList(stackList, size));
        measureTime("CopyOnWriteArrayList", () -> fillList(copyOnWriteArrayList, size));

        System.out.println("\n=== ACCESS (get random index) ===");
        measureTime("ArrayList", () -> randomAccess(arrayList));
        measureTime("LinkedList", () -> randomAccess(linkedList));
        measureTime("Vector", () -> randomAccess(vectorList));
        measureTime("Stack", () -> randomAccess(stackList));
        measureTime("CopyOnWriteArrayList", () -> randomAccess(copyOnWriteArrayList));

        System.out.println("\n=== REMOVE (dari tengah) ===");
        measureTime("ArrayList", () -> removeMiddle(arrayList));
        measureTime("LinkedList", () -> removeMiddle(linkedList));
        measureTime("Vector", () -> removeMiddle(vectorList));
        measureTime("Stack", () -> removeMiddle(stackList));
        measureTime("CopyOnWriteArrayList", () -> removeMiddle(copyOnWriteArrayList));
    }

    // isi list
    private static void fillList(List<Integer> list, int size) {
        list.clear();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    // akses acak
    private static void randomAccess(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 10_000; i++) {
            int index = random.nextInt(list.size());
            list.get(index);
        }
    }

    // hapus di tengah
    private static void removeMiddle(List<Integer> list) {
        int mid = list.size() / 2;
        for (int i = 0; i < 1_000; i++) {
            list.remove(mid);
            mid = list.size() / 2;
        }
    }

    // util: hitung waktu eksekusi
    private static void measureTime(String name, Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;
        System.out.println(name + " => " + durationMs + " ms");
    }
}
