package sygeim.dispatch.ship.component.commands;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotNull;

@Introspected
public class ShipCreateCommand {
    @NotNull
    String name;
}

