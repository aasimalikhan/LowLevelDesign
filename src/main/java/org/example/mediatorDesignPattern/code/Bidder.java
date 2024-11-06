package org.example.mediatorDesignPattern.code;

public class Bidder implements Colleague{
    String name;
    Mediator mediator;
    public Bidder(String name, Mediator mediator){
        this.name = name;
        this.mediator = mediator;
        mediator.addBidder(this);
    }

    @Override
    public void placeBid(int bidAmount) {
        mediator.placeBid(this, bidAmount);
    }

    @Override
    public void receiveBidNotification(int bidAmount) {
        System.out.println("Notification received for bid: " + bidAmount);
    }

    @Override
    public String getName() {
        return null;
    }
}
