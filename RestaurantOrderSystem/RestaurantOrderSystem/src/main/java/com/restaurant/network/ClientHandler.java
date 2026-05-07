package com.restaurant.network;

import java.io.*;
import java.net.Socket;
public class ClientHandler implements Runnable {
    private Socket socket;
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        String clientAddress = socket.getInetAddress().getHostAddress();
        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(socket.getOutputStream()), true)
        )
        {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("[" + Server.timestamp() + "] Order received from "
                        + clientAddress + ":");
                System.out.println("  " + message);
                System.out.println();

                // Send acknowledgement back to client
                writer.println("ORDER_RECEIVED:OK");
            }
        } catch (IOException e) {
            System.out.println("[" + Server.timestamp() + "] Client disconnected: "
                    + clientAddress);
        } finally {
            try { socket.close(); } catch (IOException ignored) {}
        }
    }
}
