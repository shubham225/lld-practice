package com.practice.parking.services;

import com.practice.parking.dtos.GenerateBillRequestDto;
import com.practice.parking.dtos.GenerateBillResponseDto;
import com.practice.parking.models.Bill;
import com.practice.parking.models.Gate;
import com.practice.parking.models.PaymentStatus;
import com.practice.parking.models.Ticket;
import com.practice.parking.repositories.BillRepository;
import com.practice.parking.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BillService {

    private final GateService gateService;
    private final TicketService ticketService;
    private final BillCalculationFactory billCalculationFactory;
    private final TicketRepository ticketRepository;
    private final BillRepository billRepository;
    private final SlotService slotService;

    public BillService(GateService gateService,
                       TicketService ticketService,
                       BillCalculationFactory billCalculationFactory,
                       TicketRepository ticketRepository,
                       BillRepository billRepository,
                       SlotService slotService) {
        this.gateService = gateService;
        this.ticketService = ticketService;
        this.billCalculationFactory = billCalculationFactory;
        this.ticketRepository = ticketRepository;
        this.billRepository = billRepository;
        this.slotService = slotService;
    }

    public GenerateBillResponseDto generateBill(GenerateBillRequestDto billRequestDto) {
        Gate exitGate = gateService.getGateById(billRequestDto.getGateId());
        Ticket ticket = ticketService.getTicketById(billRequestDto.getTicketId());

        ticket.setExitGate(exitGate);
        ticket.setExitDateTime(new Date());

        long amount = billCalculationFactory.getBillCalculationStrategy(ticket.getVehicle().getType())
                                           .calculateAmount(ticket.getEntryDateTime(), ticket.getExitDateTime());

        Bill bill = new Bill();
        bill.setPaymentType(billRequestDto.getPaymentType());
        bill.setPaymentStatus(PaymentStatus.UNPAID);
        bill.setAmount(amount);
        
        ticket = ticketRepository.save(ticket);
        
        bill.setTicket(ticket);
        bill = billRepository.save(bill);
        
        slotService.releaseSlot(bill.getTicket().getAllocatedSlot());

        return getBillResponseDtoFromBill(bill);
    }
    
    public GenerateBillResponseDto getBillResponseDtoFromBill(Bill bill) {
        GenerateBillResponseDto billResponseDto = new GenerateBillResponseDto();
        
        billResponseDto.setBillId(bill.getId());
        billResponseDto.setTicketId(bill.getTicket().getId());
        billResponseDto.setAmount(bill.getAmount());
        billResponseDto.setVehicleNo(bill.getTicket().getVehicle().getPlateNo());
        
        return billResponseDto;
    }
}
