package cdm.product.template;

import cdm.base.datetime.RelativeDateOffset;
import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilder;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilderImpl;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerImpl;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder;
import cdm.product.template.meta.ExerciseFeeMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining the fee payable on exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised. As a difference with FpML, it extends the BuyerSeller class.
 * @version ${project.version}
 */
@RosettaClass

public interface ExerciseFee extends BuyerSeller {
	ExerciseFee build();
	ExerciseFee.ExerciseFeeBuilder toBuilder();
	
	/**
	 * The amount of fee to be paid on exercise. The fee currency is that of the referenced notional.
	 */
	BigDecimal getFeeAmount();
	/**
	 * The date on which exercise fee(s) will be paid. It is specified as a relative date.
	 */
	RelativeDateOffset getFeePaymentDate();
	/**
	 * A fee represented as a percentage of some referenced notional. A percentage of 5% would be represented as 0.05.
	 */
	BigDecimal getFeeRate();
	/**
	 * A pointer style reference to the associated notional schedule defined elsewhere in the document.
	 */
	ReferenceWithMetaMoney getNotionalReference();
	final static ExerciseFeeMeta metaData = new ExerciseFeeMeta();
	
	@Override
	default RosettaMetaData<? extends ExerciseFee> metaData() {
		return metaData;
	} 
			
	static ExerciseFee.ExerciseFeeBuilder builder() {
		return new ExerciseFee.ExerciseFeeBuilderImpl();
	}
	
