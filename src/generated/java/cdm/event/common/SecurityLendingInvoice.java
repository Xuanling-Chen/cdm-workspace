package cdm.event.common;

import cdm.base.staticdata.party.Party;
import cdm.event.common.meta.SecurityLendingInvoiceMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the information required for inclusion in a securities lending billing invoice.
 * @version ${project.version}
 */
@RosettaClass

public interface SecurityLendingInvoice extends RosettaModelObject, GlobalKey {
	SecurityLendingInvoice build();
	SecurityLendingInvoice.SecurityLendingInvoiceBuilder toBuilder();
	
	/**
	 * The ending date of the period described by this invoice
	 */
	Date getBillingEndDate();
	/**
	 * The billing records contained within the invoice
	 */
	List<? extends BillingRecord> getBillingRecord();
	/**
	 * The starting date of the period described by this invoice
	 */
	Date getBillingStartDate();
	/**
	 * The billing summaries contained within the invoice
	 */
	List<? extends BillingSummary> getBillingSummary();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The party receiving the invoice
	 */
	Party getReceivingParty();
	/**
	 * The party issuing the invoice
	 */
	Party getSendingParty();
	final static SecurityLendingInvoiceMeta metaData = new SecurityLendingInvoiceMeta();
	
	@Override
	default RosettaMetaData<? extends SecurityLendingInvoice> metaData() {
		return metaData;
	} 
			
	static SecurityLendingInvoice.SecurityLendingInvoiceBuilder builder() {
		return new SecurityLendingInvoice.SecurityLendingInvoiceBuilderImpl();
	}
	
	default Class<? extends SecurityLendingInvoice> getType() {
		return SecurityLendingInvoice.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("billingEndDate"), Date.class, getBillingEndDate(), this);
		processor.processBasic(path.newSubPath("billingStartDate"), Date.class, getBillingStartDate(), this);
		
