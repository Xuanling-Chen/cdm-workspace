package cdm.base.datetime;

import cdm.base.datetime.meta.AdjustableOrAdjustedOrRelativeDateMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaDate.FieldWithMetaDateBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * This Rosetta class specifies the date as either an unadjusted, adjusted or relative date. It supplements the features of the AdjustableOrAdjustedDate to support the credit default swap option premium, which uses the relative date construct.
 * @version ${project.version}
 */
@RosettaClass

public interface AdjustableOrAdjustedOrRelativeDate extends RosettaModelObject {
	AdjustableOrAdjustedOrRelativeDate build();
	AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder toBuilder();
	
	/**
	 * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	FieldWithMetaDate getAdjustedDate();
	/**
	 * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * A date specified as some offset to another date (the anchor date).
	 */
	RelativeDateOffset getRelativeDate();
	/**
	 * A date subject to adjustment.
	 */
	Date getUnadjustedDate();
	final static AdjustableOrAdjustedOrRelativeDateMeta metaData = new AdjustableOrAdjustedOrRelativeDateMeta();
	
	@Override
	default RosettaMetaData<? extends AdjustableOrAdjustedOrRelativeDate> metaData() {
		return metaData;
	} 
			
	static AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder builder() {
		return new AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilderImpl();
	}
	
	default Class<? extends AdjustableOrAdjustedOrRelativeDate> getType() {
		return AdjustableOrAdjustedOrRelativeDate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedDate"), Date.class, getUnadjustedDate(), this);
		
		processRosetta(path.newSubPath("adjustedDate"), processor, FieldWithMetaDate.class, getAdjustedDate(), AttributeMeta.GLOBAL_KEY_FIELD);
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.class, getRelativeDate());
	}
	
	
	interface AdjustableOrAdjustedOrRelativeDateBuilder extends AdjustableOrAdjustedOrRelativeDate, RosettaModelObjectBuilder {
		FieldWithMetaDateBuilder getOrCreateAdjustedDate();
		FieldWithMetaDateBuilder getAdjustedDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate();
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setAdjustedDate(FieldWithMetaDate adjustedDate);
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setAdjustedDateValue(Date adjustedDate);
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setRelativeDate(RelativeDateOffset relativeDate);
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setUnadjustedDate(Date unadjustedDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("unadjustedDate"), Date.class, getUnadjustedDate(), this);
			
			processRosetta(path.newSubPath("adjustedDate"), processor, FieldWithMetaDateBuilder.class, getAdjustedDate(), AttributeMeta.GLOBAL_KEY_FIELD);
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getRelativeDate());
		}
		
	}
	
	//AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateImpl
	class AdjustableOrAdjustedOrRelativeDateImpl implements AdjustableOrAdjustedOrRelativeDate {
		private final FieldWithMetaDate adjustedDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final RelativeDateOffset relativeDate;
		private final Date unadjustedDate;
		
		protected AdjustableOrAdjustedOrRelativeDateImpl(AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder builder) {
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.relativeDate = ofNullable(builder.getRelativeDate()).map(f->f.build()).orElse(null);
			this.unadjustedDate = builder.getUnadjustedDate();
		}
		
		@Override
		public FieldWithMetaDate getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public RelativeDateOffset getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public Date getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate build() {
			return this;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder toBuilder() {
			AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder builder) {
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getRelativeDate()).ifPresent(builder::setRelativeDate);
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrAdjustedOrRelativeDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrAdjustedOrRelativeDate {" +
				"adjustedDate=" + this.adjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"relativeDate=" + this.relativeDate + ", " +
				"unadjustedDate=" + this.unadjustedDate +
			'}';
		}
	}
	
	//AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilderImpl
	class AdjustableOrAdjustedOrRelativeDateBuilderImpl implements AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder {
	
		protected FieldWithMetaDateBuilder adjustedDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected RelativeDateOffset.RelativeDateOffsetBuilder relativeDate;
		protected Date unadjustedDate;
	
		public AdjustableOrAdjustedOrRelativeDateBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaDateBuilder getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public FieldWithMetaDateBuilder getOrCreateAdjustedDate() {
			FieldWithMetaDateBuilder result;
			if (adjustedDate!=null) {
				result = adjustedDate;
			}
			else {
				result = adjustedDate = FieldWithMetaDate.builder();
			}
			
			return result;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (relativeDate!=null) {
				result = relativeDate;
			}
			else {
				result = relativeDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getUnadjustedDate() {
			return unadjustedDate;
		}
		
	
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setAdjustedDate(FieldWithMetaDate adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setAdjustedDateValue(Date adjustedDate) {
			this.getOrCreateAdjustedDate().setValue(adjustedDate);
			return this;
		}
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setRelativeDate(RelativeDateOffset relativeDate) {
			this.relativeDate = relativeDate==null?null:relativeDate.toBuilder();
			return this;
		}
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setUnadjustedDate(Date unadjustedDate) {
			this.unadjustedDate = unadjustedDate==null?null:unadjustedDate;
			return this;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate build() {
			return new AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateImpl(this);
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder prune() {
			if (adjustedDate!=null && !adjustedDate.prune().hasData()) adjustedDate = null;
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (relativeDate!=null && !relativeDate.prune().hasData()) relativeDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedDate()!=null) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getRelativeDate()!=null && getRelativeDate().hasData()) return true;
			if (getUnadjustedDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder o = (AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder) other;
			
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getRelativeDate(), o.getRelativeDate(), this::setRelativeDate);
			
			merger.mergeBasic(getUnadjustedDate(), o.getUnadjustedDate(), this::setUnadjustedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrAdjustedOrRelativeDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrAdjustedOrRelativeDateBuilder {" +
				"adjustedDate=" + this.adjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"relativeDate=" + this.relativeDate + ", " +
				"unadjustedDate=" + this.unadjustedDate +
			'}';
		}
	}
}
