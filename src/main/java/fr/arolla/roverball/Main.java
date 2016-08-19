import static spark.Spark.*;

public class Main {

    private static final String NL = System.lineSeparator();

    public static void main(String[] args) {
        get("/hello", (req, res) -> {
            return ln("0 0") + ln("100 100") + ln("200 300");
        });
    }

    private static String ln(String line) {
        return line + NL;
    }
}