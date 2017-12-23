package lu.maxime.kmtronicbridge.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lu.maxime.kmtronicbridge.domain.Settings;
import lu.maxime.kmtronicbridge.utils.Constants;

@RestController
@RequestMapping("/settings")
@CrossOrigin
public class SettingsController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Settings getSettings() {
		return Constants.getSettings();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Settings setSettings(@RequestBody Settings settings) {
		return Constants.setSettings(settings);
	}

}
