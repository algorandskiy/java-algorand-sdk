package com.algorand.algosdk.v2.client.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/*
	Fields for asset allocation, re-configuration, and destruction. A zero value for 
	asset-id indicates asset creation. A zero value for the params indicates asset 
	destruction. Definition: data/transactions/asset.go : AssetConfigTxnFields 
 */
public class TransactionAssetConfig {

	/*
		(xaid) ID of the asset being configured or empty if creating. 
	 */
	private long assetId;
	private boolean assetIdIsSet;
	@JsonProperty("asset-id")
	public void setAssetId(long assetId){
		this.assetId = assetId;
		assetIdIsSet = true;
	}
	@JsonProperty("asset-id")
	public Long getAssetId(){
		return assetIdIsSet ? assetId : null;
	}
	/*
		Check if has a value for assetId 
	 */	@JsonIgnore
	public boolean hasAssetId(){
		return assetIdIsSet;
	}

	private AssetParams params;
	private boolean paramsIsSet;
	@JsonProperty("params")
	public void setParams(AssetParams params){
		this.params = params;
		paramsIsSet = true;
	}
	@JsonProperty("params")
	public AssetParams getParams(){
		return paramsIsSet ? params : null;
	}
	/*
		Check if has a value for params 
	 */	@JsonIgnore
	public boolean hasParams(){
		return paramsIsSet;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null) return false;

		TransactionAssetConfig other = (TransactionAssetConfig) o;
		if (!Objects.deepEquals(this.assetId, other.assetId)) return false;
		if (!Objects.deepEquals(this.params, other.params)) return false;

		return true;
	}

	@Override
	public String toString() {
		ObjectMapper om = new ObjectMapper(); 
		String jsonStr;
		try {
			jsonStr = om.setSerializationInclusion(Include.NON_NULL).writeValueAsString(this);

		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage());
		}
		return jsonStr;
	}
}