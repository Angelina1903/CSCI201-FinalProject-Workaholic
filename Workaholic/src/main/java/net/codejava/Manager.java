package net.codejava;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager extends User{

	@Column(name = "isManager", nullable = false) // might be an error
	private boolean isManager;

	public boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(boolean isManager) {this.isManager = isManager;
	}

}
