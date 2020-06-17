package com.project.bean;

import lombok.Data;

@Data
/**专家与会谈结果的连接对象*/
public class ConnectExperts {
    private Integer id;
    private Integer expertsId;
    private Integer discussId;

    public ConnectExperts() {
    }

    public ConnectExperts(Integer expertsId, Integer discussId) {
        this.expertsId = expertsId;
        this.discussId = discussId;
    }
}
