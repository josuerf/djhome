package com.djhome.server;

import com.djhome.server.protocols.TCPServer;
import com.djhome.server.protocols.UDPServer;
import com.djhome.server.utils.MenuUtils;
import com.djhome.utils.KeyboardUtils;
import com.djhome.utils.Protocols;

import java.io.IOException;

public class Server {

    private static void initServer(Protocols protocol) throws IOException {
        switch (protocol) {
            case TCP:
                new TCPServer();
            case UDP:
                new UDPServer();
        }
    }

    public static void main(String[] args) throws IOException {
        MenuUtils.showConfigurationMenu();
        Protocols serverType = KeyboardUtils.getSelectedProtocol();
        initServer(serverType);
    }

}
