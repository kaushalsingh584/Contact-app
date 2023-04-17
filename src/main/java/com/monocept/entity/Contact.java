package com.monocept.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Contact_ID")
	private int contactId;
	
	@Column(name = "F_name")
	private String FName;
	
	@Column(name = "L_name")
	private String LName;
	
	private boolean isActive = true;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "contact_details",referencedColumnName = "Contact_ID" )
	private List<ContactDetail>contactDetails;
}
