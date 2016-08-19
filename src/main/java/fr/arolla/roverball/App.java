package fr.arolla.roverball;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        get("/hello", (req, res) -> {
            return "0 0 100 100 200 300";
        });
    }

    public static final String ln(String line) {
        return line + System.lineSeparator();
    }

    public static final int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}