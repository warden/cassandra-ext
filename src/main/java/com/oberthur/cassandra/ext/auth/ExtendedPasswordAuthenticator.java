package com.oberthur.cassandra.ext.auth;

import org.apache.cassandra.auth.AuthenticatedUser;
import org.apache.cassandra.auth.PasswordAuthenticator;
import org.apache.cassandra.exceptions.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * ExtendedPasswordAuthenticator is an extension of org.apache.cassandra.auth.PasswordAuthenticator.
 * Logs successful and unsuccessful logins of both admin and normal user.
 * @author Goran Dermanovic
 */
public class ExtendedPasswordAuthenticator extends PasswordAuthenticator {

    private static final Logger logger = LoggerFactory.getLogger(PasswordAuthenticator.class);

    @Override
    public AuthenticatedUser authenticate(Map<String, String> arg0) throws AuthenticationException {
        try {
            AuthenticatedUser authenticatedUser = super.authenticate(arg0);
            if (authenticatedUser != null) {
                logger.info("Successful login: for " + (authenticatedUser.isSuper() ? "super" : "ordinary ") + "user" + authenticatedUser.getName());
            }
            return authenticatedUser;
        } catch (AuthenticationException e) {
            logger.info("Unsuccessful login: with username: " + arg0.get(USERNAME_KEY));
            logger.info("AuthenticationException: " + e.getMessage());
            throw(e);
        }
    }
}
