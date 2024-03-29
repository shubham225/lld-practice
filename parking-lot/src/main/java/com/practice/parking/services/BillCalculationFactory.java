package com.practice.parking.services;

import com.practice.parking.models.VehicleType;
import com.practice.parking.services.strategies.EVFourWheelerBillCalculationStrategy;
import com.practice.parking.services.strategies.FourWheelerBillCalculationStrategy;
import com.practice.parking.services.strategies.TwoWheelerBillCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class BillCalculationFactory {
    private final EVFourWheelerBillCalculationStrategy evFourWheelerBillCalculationStrategy;
    private final FourWheelerBillCalculationStrategy fourWheelerBillCalculationStrategy;
    private final TwoWheelerBillCalculationStrategy twoWheelerBillCalculationStrategy;

    public BillCalculationFactory(EVFourWheelerBillCalculationStrategy evFourWheelerBillCalculationStrategy,
                                   FourWheelerBillCalculationStrategy fourWheelerBillCalculationStrategy,
                                   TwoWheelerBillCalculationStrategy twoWheelerBillCalculationStrategy) {
        this.evFourWheelerBillCalculationStrategy = evFourWheelerBillCalculationStrategy;
        this.fourWheelerBillCalculationStrategy = fourWheelerBillCalculationStrategy;
        this.twoWheelerBillCalculationStrategy = twoWheelerBillCalculationStrategy;
    }
    public BillCalculationStrategy getBillCalculationStrategy(VehicleType vehicleType) {
        switch (vehicleType) {
            case TWO_WHEELER -> {
                return twoWheelerBillCalculationStrategy;
            }
            case FOUR_WHEELER -> {
                return fourWheelerBillCalculationStrategy;
            }
            case EV_FOUR_WHEELER -> {
                return evFourWheelerBillCalculationStrategy;
            }
        }

        return fourWheelerBillCalculationStrategy;
    }
}
