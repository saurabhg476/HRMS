package com.hrms.api.res;

import com.hrms.constants.Constants;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRes {
    private boolean success;
    private String message;

    public static ServiceRes SomethingWentWrong(){
        ServiceRes response = new ServiceRes();
        response.setSuccess(false);
        response.setMessage(Constants.SOMETHING_WENT_WRONG);
        return response;
    }
}
