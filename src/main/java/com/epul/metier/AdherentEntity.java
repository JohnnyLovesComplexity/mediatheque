package com.epul.metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by christian on 20/02/2017.
 */
@Entity
@Table(name = "adherent", schema = "baseoeuvre", catalog = "")
public class AdherentEntity {
    private int idAdherent;
    private String nomAdherent;
    private String prenomAdherent;
    private String villeAdherent;
    private Collection<EmpruntEntity> empruntsByIdAdherent;
    private Collection<ReservationEntity> reservationsByIdAdherent;

    @Id
    @Column(name = "id_adherent", nullable = false, insertable = false, updatable = false)
    public int getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(Integer idAdherent) {
        this.idAdherent = idAdherent;
    }

    public void setIdAdherent(int idAdherent) {
        this.idAdherent = idAdherent;
    }

    @Basic
    @Column(name = "nom_adherent", nullable = false, length = 100)
    public String getNomAdherent() {
        return nomAdherent;
    }

    public void setNomAdherent(String nomAdherent) {
        this.nomAdherent = nomAdherent;
    }

    @Basic
    @Column(name = "prenom_adherent", nullable = true, length = 100)
    public String getPrenomAdherent() {
        return prenomAdherent;
    }

    public void setPrenomAdherent(String prenomAdherent) {
        this.prenomAdherent = prenomAdherent;
    }

    @Basic
    @Column(name = "ville_adherent", nullable = true, length = 100)
    public String getVilleAdherent() {
        return villeAdherent;
    }

    public void setVilleAdherent(String villeAdherent) {
        this.villeAdherent = villeAdherent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdherentEntity that = (AdherentEntity) o;

        if (idAdherent != that.idAdherent) return false;
        if (nomAdherent != null ? !nomAdherent.equals(that.nomAdherent) : that.nomAdherent != null) return false;
        if (prenomAdherent != null ? !prenomAdherent.equals(that.prenomAdherent) : that.prenomAdherent != null)
            return false;
        if (villeAdherent != null ? !villeAdherent.equals(that.villeAdherent) : that.villeAdherent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAdherent;
        result = 31 * result + (nomAdherent != null ? nomAdherent.hashCode() : 0);
        result = 31 * result + (prenomAdherent != null ? prenomAdherent.hashCode() : 0);
        result = 31 * result + (villeAdherent != null ? villeAdherent.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "adherentByIdAdherent")
    public Collection<EmpruntEntity> getEmpruntsByIdAdherent() {
        return empruntsByIdAdherent;
    }

    public void setEmpruntsByIdAdherent(Collection<EmpruntEntity> empruntsByIdAdherent) {
        this.empruntsByIdAdherent = empruntsByIdAdherent;
    }

    @OneToMany(mappedBy = "adherentByIdAdherent")
    public Collection<ReservationEntity> getReservationsByIdAdherent() {
        return reservationsByIdAdherent;
    }

    public void setReservationsByIdAdherent(Collection<ReservationEntity> reservationsByIdAdherent) {
        this.reservationsByIdAdherent = reservationsByIdAdherent;
    }
}
