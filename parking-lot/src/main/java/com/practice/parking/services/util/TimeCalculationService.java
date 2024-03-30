package com.practice.parking.services.util;

import com.practice.parking.services.DataService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class TimeCalculationService {
    public long getDifferenceInHours(Date startDate, Date endDate) {
        long diffInMilliseconds = Math.abs(endDate.getTime() - startDate.getTime());

        return TimeUnit.HOURS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
    }
}
