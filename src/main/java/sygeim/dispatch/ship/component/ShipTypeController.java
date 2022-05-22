package sygeim.dispatch.ship.component;

import io.micronaut.http.annotation.*;
import sygeim.dispatch.ship.component.commands.ShipTypeCreateCommand;
import sygeim.dispatch.ship.component.commands.ShipTypeUpdateCommand;
import sygeim.dispatch.ship.component.domain.ShipType;

import java.util.Optional;

@Controller("/shipType")
public class ShipTypeController {

    private final ShipTypeRepositoryImpl shipTypeRepository;

    public ShipTypeController(ShipTypeRepositoryImpl shipTypeRepository) {
        this.shipTypeRepository = shipTypeRepository;
    }

    @Get("/{id}")
    public Optional<ShipType> getById(Long id) {
        return shipTypeRepository.findById(id);
    }

    @Post("/")
    public ShipType create(ShipTypeCreateCommand shipType) {
        return shipTypeRepository.create(shipType);
    }

    @Put("/{id}")
    public int update(Long id, ShipTypeUpdateCommand shipType) {
        return shipTypeRepository.update(id, shipType);
    }

    @Delete("/{id}")
    public int delete(Long id) {
        return shipTypeRepository.delete(id);
    }
}