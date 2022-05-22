package sygeim.dispatch.ship.component.commands;

import io.micronaut.core.annotation.Introspected;
import sygeim.dispatch.ship.component.domain.ShipType;

@Introspected
public class ShipUpdateCommand {

    private ShipType shipType;

    private Boolean deleted;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }
}
