package com.coshop.core.common.enums;

import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2023/12/13 23:17
 */
@Getter
public enum  GenderEnum {

    MALE("male","男士"),
    FEMALE("female","女士");

    String code;
    String message;

    GenderEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

   public static  String getMessageByCode(String code) {
       if (StringUtils.isEmpty(code)) {
           return null;
       }
       for (GenderEnum genderEnum : GenderEnum.values()) {
           if (genderEnum.code.equals(code)) {
               return genderEnum.message;
           }
       }
       return null;
   }

}
