package cdm.product.template;

import cdm.base.datetime.RelativeDateOffset;
import cdm.base.math.Schedule;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilder;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilderImpl;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverImpl;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder;
import cdm.product.common.schedule.AmountSchedule;
import cdm.product.template.meta.ExerciseFeeScheduleMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to define a fee or schedule of fees to be payable on the exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised. As a difference with FpML, it extends the BuyerSeller class.
 * @version ${project.version}
 */
@RosettaClass

public interface ExerciseFeeSchedule extends PayerReceiver {
	ExerciseFeeSchedule build();
	ExerciseFeeSchedule.ExerciseFeeScheduleBuilder toBuilder();
	
	/**
	 * The exercise fee amount schedule. The fees are expressed as currency amounts. The currency of the fee is assumed to be that of the notional schedule referenced.
	 */
	AmountSchedule getFeeAmountSchedule();
	/**
	 * The date on which exercise fee(s) will be paid. It is specified as a relative date.
	 */
	RelativeDateOffset getFeePaymentDate();
	/**
	 * The exercise free rate schedule. The fees are expressed as percentage rates of the notional being exercised. The currency of the fee is assumed to be that of the notional schedule referenced.
	 */
	Schedule getFeeRateSchedule();
	/**
	 * A pointer style reference to the associated notional schedule defined elsewhere in the document.
	 */
	ReferenceWithMetaMoney getNotionalReference();
	final static ExerciseFeeScheduleMeta metaData = new ExerciseFeeScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends ExerciseFeeSchedule> metaData() {
		return metaData;
	} 
			
	static ExerciseFeeSchedule.ExerciseFeeScheduleBuilder builder() {
		return new ExerciseFeeSchedule.ExerciseFeeScheduleBuilderImpl();
	}
	
