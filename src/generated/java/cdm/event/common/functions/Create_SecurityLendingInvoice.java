package cdm.event.common.functions;

import cdm.base.staticdata.party.Party;
import cdm.event.common.BillingInstruction;
import cdm.event.common.BillingRecord;
import cdm.event.common.BillingRecordInstruction;
import cdm.event.common.SecurityLendingInvoice;
import cdm.event.common.SecurityLendingInvoice.SecurityLendingInvoiceBuilder;
import cdm.event.common.functions.Create_BillingRecords;
import cdm.event.common.functions.Create_BillingSummary;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_SecurityLendingInvoice.Create_SecurityLendingInvoiceDefault.class)
public abstract class Create_SecurityLendingInvoice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_BillingRecords create_BillingRecords;
	@Inject protected Create_BillingSummary create_BillingSummary;

	/**
	* @param instruction Specifies the instructions for creation of a Security Lending billing invoice.
	* @return invoice Produces the Security Lending Invoice
	*/
	public SecurityLendingInvoice evaluate(BillingInstruction instruction) {
		
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder invoiceHolder = doEvaluate(instruction);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder invoice = assignOutput(invoiceHolder, instruction);
		
		if (invoice!=null) objectValidator.validateAndFailOnErorr(SecurityLendingInvoice.class, invoice);
		return invoice;
	}
	
	private SecurityLendingInvoice.SecurityLendingInvoiceBuilder assignOutput(SecurityLendingInvoice.SecurityLendingInvoiceBuilder invoice, BillingInstruction instruction) {
		invoice
			.setSendingParty(MapperS.of(instruction).<Party>map("getSendingParty", _billingInstruction -> _billingInstruction.getSendingParty()).get())
		;
		invoice
			.setReceivingParty(MapperS.of(instruction).<Party>map("getReceivingParty", _billingInstruction -> _billingInstruction.getReceivingParty()).get())
		;
		invoice
			.setBillingStartDate(MapperS.of(instruction).<Date>map("getBillingStartDate", _billingInstruction -> _billingInstruction.getBillingStartDate()).get())
		;
		invoice
			.setBillingEndDate(MapperS.of(instruction).<Date>map("getBillingEndDate", _billingInstruction -> _billingInstruction.getBillingEndDate()).get())
		;
		invoice
			.addBillingRecord(MapperC.of(create_BillingRecords.evaluate(MapperS.of(instruction).<BillingRecordInstruction>mapC("getBillingRecordInstruction", _billingInstruction -> _billingInstruction.getBillingRecordInstruction()).getMulti())).getMulti())
		;
		invoice
			.addBillingSummary(MapperS.of(create_BillingSummary.evaluate(MapperS.of(invoice).<BillingRecord>mapC("getBillingRecord", _securityLendingInvoice -> _securityLendingInvoice.getBillingRecord()).getMulti())).get())
		;
		return invoice;
	}

	protected abstract SecurityLendingInvoice.SecurityLendingInvoiceBuilder doEvaluate(BillingInstruction instruction);
	
	public static final class Create_SecurityLendingInvoiceDefault extends Create_SecurityLendingInvoice {
		@Override
		protected  SecurityLendingInvoice.SecurityLendingInvoiceBuilder doEvaluate(BillingInstruction instruction) {
			return SecurityLendingInvoice.builder();
		}
	}
}
