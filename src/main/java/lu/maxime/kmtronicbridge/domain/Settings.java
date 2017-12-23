package lu.maxime.kmtronicbridge.domain;

import java.util.List;

public class Settings {

	private List<Relay> relays;
	private String url;
	private Integer portNumber;

	public List<Relay> getRelays() {
		return relays;
	}

	public void setRelays(List<Relay> relays) {
		this.relays = relays;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(Integer portNumber) {
		this.portNumber = portNumber;
	}

}
