/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngc.battledrills.vmf.VmfManager;
import com.ngc.battledrills.vmf.VmfMessage;
import java.io.IOException;
import java.net.URI;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import org.eclipse.jetty.websocket.client.WebSocketClient;
/**
 *
 * @author admin
 */
public class BattleDrillsClientWebsocket extends WebSocketAdapter {
    
    Session battleDrillsSession = null;
    private final static int ONE_DAY = 8640000;
    private final String userpass = "vmf_admin:Vinson0)Vinson0)";
    
    // TODO: eventually, we will probably want to make this a configured uri where the IP can be specified somehow
    // this is assuming that Battle drills will be installed on the same server as Vmf Manager App
    private final static String VMF_URI = "wss://localhost:8443/VmfManagerApp/ws";
    
    // connect to VMF Manager App Websockets
    public BattleDrillsClientWebsocket() {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
            @Override
            public X509Certificate[] getAcceptedIssuers(){return new X509Certificate[0];}
            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType){}
            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};
        
        SslContextFactory sslContextFactory = new SslContextFactory();
    
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            sslContextFactory.setSslContext(sc);
            
            WebSocketClient client = new WebSocketClient(sslContextFactory);
            client.start();
            
            client.getPolicy().setIdleTimeout(ONE_DAY);
            client.setMaxIdleTimeout(ONE_DAY);
            
            // internal app auth token
            String authToken = Base64.getEncoder().encodeToString(userpass.getBytes());
            
            
            Future<Session> bdVmfSession = client.connect(this, URI.create(VMF_URI + "?authToken=" + authToken));
            Session session = bdVmfSession.get();

            // TODO: can do stuff with sessions here later
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void onWebSocketConnect(Session session) {
        super.onWebSocketConnect(session);
        System.out.println("Battle drills connected to VMF websocket");
    }
    
    @Override
    public void onWebSocketText(String message) {
        super.onWebSocketText(message);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            VmfMessage vmfMessage = objectMapper.readValue(message, VmfMessage.class);
            System.out.println("received message from vmf manager: " + vmfMessage.getMessageBody().getType());
            VmfManager vmfManager = VmfManager.getInstance();
            vmfManager.handleVmfMessage(vmfMessage);
        } catch (IOException ex) {
            Logger.getLogger(BattleDrillsClientWebsocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void onWebSocketClose(int statusCode, String reason) {
        super.onWebSocketClose(statusCode, reason);
        System.out.println("Websocket connection closed: " + reason);
    }
    
    @Override
    public void onWebSocketError(Throwable cause) {
        super.onWebSocketError(cause);
        cause.printStackTrace(System.err);
    }
}
