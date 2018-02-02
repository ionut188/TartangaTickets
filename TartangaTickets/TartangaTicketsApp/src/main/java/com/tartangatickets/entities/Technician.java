/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tartangatickets.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author Sergio López
 */
@Entity(name="Technician")
@Table(name="technicians", schema="tartanga_ticket_db")
@NamedQueries({
    @NamedQuery(
            name="findAllTechnician",
            query="SELECT u FROM Technician u ORDER BY u.id"
    )
})
public class Technician extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Boolean isAdmin;
    @OneToMany(mappedBy="technician",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> assignedTickets;

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Ticket> getAssignedTickets() {
        return assignedTickets;
    }

    public void setAssignedTickets(List<Ticket> assignedTickets) {
        this.assignedTickets = assignedTickets;
    }
    
    
    
}