package com.spring.model.dto;

import com.spring.annotation.Adult;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserCreateDto {
    @NotNull
    @Size(min = 6, max = 15)
    private String username;

    @NotNull
    @Size(min = 6, max = 15)
    private String userPassword;

    @NotNull
    @Adult
    private Integer age;
}
