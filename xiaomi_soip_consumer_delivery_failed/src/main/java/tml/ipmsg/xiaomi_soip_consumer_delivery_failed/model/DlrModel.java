package tml.ipmsg.xiaomi_soip_consumer_delivery_failed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yulore_delivery_receipt")
public class DlrModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="msgid")
	private String transactionid;
	@Column(name="reciepientid")
	private String recieptid;
	@Column(name="phone")
	private String recipient;
	@Column(name="biznum")
	private String sender;
	@Column(name="description")
	private String description;
	@Column(name="totalpdu")
	private String totalpdu;
	@Column(name="message")
	private String message;
	@Column(name="status")
	private String deliverystatus;
	@Column(name="recvtm")
	private String deliverydt;
	@Column(name="senttm")
	private String submitdt;
	@Column(name="bizextra")
	private String corelationid;
	@Column(name="account")
	private String Account;
	@Column(name="source")
	private String source;
	
	/*@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERTTIME")
	@CreationTimestamp
	private Date INSERTTIME;*/
	
	//private String deliverydate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getRecieptid() {
		return recieptid;
	}

	public void setRecieptid(String recieptid) {
		this.recieptid = recieptid;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotalpdu() {
		return totalpdu;
	}

	public void setTotalpdu(String totalpdu) {
		this.totalpdu = totalpdu;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeliverystatus() {
		return deliverystatus;
	}

	public void setDeliverystatus(String deliverystatus) {
		this.deliverystatus = deliverystatus;
	}

	public String getDeliverydt() {
		return deliverydt;
	}

	public void setDeliverydt(String deliverydt) {
		this.deliverydt = deliverydt;
	}

	public String getSubmitdt() {
		return submitdt;
	}

	public void setSubmitdt(String submitdt) {
		this.submitdt = submitdt;
	}

	public String getCorelationid() {
		return corelationid;
	}

	public void setCorelationid(String corelationid) {
		this.corelationid = corelationid;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	/*public Date getINSERTTIME() {
		return INSERTTIME;
	}

	public void setINSERTTIME(Date iNSERTTIME) {
		INSERTTIME = iNSERTTIME;
	}

	public String getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}*/
}

