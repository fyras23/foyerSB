package com.esprit.foyer.services;

import com.esprit.foyer.Repo.EtudiantRepo;
import com.esprit.foyer.Repo.ReservationRepo;
import com.esprit.foyer.dto.ReservationDTO;
import com.esprit.foyer.entities.Etudiant;
import com.esprit.foyer.entities.Reservation;
import com.esprit.foyer.mappers.ReservationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    private final ReservationRepo reservationRepository;
    private final ReservationMapper reservationMapper;
    private final EtudiantRepo etudiantRepository;


    @Override
    public ReservationDTO assignEtudiantToReservation(String idReservation, Long idEtudiant) {
        Reservation reservation = reservationRepository.findById(idReservation).orElseThrow();
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElseThrow();

        reservation.getEtudiants().add(etudiant);
        Reservation saved = reservationRepository.save(reservation);

        return reservationMapper.toDto(saved);
    }


    @Override
    public ReservationDTO addOrUpdateReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        Reservation saved = reservationRepository.save(reservation);
        return reservationMapper.toDto(saved);
    }

    @Override
    public ReservationDTO findReservationById(String idReservation) {
        Reservation reservation = reservationRepository.findById(idReservation).orElseThrow();
        return reservationMapper.toDto(reservation);
    }

    @Override
    public List<ReservationDTO> findAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toDto)
                .collect(Collectors.toList());
    }



    @Override
    public void deleteReservationById(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}
