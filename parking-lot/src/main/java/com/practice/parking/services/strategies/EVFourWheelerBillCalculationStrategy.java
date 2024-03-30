package com.practice.parking.services.strategies;

import com.practice.parking.services.BillCalculationStrategy;
import com.practice.parking.services.util.TimeCalculationService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EVFourWheelerBillCalculationStrategy implements BillCalculationStrategy {
    private final TimeCalculationService timeCalculationService;
    private final long EV_CHARGING_COST_PER_HOUR = 50;
    private final long EV_PARKING_COST_PER_HOUR = 100;

    public EVFourWheelerBillCalculationStrategy(TimeCalculationService timeCalculationService) {
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
        amount += hours * EV_CHARGING_COST_PER_HOUR;

        return amount;
    }
}
