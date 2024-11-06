package org.example.code;

public class OrdinaryVehicleFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle(String vehicle) {
        switch (vehicle)
        {
            case "HYUNDAI VERNA":
            {
                return new HyundaiVerna();
            }
            case "MAHINDRA THAR":
            {
                return new MahindraThar();
            }
            default:
            {
                return null;
            }
        }
    }
}
