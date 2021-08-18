package cdm.base.datetime;

import cdm.base.datetime.meta.BusinessCentersMeta;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class for specifying the business day calendar location used in determining whether a day is a business day or not, either by specifying this business center by reference to an enumerated list that is maintained by the FpML standard, or by reference to such specification when it exists elsewhere as part of the instance document. This class corresponds to the FpML BusinessCentersOrReference.model.
 * @version ${project.version}
 */
@RosettaClass

public interface BusinessCenters extends RosettaModelObject, GlobalKey {
	BusinessCenters build();
	BusinessCenters.BusinessCentersBuilder toBuilder();
	
	/**
	 * A code identifying one or several business day calendar location(s). The set of business day calendar locations are specified by the business day calendar location enumeration which is maintained by the FpML standard.
	 */
	List<? extends FieldWithMetaBusinessCenterEnum> getBusinessCenter();
	/**
	 * A reference to a financial business center location specified elsewhere in the instance document.
	 */
	ReferenceWithMetaBusinessCenters getBusinessCentersReference();
	/**
	 */
	MetaFields getMeta();
	final static BusinessCentersMeta metaData = new BusinessCentersMeta();
	
	@Override
	default RosettaMetaData<? extends BusinessCenters> metaData() {
		return metaData;
	} 
			
	static BusinessCenters.BusinessCentersBuilder builder() {
		return new BusinessCenters.BusinessCentersBuilderImpl();
	}
	
