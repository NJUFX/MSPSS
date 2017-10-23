package vo;

public class ManageListVO extends ListVO{
double income;//收入类
double discount;//折让金额
double outcome;//支出类
double profit;
public ManageListVO(String t,double i,double d,double o){
	super(t);
	income = i;
	discount = d;
	outcome = o;
	profit = income-discount-outcome;
}
public double getIncome(){
	return income;
}
public double getOutcome(){
	return outcome;
}
public double getdiscount(){
	return discount;
}
public double getProfit(){
	return profit;
}
}
