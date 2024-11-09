package org.example.solidprinciples.adapterDesignPattern.WeightMachineUnitConverter.Adapter;

import org.example.solidprinciples.adapterDesignPattern.WeightMachineUnitConverter.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{
    WeightMachine weightMachine;
    public WeightMachineAdapterImpl(WeightMachine weightMachine)
    {
        this.weightMachine = weightMachine;
    }
    @Override
    public double getWeightInKg() {
        double weightInPound = weightMachine.getWeightInPound();
        double weightInKg = weightInPound * .45;
        return weightInKg;
    }
}
