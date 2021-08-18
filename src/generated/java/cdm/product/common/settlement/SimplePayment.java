package cdm.product.common.settlement;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverImpl;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.observable.asset.Money;
import cdm.product.common.settlement.meta.SimplePaymentMeta;
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
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specified payments in a simpler fashion than the Payment type. This construct should be used from the FpML version 4.3 onwards.
 * @version ${project.version}
 */
@RosettaClass

public interface SimplePayment extends PartyReferencePayerReceiver, GlobalKey {
	SimplePayment build();
	SimplePayment.SimplePaymentBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 * The payment amount.
	 */
	Money getPaymentAmount();
	/**
	 * The payment date. This date is subject to adjustment in accordance with any applicable business day convention.
	 */
	AdjustableOrRelativeDate getPaymentDate();
	final static SimplePaymentMeta metaData = new SimplePaymentMeta();
	
	@Override
	default RosettaMetaData<? extends SimplePayment> metaData() {
		return metaData;
	} 
			
	static SimplePayment.SimplePaymentBuilder builder() {
		return new SimplePayment.SimplePaymentBuilderImpl();
	}
	
	default Class<? extends SimplePayment> getType() {
		return SimplePayment.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.party.PartyReferencePayerReceiver.super.process(path, processor);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("paymentAmount"), processor, Money.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
	}
	
	
	interface SimplePaymentBuilder extends SimplePayment, PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Money.MoneyBuilder getOrCreatePaymentAmount();
		Money.MoneyBuilder getPaymentAmount();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate();
		SimplePayment.SimplePaymentBuilder setMeta(MetaFields meta);
		SimplePayment.SimplePaymentBuilder setPaymentAmount(Money paymentAmount);
		SimplePayment.SimplePaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		SimplePayment.SimplePaymentBuilder setPayerAccountReference(ReferenceWithMetaAccount payerAccountReference);
		SimplePayment.SimplePaymentBuilder setPayerAccountReferenceValue(Account payerAccountReference);
		SimplePayment.SimplePaymentBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference);
		SimplePayment.SimplePaymentBuilder setPayerPartyReferenceValue(Party payerPartyReference);
		SimplePayment.SimplePaymentBuilder setReceiverAccountReference(ReferenceWithMetaAccount receiverAccountReference);
		SimplePayment.SimplePaymentBuilder setReceiverAccountReferenceValue(Account receiverAccountReference);
		SimplePayment.SimplePaymentBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference);
		SimplePayment.SimplePaymentBuilder setReceiverPartyReferenceValue(Party receiverPartyReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("paymentAmount"), processor, Money.MoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
		}
		
	}
	
	//SimplePayment.SimplePaymentImpl
	class SimplePaymentImpl extends PartyReferencePayerReceiver.PartyReferencePayerReceiverImpl implements SimplePayment {
		private final MetaFields meta;
		private final Money paymentAmount;
		private final AdjustableOrRelativeDate paymentDate;
		
		protected SimplePaymentImpl(SimplePayment.SimplePaymentBuilder builder) {
			super(builder);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Money getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public AdjustableOrRelativeDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public SimplePayment build() {
			return this;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder toBuilder() {
			SimplePayment.SimplePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimplePayment.SimplePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimplePayment _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimplePayment {" +
				"meta=" + this.meta + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate +
			'}' + " " + super.toString();
		}
	}
	
	//SimplePayment.SimplePaymentBuilderImpl
	class SimplePaymentBuilderImpl extends PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl  implements SimplePayment.SimplePaymentBuilder, GlobalKeyBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected Money.MoneyBuilder paymentAmount;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder paymentDate;
	
		public SimplePaymentBuilderImpl() {
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
		public Money.MoneyBuilder getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePaymentAmount() {
			Money.MoneyBuilder result;
			if (paymentAmount!=null) {
				result = paymentAmount;
			}
			else {
				result = paymentAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SimplePayment.SimplePaymentBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public SimplePayment.SimplePaymentBuilder setPaymentAmount(Money paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		public SimplePayment.SimplePaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		public SimplePayment.SimplePaymentBuilder setPayerAccountReference(ReferenceWithMetaAccount payerAccountReference) {
			this.payerAccountReference = payerAccountReference==null?null:payerAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder setPayerAccountReferenceValue(Account payerAccountReference) {
			this.getOrCreatePayerAccountReference().setValue(payerAccountReference);
			return this;
		}
		@Override
		public SimplePayment.SimplePaymentBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference) {
			this.payerPartyReference = payerPartyReference==null?null:payerPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder setPayerPartyReferenceValue(Party payerPartyReference) {
			this.getOrCreatePayerPartyReference().setValue(payerPartyReference);
			return this;
		}
		@Override
		public SimplePayment.SimplePaymentBuilder setReceiverAccountReference(ReferenceWithMetaAccount receiverAccountReference) {
			this.receiverAccountReference = receiverAccountReference==null?null:receiverAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder setReceiverAccountReferenceValue(Account receiverAccountReference) {
			this.getOrCreateReceiverAccountReference().setValue(receiverAccountReference);
			return this;
		}
		@Override
		public SimplePayment.SimplePaymentBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference) {
			this.receiverPartyReference = receiverPartyReference==null?null:receiverPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder setReceiverPartyReferenceValue(Party receiverPartyReference) {
			this.getOrCreateReceiverPartyReference().setValue(receiverPartyReference);
			return this;
		}
		
		@Override
		public SimplePayment build() {
			return new SimplePayment.SimplePaymentImpl(this);
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimplePayment.SimplePaymentBuilder prune() {
			super.prune();
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimplePayment.SimplePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SimplePayment.SimplePaymentBuilder o = (SimplePayment.SimplePaymentBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimplePayment _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimplePaymentBuilder {" +
				"meta=" + this.meta + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate +
			'}' + " " + super.toString();
		}
	}
}
