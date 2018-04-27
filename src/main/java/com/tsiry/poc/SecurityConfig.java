/**
 * 
 */
package com.tsiry.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Tsiry MANANKASINA      from  eclipse.ini --> -Duser.name=Tsiry MANANKASINA
 *								  Preferences -> Java -> Code Style -> Code Template
 *
 *Cette classe est une classe de configuration de spring securtity
 */

@Configuration        //toute classe ayant cette annotation sera scanner au demarrage de spring
@EnableWebSecurity    //pour que cette config soit prise en compte
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//methode de configuration globale:
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
	{
		//ces users seront en mémoire  , donc plus besoin de les mettre dans application.properties
		authenticationManagerBuilder.inMemoryAuthentication().withUser("tsiry").password("tsiry").roles("ADMIN");
		authenticationManagerBuilder.inMemoryAuthentication().withUser("nanah").password("nanah").roles("ADMIN");
		authenticationManagerBuilder.inMemoryAuthentication().withUser("user1").password("user1").roles("USER");
		authenticationManagerBuilder.inMemoryAuthentication().withUser("user2").password("user2").roles("USER");
		authenticationManagerBuilder.inMemoryAuthentication().withUser("user3").password("user3").roles("USER");
	}
	
	//protection des ressources
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest()
					.authenticated()  //jusqu'ici , tous les requetes sont permises si l'user s'est authentifié
						.and() // on va ajouter une nouvelle regle
		   .formLogin()
		   	.loginPage("/login") //url de login (c un exemple , /login doit être associé à une page)
		   		.permitAll();  
	}
}
