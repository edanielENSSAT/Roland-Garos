package com.rollandgaros.tournementmanager.auth;


import org.assertj.core.util.Lists;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.rollandgaros.tournementmanager.security.ApplicationUserRole.*;

@Repository("fake")

public class FakeApplicationUserService implements  ApplicationUserDAO {
    private final BCryptPasswordEncoder passwordEncoder;

    public FakeApplicationUserService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }
    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(

                        "anasmith",
                        passwordEncoder.encode("password"),
                        PLAYER.getGrantedAuthorities(),

                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(

                        "jennylawts",
                        passwordEncoder.encode("password123"),
                        ADMIN.getGrantedAuthorities(),

                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(

                        "laurenttail",
                        passwordEncoder.encode("password456"),
                        MATCH.getGrantedAuthorities(),

                        true,
                        true,
                        true,
                        true
                )

        );
        return applicationUsers;
    }
}

