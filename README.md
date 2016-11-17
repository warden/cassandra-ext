CASSANDRA EXTENSIONS
====================

PasswordAuthenticator
------------------------

Extension of org.apache.cassandra.auth.PasswordAuthenticator. Logs successful logins of both admin and normal user.
To install this extension put an artifact jar into cassandra/lib and in cassandra.yaml set:
`authenticator: com.oberthur.cassandra.ext.auth.ExtendedPasswordAuthenticator`

RELEASE NOTES:
--------------

**v.2.0** ExtendedPasswordAuthenticator extension
**v.3.0** ExtendedPasswordAuthenticator extension; loging of IP from which connection is coming

**A note about branching strategy:** since we have to support two versions of cassandra, there are historical branches for versions 2.1.x and 3.x

