package main.java.com.djhome.client.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.com.djhome.client.api.listeners.OnAPIErrorListener;
import main.java.com.djhome.client.api.listeners.OnAPIResponseListener;
import main.java.com.djhome.io.FileUtils;

import java.util.Map;

public class RequestBuilder {
    private String host = "127.0.0.1";
    private int port = 999;
    private final RequestType requestType;
    private String param;
    private OnAPIResponseListener responseListener;
    private OnAPIErrorListener errorListener;

    public RequestBuilder() {
        Map<String, RequestType> config = new Gson()
                .fromJson(FileUtils.readJsonFile("config"),
                        new TypeToken<Map<String, RequestType>>() {
                        }.getType());

        assert config != null;

        requestType = config.get("protocol");
    }

    public RequestBuilder withDistance(int param) {
        this.param = String.valueOf(param);
        return this;
    }

    public RequestBuilder withHost(String host){
        this.host = host;
        return this;
    }

    public RequestBuilder withPort(String pott) {
        this.port = port;
        return this;
    }

    public RequestBuilder onResponse(OnAPIResponseListener responseListener) {
        this.responseListener = responseListener;
        return this;
    }

    public RequestBuilder onError(OnAPIErrorListener errorListener) {
        this.errorListener = errorListener;
        return this;
    }

    public void call() {
        switch (requestType) {
            case TCP:
                new TCPRequest(host, port).executeCall(param, responseListener, errorListener);
                break;
            case UDP:
                new UDPRequest(host, port).executeCall(param, responseListener, errorListener);
                break;
        }

    }

}
