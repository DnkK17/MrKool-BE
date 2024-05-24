package entity;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

@Table(name = "Technician")
public class Technician implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID")
    private int technicianID;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Status")
    private String status;
    
    //Relationship
    @ManyToOne(targetEntity = Manager.class, fetch = FetchType.EAGER)
  	@JoinColumn(name = "managerID", referencedColumnName = "managerID", nullable = false, insertable = true, updatable = false)
  	@JsonIgnore
  	@ToString.Exclude
  	private Manager manager;
    
    @ManyToOne(targetEntity = Station.class, fetch = FetchType.EAGER)
  	@JoinColumn(name = "stationID", referencedColumnName = "stationID", nullable = false, insertable = true, updatable = false)
  	@JsonIgnore
  	@ToString.Exclude
  	private Station station;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "walletID", referencedColumnName = "walletID", nullable = false, insertable = true, updatable = false)
	@JsonIgnore
	@ToString.Exclude
	private Wallet wallet;
    
    @OneToMany(targetEntity = Request.class, mappedBy = "technician")
   	@ToString.Exclude
   	private Collection<Request>requestList;
    
    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "technician")
   	@ToString.Exclude
   	private Collection<OrderDetail>orderDetailList;
    
    @OneToMany(targetEntity = FixHistory.class, mappedBy = "technician")
   	@ToString.Exclude
   	private Collection<FixHistory>fixHistoryList;
}
