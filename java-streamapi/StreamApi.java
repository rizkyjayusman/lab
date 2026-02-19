import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String [] args) {
        Stream<String> stream = Stream.of("hello", "world", "hi", "you");
        List<String> list = List.of("hello", "world", "hi", "you");

        // filter
        System.out.println(stream.filter(e -> e.equals("hi")).findFirst());

        // any match
        System.out.println(list.stream().anyMatch(e -> e.equals("hello")));
        System.out.println(list.stream().anyMatch(e -> e.equals("you")));

        // limit
        System.out.println(list.stream().limit(2).collect(Collectors.toSet()));

        // skip
        System.out.println(list.stream().skip(2).collect(Collectors.toSet()));

        // map
        System.out.println(list.stream().map(e -> "prefix-" + e).collect(Collectors.toSet()));

        List<List<String>> subList = List.of(
                List.of("hello", "world"),
                List.of("hi", "you")
        );
        // flatmap -> nested list
        System.out.println(subList.stream().flatMap(Collection::stream).collect(Collectors.toSet()));

        List<Item> items = List.of(
                new Item(List.of("hello", "world", "kong")),
                new Item(List.of("hi", "you", "nginx")),
                new Item(List.of("hoho", "xixixi", "java")),
                new Item(List.of("queue", "stack", "kafka"))
        );

        // flatmap -> list but object
        System.out.println(items.stream().flatMap(l -> l.subItem.stream()).collect(Collectors.toSet()));

        List<String> duplicateList = List.of("hello", "world", "hello", "live", "long", "world");
        // distinct
        System.out.println(duplicateList.stream().distinct().toList());

        // sort
        System.out.println(duplicateList.stream().sorted().toList());

        // sort by reversed
        System.out.println(duplicateList.stream().sorted(Comparator.reverseOrder()).toList());

        List<String> peekList = List.of("hello", "world", "hello", "live", "long", "world");
        // peek
        peekList.stream().peek(System.out::println).collect(Collectors.toSet());

        List<String> intList = List.of("1","2","3","4","5","6","7","8","9","10");
        // map into IntStream
        System.out.println(Arrays.toString(intList.stream().mapToInt(Integer::parseInt).toArray()));
        // map into DoubleStream
        System.out.println(Arrays.toString(intList.stream().mapToDouble(Double::parseDouble).toArray()));
        // map into LongStream
        System.out.println(Arrays.toString(intList.stream().mapToLong(Long::parseLong).toArray()));

        IntStream intStream = IntStream.rangeClosed(1, 5);
        // map IntStream to Stream<Integer>
        System.out.println(intStream.boxed().toList());

        IntStream intStreamForTakeWhile = IntStream.rangeClosed(1, 5);
        // take all element but stop immediately if element is not match
        intStreamForTakeWhile.takeWhile(n -> n < 3).forEach(System.out::println);

        IntStream intStreamForDropWhile = IntStream.rangeClosed(1, 5);
        // start immediately when element is match
        intStreamForDropWhile.dropWhile(n -> n > 3).forEach(System.out::println);
    }

    static class Item {
        public List<String> subItem;

        public Item(List<String> subItem) {
            this.subItem = subItem;
        }
    }
}
