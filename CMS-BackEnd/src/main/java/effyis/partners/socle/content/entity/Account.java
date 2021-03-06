package effyis.partners.socle.content.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 *
 * @author Elkotb Zakaria
 *
 */

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	@NotNull
	@Email
	private String login;
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = false)
	@NotNull
	private String password;
	@ManyToOne
	private Role role;

	@Override
	public String toString() {
		StringBuilder account = new StringBuilder("{ login : ");
		return account.append(this.login).append(", password : ").append(this.password).append(" }").toString();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(@NotNull String login, @NotNull String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	

}
