package com.practice.parking.services;

import java.util.Date;

public interface BillCalculationStrategy {
    public long calculateAmount(Date entryTime, Date exitTime);
}
