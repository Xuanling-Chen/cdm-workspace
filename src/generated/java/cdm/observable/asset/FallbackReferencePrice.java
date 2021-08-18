package cdm.observable.asset;

import cdm.observable.asset.meta.FallbackReferencePriceMeta;
import cdm.observable.asset.metafields.FieldWithMetaSettlementRateOptionEnum;
import cdm.observable.asset.metafields.FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
 * @version ${project.version}
 */
@RosettaClass

public interface FallbackReferencePrice extends RosettaModelObject {
	FallbackReferencePrice build();
	FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder();
	
	/**
	 * The calculation agent will decide the rate.
	 */
	CalculationAgent getCalculationAgentDetermination();
	/**
	 * This settlement rate option will be used in its place.
	 */
	List<? extends FieldWithMetaSettlementRateOptionEnum> getFallBackSettlementRateOption();
	/**
	 * Request rate quotes from the market. This element is set as type Empty in FpML. When present, the FpML synonym is mapped to a value True in the CDM.
	 */
	Boolean getFallbackSurveyValuationPostponement();
	/**
	 * Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.
	 */
	ValuationPostponement getValuationPostponement();
	final static FallbackReferencePriceMeta metaData = new FallbackReferencePriceMeta();
	
	@Override
	default RosettaMetaData<? extends FallbackReferencePrice> metaData() {
		return metaData;
	} 
			
	static FallbackReferencePrice.FallbackReferencePriceBuilder builder() {
		return new FallbackReferencePrice.FallbackReferencePriceBuilderImpl();
	}
	
	default Class<? extends FallbackReferencePrice> getType() {
		return FallbackReferencePrice.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fallbackSurveyValuationPostponement"), Boolean.class, getFallbackSurveyValuationPostponement(), this);
		
		processRosetta(path.newSubPath("calculationAgentDetermination"), processor, CalculationAgent.class, getCalculationAgentDetermination());
		processRosetta(path.newSubPath("fallBackSettlementRateOption"), processor, FieldWithMetaSettlementRateOptionEnum.class, getFallBackSettlementRateOption());
		processRosetta(path.newSubPath("valuationPostponement"), processor, ValuationPostponement.class, getValuationPostponement());
	}
	
	
	interface FallbackReferencePriceBuilder extends FallbackReferencePrice, RosettaModelObjectBuilder {
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgentDetermination();
		CalculationAgent.CalculationAgentBuilder getCalculationAgentDetermination();
		FieldWithMetaSettlementRateOptionEnumBuilder getOrCreateFallBackSettlementRateOption(int _index);
		List<? extends FieldWithMetaSettlementRateOptionEnumBuilder> getFallBackSettlementRateOption();
		ValuationPostponement.ValuationPostponementBuilder getOrCreateValuationPostponement();
		ValuationPostponement.ValuationPostponementBuilder getValuationPostponement();
		FallbackReferencePrice.FallbackReferencePriceBuilder setCalculationAgentDetermination(CalculationAgent calculationAgentDetermination);
		FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOption(FieldWithMetaSettlementRateOptionEnum fallBackSettlementRateOption);
		FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOption(FieldWithMetaSettlementRateOptionEnum fallBackSettlementRateOption, int _idx);
		FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOptionValue(SettlementRateOptionEnum fallBackSettlementRateOption);
		FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOptionValue(SettlementRateOptionEnum fallBackSettlementRateOption, int _idx);
		FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOption(List<? extends FieldWithMetaSettlementRateOptionEnum> fallBackSettlementRateOption);
		FallbackReferencePrice.FallbackReferencePriceBuilder setFallBackSettlementRateOption(List<? extends FieldWithMetaSettlementRateOptionEnum> fallBackSettlementRateOption);
		FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOptionValue(List<? extends SettlementRateOptionEnum> fallBackSettlementRateOption);
		FallbackReferencePrice.FallbackReferencePriceBuilder setFallBackSettlementRateOptionValue(List<? extends SettlementRateOptionEnum> fallBackSettlementRateOption);
		FallbackReferencePrice.FallbackReferencePriceBuilder setFallbackSurveyValuationPostponement(Boolean fallbackSurveyValuationPostponement);
		FallbackReferencePrice.FallbackReferencePriceBuilder setValuationPostponement(ValuationPostponement valuationPostponement);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("fallbackSurveyValuationPostponement"), Boolean.class, getFallbackSurveyValuationPostponement(), this);
			
