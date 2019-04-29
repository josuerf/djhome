package com.djhome.client.api;


import com.djhome.client.api.listeners.OnAPIErrorListener;
import com.djhome.client.api.listeners.OnAPIResponseListener;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPRequest implements Request{

    private final String host;
    private final int port;

    TCPRequest(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void executeCall(String param, OnAPIResponseListener onAPIResponseListener, OnAPIErrorListener onAPIErrorListener) {
        try (Socket socket = new Socket(host, port);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.ISO_8859_1))){

            outputStream.writeBytes(param+"\n");

            if(onAPIResponseListener != null) {
                onAPIResponseListener.onResponse(reader.readLine());
            }

        } catch (IOException e) {
            if(onAPIErrorListener != null) {
                onAPIErrorListener.onError(e);
            }
        }
    }
}
