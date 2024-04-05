package de.toxic2302.inventorymanagementsystem.core.modules.user.service;

import de.toxic2302.inventorymanagementsystem.core.modules.user.entity.User;
import de.toxic2302.inventorymanagementsystem.core.modules.user.repository.UserRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    // ---- Globales ----
    private final UserRepository userRepository;

    // ---- Constructor ----
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ---- Functions ----
    public void saveOrUpdate(OAuth2User oAuth2User) {
        final String sid = (String) oAuth2User.getAttributes().get("sid");
        User userByOauthId = userRepository.findUserByOauthId(sid);

        if (userByOauthId != null) {
            userByOauthId.setName(((String) oAuth2User.getAttributes().get("name")));
            userByOauthId.setEmail(((String) oAuth2User.getAttributes().get("email")));
            userByOauthId.setPictureUrl(((String) oAuth2User.getAttributes().get("picture")));
        } else {
            userByOauthId = new User();
            userByOauthId.setOauthId(sid);
            userByOauthId.setName(((String) oAuth2User.getAttributes().get("name")));
            userByOauthId.setEmail(((String) oAuth2User.getAttributes().get("email")));
            userByOauthId.setPictureUrl(((String) oAuth2User.getAttributes().get("picture")));
        }

        userRepository.save(userByOauthId);
    }
}
