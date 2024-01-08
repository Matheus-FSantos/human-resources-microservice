package io.github.matheusfsantos.hrworker.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_worker")
public class Worker implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable=false, length=120)
	private String name;
	
	@Column(nullable=false)
	private Double dailyIncome;

	@Column(nullable=false)
	private LocalDateTime createdAt;
	
	@Column(nullable=false)
	private LocalDateTime updatedAt;
	
	public Worker() { }
	
	public Worker(UUID id, String name, Double dailyIncome, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, dailyIncome, id, name, updatedAt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(dailyIncome, other.dailyIncome)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(updatedAt, other.updatedAt);
	}

	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + ", dailyIncome=" + dailyIncome + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	public UUID getId() {
		return id;
	}

	public void updateId(UUID id) {
		this.setId(id);
	}

	private void setId(UUID id) {
		this.id = id;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void updateCreatedAt() {
		this.setCreatedAt(LocalDateTime.now());
	}

	public void updateCreatedAt(LocalDateTime createdAt) {
		this.setCreatedAt(createdAt);
	}

	private void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void updateUpdatedAt() {
		this.setUpdatedAt(LocalDateTime.now());
	}

	public void updateUpdatedAt(LocalDateTime updatedAt) {
		this.setUpdatedAt(updatedAt);
	}

	private void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
