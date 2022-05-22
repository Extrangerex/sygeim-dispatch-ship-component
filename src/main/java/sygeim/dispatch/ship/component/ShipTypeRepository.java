package sygeim.dispatch.ship.component;

import sygeim.dispatch.ship.component.commands.ShipTypeCreateCommand;
import sygeim.dispatch.ship.component.commands.ShipTypeUpdateCommand;
import sygeim.dispatch.ship.component.domain.ShipType;

import java.util.List;
import java.util.Optional;

public interface ShipTypeRepository {
    Optional<List<ShipType>> findAll();

    Optional<ShipType> findById();

    ShipType create(ShipTypeCreateCommand shipTypeCreateCommand);

    int update(Long id, ShipTypeUpdateCommand shipTypeUpdateCommand);

    int delete(Long id);
}
