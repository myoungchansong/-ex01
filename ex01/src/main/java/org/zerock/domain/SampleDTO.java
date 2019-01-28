package org.zerock.domain;

import lombok.Data;

/* Lombok의 @Data를 사용 
 *  getter/ setter, equals(), toString()등의 매서드를 자동 생성이 가능하다
 * */

@Data
public class SampleDTO {
	
	private String name;
	private int age;
	
}
