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

	public int getAreaID() {
		return areaID;
	}

	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(Collection<Customer> customerList) {
		this.customerList = customerList;
	}

	public Collection<Station> getStationList() {
		return stationList;
	}

	public void setStationList(Collection<Station> stationList) {
		this.stationList = stationList;
	}

	public Collection<Request> getRequestList() {
		return requestList;
	}

	public void setRequestList(Collection<Request> requestList) {
		this.requestList = requestList;
	}
	
	
}
