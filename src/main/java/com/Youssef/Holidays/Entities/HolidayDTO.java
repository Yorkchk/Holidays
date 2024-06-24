package com.Youssef.Holidays.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayDTO {

    private Long HolyId;

    private Status StatusCD = Status.InProgress;

    private Status StatusRH = Status.InProgress;
}
