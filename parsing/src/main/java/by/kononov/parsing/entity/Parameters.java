package by.kononov.parsing.entity;

public class Parameters{

	private String color;
	private int transparence;
	private int facets;

	public Parameters() {
		super();
	}

	public Parameters(String color, int transparence, int facets) {
		this.color = color;
		this.transparence = transparence;
		this.facets = facets;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTransparence() {
		return transparence;
	}

	public void setTransparence(int transparence) {
		this.transparence = transparence;
	}

	public int getFacets() {
		return facets;
	}

	public void setFacets(int facets) {
		this.facets = facets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + facets;
		result = prime * result + transparence;
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
		Parameters other = (Parameters) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (facets != other.facets || transparence != other.transparence) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("[%s: color=%s, transparence=%s, facets=%s]", getClass().getSimpleName(), color,
				transparence, facets);
	}
}
