package com.oberthur.cassandra.ext.auth;

import org.apache.cassandra.auth.AuthenticatedUser;
import org.apache.cassandra.auth.PasswordAuthenticator;
import org.apache.cassandra.exceptions.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * ExtendedPasswordAuthenticator is an extension of org.apache.cassandra.auth.PasswordAuthenticator.
 * Logs successful logins of both admin and normal user.
 * @author Goran Dermanovic
 */
public class ExtendedPasswordAuthenticator extends PasswordAuthenticator {

    private static final Logger logger = LoggerFactory.getLogger(PasswordAuthenticator.class);

    @Override
    public AuthenticatedUser legacyAuthenticate(Map<String, String> arg0) throws AuthenticationException {

        AuthenticatedUser authenticatedUser = super.legacyAuthenticate(arg0);
        if (authenticatedUser != null) {
            logger.info((authenticatedUser.isSuper() ? "Super" : "Ordinary ") + "user " + authenticatedUser.getName() + " authenticated");
        }
        return authenticatedUser;
    }
}
