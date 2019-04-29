package com.djhome.client.api;


import com.djhome.client.api.listeners.OnAPIErrorListener;
import com.djhome.client.api.listeners.OnAPIResponseListener;

import java.io.IOException;
import java.net.*;

public class UDPRequest implements Request{

    private final String host;
    private final int port;

    UDPRequest(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void executeCall(String param, OnAPIResponseListener onAPIResponseListener, OnAPIErrorListener onAPIErrorListener) {
        try (DatagramSocket socket = new DatagramSocket()){

            byte[] responseBuffer = new byte[1024];

            InetAddress IPAddress = InetAddress.getByName(host);
            DatagramPacket sendPacket = new DatagramPacket(param.getBytes(), param.getBytes().length,
                    IPAddress, port);
            socket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(receivePacket);
            responseBuffer = receivePacket.getData();

            if(onAPIResponseListener != null) {
                onAPIResponseListener.onResponse(new String(responseBuffer, 0, responseBuffer.length));
            }

        } catch (IOException e) {
            if (onAPIErrorListener != null) {
               onAPIErrorListener.onError(e);
            }
        }
    }
}
