package com.konvergion.personalfinance.expenseplansapi.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "currency")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrencyEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7398817190407696735L;

	@Id
	@Column(name="CRRNCY_CD", length = 10)
	private String currencyCode;
	
	@Column(name = "CRRNCY_NMRC_CD", length = 15)
	private int numericCode;
	
	@Column(name = "CRRNCY_DSCRPTN", length = 100)
	private String description;
}
