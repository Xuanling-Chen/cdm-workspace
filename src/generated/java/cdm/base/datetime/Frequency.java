package cdm.base.datetime;

import cdm.base.datetime.meta.FrequencyMeta;
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
 * A class for defining a date frequency, e.g. one day, three months, through the combination of an integer value and a standardized period value that is specified as part of an enumeration.
 * @version ${project.version}
 */
@RosettaClass

public interface Frequency extends RosettaModelObject, GlobalKey {
	Frequency build();
	Frequency.FrequencyBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 * A time period, e.g. a day, week, month, year or term of the stream.
	 */
	PeriodExtendedEnum getPeriod();
	/**
	 * A time period multiplier, e.g. 1, 2, or 3. If the period value is T (Term) then period multiplier must contain the value 1.
	 */
	Integer getPeriodMultiplier();
	final static FrequencyMeta metaData = new FrequencyMeta();
	
	@Override
	default RosettaMetaData<? extends Frequency> metaData() {
		return metaData;
	} 
			
	static Frequency.FrequencyBuilder builder() {
		return new Frequency.FrequencyBuilderImpl();
	}
	
	default Class<? extends Frequency> getType() {
		return Frequency.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FrequencyBuilder extends Frequency, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Frequency.FrequencyBuilder setMeta(MetaFields meta);
		Frequency.FrequencyBuilder setPeriod(PeriodExtendedEnum period);
		Frequency.FrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//Frequency.FrequencyImpl
	class FrequencyImpl implements Frequency {
		private final MetaFields meta;
		private final PeriodExtendedEnum period;
		private final Integer periodMultiplier;
		
		protected FrequencyImpl(Frequency.FrequencyBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.period = builder.getPeriod();
			this.periodMultiplier = builder.getPeriodMultiplier();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PeriodExtendedEnum getPeriod() {
			return period;
		}
		
		@Override
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@Override
		public Frequency build() {
			return this;
		}
		
		@Override
		public Frequency.FrequencyBuilder toBuilder() {
			Frequency.FrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Frequency.FrequencyBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPeriod()).ifPresent(builder::setPeriod);
			ofNullable(getPeriodMultiplier()).ifPresent(builder::setPeriodMultiplier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Frequency _that = getType().cast(o);
		
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
			return "Frequency {" +
				"meta=" + this.meta + ", " +
				"period=" + this.period + ", " +
				"periodMultiplier=" + this.periodMultiplier +
			'}';
		}
	}
	
	//Frequency.FrequencyBuilderImpl
	class FrequencyBuilderImpl implements Frequency.FrequencyBuilder, GlobalKeyBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected PeriodExtendedEnum period;
		protected Integer periodMultiplier;
	
		public FrequencyBuilderImpl() {
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
		public PeriodExtendedEnum getPeriod() {
			return period;
		}
		
		@Override
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
	
		@Override
		public Frequency.FrequencyBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Frequency.FrequencyBuilder setPeriod(PeriodExtendedEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		public Frequency.FrequencyBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		
		@Override
		public Frequency build() {
			return new Frequency.FrequencyImpl(this);
		}
		
		@Override
		public Frequency.FrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Frequency.FrequencyBuilder prune() {
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
		public Frequency.FrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Frequency.FrequencyBuilder o = (Frequency.FrequencyBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getPeriod(), o.getPeriod(), this::setPeriod);
			merger.mergeBasic(getPeriodMultiplier(), o.getPeriodMultiplier(), this::setPeriodMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Frequency _that = getType().cast(o);
		
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
			return "FrequencyBuilder {" +
				"meta=" + this.meta + ", " +
				"period=" + this.period + ", " +
				"periodMultiplier=" + this.periodMultiplier +
			'}';
		}
	}
}
