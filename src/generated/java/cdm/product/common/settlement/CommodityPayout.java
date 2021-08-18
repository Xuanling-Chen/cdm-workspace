package cdm.product.common.settlement;

import cdm.base.math.AveragingMethodEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.settlement.ObservationPayout.ObservationPayoutBuilder;
import cdm.product.common.settlement.ObservationPayout.ObservationPayoutBuilderImpl;
import cdm.product.common.settlement.ObservationPayout.ObservationPayoutImpl;
import cdm.product.common.settlement.meta.CommodityPayoutMeta;
import cdm.product.template.FxFeature;
import cdm.product.template.Product;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Payout based on the averaged price of a referenced underlier. (e.g. Commodities). Can represent both average (average of many) &amp; bullet (average of 1) pricing
 * @version ${project.version}
 */
@RosettaClass

public interface CommodityPayout extends ObservationPayout {
	CommodityPayout build();
	CommodityPayout.CommodityPayoutBuilder toBuilder();
	
	/**
	 * Indicates if the averaging calculation, when applicable, is weighted or unweighted.
	 */
	AveragingMethodEnum getAveragingMethod();
	/**
	 * Defines parameters in which the commodity price is assessed.
	 */
	CommodityPriceReturnTerms getCommodityPriceReturnTerms();
	/**
	 * Specifies specific dates or parametric rules for the dates on which the price will be determined.
	 */
	PricingDates getPricingDates();
	final static CommodityPayoutMeta metaData = new CommodityPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends CommodityPayout> metaData() {
		return metaData;
	} 
			
	static CommodityPayout.CommodityPayoutBuilder builder() {
		return new CommodityPayout.CommodityPayoutBuilderImpl();
	}
	
