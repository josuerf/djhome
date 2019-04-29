package com.djhome.server.protocols;


import com.djhome.server.model.ServerInterface;
import com.djhome.server.reflection.RequestActionFinder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements ServerInterface<DataOutputStream> {

    public TCPServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(999);
        System.out.println("TCP Server is running.");
        while (true) {
            Socket socket = serverSocket.accept();
            try (BufferedReader clientRequest = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {

                String response = RequestActionFinder.doRequestAction(clientRequest.readLine());
                sendResponse(dataOutputStream, response);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendResponse(DataOutputStream dataOutputStream, String action) throws IOException {
        dataOutputStream.writeBytes(action+"\n");
        dataOutputStream.flush();
    }
}
