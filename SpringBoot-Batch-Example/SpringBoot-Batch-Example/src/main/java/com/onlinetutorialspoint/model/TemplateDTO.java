package com.onlinetutorialspoint.model;

public class TemplateDTO {
 	private int template_id;
    /**
	 * @return the template_id
	 */
	public int getTemplate_id() {
		return template_id;
	}
	/**
	 * @param template_id the template_id to set
	 */
	public void setTemplate_id(int template_id) {
		this.template_id = template_id;
	}
	/**
	 * @return the template_label
	 */
	public String getTemplate_label() {
		return template_label;
	}
	/**
	 * @param template_label the template_label to set
	 */
	public void setTemplate_label(String template_label) {
		this.template_label = template_label;
	}
	/**
	 * @return the template_text
	 */
	public String getTemplate_text() {
		return template_text;
	}
	/**
	 * @param template_text the template_text to set
	 */
	public void setTemplate_text(String template_text) {
		this.template_text = template_text;
	}
	/**
	 * @return the template_type
	 */
	public String getTemplate_type() {
		return template_type;
	}
	/**
	 * @param template_type the template_type to set
	 */
	public void setTemplate_type(String template_type) {
		this.template_type = template_type;
	}
	/**
	 * @return the user_code
	 */
	public int getUser_code() {
		return user_code;
	}
	/**
	 * @param user_code the user_code to set
	 */
	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}
	/**
	 * @return the dlt_ct_id
	 */
	public long getDlt_ct_id() {
		return dlt_ct_id;
	}
	/**
	 * @param dlt_ct_id the dlt_ct_id to set
	 */
	public void setDlt_ct_id(long dlt_ct_id) {
		this.dlt_ct_id = dlt_ct_id;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the sender_code
	 */
	public int getSender_code() {
		return sender_code;
	}
	/**
	 * @param sender_code the sender_code to set
	 */
	public void setSender_code(int sender_code) {
		this.sender_code = sender_code;
	}
	/**
	 * @return the approver_code
	 */
	public int getApprover_code() {
		return approver_code;
	}
	/**
	 * @param approver_code the approver_code to set
	 */
	public void setApprover_code(int approver_code) {
		this.approver_code = approver_code;
	}
	/**
	 * @return the camp_type
	 */
	public String getCamp_type() {
		return camp_type;
	}
	/**
	 * @param camp_type the camp_type to set
	 */
	public void setCamp_type(String camp_type) {
		this.camp_type = camp_type;
	}
	private String template_label;
    public TemplateDTO(int template_id, String template_label, String template_text, String template_type,
			int user_code, long dlt_ct_id, int status, int sender_code, int approver_code, String camp_type) {
		super();
		this.template_id = template_id;
		this.template_label = template_label;
		this.template_text = template_text;
		this.template_type = template_type;
		this.user_code = user_code;
		this.dlt_ct_id = dlt_ct_id;
		this.status = status;
		this.sender_code = sender_code;
		this.approver_code = approver_code;
		this.camp_type = camp_type;
	}
	private String template_text;
    private String template_type;
    private int user_code;
    private long dlt_ct_id;
    private int status;
    private int sender_code;
    private int approver_code;
    private String camp_type;
public TemplateDTO() {
}
}