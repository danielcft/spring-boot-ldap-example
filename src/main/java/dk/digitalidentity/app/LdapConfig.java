package dk.digitalidentity.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfig {

	@Bean
	public LdapContextSource getContextSource() throws Exception{
		LdapContextSource ldapContextSource = new LdapContextSource();
		ldapContextSource.setUrl("ldap://54.154.65.69:389");
		ldapContextSource.setBase("dc=example,dc=org");
		ldapContextSource.setUserDn("daniel@example");
		ldapContextSource.setPassword("Test1234");
		return ldapContextSource;
	}
	
	@Bean
	public LdapTemplate ldapTemplate() throws Exception{
		LdapTemplate ldapTemplate = new LdapTemplate(getContextSource());
		ldapTemplate.setIgnorePartialResultException(true);
		ldapTemplate.setContextSource(getContextSource());
		return ldapTemplate;
	}
}
