package com.qing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int taskID;
    private String taskName;
    private String taskDetail;
    private String taskTime;
    private String taskSite;
    private String taskNumber;
}
