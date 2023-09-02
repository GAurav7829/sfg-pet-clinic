package com.sfg.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -1006807498524942332L;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
