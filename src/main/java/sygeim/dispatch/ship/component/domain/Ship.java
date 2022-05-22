package sygeim.dispatch.ship.component.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ship {
    @Id
    private String registration;

    @OneToOne
    private ShipType shipType;

}
