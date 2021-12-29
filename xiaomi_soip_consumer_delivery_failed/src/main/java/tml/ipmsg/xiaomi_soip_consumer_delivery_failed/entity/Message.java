package tml.ipmsg.xiaomi_soip_consumer_delivery_failed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;

import javax.persistence.Column;;
@Entity()
@Table(name = "yulore_message_Request") 
public class Message implements Serializable{
	 private static final long serialVersionUID = -2736911235490297622L;
	@Id
	private long id;
	private String bizNum;
	private String phone;
	private String content;
	private String bizMsgId;
	private int message_type;
	private String bizExtra;
	private String dlttemplateid;
	private long client_id;
	private String msgId;
	private String status;
	private int credit_used;
	private String response;
	private String unicode;
	private String pdujsonFormat;
	private String delivery_status;
	public String getBizNum() {
		return bizNum;
	}
	public void setBizNum(String bizNum) {
		this.bizNum = bizNum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBizMsgId() {
		return bizMsgId;
	}
	public void setBizMsgId(String bizMsgId) {
		this.bizMsgId = bizMsgId;
	}
	public String getBizExtra() {
		return bizExtra;
	}
	public void setBizExtra(String bizExtra) {
		this.bizExtra = bizExtra;
	}
	public String getDlttemplateid() {
		return dlttemplateid;
	}
	public void setDlttemplateid(String dlttemplateid) {
		this.dlttemplateid = dlttemplateid;
	}
	public long getClient_id() {
		return client_id;
	}
	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCredit_used() {
		return credit_used;
	}
	public void setCredit_used(int credit_used) {
		this.credit_used = credit_used;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getPdujsonFormat() {
		return pdujsonFormat;
	}
	public void setPdujsonFormat(String pdujsonFormat) {
		this.pdujsonFormat = pdujsonFormat;
	}
	public String getDelivery_status() {
		return delivery_status;
	}
	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", bizNum=" + bizNum + ", phone=" + phone + ", content=" + content + ", bizMsgId="
				+ bizMsgId + ", bizExtra=" + bizExtra + ", dlttemplateid=" + dlttemplateid + ", client_id=" + client_id
				+ ", msgId=" + msgId + ", status=" + status + ", credit_used=" + credit_used + ", response=" + response
				+ ", pdujsonFormat=" + pdujsonFormat + ", delivery_status=" + delivery_status + "]";
	}
	public int getMessage_type() {
		return message_type;
	}
	public void setMessage_type(int message_type) {
		this.message_type = message_type;
	}
	public String getUnicode() {
		return unicode;
	}
	public void setUnicode(String unicode) {
		this.unicode = unicode;
	}
	
}
