package net.space.service;

import net.space.model.User;

/**
 * Service class for {@link net.space.model.User}
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
