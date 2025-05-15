package com.stackroute.model;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Address {

    @NotNull(message = "house no is required")
    private String houseNo;

    @NotNull(message = "street name is required")
    private String streetName;

    @NotNull(message = "city is required")
    private String city;

    @NotNull(message = "state is required")
    private String state;

    @NotNull
    @Min(value = 5, message = "pincode should be of minimum 5 digit")
    @Max(value = 6, message = "pincode should be of maximum 6 digit")
    private String pincode;
}
