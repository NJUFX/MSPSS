package blservice.chiefmanagerblservice;

import java.util.ArrayList;
import vo.*;

/**
 * Created by HarperLiu on 17/10/18
 */
public interface ChiefManagerBLService {
	/*
	 * 检查用户操作权限
	 * 
	 * @param id 用户ID
	 * 
	 * @param serviceType 服务类型
	 * 
	 * @return 用户是否有权限的检查结果
	 */
	public boolean checkLimit(String id, String serviceType);

	/*
	 * 导出报表到本地
	 * 
	 * @param listVo 表单视图对象
	 * 
	 * @return
	 */
	public boolean exportList(ListVO listVO);

	/*
	 * 清空当前条件
	 * 
	 * @param
	 * 
	 * @return
	 */
	public boolean emptyCondition();

	/*
	 * 退出当前功能
	 * 
	 * @param
	 * 
	 * @return
	 */
	public void exit();

	/*
	 * 创建销售明细表表单
	 * 
	 * @param time 时间间隔
	 * 
	 * @param commodityName 商品
	 * 
	 * @param customerName 客户
	 * 
	 * @param salesmanName 业务员
	 * 
	 * @param warehouse 仓库
	 * 
	 * @return salesListVO 销售明细表表单视图对象
	 */
	public SalesListVO makeSalesList(String time, String commodityName, String customerName, String salesmanName,
			String warehouseName);

	/*
	 * 创建经营情况表表单
	 * 
	 * @param time 时间间隔
	 * 
	 * @return ManagerListVO 经营情况表表单视图对象
	 */
	public ManageListVO makeManageList(String time);

	/*
	 * 显示系统日志列表
	 * 
	 * @param
	 * 
	 * @return LogListVO 日志列表视图对象
	 */
	public LogListVO showLogList();

	/*
	 * 显示日志详细信息
	 * 
	 * @param id 日志编号
	 * 
	 * @return LogVO 日志视图对象
	 */
	public LogVO showLogDetail(int id);

	/*
	 * 显示待审批单据列表
	 * 
	 * @param isExamined 单据的审批属性
	 * 
	 * @return BillListVO 单据列表视图对象
	 */
	public BillListVO showBillList(boolean isExamined);

	/*
	 * 审批单据通过或不通过
	 * 
	 * @param billVOArray 存放单据视图对象的数组
	 * 
	 * @param pass 审批状态
	 * 
	 * @return
	 */
	public ArrayList<BillVO> changeBillState(ArrayList<BillVO> billVOArray, boolean pass);

	/*
	 * 更新数据库中的单据数据
	 * 
	 * @param billVOArray 存放单据视图的数组
	 * 
	 * @return
	 */
	public void updateBillData(ArrayList<BillVO> billVOArray);

	/*
	 * 显示单据详细信息
	 * 
	 * @param id 单据编号
	 * 
	 * @return BillVO 单据视图对象
	 * 
	 */
	public BillVO showBillDetail(String id);

	/*
	 * 选择促销策略类型
	 * 
	 * @param type 促销策略类型
	 * 
	 * @return PromotionVO 促销策略视图对象
	 */
	public PromotionVO choosePromotionType(String type);

	/*
	 * 设置促销策略起始时间
	 * 
	 * @param promotionVO 促销策略视图对象
	 * 
	 * @return PromotionVO 促销策略视图对象
	 */
	public PromotionVO setPromotionTime(PromotionVO promotionVO);

	/*
	 * 检查用户输入促销信息
	 * 
	 * @param promotionVO 促销策略视图对象
	 * 
	 * @return PromotionVO 促销策略视图对象
	 */
	public boolean checkPromotionInfo(PromotionVO promotionVO);

	/*
	 * 显示当前的促销策略列表
	 * 
	 * @param
	 * 
	 * @return PromotionListVO 促销策略列表视图对象
	 */
	public PromotionListVO ShowPromotionList();

	/*
	 * 更新数据库促销策略数据
	 * 
	 * @param promotionVO 促销策略视图对象
	 * 
	 * @return
	 */
	public void updatePromotionInfo(PromotionVO promotionVO);
}
