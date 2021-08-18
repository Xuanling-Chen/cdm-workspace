package cdm.observable.asset;

import cdm.observable.asset.meta.SettlementRateOptionMeta;
import cdm.observable.asset.metafields.FieldWithMetaSettlementRateOptionEnum;
import cdm.observable.asset.metafields.FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder;
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
 * Defines the settlement rate option to use for fixing in case of cash settlement. Currently only applicable to foreign exchange fixing in case of cross-currency settlement.
 * @version ${project.version}
 */
@RosettaClass

public interface SettlementRateOption extends RosettaModelObject {
	SettlementRateOption build();
	SettlementRateOption.SettlementRateOptionBuilder toBuilder();
	
	/**
	 * An attribute defining the parameters to get a new quote when a settlement rate option is disrupted.
	 */
	PriceSourceDisruption getPriceSourceDisruption();
	/**
	 * The rate source for the conversion to the settlement currency. This source is specified through a scheme that reflects the terms of the Annex A to the 1998 FX and Currency Option Definitions.
	 */
	FieldWithMetaSettlementRateOptionEnum getSettlementRateOption();
	final static SettlementRateOptionMeta metaData = new SettlementRateOptionMeta();
	
	@Override
	default RosettaMetaData<? extends SettlementRateOption> metaData() {
		return metaData;
	} 
			
	static SettlementRateOption.SettlementRateOptionBuilder builder() {
		return new SettlementRateOption.SettlementRateOptionBuilderImpl();
	}
	
