package io.hexlet.util;

public class NamedRoutes {
    public static String homePath() {
        return "/";
    }

    public static String postsPath() {
        return "/posts";
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/courses/" + id;
    }
}
