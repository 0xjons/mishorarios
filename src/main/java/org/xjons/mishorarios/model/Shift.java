package org.xjons.mishorarios.model;

import java.time.LocalDateTime;

import org.xjons.mishorarios.enums.ShiftType;
import org.xjons.timefolddemo.model.Employee;

import ai.timefold.solver.core.api.domain.entity.PlanningEntity;
import ai.timefold.solver.core.api.domain.lookup.PlanningId;
import ai.timefold.solver.core.api.domain.variable.PlanningVariable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shifts")
@PlanningEntity
public class Shift {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PlanningId
	private Long id;
	@Column(name = "\"start\"", nullable = false)
	private LocalDateTime start; // Removed static

	@Column(name = "\"end\"", nullable = false)
	private LocalDateTime end;

	// This assumes you have defined an enum for ShiftType somewhere
	@PlanningVariable(valueRangeProviderRefs = "shiftTypeRange")
	private ShiftType type;
	
	@PlanningVariable
 @ManyToOne
 @JoinColumn(name = "employee_id", nullable = false)
 private Employee employee;

	// Relación muchos-a-uno con Schedule
	@ManyToOne
	@JoinColumn(name = "schedule_id", nullable = false)
	private Schedule schedule;

	// ... getters y setters ...
}