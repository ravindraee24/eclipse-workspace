package com.onlinetutorialspoint.listener;

import com.onlinetutorialspoint.model.TemplateDTO;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobListener extends JobExecutionListenerSupport {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
           // System.out.println("In Completion Listener ..");
            //List<TemplateDTO> results = jdbcTemplate.query("SELECT template_id,template_label,dlt_ct_id,template_text,template_type,user_code,status,sender_code,approver_code,camp_type FROM progate_message_template",
                    //(rs,rowNum)->{
                       // return new TemplateDTO(  rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),
                       //         rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                   // }
           // );
            //results.forEach(System.out::println);
        }
    }
}
