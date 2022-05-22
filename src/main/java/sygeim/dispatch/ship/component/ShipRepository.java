package sygeim.dispatch.ship.component;


import sygeim.dispatch.ship.component.commands.ShipCreateCommand;
import sygeim.dispatch.ship.component.commands.ShipTypeCreateCommand;
import sygeim.dispatch.ship.component.commands.ShipTypeUpdateCommand;
import sygeim.dispatch.ship.component.commands.ShipUpdateCommand;
import sygeim.dispatch.ship.component.domain.Ship;
import sygeim.dispatch.ship.component.domain.ShipType;

import java.util.List;
import java.util.Optional;

public interface ShipRepository {

    Optional<List<Ship>> findAll();

    Optional<Ship> findByRegistration(String registration);

    Ship create(ShipCreateCommand shipCreateCommand);

    int update(String registration, ShipUpdateCommand shipUpdateCommand);

    int delete(String registration);
}
