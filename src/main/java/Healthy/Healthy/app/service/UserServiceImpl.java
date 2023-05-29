package Healthy.Healthy.app.service;

import Healthy.Healthy.app.entity.User;
import Healthy.Healthy.app.enums.Gender;
import Healthy.Healthy.app.repository.UserRepository;
import Healthy.Healthy.app.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signIn(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            System.out.println("User signed in successfully.");
        } else {
            // Sign in failed
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

    @Override
    public void signUp(User user) {
        // Handle sign up logic here, e.g., create a new user

        // Example implementation:
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            // Username already exists
            throw new IllegalArgumentException("Username already exists");
        }

        userRepository.save(user);
        // Perform any necessary actions after sign up
        System.out.println("User signed up successfully.");
    }
    @Override
    public List<String> getGenderOptions() {
        return Arrays.stream(Gender.values())
                .map(Gender::getValue)
                .collect(Collectors.toList());
    }

}
