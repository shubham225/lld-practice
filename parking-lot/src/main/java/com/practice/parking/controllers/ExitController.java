package com.practice.parking.controllers;

import com.practice.parking.dtos.GenerateBillRequestDto;
import com.practice.parking.dtos.GenerateBillResponseDto;
import com.practice.parking.services.BillService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/V1/exit")
public class ExitController {
    private final BillService billService;

    public ExitController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/bill"
    )
    public GenerateBillResponseDto generateTicket(@RequestBody GenerateBillRequestDto billRequestDto) {
        return billService.generateBill(billRequestDto);
    }
}
