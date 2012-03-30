package efaia.model;

public class Connection {
	final String id;
	final String label;
	final Node source;
	final Node destination;

	public Connection(String id, String label, Node source, Node destination) {
		this.id = id;
		this.label = label;
		this.source = source;
		this.destination = destination;
	}

	public String getLabel() {
		return label;
	}

	public Node getSource() {
		return source;
	}

	public Node getDestination() {
		return destination;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.source);
		sb.append("---");
		sb.append(this.destination);

		return sb.toString();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Connection))
			return false;
		Connection conn = (Connection) obj;
		return conn.source == source && conn.destination == destination;
	}

	public int hashCode() {
		int hash = 0;
		if (source != null)
			hash += source.hashCode();
		if (destination != null)
			hash += destination.hashCode();
		return hash;
	}

}
