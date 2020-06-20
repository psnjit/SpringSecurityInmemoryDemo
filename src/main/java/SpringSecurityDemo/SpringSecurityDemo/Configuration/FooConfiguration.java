package SpringSecurityDemo.SpringSecurityDemo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class FooConfiguration extends WebSecurityConfigurerAdapter
{

  //for authentication
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception
  {
    auth.inMemoryAuthentication().withUser("prsaha").password("root").roles("admin_role").and().withUser("gautam").password("gautam").roles("student_role");
  }

  //for authorization
  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http.authorizeRequests().antMatchers("/admin").hasRole("admin_role") //if any api starting with admin can be accessed by someone with admin_role
      .antMatchers("/student/**").hasAnyRole("student_role", "admin_role") //else if any api starting with student can be accessed by someone with admin_role or student
      .antMatchers("/**").permitAll() //else anyone without authentication and authorization can access all these left over apis.
      .and()
      .formLogin();
  }

  @Bean
  public PasswordEncoder getPasswordEncoder()
  {
    return NoOpPasswordEncoder.getInstance();
  }
}