		processRosetta(path.newSubPath("billingRecord"), processor, BillingRecord.class, getBillingRecord());
		processRosetta(path.newSubPath("billingSummary"), processor, BillingSummary.class, getBillingSummary());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("receivingParty"), processor, Party.class, getReceivingParty());
		processRosetta(path.newSubPath("sendingParty"), processor, Party.class, getSendingParty());
	}
	
	
	interface SecurityLendingInvoiceBuilder extends SecurityLendingInvoice, RosettaModelObjectBuilder {
		BillingRecord.BillingRecordBuilder getOrCreateBillingRecord(int _index);
		List<? extends BillingRecord.BillingRecordBuilder> getBillingRecord();
		BillingSummary.BillingSummaryBuilder getOrCreateBillingSummary(int _index);
		List<? extends BillingSummary.BillingSummaryBuilder> getBillingSummary();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Party.PartyBuilder getOrCreateReceivingParty();
		Party.PartyBuilder getReceivingParty();
		Party.PartyBuilder getOrCreateSendingParty();
		Party.PartyBuilder getSendingParty();
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder setBillingEndDate(Date billingEndDate);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingRecord(BillingRecord billingRecord);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingRecord(BillingRecord billingRecord, int _idx);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingRecord(List<? extends BillingRecord> billingRecord);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder setBillingRecord(List<? extends BillingRecord> billingRecord);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder setBillingStartDate(Date billingStartDate);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingSummary(BillingSummary billingSummary);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingSummary(BillingSummary billingSummary, int _idx);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingSummary(List<? extends BillingSummary> billingSummary);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder setBillingSummary(List<? extends BillingSummary> billingSummary);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder setMeta(MetaFields meta);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder setReceivingParty(Party receivingParty);
		SecurityLendingInvoice.SecurityLendingInvoiceBuilder setSendingParty(Party sendingParty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("billingEndDate"), Date.class, getBillingEndDate(), this);
			processor.processBasic(path.newSubPath("billingStartDate"), Date.class, getBillingStartDate(), this);
			
			processRosetta(path.newSubPath("billingRecord"), processor, BillingRecord.BillingRecordBuilder.class, getBillingRecord());
			processRosetta(path.newSubPath("billingSummary"), processor, BillingSummary.BillingSummaryBuilder.class, getBillingSummary());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("receivingParty"), processor, Party.PartyBuilder.class, getReceivingParty());
			processRosetta(path.newSubPath("sendingParty"), processor, Party.PartyBuilder.class, getSendingParty());
		}
		
	}
	
	//SecurityLendingInvoice.SecurityLendingInvoiceImpl
	class SecurityLendingInvoiceImpl implements SecurityLendingInvoice {
		private final Date billingEndDate;
		private final List<? extends BillingRecord> billingRecord;
		private final Date billingStartDate;
		private final List<? extends BillingSummary> billingSummary;
		private final MetaFields meta;
		private final Party receivingParty;
		private final Party sendingParty;
		
		protected SecurityLendingInvoiceImpl(SecurityLendingInvoice.SecurityLendingInvoiceBuilder builder) {
			this.billingEndDate = builder.getBillingEndDate();
			this.billingRecord = ofNullable(builder.getBillingRecord()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.billingStartDate = builder.getBillingStartDate();
			this.billingSummary = ofNullable(builder.getBillingSummary()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.receivingParty = ofNullable(builder.getReceivingParty()).map(f->f.build()).orElse(null);
			this.sendingParty = ofNullable(builder.getSendingParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Date getBillingEndDate() {
			return billingEndDate;
		}
		
		@Override
		public List<? extends BillingRecord> getBillingRecord() {
			return billingRecord;
		}
		
		@Override
		public Date getBillingStartDate() {
			return billingStartDate;
		}
		
		@Override
		public List<? extends BillingSummary> getBillingSummary() {
			return billingSummary;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
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
		public SecurityLendingInvoice build() {
			return this;
		}
		
		@Override
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder toBuilder() {
			SecurityLendingInvoice.SecurityLendingInvoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityLendingInvoice.SecurityLendingInvoiceBuilder builder) {
			ofNullable(getBillingEndDate()).ifPresent(builder::setBillingEndDate);
			ofNullable(getBillingRecord()).ifPresent(builder::setBillingRecord);
			ofNullable(getBillingStartDate()).ifPresent(builder::setBillingStartDate);
			ofNullable(getBillingSummary()).ifPresent(builder::setBillingSummary);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getReceivingParty()).ifPresent(builder::setReceivingParty);
			ofNullable(getSendingParty()).ifPresent(builder::setSendingParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityLendingInvoice _that = getType().cast(o);
		
			if (!Objects.equals(billingEndDate, _that.getBillingEndDate())) return false;
			if (!ListEquals.listEquals(billingRecord, _that.getBillingRecord())) return false;
			if (!Objects.equals(billingStartDate, _that.getBillingStartDate())) return false;
			if (!ListEquals.listEquals(billingSummary, _that.getBillingSummary())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(receivingParty, _that.getReceivingParty())) return false;
			if (!Objects.equals(sendingParty, _that.getSendingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (billingEndDate != null ? billingEndDate.hashCode() : 0);
			_result = 31 * _result + (billingRecord != null ? billingRecord.hashCode() : 0);
			_result = 31 * _result + (billingStartDate != null ? billingStartDate.hashCode() : 0);
			_result = 31 * _result + (billingSummary != null ? billingSummary.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (receivingParty != null ? receivingParty.hashCode() : 0);
			_result = 31 * _result + (sendingParty != null ? sendingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityLendingInvoice {" +
				"billingEndDate=" + this.billingEndDate + ", " +
				"billingRecord=" + this.billingRecord + ", " +
				"billingStartDate=" + this.billingStartDate + ", " +
				"billingSummary=" + this.billingSummary + ", " +
				"meta=" + this.meta + ", " +
				"receivingParty=" + this.receivingParty + ", " +
				"sendingParty=" + this.sendingParty +
			'}';
		}
	}
	
	//SecurityLendingInvoice.SecurityLendingInvoiceBuilderImpl
	class SecurityLendingInvoiceBuilderImpl implements SecurityLendingInvoice.SecurityLendingInvoiceBuilder, GlobalKeyBuilder {
	
		protected Date billingEndDate;
		protected List<BillingRecord.BillingRecordBuilder> billingRecord = new ArrayList<>();
		protected Date billingStartDate;
		protected List<BillingSummary.BillingSummaryBuilder> billingSummary = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		protected Party.PartyBuilder receivingParty;
		protected Party.PartyBuilder sendingParty;
	
		public SecurityLendingInvoiceBuilderImpl() {
		}
	
		@Override
		public Date getBillingEndDate() {
			return billingEndDate;
		}
		
		@Override
		public List<? extends BillingRecord.BillingRecordBuilder> getBillingRecord() {
			return billingRecord;
		}
		
		public BillingRecord.BillingRecordBuilder getOrCreateBillingRecord(int _index) {
		
			if (billingRecord==null) {
				this.billingRecord = new ArrayList<>();
			}
			BillingRecord.BillingRecordBuilder result;
			return getIndex(billingRecord, _index, () -> {
						BillingRecord.BillingRecordBuilder newBillingRecord = BillingRecord.builder();
						return newBillingRecord;
					});
		}
		
		@Override
		public Date getBillingStartDate() {
			return billingStartDate;
		}
		
		@Override
		public List<? extends BillingSummary.BillingSummaryBuilder> getBillingSummary() {
			return billingSummary;
		}
		
		public BillingSummary.BillingSummaryBuilder getOrCreateBillingSummary(int _index) {
		
			if (billingSummary==null) {
				this.billingSummary = new ArrayList<>();
			}
			BillingSummary.BillingSummaryBuilder result;
			return getIndex(billingSummary, _index, () -> {
						BillingSummary.BillingSummaryBuilder newBillingSummary = BillingSummary.builder();
						return newBillingSummary;
					});
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
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
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder setBillingEndDate(Date billingEndDate) {
			this.billingEndDate = billingEndDate==null?null:billingEndDate;
			return this;
		}
		@Override
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingRecord(BillingRecord billingRecord) {
			if (billingRecord!=null) this.billingRecord.add(billingRecord.toBuilder());
			return this;
		}
		
		@Override
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingRecord(BillingRecord billingRecord, int _idx) {
			getIndex(this.billingRecord, _idx, () -> billingRecord.toBuilder());
			return this;
		}
		@Override 
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingRecord(List<? extends BillingRecord> billingRecords) {
			if (billingRecords != null) {
				for (BillingRecord toAdd : billingRecords) {
					this.billingRecord.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder setBillingRecord(List<? extends BillingRecord> billingRecords) {
			if (billingRecords == null)  {
				this.billingRecord = new ArrayList<>();
			}
			else {
				this.billingRecord = billingRecords.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder setBillingStartDate(Date billingStartDate) {
			this.billingStartDate = billingStartDate==null?null:billingStartDate;
			return this;
		}
		@Override
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingSummary(BillingSummary billingSummary) {
			if (billingSummary!=null) this.billingSummary.add(billingSummary.toBuilder());
			return this;
		}
		
		@Override
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingSummary(BillingSummary billingSummary, int _idx) {
			getIndex(this.billingSummary, _idx, () -> billingSummary.toBuilder());
			return this;
		}
		@Override 
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder addBillingSummary(List<? extends BillingSummary> billingSummarys) {
			if (billingSummarys != null) {
				for (BillingSummary toAdd : billingSummarys) {
					this.billingSummary.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder setBillingSummary(List<? extends BillingSummary> billingSummarys) {
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
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder setReceivingParty(Party receivingParty) {
			this.receivingParty = receivingParty==null?null:receivingParty.toBuilder();
			return this;
		}
		@Override
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder setSendingParty(Party sendingParty) {
			this.sendingParty = sendingParty==null?null:sendingParty.toBuilder();
			return this;
		}
		
		@Override
		public SecurityLendingInvoice build() {
			return new SecurityLendingInvoice.SecurityLendingInvoiceImpl(this);
		}
		
		@Override
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder prune() {
			billingRecord = billingRecord.stream().filter(b->b!=null).<BillingRecord.BillingRecordBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			billingSummary = billingSummary.stream().filter(b->b!=null).<BillingSummary.BillingSummaryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (receivingParty!=null && !receivingParty.prune().hasData()) receivingParty = null;
			if (sendingParty!=null && !sendingParty.prune().hasData()) sendingParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBillingEndDate()!=null) return true;
			if (getBillingRecord()!=null && getBillingRecord().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBillingStartDate()!=null) return true;
			if (getBillingSummary()!=null && getBillingSummary().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReceivingParty()!=null && getReceivingParty().hasData()) return true;
			if (getSendingParty()!=null && getSendingParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityLendingInvoice.SecurityLendingInvoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityLendingInvoice.SecurityLendingInvoiceBuilder o = (SecurityLendingInvoice.SecurityLendingInvoiceBuilder) other;
			
			merger.mergeRosetta(getBillingRecord(), o.getBillingRecord(), this::getOrCreateBillingRecord);
			merger.mergeRosetta(getBillingSummary(), o.getBillingSummary(), this::getOrCreateBillingSummary);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
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
		
			SecurityLendingInvoice _that = getType().cast(o);
		
			if (!Objects.equals(billingEndDate, _that.getBillingEndDate())) return false;
			if (!ListEquals.listEquals(billingRecord, _that.getBillingRecord())) return false;
			if (!Objects.equals(billingStartDate, _that.getBillingStartDate())) return false;
			if (!ListEquals.listEquals(billingSummary, _that.getBillingSummary())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(receivingParty, _that.getReceivingParty())) return false;
			if (!Objects.equals(sendingParty, _that.getSendingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (billingEndDate != null ? billingEndDate.hashCode() : 0);
			_result = 31 * _result + (billingRecord != null ? billingRecord.hashCode() : 0);
			_result = 31 * _result + (billingStartDate != null ? billingStartDate.hashCode() : 0);
			_result = 31 * _result + (billingSummary != null ? billingSummary.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (receivingParty != null ? receivingParty.hashCode() : 0);
			_result = 31 * _result + (sendingParty != null ? sendingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityLendingInvoiceBuilder {" +
				"billingEndDate=" + this.billingEndDate + ", " +
				"billingRecord=" + this.billingRecord + ", " +
				"billingStartDate=" + this.billingStartDate + ", " +
				"billingSummary=" + this.billingSummary + ", " +
				"meta=" + this.meta + ", " +
				"receivingParty=" + this.receivingParty + ", " +
				"sendingParty=" + this.sendingParty +
			'}';
		}
	}
}
