package by.kononov.parsing.entity;

import java.time.LocalDateTime;

public class Gem{

	private String name;
	private String preciousness;
	private String origin;
	private LocalDateTime date;
	private int value;
	private Parameters parameters;

	public Gem() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreciousness() {
		return preciousness;
	}

	public void setPreciousness(String preciousness) {
		this.preciousness = preciousness;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
		result = prime * result + ((preciousness == null) ? 0 : preciousness.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Gem other = (Gem) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (origin == null) {
			if (other.origin != null) {
				return false;
			}
		} else if (!origin.equals(other.origin)) {
			return false;
		}
		if (parameters == null) {
			if (other.parameters != null) {
				return false;
			}
		} else if (!parameters.equals(other.parameters)) {
			return false;
		}
		if (preciousness == null) {
			if (other.preciousness != null) {
				return false;
			}
		} else if (!preciousness.equals(other.preciousness)) {
			return false;
		}
		if (value != other.value) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("[%s, name=%s, preciousness=%s, origin=%s, date=%s, parameters=%s, value=%s]",
				getClass().getSimpleName(), name, preciousness, origin, date, parameters, value);
	}
}
