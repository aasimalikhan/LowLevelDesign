package org.example.solidprinciples.adapterDesignPattern.WeightMachineUnitConverter.Adaptee;

public class WeightMachineForBabies implements WeightMachine{
    @Override
    public double getWeightInPound() {
        return 28;
    }
}
