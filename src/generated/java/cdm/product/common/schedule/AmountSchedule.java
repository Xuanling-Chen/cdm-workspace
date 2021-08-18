package cdm.product.common.schedule;

import cdm.base.math.Schedule;
import cdm.base.math.Schedule.ScheduleBuilder;
import cdm.base.math.Schedule.ScheduleBuilderImpl;
import cdm.base.math.Schedule.ScheduleImpl;
import cdm.base.math.Step;
import cdm.product.common.schedule.meta.AmountScheduleMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.util.ListEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify a currency amount or a currency amount schedule.
 * @version ${project.version}
 */
@RosettaClass

public interface AmountSchedule extends Schedule {
	AmountSchedule build();
	AmountSchedule.AmountScheduleBuilder toBuilder();
	
	/**
	 * The currency in which the amount schedule is denominated. The currency is specified outside of the actual schedule in order to be applied uniformly to it. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	List<? extends FieldWithMetaString> getCurrency();
	final static AmountScheduleMeta metaData = new AmountScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends AmountSchedule> metaData() {
		return metaData;
	} 
			
	static AmountSchedule.AmountScheduleBuilder builder() {
		return new AmountSchedule.AmountScheduleBuilderImpl();
	}
	
	default Class<? extends AmountSchedule> getType() {
		return AmountSchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.math.Schedule.super.process(path, processor);
		
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
	}
	
	
	interface AmountScheduleBuilder extends AmountSchedule, Schedule.ScheduleBuilder, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCurrency(int _index);
		List<? extends FieldWithMetaStringBuilder> getCurrency();
		AmountSchedule.AmountScheduleBuilder addCurrency(FieldWithMetaString currency);
		AmountSchedule.AmountScheduleBuilder addCurrency(FieldWithMetaString currency, int _idx);
		AmountSchedule.AmountScheduleBuilder addCurrencyValue(String currency);
		AmountSchedule.AmountScheduleBuilder addCurrencyValue(String currency, int _idx);
		AmountSchedule.AmountScheduleBuilder addCurrency(List<? extends FieldWithMetaString> currency);
		AmountSchedule.AmountScheduleBuilder setCurrency(List<? extends FieldWithMetaString> currency);
		AmountSchedule.AmountScheduleBuilder addCurrencyValue(List<? extends String> currency);
		AmountSchedule.AmountScheduleBuilder setCurrencyValue(List<? extends String> currency);
		AmountSchedule.AmountScheduleBuilder setInitialValue(BigDecimal initialValue);
		AmountSchedule.AmountScheduleBuilder addStep(Step step);
		AmountSchedule.AmountScheduleBuilder addStep(Step step, int _idx);
		AmountSchedule.AmountScheduleBuilder addStep(List<? extends Step> step);
		AmountSchedule.AmountScheduleBuilder setStep(List<? extends Step> step);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			Schedule.ScheduleBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaStringBuilder.class, getCurrency());
		}
		
	}
	
	//AmountSchedule.AmountScheduleImpl
	class AmountScheduleImpl extends Schedule.ScheduleImpl implements AmountSchedule {
		private final List<? extends FieldWithMetaString> currency;
		
		protected AmountScheduleImpl(AmountSchedule.AmountScheduleBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends FieldWithMetaString> getCurrency() {
			return currency;
		}
		
		@Override
		public AmountSchedule build() {
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder toBuilder() {
			AmountSchedule.AmountScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmountSchedule.AmountScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AmountSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmountSchedule {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}
	
	//AmountSchedule.AmountScheduleBuilderImpl
	class AmountScheduleBuilderImpl extends Schedule.ScheduleBuilderImpl  implements AmountSchedule.AmountScheduleBuilder {
	
		protected List<FieldWithMetaStringBuilder> currency = new ArrayList<>();
	
		public AmountScheduleBuilderImpl() {
		}
	
		@Override
		public List<? extends FieldWithMetaStringBuilder> getCurrency() {
			return currency;
		}
		
		public FieldWithMetaStringBuilder getOrCreateCurrency(int _index) {
		
			if (currency==null) {
				this.currency = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(currency, _index, () -> {
						FieldWithMetaStringBuilder newCurrency = FieldWithMetaString.builder();
						return newCurrency;
					});
		}
		
	
		@Override
		public AmountSchedule.AmountScheduleBuilder addCurrency(FieldWithMetaString currency) {
			if (currency!=null) this.currency.add(currency.toBuilder());
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder addCurrency(FieldWithMetaString currency, int _idx) {
			getIndex(this.currency, _idx, () -> currency.toBuilder());
			return this;
		}
		
			@Override
			public AmountSchedule.AmountScheduleBuilder addCurrencyValue(String currency) {
				this.getOrCreateCurrency(-1).setValue(currency);
				return this;
			}
			
			@Override
			public AmountSchedule.AmountScheduleBuilder addCurrencyValue(String currency, int _idx) {
				this.getOrCreateCurrency(_idx).setValue(currency);
				return this;
			}
		@Override 
		public AmountSchedule.AmountScheduleBuilder addCurrency(List<? extends FieldWithMetaString> currencys) {
			if (currencys != null) {
				for (FieldWithMetaString toAdd : currencys) {
					this.currency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AmountSchedule.AmountScheduleBuilder setCurrency(List<? extends FieldWithMetaString> currencys) {
			if (currencys == null)  {
				this.currency = new ArrayList<>();
			}
			else {
				this.currency = currencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder addCurrencyValue(List<? extends String> currencys) {
			if (currencys != null) {
				for (String toAdd : currencys) {
					this.addCurrencyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder setCurrencyValue(List<? extends String> currencys) {
			this.currency.clear();
			if (currencys!=null) {
				currencys.forEach(this::addCurrencyValue);
			}
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		public AmountSchedule.AmountScheduleBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public AmountSchedule.AmountScheduleBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AmountSchedule.AmountScheduleBuilder setStep(List<? extends Step> steps) {
			if (steps == null)  {
				this.step = new ArrayList<>();
			}
			else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AmountSchedule build() {
			return new AmountSchedule.AmountScheduleImpl(this);
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountSchedule.AmountScheduleBuilder prune() {
			super.prune();
			currency = currency.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && !getCurrency().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountSchedule.AmountScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AmountSchedule.AmountScheduleBuilder o = (AmountSchedule.AmountScheduleBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::getOrCreateCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AmountSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmountScheduleBuilder {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}
}
