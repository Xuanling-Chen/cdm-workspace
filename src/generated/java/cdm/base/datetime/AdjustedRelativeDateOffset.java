package cdm.base.datetime;

import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilder;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilderImpl;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetImpl;
import cdm.base.datetime.meta.AdjustedRelativeDateOffsetMeta;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.BasicReferenceWithMetaDate;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date) plus optional date adjustments.
 * @version ${project.version}
 */
@RosettaClass

public interface AdjustedRelativeDateOffset extends RelativeDateOffset {
	AdjustedRelativeDateOffset build();
	AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder();
	
	/**
	 * The business day convention and financial business centers used for adjusting the relative date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 */
	BusinessDayAdjustments getRelativeDateAdjustments();
	final static AdjustedRelativeDateOffsetMeta metaData = new AdjustedRelativeDateOffsetMeta();
	
	@Override
	default RosettaMetaData<? extends AdjustedRelativeDateOffset> metaData() {
		return metaData;
	} 
			
	static AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder() {
		return new AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl();
	}
	
	default Class<? extends AdjustedRelativeDateOffset> getType() {
		return AdjustedRelativeDateOffset.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.datetime.RelativeDateOffset.super.process(path, processor);
		
		processRosetta(path.newSubPath("relativeDateAdjustments"), processor, BusinessDayAdjustments.class, getRelativeDateAdjustments());
	}
	
	
	interface AdjustedRelativeDateOffsetBuilder extends AdjustedRelativeDateOffset, RelativeDateOffset.RelativeDateOffsetBuilder, RosettaModelObjectBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateRelativeDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getRelativeDateAdjustments();
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setRelativeDateAdjustments(BusinessDayAdjustments relativeDateAdjustments);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setAdjustedDate(Date adjustedDate);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCenters(BusinessCenters businessCenters);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeTo(BasicReferenceWithMetaDate dateRelativeTo);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeToValue(Date dateRelativeTo);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDayType(DayTypeEnum dayType);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setMeta(MetaFields meta);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriod(PeriodEnum period);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			RelativeDateOffset.RelativeDateOffsetBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("relativeDateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getRelativeDateAdjustments());
		}
		
	}
	
	//AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetImpl
	class AdjustedRelativeDateOffsetImpl extends RelativeDateOffset.RelativeDateOffsetImpl implements AdjustedRelativeDateOffset {
		private final BusinessDayAdjustments relativeDateAdjustments;
		
		protected AdjustedRelativeDateOffsetImpl(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder) {
			super(builder);
			this.relativeDateAdjustments = ofNullable(builder.getRelativeDateAdjustments()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BusinessDayAdjustments getRelativeDateAdjustments() {
			return relativeDateAdjustments;
		}
		
		@Override
		public AdjustedRelativeDateOffset build() {
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder() {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRelativeDateAdjustments()).ifPresent(builder::setRelativeDateAdjustments);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AdjustedRelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(relativeDateAdjustments, _that.getRelativeDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relativeDateAdjustments != null ? relativeDateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedRelativeDateOffset {" +
				"relativeDateAdjustments=" + this.relativeDateAdjustments +
			'}' + " " + super.toString();
		}
	}
	
	//AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl
	class AdjustedRelativeDateOffsetBuilderImpl extends RelativeDateOffset.RelativeDateOffsetBuilderImpl  implements AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder {
	
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder relativeDateAdjustments;
	
		public AdjustedRelativeDateOffsetBuilderImpl() {
		}
	
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getRelativeDateAdjustments() {
			return relativeDateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateRelativeDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (relativeDateAdjustments!=null) {
				result = relativeDateAdjustments;
			}
			else {
				result = relativeDateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
	
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setRelativeDateAdjustments(BusinessDayAdjustments relativeDateAdjustments) {
			this.relativeDateAdjustments = relativeDateAdjustments==null?null:relativeDateAdjustments.toBuilder();
			return this;
		}
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setAdjustedDate(Date adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate;
			return this;
		}
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCenters(BusinessCenters businessCenters) {
			this.businessCenters = businessCenters==null?null:businessCenters.toBuilder();
			return this;
		}
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference) {
			this.businessCentersReference = businessCentersReference==null?null:businessCentersReference.toBuilder();
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference) {
			this.getOrCreateBusinessCentersReference().setValue(businessCentersReference);
			return this;
		}
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeTo(BasicReferenceWithMetaDate dateRelativeTo) {
			this.dateRelativeTo = dateRelativeTo==null?null:dateRelativeTo.toBuilder();
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeToValue(Date dateRelativeTo) {
			this.getOrCreateDateRelativeTo().setValue(dateRelativeTo);
			return this;
		}
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset build() {
			return new AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetImpl(this);
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder prune() {
			super.prune();
			if (relativeDateAdjustments!=null && !relativeDateAdjustments.prune().hasData()) relativeDateAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRelativeDateAdjustments()!=null && getRelativeDateAdjustments().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder o = (AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder) other;
			
			merger.mergeRosetta(getRelativeDateAdjustments(), o.getRelativeDateAdjustments(), this::setRelativeDateAdjustments);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AdjustedRelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(relativeDateAdjustments, _that.getRelativeDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relativeDateAdjustments != null ? relativeDateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedRelativeDateOffsetBuilder {" +
				"relativeDateAdjustments=" + this.relativeDateAdjustments +
			'}' + " " + super.toString();
		}
	}
}
