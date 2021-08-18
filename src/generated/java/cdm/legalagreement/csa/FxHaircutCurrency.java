package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.FxHaircutCurrencyMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the reference currency for the purpose of specifying the FX Haircut relating to a posting obligation, as being either the Termination Currency or an FX Designated Currency.
 * @version ${project.version}
 */
@RosettaClass

public interface FxHaircutCurrency extends RosettaModelObject {
	FxHaircutCurrency build();
	FxHaircutCurrency.FxHaircutCurrencyBuilder toBuilder();
	
	/**
	 * When specified, the reference currency for the purpose of specifying the FX Haircut relating to a posting obligation. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getFxDesignatedCurrency();
	/**
	 * The reference currency for the purpose of specifying the FX Haircut relating to a posting obligation is the Termination Currency when the Boolean value is set to True.
	 */
	Boolean getIsTerminationCurrency();
	final static FxHaircutCurrencyMeta metaData = new FxHaircutCurrencyMeta();
	
	@Override
	default RosettaMetaData<? extends FxHaircutCurrency> metaData() {
		return metaData;
	} 
			
	static FxHaircutCurrency.FxHaircutCurrencyBuilder builder() {
		return new FxHaircutCurrency.FxHaircutCurrencyBuilderImpl();
	}
	
	default Class<? extends FxHaircutCurrency> getType() {
		return FxHaircutCurrency.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isTerminationCurrency"), Boolean.class, getIsTerminationCurrency(), this);
		
		processRosetta(path.newSubPath("fxDesignatedCurrency"), processor, FieldWithMetaString.class, getFxDesignatedCurrency());
	}
	
	
	interface FxHaircutCurrencyBuilder extends FxHaircutCurrency, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateFxDesignatedCurrency();
		FieldWithMetaStringBuilder getFxDesignatedCurrency();
		FxHaircutCurrency.FxHaircutCurrencyBuilder setFxDesignatedCurrency(FieldWithMetaString fxDesignatedCurrency);
		FxHaircutCurrency.FxHaircutCurrencyBuilder setFxDesignatedCurrencyValue(String fxDesignatedCurrency);
		FxHaircutCurrency.FxHaircutCurrencyBuilder setIsTerminationCurrency(Boolean isTerminationCurrency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isTerminationCurrency"), Boolean.class, getIsTerminationCurrency(), this);
			
			processRosetta(path.newSubPath("fxDesignatedCurrency"), processor, FieldWithMetaStringBuilder.class, getFxDesignatedCurrency());
		}
		
	}
	
	//FxHaircutCurrency.FxHaircutCurrencyImpl
	class FxHaircutCurrencyImpl implements FxHaircutCurrency {
		private final FieldWithMetaString fxDesignatedCurrency;
		private final Boolean isTerminationCurrency;
		
		protected FxHaircutCurrencyImpl(FxHaircutCurrency.FxHaircutCurrencyBuilder builder) {
			this.fxDesignatedCurrency = ofNullable(builder.getFxDesignatedCurrency()).map(f->f.build()).orElse(null);
			this.isTerminationCurrency = builder.getIsTerminationCurrency();
		}
		
		@Override
		public FieldWithMetaString getFxDesignatedCurrency() {
			return fxDesignatedCurrency;
		}
		
		@Override
		public Boolean getIsTerminationCurrency() {
			return isTerminationCurrency;
		}
		
		@Override
		public FxHaircutCurrency build() {
			return this;
		}
		
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder toBuilder() {
			FxHaircutCurrency.FxHaircutCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxHaircutCurrency.FxHaircutCurrencyBuilder builder) {
			ofNullable(getFxDesignatedCurrency()).ifPresent(builder::setFxDesignatedCurrency);
			ofNullable(getIsTerminationCurrency()).ifPresent(builder::setIsTerminationCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxHaircutCurrency _that = getType().cast(o);
		
			if (!Objects.equals(fxDesignatedCurrency, _that.getFxDesignatedCurrency())) return false;
			if (!Objects.equals(isTerminationCurrency, _that.getIsTerminationCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxDesignatedCurrency != null ? fxDesignatedCurrency.hashCode() : 0);
			_result = 31 * _result + (isTerminationCurrency != null ? isTerminationCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxHaircutCurrency {" +
				"fxDesignatedCurrency=" + this.fxDesignatedCurrency + ", " +
				"isTerminationCurrency=" + this.isTerminationCurrency +
			'}';
		}
	}
	
	//FxHaircutCurrency.FxHaircutCurrencyBuilderImpl
	class FxHaircutCurrencyBuilderImpl implements FxHaircutCurrency.FxHaircutCurrencyBuilder {
	
		protected FieldWithMetaStringBuilder fxDesignatedCurrency;
		protected Boolean isTerminationCurrency;
	
		public FxHaircutCurrencyBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getFxDesignatedCurrency() {
			return fxDesignatedCurrency;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateFxDesignatedCurrency() {
			FieldWithMetaStringBuilder result;
			if (fxDesignatedCurrency!=null) {
				result = fxDesignatedCurrency;
			}
			else {
				result = fxDesignatedCurrency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getIsTerminationCurrency() {
			return isTerminationCurrency;
		}
		
	
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder setFxDesignatedCurrency(FieldWithMetaString fxDesignatedCurrency) {
			this.fxDesignatedCurrency = fxDesignatedCurrency==null?null:fxDesignatedCurrency.toBuilder();
			return this;
		}
		
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder setFxDesignatedCurrencyValue(String fxDesignatedCurrency) {
			this.getOrCreateFxDesignatedCurrency().setValue(fxDesignatedCurrency);
			return this;
		}
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder setIsTerminationCurrency(Boolean isTerminationCurrency) {
			this.isTerminationCurrency = isTerminationCurrency==null?null:isTerminationCurrency;
			return this;
		}
		
		@Override
		public FxHaircutCurrency build() {
			return new FxHaircutCurrency.FxHaircutCurrencyImpl(this);
		}
		
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder prune() {
			if (fxDesignatedCurrency!=null && !fxDesignatedCurrency.prune().hasData()) fxDesignatedCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxDesignatedCurrency()!=null) return true;
			if (getIsTerminationCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxHaircutCurrency.FxHaircutCurrencyBuilder o = (FxHaircutCurrency.FxHaircutCurrencyBuilder) other;
			
			merger.mergeRosetta(getFxDesignatedCurrency(), o.getFxDesignatedCurrency(), this::setFxDesignatedCurrency);
			
			merger.mergeBasic(getIsTerminationCurrency(), o.getIsTerminationCurrency(), this::setIsTerminationCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxHaircutCurrency _that = getType().cast(o);
		
			if (!Objects.equals(fxDesignatedCurrency, _that.getFxDesignatedCurrency())) return false;
			if (!Objects.equals(isTerminationCurrency, _that.getIsTerminationCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxDesignatedCurrency != null ? fxDesignatedCurrency.hashCode() : 0);
			_result = 31 * _result + (isTerminationCurrency != null ? isTerminationCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxHaircutCurrencyBuilder {" +
				"fxDesignatedCurrency=" + this.fxDesignatedCurrency + ", " +
				"isTerminationCurrency=" + this.isTerminationCurrency +
			'}';
		}
	}
}
