package cdm.base.datetime;

import cdm.base.datetime.meta.PeriodBoundMeta;
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
 * The period bound is defined as a period and whether the bound is inclusive.
 * @version ${project.version}
 */
@RosettaClass

public interface PeriodBound extends RosettaModelObject {
	PeriodBound build();
	PeriodBound.PeriodBoundBuilder toBuilder();
	
	/**
	 * Whether the period bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
	 */
	Boolean getInclusive();
	/**
	 * The period to be used as the bound, e.g. 5Y.
	 */
	Period getPeriod();
	final static PeriodBoundMeta metaData = new PeriodBoundMeta();
	
	@Override
	default RosettaMetaData<? extends PeriodBound> metaData() {
		return metaData;
	} 
			
	static PeriodBound.PeriodBoundBuilder builder() {
		return new PeriodBound.PeriodBoundBuilderImpl();
	}
	
	default Class<? extends PeriodBound> getType() {
		return PeriodBound.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("inclusive"), Boolean.class, getInclusive(), this);
		
		processRosetta(path.newSubPath("period"), processor, Period.class, getPeriod());
	}
	
	
	interface PeriodBoundBuilder extends PeriodBound, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreatePeriod();
		Period.PeriodBuilder getPeriod();
		PeriodBound.PeriodBoundBuilder setInclusive(Boolean inclusive);
		PeriodBound.PeriodBoundBuilder setPeriod(Period period);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("inclusive"), Boolean.class, getInclusive(), this);
			
			processRosetta(path.newSubPath("period"), processor, Period.PeriodBuilder.class, getPeriod());
		}
		
	}
	
	//PeriodBound.PeriodBoundImpl
	class PeriodBoundImpl implements PeriodBound {
		private final Boolean inclusive;
		private final Period period;
		
		protected PeriodBoundImpl(PeriodBound.PeriodBoundBuilder builder) {
			this.inclusive = builder.getInclusive();
			this.period = ofNullable(builder.getPeriod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Boolean getInclusive() {
			return inclusive;
		}
		
		@Override
		public Period getPeriod() {
			return period;
		}
		
		@Override
		public PeriodBound build() {
			return this;
		}
		
		@Override
		public PeriodBound.PeriodBoundBuilder toBuilder() {
			PeriodBound.PeriodBoundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PeriodBound.PeriodBoundBuilder builder) {
			ofNullable(getInclusive()).ifPresent(builder::setInclusive);
			ofNullable(getPeriod()).ifPresent(builder::setPeriod);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodBound _that = getType().cast(o);
		
			if (!Objects.equals(inclusive, _that.getInclusive())) return false;
			if (!Objects.equals(period, _that.getPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (inclusive != null ? inclusive.hashCode() : 0);
			_result = 31 * _result + (period != null ? period.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodBound {" +
				"inclusive=" + this.inclusive + ", " +
				"period=" + this.period +
			'}';
		}
	}
	
	//PeriodBound.PeriodBoundBuilderImpl
	class PeriodBoundBuilderImpl implements PeriodBound.PeriodBoundBuilder {
	
		protected Boolean inclusive;
		protected Period.PeriodBuilder period;
	
		public PeriodBoundBuilderImpl() {
		}
	
		@Override
		public Boolean getInclusive() {
			return inclusive;
		}
		
		@Override
		public Period.PeriodBuilder getPeriod() {
			return period;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreatePeriod() {
			Period.PeriodBuilder result;
			if (period!=null) {
				result = period;
			}
			else {
				result = period = Period.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PeriodBound.PeriodBoundBuilder setInclusive(Boolean inclusive) {
			this.inclusive = inclusive==null?null:inclusive;
			return this;
		}
		@Override
		public PeriodBound.PeriodBoundBuilder setPeriod(Period period) {
			this.period = period==null?null:period.toBuilder();
			return this;
		}
		
		@Override
		public PeriodBound build() {
			return new PeriodBound.PeriodBoundImpl(this);
		}
		
		@Override
		public PeriodBound.PeriodBoundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodBound.PeriodBoundBuilder prune() {
			if (period!=null && !period.prune().hasData()) period = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInclusive()!=null) return true;
			if (getPeriod()!=null && getPeriod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodBound.PeriodBoundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PeriodBound.PeriodBoundBuilder o = (PeriodBound.PeriodBoundBuilder) other;
			
			merger.mergeRosetta(getPeriod(), o.getPeriod(), this::setPeriod);
			
			merger.mergeBasic(getInclusive(), o.getInclusive(), this::setInclusive);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodBound _that = getType().cast(o);
		
			if (!Objects.equals(inclusive, _that.getInclusive())) return false;
			if (!Objects.equals(period, _that.getPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (inclusive != null ? inclusive.hashCode() : 0);
			_result = 31 * _result + (period != null ? period.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodBoundBuilder {" +
				"inclusive=" + this.inclusive + ", " +
				"period=" + this.period +
			'}';
		}
	}
}
