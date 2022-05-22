package sygeim.dispatch.ship.component.commands;

import io.micronaut.core.annotation.Introspected;
import sygeim.dispatch.ship.component.domain.ShipType;

import javax.validation.constraints.NotNull;

@Introspected
public class ShipCreateCommand {
    @NotNull
    private String registration;

    @NotNull
    private ShipType shipType;

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }
}

