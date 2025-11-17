package com.esprit.foyer.services;

import com.esprit.foyer.Repo.ChambreRepo;
import com.esprit.foyer.Repo.ReservationRepo;
import com.esprit.foyer.dto.ChambreDTO;
import com.esprit.foyer.dto.ChambreReservationDTO;
import com.esprit.foyer.dto.ReservationDTO;
import com.esprit.foyer.entities.Bloc;
import com.esprit.foyer.entities.Chambre;
import com.esprit.foyer.entities.Reservation;
import com.esprit.foyer.entities.TypeChambre;
import com.esprit.foyer.mappers.ChambreMapper;
import com.esprit.foyer.mappers.ChambreReservationMapper;
import com.esprit.foyer.mappers.ReservationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService {

    private final ChambreRepo chambreRepo;
    private final ChambreMapper chambreMapper;
    private final ChambreReservationMapper chambreReservationMapper;
    private final ReservationRepo reservationRepo;
    private final ReservationMapper reservationMapper;

    @Override
    public ChambreDTO addOrUpdateChambre(ChambreDTO chambreDTO) {
        Chambre chambre = chambreMapper.toEntity(chambreDTO);
        Chambre saved = chambreRepo.save(chambre);
        return chambreMapper.toDto(saved);
    }

    @Override
    public ChambreDTO findChambreById(Long idChambre) {
        Chambre chambre = chambreRepo.findById(idChambre).orElseThrow();
        return chambreMapper.toDto(chambre);
    }

    @Override
    public List<ChambreDTO> findAllChambres() {
        return chambreRepo.findAll()
                .stream()
                .map(chambreMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteChambreById(Long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

    @Override
    public ChambreReservationDTO addChambreWithReservation(ChambreReservationDTO CRdto) {
        Chambre chambre = chambreReservationMapper.toEntity(CRdto);

        // Save reservations
        Set<Reservation> reservations = new HashSet<>();
        if (CRdto.getReservations() != null) {
            for (ReservationDTO resDto : CRdto.getReservations()) {
                Reservation res = reservationMapper.toEntity(resDto);
                res = reservationRepo.save(res);
                reservations.add(res);
            }
        }

        // Link reservations to Chambre
        chambre.setReservation(reservations);

        // Save Chambre
        chambre = chambreRepo.save(chambre);

        // Return DTO
        return chambreReservationMapper.toDto(chambre);
    }

    @Override
    public ChambreReservationDTO assignReservation(Long chambreId, String reservationId) {
        // 1. Load Chambre and Reservation
        Chambre chambre = chambreRepo.findById(chambreId)
                .orElseThrow();
        Reservation reservation = reservationRepo.findById(reservationId)
                .orElseThrow();

        // 2. Add reservation to Chambre
        Set<Reservation> reservations = chambre.getReservation();
        if (reservations == null) {
            reservations = new HashSet<>();
        }
        reservations.add(reservation);
        chambre.setReservation(reservations);

        // 3. Save Chambre
        chambre = chambreRepo.save(chambre);

        // 4. Return DTO
        return chambreReservationMapper.toDto(chambre);
    }

    @Override
    public ChambreReservationDTO cancelReservation(Long chambreId) {
        Chambre chambre = chambreRepo.findById(chambreId)
                .orElseThrow(() -> new IllegalArgumentException("Chambre not found"));

        // 2. Remove all reservations (or you can remove a specific one if needed)
        chambre.setReservation(new HashSet<>());

        // 3. Save Chambre
        chambre = chambreRepo.save(chambre);

        // 4. Return DTO
        return chambreReservationMapper.toDto(chambre);
    }
}
