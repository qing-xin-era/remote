package com.qing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRun {
    private int runID;
    private String runTaskName;
    private String runHeadName;
    private String runHeadID;
    private String runHeadTel;
    private String runTime;
    private String runSite;
    private String runCommitment;
    private  String taskNumber;
}
