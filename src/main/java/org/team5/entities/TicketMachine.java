package org.team5.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@DiscriminatorValue("ticket_dispatcher")
public class TicketMachine extends TicketVendor {

    private MachineStatus machineStatus;
    public TicketMachine() {
    }

    public TicketMachine(Location location, MachineStatus machineStatus) {
        super(location);
        this.machineStatus = machineStatus;
    }

    @Override
    public String toString() {
        return "TicketMachine{" +
                "machineStatus=" + machineStatus +
                '}';
    }

    public MachineStatus getMachineStatus() {
        return machineStatus;
    }

    public void setMachineStatus(MachineStatus machineStatus) {
        this.machineStatus = machineStatus;
    }
}
