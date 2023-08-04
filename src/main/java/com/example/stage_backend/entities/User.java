package com.example.stage_backend.entities;
import com.example.stage_backend.enums.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="user", schema = "public")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private ERole userRole;

    @JsonIgnore // Ignorer la sérialisation de cette propriété
    @OneToOne(mappedBy = "user")
    private Eleve eleve;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ERole getUserRole() {
		return userRole;
	}

	public void setUserRole(ERole userRole) {
		this.userRole = userRole;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
}