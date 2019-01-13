package pl.rafalab.restWithSpring.Model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;
	@NotEmpty(message="Pole nie może być puste")
	private String email;
	@NotNull
	private String lastName;
	@NotNull
	private String password;
	@NotNull
	private String gender;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Role> roles;
	
	@NotNull
	private String country;
	
	@NotNull
	private Date birthDate;
}
