package cdm.legalagreement.csa;

import cdm.base.datetime.BusinessCenterTime;
import cdm.legalagreement.csa.meta.DisputeResolutionMeta;
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
 * A class to specify the election terms under which a party disputes (i) the Calculation Agent’s calculation of a Delivery Amount or a Return Amount, or (ii) the Value of any Transfer of Eligible Credit Support or Posted Credit Support. Parties can specify such election either through a business center time or through a custom election. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (g): Dispute Resolution. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (h): Dispute Resolution. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (g): Dispute Resolution.
 * @version ${project.version}
 */
@RosettaClass

public interface DisputeResolution extends RosettaModelObject {
	DisputeResolution build();
	DisputeResolution.DisputeResolutionBuilder toBuilder();
	
	/**
	 * The alternative dispute resolution procedure if specified
	 */
	String getAlternativeTerms();
	/**
	 * The custom Resolution Time election that might be specified by the parties.
	 */
	String getOtherTerms();
	/**
	 * The elections to specify terms for recalculation of the market value of posted collateral.
	 */
	RecalculationOfValue getRecalculationOfValue();
	/**
	 * The time by which the dispute needs to be resolved, failure of which would trigger a recalculation alongside a process that is specified as part of the agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (g)(i): Resolution Time. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (g)(i): Resolution Time.
	 */
	BusinessCenterTime getResolutionTime();
	/**
	 * The method of calculation for determining value for the purposes of a Variation Margin agreement.
	 */
	String getValueTerms();
	final static DisputeResolutionMeta metaData = new DisputeResolutionMeta();
	
	@Override
	default RosettaMetaData<? extends DisputeResolution> metaData() {
		return metaData;
	} 
			
	static DisputeResolution.DisputeResolutionBuilder builder() {
		return new DisputeResolution.DisputeResolutionBuilderImpl();
	}
	
	default Class<? extends DisputeResolution> getType() {
		return DisputeResolution.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("alternativeTerms"), String.class, getAlternativeTerms(), this);
		processor.processBasic(path.newSubPath("otherTerms"), String.class, getOtherTerms(), this);
		processor.processBasic(path.newSubPath("valueTerms"), String.class, getValueTerms(), this);
		
