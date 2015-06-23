package dk.digitalidentity.app;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.Filter;

public class PersonRepo {
	private LdapTemplate ldapTemplate;

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public List<LdapPerson> getAllPerson(Filter filter) {
		return ldapTemplate.search("", filter.encode(), new AttributesMapper() {
			@Override
			public LdapPerson mapFromAttributes(Attributes attr) throws NamingException {
				LdapPerson person = new LdapPerson();
				person.setCn((String) attr.get("cn").get());
				return person;
			}
		});
	}

}
