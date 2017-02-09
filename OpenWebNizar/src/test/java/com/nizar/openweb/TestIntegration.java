package com.nizar.openweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nizar.openweb.model.User;
import com.nizar.openweb.repository.BoatRepository;
import com.nizar.openweb.repository.UserRepository;

@SuppressWarnings( "deprecation" )
@RunWith( SpringJUnit4ClassRunner.class ) // 1
@SpringApplicationConfiguration( classes = WebApplication.class )
@WebAppConfiguration // 3
@SqlGroup( {
        @Sql( executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql" ) } )
@IntegrationTest( "server.port:0" )

public class TestIntegration {

    @Autowired
    private BoatRepository boatRepository;
    private UserRepository userRepository;

    String                 username;
    String                 password;
    String                 confirmPassword;

    @Value( "${local.server.port}" ) // 6
    int                    port;

    @Test
    public void testRegistrationModel() {
        User user = new User();

        username = new String( "Mickey" );
        password = new String( "Minnie" );
        confirmPassword = new String( "Minnie" );

        userRepository.save( user );
        userRepository.findAll();
    }

}
