package nl.duo.repository;

import nl.duo.model.Reisproduct;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReisproductRepository extends JpaRepository<Reisproduct, Long> {

	Reisproduct findByStudentId(Long studentId);

}
