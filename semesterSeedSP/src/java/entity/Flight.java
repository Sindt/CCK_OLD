/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sindt
 */
@Entity
@Table(name = "flight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f"),
    @NamedQuery(name = "Flight.findByFlightnumber", query = "SELECT f FROM Flight f WHERE f.flightnumber = :flightnumber"),
    @NamedQuery(name = "Flight.findByNumberofseats", query = "SELECT f FROM Flight f WHERE f.numberofseats = :numberofseats")})
public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "flightnumber")
    private String flightnumber;
    @Column(name = "numberofseats")
    private Integer numberofseats;
    @JoinColumn(name = "airline_name", referencedColumnName = "airline_name")
    @ManyToOne
    private Airline airlineName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flightnumber")
    private Collection<Flightinstance> flightinstanceCollection;

    public Flight() {
    }

    public Flight(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public Integer getNumberofseats() {
        return numberofseats;
    }

    public void setNumberofseats(Integer numberofseats) {
        this.numberofseats = numberofseats;
    }

    public Airline getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(Airline airlineName) {
        this.airlineName = airlineName;
    }

    @XmlTransient
    public Collection<Flightinstance> getFlightinstanceCollection() {
        return flightinstanceCollection;
    }

    public void setFlightinstanceCollection(Collection<Flightinstance> flightinstanceCollection) {
        this.flightinstanceCollection = flightinstanceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightnumber != null ? flightnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.flightnumber == null && other.flightnumber != null) || (this.flightnumber != null && !this.flightnumber.equals(other.flightnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Flight[ flightnumber=" + flightnumber + " ]";
    }
    
}