	default Class<? extends ExerciseFeeSchedule> getType() {
		return ExerciseFeeSchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.party.PayerReceiver.super.process(path, processor);
		
		processRosetta(path.newSubPath("feeAmountSchedule"), processor, AmountSchedule.class, getFeeAmountSchedule());
		processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.class, getFeePaymentDate());
		processRosetta(path.newSubPath("feeRateSchedule"), processor, Schedule.class, getFeeRateSchedule());
		processRosetta(path.newSubPath("notionalReference"), processor, ReferenceWithMetaMoney.class, getNotionalReference());
	}
	
	
	interface ExerciseFeeScheduleBuilder extends ExerciseFeeSchedule, PayerReceiver.PayerReceiverBuilder, RosettaModelObjectBuilder {
		AmountSchedule.AmountScheduleBuilder getOrCreateFeeAmountSchedule();
		AmountSchedule.AmountScheduleBuilder getFeeAmountSchedule();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFeePaymentDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getFeePaymentDate();
		Schedule.ScheduleBuilder getOrCreateFeeRateSchedule();
		Schedule.ScheduleBuilder getFeeRateSchedule();
		ReferenceWithMetaMoneyBuilder getOrCreateNotionalReference();
		ReferenceWithMetaMoneyBuilder getNotionalReference();
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeeAmountSchedule(AmountSchedule feeAmountSchedule);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeePaymentDate(RelativeDateOffset feePaymentDate);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeeRateSchedule(Schedule feeRateSchedule);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setNotionalReference(ReferenceWithMetaMoney notionalReference);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setNotionalReferenceValue(Money notionalReference);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayer(CounterpartyRoleEnum payer);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayerAncillaryRole(AncillaryRoleEnum payerAncillaryRole);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayerPartyReferenceValue(Party payerPartyReference);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiver(CounterpartyRoleEnum receiver);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiverAncillaryRole(AncillaryRoleEnum receiverAncillaryRole);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiverPartyReferenceValue(Party receiverPartyReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PayerReceiver.PayerReceiverBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("feeAmountSchedule"), processor, AmountSchedule.AmountScheduleBuilder.class, getFeeAmountSchedule());
			processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getFeePaymentDate());
			processRosetta(path.newSubPath("feeRateSchedule"), processor, Schedule.ScheduleBuilder.class, getFeeRateSchedule());
			processRosetta(path.newSubPath("notionalReference"), processor, ReferenceWithMetaMoneyBuilder.class, getNotionalReference());
		}
		
	}
	
	//ExerciseFeeSchedule.ExerciseFeeScheduleImpl
	class ExerciseFeeScheduleImpl extends PayerReceiver.PayerReceiverImpl implements ExerciseFeeSchedule {
		private final AmountSchedule feeAmountSchedule;
		private final RelativeDateOffset feePaymentDate;
		private final Schedule feeRateSchedule;
		private final ReferenceWithMetaMoney notionalReference;
		
		protected ExerciseFeeScheduleImpl(ExerciseFeeSchedule.ExerciseFeeScheduleBuilder builder) {
			super(builder);
			this.feeAmountSchedule = ofNullable(builder.getFeeAmountSchedule()).map(f->f.build()).orElse(null);
			this.feePaymentDate = ofNullable(builder.getFeePaymentDate()).map(f->f.build()).orElse(null);
			this.feeRateSchedule = ofNullable(builder.getFeeRateSchedule()).map(f->f.build()).orElse(null);
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AmountSchedule getFeeAmountSchedule() {
			return feeAmountSchedule;
		}
		
		@Override
		public RelativeDateOffset getFeePaymentDate() {
			return feePaymentDate;
		}
		
		@Override
		public Schedule getFeeRateSchedule() {
			return feeRateSchedule;
		}
		
		@Override
		public ReferenceWithMetaMoney getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public ExerciseFeeSchedule build() {
			return this;
		}
		
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder toBuilder() {
			ExerciseFeeSchedule.ExerciseFeeScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseFeeSchedule.ExerciseFeeScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFeeAmountSchedule()).ifPresent(builder::setFeeAmountSchedule);
			ofNullable(getFeePaymentDate()).ifPresent(builder::setFeePaymentDate);
			ofNullable(getFeeRateSchedule()).ifPresent(builder::setFeeRateSchedule);
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExerciseFeeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(feeAmountSchedule, _that.getFeeAmountSchedule())) return false;
			if (!Objects.equals(feePaymentDate, _that.getFeePaymentDate())) return false;
			if (!Objects.equals(feeRateSchedule, _that.getFeeRateSchedule())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeAmountSchedule != null ? feeAmountSchedule.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			_result = 31 * _result + (feeRateSchedule != null ? feeRateSchedule.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFeeSchedule {" +
				"feeAmountSchedule=" + this.feeAmountSchedule + ", " +
				"feePaymentDate=" + this.feePaymentDate + ", " +
				"feeRateSchedule=" + this.feeRateSchedule + ", " +
				"notionalReference=" + this.notionalReference +
			'}' + " " + super.toString();
		}
	}
	
	//ExerciseFeeSchedule.ExerciseFeeScheduleBuilderImpl
	class ExerciseFeeScheduleBuilderImpl extends PayerReceiver.PayerReceiverBuilderImpl  implements ExerciseFeeSchedule.ExerciseFeeScheduleBuilder {
	
		protected AmountSchedule.AmountScheduleBuilder feeAmountSchedule;
		protected RelativeDateOffset.RelativeDateOffsetBuilder feePaymentDate;
		protected Schedule.ScheduleBuilder feeRateSchedule;
		protected ReferenceWithMetaMoneyBuilder notionalReference;
	
		public ExerciseFeeScheduleBuilderImpl() {
		}
	
		@Override
		public AmountSchedule.AmountScheduleBuilder getFeeAmountSchedule() {
			return feeAmountSchedule;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder getOrCreateFeeAmountSchedule() {
			AmountSchedule.AmountScheduleBuilder result;
			if (feeAmountSchedule!=null) {
				result = feeAmountSchedule;
			}
			else {
				result = feeAmountSchedule = AmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getFeePaymentDate() {
			return feePaymentDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFeePaymentDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (feePaymentDate!=null) {
				result = feePaymentDate;
			}
			else {
				result = feePaymentDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		public Schedule.ScheduleBuilder getFeeRateSchedule() {
			return feeRateSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFeeRateSchedule() {
			Schedule.ScheduleBuilder result;
			if (feeRateSchedule!=null) {
				result = feeRateSchedule;
			}
			else {
				result = feeRateSchedule = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaMoneyBuilder getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public ReferenceWithMetaMoneyBuilder getOrCreateNotionalReference() {
			ReferenceWithMetaMoneyBuilder result;
			if (notionalReference!=null) {
				result = notionalReference;
			}
			else {
				result = notionalReference = ReferenceWithMetaMoney.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeeAmountSchedule(AmountSchedule feeAmountSchedule) {
			this.feeAmountSchedule = feeAmountSchedule==null?null:feeAmountSchedule.toBuilder();
			return this;
		}
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeePaymentDate(RelativeDateOffset feePaymentDate) {
			this.feePaymentDate = feePaymentDate==null?null:feePaymentDate.toBuilder();
			return this;
		}
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeeRateSchedule(Schedule feeRateSchedule) {
			this.feeRateSchedule = feeRateSchedule==null?null:feeRateSchedule.toBuilder();
			return this;
		}
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setNotionalReference(ReferenceWithMetaMoney notionalReference) {
			this.notionalReference = notionalReference==null?null:notionalReference.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setNotionalReferenceValue(Money notionalReference) {
			this.getOrCreateNotionalReference().setValue(notionalReference);
			return this;
		}
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayer(CounterpartyRoleEnum payer) {
			this.payer = payer==null?null:payer;
			return this;
		}
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayerAncillaryRole(AncillaryRoleEnum payerAncillaryRole) {
			this.payerAncillaryRole = payerAncillaryRole==null?null:payerAncillaryRole;
			return this;
		}
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference) {
			this.payerPartyReference = payerPartyReference==null?null:payerPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayerPartyReferenceValue(Party payerPartyReference) {
			this.getOrCreatePayerPartyReference().setValue(payerPartyReference);
			return this;
		}
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiver(CounterpartyRoleEnum receiver) {
			this.receiver = receiver==null?null:receiver;
			return this;
		}
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiverAncillaryRole(AncillaryRoleEnum receiverAncillaryRole) {
			this.receiverAncillaryRole = receiverAncillaryRole==null?null:receiverAncillaryRole;
			return this;
		}
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference) {
			this.receiverPartyReference = receiverPartyReference==null?null:receiverPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiverPartyReferenceValue(Party receiverPartyReference) {
			this.getOrCreateReceiverPartyReference().setValue(receiverPartyReference);
			return this;
		}
		
		@Override
		public ExerciseFeeSchedule build() {
			return new ExerciseFeeSchedule.ExerciseFeeScheduleImpl(this);
		}
		
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder prune() {
			super.prune();
			if (feeAmountSchedule!=null && !feeAmountSchedule.prune().hasData()) feeAmountSchedule = null;
			if (feePaymentDate!=null && !feePaymentDate.prune().hasData()) feePaymentDate = null;
			if (feeRateSchedule!=null && !feeRateSchedule.prune().hasData()) feeRateSchedule = null;
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFeeAmountSchedule()!=null && getFeeAmountSchedule().hasData()) return true;
			if (getFeePaymentDate()!=null && getFeePaymentDate().hasData()) return true;
			if (getFeeRateSchedule()!=null && getFeeRateSchedule().hasData()) return true;
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExerciseFeeSchedule.ExerciseFeeScheduleBuilder o = (ExerciseFeeSchedule.ExerciseFeeScheduleBuilder) other;
			
			merger.mergeRosetta(getFeeAmountSchedule(), o.getFeeAmountSchedule(), this::setFeeAmountSchedule);
			merger.mergeRosetta(getFeePaymentDate(), o.getFeePaymentDate(), this::setFeePaymentDate);
			merger.mergeRosetta(getFeeRateSchedule(), o.getFeeRateSchedule(), this::setFeeRateSchedule);
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExerciseFeeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(feeAmountSchedule, _that.getFeeAmountSchedule())) return false;
			if (!Objects.equals(feePaymentDate, _that.getFeePaymentDate())) return false;
			if (!Objects.equals(feeRateSchedule, _that.getFeeRateSchedule())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeAmountSchedule != null ? feeAmountSchedule.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			_result = 31 * _result + (feeRateSchedule != null ? feeRateSchedule.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFeeScheduleBuilder {" +
				"feeAmountSchedule=" + this.feeAmountSchedule + ", " +
				"feePaymentDate=" + this.feePaymentDate + ", " +
				"feeRateSchedule=" + this.feeRateSchedule + ", " +
				"notionalReference=" + this.notionalReference +
			'}' + " " + super.toString();
		}
	}
}
