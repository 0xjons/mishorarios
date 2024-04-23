package org.xjons.mishorarios.model;

import java.util.ArrayList;
import java.util.List;
import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningScore;
import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.solution.ProblemFactCollectionProperty;
import ai.timefold.solver.core.api.domain.valuerange.ValueRangeProvider;
import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;
import ai.timefold.solver.core.api.solver.SolverStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@PlanningSolution
public class Schedule {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 // Relación inversa uno-a-uno con Employee
 @OneToOne
 @JoinColumn(name = "employee_id", nullable = false)
	@ProblemFactCollectionProperty
	@ValueRangeProvider
 private Employee employee;

 @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
 @PlanningEntityCollectionProperty
 private List<Shift> shifts;
 
	@PlanningScore
	private HardSoftScore score;


	private SolverStatus solverStatus;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
		this.employee = new Employee();
		this.shifts = new ArrayList<>();
	}
	
	public Schedule(Employee employee, List<Shift> shifts) {
		this.employee = employee;
		this.shifts = shifts;
	}

	public Schedule(HardSoftScore score, SolverStatus solverStatus) {
		this.score = score;
		this.solverStatus = solverStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Shift> getShifts() {
		return shifts;
	}

	public void setShifts(List<Shift> shifts) {
		this.shifts = shifts;
	}

	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(HardSoftScore score) {
		this.score = score;
	}

	public SolverStatus getSolverStatus() {
		return solverStatus;
	}

	public void setSolverStatus(SolverStatus solverStatus) {
		this.solverStatus = solverStatus;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", employee=" + employee + ", shifts=" + shifts + ", score=" + score + ", solverStatus="
				+ solverStatus + "]";
	}
	
	
}
