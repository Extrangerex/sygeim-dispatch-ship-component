package sygeim.dispatch.ship.component;

import jakarta.inject.Singleton;
import sygeim.dispatch.ship.component.commands.ShipCreateCommand;
import sygeim.dispatch.ship.component.commands.ShipUpdateCommand;
import sygeim.dispatch.ship.component.domain.Ship;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Singleton
public class ShipRepositoryImpl implements ShipRepository {

    private final EntityManager entityManager;

    public ShipRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Optional<List<Ship>> findAll() {
        return Optional.ofNullable(entityManager.createQuery("select s from Ship s", Ship.class).getResultList());
    }

    @Override
    public Optional<Ship> findByRegistration(String registration) {
        return Optional.ofNullable(entityManager.find(Ship.class, registration));
    }

    @Override
    public Ship create(ShipCreateCommand shipCreateCommand) {
        Ship ship = new Ship();
        ship.setRegistration(shipCreateCommand.getRegistration());
        ship.setShipType(shipCreateCommand.getShipType());

        entityManager.persist(ship);

        return ship;
    }

    @Override
    public int update(String registration, ShipUpdateCommand shipUpdateCommand) {
        Ship ship = entityManager.find(Ship.class, registration);
        ship.setShipType(shipUpdateCommand.getShipType() != null ? shipUpdateCommand.getShipType() : ship.getShipType());

        entityManager.persist(ship);

        return 1;
    }

    @Override
    public int delete(String registration) {
        Ship ship = entityManager.find(Ship.class, registration);
        ship.setDeleted(true);

        entityManager.persist(ship);

        return 1;
    }
}
