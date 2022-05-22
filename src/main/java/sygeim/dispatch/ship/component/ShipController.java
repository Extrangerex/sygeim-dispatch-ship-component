package sygeim.dispatch.ship.component;

import io.micronaut.http.annotation.*;
import sygeim.dispatch.ship.component.commands.ShipCreateCommand;
import sygeim.dispatch.ship.component.commands.ShipUpdateCommand;
import sygeim.dispatch.ship.component.domain.Ship;

import java.util.Optional;

@Controller("/ship")
public class ShipController {
    private final ShipRepositoryImpl shipRepository;

    public ShipController(ShipRepositoryImpl shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Get("/{registration}")
    public Optional<Ship> getShip(String registration) {
        return shipRepository.findByRegistration(registration);
    }

    @Post("/")
    public Ship createShip(@Body ShipCreateCommand ship) {
        return shipRepository.create(ship);
    }

    @Put("/{registration}")
    public int updateShip(String registration, @Body ShipUpdateCommand ship) {
        return shipRepository.update(registration, ship);
    }

    @Delete("/{registration}")
    public int deleteShip(String registration) {
        return shipRepository.delete(registration);
    }
}