package Share.Dto;

public class MapperLovInformation {
	private String key;
	private Object value;
	
	public MapperLovInformation(String key, Object value) {
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public Object getValue() {
		return value;
	}
	
}
