package de.toxic2302.inventorymanagementsystem.core.modules.user.service;

import de.toxic2302.inventorymanagementsystem.base.authentication.AuthenticationService;
import de.toxic2302.inventorymanagementsystem.core.modules.user.entity.User;
import de.toxic2302.inventorymanagementsystem.core.modules.user.repository.UserRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    // ---- Globales ----
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

    // ---- Constructor ----
    public UserService(UserRepository userRepository, AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
    }

    // ---- Functions ----
    /*public void saveOrUpdate(OAuth2User oAuth2User) {
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
    }*/
    public User getCurrentUser() {
        return findByUsername(authenticationService.getUserName());
    }

    public User findByUsername(String username) {
        final Optional<User> existingUser = userRepository.findByUsername(username);

        return existingUser.orElseGet(() -> save(createUser()));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    private User createUser() {
        return User.builder()
            .username(authenticationService.getUserName())
            .active(true)
            .email(authenticationService.getEmail())
            .firstName(authenticationService.getFirstName())
            .lastName(authenticationService.getLastName())
            .build();
    }
}
