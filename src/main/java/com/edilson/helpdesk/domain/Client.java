package com.edilson.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.edilson.helpdesk.domain.enums.Profile;

@Entity
public class Client extends Person {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "client")
	private List<Called> called = new ArrayList<>();

	public Client() {
		super();
		addProfile(Profile.CLIENT);
	}

	public Client(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfile(Profile.CLIENT);
	}

	public List<Called> getCalled() {
		return called;
	}

	public void setCalled(List<Called> called) {
		this.called = called;
	}
	
	
	
	
}
