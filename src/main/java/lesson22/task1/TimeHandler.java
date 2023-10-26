package lesson22.task1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.time.LocalTime;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TimeHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        Map<String, Integer> map = Map.of("/minsk", 0, "/washington", -4, "/beijing", 8);
        int time = map.get(requestURI.toString());
        LocalTime timeNow = LocalTime.now();
        String text = "Time in city: %s".formatted(Objects.toString(timeNow.plusHours(time)));
        byte[] result = text.getBytes();
        exchange.sendResponseHeaders(200, result.length);
        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(result);

    }
}
