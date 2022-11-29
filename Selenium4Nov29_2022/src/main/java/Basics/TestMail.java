package Basics;

import utilities.MonitoringMail;
import utilities.TestConfig;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class TestMail {

	public static void main(String[] args) throws AddressException, MessagingException {


		
		MonitoringMail mail = new MonitoringMail();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);;

	}

}
