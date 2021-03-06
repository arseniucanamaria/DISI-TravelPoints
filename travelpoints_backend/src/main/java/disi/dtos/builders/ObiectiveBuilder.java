package disi.dtos.builders;


import disi.dtos.ObiectiveDTO;
import disi.dtos.UserDTO;
import disi.entities.Obiective;
import disi.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ObiectiveBuilder {

    public ObiectiveBuilder() {
    }


    public static ObiectiveDTO toObiectiveDTO(Obiective obiective) {
        return new ObiectiveDTO(obiective.getId(),obiective.getNume_obiectiv(), obiective.getDescriere_text(), obiective.getDescriere_audio(),obiective.getPret_intrare(),obiective.getLocatie(),obiective.getCategorie());
    }

    public static Obiective toEntity(ObiectiveDTO obiectiveDTO) {
        return new Obiective(
                obiectiveDTO.getNume_obiectiv(),
                obiectiveDTO.getDescriere_text(),
                obiectiveDTO.getDescriere_audio(),
                obiectiveDTO.getPret_intrare(),
                obiectiveDTO.getLocatie(),
                obiectiveDTO.getCategorie());
    }
}
