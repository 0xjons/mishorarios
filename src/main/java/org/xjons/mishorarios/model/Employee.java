package org.xjons.mishorarios.model;

import org.xjons.mishorarios.enums.ShiftType;

import ai.timefold.solver.core.api.domain.lookup.PlanningId;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @PlanningId
 private Long id;
 
 @Column(length = 255, nullable = false)
 private String name;

 // Relación uno-a-uno con Schedule
 @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
 private Schedule schedule;
 
 public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, String name, Schedule schedule) {
		super();
		this.id = id;
		this.name = name;
		this.schedule = schedule;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", schedule=" + schedule + "]";
	}
 
 
}