		processRosetta(path.newSubPath("recalculationOfValue"), processor, RecalculationOfValue.class, getRecalculationOfValue());
		processRosetta(path.newSubPath("resolutionTime"), processor, BusinessCenterTime.class, getResolutionTime());
	}
	
	
	interface DisputeResolutionBuilder extends DisputeResolution, RosettaModelObjectBuilder {
		RecalculationOfValue.RecalculationOfValueBuilder getOrCreateRecalculationOfValue();
		RecalculationOfValue.RecalculationOfValueBuilder getRecalculationOfValue();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateResolutionTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getResolutionTime();
		DisputeResolution.DisputeResolutionBuilder setAlternativeTerms(String alternativeTerms);
		DisputeResolution.DisputeResolutionBuilder setOtherTerms(String otherTerms);
		DisputeResolution.DisputeResolutionBuilder setRecalculationOfValue(RecalculationOfValue recalculationOfValue);
		DisputeResolution.DisputeResolutionBuilder setResolutionTime(BusinessCenterTime resolutionTime);
		DisputeResolution.DisputeResolutionBuilder setValueTerms(String valueTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("alternativeTerms"), String.class, getAlternativeTerms(), this);
			processor.processBasic(path.newSubPath("otherTerms"), String.class, getOtherTerms(), this);
			processor.processBasic(path.newSubPath("valueTerms"), String.class, getValueTerms(), this);
			
			processRosetta(path.newSubPath("recalculationOfValue"), processor, RecalculationOfValue.RecalculationOfValueBuilder.class, getRecalculationOfValue());
			processRosetta(path.newSubPath("resolutionTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getResolutionTime());
		}
		
	}
	
	//DisputeResolution.DisputeResolutionImpl
	class DisputeResolutionImpl implements DisputeResolution {
		private final String alternativeTerms;
		private final String otherTerms;
		private final RecalculationOfValue recalculationOfValue;
		private final BusinessCenterTime resolutionTime;
		private final String valueTerms;
		
		protected DisputeResolutionImpl(DisputeResolution.DisputeResolutionBuilder builder) {
			this.alternativeTerms = builder.getAlternativeTerms();
			this.otherTerms = builder.getOtherTerms();
			this.recalculationOfValue = ofNullable(builder.getRecalculationOfValue()).map(f->f.build()).orElse(null);
			this.resolutionTime = ofNullable(builder.getResolutionTime()).map(f->f.build()).orElse(null);
			this.valueTerms = builder.getValueTerms();
		}
		
		@Override
		public String getAlternativeTerms() {
			return alternativeTerms;
		}
		
		@Override
		public String getOtherTerms() {
			return otherTerms;
		}
		
		@Override
		public RecalculationOfValue getRecalculationOfValue() {
			return recalculationOfValue;
		}
		
		@Override
		public BusinessCenterTime getResolutionTime() {
			return resolutionTime;
		}
		
		@Override
		public String getValueTerms() {
			return valueTerms;
		}
		
		@Override
		public DisputeResolution build() {
			return this;
		}
		
		@Override
		public DisputeResolution.DisputeResolutionBuilder toBuilder() {
			DisputeResolution.DisputeResolutionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DisputeResolution.DisputeResolutionBuilder builder) {
			ofNullable(getAlternativeTerms()).ifPresent(builder::setAlternativeTerms);
			ofNullable(getOtherTerms()).ifPresent(builder::setOtherTerms);
			ofNullable(getRecalculationOfValue()).ifPresent(builder::setRecalculationOfValue);
			ofNullable(getResolutionTime()).ifPresent(builder::setResolutionTime);
			ofNullable(getValueTerms()).ifPresent(builder::setValueTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DisputeResolution _that = getType().cast(o);
		
			if (!Objects.equals(alternativeTerms, _that.getAlternativeTerms())) return false;
			if (!Objects.equals(otherTerms, _that.getOtherTerms())) return false;
			if (!Objects.equals(recalculationOfValue, _that.getRecalculationOfValue())) return false;
			if (!Objects.equals(resolutionTime, _that.getResolutionTime())) return false;
			if (!Objects.equals(valueTerms, _that.getValueTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (alternativeTerms != null ? alternativeTerms.hashCode() : 0);
			_result = 31 * _result + (otherTerms != null ? otherTerms.hashCode() : 0);
			_result = 31 * _result + (recalculationOfValue != null ? recalculationOfValue.hashCode() : 0);
			_result = 31 * _result + (resolutionTime != null ? resolutionTime.hashCode() : 0);
			_result = 31 * _result + (valueTerms != null ? valueTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DisputeResolution {" +
				"alternativeTerms=" + this.alternativeTerms + ", " +
				"otherTerms=" + this.otherTerms + ", " +
				"recalculationOfValue=" + this.recalculationOfValue + ", " +
				"resolutionTime=" + this.resolutionTime + ", " +
				"valueTerms=" + this.valueTerms +
			'}';
		}
	}
	
	//DisputeResolution.DisputeResolutionBuilderImpl
	class DisputeResolutionBuilderImpl implements DisputeResolution.DisputeResolutionBuilder {
	
		protected String alternativeTerms;
		protected String otherTerms;
		protected RecalculationOfValue.RecalculationOfValueBuilder recalculationOfValue;
		protected BusinessCenterTime.BusinessCenterTimeBuilder resolutionTime;
		protected String valueTerms;
	
		public DisputeResolutionBuilderImpl() {
		}
	
		@Override
		public String getAlternativeTerms() {
			return alternativeTerms;
		}
		
		@Override
		public String getOtherTerms() {
			return otherTerms;
		}
		
		@Override
		public RecalculationOfValue.RecalculationOfValueBuilder getRecalculationOfValue() {
			return recalculationOfValue;
		}
		
		@Override
		public RecalculationOfValue.RecalculationOfValueBuilder getOrCreateRecalculationOfValue() {
			RecalculationOfValue.RecalculationOfValueBuilder result;
			if (recalculationOfValue!=null) {
				result = recalculationOfValue;
			}
			else {
				result = recalculationOfValue = RecalculationOfValue.builder();
			}
			
			return result;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getResolutionTime() {
			return resolutionTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateResolutionTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (resolutionTime!=null) {
				result = resolutionTime;
			}
			else {
				result = resolutionTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		public String getValueTerms() {
			return valueTerms;
		}
		
	
		@Override
		public DisputeResolution.DisputeResolutionBuilder setAlternativeTerms(String alternativeTerms) {
			this.alternativeTerms = alternativeTerms==null?null:alternativeTerms;
			return this;
		}
		@Override
		public DisputeResolution.DisputeResolutionBuilder setOtherTerms(String otherTerms) {
			this.otherTerms = otherTerms==null?null:otherTerms;
			return this;
		}
		@Override
		public DisputeResolution.DisputeResolutionBuilder setRecalculationOfValue(RecalculationOfValue recalculationOfValue) {
			this.recalculationOfValue = recalculationOfValue==null?null:recalculationOfValue.toBuilder();
			return this;
		}
		@Override
		public DisputeResolution.DisputeResolutionBuilder setResolutionTime(BusinessCenterTime resolutionTime) {
			this.resolutionTime = resolutionTime==null?null:resolutionTime.toBuilder();
			return this;
		}
		@Override
		public DisputeResolution.DisputeResolutionBuilder setValueTerms(String valueTerms) {
			this.valueTerms = valueTerms==null?null:valueTerms;
			return this;
		}
		
		@Override
		public DisputeResolution build() {
			return new DisputeResolution.DisputeResolutionImpl(this);
		}
		
		@Override
		public DisputeResolution.DisputeResolutionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DisputeResolution.DisputeResolutionBuilder prune() {
			if (recalculationOfValue!=null && !recalculationOfValue.prune().hasData()) recalculationOfValue = null;
			if (resolutionTime!=null && !resolutionTime.prune().hasData()) resolutionTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAlternativeTerms()!=null) return true;
			if (getOtherTerms()!=null) return true;
			if (getRecalculationOfValue()!=null && getRecalculationOfValue().hasData()) return true;
			if (getResolutionTime()!=null && getResolutionTime().hasData()) return true;
			if (getValueTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DisputeResolution.DisputeResolutionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DisputeResolution.DisputeResolutionBuilder o = (DisputeResolution.DisputeResolutionBuilder) other;
			
			merger.mergeRosetta(getRecalculationOfValue(), o.getRecalculationOfValue(), this::setRecalculationOfValue);
			merger.mergeRosetta(getResolutionTime(), o.getResolutionTime(), this::setResolutionTime);
			
			merger.mergeBasic(getAlternativeTerms(), o.getAlternativeTerms(), this::setAlternativeTerms);
			merger.mergeBasic(getOtherTerms(), o.getOtherTerms(), this::setOtherTerms);
			merger.mergeBasic(getValueTerms(), o.getValueTerms(), this::setValueTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DisputeResolution _that = getType().cast(o);
		
			if (!Objects.equals(alternativeTerms, _that.getAlternativeTerms())) return false;
			if (!Objects.equals(otherTerms, _that.getOtherTerms())) return false;
			if (!Objects.equals(recalculationOfValue, _that.getRecalculationOfValue())) return false;
			if (!Objects.equals(resolutionTime, _that.getResolutionTime())) return false;
			if (!Objects.equals(valueTerms, _that.getValueTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (alternativeTerms != null ? alternativeTerms.hashCode() : 0);
			_result = 31 * _result + (otherTerms != null ? otherTerms.hashCode() : 0);
			_result = 31 * _result + (recalculationOfValue != null ? recalculationOfValue.hashCode() : 0);
			_result = 31 * _result + (resolutionTime != null ? resolutionTime.hashCode() : 0);
			_result = 31 * _result + (valueTerms != null ? valueTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DisputeResolutionBuilder {" +
				"alternativeTerms=" + this.alternativeTerms + ", " +
				"otherTerms=" + this.otherTerms + ", " +
				"recalculationOfValue=" + this.recalculationOfValue + ", " +
				"resolutionTime=" + this.resolutionTime + ", " +
				"valueTerms=" + this.valueTerms +
			'}';
		}
	}
}
