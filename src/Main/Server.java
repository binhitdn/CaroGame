package Main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import Model.ThreadServer;
import Model.ThreadServers;

public class Server {

    public static ThreadServers threadServers;
    public static Socket socketOfServer;
    public static int ID_room;
    public static Admin admin;

    public static void main(String[] args) {
    	
        ServerSocket listener = null;
        threadServers = new ThreadServers();
        System.out.println("Khởi động thành công...");
        int clientNumber = 0;
        ID_room = 10000;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 
                100, 
                10, 
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8) 
        );
        
        try {
            listener = new ServerSocket(12340);
        } catch (IOException e) {
           
            System.exit(1);
        }
        admin = new Admin();
        admin.run();
        try {
            while (true) {
                socketOfServer = listener.accept();
                ThreadServer serverThread = new ThreadServer(socketOfServer, clientNumber++);
                System.out.println(clientNumber);
                threadServers.add(serverThread);
                executor.execute(serverThread);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                listener.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
