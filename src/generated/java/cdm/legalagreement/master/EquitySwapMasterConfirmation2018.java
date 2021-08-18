package cdm.legalagreement.master;

import cdm.legalagreement.master.EquityMasterConfirmation.EquityMasterConfirmationBuilder;
import cdm.legalagreement.master.EquityMasterConfirmation.EquityMasterConfirmationBuilderImpl;
import cdm.legalagreement.master.EquityMasterConfirmation.EquityMasterConfirmationImpl;
import cdm.legalagreement.master.meta.EquitySwapMasterConfirmation2018Meta;
import cdm.observable.asset.InterpolationMethodEnum;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.asset.ReturnTypeEnum;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.settlement.SettlementTerms;
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
 * Specification for the General Terms and Relationship Supplement Elections as provided in the 2018 ISDA CDM Equity Confirmation for Security Equity Swap.
 * @version ${project.version}
 */
@RosettaClass

public interface EquitySwapMasterConfirmation2018 extends EquityMasterConfirmation {
	EquitySwapMasterConfirmation2018 build();
	EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder toBuilder();
	
	/**
	 * The parameters used to generate the &#39;Equity Valuation Dates&#39; schedule, including the Effective Date and Termination Date for the Swap.
	 */
	CalculationPeriodDates getEquityCalculationPeriod();
	/**
	 * The parameters used to generate the payment date schedule, relative to the equityCalculationPeriod. Part 1 Section 12, &#39;Definitions&#39;, of the 2018 ISDA CDM Equity Confirmation. Para 73: &#39;Equity Cash Settlement Date&#39; means each date falling one Settlement Cycle after an Equity Valuation Date; provided that if any such date is not a Settlement Currency Business Day, then such date shall be adjusted per Following Day Adjustment.
	 */
	PaymentDates getEquityCashSettlementDates();
	/**
	 * Part 1 Section 3, &#39;Floating Obligations&#39;, of the 2018 ISDA CDM Equity Confirmation. Para 3.3, &#39;Linear Interpolation&#39;: If the initial Calculation Period is not equal to the Designated Maturity, then the Linear Interpolation Election shall be as specified in the Relationship Supplement, unless otherwise specified in the Transaction Supplement.
	 */
	InterpolationMethodEnum getLinearInterpolationElection();
	/**
	 * Part 1 Section 5, &#39;Pricing&#39;, of the 2018 ISDA CDM Equity Confirmation, Para 5.1, &#39;Determining Prices&#39;: Each price in relation to a Pricing Date shall be determined pursuant to the specified Pricing Method. The relevant price specified under the column header &#39;Price&#39; for a corresponding Pricing Date specified under the column header &#39;Pricing Date&#39; shall be determined using the corresponding method specified under the column header &#39;Pricing Method&#39;. Pricing Method for the final Equity Valuation Date shall be specified by the Final EVD Pricing Election and Pricing Method for any other Equity Valaution Date shall be &#39;Securities Close Pricing (Official)&#39;
	 */
	PriceReturnTerms getPricingMethodElection();
	/**
	 * Part 1 Section 8, &#39;Settlement&#39;, of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap. All Settlements are in Cash.
	 */
	SettlementTerms getSettlementTerms();
	/**
	 * Part 1 Section 4, &#39;Dividend Obligations&#39;, of the 2018 ISDA CDM Equity Confirmation, Para 4.2 &#39;Dividend Returns&#39;: The Type Of Swap Election shall be &#39;Total Return&#39;, unless otherwise specified (as alternative &#39;Price Return&#39;) in the Transaction Supplement.
	 */
	ReturnTypeEnum getTypeOfSwapElection();
	final static EquitySwapMasterConfirmation2018Meta metaData = new EquitySwapMasterConfirmation2018Meta();
	
	@Override
	default RosettaMetaData<? extends EquitySwapMasterConfirmation2018> metaData() {
		return metaData;
	} 
			
	static EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder builder() {
		return new EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018BuilderImpl();
	}
	
