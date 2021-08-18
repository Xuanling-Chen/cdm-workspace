package cdm.legalagreement.csa;

import cdm.base.datetime.CustomisableOffset;
import cdm.legalagreement.csa.meta.CustodianEventEndDateMeta;
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
 * A class to specify the Custodian Event (English Law &amp; New York Law ISDA CSA) or Collateral Manager Event (Japanese Law ISDA CSA) End Date. Its qualification is function of three elective periods: either (i) a specified number of days after the occurrence of the Custodian Event (the daysAfterCustodianEvent attribute), or (ii) the number of days prior to the date on which the Control Agreement will terminate, with in this latter case (iii) the further qualification of the number of days prior to the Release Date if only one party has effectively provided the Timely Statement to the other party. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (n)(iii): CE End Date. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (m)(ii): CME End Date. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(iii): CE End Date.
 * @version ${project.version}
 */
@RosettaClass

public interface CustodianEventEndDate extends RosettaModelObject {
	CustodianEventEndDate build();
	CustodianEventEndDate.CustodianEventEndDateBuilder toBuilder();
	
	/**
	 * The parties&#39; election to specify the number of days one party has effectively provided the Timely Statement to the other party.
	 */
	CustomisableOffset getDateOfTimelyStatement();
	/**
	 * The parties&#39; election to specify the number of days after the occurrence of the Custodian Event (English Law &amp; New York Law ISDA CSA) or the Collateral Management Event (Japanese Law ISDA CSA) for the purpose of qualifying the CE/CME End Date.
	 */
	CustomisableOffset getDaysAfterCustodianEvent();
	/**
	 * The parties&#39; election to specify the number of days prior to the termination of the Control Agreement (English Law &amp; New York Law ISDA CSA) or the Collateral Management Event (Japanese Law ISDA CSA) for the purpose of qualifying the CE/CME End Date, in the case where advance notice is given.
	 */
	CustomisableOffset getReleaseDate();
	/**
	 * The parties&#39; election to specify the number of days prior to the end of the safekeeping period (Clearstream CTA) purpose of qualifying the CE/CME End Date, in the case where advance notice is given.
	 */
	CustomisableOffset getSafekeepingPeriodExpiry();
	final static CustodianEventEndDateMeta metaData = new CustodianEventEndDateMeta();
	
	@Override
	default RosettaMetaData<? extends CustodianEventEndDate> metaData() {
		return metaData;
	} 
			
	static CustodianEventEndDate.CustodianEventEndDateBuilder builder() {
		return new CustodianEventEndDate.CustodianEventEndDateBuilderImpl();
	}
	
