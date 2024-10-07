package org.example.solidprinciples.mediatorDesignPattern.gptCode;

public class User implements Colleague{
    public ChatRoomMediator mediator;
    String userName;
    public User(String userName, ChatRoomMediator mediator)
    {
        this.userName = userName;
        this.mediator = mediator;
        mediator.addUser(this);
    }
    @Override
    public void sendMessage(String text) {
        mediator.sendMessage(this, text);
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println(message + ": message received");
    }
}
