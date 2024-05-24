package entity;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Table(name = "Area")
public class Area implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "areaID")
	private int areaID;
	
	@Column(name = "Title")
	private String title;

	@Column(name = "Address")
	private String address;
	
	//Relationship
	@OneToMany(targetEntity = Customer.class, mappedBy = "area")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Customer>customerList;
	
	@OneToMany(targetEntity = Station.class, mappedBy = "area")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Station>stationList;
	
	@OneToMany(targetEntity = Request.class, mappedBy = "area")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Request>requestList;
}
