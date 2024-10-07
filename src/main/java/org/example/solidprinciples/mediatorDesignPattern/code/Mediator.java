package org.example.solidprinciples.mediatorDesignPattern.code;

public interface Mediator {
    public void addBidder(Colleague bidder);
    public void placeBid(Colleague bidder, int bidAmount);
}
