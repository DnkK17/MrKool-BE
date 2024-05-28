package entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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

@Table(name = "Request")
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequestID")
    private int requestID;

    @Column(name = "Date")
    private String date;

    @Column(name = "Description")
    private String description;

    @Column(name = "Address")
    private String address;

    @Column(name = "Status")
    private String status;
    
    //Relationship
    @ManyToOne(targetEntity = Area.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "areaID", referencedColumnName = "areaID", nullable = false, insertable = true, updatable = false)
	@JsonIgnore
	@ToString.Exclude
	private Area area;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "customerID", referencedColumnName = "customerID", nullable = false, insertable = true, updatable = false)
	@JsonIgnore
	@ToString.Exclude
	private Customer customer;
    
    @ManyToOne(targetEntity = Station.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "stationID", referencedColumnName = "stationID", nullable = false, insertable = true, updatable = false)
	@JsonIgnore
	@ToString.Exclude
	private Station station;
    
    @ManyToOne(targetEntity = Manager.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "managerID", referencedColumnName = "managerID", nullable = false, insertable = true, updatable = false)
	@JsonIgnore
	@ToString.Exclude
	private Manager manager;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "orderID", referencedColumnName = "orderID",nullable = false)
    private Order order;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "technicianID", referencedColumnName = "technicianID",nullable = false)
    private Technician technician;
    
}
