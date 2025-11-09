import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionListLinkedList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.remove(1);
        list.add("C");

        System.out.println(list);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.remove(1);
        linkedList.add("C");

        System.out.println(linkedList);
    }

}
