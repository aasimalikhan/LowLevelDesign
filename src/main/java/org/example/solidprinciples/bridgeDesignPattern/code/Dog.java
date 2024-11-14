package org.example.solidprinciples.bridgeDesignPattern.code;

public class Dog extends LivingThings{
    public Dog(BreatheImplementor breatheImplementor) {
        super(breatheImplementor);
    }

    @Override
    public void breatheProcess() {

    }
}
