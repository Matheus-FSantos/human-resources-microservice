package io.github.matheusfsantos.hroauth.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String roleName;
	
	public Role() { }
	
	public Role(Long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(id, other.id) && Objects.equals(roleName, other.roleName);
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
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

	public String getRoleName() {
		return roleName;
	}

	public void updateRoleName(String roleName) {
		this.setRoleName(roleName);
	}

	private void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
