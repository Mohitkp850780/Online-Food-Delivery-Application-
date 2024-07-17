/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yumxpress.util;

import Yumxpress.pojo.CustomerPojo;
import Yumxpress.pojo.OrderPojo;
import Yumxpress.pojo.StaffPojo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class MyAuthenticator extends Authenticator{
    private String username,password;
    public MyAuthenticator(String username,String password){
        this.username=username;
        this.password=password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        PasswordAuthentication pwdAuth=new PasswordAuthentication(this.username,this.password);        
        return pwdAuth;
    }

}

public class Mailer {
    private static Properties prop;
    static {
        prop=new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
    }
    public static void sendMail(Map<String,String>emailCredentials,StaffPojo staff)throws MessagingException{
        final String username=emailCredentials.get("emailId");
        final String password=emailCredentials.get("securityKey");
        MyAuthenticator myAuth=new MyAuthenticator(username,password);        
        Session session = Session.getInstance(prop,myAuth); 
        Message message = new MimeMessage(session);
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(staff.getEmailId())
            );
            String emailSubject="Staff Details";
            String emailBody="Dear"+staff.getStaffName()+"\n"
                    +"\n"
                    +"I hope this email finds you well."+"\n"
                    + "\n"
                    +"Staff Id:"+staff.getStaffId()+"\n"
                    +"Company Name:"+OwnerProfile.getCompanyName()+"\n"
                    +"Email Id:"+staff.getEmailId()+"\n"
                    +"Staff Password:"+PasswordEncryption.getDecryptedPassword(staff.getPassword())+"\n"
                    +"\n"
                    +"These details are cruicial for internal record"+"\n"
                    +"\n"
                    +"Best regards,"+"\n"
                    +OwnerProfile.getOwnerName();
            message.setSubject(emailSubject);
            message.setText(emailBody);
            
            Transport.send(message);
            
            
           
        
        
        
    }
     public static void sendMail(Map<String,String>emailCredentials,CustomerPojo customer)throws MessagingException{
        final String username=emailCredentials.get("emailId");
        final String password=emailCredentials.get("securityKey");
        MyAuthenticator myAuth=new MyAuthenticator(username,password);        
        Session session = Session.getInstance(prop,myAuth); 
        Message message = new MimeMessage(session);
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(customer.getEmailId())
            );
            String emailSubject="Staff Details";
            String emailBody="Dear"+customer.getCustomerName()+"\n"
                    +"\n"
                    +"we are happy to have as our esteemed customer.please find your account info :\n"
                    + "\n"
                    +"Customer Id:"+customer.getCustomerId()+"\n"
                    +"your Name:"+customer.getCustomerName()+"\n"
                    +"Email Id(loginid):"+customer.getEmailId()+"\n"
                    +"initial Password:"+PasswordEncryption.getDecryptedPassword(customer.getPassword())+"\n"
                    +"\n"
                    +"Happy Hunger!!!\n"
                    +"\n"
                    +"Best regards,"+"\n"
                    +"Yumxpress!";
            message.setSubject(emailSubject);
            message.setText(emailBody);
            
            Transport.send(message);
            
            
           
        
        
        
    }
      public static void sendMail(Map<String,String>emailCredentials,OrderPojo order)throws MessagingException{
           final String username=emailCredentials.get("emailId");
        final String password=emailCredentials.get("securityKey");
        MyAuthenticator myAuth=new MyAuthenticator(username,password);        
        Session session = Session.getInstance(prop,myAuth); 
        Message message = new MimeMessage(session);
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(UserProfile.getEmailId())
            );
            double taxRate=0.075;
            double taxAmt=order.getProductPrice()*taxRate;
            double billAmount=order.getProductPrice()+taxAmt;
            Date today=new Date();
     
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
            String orderDate=sdf.format(today);
            
            
            String emailSubject="Order Confirmation Mail!";
            
            String emailBody="Dear"+order.getCustomerName()+"\n";
                   emailBody+="\n Following are your order details:\n";
                   emailBody+="\nOrderId:"+order.getOrderId()+"\n";
                   emailBody+="\nProduct Name:"+order.getProductName()+"\n";
                   emailBody+="\nCompany:"+order.getCompanyName()+"\n";
                   emailBody+="\nCompany email:"+order.getCompanyEmailId()+"\n";
                   emailBody+="\nProductPrice:"+order.getProductPrice()+"\n";
                   emailBody+="\nTax Amt:"+taxAmt+"\n";
                   emailBody+="\nbill Amt:"+billAmount+"\n";
                   emailBody+="\nDeliveryStaffName:"+order.getDeliveryStaffName()+"\n";
                   emailBody+="\nOTP:"+order.getOtp()+"\n";
                   emailBody+="\nPlease share this OTP to delivery staff\n";
                   emailBody+="\nOrderDate:"+orderDate+"\n";
                   emailBody+="\nThank You for Ordering!!\n\nHappyHunger!";
                   
             message.setSubject(emailSubject);
             message.setText(emailBody);
             Transport.send(message);
             
             
      }

    public static void sendMail(OrderPojo ord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
