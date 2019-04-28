package main.java.com.djhome.client.api;

import main.java.com.djhome.client.api.listeners.OnAPIErrorListener;
import main.java.com.djhome.client.api.listeners.OnAPIResponseListener;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

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

            byte[] response = new byte[1024];

            InetAddress IPAddress = InetAddress.getByName(host);
            DatagramPacket sendPacket = new DatagramPacket(param.getBytes(), param.getBytes().length,
                    IPAddress, port);
            socket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(response, response.length);
            socket.receive(receivePacket);
            if(onAPIResponseListener != null) {
                onAPIResponseListener.onResponse(Arrays.toString(receivePacket.getData()));
            }

        } catch (IOException e) {
            if (onAPIErrorListener != null) {
               onAPIErrorListener.onError(e);
            }
        }
    }
}
