package sygeim.dispatch.ship.component;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import jakarta.inject.Singleton;
import sygeim.dispatch.ship.component.commands.ShipTypeCreateCommand;
import sygeim.dispatch.ship.component.commands.ShipTypeUpdateCommand;
import sygeim.dispatch.ship.component.domain.ShipType;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Singleton
public class ShipTypeRepositoryImpl implements ShipTypeRepository {
    private final EntityManager entityManager;

    public ShipTypeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public Optional<List<ShipType>> findAll() {
        return Optional.ofNullable(entityManager.createQuery("SELECT n from ShipType n", ShipType.class).getResultList());
    }

    @Override
    @ReadOnly
    public Optional<ShipType> findById(Long id) {
        return Optional.ofNullable(entityManager.find(ShipType.class, id));
    }

    @Override
    @TransactionalAdvice
    public ShipType create(ShipTypeCreateCommand shipTypeCreateCommand) {
        ShipType shipType = new ShipType();

        shipType.setName(shipTypeCreateCommand.getName());
        shipType.setDeleted(false);

        entityManager.persist(shipType);

        return shipType;
    }

    @Override
    public int update(Long id, ShipTypeUpdateCommand shipTypeUpdateCommand) {
        ShipType shipType = entityManager.find(ShipType.class, id);

        shipType.setName(shipTypeUpdateCommand.getName() == null ? shipType.getName() : shipTypeUpdateCommand.getName());

        entityManager.persist(shipType);

        return 1;
    }

    @Override
    public int delete(Long id) {
        ShipType shipType = entityManager.find(ShipType.class, id);

        shipType.setDeleted(true);

        entityManager.persist(shipType);

        return 1;
    }
}
