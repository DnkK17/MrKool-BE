package entity;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

@Table(name = "Manager")
public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ManagerID")
    private int managerID;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Status")
    private String status;
    
    //Relationship
    @OneToMany(targetEntity = Technician.class, mappedBy = "manager")
	@JsonIgnore
	@ToString.Exclude
	private Collection<Technician>technicianList;
    
    @OneToMany(targetEntity = Request.class, mappedBy = "manager")
   	@JsonIgnore
   	@ToString.Exclude
   	private Collection<Request>requestList;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "walletID", referencedColumnName = "walletID", nullable = false, insertable = true, updatable = false)
	@JsonIgnore
	@ToString.Exclude
	private Wallet wallet;
    
}
