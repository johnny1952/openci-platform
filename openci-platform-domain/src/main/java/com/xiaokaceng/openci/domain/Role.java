package com.xiaokaceng.openci.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "roles")
public class Role extends TimeIntervalEntity {

	private static final long serialVersionUID = 3030679767001723029L;

	private String name;

	private String description;

	public Role(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Role(String name) {
		this.name = name;
	}

	Role() {
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Role)) {
			return false;
		}
		Role that = (Role) other;
		return new EqualsBuilder().append(getName(), that.getName()).append(getDescription(), that.getDescription()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName()).append(getDescription()).hashCode();
	}

	@Override
	public String toString() {
		return getName();
	}

}
