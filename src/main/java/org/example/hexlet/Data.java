package org.example.hexlet;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import net.datafaker.Faker;
import org.example.hexlet.model.User;

public class Data {
    private static final int ITEMS_COUNT = 30;
    private static final Random RANDOM = new Random(123);
    private static long idCounter = ITEMS_COUNT;

    public static List<String> getPhones() {
        Faker faker = new Faker(new Locale("en"), RANDOM);
        List<String> phones = new ArrayList<>();
        for (int i = 0; i < ITEMS_COUNT; i++) {
            phones.add(faker.phoneNumber().cellPhone());
        }

        return phones;
    }

    public static List<String> getDomains() {
        Faker faker = new Faker(new Locale("en"), RANDOM);
        List<String> domains = new ArrayList<>();
        for (int i = 0; i < ITEMS_COUNT; i++) {
            domains.add(faker.internet().domainName());
        }

        return domains;
    }

    public static List<User> getUsers() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        List<Long> ids = LongStream
            .range(1, ITEMS_COUNT + 1)
            .boxed()
            .collect(Collectors.toList());
        Collections.shuffle(ids, random);

        List<User> users = new ArrayList<>();

        for (int i = 0; i < ITEMS_COUNT; i++) {
            var id = ids.get(i);
            var firstName = faker.name().firstName();
            var lastName = faker.name().lastName();
            var email = faker.internet().emailAddress();
            User user = new User(id, firstName, lastName, email);
            users.add(user);
        }

        return users;
    }

    public static long getNextId() {
        return ++idCounter;
    }

    public static List<Map<String, String>> getCompanies() {
        Random random = new Random(123);
        Faker faker = new Faker(random);

        List<String> ids = IntStream
            .range(1, ITEMS_COUNT + 1)
            .mapToObj(i -> Integer.toString(i))
            .collect(Collectors.toList());
        Collections.shuffle(ids, random);

        List<Map<String, String>> companies = new ArrayList<>();

        for (int i = 0; i < ITEMS_COUNT; i++) {
            Map<String, String> company = new HashMap<>();
            company.put("id", ids.get(i));
            company.put("name", faker.company().name());
            company.put("phone", faker.phoneNumber().phoneNumber());
            companies.add(company);
        }

        return companies;
    }
}
