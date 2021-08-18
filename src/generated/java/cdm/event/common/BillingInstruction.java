package cdm.event.common;

import cdm.base.staticdata.party.Party;
import cdm.event.common.meta.BillingInstructionMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the instructions for creation of a Security Lending billing invoice.
 * @version ${project.version}
 */
@RosettaClass

public interface BillingInstruction extends RosettaModelObject {
	BillingInstruction build();
	BillingInstruction.BillingInstructionBuilder toBuilder();
	
	/**
	 * The ending date of the period described by this invoice
	 */
	Date getBillingEndDate();
	/**
	 * Instructions for creating the billing records contained within the invoice
	 */
	List<? extends BillingRecordInstruction> getBillingRecordInstruction();
	/**
	 * The starting date of the period described by this invoice
	 */
	Date getBillingStartDate();
	/**
	 * The billing summaries contained within the invoice
	 */
	List<? extends BillingSummaryInstruction> getBillingSummary();
	/**
	 * The party receiving the invoice
	 */
	Party getReceivingParty();
	/**
	 * The party issuing the invoice
	 */
	Party getSendingParty();
	final static BillingInstructionMeta metaData = new BillingInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends BillingInstruction> metaData() {
		return metaData;
	} 
			
	static BillingInstruction.BillingInstructionBuilder builder() {
		return new BillingInstruction.BillingInstructionBuilderImpl();
	}
	
	default Class<? extends BillingInstruction> getType() {
		return BillingInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("billingEndDate"), Date.class, getBillingEndDate(), this);
		processor.processBasic(path.newSubPath("billingStartDate"), Date.class, getBillingStartDate(), this);
		
