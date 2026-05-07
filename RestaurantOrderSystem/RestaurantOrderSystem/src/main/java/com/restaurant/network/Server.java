package com.restaurant.network;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Server {
    public static final int PORT = 9090;
    public static void main(String[] args) {
        System.out.println("=== Restaurant Order Server ===");
        System.out.println("Starting on port " + PORT + "...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running. Waiting for clients...\n");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("[" + timestamp() + "] New client connected: "
                        + clientSocket.getInetAddress().getHostAddress());
                ClientHandler handler = new ClientHandler(clientSocket);
                Thread thread = new Thread(handler);
                thread.setDaemon(true);
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
    static String timestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
