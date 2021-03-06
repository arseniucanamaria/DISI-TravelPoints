package disi.services;

import disi.controllers.ResourceNotFoundException;
import disi.dtos.ObiectiveDTO;
import disi.dtos.builders.ObiectiveBuilder;
import disi.entities.Obiective;
import disi.entities.User;
import disi.repositories.ObiectiveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObiectiveService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObiectiveService.class);
    private final ObiectiveRepository obiectiveRepository;

    @Autowired
    public ObiectiveService(ObiectiveRepository obiectiveRepository) {
        this.obiectiveRepository = obiectiveRepository;
    }

    public List<ObiectiveDTO> findObiective() {
        List<Obiective> obiectiveList = obiectiveRepository.findAll();
        return obiectiveList.stream()
                .map(ObiectiveBuilder::toObiectiveDTO)
                .collect(Collectors.toList());
    }

    public ObiectiveDTO findObiectivById(int id) {
        Optional<Obiective> prosumerOptional = obiectiveRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Obiectiv with id {} was not found in db", id);
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + id);
        }
        return ObiectiveBuilder.toObiectiveDTO(prosumerOptional.get());
    }

    public int insert(ObiectiveDTO obiectiveDTO) {
        Obiective obiective = ObiectiveBuilder.toEntity(obiectiveDTO);
        obiective = obiectiveRepository.save(obiective);
        LOGGER.debug("Obiectiv with id {} was inserted in db", obiective.getId());
        return obiective.getId();
    }

    public ObiectiveDTO findObiectivByLocation(String locatie) {
        Optional<Obiective> prosumerOptional = obiectiveRepository.findByLocation(locatie);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Obiectiv from location {} was not found in db", locatie);
        }
        return ObiectiveBuilder.toObiectiveDTO(prosumerOptional.get());
    }

    public ObiectiveDTO findObiectivByCategory(String categorie) {
        Optional<Obiective> prosumerOptional = obiectiveRepository.findByCategory(categorie);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Obiectiv with name {} was not found in db", categorie);
        }
        return ObiectiveBuilder.toObiectiveDTO(prosumerOptional.get());
    }

    public ObiectiveDTO vizualizareText(int id) {
        return ObiectiveBuilder.toObiectiveDTO(obiectiveRepository.findById(id).get());
    }
    //delete objective
    public int delete(ObiectiveDTO obiectiveDTO) {
        obiectiveRepository.deleteById(obiectiveDTO.getId());
        LOGGER.debug("Client with id {} was deleted in db", obiectiveDTO.getId());
        return obiectiveDTO.getId();
    }
    public ObiectiveDTO updateObiective (int id, ObiectiveDTO obiectiveDTO){


        Optional<Obiective> obiectiveOptional = obiectiveRepository.findById(id);
        if (!obiectiveOptional.isPresent()) {
            LOGGER.error("Obiectiv with id {} was not found in db", id);
            throw new ResourceNotFoundException(Obiective.class.getSimpleName() + " with id: " + id + " was not found!");
        }

        Obiective obiective = obiectiveOptional.get();
        obiective.setNume_obiectiv(obiectiveDTO.getNume_obiectiv());
        obiective.setDescriere_text(obiectiveDTO.getDescriere_text());
        obiective.setDescriere_audio(obiectiveDTO.getDescriere_audio());
        obiective.setPret_intrare(obiectiveDTO.getPret_intrare());
        obiective.setLocatie(obiectiveDTO.getLocatie());
        obiective.setCategorie(obiectiveDTO.getCategorie());

        obiectiveRepository.save(obiective);

        return ObiectiveBuilder.toObiectiveDTO(obiective);

    }


}

