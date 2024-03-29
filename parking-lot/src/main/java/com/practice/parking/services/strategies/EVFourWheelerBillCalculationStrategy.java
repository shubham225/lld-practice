package com.practice.parking.services.strategies;

import com.practice.parking.services.BillCalculationStrategy;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EVFourWheelerBillCalculationStrategy implements BillCalculationStrategy {
    @Override
    public int calculateAmount(Date entryTime, Date exitTime) {
        // TODO : Implementation
        return 0;
    }
}
