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

@Table(name = "Model")
public class Model implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ModelID")
    private int modelID;

    @Column(name = "Title")
    private String title;

    @Column(name = "Price")
    private double price;

    // Relationship 
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ServiceID", referencedColumnName = "ServiceID",nullable = false)
    private Service service;
}
