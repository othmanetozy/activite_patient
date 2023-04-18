package ma.emsi.jpaap__2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity

public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)     //creation une entity jpa
    private Long id;
    @Column(length = 40)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    private boolean malade;
    private int score;

}
