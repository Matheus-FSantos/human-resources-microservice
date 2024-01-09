package io.github.matheusfsantos.hrpayroll.model.dtos;

import java.io.Serializable;
import java.util.Objects;

public class WorkerDTO implements Serializable {

	public static final long serialVersionUID = 1L;
	
	private String name;
	private Double dailyIncome;
	
	public WorkerDTO() { }
	
	public WorkerDTO(String name, Double dailyIncome) {
		super();
		this.name = name;
		this.dailyIncome = dailyIncome;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dailyIncome, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkerDTO other = (WorkerDTO) obj;
		return Objects.equals(dailyIncome, other.dailyIncome) && Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "WorkerDTO [name=" + name + ", dailyIncome=" + dailyIncome + "]";
	}

	public String getName() {
		return name;
	}

	public void updateName(String name) {
		this.setName(name);
	}

	private void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void updateDailyIncome(Double dailyIncome) {
		this.setDailyIncome(dailyIncome);
	}

	private void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	
}
