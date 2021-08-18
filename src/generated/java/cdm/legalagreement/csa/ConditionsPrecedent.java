package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.ConditionsPrecedentMeta;
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
 * A class to specify the two set of elections that may overwrite the default Condition Precedent provision as specified in Paragraph 4, (a) of the ISDA 2016 Credit Support Annex for Initial Margin and the ISDA 2016 Credit Support Annex for Variation Margin. | ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e): Conditions Precedent. | ISDA 2018 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e): Conditions Precedent. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f): Conditions Precedent. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e): Conditions Precedent. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (e): Conditions Precedent and Secured Party’s Rights and Remedies.
 * @version ${project.version}
 */
@RosettaClass

public interface ConditionsPrecedent extends RosettaModelObject {
	ConditionsPrecedent build();
	ConditionsPrecedent.ConditionsPrecedentBuilder toBuilder();
	
	/**
	 * The parties&#39; election with respect to the Termination Events that will be deemed an Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f)(ii). | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (e): Conditions Precedent and Secured Party’s Rights and Remedies.
	 */
	AccessConditions getAccessConditions();
	/**
	 * The election to specify whether the standard Conditions Precedent apply
	 */
	ExceptionEnum getConditionsPrecedentElection();
	/**
	 * The custom provisions that might be specified by the parties to the agreement for the purpose of overwriting the default Condition Precedent provision as specified in ISDA 2016 Credit Support Annex for Initial Margin and the ISDA 2016 Credit Support Annex for Variation Margin, Paragraph 4, (a). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e)(i). | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f)(i). | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(i). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, : Conditions Precedent and Secured Party’s Rights and Remedies.
	 */
	String getCustomProvision();
	final static ConditionsPrecedentMeta metaData = new ConditionsPrecedentMeta();
	
	@Override
	default RosettaMetaData<? extends ConditionsPrecedent> metaData() {
		return metaData;
	} 
			
	static ConditionsPrecedent.ConditionsPrecedentBuilder builder() {
		return new ConditionsPrecedent.ConditionsPrecedentBuilderImpl();
	}
	
	default Class<? extends ConditionsPrecedent> getType() {
		return ConditionsPrecedent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("conditionsPrecedentElection"), ExceptionEnum.class, getConditionsPrecedentElection(), this);
		processor.processBasic(path.newSubPath("customProvision"), String.class, getCustomProvision(), this);
		
