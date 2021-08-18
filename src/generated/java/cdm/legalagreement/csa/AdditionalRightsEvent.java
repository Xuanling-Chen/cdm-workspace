package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.AdditionalRightsEventMeta;
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
 * A class to specify the Pledgor/Obligor/Chargor Additional Rights Event election. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (k): Chargor Additional Rights Event. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (k): Obligor Additional Rights Event. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (k): Pledgor Additional Rights Event.
 * @version ${project.version}
 */
@RosettaClass

public interface AdditionalRightsEvent extends RosettaModelObject {
	AdditionalRightsEvent build();
	AdditionalRightsEvent.AdditionalRightsEventBuilder toBuilder();
	
	/**
	 * The Pledgor Additional Rights Event election is applicable when True, and not applicable when False.
	 */
	Boolean getIsApplicable();
	/**
	 * The qualification of the Pledgor Additional Rights Event election, when specified.
	 */
	String getQualification();
	final static AdditionalRightsEventMeta metaData = new AdditionalRightsEventMeta();
	
	@Override
	default RosettaMetaData<? extends AdditionalRightsEvent> metaData() {
		return metaData;
	} 
			
	static AdditionalRightsEvent.AdditionalRightsEventBuilder builder() {
		return new AdditionalRightsEvent.AdditionalRightsEventBuilderImpl();
	}
	
	default Class<? extends AdditionalRightsEvent> getType() {
		return AdditionalRightsEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("qualification"), String.class, getQualification(), this);
		
	}
	
	
	interface AdditionalRightsEventBuilder extends AdditionalRightsEvent, RosettaModelObjectBuilder {
		AdditionalRightsEvent.AdditionalRightsEventBuilder setIsApplicable(Boolean isApplicable);
		AdditionalRightsEvent.AdditionalRightsEventBuilder setQualification(String qualification);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("qualification"), String.class, getQualification(), this);
			
		}
		
	}
	
	//AdditionalRightsEvent.AdditionalRightsEventImpl
	class AdditionalRightsEventImpl implements AdditionalRightsEvent {
		private final Boolean isApplicable;
		private final String qualification;
		
		protected AdditionalRightsEventImpl(AdditionalRightsEvent.AdditionalRightsEventBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.qualification = builder.getQualification();
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public String getQualification() {
			return qualification;
		}
		
		@Override
		public AdditionalRightsEvent build() {
			return this;
		}
		
		@Override
		public AdditionalRightsEvent.AdditionalRightsEventBuilder toBuilder() {
			AdditionalRightsEvent.AdditionalRightsEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalRightsEvent.AdditionalRightsEventBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getQualification()).ifPresent(builder::setQualification);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRightsEvent _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(qualification, _that.getQualification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (qualification != null ? qualification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalRightsEvent {" +
				"isApplicable=" + this.isApplicable + ", " +
				"qualification=" + this.qualification +
			'}';
		}
	}
	
	//AdditionalRightsEvent.AdditionalRightsEventBuilderImpl
	class AdditionalRightsEventBuilderImpl implements AdditionalRightsEvent.AdditionalRightsEventBuilder {
	
		protected Boolean isApplicable;
		protected String qualification;
	
		public AdditionalRightsEventBuilderImpl() {
		}
	
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public String getQualification() {
			return qualification;
		}
		
	
		@Override
		public AdditionalRightsEvent.AdditionalRightsEventBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public AdditionalRightsEvent.AdditionalRightsEventBuilder setQualification(String qualification) {
			this.qualification = qualification==null?null:qualification;
			return this;
		}
		
		@Override
		public AdditionalRightsEvent build() {
			return new AdditionalRightsEvent.AdditionalRightsEventImpl(this);
		}
		
		@Override
		public AdditionalRightsEvent.AdditionalRightsEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalRightsEvent.AdditionalRightsEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getQualification()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalRightsEvent.AdditionalRightsEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalRightsEvent.AdditionalRightsEventBuilder o = (AdditionalRightsEvent.AdditionalRightsEventBuilder) other;
			
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getQualification(), o.getQualification(), this::setQualification);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRightsEvent _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(qualification, _that.getQualification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (qualification != null ? qualification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalRightsEventBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"qualification=" + this.qualification +
			'}';
		}
	}
}