	default Class<? extends BusinessCenters> getType() {
		return BusinessCenters.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnum.class, getBusinessCenter());
		processRosetta(path.newSubPath("businessCentersReference"), processor, ReferenceWithMetaBusinessCenters.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface BusinessCentersBuilder extends BusinessCenters, RosettaModelObjectBuilder {
		FieldWithMetaBusinessCenterEnumBuilder getOrCreateBusinessCenter(int _index);
		List<? extends FieldWithMetaBusinessCenterEnumBuilder> getBusinessCenter();
		ReferenceWithMetaBusinessCentersBuilder getOrCreateBusinessCentersReference();
		ReferenceWithMetaBusinessCentersBuilder getBusinessCentersReference();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		BusinessCenters.BusinessCentersBuilder addBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter);
		BusinessCenters.BusinessCentersBuilder addBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter, int _idx);
		BusinessCenters.BusinessCentersBuilder addBusinessCenterValue(BusinessCenterEnum businessCenter);
		BusinessCenters.BusinessCentersBuilder addBusinessCenterValue(BusinessCenterEnum businessCenter, int _idx);
		BusinessCenters.BusinessCentersBuilder addBusinessCenter(List<? extends FieldWithMetaBusinessCenterEnum> businessCenter);
		BusinessCenters.BusinessCentersBuilder setBusinessCenter(List<? extends FieldWithMetaBusinessCenterEnum> businessCenter);
		BusinessCenters.BusinessCentersBuilder addBusinessCenterValue(List<? extends BusinessCenterEnum> businessCenter);
		BusinessCenters.BusinessCentersBuilder setBusinessCenterValue(List<? extends BusinessCenterEnum> businessCenter);
		BusinessCenters.BusinessCentersBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference);
		BusinessCenters.BusinessCentersBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference);
		BusinessCenters.BusinessCentersBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnumBuilder.class, getBusinessCenter());
			processRosetta(path.newSubPath("businessCentersReference"), processor, ReferenceWithMetaBusinessCentersBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//BusinessCenters.BusinessCentersImpl
	class BusinessCentersImpl implements BusinessCenters {
		private final List<? extends FieldWithMetaBusinessCenterEnum> businessCenter;
		private final ReferenceWithMetaBusinessCenters businessCentersReference;
		private final MetaFields meta;
		
		protected BusinessCentersImpl(BusinessCenters.BusinessCentersBuilder builder) {
			this.businessCenter = ofNullable(builder.getBusinessCenter()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends FieldWithMetaBusinessCenterEnum> getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public ReferenceWithMetaBusinessCenters getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public BusinessCenters build() {
			return this;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder toBuilder() {
			BusinessCenters.BusinessCentersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessCenters.BusinessCentersBuilder builder) {
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenters _that = getType().cast(o);
		
			if (!ListEquals.listEquals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCenters {" +
				"businessCenter=" + this.businessCenter + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//BusinessCenters.BusinessCentersBuilderImpl
	class BusinessCentersBuilderImpl implements BusinessCenters.BusinessCentersBuilder, GlobalKeyBuilder {
	
		protected List<FieldWithMetaBusinessCenterEnumBuilder> businessCenter = new ArrayList<>();
		protected ReferenceWithMetaBusinessCentersBuilder businessCentersReference;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public BusinessCentersBuilderImpl() {
		}
	
		@Override
		public List<? extends FieldWithMetaBusinessCenterEnumBuilder> getBusinessCenter() {
			return businessCenter;
		}
		
		public FieldWithMetaBusinessCenterEnumBuilder getOrCreateBusinessCenter(int _index) {
		
			if (businessCenter==null) {
				this.businessCenter = new ArrayList<>();
			}
			FieldWithMetaBusinessCenterEnumBuilder result;
			return getIndex(businessCenter, _index, () -> {
						FieldWithMetaBusinessCenterEnumBuilder newBusinessCenter = FieldWithMetaBusinessCenterEnum.builder();
						return newBusinessCenter;
					});
		}
		
		@Override
		public ReferenceWithMetaBusinessCentersBuilder getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		public ReferenceWithMetaBusinessCentersBuilder getOrCreateBusinessCentersReference() {
			ReferenceWithMetaBusinessCentersBuilder result;
			if (businessCentersReference!=null) {
				result = businessCentersReference;
			}
			else {
				result = businessCentersReference = ReferenceWithMetaBusinessCenters.builder();
			}
			
			return result;
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
		public BusinessCenters.BusinessCentersBuilder addBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter) {
			if (businessCenter!=null) this.businessCenter.add(businessCenter.toBuilder());
			return this;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder addBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter, int _idx) {
			getIndex(this.businessCenter, _idx, () -> businessCenter.toBuilder());
			return this;
		}
		
			@Override
			public BusinessCenters.BusinessCentersBuilder addBusinessCenterValue(BusinessCenterEnum businessCenter) {
				this.getOrCreateBusinessCenter(-1).setValue(businessCenter);
				return this;
			}
			
			@Override
			public BusinessCenters.BusinessCentersBuilder addBusinessCenterValue(BusinessCenterEnum businessCenter, int _idx) {
				this.getOrCreateBusinessCenter(_idx).setValue(businessCenter);
				return this;
			}
		@Override 
		public BusinessCenters.BusinessCentersBuilder addBusinessCenter(List<? extends FieldWithMetaBusinessCenterEnum> businessCenters) {
			if (businessCenters != null) {
				for (FieldWithMetaBusinessCenterEnum toAdd : businessCenters) {
					this.businessCenter.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public BusinessCenters.BusinessCentersBuilder setBusinessCenter(List<? extends FieldWithMetaBusinessCenterEnum> businessCenters) {
			if (businessCenters == null)  {
				this.businessCenter = new ArrayList<>();
			}
			else {
				this.businessCenter = businessCenters.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder addBusinessCenterValue(List<? extends BusinessCenterEnum> businessCenters) {
			if (businessCenters != null) {
				for (BusinessCenterEnum toAdd : businessCenters) {
					this.addBusinessCenterValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder setBusinessCenterValue(List<? extends BusinessCenterEnum> businessCenters) {
			this.businessCenter.clear();
			if (businessCenters!=null) {
				businessCenters.forEach(this::addBusinessCenterValue);
			}
			return this;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference) {
			this.businessCentersReference = businessCentersReference==null?null:businessCentersReference.toBuilder();
			return this;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference) {
			this.getOrCreateBusinessCentersReference().setValue(businessCentersReference);
			return this;
		}
		@Override
		public BusinessCenters.BusinessCentersBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public BusinessCenters build() {
			return new BusinessCenters.BusinessCentersImpl(this);
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenters.BusinessCentersBuilder prune() {
			businessCenter = businessCenter.stream().filter(b->b!=null).<FieldWithMetaBusinessCenterEnumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessCenter()!=null && !getBusinessCenter().isEmpty()) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenters.BusinessCentersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessCenters.BusinessCentersBuilder o = (BusinessCenters.BusinessCentersBuilder) other;
			
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::getOrCreateBusinessCenter);
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenters _that = getType().cast(o);
		
			if (!ListEquals.listEquals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCentersBuilder {" +
				"businessCenter=" + this.businessCenter + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
