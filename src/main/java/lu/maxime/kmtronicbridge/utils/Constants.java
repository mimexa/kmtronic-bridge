package lu.maxime.kmtronicbridge.utils;

import java.util.ArrayList;
import java.util.List;

import lu.maxime.kmtronicbridge.domain.Relay;
import lu.maxime.kmtronicbridge.domain.Settings;
import lu.maxime.kmtronicbridge.domain.User;

public final class Constants {

	private static final String FAKE_URL = "255.255.255.255";
	private static final Integer FAKE_PORT_NUMBER = 65000;

	private static List<Relay> RELAYS = new ArrayList<>();
	private static Settings SETTINGS;
	static {
		for (int i = 1; i < 9; i++) {
			RELAYS.add(new Relay(i, "Relay " + i, false));
		}
		SETTINGS = new Settings();
		SETTINGS.setRelays(RELAYS);
		SETTINGS.setUrl(FAKE_URL);
		SETTINGS.setPortNumber(FAKE_PORT_NUMBER);
	}

	private static final User USER = new User();
	static {
		USER.setUserId(1L);
		USER.setUserName("maxime");
		USER.setPassword("M@xime1234");
	}

	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users/sign-up";

	private Constants() {

	}

	public static List<Relay> getRelays() {
		return SETTINGS.getRelays();
	}

	public static void updateDescription(Integer id, String description) {
		SETTINGS.getRelays().forEach(item -> {
			if (item.getId().equals(id)) {
				item.setDescription(description);
			}
		});
	}

	public static void updateIsOn(Integer id, Boolean isOn) {
		SETTINGS.getRelays().forEach(item -> {
			if (item.getId().equals(id)) {
				item.setIsOn(isOn);
			}
		});
	}

	public static Settings getSettings() {
		return SETTINGS;
	}

	public static Settings setSettings(Settings settings) {
		SETTINGS = settings;
		return settings;
	}

	public static User getUser() {
		return USER;
	}

}
