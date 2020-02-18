package com.wallet.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class WalletDTO {

	private Long id;
	@Length(min=3)
	@NotNull
	private String name;
	@NotNull
	private BigDecimal value;
}
