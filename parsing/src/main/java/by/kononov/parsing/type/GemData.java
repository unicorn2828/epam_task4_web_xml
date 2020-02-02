package by.kononov.parsing.type;

public enum GemData {
	GEM("gem"),
	GEMS("gems"),
	NAME("name"),
	PRECIOUSNESS("preciousness"),
	ORIGIN("origin"),
	DATE("date"),
	VALUE("value"),
	PARAMETERS("parameters"),
	COLOR("color"),
	TRANSPARENCE("transparence"),
	FACETS("facets");

	private String element;

	private GemData(String element) {
		this.element = element;
	}

	public String getElement() {
		return element;
	}
}