package fr.arolla.roverball;

import static java.lang.Math.abs;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import java.util.Random;

public class App {

    public static void main(String[] args) {
    	staticFiles.location("/public");
        port(getHerokuAssignedPort());
        get("/hello", (req, res) -> {
            return "["
            		+ "{\"x\": "+random(1300)+",   \"y\": "+random(500)+"}, "
            		+ "{\"x\": "+random(1300)+",   \"y\": "+random(500)+"}, "
            		+ "{\"x\": "+random(1300)+",   \"y\": "+random(500)+"}"
            		+ "]";
        });
    }

    private static int random(int max) {
		return abs(new Random().nextInt() % max) ;
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