package cdm.product.asset;

import cdm.product.asset.meta.FloatingAmountProvisionsMeta;
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

public interface FloatingAmountProvisions extends RosettaModelObject {
	FloatingAmountProvisions build();
	FloatingAmountProvisions.FloatingAmountProvisionsBuilder toBuilder();
	
	/**
	 * As specified by the ISDA Standard Terms Supplement for use with trades on mortgage-backed securities. The presence of the element with value set to &#39;true&#39; signifies that the provision is applicable. If applicable, the applicable step-up terms are specified as part of that ISDA Standard Terms Supplement. From a usage standpoint, this provision is typically applicable in the case of RMBS and not applicable in case of CMBS trades.
	 */
	Boolean getStepUpProvision();
	/**
	 * As specified by the ISDA Supplement for use with trades on mortgage-backed securities, &#39;WAC Cap&#39; means a weighted average coupon or weighted average rate cap provision (however defined in the Underlying Instruments) of the Underlying Instruments that limits, increases or decreases the interest rate or interest entitlement, as set out in the Underlying Instruments on the Effective Date without regard to any subsequent amendment The presence of the element with value set to &#39;true&#39; signifies that the provision is applicable. From a usage standpoint, this provision is typically applicable in the case of CMBS and not applicable in case of RMBS trades.
	 */
	Boolean getWacCapInterestProvision();
	final static FloatingAmountProvisionsMeta metaData = new FloatingAmountProvisionsMeta();
	
	@Override
	default RosettaMetaData<? extends FloatingAmountProvisions> metaData() {
		return metaData;
	} 
			
	static FloatingAmountProvisions.FloatingAmountProvisionsBuilder builder() {
		return new FloatingAmountProvisions.FloatingAmountProvisionsBuilderImpl();
	}
	
	default Class<? extends FloatingAmountProvisions> getType() {
		return FloatingAmountProvisions.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("stepUpProvision"), Boolean.class, getStepUpProvision(), this);
		processor.processBasic(path.newSubPath("wacCapInterestProvision"), Boolean.class, getWacCapInterestProvision(), this);
		
	}
	
	
	interface FloatingAmountProvisionsBuilder extends FloatingAmountProvisions, RosettaModelObjectBuilder {
		FloatingAmountProvisions.FloatingAmountProvisionsBuilder setStepUpProvision(Boolean stepUpProvision);
		FloatingAmountProvisions.FloatingAmountProvisionsBuilder setWacCapInterestProvision(Boolean wacCapInterestProvision);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("stepUpProvision"), Boolean.class, getStepUpProvision(), this);
			processor.processBasic(path.newSubPath("wacCapInterestProvision"), Boolean.class, getWacCapInterestProvision(), this);
			
		}
		
	}
	
	//FloatingAmountProvisions.FloatingAmountProvisionsImpl
	class FloatingAmountProvisionsImpl implements FloatingAmountProvisions {
		private final Boolean stepUpProvision;
		private final Boolean wacCapInterestProvision;
		
		protected FloatingAmountProvisionsImpl(FloatingAmountProvisions.FloatingAmountProvisionsBuilder builder) {
			this.stepUpProvision = builder.getStepUpProvision();
			this.wacCapInterestProvision = builder.getWacCapInterestProvision();
		}
		
		@Override
		public Boolean getStepUpProvision() {
			return stepUpProvision;
		}
		
		@Override
		public Boolean getWacCapInterestProvision() {
			return wacCapInterestProvision;
		}
		
		@Override
		public FloatingAmountProvisions build() {
			return this;
		}
		
		@Override
		public FloatingAmountProvisions.FloatingAmountProvisionsBuilder toBuilder() {
			FloatingAmountProvisions.FloatingAmountProvisionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingAmountProvisions.FloatingAmountProvisionsBuilder builder) {
			ofNullable(getStepUpProvision()).ifPresent(builder::setStepUpProvision);
			ofNullable(getWacCapInterestProvision()).ifPresent(builder::setWacCapInterestProvision);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingAmountProvisions _that = getType().cast(o);
		
			if (!Objects.equals(stepUpProvision, _that.getStepUpProvision())) return false;
			if (!Objects.equals(wacCapInterestProvision, _that.getWacCapInterestProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (stepUpProvision != null ? stepUpProvision.hashCode() : 0);
			_result = 31 * _result + (wacCapInterestProvision != null ? wacCapInterestProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingAmountProvisions {" +
				"stepUpProvision=" + this.stepUpProvision + ", " +
				"wacCapInterestProvision=" + this.wacCapInterestProvision +
			'}';
		}
	}
	
	//FloatingAmountProvisions.FloatingAmountProvisionsBuilderImpl
	class FloatingAmountProvisionsBuilderImpl implements FloatingAmountProvisions.FloatingAmountProvisionsBuilder {
	
		protected Boolean stepUpProvision;
		protected Boolean wacCapInterestProvision;
	
		public FloatingAmountProvisionsBuilderImpl() {
		}
	
		@Override
		public Boolean getStepUpProvision() {
			return stepUpProvision;
		}
		
		@Override
		public Boolean getWacCapInterestProvision() {
			return wacCapInterestProvision;
		}
		
	
		@Override
		public FloatingAmountProvisions.FloatingAmountProvisionsBuilder setStepUpProvision(Boolean stepUpProvision) {
			this.stepUpProvision = stepUpProvision==null?null:stepUpProvision;
			return this;
		}
		@Override
		public FloatingAmountProvisions.FloatingAmountProvisionsBuilder setWacCapInterestProvision(Boolean wacCapInterestProvision) {
			this.wacCapInterestProvision = wacCapInterestProvision==null?null:wacCapInterestProvision;
			return this;
		}
		
		@Override
		public FloatingAmountProvisions build() {
			return new FloatingAmountProvisions.FloatingAmountProvisionsImpl(this);
		}
		
		@Override
		public FloatingAmountProvisions.FloatingAmountProvisionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingAmountProvisions.FloatingAmountProvisionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStepUpProvision()!=null) return true;
			if (getWacCapInterestProvision()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingAmountProvisions.FloatingAmountProvisionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingAmountProvisions.FloatingAmountProvisionsBuilder o = (FloatingAmountProvisions.FloatingAmountProvisionsBuilder) other;
			
			
			merger.mergeBasic(getStepUpProvision(), o.getStepUpProvision(), this::setStepUpProvision);
			merger.mergeBasic(getWacCapInterestProvision(), o.getWacCapInterestProvision(), this::setWacCapInterestProvision);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingAmountProvisions _that = getType().cast(o);
		
			if (!Objects.equals(stepUpProvision, _that.getStepUpProvision())) return false;
			if (!Objects.equals(wacCapInterestProvision, _that.getWacCapInterestProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (stepUpProvision != null ? stepUpProvision.hashCode() : 0);
			_result = 31 * _result + (wacCapInterestProvision != null ? wacCapInterestProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingAmountProvisionsBuilder {" +
				"stepUpProvision=" + this.stepUpProvision + ", " +
				"wacCapInterestProvision=" + this.wacCapInterestProvision +
			'}';
		}
	}
}
