package com.epul.metier;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EmpruntEntityPK implements Serializable {
    private Integer idOeuvrepret;
    private Integer idAdherent;

    @Column(name = "id_oeuvrepret", nullable = false, insertable = false, updatable = false)
    @Id
    public Integer getIdOeuvrepret() {
        return idOeuvrepret;
    }

    public void setIdOeuvrepret(Integer idOeuvrepret) {
        this.idOeuvrepret = idOeuvrepret;
    }

    @Column(name = "id_adherent", nullable = false, insertable = false, updatable = false)
    @Id
    public Integer getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(Integer idAdherent) {
        this.idAdherent = idAdherent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpruntEntityPK that = (EmpruntEntityPK) o;
        return Objects.equals(idOeuvrepret, that.idOeuvrepret) &&
                Objects.equals(idAdherent, that.idAdherent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOeuvrepret, idAdherent);
    }
}
