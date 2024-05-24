package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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


public class FixHistory implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fixID")
	private int fixHistoryID;
	
	@Column(name = "Title")
	private String title;

	@Column(name = "Date")
	private Date date;
	
	@Column(name = "Type")
	private String type;
	
	@Column(name = "Description")
	private String description;
	
	//Relationship
	
	@ManyToOne(targetEntity = Technician.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "technicianID", referencedColumnName = "techinicianID", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Technician technician;
	
	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "customerID", referencedColumnName = "customerID", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Customer customer;
	
	@ManyToOne(targetEntity = Service.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "serviceID", referencedColumnName = "serviceID", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Service service;
	
}
