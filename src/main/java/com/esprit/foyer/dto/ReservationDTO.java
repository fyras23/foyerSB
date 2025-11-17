package com.esprit.foyer.dto;

import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
public class ReservationDTO {
    private String idReservation;
    private Boolean estValide;
    private Date anneeUniversitaire;

    private Set<Long> etudiantIds;

    public String getIdReservation() {
        return idReservation;
    }

    public Boolean getEstValide() {
        return estValide;
    }

    public Date getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public Set<Long> getEtudiantIds() {
        return etudiantIds;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public void setEstValide(Boolean estValide) {
        this.estValide = estValide;
    }

    public void setAnneeUniversitaire(Date anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    public void setEtudiantIds(Set<Long> etudiantIds) {
        this.etudiantIds = etudiantIds;
    }
}
