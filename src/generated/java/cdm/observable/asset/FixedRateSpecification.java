package cdm.observable.asset;

import cdm.base.math.RateSchedule;
import cdm.observable.asset.meta.FixedRateSpecificationMeta;
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
 * Type defining the specification for a fixed rate.
 * @version ${project.version}
 */
@RosettaClass

public interface FixedRateSpecification extends RosettaModelObject, GlobalKey {
	FixedRateSpecification build();
	FixedRateSpecification.FixedRateSpecificationBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 * The fixed rate or fixed rate schedule expressed as explicit fixed rates and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 */
	RateSchedule getRateSchedule();
	final static FixedRateSpecificationMeta metaData = new FixedRateSpecificationMeta();
	
	@Override
	default RosettaMetaData<? extends FixedRateSpecification> metaData() {
		return metaData;
	} 
			
	static FixedRateSpecification.FixedRateSpecificationBuilder builder() {
		return new FixedRateSpecification.FixedRateSpecificationBuilderImpl();
	}
	
	default Class<? extends FixedRateSpecification> getType() {
		return FixedRateSpecification.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("rateSchedule"), processor, RateSchedule.class, getRateSchedule());
	}
	
	
	interface FixedRateSpecificationBuilder extends FixedRateSpecification, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		RateSchedule.RateScheduleBuilder getOrCreateRateSchedule();
		RateSchedule.RateScheduleBuilder getRateSchedule();
		FixedRateSpecification.FixedRateSpecificationBuilder setMeta(MetaFields meta);
		FixedRateSpecification.FixedRateSpecificationBuilder setRateSchedule(RateSchedule rateSchedule);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("rateSchedule"), processor, RateSchedule.RateScheduleBuilder.class, getRateSchedule());
		}
		
	}
	
	//FixedRateSpecification.FixedRateSpecificationImpl
	class FixedRateSpecificationImpl implements FixedRateSpecification {
		private final MetaFields meta;
		private final RateSchedule rateSchedule;
		
		protected FixedRateSpecificationImpl(FixedRateSpecification.FixedRateSpecificationBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.rateSchedule = ofNullable(builder.getRateSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public RateSchedule getRateSchedule() {
			return rateSchedule;
		}
		
		@Override
		public FixedRateSpecification build() {
			return this;
		}
		
		@Override
		public FixedRateSpecification.FixedRateSpecificationBuilder toBuilder() {
			FixedRateSpecification.FixedRateSpecificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedRateSpecification.FixedRateSpecificationBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getRateSchedule()).ifPresent(builder::setRateSchedule);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedRateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(rateSchedule, _that.getRateSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (rateSchedule != null ? rateSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRateSpecification {" +
				"meta=" + this.meta + ", " +
				"rateSchedule=" + this.rateSchedule +
			'}';
		}
	}
	
	//FixedRateSpecification.FixedRateSpecificationBuilderImpl
	class FixedRateSpecificationBuilderImpl implements FixedRateSpecification.FixedRateSpecificationBuilder, GlobalKeyBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected RateSchedule.RateScheduleBuilder rateSchedule;
	
		public FixedRateSpecificationBuilderImpl() {
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
		public RateSchedule.RateScheduleBuilder getRateSchedule() {
			return rateSchedule;
		}
		
		@Override
		public RateSchedule.RateScheduleBuilder getOrCreateRateSchedule() {
			RateSchedule.RateScheduleBuilder result;
			if (rateSchedule!=null) {
				result = rateSchedule;
			}
			else {
				result = rateSchedule = RateSchedule.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FixedRateSpecification.FixedRateSpecificationBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FixedRateSpecification.FixedRateSpecificationBuilder setRateSchedule(RateSchedule rateSchedule) {
			this.rateSchedule = rateSchedule==null?null:rateSchedule.toBuilder();
			return this;
		}
		
		@Override
		public FixedRateSpecification build() {
			return new FixedRateSpecification.FixedRateSpecificationImpl(this);
		}
		
		@Override
		public FixedRateSpecification.FixedRateSpecificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRateSpecification.FixedRateSpecificationBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (rateSchedule!=null && !rateSchedule.prune().hasData()) rateSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRateSchedule()!=null && getRateSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRateSpecification.FixedRateSpecificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FixedRateSpecification.FixedRateSpecificationBuilder o = (FixedRateSpecification.FixedRateSpecificationBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getRateSchedule(), o.getRateSchedule(), this::setRateSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedRateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(rateSchedule, _that.getRateSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (rateSchedule != null ? rateSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRateSpecificationBuilder {" +
				"meta=" + this.meta + ", " +
				"rateSchedule=" + this.rateSchedule +
			'}';
		}
	}
}
