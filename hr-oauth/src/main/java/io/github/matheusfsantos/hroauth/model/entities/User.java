package io.github.matheusfsantos.hroauth.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String email;

	private String password;
	
	private Set<Role> roles = new HashSet<Role>();
	
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	public User() { }
	
	public User(Long id, String name, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	public Long getId() {
		return id;
	}
	
	public void updateId(Long id) {
		this.setId(id);
	}
	
	private void setId(Long id) {
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
	
	
	public String getEmail() {
		return email;
	}
	
	public void updateEmail(String email) {
		this.setEmail(email);
	}
	
	private void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void updatePassword(String password) {
		this.setPassword(password);
	}
	
	private void setPassword(String password) {
		this.password = password;
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
	
	public Set<Role> getRoles() {
		return roles;
	}
	
}
