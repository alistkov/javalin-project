package io.hexlet.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String postsPath() {
        return "/posts";
    }

    public static String buildPostPath() {
        return "/posts/build";
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }

    public static String editPath(Long id) {
        return editPath(String.valueOf(id));
    }

    public static String editPath(String id) {
        return "/posts/" + id + "/edit";
    }

    public static String updatePath(Long id) {
        return updatePath(String.valueOf(id));
    }

    public static String updatePath(String id) {
        return "/posts/" + id + "/update";
    }

    public static String usersPath() {
        return "/users";
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }

    public static String buildUserPath() {
        return "/users/build";
    }
}
