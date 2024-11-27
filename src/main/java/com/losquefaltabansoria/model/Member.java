package com.losquefaltabansoria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long code;
	private String lastName;
	private String firstName;
	private String address;
	private String postalCode;
	private String municipality;
	private String province;
	private String telephone;
	private String email;
	private String gender;
	private String size;
	private String quota;
	private String reservation;
	private String allergies;
	private String remarks;
	private String password;
}