		processRosetta(path.newSubPath("accessConditions"), processor, AccessConditions.class, getAccessConditions());
	}
	
	
	interface ConditionsPrecedentBuilder extends ConditionsPrecedent, RosettaModelObjectBuilder {
		AccessConditions.AccessConditionsBuilder getOrCreateAccessConditions();
		AccessConditions.AccessConditionsBuilder getAccessConditions();
		ConditionsPrecedent.ConditionsPrecedentBuilder setAccessConditions(AccessConditions accessConditions);
		ConditionsPrecedent.ConditionsPrecedentBuilder setConditionsPrecedentElection(ExceptionEnum conditionsPrecedentElection);
		ConditionsPrecedent.ConditionsPrecedentBuilder setCustomProvision(String customProvision);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("conditionsPrecedentElection"), ExceptionEnum.class, getConditionsPrecedentElection(), this);
			processor.processBasic(path.newSubPath("customProvision"), String.class, getCustomProvision(), this);
			
			processRosetta(path.newSubPath("accessConditions"), processor, AccessConditions.AccessConditionsBuilder.class, getAccessConditions());
		}
		
	}
	
	//ConditionsPrecedent.ConditionsPrecedentImpl
	class ConditionsPrecedentImpl implements ConditionsPrecedent {
		private final AccessConditions accessConditions;
		private final ExceptionEnum conditionsPrecedentElection;
		private final String customProvision;
		
		protected ConditionsPrecedentImpl(ConditionsPrecedent.ConditionsPrecedentBuilder builder) {
			this.accessConditions = ofNullable(builder.getAccessConditions()).map(f->f.build()).orElse(null);
			this.conditionsPrecedentElection = builder.getConditionsPrecedentElection();
			this.customProvision = builder.getCustomProvision();
		}
		
		@Override
		public AccessConditions getAccessConditions() {
			return accessConditions;
		}
		
		@Override
		public ExceptionEnum getConditionsPrecedentElection() {
			return conditionsPrecedentElection;
		}
		
		@Override
		public String getCustomProvision() {
			return customProvision;
		}
		
		@Override
		public ConditionsPrecedent build() {
			return this;
		}
		
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder toBuilder() {
			ConditionsPrecedent.ConditionsPrecedentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConditionsPrecedent.ConditionsPrecedentBuilder builder) {
			ofNullable(getAccessConditions()).ifPresent(builder::setAccessConditions);
			ofNullable(getConditionsPrecedentElection()).ifPresent(builder::setConditionsPrecedentElection);
			ofNullable(getCustomProvision()).ifPresent(builder::setCustomProvision);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConditionsPrecedent _that = getType().cast(o);
		
			if (!Objects.equals(accessConditions, _that.getAccessConditions())) return false;
			if (!Objects.equals(conditionsPrecedentElection, _that.getConditionsPrecedentElection())) return false;
			if (!Objects.equals(customProvision, _that.getCustomProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accessConditions != null ? accessConditions.hashCode() : 0);
			_result = 31 * _result + (conditionsPrecedentElection != null ? conditionsPrecedentElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customProvision != null ? customProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConditionsPrecedent {" +
				"accessConditions=" + this.accessConditions + ", " +
				"conditionsPrecedentElection=" + this.conditionsPrecedentElection + ", " +
				"customProvision=" + this.customProvision +
			'}';
		}
	}
	
	//ConditionsPrecedent.ConditionsPrecedentBuilderImpl
	class ConditionsPrecedentBuilderImpl implements ConditionsPrecedent.ConditionsPrecedentBuilder {
	
		protected AccessConditions.AccessConditionsBuilder accessConditions;
		protected ExceptionEnum conditionsPrecedentElection;
		protected String customProvision;
	
		public ConditionsPrecedentBuilderImpl() {
		}
	
		@Override
		public AccessConditions.AccessConditionsBuilder getAccessConditions() {
			return accessConditions;
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder getOrCreateAccessConditions() {
			AccessConditions.AccessConditionsBuilder result;
			if (accessConditions!=null) {
				result = accessConditions;
			}
			else {
				result = accessConditions = AccessConditions.builder();
			}
			
			return result;
		}
		
		@Override
		public ExceptionEnum getConditionsPrecedentElection() {
			return conditionsPrecedentElection;
		}
		
		@Override
		public String getCustomProvision() {
			return customProvision;
		}
		
	
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder setAccessConditions(AccessConditions accessConditions) {
			this.accessConditions = accessConditions==null?null:accessConditions.toBuilder();
			return this;
		}
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder setConditionsPrecedentElection(ExceptionEnum conditionsPrecedentElection) {
			this.conditionsPrecedentElection = conditionsPrecedentElection==null?null:conditionsPrecedentElection;
			return this;
		}
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder setCustomProvision(String customProvision) {
			this.customProvision = customProvision==null?null:customProvision;
			return this;
		}
		
		@Override
		public ConditionsPrecedent build() {
			return new ConditionsPrecedent.ConditionsPrecedentImpl(this);
		}
		
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder prune() {
			if (accessConditions!=null && !accessConditions.prune().hasData()) accessConditions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccessConditions()!=null && getAccessConditions().hasData()) return true;
			if (getConditionsPrecedentElection()!=null) return true;
			if (getCustomProvision()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ConditionsPrecedent.ConditionsPrecedentBuilder o = (ConditionsPrecedent.ConditionsPrecedentBuilder) other;
			
			merger.mergeRosetta(getAccessConditions(), o.getAccessConditions(), this::setAccessConditions);
			
			merger.mergeBasic(getConditionsPrecedentElection(), o.getConditionsPrecedentElection(), this::setConditionsPrecedentElection);
			merger.mergeBasic(getCustomProvision(), o.getCustomProvision(), this::setCustomProvision);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConditionsPrecedent _that = getType().cast(o);
		
			if (!Objects.equals(accessConditions, _that.getAccessConditions())) return false;
			if (!Objects.equals(conditionsPrecedentElection, _that.getConditionsPrecedentElection())) return false;
			if (!Objects.equals(customProvision, _that.getCustomProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accessConditions != null ? accessConditions.hashCode() : 0);
			_result = 31 * _result + (conditionsPrecedentElection != null ? conditionsPrecedentElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customProvision != null ? customProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConditionsPrecedentBuilder {" +
				"accessConditions=" + this.accessConditions + ", " +
				"conditionsPrecedentElection=" + this.conditionsPrecedentElection + ", " +
				"customProvision=" + this.customProvision +
			'}';
		}
	}
}
