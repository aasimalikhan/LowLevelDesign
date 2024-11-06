package org.example.commandDesignPattern.goodCode.invoker;

import org.example.commandDesignPattern.goodCode.command.ICommand;

import java.util.Stack;

public class Invoker {
    Stack<ICommand> commandHistory = new Stack<>();
    ICommand command;
    public Invoker()
    {

    }
    public void setCommand(ICommand command)
    {
        this.command = command;
    }
    public void pressButton()
    {
        command.execute();
        commandHistory.push(command);
    }

    public void undo()
    {
        if(!commandHistory.isEmpty())
        {
            ICommand prevCommand = commandHistory.pop();
            prevCommand.undo();
        }
    }

}
