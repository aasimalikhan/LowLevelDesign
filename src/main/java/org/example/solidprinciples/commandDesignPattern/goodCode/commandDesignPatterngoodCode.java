package org.example.solidprinciples.commandDesignPattern.goodCode;

import org.example.solidprinciples.commandDesignPattern.goodCode.command.TurnOffAcCommand;
import org.example.solidprinciples.commandDesignPattern.goodCode.command.TurnOnAcCommand;
import org.example.solidprinciples.commandDesignPattern.goodCode.invoker.Invoker;
import org.example.solidprinciples.commandDesignPattern.goodCode.receiver.AirConditioner;

public class commandDesignPatterngoodCode {
    public static void main(String[] args) {
        AirConditioner ac = new AirConditioner();
        Invoker invoker = new Invoker();
        invoker.setCommand(new TurnOnAcCommand(ac));
        invoker.pressButton();

        invoker.setCommand(new TurnOffAcCommand(ac));
        invoker.pressButton();
    }
}
