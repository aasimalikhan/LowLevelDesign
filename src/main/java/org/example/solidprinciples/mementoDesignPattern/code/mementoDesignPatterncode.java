package org.example.solidprinciples.mementoDesignPattern.code;

public class mementoDesignPatterncode {
    public static void main(String[] args) {
        ConfigurationCareTaker careTaker = new ConfigurationCareTaker();
        ConfigurationOriginator originator = new ConfigurationOriginator(10, 15);
        ConfigurationMemento snapshot1 = originator.createMemento();
        careTaker.addMemento(snapshot1);
        originator.setHeight(12);
        originator.setWidth(17);
        ConfigurationMemento snapshot2 = originator.createMemento();
        careTaker.addMemento(snapshot2);
        originator.setHeight(14);
        originator.setWidth(19);
//        ConfigurationMemento snapshot3 = originator.createMemento();

        System.out.println("originator state");
        System.out.println("height: " + originator.getHeight());
        System.out.println("width: " + originator.getWidth());

        ConfigurationMemento prevMemento = careTaker.undo();
        originator.restoreMemento(prevMemento);
        System.out.println("originator state");
        System.out.println("height: " + originator.getHeight());
        System.out.println("width: " + originator.getWidth());
    }
}
