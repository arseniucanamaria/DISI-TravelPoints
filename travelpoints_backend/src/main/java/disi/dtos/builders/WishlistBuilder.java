package disi.dtos.builders;

import disi.controllers.DeviceNotFound;
import disi.dtos.UserDTO;
import disi.dtos.WishlistDTO;
import disi.entities.User;
import disi.entities.Wishlist;
import disi.repositories.ObiectiveRepository;
import disi.repositories.UserRepository;
import disi.repositories.WishlistRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class WishlistBuilder {
    private static
    UserRepository userRepository;
    private static
    ObiectiveRepository obiectiveRepository;

    public WishlistBuilder( UserRepository userRepository,ObiectiveRepository obiectiveRepository){
        this.obiectiveRepository= obiectiveRepository;
        this.userRepository= userRepository;
    }
    public static WishlistDTO toWishlistDTO(Wishlist wishlist) {
        return new WishlistDTO(wishlist.getId(),wishlist.getUtilizator().getId(),wishlist.getObiective().getId());
    }

    public static Wishlist toEntity(WishlistDTO wishlistDTO) {
        return new Wishlist(wishlistDTO.getId(),
                obiectiveRepository.findById(wishlistDTO.getId_obiectiv()).orElseThrow(()-> new DeviceNotFound(wishlistDTO.getId_obiectiv())),
                userRepository.findById(wishlistDTO.getId_user()).orElseThrow(()-> new DeviceNotFound(wishlistDTO.getId_user())));

    }
}
