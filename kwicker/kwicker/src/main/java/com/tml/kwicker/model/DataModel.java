package com.tml.kwicker.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DataModel {
	@Id
private String	message_id;
public String getMessage_id() {
	return message_id;
}
public void setMessage_id(String message_id) {
	this.message_id = message_id;
}
public String getRecpient() {
	return recpient;
}
public void setRecpient(String recpient) {
	this.recpient = recpient;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getDlr_state() {
	return dlr_state;
}
public void setDlr_state(String dlr_state) {
	this.dlr_state = dlr_state;
}
public String getDone_date() {
	return done_date;
}
public void setDone_date(String done_date) {
	this.done_date = done_date;
}
public String getSubmission_date() {
	return submission_date;
}
public void setSubmission_date(String submission_date) {
	this.submission_date = submission_date;
}
public String getSender_name() {
	return sender_name;
}
public void setSender_name(String sender_name) {
	this.sender_name = sender_name;
}
public String getMessage_pdu() {
	return message_pdu;
}
public void setMessage_pdu(String message_pdu) {
	this.message_pdu = message_pdu;
}
private String	recpient;
private String	description;
private String	dlr_state;
private String	done_date;
private String	submission_date;
private String	sender_name;
private String	message_pdu;

}
