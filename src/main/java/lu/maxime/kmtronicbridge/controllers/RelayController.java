package lu.maxime.kmtronicbridge.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lu.maxime.kmtronicbridge.domain.Relay;
import lu.maxime.kmtronicbridge.domain.SimpleBean;
import lu.maxime.kmtronicbridge.utils.Constants;

@RestController
@RequestMapping("/relays")
@CrossOrigin
public class RelayController {

	private static final Logger LOG = LoggerFactory.getLogger(RelayController.class);
	@Value("${kmtronicurl}")
	private String KMTRONIC_URL;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Relay> getAll() {
		return Constants.getRelays();
	}

	@RequestMapping(value = "/{id}/description", method = RequestMethod.POST)
	public void updateDesciption(@PathVariable Integer id, @RequestBody SimpleBean<String> description) {
		Constants.updateDescription(id, description.getValue());
		LOG.info(String.format("Relay #%d description has been set to %s", id, description.getValue()));
	}

	@RequestMapping(value = "/{id}/isOn", method = RequestMethod.POST)
	public void updateIsOn(@PathVariable Integer id, @RequestBody SimpleBean<Boolean> isOn) {
		String url = String.format("%s/FF0%d0%d", KMTRONIC_URL, id, isOn.getValue() ? 1 : 0);
		try (Scanner s = new Scanner(new URL(url).openStream())) {
			System.out.println(s.useDelimiter("\\A").next());
		} catch (IOException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			LOG.info(String.format("Cannot set relay #%d to %b", id, isOn.getValue()));
			return;
		}
		Constants.updateIsOn(id, isOn.getValue());
		LOG.info(String.format("Relay #%d has been set to %b", id, isOn.getValue()));
	}

}
