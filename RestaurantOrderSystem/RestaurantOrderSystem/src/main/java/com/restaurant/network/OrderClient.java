package com.restaurant.network;

import java.io.*;
import java.net.Socket;
public class OrderClient {
    private static final String HOST = "localhost";
    private static final int    PORT = Server.PORT;
    public String sendOrder(String orderData) {
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(socket.getOutputStream()), true);
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()))
        )
        {
            writer.println(orderData);
            String response = reader.readLine();
            return (response != null) ? response : "No response from server";

        } catch (IOException e) {
            return "ERROR: Could not connect to server. " + e.getMessage();
        }
    }
}
