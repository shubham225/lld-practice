package com.practice.parking.services.strategies;

import com.practice.parking.services.BillCalculationStrategy;
import com.practice.parking.services.util.TimeCalculationService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FourWheelerBillCalculationStrategy implements BillCalculationStrategy {
    private final TimeCalculationService timeCalculationService;
    private final long EV_PARKING_COST_PER_HOUR = 75;

    public FourWheelerBillCalculationStrategy(TimeCalculationService timeCalculationService) {
        this.timeCalculationService = timeCalculationService;
    }

    @Override
    public long calculateAmount(Date entryTime, Date exitTime) {
        // TODO : Implementation
        long amount = 0;
        long hours = timeCalculationService.getDifferenceInHours(entryTime, exitTime);

        if(hours < 1)
            hours = 1;

        amount = hours * EV_PARKING_COST_PER_HOUR;

        return amount;
    }
}
