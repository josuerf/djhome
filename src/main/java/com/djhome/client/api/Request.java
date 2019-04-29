package com.djhome.client.api;


import com.djhome.client.api.listeners.OnAPIErrorListener;
import com.djhome.client.api.listeners.OnAPIResponseListener;

public interface Request {
    void executeCall(String param,
                     OnAPIResponseListener onAPIResponseListener,
                     OnAPIErrorListener onAPIErrorListener);
}
