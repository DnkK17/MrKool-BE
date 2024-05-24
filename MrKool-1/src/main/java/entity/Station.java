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

@Table(name = "Station")
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StationID")
    private int stationID;

    @Column(name = "Address")
    private String address;
    
    @Column(name = "Status")
    private boolean status;
    
    //Relationship
    @OneToMany(targetEntity = Request.class, mappedBy = "station")
   	@ToString.Exclude
   	private Collection<Request>requestList;
    
    @ManyToOne(targetEntity = Area.class, fetch = FetchType.EAGER)
  	@JoinColumn(name = "areaID", referencedColumnName = "areaID", nullable = false, insertable = true, updatable = false)
  	@JsonIgnore
  	@ToString.Exclude
  	private Area area;

    @OneToMany(targetEntity = Technician.class, mappedBy = "station")
   	@ToString.Exclude
   	private Collection<Technician>technicianList;
}
