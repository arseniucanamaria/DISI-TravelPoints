package disi.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor

@NoArgsConstructor
@Table(name="Vizita")
public class Vizita implements Serializable {


    @Id
    @GeneratedValue
    private int id;

    @Column(name = "ora", nullable = false)
    private String ora;

    @Column(name = "data", nullable = false)
    private String data;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_obiectiv", nullable = false)
    private Obiective  obiective;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User utilizator;


}
