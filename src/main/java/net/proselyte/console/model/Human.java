package net.proselyte.console.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "humans")
@Getter
@Setter
@ToString
public class Human extends BaseEntity{
    @Column(name = "name")
    private  String name;
    @Column(name = "address")
    private String address;
}
