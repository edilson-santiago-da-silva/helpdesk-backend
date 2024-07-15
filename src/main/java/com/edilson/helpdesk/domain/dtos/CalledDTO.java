package com.edilson.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.edilson.helpdesk.domain.Called;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CalledDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate openingDate = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate closingDate = LocalDate.now();
	private Integer priority;
	private Integer status;
	private String title;
	private String comments;
	private Integer technician;
	private Integer client;
	private String nameTechnician;
	private String nameClient;

	public CalledDTO() {
		super();
	}

	public CalledDTO(Called obj) {
		this.id = obj.getId();
		this.openingDate = obj.getOpeningDate();
		this.closingDate = obj.getClosingDate();
		this.priority = obj.getPriority().getCode();
		this.status = obj.getStatus().getCode();
		this.title = obj.getTitle();
		this.comments = obj.getComments();
		this.technician = obj.getTechnician().getId();
		this.client = obj.getClient().getId();
		this.nameClient = obj.getClient().getName();
		this.nameTechnician = obj.getTechnician().getName();
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Integer getTechnician() {
		return technician;
	}

	public void setTechnician(Integer technician) {
		this.technician = technician;
	}

	public Integer getClient() {
		return client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}

	public String getNameTechnician() {
		return nameTechnician;
	}

	public void setNameTechnician(String nameTechnician) {
		this.nameTechnician = nameTechnician;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

}