	default Class<? extends CustodianEventEndDate> getType() {
		return CustodianEventEndDate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("dateOfTimelyStatement"), processor, CustomisableOffset.class, getDateOfTimelyStatement());
		processRosetta(path.newSubPath("daysAfterCustodianEvent"), processor, CustomisableOffset.class, getDaysAfterCustodianEvent());
		processRosetta(path.newSubPath("releaseDate"), processor, CustomisableOffset.class, getReleaseDate());
		processRosetta(path.newSubPath("safekeepingPeriodExpiry"), processor, CustomisableOffset.class, getSafekeepingPeriodExpiry());
	}
	
	
	interface CustodianEventEndDateBuilder extends CustodianEventEndDate, RosettaModelObjectBuilder {
		CustomisableOffset.CustomisableOffsetBuilder getOrCreateDateOfTimelyStatement();
		CustomisableOffset.CustomisableOffsetBuilder getDateOfTimelyStatement();
		CustomisableOffset.CustomisableOffsetBuilder getOrCreateDaysAfterCustodianEvent();
		CustomisableOffset.CustomisableOffsetBuilder getDaysAfterCustodianEvent();
		CustomisableOffset.CustomisableOffsetBuilder getOrCreateReleaseDate();
		CustomisableOffset.CustomisableOffsetBuilder getReleaseDate();
		CustomisableOffset.CustomisableOffsetBuilder getOrCreateSafekeepingPeriodExpiry();
		CustomisableOffset.CustomisableOffsetBuilder getSafekeepingPeriodExpiry();
		CustodianEventEndDate.CustodianEventEndDateBuilder setDateOfTimelyStatement(CustomisableOffset dateOfTimelyStatement);
		CustodianEventEndDate.CustodianEventEndDateBuilder setDaysAfterCustodianEvent(CustomisableOffset daysAfterCustodianEvent);
		CustodianEventEndDate.CustodianEventEndDateBuilder setReleaseDate(CustomisableOffset releaseDate);
		CustodianEventEndDate.CustodianEventEndDateBuilder setSafekeepingPeriodExpiry(CustomisableOffset safekeepingPeriodExpiry);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("dateOfTimelyStatement"), processor, CustomisableOffset.CustomisableOffsetBuilder.class, getDateOfTimelyStatement());
			processRosetta(path.newSubPath("daysAfterCustodianEvent"), processor, CustomisableOffset.CustomisableOffsetBuilder.class, getDaysAfterCustodianEvent());
			processRosetta(path.newSubPath("releaseDate"), processor, CustomisableOffset.CustomisableOffsetBuilder.class, getReleaseDate());
			processRosetta(path.newSubPath("safekeepingPeriodExpiry"), processor, CustomisableOffset.CustomisableOffsetBuilder.class, getSafekeepingPeriodExpiry());
		}
		
	}
	
	//CustodianEventEndDate.CustodianEventEndDateImpl
	class CustodianEventEndDateImpl implements CustodianEventEndDate {
		private final CustomisableOffset dateOfTimelyStatement;
		private final CustomisableOffset daysAfterCustodianEvent;
		private final CustomisableOffset releaseDate;
		private final CustomisableOffset safekeepingPeriodExpiry;
		
		protected CustodianEventEndDateImpl(CustodianEventEndDate.CustodianEventEndDateBuilder builder) {
			this.dateOfTimelyStatement = ofNullable(builder.getDateOfTimelyStatement()).map(f->f.build()).orElse(null);
			this.daysAfterCustodianEvent = ofNullable(builder.getDaysAfterCustodianEvent()).map(f->f.build()).orElse(null);
			this.releaseDate = ofNullable(builder.getReleaseDate()).map(f->f.build()).orElse(null);
			this.safekeepingPeriodExpiry = ofNullable(builder.getSafekeepingPeriodExpiry()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CustomisableOffset getDateOfTimelyStatement() {
			return dateOfTimelyStatement;
		}
		
		@Override
		public CustomisableOffset getDaysAfterCustodianEvent() {
			return daysAfterCustodianEvent;
		}
		
		@Override
		public CustomisableOffset getReleaseDate() {
			return releaseDate;
		}
		
		@Override
		public CustomisableOffset getSafekeepingPeriodExpiry() {
			return safekeepingPeriodExpiry;
		}
		
		@Override
		public CustodianEventEndDate build() {
			return this;
		}
		
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder toBuilder() {
			CustodianEventEndDate.CustodianEventEndDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodianEventEndDate.CustodianEventEndDateBuilder builder) {
			ofNullable(getDateOfTimelyStatement()).ifPresent(builder::setDateOfTimelyStatement);
			ofNullable(getDaysAfterCustodianEvent()).ifPresent(builder::setDaysAfterCustodianEvent);
			ofNullable(getReleaseDate()).ifPresent(builder::setReleaseDate);
			ofNullable(getSafekeepingPeriodExpiry()).ifPresent(builder::setSafekeepingPeriodExpiry);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianEventEndDate _that = getType().cast(o);
		
			if (!Objects.equals(dateOfTimelyStatement, _that.getDateOfTimelyStatement())) return false;
			if (!Objects.equals(daysAfterCustodianEvent, _that.getDaysAfterCustodianEvent())) return false;
			if (!Objects.equals(releaseDate, _that.getReleaseDate())) return false;
			if (!Objects.equals(safekeepingPeriodExpiry, _that.getSafekeepingPeriodExpiry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateOfTimelyStatement != null ? dateOfTimelyStatement.hashCode() : 0);
			_result = 31 * _result + (daysAfterCustodianEvent != null ? daysAfterCustodianEvent.hashCode() : 0);
			_result = 31 * _result + (releaseDate != null ? releaseDate.hashCode() : 0);
			_result = 31 * _result + (safekeepingPeriodExpiry != null ? safekeepingPeriodExpiry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianEventEndDate {" +
				"dateOfTimelyStatement=" + this.dateOfTimelyStatement + ", " +
				"daysAfterCustodianEvent=" + this.daysAfterCustodianEvent + ", " +
				"releaseDate=" + this.releaseDate + ", " +
				"safekeepingPeriodExpiry=" + this.safekeepingPeriodExpiry +
			'}';
		}
	}
	
	//CustodianEventEndDate.CustodianEventEndDateBuilderImpl
	class CustodianEventEndDateBuilderImpl implements CustodianEventEndDate.CustodianEventEndDateBuilder {
	
		protected CustomisableOffset.CustomisableOffsetBuilder dateOfTimelyStatement;
		protected CustomisableOffset.CustomisableOffsetBuilder daysAfterCustodianEvent;
		protected CustomisableOffset.CustomisableOffsetBuilder releaseDate;
		protected CustomisableOffset.CustomisableOffsetBuilder safekeepingPeriodExpiry;
	
		public CustodianEventEndDateBuilderImpl() {
		}
	
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getDateOfTimelyStatement() {
			return dateOfTimelyStatement;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getOrCreateDateOfTimelyStatement() {
			CustomisableOffset.CustomisableOffsetBuilder result;
			if (dateOfTimelyStatement!=null) {
				result = dateOfTimelyStatement;
			}
			else {
				result = dateOfTimelyStatement = CustomisableOffset.builder();
			}
			
			return result;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getDaysAfterCustodianEvent() {
			return daysAfterCustodianEvent;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getOrCreateDaysAfterCustodianEvent() {
			CustomisableOffset.CustomisableOffsetBuilder result;
			if (daysAfterCustodianEvent!=null) {
				result = daysAfterCustodianEvent;
			}
			else {
				result = daysAfterCustodianEvent = CustomisableOffset.builder();
			}
			
			return result;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getReleaseDate() {
			return releaseDate;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getOrCreateReleaseDate() {
			CustomisableOffset.CustomisableOffsetBuilder result;
			if (releaseDate!=null) {
				result = releaseDate;
			}
			else {
				result = releaseDate = CustomisableOffset.builder();
			}
			
			return result;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getSafekeepingPeriodExpiry() {
			return safekeepingPeriodExpiry;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getOrCreateSafekeepingPeriodExpiry() {
			CustomisableOffset.CustomisableOffsetBuilder result;
			if (safekeepingPeriodExpiry!=null) {
				result = safekeepingPeriodExpiry;
			}
			else {
				result = safekeepingPeriodExpiry = CustomisableOffset.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder setDateOfTimelyStatement(CustomisableOffset dateOfTimelyStatement) {
			this.dateOfTimelyStatement = dateOfTimelyStatement==null?null:dateOfTimelyStatement.toBuilder();
			return this;
		}
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder setDaysAfterCustodianEvent(CustomisableOffset daysAfterCustodianEvent) {
			this.daysAfterCustodianEvent = daysAfterCustodianEvent==null?null:daysAfterCustodianEvent.toBuilder();
			return this;
		}
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder setReleaseDate(CustomisableOffset releaseDate) {
			this.releaseDate = releaseDate==null?null:releaseDate.toBuilder();
			return this;
		}
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder setSafekeepingPeriodExpiry(CustomisableOffset safekeepingPeriodExpiry) {
			this.safekeepingPeriodExpiry = safekeepingPeriodExpiry==null?null:safekeepingPeriodExpiry.toBuilder();
			return this;
		}
		
		@Override
		public CustodianEventEndDate build() {
			return new CustodianEventEndDate.CustodianEventEndDateImpl(this);
		}
		
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder prune() {
			if (dateOfTimelyStatement!=null && !dateOfTimelyStatement.prune().hasData()) dateOfTimelyStatement = null;
			if (daysAfterCustodianEvent!=null && !daysAfterCustodianEvent.prune().hasData()) daysAfterCustodianEvent = null;
			if (releaseDate!=null && !releaseDate.prune().hasData()) releaseDate = null;
			if (safekeepingPeriodExpiry!=null && !safekeepingPeriodExpiry.prune().hasData()) safekeepingPeriodExpiry = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateOfTimelyStatement()!=null && getDateOfTimelyStatement().hasData()) return true;
			if (getDaysAfterCustodianEvent()!=null && getDaysAfterCustodianEvent().hasData()) return true;
			if (getReleaseDate()!=null && getReleaseDate().hasData()) return true;
			if (getSafekeepingPeriodExpiry()!=null && getSafekeepingPeriodExpiry().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodianEventEndDate.CustodianEventEndDateBuilder o = (CustodianEventEndDate.CustodianEventEndDateBuilder) other;
			
			merger.mergeRosetta(getDateOfTimelyStatement(), o.getDateOfTimelyStatement(), this::setDateOfTimelyStatement);
			merger.mergeRosetta(getDaysAfterCustodianEvent(), o.getDaysAfterCustodianEvent(), this::setDaysAfterCustodianEvent);
			merger.mergeRosetta(getReleaseDate(), o.getReleaseDate(), this::setReleaseDate);
			merger.mergeRosetta(getSafekeepingPeriodExpiry(), o.getSafekeepingPeriodExpiry(), this::setSafekeepingPeriodExpiry);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianEventEndDate _that = getType().cast(o);
		
			if (!Objects.equals(dateOfTimelyStatement, _that.getDateOfTimelyStatement())) return false;
			if (!Objects.equals(daysAfterCustodianEvent, _that.getDaysAfterCustodianEvent())) return false;
			if (!Objects.equals(releaseDate, _that.getReleaseDate())) return false;
			if (!Objects.equals(safekeepingPeriodExpiry, _that.getSafekeepingPeriodExpiry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateOfTimelyStatement != null ? dateOfTimelyStatement.hashCode() : 0);
			_result = 31 * _result + (daysAfterCustodianEvent != null ? daysAfterCustodianEvent.hashCode() : 0);
			_result = 31 * _result + (releaseDate != null ? releaseDate.hashCode() : 0);
			_result = 31 * _result + (safekeepingPeriodExpiry != null ? safekeepingPeriodExpiry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianEventEndDateBuilder {" +
				"dateOfTimelyStatement=" + this.dateOfTimelyStatement + ", " +
				"daysAfterCustodianEvent=" + this.daysAfterCustodianEvent + ", " +
				"releaseDate=" + this.releaseDate + ", " +
				"safekeepingPeriodExpiry=" + this.safekeepingPeriodExpiry +
			'}';
		}
	}
}
