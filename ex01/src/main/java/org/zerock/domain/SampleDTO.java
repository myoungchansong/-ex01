package org.zerock.domain;

import lombok.Data;

/* Lombok�� @Data�� ��� 
 *  getter/ setter, equals(), toString()���� �ż��带 �ڵ� ������ �����ϴ�
 * */

@Data
public class SampleDTO {
	
	private String name;
	private int age;
	
}
