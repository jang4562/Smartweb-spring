package kr.green.spring.vo;

public class AccountVo {
	//멤버변수의 이름은 테이블 속성의 이름과 일치시켜주는것이 좋다.
	//단 필수는 아니지만 일치하지 않으면 Mapper에서 추가 작업을 해야한다.	
	private String id;
	private String pw;
	private String email;
	
	// 카멜표기법 두단어가 겹칠때 첫단어의 첫글자는 소문자, 두번째단어의 첫글자는 대문자	
	// 우측마우스 source -> 제너레이터 겟터,셋터 클릭후 셀렉트올로 호출
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + "]";
	}
}