	default Class<? extends ExerciseFee> getType() {
		return ExerciseFee.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.party.BuyerSeller.super.process(path, processor);
		processor.processBasic(path.newSubPath("feeAmount"), BigDecimal.class, getFeeAmount(), this);
		processor.processBasic(path.newSubPath("feeRate"), BigDecimal.class, getFeeRate(), this);
		
		processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.class, getFeePaymentDate());
		processRosetta(path.newSubPath("notionalReference"), processor, ReferenceWithMetaMoney.class, getNotionalReference());
	}
	
	
	interface ExerciseFeeBuilder extends ExerciseFee, BuyerSeller.BuyerSellerBuilder, RosettaModelObjectBuilder {
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFeePaymentDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getFeePaymentDate();
		ReferenceWithMetaMoneyBuilder getOrCreateNotionalReference();
		ReferenceWithMetaMoneyBuilder getNotionalReference();
		ExerciseFee.ExerciseFeeBuilder setFeeAmount(BigDecimal feeAmount);
		ExerciseFee.ExerciseFeeBuilder setFeePaymentDate(RelativeDateOffset feePaymentDate);
		ExerciseFee.ExerciseFeeBuilder setFeeRate(BigDecimal feeRate);
		ExerciseFee.ExerciseFeeBuilder setNotionalReference(ReferenceWithMetaMoney notionalReference);
		ExerciseFee.ExerciseFeeBuilder setNotionalReferenceValue(Money notionalReference);
		ExerciseFee.ExerciseFeeBuilder setBuyer(CounterpartyRoleEnum buyer);
		ExerciseFee.ExerciseFeeBuilder setSeller(CounterpartyRoleEnum seller);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			BuyerSeller.BuyerSellerBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("feeAmount"), BigDecimal.class, getFeeAmount(), this);
			processor.processBasic(path.newSubPath("feeRate"), BigDecimal.class, getFeeRate(), this);
			
			processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getFeePaymentDate());
			processRosetta(path.newSubPath("notionalReference"), processor, ReferenceWithMetaMoneyBuilder.class, getNotionalReference());
		}
		
	}
	
	//ExerciseFee.ExerciseFeeImpl
	class ExerciseFeeImpl extends BuyerSeller.BuyerSellerImpl implements ExerciseFee {
		private final BigDecimal feeAmount;
		private final RelativeDateOffset feePaymentDate;
		private final BigDecimal feeRate;
		private final ReferenceWithMetaMoney notionalReference;
		
		protected ExerciseFeeImpl(ExerciseFee.ExerciseFeeBuilder builder) {
			super(builder);
			this.feeAmount = builder.getFeeAmount();
			this.feePaymentDate = ofNullable(builder.getFeePaymentDate()).map(f->f.build()).orElse(null);
			this.feeRate = builder.getFeeRate();
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getFeeAmount() {
			return feeAmount;
		}
		
		@Override
		public RelativeDateOffset getFeePaymentDate() {
			return feePaymentDate;
		}
		
		@Override
		public BigDecimal getFeeRate() {
			return feeRate;
		}
		
		@Override
		public ReferenceWithMetaMoney getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public ExerciseFee build() {
			return this;
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder toBuilder() {
			ExerciseFee.ExerciseFeeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseFee.ExerciseFeeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFeeAmount()).ifPresent(builder::setFeeAmount);
			ofNullable(getFeePaymentDate()).ifPresent(builder::setFeePaymentDate);
			ofNullable(getFeeRate()).ifPresent(builder::setFeeRate);
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExerciseFee _that = getType().cast(o);
		
			if (!Objects.equals(feeAmount, _that.getFeeAmount())) return false;
			if (!Objects.equals(feePaymentDate, _that.getFeePaymentDate())) return false;
			if (!Objects.equals(feeRate, _that.getFeeRate())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeAmount != null ? feeAmount.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			_result = 31 * _result + (feeRate != null ? feeRate.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFee {" +
				"feeAmount=" + this.feeAmount + ", " +
				"feePaymentDate=" + this.feePaymentDate + ", " +
				"feeRate=" + this.feeRate + ", " +
				"notionalReference=" + this.notionalReference +
			'}' + " " + super.toString();
		}
	}
	
	//ExerciseFee.ExerciseFeeBuilderImpl
	class ExerciseFeeBuilderImpl extends BuyerSeller.BuyerSellerBuilderImpl  implements ExerciseFee.ExerciseFeeBuilder {
	
		protected BigDecimal feeAmount;
		protected RelativeDateOffset.RelativeDateOffsetBuilder feePaymentDate;
		protected BigDecimal feeRate;
		protected ReferenceWithMetaMoneyBuilder notionalReference;
	
		public ExerciseFeeBuilderImpl() {
		}
	
		@Override
		public BigDecimal getFeeAmount() {
			return feeAmount;
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
		public BigDecimal getFeeRate() {
			return feeRate;
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
		public ExerciseFee.ExerciseFeeBuilder setFeeAmount(BigDecimal feeAmount) {
			this.feeAmount = feeAmount==null?null:feeAmount;
			return this;
		}
		@Override
		public ExerciseFee.ExerciseFeeBuilder setFeePaymentDate(RelativeDateOffset feePaymentDate) {
			this.feePaymentDate = feePaymentDate==null?null:feePaymentDate.toBuilder();
			return this;
		}
		@Override
		public ExerciseFee.ExerciseFeeBuilder setFeeRate(BigDecimal feeRate) {
			this.feeRate = feeRate==null?null:feeRate;
			return this;
		}
		@Override
		public ExerciseFee.ExerciseFeeBuilder setNotionalReference(ReferenceWithMetaMoney notionalReference) {
			this.notionalReference = notionalReference==null?null:notionalReference.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder setNotionalReferenceValue(Money notionalReference) {
			this.getOrCreateNotionalReference().setValue(notionalReference);
			return this;
		}
		@Override
		public ExerciseFee.ExerciseFeeBuilder setBuyer(CounterpartyRoleEnum buyer) {
			this.buyer = buyer==null?null:buyer;
			return this;
		}
		@Override
		public ExerciseFee.ExerciseFeeBuilder setSeller(CounterpartyRoleEnum seller) {
			this.seller = seller==null?null:seller;
			return this;
		}
		
		@Override
		public ExerciseFee build() {
			return new ExerciseFee.ExerciseFeeImpl(this);
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFee.ExerciseFeeBuilder prune() {
			super.prune();
			if (feePaymentDate!=null && !feePaymentDate.prune().hasData()) feePaymentDate = null;
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFeeAmount()!=null) return true;
			if (getFeePaymentDate()!=null && getFeePaymentDate().hasData()) return true;
			if (getFeeRate()!=null) return true;
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFee.ExerciseFeeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExerciseFee.ExerciseFeeBuilder o = (ExerciseFee.ExerciseFeeBuilder) other;
			
			merger.mergeRosetta(getFeePaymentDate(), o.getFeePaymentDate(), this::setFeePaymentDate);
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			
			merger.mergeBasic(getFeeAmount(), o.getFeeAmount(), this::setFeeAmount);
			merger.mergeBasic(getFeeRate(), o.getFeeRate(), this::setFeeRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExerciseFee _that = getType().cast(o);
		
			if (!Objects.equals(feeAmount, _that.getFeeAmount())) return false;
			if (!Objects.equals(feePaymentDate, _that.getFeePaymentDate())) return false;
			if (!Objects.equals(feeRate, _that.getFeeRate())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeAmount != null ? feeAmount.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			_result = 31 * _result + (feeRate != null ? feeRate.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFeeBuilder {" +
				"feeAmount=" + this.feeAmount + ", " +
				"feePaymentDate=" + this.feePaymentDate + ", " +
				"feeRate=" + this.feeRate + ", " +
				"notionalReference=" + this.notionalReference +
			'}' + " " + super.toString();
		}
	}
}
