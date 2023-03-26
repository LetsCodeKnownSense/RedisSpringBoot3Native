package com.knownsense.springredis.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Contract_ID", "Contract_URL", "I_AGREE_CONTENT", "DESCRIPTION", "LOCALE", "VERSION", "CREATED_DATE",
		"CREATED_BY", "UPDATED_DATE", "UPDATED_BY", "Contract_CATEGORY", "Contract_GROUP_ID" })
public class ContractInfo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ContractInfo() {
	}

	@JsonProperty("Contract_ID")
	private Long ContractID;

	@JsonProperty("Contract_URL")
	private String ContractURL;

	@JsonProperty("I_AGREE_CONTENT")
	private String termsConditions;


	@JsonProperty("DESCRIPTION")
	private String description;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 *
	 * @JoinColumn(name = "LOCALE") private LocaleType locale;
	 */


	@JsonProperty("LOCALE")
	private String locale;


	@JsonProperty("VERSION")
	private Integer version;


	@JsonProperty("CREATED_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;


	@JsonProperty("CREATED_BY")
	private String createdBy;


	@JsonProperty("UPDATED_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedDate;


	@JsonProperty("Contract_CATEGORY")
	private String category;


	@JsonProperty("UPDATED_BY")
	private String updatedBy;


	@JsonProperty("Contract_GROUP_ID")
	private Long ContractGroupID;


	private String displayName;


}
