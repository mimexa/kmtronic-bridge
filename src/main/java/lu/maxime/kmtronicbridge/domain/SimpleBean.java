package lu.maxime.kmtronicbridge.domain;

public class SimpleBean<E> {

	private E value;

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

}
