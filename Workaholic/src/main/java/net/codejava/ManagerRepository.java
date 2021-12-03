package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

<<<<<<< HEAD
public interface ManagerRepository extends JpaRepository<Manager,Long>{
=======
public interface ManagerRepository extends JpaRepository<Manager, Long> {
>>>>>>> db2bc7a2eb552ab091ba3b1d6edef248e84bb649
	@Query("SELECT m FROM Manager m WHERE m.email = ?1")
	public Manager findByEmail(String email);
}
