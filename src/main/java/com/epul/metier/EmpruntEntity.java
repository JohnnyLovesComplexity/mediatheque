package com.epul.metier;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "emprunt", schema = "baseoeuvre", catalog = "")
@IdClass(EmpruntEntityPK.class)
public class EmpruntEntity {
    private Integer idOeuvrepret;
    private Integer idAdherent;
    private Date dateReservation;
    private String statut;
    private OeuvrepretEntity oeuvrepretByIdOeuvrepret;
    private AdherentEntity adherentByIdAdherent;

    @Id
    @Column(name = "id_oeuvrepret", nullable = false, insertable = false, updatable = false)
    public Integer getIdOeuvrepret() {
        return idOeuvrepret;
    }

    public void setIdOeuvrepret(Integer idOeuvrepret) {
        this.idOeuvrepret = idOeuvrepret;
    }

    @Id
    @Column(name = "id_adherent", nullable = false, insertable = false, updatable = false)
    public Integer getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(Integer idAdherent) {
        this.idAdherent = idAdherent;
    }

    @Basic
    @Column(name = "date_reservation", nullable = false)
    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Basic
    @Column(name = "statut", nullable = false, length = 20)
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpruntEntity that = (EmpruntEntity) o;
        return Objects.equals(idOeuvrepret, that.idOeuvrepret) &&
                Objects.equals(idAdherent, that.idAdherent) &&
                Objects.equals(dateReservation, that.dateReservation) &&
                Objects.equals(statut, that.statut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOeuvrepret, idAdherent, dateReservation, statut);
    }

    @ManyToOne
    @JoinColumn(name = "id_oeuvrepret", referencedColumnName = "id_oeuvrepret", nullable = false)
    public OeuvrepretEntity getOeuvrepretByIdOeuvrepret() {
        return oeuvrepretByIdOeuvrepret;
    }

    public void setOeuvrepretByIdOeuvrepret(OeuvrepretEntity oeuvrepretByIdOeuvrepret) {
        this.oeuvrepretByIdOeuvrepret = oeuvrepretByIdOeuvrepret;
    }

    @ManyToOne
    @JoinColumn(name = "id_adherent", referencedColumnName = "id_adherent", nullable = false)
    public AdherentEntity getAdherentByIdAdherent() {
        return adherentByIdAdherent;
    }

    public void setAdherentByIdAdherent(AdherentEntity adherentByIdAdherent) {
        this.adherentByIdAdherent = adherentByIdAdherent;
    }
}