package io.github.matheusfsantos.hrpayroll.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Payment implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	private String name;
	private Double dailyIncome;
	private Integer days;
	
	public Payment() { }
	
	public Payment(String name, Double dailyIncome, Integer days) {
		this.name = name;
		this.dailyIncome = dailyIncome;
		this.days = days;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dailyIncome, days, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(dailyIncome, other.dailyIncome) && Objects.equals(days, other.days)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Payroll [name=" + name + ", dailyIncome=" + dailyIncome + ", days=" + days + "]";
	}

	public Double getTotal() {
		return this.getDays() * this.getDailyIncome();
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

	public Integer getDays() {
		return days;
	}

	public void updateDays(Integer days) {
		this.setDays(days);
	}

	private void setDays(Integer days) {
		this.days = days;
	}
	
}
