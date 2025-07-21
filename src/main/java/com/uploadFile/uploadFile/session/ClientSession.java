package com.uploadFile.uploadFile.session;

import com.uploadFile.uploadFile.model.entity.ClientEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component
public class ClientSession {
    private  HttpSession session;

    public ClientSession(HttpSession session) {
        this.session = session;
    }

    public ClientEntity getSession(){
        return (ClientEntity)session.getAttribute("client");
    }
    public void setSession(ClientEntity entity){
        session.setAttribute("client",entity);
    }
}
