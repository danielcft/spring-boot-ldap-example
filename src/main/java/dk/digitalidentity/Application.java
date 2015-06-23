package dk.digitalidentity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

import dk.digitalidentity.app.LdapPerson;
import dk.digitalidentity.app.PersonRepo;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	LdapTemplate ldapTemplate;

	public void run(String... args) {

		PersonRepo dao = new PersonRepo();
		dao.setLdapTemplate(ldapTemplate);

		AndFilter andFilter = new AndFilter();
		andFilter.and(new EqualsFilter("objectclass", "person"));
		andFilter.and(new EqualsFilter("sAMAccountName", "daniel"));
		andFilter.and(new EqualsFilter("memberof", "CN=TestGroup,DC=example,DC=org"));

		List<LdapPerson> allPerson = dao.getAllPerson(andFilter);
		for (LdapPerson p : allPerson) {
			System.out.println(p.getCn());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
