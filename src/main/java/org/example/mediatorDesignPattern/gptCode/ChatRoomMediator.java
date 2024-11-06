package org.example.mediatorDesignPattern.gptCode;

public interface ChatRoomMediator {
    public void addUser(Colleague colleague);
    public void sendMessage(Colleague colleague, String text);
}
