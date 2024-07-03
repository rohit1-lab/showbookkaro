package com.rohit.showBookKaro.requests;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterationRequest {

@NotEmpty(message = "First name is mandatory")
@NotBlank(message = "First name is mandatory")
private String firstName;

    @NotEmpty(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
private String lastName;
    @NotEmpty(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    @Email(message = "Email is not formatted")
private String email;

    @NotEmpty(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    @Size(min = 8, message ="Password should be alteast 6 characters long")
private String password;


}
