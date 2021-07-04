package com.onlinetutorialspoint.processor;

import org.springframework.batch.item.ItemProcessor;
import com.onlinetutorialspoint.model.Template;
import com.onlinetutorialspoint.model.TemplateDTO;

public class TemplateProcessor implements ItemProcessor<Template, TemplateDTO> {

	@Override
	public TemplateDTO process(final Template template) throws Exception {
        System.out.println("Transforming Template(s) to TemplateDTO(s)..");
        final TemplateDTO templateDto = new TemplateDTO(template.getTemplate_id(),template.getTemplate_label(), template.getTemplate_text(), template.getTemplate_type(),
        		template.getUser_code(), template.getDlt_ct_id(),template.getStatus(), template.getSender_code(), template.getApprover_code(), template.getCamp_type());

        return templateDto;
    }


}
