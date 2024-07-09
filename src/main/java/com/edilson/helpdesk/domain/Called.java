package com.edilson.helpdesk.domain;

import java.time.LocalDate;
import java.util.Objects;

import com.edilson.helpdesk.domain.enums.Priority;
import com.edilson.helpdesk.domain.enums.Status;

public class Called {
	
	private Integer id;
	private LocalDate openingDate = LocalDate.now();
	private LocalDate closingDate = LocalDate.now();
	private Priority priority;
	private Status status;
	private String title;
	private String comments;
	
	private Technician technician;
	private Client client;
	
	public Called() {
		super();
	}

	public Called(Integer id, Priority priority, Status status, String title, String comments, Technician technician, Client client) {
		super();
		this.id = id;
		this.priority = priority;
		this.status = status;
		this.title = title;
		this.comments = comments;
		this.technician = technician;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Called other = (Called) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
