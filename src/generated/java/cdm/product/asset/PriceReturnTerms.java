package cdm.product.asset;

import cdm.observable.asset.EquityValuation;
import cdm.product.asset.meta.PriceReturnTermsMeta;
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
 * @version ${project.version}
 */
@RosettaClass

public interface PriceReturnTerms extends RosettaModelObject {
	PriceReturnTerms build();
	PriceReturnTerms.PriceReturnTermsBuilder toBuilder();
	
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Final Price | Specifies the final valuation price of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 */
	EquityValuation getValuationPriceFinal();
	/**
	 * Specifies the interim valuation price(s) of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 */
	EquityValuation getValuationPriceInterim();
	final static PriceReturnTermsMeta metaData = new PriceReturnTermsMeta();
	
	@Override
	default RosettaMetaData<? extends PriceReturnTerms> metaData() {
		return metaData;
	} 
			
	static PriceReturnTerms.PriceReturnTermsBuilder builder() {
		return new PriceReturnTerms.PriceReturnTermsBuilderImpl();
	}
	
	default Class<? extends PriceReturnTerms> getType() {
		return PriceReturnTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("valuationPriceFinal"), processor, EquityValuation.class, getValuationPriceFinal());
		processRosetta(path.newSubPath("valuationPriceInterim"), processor, EquityValuation.class, getValuationPriceInterim());
	}
	
	
	interface PriceReturnTermsBuilder extends PriceReturnTerms, RosettaModelObjectBuilder {
		EquityValuation.EquityValuationBuilder getOrCreateValuationPriceFinal();
		EquityValuation.EquityValuationBuilder getValuationPriceFinal();
		EquityValuation.EquityValuationBuilder getOrCreateValuationPriceInterim();
		EquityValuation.EquityValuationBuilder getValuationPriceInterim();
		PriceReturnTerms.PriceReturnTermsBuilder setValuationPriceFinal(EquityValuation valuationPriceFinal);
		PriceReturnTerms.PriceReturnTermsBuilder setValuationPriceInterim(EquityValuation valuationPriceInterim);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("valuationPriceFinal"), processor, EquityValuation.EquityValuationBuilder.class, getValuationPriceFinal());
			processRosetta(path.newSubPath("valuationPriceInterim"), processor, EquityValuation.EquityValuationBuilder.class, getValuationPriceInterim());
		}
		
	}
	
	//PriceReturnTerms.PriceReturnTermsImpl
	class PriceReturnTermsImpl implements PriceReturnTerms {
		private final EquityValuation valuationPriceFinal;
		private final EquityValuation valuationPriceInterim;
		
		protected PriceReturnTermsImpl(PriceReturnTerms.PriceReturnTermsBuilder builder) {
			this.valuationPriceFinal = ofNullable(builder.getValuationPriceFinal()).map(f->f.build()).orElse(null);
			this.valuationPriceInterim = ofNullable(builder.getValuationPriceInterim()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public EquityValuation getValuationPriceFinal() {
			return valuationPriceFinal;
		}
		
		@Override
		public EquityValuation getValuationPriceInterim() {
			return valuationPriceInterim;
		}
		
		@Override
		public PriceReturnTerms build() {
			return this;
		}
		
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder toBuilder() {
			PriceReturnTerms.PriceReturnTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceReturnTerms.PriceReturnTermsBuilder builder) {
			ofNullable(getValuationPriceFinal()).ifPresent(builder::setValuationPriceFinal);
			ofNullable(getValuationPriceInterim()).ifPresent(builder::setValuationPriceInterim);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(valuationPriceFinal, _that.getValuationPriceFinal())) return false;
			if (!Objects.equals(valuationPriceInterim, _that.getValuationPriceInterim())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationPriceFinal != null ? valuationPriceFinal.hashCode() : 0);
			_result = 31 * _result + (valuationPriceInterim != null ? valuationPriceInterim.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceReturnTerms {" +
				"valuationPriceFinal=" + this.valuationPriceFinal + ", " +
				"valuationPriceInterim=" + this.valuationPriceInterim +
			'}';
		}
	}
	
	//PriceReturnTerms.PriceReturnTermsBuilderImpl
	class PriceReturnTermsBuilderImpl implements PriceReturnTerms.PriceReturnTermsBuilder {
	
		protected EquityValuation.EquityValuationBuilder valuationPriceFinal;
		protected EquityValuation.EquityValuationBuilder valuationPriceInterim;
	
		public PriceReturnTermsBuilderImpl() {
		}
	
		@Override
		public EquityValuation.EquityValuationBuilder getValuationPriceFinal() {
			return valuationPriceFinal;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder getOrCreateValuationPriceFinal() {
			EquityValuation.EquityValuationBuilder result;
			if (valuationPriceFinal!=null) {
				result = valuationPriceFinal;
			}
			else {
				result = valuationPriceFinal = EquityValuation.builder();
			}
			
			return result;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder getValuationPriceInterim() {
			return valuationPriceInterim;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder getOrCreateValuationPriceInterim() {
			EquityValuation.EquityValuationBuilder result;
			if (valuationPriceInterim!=null) {
				result = valuationPriceInterim;
			}
			else {
				result = valuationPriceInterim = EquityValuation.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder setValuationPriceFinal(EquityValuation valuationPriceFinal) {
			this.valuationPriceFinal = valuationPriceFinal==null?null:valuationPriceFinal.toBuilder();
			return this;
		}
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder setValuationPriceInterim(EquityValuation valuationPriceInterim) {
			this.valuationPriceInterim = valuationPriceInterim==null?null:valuationPriceInterim.toBuilder();
			return this;
		}
		
		@Override
		public PriceReturnTerms build() {
			return new PriceReturnTerms.PriceReturnTermsImpl(this);
		}
		
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder prune() {
			if (valuationPriceFinal!=null && !valuationPriceFinal.prune().hasData()) valuationPriceFinal = null;
			if (valuationPriceInterim!=null && !valuationPriceInterim.prune().hasData()) valuationPriceInterim = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValuationPriceFinal()!=null && getValuationPriceFinal().hasData()) return true;
			if (getValuationPriceInterim()!=null && getValuationPriceInterim().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceReturnTerms.PriceReturnTermsBuilder o = (PriceReturnTerms.PriceReturnTermsBuilder) other;
			
			merger.mergeRosetta(getValuationPriceFinal(), o.getValuationPriceFinal(), this::setValuationPriceFinal);
			merger.mergeRosetta(getValuationPriceInterim(), o.getValuationPriceInterim(), this::setValuationPriceInterim);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(valuationPriceFinal, _that.getValuationPriceFinal())) return false;
			if (!Objects.equals(valuationPriceInterim, _that.getValuationPriceInterim())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationPriceFinal != null ? valuationPriceFinal.hashCode() : 0);
			_result = 31 * _result + (valuationPriceInterim != null ? valuationPriceInterim.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceReturnTermsBuilder {" +
				"valuationPriceFinal=" + this.valuationPriceFinal + ", " +
				"valuationPriceInterim=" + this.valuationPriceInterim +
			'}';
		}
	}
}
