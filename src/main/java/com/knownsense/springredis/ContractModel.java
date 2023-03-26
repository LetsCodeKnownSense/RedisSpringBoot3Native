
package com.knownsense.springredis;

import com.knownsense.springredis.vo.ContractInfo;
import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Contract"
})
public class ContractModel implements Serializable {

    @JsonProperty("Contract")
    private List<ContractInfo> Contract = null;
    @JsonProperty("Contract")
    public List<ContractInfo> getContract() {
        return Contract;
    }
}
