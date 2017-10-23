package vo;

public class LogVO {
int id;
String logText;
public LogVO(int i,String s){
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
