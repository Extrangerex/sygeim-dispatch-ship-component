package sygeim.dispatch.ship.component.commands;

import io.micronaut.core.annotation.Introspected;
import sygeim.dispatch.ship.component.domain.ShipType;

import javax.validation.constraints.NotNull;

@Introspected
public class ShipCreateCommand {
    @NotNull
    private String ship;

    @NotNull
    private ShipType shipType;

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }
}

