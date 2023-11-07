import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerDB {

    public static List<Customer> getAll() {
        return Stream.of(new Customer(101,"Harshit","hrsht.jn@gmail.com", List.of("9428048930","9499773038")),
                new Customer(102,"Paryul","paryul@gmail.com", List.of("9111977211","9426614125")))
                .collect(Collectors.toList());

    }
}
