package cdm.base.datetime;

import cdm.base.datetime.Frequency.FrequencyBuilder;
import cdm.base.datetime.Frequency.FrequencyBuilderImpl;
import cdm.base.datetime.Frequency.FrequencyImpl;
import cdm.base.datetime.meta.CalculationPeriodFrequencyMeta;
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
 * A class to specify the frequency at which calculation period end dates occur within the regular part of the calculation period schedule and their roll date convention.
 * @version ${project.version}
 */
@RosettaClass

public interface CalculationPeriodFrequency extends Frequency {
	CalculationPeriodFrequency build();
	CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder toBuilder();
	
	/**
	 * Indicates, when true, that that the first Calculation Period should run from the Effective Date to the end of the calendar period in which the Effective Date falls, e.g. Jan 15 - Jan 31 if the calculation periods are one month long and Effective Date is Jan 15. If false, the first Calculation Period should run from the Effective Date for one whole period, e.g. Jan 15 to Feb 14 if the calculation periods are one month long and Effective Date is Jan 15. Mostly used in Commmodity Swaps.
	 */
	Boolean getBalanceOfFirstPeriod();
	/**
	 * The roll convention specifies the period term as part of a periodic schedule, i.e. the calculation period end date within the regular part of the calculation period. The value could be a rule, e.g. IMM Settlement Dates, which is the 3rd Wednesday of the month, or it could be a specific day of the month, such as the first day of the applicable month. It is used in conjunction with a frequency and the regular period start date of a calculation period.
	 */
	RollConventionEnum getRollConvention();
	final static CalculationPeriodFrequencyMeta metaData = new CalculationPeriodFrequencyMeta();
	
	@Override
	default RosettaMetaData<? extends CalculationPeriodFrequency> metaData() {
		return metaData;
	} 
			
	static CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder builder() {
		return new CalculationPeriodFrequency.CalculationPeriodFrequencyBuilderImpl();
	}
	
	default Class<? extends CalculationPeriodFrequency> getType() {
		return CalculationPeriodFrequency.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.datetime.Frequency.super.process(path, processor);
		processor.processBasic(path.newSubPath("balanceOfFirstPeriod"), Boolean.class, getBalanceOfFirstPeriod(), this);
		processor.processBasic(path.newSubPath("rollConvention"), RollConventionEnum.class, getRollConvention(), this);
		
	}
	
	
	interface CalculationPeriodFrequencyBuilder extends CalculationPeriodFrequency, Frequency.FrequencyBuilder, RosettaModelObjectBuilder {
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setBalanceOfFirstPeriod(Boolean balanceOfFirstPeriod);
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setRollConvention(RollConventionEnum rollConvention);
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setMeta(MetaFields meta);
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setPeriod(PeriodExtendedEnum period);
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			Frequency.FrequencyBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("balanceOfFirstPeriod"), Boolean.class, getBalanceOfFirstPeriod(), this);
			processor.processBasic(path.newSubPath("rollConvention"), RollConventionEnum.class, getRollConvention(), this);
			
		}
		
	}
	
	//CalculationPeriodFrequency.CalculationPeriodFrequencyImpl
	class CalculationPeriodFrequencyImpl extends Frequency.FrequencyImpl implements CalculationPeriodFrequency {
		private final Boolean balanceOfFirstPeriod;
		private final RollConventionEnum rollConvention;
		
		protected CalculationPeriodFrequencyImpl(CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder builder) {
			super(builder);
			this.balanceOfFirstPeriod = builder.getBalanceOfFirstPeriod();
			this.rollConvention = builder.getRollConvention();
		}
		
		@Override
		public Boolean getBalanceOfFirstPeriod() {
			return balanceOfFirstPeriod;
		}
		
		@Override
		public RollConventionEnum getRollConvention() {
			return rollConvention;
		}
		
		@Override
		public CalculationPeriodFrequency build() {
			return this;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder toBuilder() {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBalanceOfFirstPeriod()).ifPresent(builder::setBalanceOfFirstPeriod);
			ofNullable(getRollConvention()).ifPresent(builder::setRollConvention);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodFrequency _that = getType().cast(o);
		
			if (!Objects.equals(balanceOfFirstPeriod, _that.getBalanceOfFirstPeriod())) return false;
			if (!Objects.equals(rollConvention, _that.getRollConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (balanceOfFirstPeriod != null ? balanceOfFirstPeriod.hashCode() : 0);
			_result = 31 * _result + (rollConvention != null ? rollConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodFrequency {" +
				"balanceOfFirstPeriod=" + this.balanceOfFirstPeriod + ", " +
				"rollConvention=" + this.rollConvention +
			'}' + " " + super.toString();
		}
	}
	
	//CalculationPeriodFrequency.CalculationPeriodFrequencyBuilderImpl
	class CalculationPeriodFrequencyBuilderImpl extends Frequency.FrequencyBuilderImpl  implements CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder {
	
		protected Boolean balanceOfFirstPeriod;
		protected RollConventionEnum rollConvention;
	
		public CalculationPeriodFrequencyBuilderImpl() {
		}
	
		@Override
		public Boolean getBalanceOfFirstPeriod() {
			return balanceOfFirstPeriod;
		}
		
		@Override
		public RollConventionEnum getRollConvention() {
			return rollConvention;
		}
		
	
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setBalanceOfFirstPeriod(Boolean balanceOfFirstPeriod) {
			this.balanceOfFirstPeriod = balanceOfFirstPeriod==null?null:balanceOfFirstPeriod;
			return this;
		}
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setRollConvention(RollConventionEnum rollConvention) {
			this.rollConvention = rollConvention==null?null:rollConvention;
			return this;
		}
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setPeriod(PeriodExtendedEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		
		@Override
		public CalculationPeriodFrequency build() {
			return new CalculationPeriodFrequency.CalculationPeriodFrequencyImpl(this);
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBalanceOfFirstPeriod()!=null) return true;
			if (getRollConvention()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder o = (CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder) other;
			
			
			merger.mergeBasic(getBalanceOfFirstPeriod(), o.getBalanceOfFirstPeriod(), this::setBalanceOfFirstPeriod);
			merger.mergeBasic(getRollConvention(), o.getRollConvention(), this::setRollConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodFrequency _that = getType().cast(o);
		
			if (!Objects.equals(balanceOfFirstPeriod, _that.getBalanceOfFirstPeriod())) return false;
			if (!Objects.equals(rollConvention, _that.getRollConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (balanceOfFirstPeriod != null ? balanceOfFirstPeriod.hashCode() : 0);
			_result = 31 * _result + (rollConvention != null ? rollConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodFrequencyBuilder {" +
				"balanceOfFirstPeriod=" + this.balanceOfFirstPeriod + ", " +
				"rollConvention=" + this.rollConvention +
			'}' + " " + super.toString();
		}
	}
}
