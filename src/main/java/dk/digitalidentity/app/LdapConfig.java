package dk.digitalidentity.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfig {

	@Bean
	public LdapContextSource getContextSource() {
		LdapContextSource ldapContextSource = new LdapContextSource();
		ldapContextSource.setUrl("ldap://someIP:389");
		ldapContextSource.setBase("CN=Configuration,DC=example,DC=org");
		ldapContextSource.setUserDn("EXAMPLE\\DANIEL");
		return ldapContextSource;
	}
}
