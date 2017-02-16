package com.nizar.openweb.test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nizar.openweb.WebApplication;
import com.nizar.openweb.model.Boat;
import com.nizar.openweb.model.User;
import com.nizar.openweb.repository.BoatRepository;
import com.nizar.openweb.repository.UserRepository;

@RunWith( SpringJUnit4ClassRunner.class )
@WebAppConfiguration
@ContextConfiguration( classes = WebApplication.class )
public class TestController {

    @Autowired
    UserRepository userRepository;

    BoatRepository boatRepository;
    // EmbeddedDatabase db;

    /*
     * @Before public void setUp() throws Exception { // db = new
     * EmbeddedDatabaseBuilder().addDefaultScripts().build(); db = new
     * EmbeddedDatabaseBuilder() .setType( EmbeddedDatabaseType.HSQL )
     * .addScript( "resources/beforeTestRun.sql" ) .build(); }
     * 
     * @After public void tearDown() throws Exception { }
     */
    @Test
    public final void testRegistrationUserBindingResultModel() {
        User user = new User();
        String username = "test";
        String password = "test2";
        String confirmPassword = "test2";

        user.setUsername( username );
        user.setPassword( password );
        // user.setRoles( new HashSet<>( roleRepository.findAll() ) );

        if ( userRepository.save( user ) != null ) {
            userRepository.save( user );
            System.out.println( "Enregistré en base de données" );
        } else {
            fail( "Non inséré" );
        }

    }

    @Test
    public final void testLoginUserBindingResultModel() {
        fail( "Pas encore implémenté" ); // TODO
    }

    @Test
    public final void testAddBoatBoatBindingResultStringModel() {
        String boatname = "testBoat";
        Boat boat = new Boat();
        boat.setBoatname( boatname );
        boatRepository.save( boat );
        fail( "Pas encore implémenté" );
    }

}
