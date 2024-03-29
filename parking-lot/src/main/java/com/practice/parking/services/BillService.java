package com.practice.parking.services;

import com.practice.parking.dtos.GenerateBillRequestDto;
import com.practice.parking.dtos.GenerateBillResponseDto;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    public GenerateBillResponseDto generateBill(GenerateBillRequestDto billRequestDto) {
        return new GenerateBillResponseDto();
    }
}
