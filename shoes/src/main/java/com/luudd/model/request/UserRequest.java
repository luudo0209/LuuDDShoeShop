package com.luudd.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserRequest {
	
	@NotNull(message = "User name is required")
    @NotEmpty(message = "User name is required")
    @ApiModelProperty(
            example="Duc Luu",
            notes="User name cannot be empty",
            required=true
    )
	private String userName;
	
	@Pattern(regexp="(09|03)+([0-9]{8})\\b", message = "Please provide a valid phone number")
    @ApiModelProperty(
            example="0348614562",
            notes="Phone cannot be empty",
            required=true
    )
    private String phone;

}
