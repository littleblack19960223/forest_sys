package com.project.bean;

import lombok.Data;

import java.sql.Date;
import java.util.List;
/**专家会商表*/
@Data
public class DiscussBean {
    private Integer discussId;
    /**会商时间*/
    private Date discussdate;
    /**会商人员*/
    private String personnel;
    /**会商结果*/
    private String resultTxt;
}
