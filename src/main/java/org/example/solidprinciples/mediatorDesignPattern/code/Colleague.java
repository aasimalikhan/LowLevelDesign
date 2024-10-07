package org.example.solidprinciples.mediatorDesignPattern.code;

public interface Colleague {
    void placeBid(int bidAmount);
    void receiveBidNotification(int bidAmount);
    String getName();
}