	default Class<? extends CommodityPayout> getType() {
		return CommodityPayout.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.common.settlement.ObservationPayout.super.process(path, processor);
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		
		processRosetta(path.newSubPath("commodityPriceReturnTerms"), processor, CommodityPriceReturnTerms.class, getCommodityPriceReturnTerms());
		processRosetta(path.newSubPath("pricingDates"), processor, PricingDates.class, getPricingDates());
	}
	
	
	interface CommodityPayoutBuilder extends CommodityPayout, ObservationPayout.ObservationPayoutBuilder, RosettaModelObjectBuilder {
		CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder getOrCreateCommodityPriceReturnTerms();
		CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder getCommodityPriceReturnTerms();
		PricingDates.PricingDatesBuilder getOrCreatePricingDates();
		PricingDates.PricingDatesBuilder getPricingDates();
		CommodityPayout.CommodityPayoutBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		CommodityPayout.CommodityPayoutBuilder setCommodityPriceReturnTerms(CommodityPriceReturnTerms commodityPriceReturnTerms);
		CommodityPayout.CommodityPayoutBuilder setPricingDates(PricingDates pricingDates);
		CommodityPayout.CommodityPayoutBuilder addCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates);
		CommodityPayout.CommodityPayoutBuilder addCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates, int _idx);
		CommodityPayout.CommodityPayoutBuilder addCalculationPeriodDates(List<? extends CalculationPeriodDates> calculationPeriodDates);
		CommodityPayout.CommodityPayoutBuilder setCalculationPeriodDates(List<? extends CalculationPeriodDates> calculationPeriodDates);
		CommodityPayout.CommodityPayoutBuilder setFxFeature(FxFeature fxFeature);
		CommodityPayout.CommodityPayoutBuilder setPaymentDates(PaymentDates paymentDates);
		CommodityPayout.CommodityPayoutBuilder setUnderlier(Product underlier);
		CommodityPayout.CommodityPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		CommodityPayout.CommodityPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity);
		CommodityPayout.CommodityPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			ObservationPayout.ObservationPayoutBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			
			processRosetta(path.newSubPath("commodityPriceReturnTerms"), processor, CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder.class, getCommodityPriceReturnTerms());
			processRosetta(path.newSubPath("pricingDates"), processor, PricingDates.PricingDatesBuilder.class, getPricingDates());
		}
		
	}
	
	//CommodityPayout.CommodityPayoutImpl
	class CommodityPayoutImpl extends ObservationPayout.ObservationPayoutImpl implements CommodityPayout {
		private final AveragingMethodEnum averagingMethod;
		private final CommodityPriceReturnTerms commodityPriceReturnTerms;
		private final PricingDates pricingDates;
		
		protected CommodityPayoutImpl(CommodityPayout.CommodityPayoutBuilder builder) {
			super(builder);
			this.averagingMethod = builder.getAveragingMethod();
			this.commodityPriceReturnTerms = ofNullable(builder.getCommodityPriceReturnTerms()).map(f->f.build()).orElse(null);
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		public CommodityPriceReturnTerms getCommodityPriceReturnTerms() {
			return commodityPriceReturnTerms;
		}
		
		@Override
		public PricingDates getPricingDates() {
			return pricingDates;
		}
		
		@Override
		public CommodityPayout build() {
			return this;
		}
		
		@Override
		public CommodityPayout.CommodityPayoutBuilder toBuilder() {
			CommodityPayout.CommodityPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPayout.CommodityPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getCommodityPriceReturnTerms()).ifPresent(builder::setCommodityPriceReturnTerms);
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPayout _that = getType().cast(o);
		
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(commodityPriceReturnTerms, _that.getCommodityPriceReturnTerms())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodityPriceReturnTerms != null ? commodityPriceReturnTerms.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPayout {" +
				"averagingMethod=" + this.averagingMethod + ", " +
				"commodityPriceReturnTerms=" + this.commodityPriceReturnTerms + ", " +
				"pricingDates=" + this.pricingDates +
			'}' + " " + super.toString();
		}
	}
	
	//CommodityPayout.CommodityPayoutBuilderImpl
	class CommodityPayoutBuilderImpl extends ObservationPayout.ObservationPayoutBuilderImpl  implements CommodityPayout.CommodityPayoutBuilder {
	
		protected AveragingMethodEnum averagingMethod;
		protected CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder commodityPriceReturnTerms;
		protected PricingDates.PricingDatesBuilder pricingDates;
	
		public CommodityPayoutBuilderImpl() {
		}
	
		@Override
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder getCommodityPriceReturnTerms() {
			return commodityPriceReturnTerms;
		}
		
		@Override
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder getOrCreateCommodityPriceReturnTerms() {
			CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder result;
			if (commodityPriceReturnTerms!=null) {
				result = commodityPriceReturnTerms;
			}
			else {
				result = commodityPriceReturnTerms = CommodityPriceReturnTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public PricingDates.PricingDatesBuilder getPricingDates() {
			return pricingDates;
		}
		
		@Override
		public PricingDates.PricingDatesBuilder getOrCreatePricingDates() {
			PricingDates.PricingDatesBuilder result;
			if (pricingDates!=null) {
				result = pricingDates;
			}
			else {
				result = pricingDates = PricingDates.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CommodityPayout.CommodityPayoutBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		public CommodityPayout.CommodityPayoutBuilder setCommodityPriceReturnTerms(CommodityPriceReturnTerms commodityPriceReturnTerms) {
			this.commodityPriceReturnTerms = commodityPriceReturnTerms==null?null:commodityPriceReturnTerms.toBuilder();
			return this;
		}
		@Override
		public CommodityPayout.CommodityPayoutBuilder setPricingDates(PricingDates pricingDates) {
			this.pricingDates = pricingDates==null?null:pricingDates.toBuilder();
			return this;
		}
		@Override
		public CommodityPayout.CommodityPayoutBuilder addCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates) {
			if (calculationPeriodDates!=null) this.calculationPeriodDates.add(calculationPeriodDates.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPayout.CommodityPayoutBuilder addCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates, int _idx) {
			getIndex(this.calculationPeriodDates, _idx, () -> calculationPeriodDates.toBuilder());
			return this;
		}
		@Override 
		public CommodityPayout.CommodityPayoutBuilder addCalculationPeriodDates(List<? extends CalculationPeriodDates> calculationPeriodDatess) {
			if (calculationPeriodDatess != null) {
				for (CalculationPeriodDates toAdd : calculationPeriodDatess) {
					this.calculationPeriodDates.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityPayout.CommodityPayoutBuilder setCalculationPeriodDates(List<? extends CalculationPeriodDates> calculationPeriodDatess) {
			if (calculationPeriodDatess == null)  {
				this.calculationPeriodDates = new ArrayList<>();
			}
			else {
				this.calculationPeriodDates = calculationPeriodDatess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommodityPayout.CommodityPayoutBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		@Override
		public CommodityPayout.CommodityPayoutBuilder setPaymentDates(PaymentDates paymentDates) {
			this.paymentDates = paymentDates==null?null:paymentDates.toBuilder();
			return this;
		}
		@Override
		public CommodityPayout.CommodityPayoutBuilder setUnderlier(Product underlier) {
			this.underlier = underlier==null?null:underlier.toBuilder();
			return this;
		}
		@Override
		public CommodityPayout.CommodityPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public CommodityPayout.CommodityPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity) {
			this.payoutQuantity = payoutQuantity==null?null:payoutQuantity.toBuilder();
			return this;
		}
		@Override
		public CommodityPayout.CommodityPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPayout build() {
			return new CommodityPayout.CommodityPayoutImpl(this);
		}
		
		@Override
		public CommodityPayout.CommodityPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPayout.CommodityPayoutBuilder prune() {
			super.prune();
			if (commodityPriceReturnTerms!=null && !commodityPriceReturnTerms.prune().hasData()) commodityPriceReturnTerms = null;
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getCommodityPriceReturnTerms()!=null && getCommodityPriceReturnTerms().hasData()) return true;
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPayout.CommodityPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityPayout.CommodityPayoutBuilder o = (CommodityPayout.CommodityPayoutBuilder) other;
			
			merger.mergeRosetta(getCommodityPriceReturnTerms(), o.getCommodityPriceReturnTerms(), this::setCommodityPriceReturnTerms);
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPayout _that = getType().cast(o);
		
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(commodityPriceReturnTerms, _that.getCommodityPriceReturnTerms())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodityPriceReturnTerms != null ? commodityPriceReturnTerms.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPayoutBuilder {" +
				"averagingMethod=" + this.averagingMethod + ", " +
				"commodityPriceReturnTerms=" + this.commodityPriceReturnTerms + ", " +
				"pricingDates=" + this.pricingDates +
			'}' + " " + super.toString();
		}
	}
}
