package org.example.commandDesignPattern.goodCode.command;


import org.example.commandDesignPattern.goodCode.receiver.AirConditioner;

public class TurnOnAcCommand implements ICommand{
    AirConditioner ac;
    public TurnOnAcCommand(AirConditioner ac)
    {
        this.ac = ac;
    }
    @Override
    public void execute() {
        ac.turnOnAC();
    }

    @Override
    public void undo() {
        ac.turnOffAC();
    }
}
