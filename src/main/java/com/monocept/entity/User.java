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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id")
	private int UserID;
	
	@Column(name = "F_name")
	private String FName;
	
	@Column(name = "L_name")
	private String LName;
	
	private boolean isAdmin = true ;
	private boolean isActive = true;
	
	
	@OneToMany(cascade= CascadeType.ALL )
	@JoinColumn(name = "fk_user_id",referencedColumnName = "User_Id")
	private List<Contact> contacts;
	
	
}
