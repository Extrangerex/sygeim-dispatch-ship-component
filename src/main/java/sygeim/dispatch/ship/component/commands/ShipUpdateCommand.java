package sygeim.dispatch.ship.component.commands;

import io.micronaut.core.annotation.Introspected;
import sygeim.dispatch.ship.component.domain.ShipType;

@Introspected
public class ShipUpdateCommand {

    private ShipType shipType;

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }
}
