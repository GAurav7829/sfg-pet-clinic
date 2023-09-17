package com.sfg.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

	@Column(name = "name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dateOfBirth;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();

	@Builder
	public Pet(String name, PetType petType, Owner owner, LocalDate dateOfBirth, Set<Visit> visits) {
		super();
		this.name = name;
		this.petType = petType;
		this.owner = owner;
		this.dateOfBirth = dateOfBirth;
		if (null == visits || visits.size() > 0)
			this.visits = visits;
	}

}
