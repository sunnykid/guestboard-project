package kr.goodee.mem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name="mem",uniqueConstraints = {
        @UniqueConstraint(
                name="EMAIL_UNIQUE",
                columnNames={"mb_email"}
         )}       
      )
public class Member {
	
	public Member(String name, String nickname, String email) {
		this.mbName = name;
		this.mbNickName = nickname;
		this.mbEmail = email;
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mb_seq;
	
	@Column(name="mb_id")  //변수명과 컬럼명이 같은 경우 name 생략 가능
	private String mbId;
	
	@Column(name="mb_name")
	private String mbName;
	
	@Column(name="mb_nickname")
	private String mbNickName;
	
	@Column(name="mb_email")
	private String mbEmail;
}
