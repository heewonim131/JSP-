package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {
	// �̸��� ������ ���� �ܺ� ���̺귯�� 2���� �߰�
	// JavaMail API & JavaBeans Activation Framework

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// ���� ������ ���� ������ �ڽ��� ���̵�� ��й�ȣ �Է�
		// ���� > ���� > ���� ������ ���� ���� �׼��� > ���(���)
		return new PasswordAuthentication("heewonim131@gmail.com", "skdkrlgldhs");
	}
}
