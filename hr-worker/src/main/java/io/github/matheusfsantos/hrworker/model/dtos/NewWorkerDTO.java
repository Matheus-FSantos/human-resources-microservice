package io.github.matheusfsantos.hrworker.model.dtos;

import java.io.Serializable;

public class NewWorkerDTO implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	private String name;
	private Double dailyIncome;
	
	public NewWorkerDTO() { }
	
	public NewWorkerDTO(String name, Double dailyIncome) {
		this.name = name;
		this.dailyIncome =  dailyIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	
}
