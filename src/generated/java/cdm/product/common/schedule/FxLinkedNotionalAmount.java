package cdm.product.common.schedule;

import cdm.product.common.schedule.meta.FxLinkedNotionalAmountMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A data to:  describe the cashflow representation for FX linked notionals.
 * @version ${project.version}
 */
@RosettaClass

public interface FxLinkedNotionalAmount extends RosettaModelObject {
	FxLinkedNotionalAmount build();
	FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder toBuilder();
	
	/**
	 * The date on which the FX spot rate is observed. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedFxSpotFixingDate();
	/**
	 * The calculation period notional amount.
	 */
	BigDecimal getNotionalAmount();
	/**
	 * The actual observed FX spot rate.
	 */
	BigDecimal getObservedFxSpotRate();
	/**
	 * The reset date.
	 */
	Date getResetDate();
	final static FxLinkedNotionalAmountMeta metaData = new FxLinkedNotionalAmountMeta();
	
	@Override
	default RosettaMetaData<? extends FxLinkedNotionalAmount> metaData() {
		return metaData;
	} 
			
	static FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder builder() {
		return new FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilderImpl();
	}
	
	default Class<? extends FxLinkedNotionalAmount> getType() {
		return FxLinkedNotionalAmount.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedFxSpotFixingDate"), Date.class, getAdjustedFxSpotFixingDate(), this);
		processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
		processor.processBasic(path.newSubPath("observedFxSpotRate"), BigDecimal.class, getObservedFxSpotRate(), this);
		processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
		
	}
	
	
	interface FxLinkedNotionalAmountBuilder extends FxLinkedNotionalAmount, RosettaModelObjectBuilder {
		FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder setAdjustedFxSpotFixingDate(Date adjustedFxSpotFixingDate);
		FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder setNotionalAmount(BigDecimal notionalAmount);
		FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder setObservedFxSpotRate(BigDecimal observedFxSpotRate);
		FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder setResetDate(Date resetDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("adjustedFxSpotFixingDate"), Date.class, getAdjustedFxSpotFixingDate(), this);
			processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
			processor.processBasic(path.newSubPath("observedFxSpotRate"), BigDecimal.class, getObservedFxSpotRate(), this);
			processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
			
		}
		
	}
	
	//FxLinkedNotionalAmount.FxLinkedNotionalAmountImpl
	class FxLinkedNotionalAmountImpl implements FxLinkedNotionalAmount {
		private final Date adjustedFxSpotFixingDate;
		private final BigDecimal notionalAmount;
		private final BigDecimal observedFxSpotRate;
		private final Date resetDate;
		
		protected FxLinkedNotionalAmountImpl(FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder builder) {
			this.adjustedFxSpotFixingDate = builder.getAdjustedFxSpotFixingDate();
			this.notionalAmount = builder.getNotionalAmount();
			this.observedFxSpotRate = builder.getObservedFxSpotRate();
			this.resetDate = builder.getResetDate();
		}
		
		@Override
		public Date getAdjustedFxSpotFixingDate() {
			return adjustedFxSpotFixingDate;
		}
		
		@Override
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public BigDecimal getObservedFxSpotRate() {
			return observedFxSpotRate;
		}
		
		@Override
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		public FxLinkedNotionalAmount build() {
			return this;
		}
		
		@Override
		public FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder toBuilder() {
			FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder builder) {
			ofNullable(getAdjustedFxSpotFixingDate()).ifPresent(builder::setAdjustedFxSpotFixingDate);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getObservedFxSpotRate()).ifPresent(builder::setObservedFxSpotRate);
			ofNullable(getResetDate()).ifPresent(builder::setResetDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxLinkedNotionalAmount _that = getType().cast(o);
		
			if (!Objects.equals(adjustedFxSpotFixingDate, _that.getAdjustedFxSpotFixingDate())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(observedFxSpotRate, _that.getObservedFxSpotRate())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedFxSpotFixingDate != null ? adjustedFxSpotFixingDate.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (observedFxSpotRate != null ? observedFxSpotRate.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxLinkedNotionalAmount {" +
				"adjustedFxSpotFixingDate=" + this.adjustedFxSpotFixingDate + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"observedFxSpotRate=" + this.observedFxSpotRate + ", " +
				"resetDate=" + this.resetDate +
			'}';
		}
	}
	
	//FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilderImpl
	class FxLinkedNotionalAmountBuilderImpl implements FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder {
	
		protected Date adjustedFxSpotFixingDate;
		protected BigDecimal notionalAmount;
		protected BigDecimal observedFxSpotRate;
		protected Date resetDate;
	
		public FxLinkedNotionalAmountBuilderImpl() {
		}
	
		@Override
		public Date getAdjustedFxSpotFixingDate() {
			return adjustedFxSpotFixingDate;
		}
		
		@Override
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public BigDecimal getObservedFxSpotRate() {
			return observedFxSpotRate;
		}
		
		@Override
		public Date getResetDate() {
			return resetDate;
		}
		
	
		@Override
		public FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder setAdjustedFxSpotFixingDate(Date adjustedFxSpotFixingDate) {
			this.adjustedFxSpotFixingDate = adjustedFxSpotFixingDate==null?null:adjustedFxSpotFixingDate;
			return this;
		}
		@Override
		public FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder setNotionalAmount(BigDecimal notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount;
			return this;
		}
		@Override
		public FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder setObservedFxSpotRate(BigDecimal observedFxSpotRate) {
			this.observedFxSpotRate = observedFxSpotRate==null?null:observedFxSpotRate;
			return this;
		}
		@Override
		public FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder setResetDate(Date resetDate) {
			this.resetDate = resetDate==null?null:resetDate;
			return this;
		}
		
		@Override
		public FxLinkedNotionalAmount build() {
			return new FxLinkedNotionalAmount.FxLinkedNotionalAmountImpl(this);
		}
		
		@Override
		public FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedFxSpotFixingDate()!=null) return true;
			if (getNotionalAmount()!=null) return true;
			if (getObservedFxSpotRate()!=null) return true;
			if (getResetDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder o = (FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder) other;
			
			
			merger.mergeBasic(getAdjustedFxSpotFixingDate(), o.getAdjustedFxSpotFixingDate(), this::setAdjustedFxSpotFixingDate);
			merger.mergeBasic(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeBasic(getObservedFxSpotRate(), o.getObservedFxSpotRate(), this::setObservedFxSpotRate);
			merger.mergeBasic(getResetDate(), o.getResetDate(), this::setResetDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxLinkedNotionalAmount _that = getType().cast(o);
		
			if (!Objects.equals(adjustedFxSpotFixingDate, _that.getAdjustedFxSpotFixingDate())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(observedFxSpotRate, _that.getObservedFxSpotRate())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedFxSpotFixingDate != null ? adjustedFxSpotFixingDate.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (observedFxSpotRate != null ? observedFxSpotRate.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxLinkedNotionalAmountBuilder {" +
				"adjustedFxSpotFixingDate=" + this.adjustedFxSpotFixingDate + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"observedFxSpotRate=" + this.observedFxSpotRate + ", " +
				"resetDate=" + this.resetDate +
			'}';
		}
	}
}
