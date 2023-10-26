package lesson22.task1;
/*Создать приложение, которое при переходе на следующие урлы будет выдавать
результат:
/minsk - время в Минске
/washington - время в Вашингтоне
/beijing - время в Пекине*/

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;


public class HttpServerLauncher {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/minsk", new TimeHandler());
        httpServer.createContext("/washington", new TimeHandler());
        httpServer.createContext("/beijing", new TimeHandler());
        httpServer.start();
    }
}
