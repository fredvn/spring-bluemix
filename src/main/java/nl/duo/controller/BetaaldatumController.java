package nl.duo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.duo.model.Betaaldatum;
import nl.duo.repository.BetaaldatumRepository;

@RestController
@RequestMapping("/betaaldatum")
public class BetaaldatumController {

	@Autowired
	BetaaldatumRepository betaaldatumRepository;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Betaaldatum> getAll() {
	        return betaaldatumRepository.findAll();
	    }
	@RequestMapping(value = "/next", method = RequestMethod.GET, produces = "application/json")
	public Betaaldatum getNext() {
	        return betaaldatumRepository.getNextBetaaldatumAfter(new Date());
	    }

	@RequestMapping(value = "/{jaar}", method = RequestMethod.GET, produces = "application/json")
	public List<Betaaldatum> get(@PathVariable(value="jaar") Integer jaar) {
	        return betaaldatumRepository.getBetaaldataPerJaar(jaar);
	    }
	

}