		processRosetta(path.newSubPath("billingRecordInstruction"), processor, BillingRecordInstruction.class, getBillingRecordInstruction());
		processRosetta(path.newSubPath("billingSummary"), processor, BillingSummaryInstruction.class, getBillingSummary());
		processRosetta(path.newSubPath("receivingParty"), processor, Party.class, getReceivingParty());
		processRosetta(path.newSubPath("sendingParty"), processor, Party.class, getSendingParty());
	}
	
	
	interface BillingInstructionBuilder extends BillingInstruction, RosettaModelObjectBuilder {
		BillingRecordInstruction.BillingRecordInstructionBuilder getOrCreateBillingRecordInstruction(int _index);
		List<? extends BillingRecordInstruction.BillingRecordInstructionBuilder> getBillingRecordInstruction();
		BillingSummaryInstruction.BillingSummaryInstructionBuilder getOrCreateBillingSummary(int _index);
		List<? extends BillingSummaryInstruction.BillingSummaryInstructionBuilder> getBillingSummary();
		Party.PartyBuilder getOrCreateReceivingParty();
		Party.PartyBuilder getReceivingParty();
		Party.PartyBuilder getOrCreateSendingParty();
		Party.PartyBuilder getSendingParty();
		BillingInstruction.BillingInstructionBuilder setBillingEndDate(Date billingEndDate);
		BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(BillingRecordInstruction billingRecordInstruction);
		BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(BillingRecordInstruction billingRecordInstruction, int _idx);
		BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(List<? extends BillingRecordInstruction> billingRecordInstruction);
		BillingInstruction.BillingInstructionBuilder setBillingRecordInstruction(List<? extends BillingRecordInstruction> billingRecordInstruction);
		BillingInstruction.BillingInstructionBuilder setBillingStartDate(Date billingStartDate);
		BillingInstruction.BillingInstructionBuilder addBillingSummary(BillingSummaryInstruction billingSummary);
		BillingInstruction.BillingInstructionBuilder addBillingSummary(BillingSummaryInstruction billingSummary, int _idx);
		BillingInstruction.BillingInstructionBuilder addBillingSummary(List<? extends BillingSummaryInstruction> billingSummary);
		BillingInstruction.BillingInstructionBuilder setBillingSummary(List<? extends BillingSummaryInstruction> billingSummary);
		BillingInstruction.BillingInstructionBuilder setReceivingParty(Party receivingParty);
		BillingInstruction.BillingInstructionBuilder setSendingParty(Party sendingParty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("billingEndDate"), Date.class, getBillingEndDate(), this);
			processor.processBasic(path.newSubPath("billingStartDate"), Date.class, getBillingStartDate(), this);
			
			processRosetta(path.newSubPath("billingRecordInstruction"), processor, BillingRecordInstruction.BillingRecordInstructionBuilder.class, getBillingRecordInstruction());
			processRosetta(path.newSubPath("billingSummary"), processor, BillingSummaryInstruction.BillingSummaryInstructionBuilder.class, getBillingSummary());
			processRosetta(path.newSubPath("receivingParty"), processor, Party.PartyBuilder.class, getReceivingParty());
			processRosetta(path.newSubPath("sendingParty"), processor, Party.PartyBuilder.class, getSendingParty());
		}
		
	}
	
	//BillingInstruction.BillingInstructionImpl
	class BillingInstructionImpl implements BillingInstruction {
		private final Date billingEndDate;
		private final List<? extends BillingRecordInstruction> billingRecordInstruction;
		private final Date billingStartDate;
		private final List<? extends BillingSummaryInstruction> billingSummary;
		private final Party receivingParty;
		private final Party sendingParty;
		
		protected BillingInstructionImpl(BillingInstruction.BillingInstructionBuilder builder) {
			this.billingEndDate = builder.getBillingEndDate();
			this.billingRecordInstruction = ofNullable(builder.getBillingRecordInstruction()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.billingStartDate = builder.getBillingStartDate();
			this.billingSummary = ofNullable(builder.getBillingSummary()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.receivingParty = ofNullable(builder.getReceivingParty()).map(f->f.build()).orElse(null);
			this.sendingParty = ofNullable(builder.getSendingParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Date getBillingEndDate() {
			return billingEndDate;
		}
		
		@Override
		public List<? extends BillingRecordInstruction> getBillingRecordInstruction() {
			return billingRecordInstruction;
		}
		
		@Override
		public Date getBillingStartDate() {
			return billingStartDate;
		}
		
		@Override
		public List<? extends BillingSummaryInstruction> getBillingSummary() {
			return billingSummary;
		}
		
		@Override
		public Party getReceivingParty() {
			return receivingParty;
		}
		
		@Override
		public Party getSendingParty() {
			return sendingParty;
		}
		
		@Override
		public BillingInstruction build() {
			return this;
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder toBuilder() {
			BillingInstruction.BillingInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BillingInstruction.BillingInstructionBuilder builder) {
			ofNullable(getBillingEndDate()).ifPresent(builder::setBillingEndDate);
			ofNullable(getBillingRecordInstruction()).ifPresent(builder::setBillingRecordInstruction);
			ofNullable(getBillingStartDate()).ifPresent(builder::setBillingStartDate);
			ofNullable(getBillingSummary()).ifPresent(builder::setBillingSummary);
			ofNullable(getReceivingParty()).ifPresent(builder::setReceivingParty);
			ofNullable(getSendingParty()).ifPresent(builder::setSendingParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingInstruction _that = getType().cast(o);
		
			if (!Objects.equals(billingEndDate, _that.getBillingEndDate())) return false;
			if (!ListEquals.listEquals(billingRecordInstruction, _that.getBillingRecordInstruction())) return false;
			if (!Objects.equals(billingStartDate, _that.getBillingStartDate())) return false;
			if (!ListEquals.listEquals(billingSummary, _that.getBillingSummary())) return false;
			if (!Objects.equals(receivingParty, _that.getReceivingParty())) return false;
			if (!Objects.equals(sendingParty, _that.getSendingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (billingEndDate != null ? billingEndDate.hashCode() : 0);
			_result = 31 * _result + (billingRecordInstruction != null ? billingRecordInstruction.hashCode() : 0);
			_result = 31 * _result + (billingStartDate != null ? billingStartDate.hashCode() : 0);
			_result = 31 * _result + (billingSummary != null ? billingSummary.hashCode() : 0);
			_result = 31 * _result + (receivingParty != null ? receivingParty.hashCode() : 0);
			_result = 31 * _result + (sendingParty != null ? sendingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingInstruction {" +
				"billingEndDate=" + this.billingEndDate + ", " +
				"billingRecordInstruction=" + this.billingRecordInstruction + ", " +
				"billingStartDate=" + this.billingStartDate + ", " +
				"billingSummary=" + this.billingSummary + ", " +
				"receivingParty=" + this.receivingParty + ", " +
				"sendingParty=" + this.sendingParty +
			'}';
		}
	}
	
	//BillingInstruction.BillingInstructionBuilderImpl
	class BillingInstructionBuilderImpl implements BillingInstruction.BillingInstructionBuilder {
	
		protected Date billingEndDate;
		protected List<BillingRecordInstruction.BillingRecordInstructionBuilder> billingRecordInstruction = new ArrayList<>();
		protected Date billingStartDate;
		protected List<BillingSummaryInstruction.BillingSummaryInstructionBuilder> billingSummary = new ArrayList<>();
		protected Party.PartyBuilder receivingParty;
		protected Party.PartyBuilder sendingParty;
	
		public BillingInstructionBuilderImpl() {
		}
	
		@Override
		public Date getBillingEndDate() {
			return billingEndDate;
		}
		
		@Override
		public List<? extends BillingRecordInstruction.BillingRecordInstructionBuilder> getBillingRecordInstruction() {
			return billingRecordInstruction;
		}
		
		public BillingRecordInstruction.BillingRecordInstructionBuilder getOrCreateBillingRecordInstruction(int _index) {
		
			if (billingRecordInstruction==null) {
				this.billingRecordInstruction = new ArrayList<>();
			}
			BillingRecordInstruction.BillingRecordInstructionBuilder result;
			return getIndex(billingRecordInstruction, _index, () -> {
						BillingRecordInstruction.BillingRecordInstructionBuilder newBillingRecordInstruction = BillingRecordInstruction.builder();
						return newBillingRecordInstruction;
					});
		}
		
		@Override
		public Date getBillingStartDate() {
			return billingStartDate;
		}
		
		@Override
		public List<? extends BillingSummaryInstruction.BillingSummaryInstructionBuilder> getBillingSummary() {
			return billingSummary;
		}
		
		public BillingSummaryInstruction.BillingSummaryInstructionBuilder getOrCreateBillingSummary(int _index) {
		
			if (billingSummary==null) {
				this.billingSummary = new ArrayList<>();
			}
			BillingSummaryInstruction.BillingSummaryInstructionBuilder result;
			return getIndex(billingSummary, _index, () -> {
						BillingSummaryInstruction.BillingSummaryInstructionBuilder newBillingSummary = BillingSummaryInstruction.builder();
						return newBillingSummary;
					});
		}
		
		@Override
		public Party.PartyBuilder getReceivingParty() {
			return receivingParty;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateReceivingParty() {
			Party.PartyBuilder result;
			if (receivingParty!=null) {
				result = receivingParty;
			}
			else {
				result = receivingParty = Party.builder();
			}
			
			return result;
		}
		
		@Override
		public Party.PartyBuilder getSendingParty() {
			return sendingParty;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateSendingParty() {
			Party.PartyBuilder result;
			if (sendingParty!=null) {
				result = sendingParty;
			}
			else {
				result = sendingParty = Party.builder();
			}
			
			return result;
		}
		
	
		@Override
		public BillingInstruction.BillingInstructionBuilder setBillingEndDate(Date billingEndDate) {
			this.billingEndDate = billingEndDate==null?null:billingEndDate;
			return this;
		}
		@Override
		public BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(BillingRecordInstruction billingRecordInstruction) {
			if (billingRecordInstruction!=null) this.billingRecordInstruction.add(billingRecordInstruction.toBuilder());
			return this;
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(BillingRecordInstruction billingRecordInstruction, int _idx) {
			getIndex(this.billingRecordInstruction, _idx, () -> billingRecordInstruction.toBuilder());
			return this;
		}
		@Override 
		public BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(List<? extends BillingRecordInstruction> billingRecordInstructions) {
			if (billingRecordInstructions != null) {
				for (BillingRecordInstruction toAdd : billingRecordInstructions) {
					this.billingRecordInstruction.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public BillingInstruction.BillingInstructionBuilder setBillingRecordInstruction(List<? extends BillingRecordInstruction> billingRecordInstructions) {
			if (billingRecordInstructions == null)  {
				this.billingRecordInstruction = new ArrayList<>();
			}
			else {
				this.billingRecordInstruction = billingRecordInstructions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder setBillingStartDate(Date billingStartDate) {
			this.billingStartDate = billingStartDate==null?null:billingStartDate;
			return this;
		}
		@Override
		public BillingInstruction.BillingInstructionBuilder addBillingSummary(BillingSummaryInstruction billingSummary) {
			if (billingSummary!=null) this.billingSummary.add(billingSummary.toBuilder());
			return this;
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder addBillingSummary(BillingSummaryInstruction billingSummary, int _idx) {
			getIndex(this.billingSummary, _idx, () -> billingSummary.toBuilder());
			return this;
		}
		@Override 
		public BillingInstruction.BillingInstructionBuilder addBillingSummary(List<? extends BillingSummaryInstruction> billingSummarys) {
			if (billingSummarys != null) {
				for (BillingSummaryInstruction toAdd : billingSummarys) {
					this.billingSummary.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public BillingInstruction.BillingInstructionBuilder setBillingSummary(List<? extends BillingSummaryInstruction> billingSummarys) {
			if (billingSummarys == null)  {
				this.billingSummary = new ArrayList<>();
			}
			else {
				this.billingSummary = billingSummarys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder setReceivingParty(Party receivingParty) {
			this.receivingParty = receivingParty==null?null:receivingParty.toBuilder();
			return this;
		}
		@Override
		public BillingInstruction.BillingInstructionBuilder setSendingParty(Party sendingParty) {
			this.sendingParty = sendingParty==null?null:sendingParty.toBuilder();
			return this;
		}
		
		@Override
		public BillingInstruction build() {
			return new BillingInstruction.BillingInstructionImpl(this);
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingInstruction.BillingInstructionBuilder prune() {
			billingRecordInstruction = billingRecordInstruction.stream().filter(b->b!=null).<BillingRecordInstruction.BillingRecordInstructionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			billingSummary = billingSummary.stream().filter(b->b!=null).<BillingSummaryInstruction.BillingSummaryInstructionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (receivingParty!=null && !receivingParty.prune().hasData()) receivingParty = null;
			if (sendingParty!=null && !sendingParty.prune().hasData()) sendingParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBillingEndDate()!=null) return true;
			if (getBillingRecordInstruction()!=null && getBillingRecordInstruction().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBillingStartDate()!=null) return true;
			if (getBillingSummary()!=null && getBillingSummary().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReceivingParty()!=null && getReceivingParty().hasData()) return true;
			if (getSendingParty()!=null && getSendingParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingInstruction.BillingInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BillingInstruction.BillingInstructionBuilder o = (BillingInstruction.BillingInstructionBuilder) other;
			
			merger.mergeRosetta(getBillingRecordInstruction(), o.getBillingRecordInstruction(), this::getOrCreateBillingRecordInstruction);
			merger.mergeRosetta(getBillingSummary(), o.getBillingSummary(), this::getOrCreateBillingSummary);
			merger.mergeRosetta(getReceivingParty(), o.getReceivingParty(), this::setReceivingParty);
			merger.mergeRosetta(getSendingParty(), o.getSendingParty(), this::setSendingParty);
			
			merger.mergeBasic(getBillingEndDate(), o.getBillingEndDate(), this::setBillingEndDate);
			merger.mergeBasic(getBillingStartDate(), o.getBillingStartDate(), this::setBillingStartDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingInstruction _that = getType().cast(o);
		
			if (!Objects.equals(billingEndDate, _that.getBillingEndDate())) return false;
			if (!ListEquals.listEquals(billingRecordInstruction, _that.getBillingRecordInstruction())) return false;
			if (!Objects.equals(billingStartDate, _that.getBillingStartDate())) return false;
			if (!ListEquals.listEquals(billingSummary, _that.getBillingSummary())) return false;
			if (!Objects.equals(receivingParty, _that.getReceivingParty())) return false;
			if (!Objects.equals(sendingParty, _that.getSendingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (billingEndDate != null ? billingEndDate.hashCode() : 0);
			_result = 31 * _result + (billingRecordInstruction != null ? billingRecordInstruction.hashCode() : 0);
			_result = 31 * _result + (billingStartDate != null ? billingStartDate.hashCode() : 0);
			_result = 31 * _result + (billingSummary != null ? billingSummary.hashCode() : 0);
			_result = 31 * _result + (receivingParty != null ? receivingParty.hashCode() : 0);
			_result = 31 * _result + (sendingParty != null ? sendingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingInstructionBuilder {" +
				"billingEndDate=" + this.billingEndDate + ", " +
				"billingRecordInstruction=" + this.billingRecordInstruction + ", " +
				"billingStartDate=" + this.billingStartDate + ", " +
				"billingSummary=" + this.billingSummary + ", " +
				"receivingParty=" + this.receivingParty + ", " +
				"sendingParty=" + this.sendingParty +
			'}';
		}
	}
}
