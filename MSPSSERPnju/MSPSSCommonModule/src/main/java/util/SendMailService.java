package util;

import java.util.Properties;

/**
 * Description:
 * Created by Hanxinhu at 7:48 2018/1/3/003
 */
public interface SendMailService {


    /**
     * 实现发送邮件的功能
     * @param receiverName 收件人称呼
     * @param receiverAddress 收件人地址
     * @param subject 主题
     * @param content 内容
     * @return 是否发送成功
     */
    public ResultMessage sendMail(String receiverName,String receiverAddress,String subject,String content);
}
