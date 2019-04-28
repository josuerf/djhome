package main.java.com.djhome.server.model;

import java.io.IOException;

public interface ServerInterface<T> {
    void sendResponse(T dataSendingObject, String response) throws IOException;
}
