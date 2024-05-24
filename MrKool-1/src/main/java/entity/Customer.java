package entity;

import java.io.Serializable;
import java.util.Collection;

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

@Table(name = "Customer")
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerID")
	private int customerID;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Telephone")
	private String telephone;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Gender")
	private boolean gender;
	
	//Relationship 
	
	@ManyToOne(targetEntity = Area.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "areaID", referencedColumnName = "areaID", nullable = false)
	@JsonIgnore
	@ToString.Exclude
	private Area area; 
	
	@OneToMany(targetEntity = Order.class, mappedBy = "customer")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Order> orderList;
	
	@OneToMany(targetEntity = FixHistory.class, mappedBy = "customer")
	@JsonIgnore
	@ToString.Exclude
	private Collection<FixHistory> fixHistoryList;
	
	@OneToMany(targetEntity = Request.class, mappedBy = "customer")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Order> requestList;
}
