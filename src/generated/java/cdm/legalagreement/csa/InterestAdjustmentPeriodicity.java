package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.InterestAdjustmentPeriodicityMeta;
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
 * A class to specify the Interest Adjustment periodicity either through a standardized election or a custom one. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).
 * @version ${project.version}
 */
@RosettaClass

public interface InterestAdjustmentPeriodicity extends RosettaModelObject {
	InterestAdjustmentPeriodicity build();
	InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder toBuilder();
	
	/**
	 * The Interest Adjustment periodicity when specified through a custom election.
	 */
	String getCustomElection();
	/**
	 * The Interest Adjustment periodicity when specified through a standardized election.
	 */
	InterestAdjustmentPeriodicityEnum getStandardElection();
	final static InterestAdjustmentPeriodicityMeta metaData = new InterestAdjustmentPeriodicityMeta();
	
	@Override
	default RosettaMetaData<? extends InterestAdjustmentPeriodicity> metaData() {
		return metaData;
	} 
			
	static InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder builder() {
		return new InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilderImpl();
	}
	
	default Class<? extends InterestAdjustmentPeriodicity> getType() {
		return InterestAdjustmentPeriodicity.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
		processor.processBasic(path.newSubPath("standardElection"), InterestAdjustmentPeriodicityEnum.class, getStandardElection(), this);
		
	}
	
	
	interface InterestAdjustmentPeriodicityBuilder extends InterestAdjustmentPeriodicity, RosettaModelObjectBuilder {
		InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder setCustomElection(String customElection);
		InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder setStandardElection(InterestAdjustmentPeriodicityEnum standardElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
			processor.processBasic(path.newSubPath("standardElection"), InterestAdjustmentPeriodicityEnum.class, getStandardElection(), this);
			
		}
		
	}
	
	//InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityImpl
	class InterestAdjustmentPeriodicityImpl implements InterestAdjustmentPeriodicity {
		private final String customElection;
		private final InterestAdjustmentPeriodicityEnum standardElection;
		
		protected InterestAdjustmentPeriodicityImpl(InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder builder) {
			this.customElection = builder.getCustomElection();
			this.standardElection = builder.getStandardElection();
		}
		
		@Override
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public InterestAdjustmentPeriodicityEnum getStandardElection() {
			return standardElection;
		}
		
		@Override
		public InterestAdjustmentPeriodicity build() {
			return this;
		}
		
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder toBuilder() {
			InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder builder) {
			ofNullable(getCustomElection()).ifPresent(builder::setCustomElection);
			ofNullable(getStandardElection()).ifPresent(builder::setStandardElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAdjustmentPeriodicity _that = getType().cast(o);
		
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!Objects.equals(standardElection, _that.getStandardElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (standardElection != null ? standardElection.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAdjustmentPeriodicity {" +
				"customElection=" + this.customElection + ", " +
				"standardElection=" + this.standardElection +
			'}';
		}
	}
	
	//InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilderImpl
	class InterestAdjustmentPeriodicityBuilderImpl implements InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder {
	
		protected String customElection;
		protected InterestAdjustmentPeriodicityEnum standardElection;
	
		public InterestAdjustmentPeriodicityBuilderImpl() {
		}
	
		@Override
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public InterestAdjustmentPeriodicityEnum getStandardElection() {
			return standardElection;
		}
		
	
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder setCustomElection(String customElection) {
			this.customElection = customElection==null?null:customElection;
			return this;
		}
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder setStandardElection(InterestAdjustmentPeriodicityEnum standardElection) {
			this.standardElection = standardElection==null?null:standardElection;
			return this;
		}
		
		@Override
		public InterestAdjustmentPeriodicity build() {
			return new InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityImpl(this);
		}
		
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustomElection()!=null) return true;
			if (getStandardElection()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder o = (InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder) other;
			
			
			merger.mergeBasic(getCustomElection(), o.getCustomElection(), this::setCustomElection);
			merger.mergeBasic(getStandardElection(), o.getStandardElection(), this::setStandardElection);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAdjustmentPeriodicity _that = getType().cast(o);
		
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!Objects.equals(standardElection, _that.getStandardElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (standardElection != null ? standardElection.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAdjustmentPeriodicityBuilder {" +
				"customElection=" + this.customElection + ", " +
				"standardElection=" + this.standardElection +
			'}';
		}
	}
}
