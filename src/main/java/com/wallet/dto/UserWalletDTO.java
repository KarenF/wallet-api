package com.wallet.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserWalletDTO {

	Long id;
	@NotNull(message = "informe o id do usuário")
	Long users;
	@NotNull(message = "informe o id da carteira")
	Long wallet;
}
