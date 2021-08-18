package cdm.product.common.settlement;

import cdm.product.common.settlement.meta.PhysicalSettlementPeriodMeta;
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

public interface PhysicalSettlementPeriod extends RosettaModelObject {
	PhysicalSettlementPeriod build();
	PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder toBuilder();
	
	/**
	 * A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.
	 */
	Integer getBusinessDays();
	/**
	 * An explicit indication that a number of business days are not specified and therefore ISDA fallback provisions should apply.
	 */
	Boolean getBusinessDaysNotSpecified();
	/**
	 * A maximum number of business days. Its precise meaning is dependant on the context in which this element is used. Intended to be used to limit a particular ISDA fallback provision.
	 */
	Integer getMaximumBusinessDays();
	final static PhysicalSettlementPeriodMeta metaData = new PhysicalSettlementPeriodMeta();
	
	@Override
	default RosettaMetaData<? extends PhysicalSettlementPeriod> metaData() {
		return metaData;
	} 
			
	static PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder builder() {
		return new PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilderImpl();
	}
	
	default Class<? extends PhysicalSettlementPeriod> getType() {
		return PhysicalSettlementPeriod.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("businessDays"), Integer.class, getBusinessDays(), this);
		processor.processBasic(path.newSubPath("businessDaysNotSpecified"), Boolean.class, getBusinessDaysNotSpecified(), this);
		processor.processBasic(path.newSubPath("maximumBusinessDays"), Integer.class, getMaximumBusinessDays(), this);
		
	}
	
	
	interface PhysicalSettlementPeriodBuilder extends PhysicalSettlementPeriod, RosettaModelObjectBuilder {
		PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder setBusinessDays(Integer businessDays);
		PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder setBusinessDaysNotSpecified(Boolean businessDaysNotSpecified);
		PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder setMaximumBusinessDays(Integer maximumBusinessDays);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("businessDays"), Integer.class, getBusinessDays(), this);
			processor.processBasic(path.newSubPath("businessDaysNotSpecified"), Boolean.class, getBusinessDaysNotSpecified(), this);
			processor.processBasic(path.newSubPath("maximumBusinessDays"), Integer.class, getMaximumBusinessDays(), this);
			
		}
		
	}
	
	//PhysicalSettlementPeriod.PhysicalSettlementPeriodImpl
	class PhysicalSettlementPeriodImpl implements PhysicalSettlementPeriod {
		private final Integer businessDays;
		private final Boolean businessDaysNotSpecified;
		private final Integer maximumBusinessDays;
		
		protected PhysicalSettlementPeriodImpl(PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder builder) {
			this.businessDays = builder.getBusinessDays();
			this.businessDaysNotSpecified = builder.getBusinessDaysNotSpecified();
			this.maximumBusinessDays = builder.getMaximumBusinessDays();
		}
		
		@Override
		public Integer getBusinessDays() {
			return businessDays;
		}
		
		@Override
		public Boolean getBusinessDaysNotSpecified() {
			return businessDaysNotSpecified;
		}
		
		@Override
		public Integer getMaximumBusinessDays() {
			return maximumBusinessDays;
		}
		
		@Override
		public PhysicalSettlementPeriod build() {
			return this;
		}
		
		@Override
		public PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder toBuilder() {
			PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder builder) {
			ofNullable(getBusinessDays()).ifPresent(builder::setBusinessDays);
			ofNullable(getBusinessDaysNotSpecified()).ifPresent(builder::setBusinessDaysNotSpecified);
			ofNullable(getMaximumBusinessDays()).ifPresent(builder::setMaximumBusinessDays);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PhysicalSettlementPeriod _that = getType().cast(o);
		
			if (!Objects.equals(businessDays, _that.getBusinessDays())) return false;
			if (!Objects.equals(businessDaysNotSpecified, _that.getBusinessDaysNotSpecified())) return false;
			if (!Objects.equals(maximumBusinessDays, _that.getMaximumBusinessDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessDays != null ? businessDays.hashCode() : 0);
			_result = 31 * _result + (businessDaysNotSpecified != null ? businessDaysNotSpecified.hashCode() : 0);
			_result = 31 * _result + (maximumBusinessDays != null ? maximumBusinessDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PhysicalSettlementPeriod {" +
				"businessDays=" + this.businessDays + ", " +
				"businessDaysNotSpecified=" + this.businessDaysNotSpecified + ", " +
				"maximumBusinessDays=" + this.maximumBusinessDays +
			'}';
		}
	}
	
	//PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilderImpl
	class PhysicalSettlementPeriodBuilderImpl implements PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder {
	
		protected Integer businessDays;
		protected Boolean businessDaysNotSpecified;
		protected Integer maximumBusinessDays;
	
		public PhysicalSettlementPeriodBuilderImpl() {
		}
	
		@Override
		public Integer getBusinessDays() {
			return businessDays;
		}
		
		@Override
		public Boolean getBusinessDaysNotSpecified() {
			return businessDaysNotSpecified;
		}
		
		@Override
		public Integer getMaximumBusinessDays() {
			return maximumBusinessDays;
		}
		
	
		@Override
		public PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder setBusinessDays(Integer businessDays) {
			this.businessDays = businessDays==null?null:businessDays;
			return this;
		}
		@Override
		public PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder setBusinessDaysNotSpecified(Boolean businessDaysNotSpecified) {
			this.businessDaysNotSpecified = businessDaysNotSpecified==null?null:businessDaysNotSpecified;
			return this;
		}
		@Override
		public PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder setMaximumBusinessDays(Integer maximumBusinessDays) {
			this.maximumBusinessDays = maximumBusinessDays==null?null:maximumBusinessDays;
			return this;
		}
		
		@Override
		public PhysicalSettlementPeriod build() {
			return new PhysicalSettlementPeriod.PhysicalSettlementPeriodImpl(this);
		}
		
		@Override
		public PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessDays()!=null) return true;
			if (getBusinessDaysNotSpecified()!=null) return true;
			if (getMaximumBusinessDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder o = (PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder) other;
			
			
			merger.mergeBasic(getBusinessDays(), o.getBusinessDays(), this::setBusinessDays);
			merger.mergeBasic(getBusinessDaysNotSpecified(), o.getBusinessDaysNotSpecified(), this::setBusinessDaysNotSpecified);
			merger.mergeBasic(getMaximumBusinessDays(), o.getMaximumBusinessDays(), this::setMaximumBusinessDays);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PhysicalSettlementPeriod _that = getType().cast(o);
		
			if (!Objects.equals(businessDays, _that.getBusinessDays())) return false;
			if (!Objects.equals(businessDaysNotSpecified, _that.getBusinessDaysNotSpecified())) return false;
			if (!Objects.equals(maximumBusinessDays, _that.getMaximumBusinessDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessDays != null ? businessDays.hashCode() : 0);
			_result = 31 * _result + (businessDaysNotSpecified != null ? businessDaysNotSpecified.hashCode() : 0);
			_result = 31 * _result + (maximumBusinessDays != null ? maximumBusinessDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PhysicalSettlementPeriodBuilder {" +
				"businessDays=" + this.businessDays + ", " +
				"businessDaysNotSpecified=" + this.businessDaysNotSpecified + ", " +
				"maximumBusinessDays=" + this.maximumBusinessDays +
			'}';
		}
	}
}
