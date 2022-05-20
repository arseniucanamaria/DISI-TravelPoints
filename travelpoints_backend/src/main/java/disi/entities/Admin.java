package disi.entities;


import lombok.AllArgsConstructor;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity

@AllArgsConstructor

@NoArgsConstructor
@Table(name = "admin")
public class Admin extends User implements Serializable {
    @Id
    @GeneratedValue
    private int id;



}
