package com.fundamentos.nestor.fundamentos.service;

import com.fundamentos.nestor.fundamentos.entity.User;
import com.fundamentos.nestor.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    //Permite hacer un Rollback de todas las transaciones de la base de datos. Si existe un error hara un rollback del error
    public void saveTransactional(List<User> users) {
        users.stream()
                .peek(user -> LOG.info("Usuario insertado : " + user))
                .forEach(userRepository::save);
        //        .forEach(user -> userRepository.save(user));

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public void delete(Long id) {
        userRepository.delete(new User(id));
    }

    public User update(User newUser, Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setBirthDate(newUser.getBirthDate());
                    user.setName(newUser.getName());
                    return userRepository.save(user);
                }).get();
    }
}
