package blstubdriver.financestubdriver;
import status.*;
import vo.*;
import java.util.ArrayList;
public class FinanceBLService_Driver {
    AccountVO avo = new AccountVO("王二",100,"李白","2017-10-1");
    AccountVO newavo = new AccountVO("王二",200,"杜甫","2017-10-8");
    AccountFilterFlagsVO affvo = new AccountFilterFlagsVO("第一季度总账","王二",new String[]{"2017-9-1","2017-10-1"});
    IncomeBillVO ibvo = new IncomeBillVO("SKD-yyyyMMdd-10000","2017-10-2","王二","白居易",new ArrayList<VirementVO>(),100);
    PayBillVO pbvo = new PayBillVO("XJFYD-yyyyMMdd-10000","2017-10-7","100000","杜甫",new ArrayList<TermSetVO>(),100);
    BusinessProcessTableFilterFlagsVO bptffvo = new BusinessProcessTableFilterFlagsVO(new String[]{"2017-10-8","2017-10-30"},"PayBill","王安石","67","1");
    GeneralAccountVO gavo = new GeneralAccountVO("2017公司总账","李白","2017-1-1",1000);

    public void driver(){
        System.out.println("Start Drivering");
        Account_Operation_Status aos;
        Bill_Submit_Status bss;
        Init_General_Account_Status igas;
        FinanceBLService_Stub stub = new FinanceBLService_Stub();
        ArrayList<AccountVO> avolist;
        ArrayList<BillVO> bvolist;
        //1
        aos = stub.addAccount(avo);
        if(aos==Account_Operation_Status.SUCCESS){
            System.out.println("Add account successfully!");
        }
        else{
            System.out.println("Fail to add account!");
        }
        //2
        aos = stub.deleteAccount(avo);
        if(aos==Account_Operation_Status.SUCCESS){
            System.out.println("Delete account successfully!");
        }
        else{
            System.out.println("Fail to delete account!");
        }

        //3
        avolist = stub.searchAccount(affvo);
        if(avolist!=null){
            System.out.println("There is some accounts that match your flags");
        }
        else{
            System.out.println("There is no account that matches your flags");

        }

        //4
        aos = stub.modifyAccount(avo,newavo);
        if(aos==Account_Operation_Status.SUCCESS){
            System.out.println("Modify account successfully!");
        }
        else{
            System.out.println("Fail to modify account!");
        }

        //5
        bss = stub.submitIncomeBill(ibvo);
        if(bss==Bill_Submit_Status.SUCCESS){
            System.out.println("submit IncomeBill successfully!");
        }
        else{
            System.out.println("Fail to submit IncomeBill!");
        }

        //6
        bss = stub.submitPayBill(pbvo);
        if(bss==Bill_Submit_Status.SUCCESS){
            System.out.println("submit PayBill successfully!");
        }
        else{
            System.out.println("Fail to submit PayBill!");
        }

        //7
        bvolist = stub.searchBusinessProcessTable(bptffvo);
        if(bvolist!=null){
            System.out.println("There is some bills that match your flags");
        }
        else{
            System.out.println("There is no bill that matches your flags");

        }

        //8
        igas = stub.initGeneralAccount(gavo);
        if(igas==Init_General_Account_Status.SUCCESS){
            System.out.println("Initialize general account successfully!");
        }
        else{
            System.out.println("Fail to Initialize general account!");
        }
    }

}
