package com.stella.web.orderService.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class YearsBean {
	private List<Integer> years;
	private List<Integer> totalprice;
	private List<Integer> months;
}