			processRosetta(path.newSubPath("calculationAgentDetermination"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgentDetermination());
			processRosetta(path.newSubPath("fallBackSettlementRateOption"), processor, FieldWithMetaSettlementRateOptionEnumBuilder.class, getFallBackSettlementRateOption());
			processRosetta(path.newSubPath("valuationPostponement"), processor, ValuationPostponement.ValuationPostponementBuilder.class, getValuationPostponement());
		}
		
	}
	
	//FallbackReferencePrice.FallbackReferencePriceImpl
	class FallbackReferencePriceImpl implements FallbackReferencePrice {
		private final CalculationAgent calculationAgentDetermination;
		private final List<? extends FieldWithMetaSettlementRateOptionEnum> fallBackSettlementRateOption;
		private final Boolean fallbackSurveyValuationPostponement;
		private final ValuationPostponement valuationPostponement;
		
		protected FallbackReferencePriceImpl(FallbackReferencePrice.FallbackReferencePriceBuilder builder) {
			this.calculationAgentDetermination = ofNullable(builder.getCalculationAgentDetermination()).map(f->f.build()).orElse(null);
			this.fallBackSettlementRateOption = ofNullable(builder.getFallBackSettlementRateOption()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fallbackSurveyValuationPostponement = builder.getFallbackSurveyValuationPostponement();
			this.valuationPostponement = ofNullable(builder.getValuationPostponement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CalculationAgent getCalculationAgentDetermination() {
			return calculationAgentDetermination;
		}
		
		@Override
		public List<? extends FieldWithMetaSettlementRateOptionEnum> getFallBackSettlementRateOption() {
			return fallBackSettlementRateOption;
		}
		
		@Override
		public Boolean getFallbackSurveyValuationPostponement() {
			return fallbackSurveyValuationPostponement;
		}
		
		@Override
		public ValuationPostponement getValuationPostponement() {
			return valuationPostponement;
		}
		
		@Override
		public FallbackReferencePrice build() {
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder() {
			FallbackReferencePrice.FallbackReferencePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FallbackReferencePrice.FallbackReferencePriceBuilder builder) {
			ofNullable(getCalculationAgentDetermination()).ifPresent(builder::setCalculationAgentDetermination);
			ofNullable(getFallBackSettlementRateOption()).ifPresent(builder::setFallBackSettlementRateOption);
			ofNullable(getFallbackSurveyValuationPostponement()).ifPresent(builder::setFallbackSurveyValuationPostponement);
			ofNullable(getValuationPostponement()).ifPresent(builder::setValuationPostponement);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackReferencePrice _that = getType().cast(o);
		
			if (!Objects.equals(calculationAgentDetermination, _that.getCalculationAgentDetermination())) return false;
			if (!ListEquals.listEquals(fallBackSettlementRateOption, _that.getFallBackSettlementRateOption())) return false;
			if (!Objects.equals(fallbackSurveyValuationPostponement, _that.getFallbackSurveyValuationPostponement())) return false;
			if (!Objects.equals(valuationPostponement, _that.getValuationPostponement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAgentDetermination != null ? calculationAgentDetermination.hashCode() : 0);
			_result = 31 * _result + (fallBackSettlementRateOption != null ? fallBackSettlementRateOption.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (fallbackSurveyValuationPostponement != null ? fallbackSurveyValuationPostponement.hashCode() : 0);
			_result = 31 * _result + (valuationPostponement != null ? valuationPostponement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackReferencePrice {" +
				"calculationAgentDetermination=" + this.calculationAgentDetermination + ", " +
				"fallBackSettlementRateOption=" + this.fallBackSettlementRateOption + ", " +
				"fallbackSurveyValuationPostponement=" + this.fallbackSurveyValuationPostponement + ", " +
				"valuationPostponement=" + this.valuationPostponement +
			'}';
		}
	}
	
	//FallbackReferencePrice.FallbackReferencePriceBuilderImpl
	class FallbackReferencePriceBuilderImpl implements FallbackReferencePrice.FallbackReferencePriceBuilder {
	
		protected CalculationAgent.CalculationAgentBuilder calculationAgentDetermination;
		protected List<FieldWithMetaSettlementRateOptionEnumBuilder> fallBackSettlementRateOption = new ArrayList<>();
		protected Boolean fallbackSurveyValuationPostponement;
		protected ValuationPostponement.ValuationPostponementBuilder valuationPostponement;
	
		public FallbackReferencePriceBuilderImpl() {
		}
	
		@Override
		public CalculationAgent.CalculationAgentBuilder getCalculationAgentDetermination() {
			return calculationAgentDetermination;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgentDetermination() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgentDetermination!=null) {
				result = calculationAgentDetermination;
			}
			else {
				result = calculationAgentDetermination = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends FieldWithMetaSettlementRateOptionEnumBuilder> getFallBackSettlementRateOption() {
			return fallBackSettlementRateOption;
		}
		
		public FieldWithMetaSettlementRateOptionEnumBuilder getOrCreateFallBackSettlementRateOption(int _index) {
		
			if (fallBackSettlementRateOption==null) {
				this.fallBackSettlementRateOption = new ArrayList<>();
			}
			FieldWithMetaSettlementRateOptionEnumBuilder result;
			return getIndex(fallBackSettlementRateOption, _index, () -> {
						FieldWithMetaSettlementRateOptionEnumBuilder newFallBackSettlementRateOption = FieldWithMetaSettlementRateOptionEnum.builder();
						return newFallBackSettlementRateOption;
					});
		}
		
		@Override
		public Boolean getFallbackSurveyValuationPostponement() {
			return fallbackSurveyValuationPostponement;
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder getValuationPostponement() {
			return valuationPostponement;
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder getOrCreateValuationPostponement() {
			ValuationPostponement.ValuationPostponementBuilder result;
			if (valuationPostponement!=null) {
				result = valuationPostponement;
			}
			else {
				result = valuationPostponement = ValuationPostponement.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder setCalculationAgentDetermination(CalculationAgent calculationAgentDetermination) {
			this.calculationAgentDetermination = calculationAgentDetermination==null?null:calculationAgentDetermination.toBuilder();
			return this;
		}
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOption(FieldWithMetaSettlementRateOptionEnum fallBackSettlementRateOption) {
			if (fallBackSettlementRateOption!=null) this.fallBackSettlementRateOption.add(fallBackSettlementRateOption.toBuilder());
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOption(FieldWithMetaSettlementRateOptionEnum fallBackSettlementRateOption, int _idx) {
			getIndex(this.fallBackSettlementRateOption, _idx, () -> fallBackSettlementRateOption.toBuilder());
			return this;
		}
		
			@Override
			public FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOptionValue(SettlementRateOptionEnum fallBackSettlementRateOption) {
				this.getOrCreateFallBackSettlementRateOption(-1).setValue(fallBackSettlementRateOption);
				return this;
			}
			
			@Override
			public FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOptionValue(SettlementRateOptionEnum fallBackSettlementRateOption, int _idx) {
				this.getOrCreateFallBackSettlementRateOption(_idx).setValue(fallBackSettlementRateOption);
				return this;
			}
		@Override 
		public FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOption(List<? extends FieldWithMetaSettlementRateOptionEnum> fallBackSettlementRateOptions) {
			if (fallBackSettlementRateOptions != null) {
				for (FieldWithMetaSettlementRateOptionEnum toAdd : fallBackSettlementRateOptions) {
					this.fallBackSettlementRateOption.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FallbackReferencePrice.FallbackReferencePriceBuilder setFallBackSettlementRateOption(List<? extends FieldWithMetaSettlementRateOptionEnum> fallBackSettlementRateOptions) {
			if (fallBackSettlementRateOptions == null)  {
				this.fallBackSettlementRateOption = new ArrayList<>();
			}
			else {
				this.fallBackSettlementRateOption = fallBackSettlementRateOptions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder addFallBackSettlementRateOptionValue(List<? extends SettlementRateOptionEnum> fallBackSettlementRateOptions) {
			if (fallBackSettlementRateOptions != null) {
				for (SettlementRateOptionEnum toAdd : fallBackSettlementRateOptions) {
					this.addFallBackSettlementRateOptionValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder setFallBackSettlementRateOptionValue(List<? extends SettlementRateOptionEnum> fallBackSettlementRateOptions) {
			this.fallBackSettlementRateOption.clear();
			if (fallBackSettlementRateOptions!=null) {
				fallBackSettlementRateOptions.forEach(this::addFallBackSettlementRateOptionValue);
			}
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder setFallbackSurveyValuationPostponement(Boolean fallbackSurveyValuationPostponement) {
			this.fallbackSurveyValuationPostponement = fallbackSurveyValuationPostponement==null?null:fallbackSurveyValuationPostponement;
			return this;
		}
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder setValuationPostponement(ValuationPostponement valuationPostponement) {
			this.valuationPostponement = valuationPostponement==null?null:valuationPostponement.toBuilder();
			return this;
		}
		
		@Override
		public FallbackReferencePrice build() {
			return new FallbackReferencePrice.FallbackReferencePriceImpl(this);
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder prune() {
			if (calculationAgentDetermination!=null && !calculationAgentDetermination.prune().hasData()) calculationAgentDetermination = null;
			fallBackSettlementRateOption = fallBackSettlementRateOption.stream().filter(b->b!=null).<FieldWithMetaSettlementRateOptionEnumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (valuationPostponement!=null && !valuationPostponement.prune().hasData()) valuationPostponement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationAgentDetermination()!=null && getCalculationAgentDetermination().hasData()) return true;
			if (getFallBackSettlementRateOption()!=null && !getFallBackSettlementRateOption().isEmpty()) return true;
			if (getFallbackSurveyValuationPostponement()!=null) return true;
			if (getValuationPostponement()!=null && getValuationPostponement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FallbackReferencePrice.FallbackReferencePriceBuilder o = (FallbackReferencePrice.FallbackReferencePriceBuilder) other;
			
			merger.mergeRosetta(getCalculationAgentDetermination(), o.getCalculationAgentDetermination(), this::setCalculationAgentDetermination);
			merger.mergeRosetta(getFallBackSettlementRateOption(), o.getFallBackSettlementRateOption(), this::getOrCreateFallBackSettlementRateOption);
			merger.mergeRosetta(getValuationPostponement(), o.getValuationPostponement(), this::setValuationPostponement);
			
			merger.mergeBasic(getFallbackSurveyValuationPostponement(), o.getFallbackSurveyValuationPostponement(), this::setFallbackSurveyValuationPostponement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackReferencePrice _that = getType().cast(o);
		
			if (!Objects.equals(calculationAgentDetermination, _that.getCalculationAgentDetermination())) return false;
			if (!ListEquals.listEquals(fallBackSettlementRateOption, _that.getFallBackSettlementRateOption())) return false;
			if (!Objects.equals(fallbackSurveyValuationPostponement, _that.getFallbackSurveyValuationPostponement())) return false;
			if (!Objects.equals(valuationPostponement, _that.getValuationPostponement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAgentDetermination != null ? calculationAgentDetermination.hashCode() : 0);
			_result = 31 * _result + (fallBackSettlementRateOption != null ? fallBackSettlementRateOption.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (fallbackSurveyValuationPostponement != null ? fallbackSurveyValuationPostponement.hashCode() : 0);
			_result = 31 * _result + (valuationPostponement != null ? valuationPostponement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackReferencePriceBuilder {" +
				"calculationAgentDetermination=" + this.calculationAgentDetermination + ", " +
				"fallBackSettlementRateOption=" + this.fallBackSettlementRateOption + ", " +
				"fallbackSurveyValuationPostponement=" + this.fallbackSurveyValuationPostponement + ", " +
				"valuationPostponement=" + this.valuationPostponement +
			'}';
		}
	}
}
