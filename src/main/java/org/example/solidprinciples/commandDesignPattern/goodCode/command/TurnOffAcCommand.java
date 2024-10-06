package org.example.solidprinciples.commandDesignPattern.goodCode.command;

import org.example.solidprinciples.commandDesignPattern.goodCode.receiver.AirConditioner;

public class TurnOffAcCommand implements ICommand{
    AirConditioner ac;
    public TurnOffAcCommand(AirConditioner ac)
    {
        this.ac = ac;
    }
    @Override
    public void execute() {
        ac.turnOffAC();
    }

    @Override
    public void undo() {
        ac.turnOnAC();
    }
}