	default Class<? extends SettlementRateOption> getType() {
		return SettlementRateOption.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("priceSourceDisruption"), processor, PriceSourceDisruption.class, getPriceSourceDisruption());
		processRosetta(path.newSubPath("settlementRateOption"), processor, FieldWithMetaSettlementRateOptionEnum.class, getSettlementRateOption());
	}
	
	
	interface SettlementRateOptionBuilder extends SettlementRateOption, RosettaModelObjectBuilder {
		PriceSourceDisruption.PriceSourceDisruptionBuilder getOrCreatePriceSourceDisruption();
		PriceSourceDisruption.PriceSourceDisruptionBuilder getPriceSourceDisruption();
		FieldWithMetaSettlementRateOptionEnumBuilder getOrCreateSettlementRateOption();
		FieldWithMetaSettlementRateOptionEnumBuilder getSettlementRateOption();
		SettlementRateOption.SettlementRateOptionBuilder setPriceSourceDisruption(PriceSourceDisruption priceSourceDisruption);
		SettlementRateOption.SettlementRateOptionBuilder setSettlementRateOption(FieldWithMetaSettlementRateOptionEnum settlementRateOption);
		SettlementRateOption.SettlementRateOptionBuilder setSettlementRateOptionValue(SettlementRateOptionEnum settlementRateOption);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("priceSourceDisruption"), processor, PriceSourceDisruption.PriceSourceDisruptionBuilder.class, getPriceSourceDisruption());
			processRosetta(path.newSubPath("settlementRateOption"), processor, FieldWithMetaSettlementRateOptionEnumBuilder.class, getSettlementRateOption());
		}
		
	}
	
	//SettlementRateOption.SettlementRateOptionImpl
	class SettlementRateOptionImpl implements SettlementRateOption {
		private final PriceSourceDisruption priceSourceDisruption;
		private final FieldWithMetaSettlementRateOptionEnum settlementRateOption;
		
		protected SettlementRateOptionImpl(SettlementRateOption.SettlementRateOptionBuilder builder) {
			this.priceSourceDisruption = ofNullable(builder.getPriceSourceDisruption()).map(f->f.build()).orElse(null);
			this.settlementRateOption = ofNullable(builder.getSettlementRateOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public PriceSourceDisruption getPriceSourceDisruption() {
			return priceSourceDisruption;
		}
		
		@Override
		public FieldWithMetaSettlementRateOptionEnum getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		public SettlementRateOption build() {
			return this;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder toBuilder() {
			SettlementRateOption.SettlementRateOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementRateOption.SettlementRateOptionBuilder builder) {
			ofNullable(getPriceSourceDisruption()).ifPresent(builder::setPriceSourceDisruption);
			ofNullable(getSettlementRateOption()).ifPresent(builder::setSettlementRateOption);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementRateOption _that = getType().cast(o);
		
			if (!Objects.equals(priceSourceDisruption, _that.getPriceSourceDisruption())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceSourceDisruption != null ? priceSourceDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementRateOption {" +
				"priceSourceDisruption=" + this.priceSourceDisruption + ", " +
				"settlementRateOption=" + this.settlementRateOption +
			'}';
		}
	}
	
	//SettlementRateOption.SettlementRateOptionBuilderImpl
	class SettlementRateOptionBuilderImpl implements SettlementRateOption.SettlementRateOptionBuilder {
	
		protected PriceSourceDisruption.PriceSourceDisruptionBuilder priceSourceDisruption;
		protected FieldWithMetaSettlementRateOptionEnumBuilder settlementRateOption;
	
		public SettlementRateOptionBuilderImpl() {
		}
	
		@Override
		public PriceSourceDisruption.PriceSourceDisruptionBuilder getPriceSourceDisruption() {
			return priceSourceDisruption;
		}
		
		@Override
		public PriceSourceDisruption.PriceSourceDisruptionBuilder getOrCreatePriceSourceDisruption() {
			PriceSourceDisruption.PriceSourceDisruptionBuilder result;
			if (priceSourceDisruption!=null) {
				result = priceSourceDisruption;
			}
			else {
				result = priceSourceDisruption = PriceSourceDisruption.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaSettlementRateOptionEnumBuilder getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		public FieldWithMetaSettlementRateOptionEnumBuilder getOrCreateSettlementRateOption() {
			FieldWithMetaSettlementRateOptionEnumBuilder result;
			if (settlementRateOption!=null) {
				result = settlementRateOption;
			}
			else {
				result = settlementRateOption = FieldWithMetaSettlementRateOptionEnum.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder setPriceSourceDisruption(PriceSourceDisruption priceSourceDisruption) {
			this.priceSourceDisruption = priceSourceDisruption==null?null:priceSourceDisruption.toBuilder();
			return this;
		}
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder setSettlementRateOption(FieldWithMetaSettlementRateOptionEnum settlementRateOption) {
			this.settlementRateOption = settlementRateOption==null?null:settlementRateOption.toBuilder();
			return this;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder setSettlementRateOptionValue(SettlementRateOptionEnum settlementRateOption) {
			this.getOrCreateSettlementRateOption().setValue(settlementRateOption);
			return this;
		}
		
		@Override
		public SettlementRateOption build() {
			return new SettlementRateOption.SettlementRateOptionImpl(this);
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder prune() {
			if (priceSourceDisruption!=null && !priceSourceDisruption.prune().hasData()) priceSourceDisruption = null;
			if (settlementRateOption!=null && !settlementRateOption.prune().hasData()) settlementRateOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPriceSourceDisruption()!=null && getPriceSourceDisruption().hasData()) return true;
			if (getSettlementRateOption()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementRateOption.SettlementRateOptionBuilder o = (SettlementRateOption.SettlementRateOptionBuilder) other;
			
			merger.mergeRosetta(getPriceSourceDisruption(), o.getPriceSourceDisruption(), this::setPriceSourceDisruption);
			merger.mergeRosetta(getSettlementRateOption(), o.getSettlementRateOption(), this::setSettlementRateOption);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementRateOption _that = getType().cast(o);
		
			if (!Objects.equals(priceSourceDisruption, _that.getPriceSourceDisruption())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceSourceDisruption != null ? priceSourceDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementRateOptionBuilder {" +
				"priceSourceDisruption=" + this.priceSourceDisruption + ", " +
				"settlementRateOption=" + this.settlementRateOption +
			'}';
		}
	}
}
