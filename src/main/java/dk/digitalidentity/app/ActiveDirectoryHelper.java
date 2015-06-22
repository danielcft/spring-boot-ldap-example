package dk.digitalidentity.app;

import javax.naming.directory.DirContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Component;

@Component
public class ActiveDirectoryHelper {

	@Autowired
	private LdapContextSource contextSource;

	public ActiveDirectoryHelper() {
	}

	public boolean authenticate(String userDn, String credentials) {
		DirContext ctx = null;
		try {
			ctx = contextSource.getContext(userDn, credentials);
			return true;
		}
		catch (Exception e) {
			// Context creation failed - authentication did not succeed
			System.out.println("login failed, " + e);
			return false;
		}
		finally {
			// It is imperative that the created DirContext instance is always
			// closed
			LdapUtils.closeContext(ctx);
		}
	}
}
