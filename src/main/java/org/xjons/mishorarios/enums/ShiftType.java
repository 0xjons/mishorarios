package org.xjons.mishorarios.enums;

import java.time.LocalTime;

import org.xjons.mishorarios.model.ShiftPlanningConstants;

public enum ShiftType {
 PUERTA_PRINCIPAL_MANANA("Puerta Principal - Mañana", "08:00-15:00",
 		ShiftPlanningConstants.INIT_MORNING, ShiftPlanningConstants.END_MORNING),
 PUERTA_PRINCIPAL_TARDE("Puerta Principal - Tarde", "15:00-22:00",
 		ShiftPlanningConstants.END_MORNING, ShiftPlanningConstants.END_AFTERNOON),
 RX_MANANA("Rayos X - Mañana", "08:00-15:00",
 		ShiftPlanningConstants.INIT_MORNING, ShiftPlanningConstants.END_MORNING),
 RX_TARDE("Rayos X - Tarde", "15:00-22:00", ShiftPlanningConstants.END_MORNING, ShiftPlanningConstants.END_AFTERNOON),
 PLANTAS_MANANA("Plantas - Mañana", "08:00-15:00",
 		ShiftPlanningConstants.INIT_MORNING, ShiftPlanningConstants.END_MORNING),
 REFUERZO_MANANA("Refuerzo - Mañana", "08:00-15:00",
 		ShiftPlanningConstants.INIT_MORNING, ShiftPlanningConstants.END_MORNING),
 REFUERZO_TARDE("Refuerzo - Tarde", "15:00-22:00", ShiftPlanningConstants.END_MORNING, ShiftPlanningConstants.END_AFTERNOON),
 FREE_("Día Libre", "00:00-24:00",
 		ShiftPlanningConstants.INIT_FREE, ShiftPlanningConstants.END_FREE);

 private final String displayName;
 private final String workingHours;
 private final LocalTime startTime;
 private final LocalTime endTime;

 ShiftType(String displayName, String workingHours,
 		LocalTime startTime, LocalTime endTime) {
     this.displayName = displayName;
     this.workingHours = workingHours;
					this.startTime = startTime;
					this.endTime = endTime;
 }

 public String getDisplayName() {
     return displayName;
 }

 public String getWorkingHours() {
     return workingHours;
 }
 
 

 public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	@Override
 public String toString() {
     return displayName + " (" + workingHours + ")";
 }
}
