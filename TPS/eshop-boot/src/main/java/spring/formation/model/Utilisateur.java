package spring.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "utilisateur")
@JsonView(Views.ViewBase.class)
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uti_id")
	private Long id;

	@Column(name = "uti_username", length = 50, nullable = false)
	private String username;

	@Column(name = "uti_password", length = 200, nullable = false)
	private String password;

	@Column(name = "uti_admin")
	private Boolean admin;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String username, String password, Boolean admin) {
		super();
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}
