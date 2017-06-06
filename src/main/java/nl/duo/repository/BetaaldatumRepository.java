package nl.duo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nl.duo.model.Betaaldatum;

public interface BetaaldatumRepository extends JpaRepository<Betaaldatum, Long>  {

	@Query("select o from Betaaldatum o where extract(year from o.betaaldatum) = :jaar")
	public List<Betaaldatum> getBetaaldataPerJaar(@Param("jaar") int jaar);
	
	@Query("select o from Betaaldatum o where o.betaaldatum = ( select min(betaaldatum) from Betaaldatum o2 where o2.betaaldatum > :datum )")
	public Betaaldatum getNextBetaaldatumAfter(@Param("datum") Date datum);
}
