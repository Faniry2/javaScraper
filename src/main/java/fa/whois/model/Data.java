package fa.whois.model;

public class Data {

	private String  address="",
			type="",
			dateCreation="",
			state="",
			localisation="",
			reputation="",
			anonymat="",
		    usage="",
		    source="",
		    nomHote="";

	public String getAddress() {
		return address;
	}

	public Data setAddress(String address) {
		this.address = address;
		return this;
		
	}

	public String getType() {
		return type;
	}

	public Data setType(String type) {
		this.type = type;
		return this;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public Data setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
		return this;
	}

	public String getState() {
		return state;
	}

	public Data setState(String state) {
		this.state = state;
		return this;
	}

	public String getLocalisation() {
		return localisation;
		
	}

	public Data setLocalisation(String localisation) {
		this.localisation = localisation;
		return this;
	}

	public String getReputation() {
		return reputation;
	}

	public Data setReputation(String reputation) {
		this.reputation = reputation;
		return this;
	}

	public String getAnonymat() {
		return anonymat;
	}

	public Data setAnonymat(String anonymat) {
		this.anonymat = anonymat;
		return this;
	}

	public String getUsage() {
		return usage;
	}

	public Data setUsage(String usage) {
		this.usage = usage;
		return this;
	}

	public String getSource() {
		return source;
	}

	public Data setSource(String source) {
		this.source = source;
		return this;
	}

	public String getNomHote() {
		return nomHote;
	}

	public Data setNomHote(String nomHote) {
		this.nomHote = nomHote;
		return this;
	}
}
