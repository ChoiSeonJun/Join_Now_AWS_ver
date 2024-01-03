package com.exam.dto;

import org.apache.ibatis.type.Alias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Alias("TestDTO")
public class TestDTO {
	int id;
	int pw;
	
	public TestDTO(int id, int pw) {
		this.id = id;
		this.pw = pw;
	}
	
}
