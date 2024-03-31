package com.practice.parking.services;

import com.practice.parking.dtos.GenerateTicketRequestDto;
import com.practice.parking.dtos.GenerateTicketResponseDto;
import com.practice.parking.dtos.VehicleDto;
import com.practice.parking.exceptions.TicketNotFoundException;
import com.practice.parking.models.Gate;
import com.practice.parking.models.Slot;
import com.practice.parking.models.Ticket;
import com.practice.parking.models.Vehicle;
import com.practice.parking.repositories.GateRepository;
import com.practice.parking.repositories.TicketRepository;
import com.practice.parking.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketService {

    private final VehicleRepository vehicleRepository;
    private final GateService gateService;
    private final SlotAllocationFactory slotAllocationFactory;
    private final TicketRepository ticketRepository;

    public TicketService(VehicleRepository vehicleRepository,
                         GateService gateService,
                         SlotAllocationFactory slotAllocationFactory,
                         TicketRepository ticketRepository) {
        this.vehicleRepository = vehicleRepository;
        this.gateService = gateService;
        this.slotAllocationFactory = slotAllocationFactory;
        this.ticketRepository = ticketRepository;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto ticketRequestDto) {
        Vehicle vehicle = getVehicleFromVehicleDto(ticketRequestDto.getVehicle());
        Gate gate = gateService.getGateById(ticketRequestDto.getGateId());

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryGate(gate);
        ticket.setEntryDateTime(new Date());
        ticket.setExitGate(null);
        ticket.setExitDateTime(null);
        ticket = ticketRepository.save(ticket);

        slotAllocationFactory.getBestSlotAllocationStrategy().allocateSlot(ticket);

        ticket = ticketRepository.save(ticket);

        return getTicketResponseDtoFromTicket(ticket);
    }

    public GenerateTicketResponseDto getTicketResponseDtoFromTicket(Ticket ticket) {
        GenerateTicketResponseDto ticketResponseDto = new GenerateTicketResponseDto();
        ticketResponseDto.setTicketId(ticket.getId());
        ticketResponseDto.setGateId(ticket.getEntryGate().getId());

        String slotLocation = ticket.getAllocatedSlot().getFloor().getName() + "-" + ticket.getAllocatedSlot().getName();

        ticketResponseDto.setSlot(slotLocation);

        ticketResponseDto.setVehicleNo(ticket.getVehicle().getPlateNo());

        return ticketResponseDto;
    }

    private Vehicle getVehicleFromVehicleDto(VehicleDto vehicle) {
        Vehicle vehicle1 = null;

        Optional<Vehicle> vehicleOptional = vehicleRepository.findByPlateNo(vehicle.getPlateNo());

        if(vehicleOptional.isEmpty()) {
            vehicle1 = new Vehicle();
            vehicle1.setPlateNo(vehicle.getPlateNo());
            vehicle1.setModel(vehicle.getModel());
            vehicle1.setManufacturer(vehicle.getManufacturer());
            vehicle1.setType(vehicle.getVehicleType());

            vehicle1 = vehicleRepository.save(vehicle1);
        }else {
            vehicle1 = vehicleOptional.get();
        }

        return vehicle1;
    }

    public Ticket getTicketById(UUID ticketId) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);

        if(ticketOptional.isEmpty())
            throw new TicketNotFoundException("Ticket with id '" + ticketId + "' not Found");

        return ticketOptional.get();
    }
}
