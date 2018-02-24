package com.interglobe.test.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Sanjib Pramanick
 *
 */
@Entity
@Getter
@Setter
@ToString
@RestResource
@EqualsAndHashCode
@Table(name = "notes")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	private String content;

	@Column(name = "create_date", nullable = false)
	private Date createDate;

	@Column(name = "modified_date", nullable = false)
	private Date modifiedDate;

	private String status="INACTIVE";

}
