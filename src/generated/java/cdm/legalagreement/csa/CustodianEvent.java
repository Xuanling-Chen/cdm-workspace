package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CustodianEventMeta;
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
 * A class to specify the Custodian Event (English Law &amp; New York Law ISDA CSA) and the Collateral Manager Event (Japanese Law ISDA CSA) in terms of applicability and end-date. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (n)(iii): Custodian Event. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (m)(ii): Collateral Manager Event. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(iii): Custodian Event.
 * @version ${project.version}
 */
@RosettaClass

public interface CustodianEvent extends RosettaModelObject {
	CustodianEvent build();
	CustodianEvent.CustodianEventBuilder toBuilder();
	
	/**
	 * The qualification of the Custodian Event (English Law &amp; New York Law ISDA CSA) or Collateral Manager Event (Japanese Law ISDA CSA) End Date.
	 */
	CustodianEventEndDate getEndDate();
	/**
	 * The qualification as to whether the Custodian Event (English Law &amp; New York Law ISDA CSA) or the Collateral Manager Event (Japanese Law ISDA CSA) is applicable.
	 */
	Boolean getIsApplicable();
	final static CustodianEventMeta metaData = new CustodianEventMeta();
	
	@Override
	default RosettaMetaData<? extends CustodianEvent> metaData() {
		return metaData;
	} 
			
	static CustodianEvent.CustodianEventBuilder builder() {
		return new CustodianEvent.CustodianEventBuilderImpl();
	}
	
	default Class<? extends CustodianEvent> getType() {
		return CustodianEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		
		processRosetta(path.newSubPath("endDate"), processor, CustodianEventEndDate.class, getEndDate());
	}
	
	
	interface CustodianEventBuilder extends CustodianEvent, RosettaModelObjectBuilder {
		CustodianEventEndDate.CustodianEventEndDateBuilder getOrCreateEndDate();
		CustodianEventEndDate.CustodianEventEndDateBuilder getEndDate();
		CustodianEvent.CustodianEventBuilder setEndDate(CustodianEventEndDate endDate);
		CustodianEvent.CustodianEventBuilder setIsApplicable(Boolean isApplicable);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			
			processRosetta(path.newSubPath("endDate"), processor, CustodianEventEndDate.CustodianEventEndDateBuilder.class, getEndDate());
		}
		
	}
	
	//CustodianEvent.CustodianEventImpl
	class CustodianEventImpl implements CustodianEvent {
		private final CustodianEventEndDate endDate;
		private final Boolean isApplicable;
		
		protected CustodianEventImpl(CustodianEvent.CustodianEventBuilder builder) {
			this.endDate = ofNullable(builder.getEndDate()).map(f->f.build()).orElse(null);
			this.isApplicable = builder.getIsApplicable();
		}
		
		@Override
		public CustodianEventEndDate getEndDate() {
			return endDate;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CustodianEvent build() {
			return this;
		}
		
		@Override
		public CustodianEvent.CustodianEventBuilder toBuilder() {
			CustodianEvent.CustodianEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodianEvent.CustodianEventBuilder builder) {
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianEvent _that = getType().cast(o);
		
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianEvent {" +
				"endDate=" + this.endDate + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}
	
	//CustodianEvent.CustodianEventBuilderImpl
	class CustodianEventBuilderImpl implements CustodianEvent.CustodianEventBuilder {
	
		protected CustodianEventEndDate.CustodianEventEndDateBuilder endDate;
		protected Boolean isApplicable;
	
		public CustodianEventBuilderImpl() {
		}
	
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder getEndDate() {
			return endDate;
		}
		
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder getOrCreateEndDate() {
			CustodianEventEndDate.CustodianEventEndDateBuilder result;
			if (endDate!=null) {
				result = endDate;
			}
			else {
				result = endDate = CustodianEventEndDate.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
	
		@Override
		public CustodianEvent.CustodianEventBuilder setEndDate(CustodianEventEndDate endDate) {
			this.endDate = endDate==null?null:endDate.toBuilder();
			return this;
		}
		@Override
		public CustodianEvent.CustodianEventBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		
		@Override
		public CustodianEvent build() {
			return new CustodianEvent.CustodianEventImpl(this);
		}
		
		@Override
		public CustodianEvent.CustodianEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianEvent.CustodianEventBuilder prune() {
			if (endDate!=null && !endDate.prune().hasData()) endDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEndDate()!=null && getEndDate().hasData()) return true;
			if (getIsApplicable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianEvent.CustodianEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodianEvent.CustodianEventBuilder o = (CustodianEvent.CustodianEventBuilder) other;
			
			merger.mergeRosetta(getEndDate(), o.getEndDate(), this::setEndDate);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianEvent _that = getType().cast(o);
		
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianEventBuilder {" +
				"endDate=" + this.endDate + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}
}
