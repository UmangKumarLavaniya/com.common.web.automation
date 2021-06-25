package com.test.xyz;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author umangkumar
 *
 */
@Data
@NoArgsConstructor
public class TestRequestPojo {
	String orderNum;
	Integer quantity;
	String comments;
	String name;
	Address address;
}
