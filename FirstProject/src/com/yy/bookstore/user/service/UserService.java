package com.yy.bookstore.user.service;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.user.dao.UserDao;
import com.yy.bookstore.user.domain.User;
import com.yy.bookstore.user.service.exception.*;

import javax.mail.Authenticator;
import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
//import java.net.Authenticator;
//import java.net.PasswordAuthentication;
import java.sql.SQLException;
import java.util.Properties;

public class UserService{

    public User regist(User fromU) throws UserNameAlreadyExistException, EmailAlreadyExistException, UserNameNotStandardException {
        UserDao userDao=new UserDao();
        if(!(fromU.getUsername()).matches("[A-Z][a-zA-Z0-9]{2,9}")){
            throw new UserNameNotStandardException();
        }
        User fromDb = userDao.queryByUserName(fromU.getUsername());
        if (fromDb!=null){
            throw new UserNameAlreadyExistException();
        }
        if (userDao.queryByEmail(fromU.getEmail())!=null){
            throw new EmailAlreadyExistException();
        }

        userDao.insertUser(fromU);
        return fromU;
    }
    public User login(String username,String password) throws InvalidUserNameException, PasswordErrorException, UserNotActiveException {
        UserDao userDao=new UserDao();
        User fromDb = userDao.queryByUserName(username);
        if (fromDb==null){
            throw new InvalidUserNameException();
        }
        if (!fromDb.getPassword().equals(password)){
            throw new PasswordErrorException();
        }
        if (fromDb.getState()==0){
            throw new UserNotActiveException();
        }
        return fromDb;
    }
    public void active(String code) throws CodeErrorException, CodeAlreadyActiveException, SQLException {
        UserDao userDao=new UserDao();
        User byCodeUser = userDao.queryByCode(code);
        if (byCodeUser==null){
            throw new CodeErrorException();
        }else if (byCodeUser!=null){
            int state = byCodeUser.getState();
            if (state==1){
                throw new CodeAlreadyActiveException();
            }
            if (state==0){
                userDao.updateState(byCodeUser.getUid(),1);
            }
        }
    }
    public void sendMail(String code,String email) throws MessagingException {
        String myEmailAccount = "1411374327@qq.com";
        String myEmailPassword = "otejikcllrrrfedj";
        String myEmailSMTPHost = "smtp.qq.com";
        String receiveMailAccount = email;
        Properties properties=new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", myEmailSMTPHost);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port","465");
        properties.setProperty("mail.smtp.ssl.enable","true");
        Authenticator authenticator=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmailAccount,myEmailPassword);
            }
        };
        Session session=Session.getInstance(properties,authenticator);
        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress(myEmailAccount));
        message.setRecipients(Message.RecipientType.TO,receiveMailAccount);
        message.setSubject("蓝鸥书城");
        message.setContent("<html><head ><meta charset='utf-8'>"
                        + "</head><body>内容：为了保证您的 蓝鸥书城 帐户的安全，请验证您的电子邮件地址。<br>"
                        + "<a href='http://192.168.11.210:8080/Yuanying/user?method=active&&code="+code+"'>点击此处来验证您的电子邮件地址。</a><br>" +
                        "验证您的电子邮件地址让您能够：使用 蓝鸥书城 令牌，更改您的蓝鸥书城帐户凭据，" +
                        "使用交易与市场确认，以及在您无法访问帐户或是忘记密码时，找回您的 蓝鸥书城 帐户。</body></html>",
                "text/html;charset=utf-8");
        Transport.send(message);
    }

}
