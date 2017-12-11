package auxiliary.stockmanager;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Log {

	private SimpleStringProperty id = new SimpleStringProperty("");
	private SimpleStringProperty operator = new SimpleStringProperty("");
	private SimpleStringProperty time = new SimpleStringProperty("");
	private SimpleStringProperty kind = new SimpleStringProperty();

	public Log() {
		this("", "", "", "");
	}

	public Log(String i, String o, String t,String k) {
		setId(i);
		setOperator(o);
		setTime(t);
		setKind(k);
	}

	public void setKind(String k) {
		// TODO Auto-generated method stub
		kind.set(k);

	}

	public void setTime(String t) {
		// TODO Auto-generated method stub
		time.set(t);
	}

	public void setOperator(String o) {
		// TODO Auto-generated method stub
		operator.set(o);
	}

	public void setId(String i) {
		// TODO Auto-generated method stub
		id.set(i);
	}

	public String getId() {
		return id.get();
	}

	public String getOperator() {
		return operator.get();
	}

	public String getTime() {
		return time.get();
	}

	public String getKind() {
		return kind.get();
	}

}