	default Class<? extends EquitySwapMasterConfirmation2018> getType() {
		return EquitySwapMasterConfirmation2018.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.legalagreement.master.EquityMasterConfirmation.super.process(path, processor);
		processor.processBasic(path.newSubPath("linearInterpolationElection"), InterpolationMethodEnum.class, getLinearInterpolationElection(), this);
		processor.processBasic(path.newSubPath("typeOfSwapElection"), ReturnTypeEnum.class, getTypeOfSwapElection(), this);
		
		processRosetta(path.newSubPath("equityCalculationPeriod"), processor, CalculationPeriodDates.class, getEquityCalculationPeriod());
		processRosetta(path.newSubPath("equityCashSettlementDates"), processor, PaymentDates.class, getEquityCashSettlementDates());
		processRosetta(path.newSubPath("pricingMethodElection"), processor, PriceReturnTerms.class, getPricingMethodElection());
		processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.class, getSettlementTerms());
	}
	
	
	interface EquitySwapMasterConfirmation2018Builder extends EquitySwapMasterConfirmation2018, EquityMasterConfirmation.EquityMasterConfirmationBuilder, RosettaModelObjectBuilder {
		CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateEquityCalculationPeriod();
		CalculationPeriodDates.CalculationPeriodDatesBuilder getEquityCalculationPeriod();
		PaymentDates.PaymentDatesBuilder getOrCreateEquityCashSettlementDates();
		PaymentDates.PaymentDatesBuilder getEquityCashSettlementDates();
		PriceReturnTerms.PriceReturnTermsBuilder getOrCreatePricingMethodElection();
		PriceReturnTerms.PriceReturnTermsBuilder getPricingMethodElection();
		SettlementTerms.SettlementTermsBuilder getOrCreateSettlementTerms();
		SettlementTerms.SettlementTermsBuilder getSettlementTerms();
		EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setEquityCalculationPeriod(CalculationPeriodDates equityCalculationPeriod);
		EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setEquityCashSettlementDates(PaymentDates equityCashSettlementDates);
		EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setLinearInterpolationElection(InterpolationMethodEnum linearInterpolationElection);
		EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setPricingMethodElection(PriceReturnTerms pricingMethodElection);
		EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setSettlementTerms(SettlementTerms settlementTerms);
		EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setTypeOfSwapElection(ReturnTypeEnum typeOfSwapElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			EquityMasterConfirmation.EquityMasterConfirmationBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("linearInterpolationElection"), InterpolationMethodEnum.class, getLinearInterpolationElection(), this);
			processor.processBasic(path.newSubPath("typeOfSwapElection"), ReturnTypeEnum.class, getTypeOfSwapElection(), this);
			
			processRosetta(path.newSubPath("equityCalculationPeriod"), processor, CalculationPeriodDates.CalculationPeriodDatesBuilder.class, getEquityCalculationPeriod());
			processRosetta(path.newSubPath("equityCashSettlementDates"), processor, PaymentDates.PaymentDatesBuilder.class, getEquityCashSettlementDates());
			processRosetta(path.newSubPath("pricingMethodElection"), processor, PriceReturnTerms.PriceReturnTermsBuilder.class, getPricingMethodElection());
			processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.SettlementTermsBuilder.class, getSettlementTerms());
		}
		
	}
	
	//EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Impl
	class EquitySwapMasterConfirmation2018Impl extends EquityMasterConfirmation.EquityMasterConfirmationImpl implements EquitySwapMasterConfirmation2018 {
		private final CalculationPeriodDates equityCalculationPeriod;
		private final PaymentDates equityCashSettlementDates;
		private final InterpolationMethodEnum linearInterpolationElection;
		private final PriceReturnTerms pricingMethodElection;
		private final SettlementTerms settlementTerms;
		private final ReturnTypeEnum typeOfSwapElection;
		
		protected EquitySwapMasterConfirmation2018Impl(EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder builder) {
			super(builder);
			this.equityCalculationPeriod = ofNullable(builder.getEquityCalculationPeriod()).map(f->f.build()).orElse(null);
			this.equityCashSettlementDates = ofNullable(builder.getEquityCashSettlementDates()).map(f->f.build()).orElse(null);
			this.linearInterpolationElection = builder.getLinearInterpolationElection();
			this.pricingMethodElection = ofNullable(builder.getPricingMethodElection()).map(f->f.build()).orElse(null);
			this.settlementTerms = ofNullable(builder.getSettlementTerms()).map(f->f.build()).orElse(null);
			this.typeOfSwapElection = builder.getTypeOfSwapElection();
		}
		
		@Override
		public CalculationPeriodDates getEquityCalculationPeriod() {
			return equityCalculationPeriod;
		}
		
		@Override
		public PaymentDates getEquityCashSettlementDates() {
			return equityCashSettlementDates;
		}
		
		@Override
		public InterpolationMethodEnum getLinearInterpolationElection() {
			return linearInterpolationElection;
		}
		
		@Override
		public PriceReturnTerms getPricingMethodElection() {
			return pricingMethodElection;
		}
		
		@Override
		public SettlementTerms getSettlementTerms() {
			return settlementTerms;
		}
		
		@Override
		public ReturnTypeEnum getTypeOfSwapElection() {
			return typeOfSwapElection;
		}
		
		@Override
		public EquitySwapMasterConfirmation2018 build() {
			return this;
		}
		
		@Override
		public EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder toBuilder() {
			EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEquityCalculationPeriod()).ifPresent(builder::setEquityCalculationPeriod);
			ofNullable(getEquityCashSettlementDates()).ifPresent(builder::setEquityCashSettlementDates);
			ofNullable(getLinearInterpolationElection()).ifPresent(builder::setLinearInterpolationElection);
			ofNullable(getPricingMethodElection()).ifPresent(builder::setPricingMethodElection);
			ofNullable(getSettlementTerms()).ifPresent(builder::setSettlementTerms);
			ofNullable(getTypeOfSwapElection()).ifPresent(builder::setTypeOfSwapElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquitySwapMasterConfirmation2018 _that = getType().cast(o);
		
			if (!Objects.equals(equityCalculationPeriod, _that.getEquityCalculationPeriod())) return false;
			if (!Objects.equals(equityCashSettlementDates, _that.getEquityCashSettlementDates())) return false;
			if (!Objects.equals(linearInterpolationElection, _that.getLinearInterpolationElection())) return false;
			if (!Objects.equals(pricingMethodElection, _that.getPricingMethodElection())) return false;
			if (!Objects.equals(settlementTerms, _that.getSettlementTerms())) return false;
			if (!Objects.equals(typeOfSwapElection, _that.getTypeOfSwapElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (equityCalculationPeriod != null ? equityCalculationPeriod.hashCode() : 0);
			_result = 31 * _result + (equityCashSettlementDates != null ? equityCashSettlementDates.hashCode() : 0);
			_result = 31 * _result + (linearInterpolationElection != null ? linearInterpolationElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricingMethodElection != null ? pricingMethodElection.hashCode() : 0);
			_result = 31 * _result + (settlementTerms != null ? settlementTerms.hashCode() : 0);
			_result = 31 * _result + (typeOfSwapElection != null ? typeOfSwapElection.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquitySwapMasterConfirmation2018 {" +
				"equityCalculationPeriod=" + this.equityCalculationPeriod + ", " +
				"equityCashSettlementDates=" + this.equityCashSettlementDates + ", " +
				"linearInterpolationElection=" + this.linearInterpolationElection + ", " +
				"pricingMethodElection=" + this.pricingMethodElection + ", " +
				"settlementTerms=" + this.settlementTerms + ", " +
				"typeOfSwapElection=" + this.typeOfSwapElection +
			'}' + " " + super.toString();
		}
	}
	
	//EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018BuilderImpl
	class EquitySwapMasterConfirmation2018BuilderImpl extends EquityMasterConfirmation.EquityMasterConfirmationBuilderImpl  implements EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder {
	
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder equityCalculationPeriod;
		protected PaymentDates.PaymentDatesBuilder equityCashSettlementDates;
		protected InterpolationMethodEnum linearInterpolationElection;
		protected PriceReturnTerms.PriceReturnTermsBuilder pricingMethodElection;
		protected SettlementTerms.SettlementTermsBuilder settlementTerms;
		protected ReturnTypeEnum typeOfSwapElection;
	
		public EquitySwapMasterConfirmation2018BuilderImpl() {
		}
	
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getEquityCalculationPeriod() {
			return equityCalculationPeriod;
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateEquityCalculationPeriod() {
			CalculationPeriodDates.CalculationPeriodDatesBuilder result;
			if (equityCalculationPeriod!=null) {
				result = equityCalculationPeriod;
			}
			else {
				result = equityCalculationPeriod = CalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder getEquityCashSettlementDates() {
			return equityCashSettlementDates;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder getOrCreateEquityCashSettlementDates() {
			PaymentDates.PaymentDatesBuilder result;
			if (equityCashSettlementDates!=null) {
				result = equityCashSettlementDates;
			}
			else {
				result = equityCashSettlementDates = PaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		public InterpolationMethodEnum getLinearInterpolationElection() {
			return linearInterpolationElection;
		}
		
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder getPricingMethodElection() {
			return pricingMethodElection;
		}
		
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder getOrCreatePricingMethodElection() {
			PriceReturnTerms.PriceReturnTermsBuilder result;
			if (pricingMethodElection!=null) {
				result = pricingMethodElection;
			}
			else {
				result = pricingMethodElection = PriceReturnTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder getSettlementTerms() {
			return settlementTerms;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder getOrCreateSettlementTerms() {
			SettlementTerms.SettlementTermsBuilder result;
			if (settlementTerms!=null) {
				result = settlementTerms;
			}
			else {
				result = settlementTerms = SettlementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public ReturnTypeEnum getTypeOfSwapElection() {
			return typeOfSwapElection;
		}
		
	
		@Override
		public EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setEquityCalculationPeriod(CalculationPeriodDates equityCalculationPeriod) {
			this.equityCalculationPeriod = equityCalculationPeriod==null?null:equityCalculationPeriod.toBuilder();
			return this;
		}
		@Override
		public EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setEquityCashSettlementDates(PaymentDates equityCashSettlementDates) {
			this.equityCashSettlementDates = equityCashSettlementDates==null?null:equityCashSettlementDates.toBuilder();
			return this;
		}
		@Override
		public EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setLinearInterpolationElection(InterpolationMethodEnum linearInterpolationElection) {
			this.linearInterpolationElection = linearInterpolationElection==null?null:linearInterpolationElection;
			return this;
		}
		@Override
		public EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setPricingMethodElection(PriceReturnTerms pricingMethodElection) {
			this.pricingMethodElection = pricingMethodElection==null?null:pricingMethodElection.toBuilder();
			return this;
		}
		@Override
		public EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		@Override
		public EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder setTypeOfSwapElection(ReturnTypeEnum typeOfSwapElection) {
			this.typeOfSwapElection = typeOfSwapElection==null?null:typeOfSwapElection;
			return this;
		}
		
		@Override
		public EquitySwapMasterConfirmation2018 build() {
			return new EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Impl(this);
		}
		
		@Override
		public EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder prune() {
			super.prune();
			if (equityCalculationPeriod!=null && !equityCalculationPeriod.prune().hasData()) equityCalculationPeriod = null;
			if (equityCashSettlementDates!=null && !equityCashSettlementDates.prune().hasData()) equityCashSettlementDates = null;
			if (pricingMethodElection!=null && !pricingMethodElection.prune().hasData()) pricingMethodElection = null;
			if (settlementTerms!=null && !settlementTerms.prune().hasData()) settlementTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEquityCalculationPeriod()!=null && getEquityCalculationPeriod().hasData()) return true;
			if (getEquityCashSettlementDates()!=null && getEquityCashSettlementDates().hasData()) return true;
			if (getLinearInterpolationElection()!=null) return true;
			if (getPricingMethodElection()!=null && getPricingMethodElection().hasData()) return true;
			if (getSettlementTerms()!=null && getSettlementTerms().hasData()) return true;
			if (getTypeOfSwapElection()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder o = (EquitySwapMasterConfirmation2018.EquitySwapMasterConfirmation2018Builder) other;
			
			merger.mergeRosetta(getEquityCalculationPeriod(), o.getEquityCalculationPeriod(), this::setEquityCalculationPeriod);
			merger.mergeRosetta(getEquityCashSettlementDates(), o.getEquityCashSettlementDates(), this::setEquityCashSettlementDates);
			merger.mergeRosetta(getPricingMethodElection(), o.getPricingMethodElection(), this::setPricingMethodElection);
			merger.mergeRosetta(getSettlementTerms(), o.getSettlementTerms(), this::setSettlementTerms);
			
			merger.mergeBasic(getLinearInterpolationElection(), o.getLinearInterpolationElection(), this::setLinearInterpolationElection);
			merger.mergeBasic(getTypeOfSwapElection(), o.getTypeOfSwapElection(), this::setTypeOfSwapElection);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquitySwapMasterConfirmation2018 _that = getType().cast(o);
		
			if (!Objects.equals(equityCalculationPeriod, _that.getEquityCalculationPeriod())) return false;
			if (!Objects.equals(equityCashSettlementDates, _that.getEquityCashSettlementDates())) return false;
			if (!Objects.equals(linearInterpolationElection, _that.getLinearInterpolationElection())) return false;
			if (!Objects.equals(pricingMethodElection, _that.getPricingMethodElection())) return false;
			if (!Objects.equals(settlementTerms, _that.getSettlementTerms())) return false;
			if (!Objects.equals(typeOfSwapElection, _that.getTypeOfSwapElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (equityCalculationPeriod != null ? equityCalculationPeriod.hashCode() : 0);
			_result = 31 * _result + (equityCashSettlementDates != null ? equityCashSettlementDates.hashCode() : 0);
			_result = 31 * _result + (linearInterpolationElection != null ? linearInterpolationElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricingMethodElection != null ? pricingMethodElection.hashCode() : 0);
			_result = 31 * _result + (settlementTerms != null ? settlementTerms.hashCode() : 0);
			_result = 31 * _result + (typeOfSwapElection != null ? typeOfSwapElection.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquitySwapMasterConfirmation2018Builder {" +
				"equityCalculationPeriod=" + this.equityCalculationPeriod + ", " +
				"equityCashSettlementDates=" + this.equityCashSettlementDates + ", " +
				"linearInterpolationElection=" + this.linearInterpolationElection + ", " +
				"pricingMethodElection=" + this.pricingMethodElection + ", " +
				"settlementTerms=" + this.settlementTerms + ", " +
				"typeOfSwapElection=" + this.typeOfSwapElection +
			'}' + " " + super.toString();
		}
	}
}
