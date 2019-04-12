package com.epul.metier;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "status", schema = "baseoeuvre", catalog = "")
public class StatusEntity {
    private Integer id;
    private String name;
    private Collection<EmpruntEntity> empruntsById;

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusEntity that = (StatusEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "statusByIdStatut")
    public Collection<EmpruntEntity> getEmpruntsById() {
        return empruntsById;
    }

    public void setEmpruntsById(Collection<EmpruntEntity> empruntsById) {
        this.empruntsById = empruntsById;
    }
}
