package cdm.product.template;

import cdm.product.template.meta.MandatoryEarlyTerminationAdjustedDatesMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A data defining:  the adjusted dates associated with a mandatory early termination provision.
 * @version ${project.version}
 */
@RosettaClass

public interface MandatoryEarlyTerminationAdjustedDates extends RosettaModelObject {
	MandatoryEarlyTerminationAdjustedDates build();
	MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder toBuilder();
	
	/**
	 * The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business date convention.
	 */
	Date getAdjustedCashSettlementPaymentDate();
	/**
	 * The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedCashSettlementValuationDate();
	/**
	 * The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedEarlyTerminationDate();
	final static MandatoryEarlyTerminationAdjustedDatesMeta metaData = new MandatoryEarlyTerminationAdjustedDatesMeta();
	
	@Override
	default RosettaMetaData<? extends MandatoryEarlyTerminationAdjustedDates> metaData() {
		return metaData;
	} 
			
	static MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder builder() {
		return new MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilderImpl();
	}
	
	default Class<? extends MandatoryEarlyTerminationAdjustedDates> getType() {
		return MandatoryEarlyTerminationAdjustedDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), Date.class, getAdjustedCashSettlementPaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), Date.class, getAdjustedCashSettlementValuationDate(), this);
		processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), Date.class, getAdjustedEarlyTerminationDate(), this);
		
	}
	
	
	interface MandatoryEarlyTerminationAdjustedDatesBuilder extends MandatoryEarlyTerminationAdjustedDates, RosettaModelObjectBuilder {
		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedCashSettlementPaymentDate(Date adjustedCashSettlementPaymentDate);
		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedCashSettlementValuationDate(Date adjustedCashSettlementValuationDate);
		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedEarlyTerminationDate(Date adjustedEarlyTerminationDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), Date.class, getAdjustedCashSettlementPaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), Date.class, getAdjustedCashSettlementValuationDate(), this);
			processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), Date.class, getAdjustedEarlyTerminationDate(), this);
			
		}
		
	}
	
	//MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesImpl
	class MandatoryEarlyTerminationAdjustedDatesImpl implements MandatoryEarlyTerminationAdjustedDates {
		private final Date adjustedCashSettlementPaymentDate;
		private final Date adjustedCashSettlementValuationDate;
		private final Date adjustedEarlyTerminationDate;
		
		protected MandatoryEarlyTerminationAdjustedDatesImpl(MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder builder) {
			this.adjustedCashSettlementPaymentDate = builder.getAdjustedCashSettlementPaymentDate();
			this.adjustedCashSettlementValuationDate = builder.getAdjustedCashSettlementValuationDate();
			this.adjustedEarlyTerminationDate = builder.getAdjustedEarlyTerminationDate();
		}
		
		@Override
		public Date getAdjustedCashSettlementPaymentDate() {
			return adjustedCashSettlementPaymentDate;
		}
		
		@Override
		public Date getAdjustedCashSettlementValuationDate() {
			return adjustedCashSettlementValuationDate;
		}
		
		@Override
		public Date getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
		}
		
		@Override
		public MandatoryEarlyTerminationAdjustedDates build() {
			return this;
		}
		
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder toBuilder() {
			MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder builder) {
			ofNullable(getAdjustedCashSettlementPaymentDate()).ifPresent(builder::setAdjustedCashSettlementPaymentDate);
			ofNullable(getAdjustedCashSettlementValuationDate()).ifPresent(builder::setAdjustedCashSettlementValuationDate);
			ofNullable(getAdjustedEarlyTerminationDate()).ifPresent(builder::setAdjustedEarlyTerminationDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTerminationAdjustedDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTerminationAdjustedDates {" +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate +
			'}';
		}
	}
	
	//MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilderImpl
	class MandatoryEarlyTerminationAdjustedDatesBuilderImpl implements MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder {
	
		protected Date adjustedCashSettlementPaymentDate;
		protected Date adjustedCashSettlementValuationDate;
		protected Date adjustedEarlyTerminationDate;
	
		public MandatoryEarlyTerminationAdjustedDatesBuilderImpl() {
		}
	
		@Override
		public Date getAdjustedCashSettlementPaymentDate() {
			return adjustedCashSettlementPaymentDate;
		}
		
		@Override
		public Date getAdjustedCashSettlementValuationDate() {
			return adjustedCashSettlementValuationDate;
		}
		
		@Override
		public Date getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
		}
		
	
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedCashSettlementPaymentDate(Date adjustedCashSettlementPaymentDate) {
			this.adjustedCashSettlementPaymentDate = adjustedCashSettlementPaymentDate==null?null:adjustedCashSettlementPaymentDate;
			return this;
		}
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedCashSettlementValuationDate(Date adjustedCashSettlementValuationDate) {
			this.adjustedCashSettlementValuationDate = adjustedCashSettlementValuationDate==null?null:adjustedCashSettlementValuationDate;
			return this;
		}
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedEarlyTerminationDate(Date adjustedEarlyTerminationDate) {
			this.adjustedEarlyTerminationDate = adjustedEarlyTerminationDate==null?null:adjustedEarlyTerminationDate;
			return this;
		}
		
		@Override
		public MandatoryEarlyTerminationAdjustedDates build() {
			return new MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesImpl(this);
		}
		
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedCashSettlementPaymentDate()!=null) return true;
			if (getAdjustedCashSettlementValuationDate()!=null) return true;
			if (getAdjustedEarlyTerminationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder o = (MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder) other;
			
			
			merger.mergeBasic(getAdjustedCashSettlementPaymentDate(), o.getAdjustedCashSettlementPaymentDate(), this::setAdjustedCashSettlementPaymentDate);
			merger.mergeBasic(getAdjustedCashSettlementValuationDate(), o.getAdjustedCashSettlementValuationDate(), this::setAdjustedCashSettlementValuationDate);
			merger.mergeBasic(getAdjustedEarlyTerminationDate(), o.getAdjustedEarlyTerminationDate(), this::setAdjustedEarlyTerminationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTerminationAdjustedDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTerminationAdjustedDatesBuilder {" +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate +
			'}';
		}
	}
}
