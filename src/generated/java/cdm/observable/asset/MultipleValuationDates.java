package cdm.observable.asset;

import cdm.observable.asset.SingleValuationDate.SingleValuationDateBuilder;
import cdm.observable.asset.SingleValuationDate.SingleValuationDateBuilderImpl;
import cdm.observable.asset.SingleValuationDate.SingleValuationDateImpl;
import cdm.observable.asset.meta.MultipleValuationDatesMeta;
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
 * @version ${project.version}
 */
@RosettaClass

public interface MultipleValuationDates extends SingleValuationDate {
	MultipleValuationDates build();
	MultipleValuationDates.MultipleValuationDatesBuilder toBuilder();
	
	/**
	 * The number of business days between successive valuation dates when multiple valuation dates are applicable for cash settlement. ISDA 2003 Term: Business Days thereafter.
	 */
	Integer getBusinessDaysThereafter();
	/**
	 * Where multiple valuation dates are specified as being applicable for cash settlement, this element specifies (a) the number of applicable valuation dates, and (b) the number of business days after satisfaction of all conditions to settlement when the first such valuation date occurs, and (c) the number of business days thereafter of each successive valuation date. ISDA 2003 Term: Multiple Valuation Dates.
	 */
	Integer getNumberValuationDates();
	final static MultipleValuationDatesMeta metaData = new MultipleValuationDatesMeta();
	
	@Override
	default RosettaMetaData<? extends MultipleValuationDates> metaData() {
		return metaData;
	} 
			
	static MultipleValuationDates.MultipleValuationDatesBuilder builder() {
		return new MultipleValuationDates.MultipleValuationDatesBuilderImpl();
	}
	
	default Class<? extends MultipleValuationDates> getType() {
		return MultipleValuationDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.observable.asset.SingleValuationDate.super.process(path, processor);
		processor.processBasic(path.newSubPath("businessDaysThereafter"), Integer.class, getBusinessDaysThereafter(), this);
		processor.processBasic(path.newSubPath("numberValuationDates"), Integer.class, getNumberValuationDates(), this);
		
	}
	
	
	interface MultipleValuationDatesBuilder extends MultipleValuationDates, SingleValuationDate.SingleValuationDateBuilder, RosettaModelObjectBuilder {
		MultipleValuationDates.MultipleValuationDatesBuilder setBusinessDaysThereafter(Integer businessDaysThereafter);
		MultipleValuationDates.MultipleValuationDatesBuilder setNumberValuationDates(Integer numberValuationDates);
		MultipleValuationDates.MultipleValuationDatesBuilder setBusinessDays(Integer businessDays);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			SingleValuationDate.SingleValuationDateBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("businessDaysThereafter"), Integer.class, getBusinessDaysThereafter(), this);
			processor.processBasic(path.newSubPath("numberValuationDates"), Integer.class, getNumberValuationDates(), this);
			
		}
		
	}
	
	//MultipleValuationDates.MultipleValuationDatesImpl
	class MultipleValuationDatesImpl extends SingleValuationDate.SingleValuationDateImpl implements MultipleValuationDates {
		private final Integer businessDaysThereafter;
		private final Integer numberValuationDates;
		
		protected MultipleValuationDatesImpl(MultipleValuationDates.MultipleValuationDatesBuilder builder) {
			super(builder);
			this.businessDaysThereafter = builder.getBusinessDaysThereafter();
			this.numberValuationDates = builder.getNumberValuationDates();
		}
		
		@Override
		public Integer getBusinessDaysThereafter() {
			return businessDaysThereafter;
		}
		
		@Override
		public Integer getNumberValuationDates() {
			return numberValuationDates;
		}
		
		@Override
		public MultipleValuationDates build() {
			return this;
		}
		
		@Override
		public MultipleValuationDates.MultipleValuationDatesBuilder toBuilder() {
			MultipleValuationDates.MultipleValuationDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MultipleValuationDates.MultipleValuationDatesBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessDaysThereafter()).ifPresent(builder::setBusinessDaysThereafter);
			ofNullable(getNumberValuationDates()).ifPresent(builder::setNumberValuationDates);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MultipleValuationDates _that = getType().cast(o);
		
			if (!Objects.equals(businessDaysThereafter, _that.getBusinessDaysThereafter())) return false;
			if (!Objects.equals(numberValuationDates, _that.getNumberValuationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDaysThereafter != null ? businessDaysThereafter.hashCode() : 0);
			_result = 31 * _result + (numberValuationDates != null ? numberValuationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultipleValuationDates {" +
				"businessDaysThereafter=" + this.businessDaysThereafter + ", " +
				"numberValuationDates=" + this.numberValuationDates +
			'}' + " " + super.toString();
		}
	}
	
	//MultipleValuationDates.MultipleValuationDatesBuilderImpl
	class MultipleValuationDatesBuilderImpl extends SingleValuationDate.SingleValuationDateBuilderImpl  implements MultipleValuationDates.MultipleValuationDatesBuilder {
	
		protected Integer businessDaysThereafter;
		protected Integer numberValuationDates;
	
		public MultipleValuationDatesBuilderImpl() {
		}
	
		@Override
		public Integer getBusinessDaysThereafter() {
			return businessDaysThereafter;
		}
		
		@Override
		public Integer getNumberValuationDates() {
			return numberValuationDates;
		}
		
	
		@Override
		public MultipleValuationDates.MultipleValuationDatesBuilder setBusinessDaysThereafter(Integer businessDaysThereafter) {
			this.businessDaysThereafter = businessDaysThereafter==null?null:businessDaysThereafter;
			return this;
		}
		@Override
		public MultipleValuationDates.MultipleValuationDatesBuilder setNumberValuationDates(Integer numberValuationDates) {
			this.numberValuationDates = numberValuationDates==null?null:numberValuationDates;
			return this;
		}
		@Override
		public MultipleValuationDates.MultipleValuationDatesBuilder setBusinessDays(Integer businessDays) {
			this.businessDays = businessDays==null?null:businessDays;
			return this;
		}
		
		@Override
		public MultipleValuationDates build() {
			return new MultipleValuationDates.MultipleValuationDatesImpl(this);
		}
		
		@Override
		public MultipleValuationDates.MultipleValuationDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultipleValuationDates.MultipleValuationDatesBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessDaysThereafter()!=null) return true;
			if (getNumberValuationDates()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultipleValuationDates.MultipleValuationDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MultipleValuationDates.MultipleValuationDatesBuilder o = (MultipleValuationDates.MultipleValuationDatesBuilder) other;
			
			
			merger.mergeBasic(getBusinessDaysThereafter(), o.getBusinessDaysThereafter(), this::setBusinessDaysThereafter);
			merger.mergeBasic(getNumberValuationDates(), o.getNumberValuationDates(), this::setNumberValuationDates);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MultipleValuationDates _that = getType().cast(o);
		
			if (!Objects.equals(businessDaysThereafter, _that.getBusinessDaysThereafter())) return false;
			if (!Objects.equals(numberValuationDates, _that.getNumberValuationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDaysThereafter != null ? businessDaysThereafter.hashCode() : 0);
			_result = 31 * _result + (numberValuationDates != null ? numberValuationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultipleValuationDatesBuilder {" +
				"businessDaysThereafter=" + this.businessDaysThereafter + ", " +
				"numberValuationDates=" + this.numberValuationDates +
			'}' + " " + super.toString();
		}
	}
}
