package lu.maxime.kmtronicbridge.domain;

public class Relay {

	private Integer id;
	private String description;
	private Boolean isOn;

	public Relay() {
		super();
	}

	public Relay(Integer id, String description, Boolean isOn) {
		super();
		this.id = id;
		this.description = description;
		this.isOn = isOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsOn() {
		return isOn;
	}

	public void setIsOn(Boolean isOn) {
		this.isOn = isOn;
	}

}
