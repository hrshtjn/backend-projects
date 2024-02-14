package com.demo.kafkapoc.util;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FakeDataUtil {

    public List<String> getListOfFakeNames() {
        Faker faker = new Faker();
        // this code is generating a list of fake names with a length between 3 and 5.
        // The names are constructed by combining a fake first name and a fake last name
        // using the Faker library.
        List<String> names = faker.collection(
                        () -> faker.name().firstName(),
                        () -> faker.name().lastName())
                .len(3, 5)
                .generate();

        return names;
    }

    public static List<String> getFakeQuotes(int numberOfQuotes) {
        Faker faker = new Faker();
        List<String> quotes = new ArrayList<>();
        for (int i = 0; i < numberOfQuotes; i++) {
            // Use hobbit().quote() to generate a fake Hobbit quote
            String hobbitQuote = faker.hobbit().quote();
            quotes.add(hobbitQuote);
        }
        return quotes;
    }

    public Stream<String> getInfiniteFakeNames() {
        Faker faker = new Faker();
// generate an infinite stream
        Stream<String> names = faker.stream(
                        () -> faker.name().firstName(),
                        () -> faker.name().lastName())
                .generate();

        return names;
    }
}
