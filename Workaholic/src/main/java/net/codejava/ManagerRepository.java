package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
	@Query("SELECT m FROM Manager m WHERE m.email = ?1")
	public Manager findByEmail(String email);
}
