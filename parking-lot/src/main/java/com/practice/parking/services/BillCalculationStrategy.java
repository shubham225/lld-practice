package com.practice.parking.services;

import com.practice.parking.models.Vehicle;

import java.util.Date;

public interface BillCalculationStrategy {
    public int calculateAmount(Date entryTime, Date exitTime);
}
