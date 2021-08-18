package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.OneWayProvisionsMeta;
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
 * A class to specify whether One Way Provisions apply in relation to the ISDA CSA for Initial Margin and, if yes, to specify the Posting Party. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles (aa): One Way Provisions.
 * @version ${project.version}
 */
@RosettaClass

public interface OneWayProvisions extends RosettaModelObject {
	OneWayProvisions build();
	OneWayProvisions.OneWayProvisionsBuilder toBuilder();
	
	/**
	 * The determination of whether the One Way Provisions are applicable (true) or not applicable (false).
	 */
	Boolean getIsApplicable();
	/**
	 * The Posting Party for the purposes of One Way Provisions. It is specified in the case where the One Way Provision is deemed applicable.
	 */
	CounterpartyRoleEnum getPostingParty();
	final static OneWayProvisionsMeta metaData = new OneWayProvisionsMeta();
	
	@Override
	default RosettaMetaData<? extends OneWayProvisions> metaData() {
		return metaData;
	} 
			
	static OneWayProvisions.OneWayProvisionsBuilder builder() {
		return new OneWayProvisions.OneWayProvisionsBuilderImpl();
	}
	
	default Class<? extends OneWayProvisions> getType() {
		return OneWayProvisions.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("postingParty"), CounterpartyRoleEnum.class, getPostingParty(), this);
		
	}
	
	
	interface OneWayProvisionsBuilder extends OneWayProvisions, RosettaModelObjectBuilder {
		OneWayProvisions.OneWayProvisionsBuilder setIsApplicable(Boolean isApplicable);
		OneWayProvisions.OneWayProvisionsBuilder setPostingParty(CounterpartyRoleEnum postingParty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("postingParty"), CounterpartyRoleEnum.class, getPostingParty(), this);
			
		}
		
	}
	
	//OneWayProvisions.OneWayProvisionsImpl
	class OneWayProvisionsImpl implements OneWayProvisions {
		private final Boolean isApplicable;
		private final CounterpartyRoleEnum postingParty;
		
		protected OneWayProvisionsImpl(OneWayProvisions.OneWayProvisionsBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.postingParty = builder.getPostingParty();
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CounterpartyRoleEnum getPostingParty() {
			return postingParty;
		}
		
		@Override
		public OneWayProvisions build() {
			return this;
		}
		
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder toBuilder() {
			OneWayProvisions.OneWayProvisionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OneWayProvisions.OneWayProvisionsBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getPostingParty()).ifPresent(builder::setPostingParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OneWayProvisions _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(postingParty, _that.getPostingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (postingParty != null ? postingParty.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OneWayProvisions {" +
				"isApplicable=" + this.isApplicable + ", " +
				"postingParty=" + this.postingParty +
			'}';
		}
	}
	
	//OneWayProvisions.OneWayProvisionsBuilderImpl
	class OneWayProvisionsBuilderImpl implements OneWayProvisions.OneWayProvisionsBuilder {
	
		protected Boolean isApplicable;
		protected CounterpartyRoleEnum postingParty;
	
		public OneWayProvisionsBuilderImpl() {
		}
	
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CounterpartyRoleEnum getPostingParty() {
			return postingParty;
		}
		
	
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder setPostingParty(CounterpartyRoleEnum postingParty) {
			this.postingParty = postingParty==null?null:postingParty;
			return this;
		}
		
		@Override
		public OneWayProvisions build() {
			return new OneWayProvisions.OneWayProvisionsImpl(this);
		}
		
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getPostingParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OneWayProvisions.OneWayProvisionsBuilder o = (OneWayProvisions.OneWayProvisionsBuilder) other;
			
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getPostingParty(), o.getPostingParty(), this::setPostingParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OneWayProvisions _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(postingParty, _that.getPostingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (postingParty != null ? postingParty.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OneWayProvisionsBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"postingParty=" + this.postingParty +
			'}';
		}
	}
}
