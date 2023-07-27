package websocket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Iterator;

@ServerEndpoint("/myEndpoint")
public class WebsocketEndpoint {
    @OnOpen
    public void open(){
        System.out.println("socket is opened");
    }
//    @OnMessage
//    public String message(String mes){
//        System.out.println("message socket is received :  " + mes);
//        return  "Hello ... : " + mes ;
//    }
    @OnMessage
    public void message(Session s, String mes) throws IOException {
        System.out.println("message socket is received :  " + mes);
        Iterator<Session> iterator = s.getOpenSessions().iterator();
        while (iterator.hasNext()){
            Session next = iterator.next();
            if(next.isOpen()){
                next.getBasicRemote().sendText("hello" + mes);
            }
        }

    }
    @OnClose
    public void close(){
        System.out.println("websocket is close ...");
    }

}
