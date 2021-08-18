package cdm.base.datetime;

import cdm.base.datetime.meta.BusinessDayAdjustmentsMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining the business day convention and financial business centers used for adjusting any relevant date if it would otherwise fall on a day that is not a business day in the specified business center.
 * @version ${project.version}
 */
@RosettaClass

public interface BusinessDayAdjustments extends RosettaModelObject, GlobalKey {
	BusinessDayAdjustments build();
	BusinessDayAdjustments.BusinessDayAdjustmentsBuilder toBuilder();
	
	/**
	 * The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.
	 */
	BusinessCenters getBusinessCenters();
	/**
	 * The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	/**
	 */
	MetaFields getMeta();
	final static BusinessDayAdjustmentsMeta metaData = new BusinessDayAdjustmentsMeta();
	
	@Override
	default RosettaMetaData<? extends BusinessDayAdjustments> metaData() {
		return metaData;
	} 
			
	static BusinessDayAdjustments.BusinessDayAdjustmentsBuilder builder() {
		return new BusinessDayAdjustments.BusinessDayAdjustmentsBuilderImpl();
	}
	
	default Class<? extends BusinessDayAdjustments> getType() {
		return BusinessDayAdjustments.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface BusinessDayAdjustmentsBuilder extends BusinessDayAdjustments, RosettaModelObjectBuilder {
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setBusinessCenters(BusinessCenters businessCenters);
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//BusinessDayAdjustments.BusinessDayAdjustmentsImpl
	class BusinessDayAdjustmentsImpl implements BusinessDayAdjustments {
		private final BusinessCenters businessCenters;
		private final BusinessDayConventionEnum businessDayConvention;
		private final MetaFields meta;
		
		protected BusinessDayAdjustmentsImpl(BusinessDayAdjustments.BusinessDayAdjustmentsBuilder builder) {
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public BusinessDayAdjustments build() {
			return this;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder toBuilder() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessDayAdjustments.BusinessDayAdjustmentsBuilder builder) {
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessDayAdjustments _that = getType().cast(o);
		
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDayAdjustments {" +
				"businessCenters=" + this.businessCenters + ", " +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//BusinessDayAdjustments.BusinessDayAdjustmentsBuilderImpl
	class BusinessDayAdjustmentsBuilderImpl implements BusinessDayAdjustments.BusinessDayAdjustmentsBuilder, GlobalKeyBuilder {
	
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected BusinessDayConventionEnum businessDayConvention;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public BusinessDayAdjustmentsBuilderImpl() {
		}
	
		@Override
		public BusinessCenters.BusinessCentersBuilder getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters() {
			BusinessCenters.BusinessCentersBuilder result;
			if (businessCenters!=null) {
				result = businessCenters;
			}
			else {
				result = businessCenters = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
	
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setBusinessCenters(BusinessCenters businessCenters) {
			this.businessCenters = businessCenters==null?null:businessCenters.toBuilder();
			return this;
		}
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public BusinessDayAdjustments build() {
			return new BusinessDayAdjustments.BusinessDayAdjustmentsImpl(this);
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder prune() {
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder o = (BusinessDayAdjustments.BusinessDayAdjustmentsBuilder) other;
			
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessDayAdjustments _that = getType().cast(o);
		
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDayAdjustmentsBuilder {" +
				"businessCenters=" + this.businessCenters + ", " +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
