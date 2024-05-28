package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Collection;

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
