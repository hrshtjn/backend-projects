import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPOC {

    public static void main(String[] args) throws IOException {
        //1. Int Stream
        System.out.println("1. Int Stream");
        IntStream.range(1,5).forEach(System.out::println);

        //2. skip first 5 elements from int stream
        System.out.println("\n\n2. skip first 5 elements from int stream");
        IntStream.range(1,10).skip(5).forEach(System.out::println);

        //3. Int stream with sum
        System.out.println("\n\n3. Int stream with sum");
        int total = IntStream.range(1,5).sum();
        System.out.println(total);

        //4. Create stream, sort and find first
        System.out.println("\n\n4. Create stream, sort and find first");
        Stream.of("Apple","Banana","Cat")
                        .sorted()
                                .findFirst().ifPresent(System.out::println);

        //5. Stream rows from text file, sort, filter and save to list
        System.out.println("\n\n5. Stream rows from text file, sort, filter and print");
        Stream<String> bands = Files.lines(Paths.get("C:\\development\\backend-projects\\java8\\bands.txt"));
        List<String> result= bands.filter(x ->x.length()>8).sorted().collect(Collectors.toList());
        System.out.println(result);
        bands.close();

        //6. Stream rows from csv file, store fields in hashmap
        System.out.println("\n\n6. Stream rows from csv file, store fields in hashmap");
        Stream<String> rows = Files.lines(Paths.get("C:\\development\\backend-projects\\java8\\data.txt"));
        Map<String,Integer> map = new HashMap<>();
        map = rows.map(x -> x.split(","))
                .filter(x -> x.length==3)
                .filter(x -> Integer.parseInt(x[1])>3)
                .collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
        rows.close();
        System.out.println(map);

        //7. Sum the elements - reduce
        System.out.println("\n\n7. Sum the elements - reduce");
        double total2 = Stream.of(1.3,2.5,6.5)
                .reduce(0.0, (Double a, Double b) -> a+b);
        System.out.println(total2);

        //8. Difference between Map and flatmap
        System.out.println("\n\n8.a Get a list of all email IDs");
        CustomerDB.getAll().stream().map(c -> c.getEmail()).forEach(System.out::println);

        System.out.println("\n\n8.b Get a list of all phone numbers");
        CustomerDB.getAll().stream().flatMap(c-> c.getPhoneNumbers().stream()).forEach(System.out::println);
    }
}
