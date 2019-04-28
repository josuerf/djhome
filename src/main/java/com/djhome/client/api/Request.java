package main.java.com.djhome.client.api;

import main.java.com.djhome.client.api.listeners.OnAPIErrorListener;
import main.java.com.djhome.client.api.listeners.OnAPIResponseListener;

public interface Request {
    void executeCall(String param,
                     OnAPIResponseListener onAPIResponseListener,
                     OnAPIErrorListener onAPIErrorListener);
}
