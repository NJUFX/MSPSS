package blstubdriver.financestubdriver;
import blservice.financeblservice.FinanceBLService;
import java.util.ArrayList;
import vo.*;
import status.*;
public class
FinanceBLService_Stub implements FinanceBLService{

	public Account_Operation_Status addAccount(AccountVO  account){
		System.out.println("add successfully!");
		return Account_Operation_Status.SUCCESS;
	}
	
	public Account_Operation_Status deleteAccount(AccountVO  account){
		System.out.println("delete successfully!");
		return Account_Operation_Status.SUCCESS;
	}
	
	public ArrayList<AccountVO> searchAccount(AccountFilterFlagsVO flags){
		System.out.println("Account has returned");
		return new ArrayList<AccountVO>();
	}
	
	public Account_Operation_Status modifyAccount(AccountVO  oldaccount,AccountVO newaccount){
		System.out.println("modify successfully!");
		return Account_Operation_Status.SUCCESS;
	}
	
	public Bill_Submit_Status submitIncomeBill(IncomeBillVO bill){
		System.out.println("IncomeBill has submitted successfully!");
		return Bill_Submit_Status.SUCCESS;
	}

	public Bill_Submit_Status submitPayBill(PayBillVO bill){
		System.out.println("PayBill has submitted successfully!");
		return Bill_Submit_Status.SUCCESS;
	}

	public ArrayList<BillVO> searchBusinessProcessTable(BusinessProcessTableFilterFlagsVO flags){
		System.out.println("Account has returned");
		return new ArrayList<BillVO>();
	}
	
	public Init_General_Account_Status initGeneralAccount(GeneralAccountVO generalaccount){
		System.out.println("Account has initialized successfully!");
		return Init_General_Account_Status.SUCCESS;
	}
	
	
}
