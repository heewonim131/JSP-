package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {
	// 이메일 인증을 위해 외부 라이브러리 2가지 추가
	// JavaMail API & JavaBeans Activation Framework

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// 인증 메일을 보낼 관리자 자신의 아이디와 비밀번호 입력
		// 구글 > 보안 > 보안 수준이 낮은 앱의 액세스 > 허용(사용)
		return new PasswordAuthentication("heewonim131@gmail.com", "skdkrlgldhs");
	}
}
