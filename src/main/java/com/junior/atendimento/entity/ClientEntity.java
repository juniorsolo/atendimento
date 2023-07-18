package com.junior.atendimento.entity;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "client")
@Data
@EqualsAndHashCode(callSuper = false)
public class ClientEntity extends RepresentationModel<ClientEntity>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name" )
	private String name;
	
	@OneToMany(mappedBy = "client")
	@JsonManagedReference
	private List<CustomerServiceEntity> customerServiceList;

}
