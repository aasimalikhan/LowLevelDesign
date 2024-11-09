package org.example.solidprinciples.adapterDesignPattern.WeightMachineUnitConverter.Client;

import org.example.solidprinciples.adapterDesignPattern.WeightMachineUnitConverter.Adaptee.WeightMachineForBabies;
import org.example.solidprinciples.adapterDesignPattern.WeightMachineUnitConverter.Adapter.WeightMachineAdapter;
import org.example.solidprinciples.adapterDesignPattern.WeightMachineUnitConverter.Adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
