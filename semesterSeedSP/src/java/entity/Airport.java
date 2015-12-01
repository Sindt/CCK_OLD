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
@Table(name = "airport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airport.findAll", query = "SELECT a FROM Airport a"),
    @NamedQuery(name = "Airport.findByIatacode", query = "SELECT a FROM Airport a WHERE a.iatacode = :iatacode"),
    @NamedQuery(name = "Airport.findByName", query = "SELECT a FROM Airport a WHERE a.name = :name"),
    @NamedQuery(name = "Airport.findByCity", query = "SELECT a FROM Airport a WHERE a.city = :city"),
    @NamedQuery(name = "Airport.findByTimezone", query = "SELECT a FROM Airport a WHERE a.timezone = :timezone")})
public class Airport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "iatacode")
    private String iatacode;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "city")
    private String city;
    @Size(max = 255)
    @Column(name = "timezone")
    private String timezone;
    @OneToMany(mappedBy = "destination")
    private Collection<Flightinstance> flightinstanceCollection;
    @OneToMany(mappedBy = "origin")
    private Collection<Flightinstance> flightinstanceCollection1;

    public Airport() {
    }

    public Airport(String iatacode) {
        this.iatacode = iatacode;
    }

    public String getIatacode() {
        return iatacode;
    }

    public void setIatacode(String iatacode) {
        this.iatacode = iatacode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @XmlTransient
    public Collection<Flightinstance> getFlightinstanceCollection() {
        return flightinstanceCollection;
    }

    public void setFlightinstanceCollection(Collection<Flightinstance> flightinstanceCollection) {
        this.flightinstanceCollection = flightinstanceCollection;
    }

    @XmlTransient
    public Collection<Flightinstance> getFlightinstanceCollection1() {
        return flightinstanceCollection1;
    }

    public void setFlightinstanceCollection1(Collection<Flightinstance> flightinstanceCollection1) {
        this.flightinstanceCollection1 = flightinstanceCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iatacode != null ? iatacode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airport)) {
            return false;
        }
        Airport other = (Airport) object;
        if ((this.iatacode == null && other.iatacode != null) || (this.iatacode != null && !this.iatacode.equals(other.iatacode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Airport[ iatacode=" + iatacode + " ]";
    }
    
}
