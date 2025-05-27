package org.example.hexlet;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import net.datafaker.Faker;

public class Data {
    private static final int ITEMS_COUNT = 10;
    private static final Random RANDOM = new Random(123);
    private static final int USERS_COUNT = 30;
    private static final int COMPANIES_COUNT = 30;

    private static int idCounter = USERS_COUNT;

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

    public static List<Map<String, String>> getUsers() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        List<String> ids = IntStream
            .range(1, USERS_COUNT + 1)
            .mapToObj(i -> Integer.toString(i))
            .collect(Collectors.toList());
        Collections.shuffle(ids, random);

        List<Map<String, String>> users = new ArrayList<>();

        for (int i = 0; i < USERS_COUNT; i++) {
            Map<String, String> user = new HashMap<>();
            user.put("id", ids.get(i));
            user.put("firstName", faker.name().firstName());
            user.put("lastName", faker.name().lastName());
            users.add(user);
        }

        return users;
    }

    public static String getNextId() {
        int id = ++idCounter;
        return Integer.toString(id);
    }

    public static List<Map<String, String>> getCompanies() {
        Random random = new Random(123);
        Faker faker = new Faker(random);

        List<String> ids = IntStream
            .range(1, COMPANIES_COUNT + 1)
            .mapToObj(i -> Integer.toString(i))
            .collect(Collectors.toList());
        Collections.shuffle(ids, random);

        List<Map<String, String>> companies = new ArrayList<>();

        for (int i = 0; i < COMPANIES_COUNT; i++) {
            Map<String, String> company = new HashMap<>();
            company.put("id", ids.get(i));
            company.put("name", faker.company().name());
            company.put("phone", faker.phoneNumber().phoneNumber());
            companies.add(company);
        }

        return companies;
    }
}
