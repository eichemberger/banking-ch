package ar.com.bankist.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Empresas")
@Table(name = "EMPRESAS")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cuit;
    private String razonSocial;
    private LocalDateTime fechaAdhesion;

    @PrePersist
    public void prePersist() {
        this.fechaAdhesion = LocalDateTime.now();
    }

}
