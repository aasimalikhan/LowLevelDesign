package org.example.commandDesignPattern.goodCode;

import org.example.commandDesignPattern.goodCode.command.TurnOffAcCommand;
import org.example.commandDesignPattern.goodCode.command.TurnOnAcCommand;
import org.example.commandDesignPattern.goodCode.invoker.Invoker;
import org.example.commandDesignPattern.goodCode.receiver.AirConditioner;

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
