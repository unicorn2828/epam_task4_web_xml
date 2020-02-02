package by.kononov.parsing.entity;

import java.util.ArrayList;
import java.util.List;

public class Gems{

	private List<Gem> list = new ArrayList<>();

	public Gems() {
		super();
	}

	public List<Gem> getGems() {
		return list;
	}

	public boolean add(Gem gem) {
		return list.add(gem);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		Gems other = (Gems) obj;
		if (list == null) {
			if (other.list != null) {
				return false;
			}
		} else if (!list.equals(other.list)) {
			return false;
		}
		return true;
	}
}