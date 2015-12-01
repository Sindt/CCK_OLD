/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "airline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airline.findAll", query = "SELECT a FROM Airline a"),
    @NamedQuery(name = "Airline.findByAirlineName", query = "SELECT a FROM Airline a WHERE a.airlineName = :airlineName")})
public class Airline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "airline_name")
    private String airlineName;
    @OneToMany(mappedBy = "airlineName")
    private Collection<Flight> flightCollection;

    public Airline() {
    }

    public Airline(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @XmlTransient
    public Collection<Flight> getFlightCollection() {
        return flightCollection;
    }

    public void setFlightCollection(Collection<Flight> flightCollection) {
        this.flightCollection = flightCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (airlineName != null ? airlineName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airline)) {
            return false;
        }
        Airline other = (Airline) object;
        if ((this.airlineName == null && other.airlineName != null) || (this.airlineName != null && !this.airlineName.equals(other.airlineName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Airline[ airlineName=" + airlineName + " ]";
    }
    
}
