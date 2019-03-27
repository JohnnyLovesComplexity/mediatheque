package com.epul.metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by christian on 20/02/2017.
 */
@Entity
@Table(name = "oeuvrevente", schema = "baseoeuvre", catalog = "")
public class OeuvreventeEntity extends OeuvreEntity {
    private int idOeuvrevente;
    private String titreOeuvrevente;
    private String etatOeuvrevente;
    private double prixOeuvrevente;
//    private ProprietaireEntity proprietaire;
    private Integer idProprietaire;
    private ProprietaireEntity proprietaireByIdProprietaire;
    private Collection<ReservationEntity> reservationsByIdOeuvrevente;

    @Id
    @Column(name = "id_oeuvrevente", nullable = false, insertable = false, updatable = false)
    public int getIdOeuvrevente() {
        return idOeuvrevente;
    }

    public void setIdOeuvrevente(Integer idOeuvrevente) {
        this.idOeuvrevente = idOeuvrevente;
    }

    public void setIdOeuvrevente(int idOeuvrevente) {
        this.idOeuvrevente = idOeuvrevente;
    }

    @Basic
    @Column(name = "titre_oeuvrevente", nullable = false, length = 200)
    public String getTitreOeuvrevente() {
        return titreOeuvrevente;
    }

    public void setTitreOeuvrevente(String titreOeuvrevente) {
        this.titreOeuvrevente = titreOeuvrevente;
    }

    @Basic
    @Column(name = "etat_oeuvrevente", nullable = false, length = 1)
    public String getEtatOeuvrevente() {
        return etatOeuvrevente;
    }

    public void setEtatOeuvrevente(String etatOeuvrevente) {
        this.etatOeuvrevente = etatOeuvrevente;
    }

    @Basic
    @Column(name = "prix_oeuvrevente", nullable = false, precision = 0)
    public double getPrixOeuvrevente() {
        return prixOeuvrevente;
    }

    public void setPrixOeuvrevente(Double prixOeuvrevente) {
        this.prixOeuvrevente = prixOeuvrevente;
    }

    public void setPrixOeuvrevente(double prixOeuvrevente) {
        this.prixOeuvrevente = prixOeuvrevente;
    }

//    @ManyToOne
//    @JoinColumn(name = "id_proprietaire", referencedColumnName="id_proprietaire")
//    public ProprietaireEntity getProprietaire() { return proprietaire; }
//
//    public void setProprietaire(ProprietaireEntity proprietaire) {
//        this.proprietaire = proprietaire;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OeuvreventeEntity that = (OeuvreventeEntity) o;

        if (idOeuvrevente != that.idOeuvrevente) return false;
        if (Double.compare(that.prixOeuvrevente, prixOeuvrevente) != 0) return false;
        if (titreOeuvrevente != null ? !titreOeuvrevente.equals(that.titreOeuvrevente) : that.titreOeuvrevente != null)
            return false;
        if (etatOeuvrevente != null ? !etatOeuvrevente.equals(that.etatOeuvrevente) : that.etatOeuvrevente != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idOeuvrevente;
        result = 31 * result + (titreOeuvrevente != null ? titreOeuvrevente.hashCode() : 0);
        result = 31 * result + (etatOeuvrevente != null ? etatOeuvrevente.hashCode() : 0);
        temp = Double.doubleToLongBits(prixOeuvrevente);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Basic
    @Column(name = "id_proprietaire", nullable = true, insertable = false, updatable = false)
    public Integer getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Integer idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    @ManyToOne
    @JoinColumn(name = "id_proprietaire", referencedColumnName = "id_proprietaire")
    public ProprietaireEntity getProprietaireByIdProprietaire() {
        return proprietaireByIdProprietaire;
    }

    public void setProprietaireByIdProprietaire(ProprietaireEntity proprietaireByIdProprietaire) {
        this.proprietaireByIdProprietaire = proprietaireByIdProprietaire;
    }

    @OneToMany(mappedBy = "oeuvreventeByIdOeuvrevente")
    public Collection<ReservationEntity> getReservationsByIdOeuvrevente() {
        return reservationsByIdOeuvrevente;
    }

    public void setReservationsByIdOeuvrevente(Collection<ReservationEntity> reservationsByIdOeuvrevente) {
        this.reservationsByIdOeuvrevente = reservationsByIdOeuvrevente;
    }
    
    @Override
    public String toString() {
        return "OeuvreventeEntity{" +
                "idOeuvrevente=" + idOeuvrevente +
                ", titreOeuvrevente='" + titreOeuvrevente + '\'' +
                ", etatOeuvrevente='" + etatOeuvrevente + '\'' +
                ", prixOeuvrevente=" + prixOeuvrevente +
                '}';
    }
}
