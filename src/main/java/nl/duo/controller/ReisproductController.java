package nl.duo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.duo.model.Reisproduct;
import nl.duo.repository.ReisproductRepository;

@RestController
@RequestMapping("/student")
public class ReisproductController {

	@Autowired
	ReisproductRepository reisproductRepository;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Reisproduct> get() {
	        return reisproductRepository.findAll();
	    }
	
	@RequestMapping(value = "/{studentId}", method = RequestMethod.GET, produces = "application/json")
	public Reisproduct get(@PathVariable(value="studentId") Long studentId) {
	        return reisproductRepository.findByStudentId(studentId);
	    }

}
