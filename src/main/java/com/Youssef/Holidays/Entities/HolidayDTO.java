package com.Youssef.Holidays.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayDTO {

    private Long HolyId;

    private Status status = Status.InProgress;

//    public Status convertStringToStatus(String str) throws Exception {
//        Status status1 = null;
//        try {
//            if (str.equals("InProgress")) {
//                status1 = Status.InProgress;
//            } else if (str.equals("Validated")) {
//                status1 = Status.Validated;
//            } else if (str.equals("Rejected")) {
//                status1 = Status.Rejected;
//            } else {
//                throw new Exception();
//            }
//        } catch (Exception e) {
//            System.out.println("The status does not exist");
//        }
//        return status1;
//    }
}
