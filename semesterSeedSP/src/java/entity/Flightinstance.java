/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sindt
 */
@Entity
@Table(name = "flightinstance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flightinstance.findAll", query = "SELECT f FROM Flightinstance f"),
    @NamedQuery(name = "Flightinstance.findByFlightinstanceId", query = "SELECT f FROM Flightinstance f WHERE f.flightinstanceId = :flightinstanceId"),
    @NamedQuery(name = "Flightinstance.findByDepartureTime", query = "SELECT f FROM Flightinstance f WHERE f.departureTime = :departureTime"),
    @NamedQuery(name = "Flightinstance.findByDepartureDate", query = "SELECT f FROM Flightinstance f WHERE f.departureDate = :departureDate"),
    @NamedQuery(name = "Flightinstance.findByFlighttime", query = "SELECT f FROM Flightinstance f WHERE f.flighttime = :flighttime"),
    @NamedQuery(name = "Flightinstance.findByPrice", query = "SELECT f FROM Flightinstance f WHERE f.price = :price")})
public class Flightinstance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "flightinstance_id")
    private Long flightinstanceId;
    @Column(name = "departureTime")
    private Integer departureTime;
    @Column(name = "departureDate")
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Column(name = "flighttime")
    private Integer flighttime;
    @Column(name = "price")
    private Integer price;
    @JoinColumn(name = "flightnumber", referencedColumnName = "flightnumber")
    @ManyToOne(optional = false)
    private Flight flightnumber;
    @JoinColumn(name = "destination", referencedColumnName = "iatacode")
    @ManyToOne
    private Airport destination;
    @JoinColumn(name = "origin", referencedColumnName = "iatacode")
    @ManyToOne
    private Airport origin;
    @OneToMany(mappedBy = "flightinstanceId")
    private Collection<Reservation> reservationCollection;

    public Flightinstance() {
    }

    public Flightinstance(Long flightinstanceId) {
        this.flightinstanceId = flightinstanceId;
    }

    public Long getFlightinstanceId() {
        return flightinstanceId;
    }

    public void setFlightinstanceId(Long flightinstanceId) {
        this.flightinstanceId = flightinstanceId;
    }

    public Integer getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Integer departureTime) {
        this.departureTime = departureTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getFlighttime() {
        return flighttime;
    }

    public void setFlighttime(Integer flighttime) {
        this.flighttime = flighttime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Flight getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(Flight flightnumber) {
        this.flightnumber = flightnumber;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightinstanceId != null ? flightinstanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flightinstance)) {
            return false;
        }
        Flightinstance other = (Flightinstance) object;
        if ((this.flightinstanceId == null && other.flightinstanceId != null) || (this.flightinstanceId != null && !this.flightinstanceId.equals(other.flightinstanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Flightinstance[ flightinstanceId=" + flightinstanceId + " ]";
    }
    
}
