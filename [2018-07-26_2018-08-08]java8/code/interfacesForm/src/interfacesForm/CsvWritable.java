package interfacesForm;

public interface CsvWritable {
	String toCsvLine();
	void toCsvLine(StringBuilder sb);
}
