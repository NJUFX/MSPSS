package po;

public class LogPO {
int id;
String logText;
public LogPO(int i,String s){
	id = i;
	logText = s;
}
public int getId(){
	return id;
}
public String getLogText(){
	return logText;
}
}
