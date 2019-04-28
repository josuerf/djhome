package main.java.com.djhome.server.protocols;

import main.java.com.djhome.server.model.ServerInterface;
import main.java.com.djhome.server.reflection.RequestActionFinder;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer implements ServerInterface<DatagramPacket> {

    private DatagramSocket serverSocket;

    public UDPServer() throws IOException {

        serverSocket = new DatagramSocket(999);
        System.out.println("UDP Server is running.");

        byte[] receiveData = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);

        String response = RequestActionFinder.doRequestAction(new String(receivePacket.getData()));
        sendResponse(receivePacket, response);

    }

    @Override
    public void sendResponse(DatagramPacket receivePacket, String response) throws IOException {
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        DatagramPacket sendPacket = new DatagramPacket(response.getBytes(),
                response.getBytes().length,
                IPAddress,
                port);
        serverSocket.send(sendPacket);
    }
}
