package com.qing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamTask {
    private int teamTaskID;
    private String teamTaskDetail;
    private String teamTaskHeadID;
    private String teamTaskHeadTel;
    private String teamTaskNumber;
    private String teamTaskProgress;
    private String teamTaskFileSrc;


}
