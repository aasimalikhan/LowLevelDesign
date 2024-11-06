package org.example.mediatorDesignPattern.gptCode;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatRoomMediator{
    public List<Colleague> users;

    public ChatRoom()
    {
        users = new ArrayList<>();
    }
    @Override
    public void addUser(Colleague colleague) {
        users.add(colleague);
    }

    @Override
    public void sendMessage(Colleague colleague, String text) {
        for(Colleague colleagueEntry : users)
        {
            if(colleague != colleagueEntry)
            {
                colleagueEntry.receiveNotification(text);
            }
        }
    }
}
