package cdm.base.datetime;

import cdm.base.datetime.meta.PeriodMeta;
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
 * A class to define recurring periods or time offsets.
 * @version ${project.version}
 */
@RosettaClass

public interface Period extends RosettaModelObject, GlobalKey {
	Period build();
	Period.PeriodBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 * A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
	 */
	PeriodEnum getPeriod();
	/**
	 * A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
	 */
	Integer getPeriodMultiplier();
	final static PeriodMeta metaData = new PeriodMeta();
	
	@Override
	default RosettaMetaData<? extends Period> metaData() {
		return metaData;
	} 
			
	static Period.PeriodBuilder builder() {
		return new Period.PeriodBuilderImpl();
	}
	
	default Class<? extends Period> getType() {
		return Period.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface PeriodBuilder extends Period, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Period.PeriodBuilder setMeta(MetaFields meta);
		Period.PeriodBuilder setPeriod(PeriodEnum period);
		Period.PeriodBuilder setPeriodMultiplier(Integer periodMultiplier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//Period.PeriodImpl
	class PeriodImpl implements Period {
		private final MetaFields meta;
		private final PeriodEnum period;
		private final Integer periodMultiplier;
		
		protected PeriodImpl(Period.PeriodBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.period = builder.getPeriod();
			this.periodMultiplier = builder.getPeriodMultiplier();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PeriodEnum getPeriod() {
			return period;
		}
		
		@Override
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@Override
		public Period build() {
			return this;
		}
		
		@Override
		public Period.PeriodBuilder toBuilder() {
			Period.PeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Period.PeriodBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPeriod()).ifPresent(builder::setPeriod);
			ofNullable(getPeriodMultiplier()).ifPresent(builder::setPeriodMultiplier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Period _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(period, _that.getPeriod())) return false;
			if (!Objects.equals(periodMultiplier, _that.getPeriodMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (period != null ? period.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (periodMultiplier != null ? periodMultiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Period {" +
				"meta=" + this.meta + ", " +
				"period=" + this.period + ", " +
				"periodMultiplier=" + this.periodMultiplier +
			'}';
		}
	}
	
	//Period.PeriodBuilderImpl
	class PeriodBuilderImpl implements Period.PeriodBuilder, GlobalKeyBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected PeriodEnum period;
		protected Integer periodMultiplier;
	
		public PeriodBuilderImpl() {
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
		public PeriodEnum getPeriod() {
			return period;
		}
		
		@Override
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
	
		@Override
		public Period.PeriodBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Period.PeriodBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		public Period.PeriodBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		
		@Override
		public Period build() {
			return new Period.PeriodImpl(this);
		}
		
		@Override
		public Period.PeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Period.PeriodBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriod()!=null) return true;
			if (getPeriodMultiplier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Period.PeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Period.PeriodBuilder o = (Period.PeriodBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getPeriod(), o.getPeriod(), this::setPeriod);
			merger.mergeBasic(getPeriodMultiplier(), o.getPeriodMultiplier(), this::setPeriodMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Period _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(period, _that.getPeriod())) return false;
			if (!Objects.equals(periodMultiplier, _that.getPeriodMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (period != null ? period.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (periodMultiplier != null ? periodMultiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodBuilder {" +
				"meta=" + this.meta + ", " +
				"period=" + this.period + ", " +
				"periodMultiplier=" + this.periodMultiplier +
			'}';
		}
	}
}
