package ui.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import domain.db.Destinations;
import domain.model.Address;
@RestController
@RequestMapping("/destination")
public class DestinationsController {

	private Destinations destinations = Destinations.getInstance();
	
	@RequestMapping("{name}")
	@ResponseBody
	public String getDestinationWithName(@PathVariable(value="name") String name) throws JsonProcessingException {
		System.out.println("Getting destination with name " + name);
		Address out = destinations.getDestinationWithName(name);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(out);
	}
}
