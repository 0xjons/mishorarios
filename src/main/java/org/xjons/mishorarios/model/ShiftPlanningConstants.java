package org.xjons.mishorarios.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiftPlanningConstants {

	public static final int ANNUAL_HOURS_PER_EMPLOYEE = 1955;
	public static final int HOURS_PER_SHIFT = 7;

	//Numero de empleados
	public static int EMPLOYEE_BASE = 25;
	public static int EMPLOYEE_EXTRA = 10;
	public static final int TOTAL_EMPLOYEES = EMPLOYEE_BASE + EMPLOYEE_EXTRA;
	
	

	public static final int WORK_DAYS_PER_YEAR = 279; // Ajustar según los días laborales reales
	public static final int TOTAL_WEEKDAYS = 104;

	public static final int MAX_CONSECUTIVE_DAYS = 6;
	
	public static final int MINIMO_CUBRIR_PUERTA = 4;
	public static final int MINIMO_CUBRIR_RX = 4;
	public static final int MINIMO_CUBRIR_PLANTAS = 12;
	
	public static final LocalTime INIT_MORNING = LocalTime.of(8, 0);
	public static final LocalTime INIT_FREE = LocalTime.of(0, 0);
	public static final LocalTime END_FREE = LocalTime.of(0, 0).plusHours(24); //test, añado 24h probar.
	public static final LocalTime END_MORNING = LocalTime.of(15, 0);
	public static final LocalTime END_AFTERNOON = LocalTime.of(22, 0);
	
	public static final int AFTERNOON_SHIFT_START_TIME = 15;  //A las 15h

	public static LocalDate ANNO_INI = LocalDate.of(2025, 1, 1);
	public static LocalDate ANNO_FIN = ANNO_INI.plusYears(1).minusDays(1);

	// Calcular el número de turnos por empleado por año
	public static final int TOTAL_SHIFTS_PER_EMPLOYEE_PER_YEAR = ANNUAL_HOURS_PER_EMPLOYEE / HOURS_PER_SHIFT;

	// Calcular el promedio de turnos por día entre todos los empleados
	public static final int AVERAGE_SHIFTS_PER_EMPLOYEE = (TOTAL_SHIFTS_PER_EMPLOYEE_PER_YEAR * TOTAL_EMPLOYEES)
			/ WORK_DAYS_PER_YEAR;
	
	// Calculamos cuántos turnos de fin de semana tocaría trabajar a cada empleado
	// para distribuir equitativamente
	public static final int AVERAGE_WEEKEND_WORK = (TOTAL_WEEKDAYS * TOTAL_EMPLOYEES) / TOTAL_EMPLOYEES;


	// Getter para obtener el promedio de turnos por empleado
	public static int getAverageShiftsPerEmployee() {
		return AVERAGE_SHIFTS_PER_EMPLOYEE;
	}

	public static boolean isWeekend(LocalDate date) {
		return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
	}

	public ShiftPlanningConstants() {
	}
	
 private static Set<LocalDate> holidays;

 static {
     holidays = initializeHolidays2024();  // Inicializar los días festivos cuando se carga la clase
 }

 public static boolean isHoliday(LocalDate date) {
     return holidays.contains(date);
 }

 //copiamos las de 2024, revisar...
	public static Set<LocalDate> initializeHolidays2024() {
		Set<LocalDate> holidays = new HashSet<>();
		holidays.add(LocalDate.of(2024, 1, 1)); // Año Nuevo
		holidays.add(LocalDate.of(2024, 1, 6)); // Epifanía del Señor
		holidays.add(LocalDate.of(2024, 3, 19)); // San José
		holidays.add(LocalDate.of(2024, 3, 29)); // Viernes Santo
		holidays.add(LocalDate.of(2024, 4, 1)); // Lunes de Pascua
		holidays.add(LocalDate.of(2024, 4, 8)); // San Vicente Ferrer
		holidays.add(LocalDate.of(2024, 5, 1)); // Fiesta del Trabajo
		holidays.add(LocalDate.of(2024, 7, 30)); // Fiesta Local
		holidays.add(LocalDate.of(2024, 8, 15)); // Asunción de la Virgen
		holidays.add(LocalDate.of(2024, 10, 9)); // Día de la Comunidad Valenciana
		holidays.add(LocalDate.of(2024, 10, 12)); // Fiesta Nacional de España
		holidays.add(LocalDate.of(2024, 11, 1)); // Todos los Santos
		holidays.add(LocalDate.of(2024, 12, 6)); // Día de la Constitución
		holidays.add(LocalDate.of(2024, 12, 25)); // Natividad del Señor
		return holidays;
	}
	
	//Generar nombres empleados random
	public static final List<String> NOMBRES = List.of("Carlos", "Ana", "Luis", "María", "Juan", "Carmen", "Jose",
			"Isabel");
	public static final List<String> APELLIDOS = List.of("Herrera", "Martínez", "García", "López", "González", "Pérez",
			"Rodríguez", "Sánchez");



}
