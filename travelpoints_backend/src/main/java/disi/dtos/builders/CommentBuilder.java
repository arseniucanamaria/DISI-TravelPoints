package disi.dtos.builders;


import disi.controllers.DeviceNotFound;
import disi.controllers.ResourceNotFoundException;
import disi.dtos.CommentDTO;
import disi.entities.Comentariu;
import disi.repositories.ObiectiveRepository;
import disi.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CommentBuilder {
    private static
    ObiectiveRepository obiectiveRepository;
    private static
    UserRepository userRepository;


    private CommentBuilder(ObiectiveRepository obiectiveRepository,UserRepository userRepository) {
        this.obiectiveRepository= obiectiveRepository;
        this.userRepository= userRepository;

    }


    public static CommentDTO toCommentDTO(Comentariu comentariu) {
        return new CommentDTO(comentariu.getId(),comentariu.getData(), comentariu.getDescriere(), comentariu.getOra(),comentariu.getObiective().getId(),comentariu.getUtilizator().getId());
    }
    public static CommentDTO toCommentDTO1(Comentariu comentariu) {
        return new CommentDTO(comentariu.getId(),comentariu.getData(), comentariu.getDescriere(), comentariu.getOra(),comentariu.getObiective().getNume_obiectiv(),comentariu.getUtilizator().getUsername());
    }

    public static Comentariu toEntity(CommentDTO commentDTO) {
        return new Comentariu(
               commentDTO.getId(),
               commentDTO.getData(),
               commentDTO.getDescriere(),
               commentDTO.getOra(),
                obiectiveRepository.findById(commentDTO.getId_obiectiv()).orElseThrow(()-> new DeviceNotFound(commentDTO.getId_obiectiv())),
                userRepository.findById(commentDTO.getId_user()).orElseThrow(()-> new DeviceNotFound(commentDTO.getId_user())));


    }



}

