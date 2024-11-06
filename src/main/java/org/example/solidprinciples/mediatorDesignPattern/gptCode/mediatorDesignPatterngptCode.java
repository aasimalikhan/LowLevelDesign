package org.example.solidprinciples.mediatorDesignPattern.gptCode;

public class mediatorDesignPatterngptCode {
    public static void main(String[] args) {
        ChatRoomMediator chatroom = new ChatRoom();
        Colleague user1 = new User("aasim", chatroom);
        Colleague user2 = new User("emaad", chatroom);
        Colleague user3 = new User("rida", chatroom);

        user1.sendMessage("hello");
        user2.sendMessage("hi");
    }
}
