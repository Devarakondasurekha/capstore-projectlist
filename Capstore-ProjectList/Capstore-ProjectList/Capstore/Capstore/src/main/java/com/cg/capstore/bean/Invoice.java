package com.cg.capstore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice
{
	@Id
	@Column(name="invoice_id")
	private String invoiceId;
	@Column(name="payment_options")
	private String paymentOptions;
	@Column(name="transaction_id")
	private long transactionId;
	
	public Invoice() 
	{
		super();
	}

	public Invoice(String invoiceId, String paymentOptions, long transactionId) {
		super();
		this.invoiceId = invoiceId;
		this.paymentOptions = paymentOptions;
		this.transactionId = transactionId;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getPaymentOptions() {
		return paymentOptions;
	}

	public void setPaymentOptions(String paymentOptions) {
		this.paymentOptions = paymentOptions;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", paymentOptions=" + paymentOptions + ", transactionId="
				+ transactionId + "]";
	}


	
	
}
