package com.my.fim;

import com.my.fim.model.Role;
import com.my.fim.model.User;
import com.my.fim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FimAppApplication implements CommandLineRunner {

    @Value("${admin.firstname}")
    public String ADMIN_FIRSTNAME;
    @Value("${admin.lastname}")
    public String ADMIN_LASTNAME;
    @Value("${admin.email}")
    public String ADMIN_EMAIL;
    @Value("${admin.password}")
    public String ADMIN_PASSWORD;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(FimAppApplication.class, args);
    }

    public void run(String... arg) {
        User adminAccount = userRepository.findByRole(Role.ADMIN);
        if (null == adminAccount) {
            User user = new User();

            user.setFirstname(ADMIN_FIRSTNAME);
            user.setLastname(ADMIN_LASTNAME);
            user.setEmail(ADMIN_EMAIL);
            user.setPassword(new BCryptPasswordEncoder().encode(ADMIN_PASSWORD));
            user.setRole(Role.ADMIN);

            userRepository.save(user);
        }
    }

}
