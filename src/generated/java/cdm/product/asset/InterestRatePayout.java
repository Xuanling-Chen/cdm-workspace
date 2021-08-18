package cdm.product.asset;

import cdm.base.datetime.AdjustableDate;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.asset.meta.InterestRatePayoutMeta;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.schedule.ResetDates;
import cdm.product.common.schedule.StubPeriod;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.PrincipalExchanges;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import cdm.product.common.settlement.SettlementTerms;
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
 *  A class to specify all of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg). The associated globalKey denotes the ability to associate a hash value to the InterestRatePayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version ${project.version}
 */
@RosettaClass

public interface InterestRatePayout extends PayoutBase, GlobalKey {
	InterestRatePayout build();
	InterestRatePayout.InterestRatePayoutBuilder toBuilder();
	
	/**
	 * Reference to a bond underlier to represent an asset swap or Condition Precedent Bond.
	 */
	BondReference getBondReference();
	/**
	 * The parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods.
	 */
	CalculationPeriodDates getCalculationPeriodDates();
	/**
	 * The cashflow representation of the swap stream.
	 */
	CashflowRepresentation getCashflowRepresentation();
	/**
	 * If one or more calculation period contributes to a single payment amount this element specifies whether compounding is applicable and, if so, what compounding method is to be used. This element must only be included when more than one calculation period contributes to a single payment amount.
	 */
	CompoundingMethodEnum getCompoundingMethod();
	/**
	 * The day count fraction. The cardinality has been relaxed when compared with the FpML interest rate swap for the purpose of accommodating standardized credit default swaps which DCF is not explicitly stated as part of the economic terms. The data rule InterestRatePayout_dayCountFraction requires that the DCF be stated for interest rate products.
	 */
	FieldWithMetaDayCountFractionEnum getDayCountFraction();
	/**
	 * The parameters specifying any discounting conventions that may apply. This element must only be included if discounting applies.
	 */
	DiscountingMethod getDiscountingMethod();
	/**
	 * Fixed Amount Calculation
	 */
	String getFixedAmount();
	/**
	 * Floating Amount Calculation
	 */
	String getFloatingAmount();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The payment date, where only one date is specified, as for the FRA product.
	 */
	AdjustableDate getPaymentDate();
	/**
	 * The payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the reset dates).
	 */
	PaymentDates getPaymentDates();
	/**
	 * Applicable to CDS on MBS to specify whether payment delays are applicable to the fixed Amount. RMBS typically have a payment delay of 5 days between the coupon date of the reference obligation and the payment date of the synthetic swap. CMBS do not, on the other hand, with both payment dates being on the 25th of each month.
	 */
	Boolean getPaymentDelay();
	/**
	 * The specification of the principal exchange. Optional as only applicable in the case of cross-currency.
	 */
	PrincipalExchanges getPrincipalExchanges();
	/**
	 * The specification of the rate value(s) applicable to the contract using either a floating rate calculation, a single fixed rate, a fixed rate schedule, or an inflation rate calculation.
	 */
	RateSpecification getRateSpecification();
	/**
	 * The reset dates schedule, i.e. the dates on which the new observed index value is applied for each period and the interest rate hence begins to accrue.
	 */
	ResetDates getResetDates();
	/**
	 * The stub calculation period amount parameters. This element must only be included if there is an initial or final stub calculation period. Even then, it must only be included if either the stub references a different floating rate tenor to the regular calculation periods, or if the stub is calculated as a linear interpolation of two different floating rate tenors, or if a specific stub rate or stub amount has been negotiated.
	 */
	StubPeriod getStubPeriod();
	final static InterestRatePayoutMeta metaData = new InterestRatePayoutMeta();
	
	@Override
	default RosettaMetaData<? extends InterestRatePayout> metaData() {
		return metaData;
	} 
			
	static InterestRatePayout.InterestRatePayoutBuilder builder() {
		return new InterestRatePayout.InterestRatePayoutBuilderImpl();
	}
	
	default Class<? extends InterestRatePayout> getType() {
		return InterestRatePayout.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.common.settlement.PayoutBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
		processor.processBasic(path.newSubPath("fixedAmount"), String.class, getFixedAmount(), this);
		processor.processBasic(path.newSubPath("floatingAmount"), String.class, getFloatingAmount(), this);
		processor.processBasic(path.newSubPath("paymentDelay"), Boolean.class, getPaymentDelay(), this);
		
		processRosetta(path.newSubPath("bondReference"), processor, BondReference.class, getBondReference());
		processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.class, getCalculationPeriodDates());
		processRosetta(path.newSubPath("cashflowRepresentation"), processor, CashflowRepresentation.class, getCashflowRepresentation());
		processRosetta(path.newSubPath("dayCountFraction"), processor, FieldWithMetaDayCountFractionEnum.class, getDayCountFraction());
		processRosetta(path.newSubPath("discountingMethod"), processor, DiscountingMethod.class, getDiscountingMethod());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.class, getPaymentDates());
		processRosetta(path.newSubPath("principalExchanges"), processor, PrincipalExchanges.class, getPrincipalExchanges());
		processRosetta(path.newSubPath("rateSpecification"), processor, RateSpecification.class, getRateSpecification());
		processRosetta(path.newSubPath("resetDates"), processor, ResetDates.class, getResetDates());
		processRosetta(path.newSubPath("stubPeriod"), processor, StubPeriod.class, getStubPeriod());
	}
	
	
	interface InterestRatePayoutBuilder extends InterestRatePayout, PayoutBase.PayoutBaseBuilder, RosettaModelObjectBuilder {
		BondReference.BondReferenceBuilder getOrCreateBondReference();
		BondReference.BondReferenceBuilder getBondReference();
		CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates();
		CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates();
		CashflowRepresentation.CashflowRepresentationBuilder getOrCreateCashflowRepresentation();
		CashflowRepresentation.CashflowRepresentationBuilder getCashflowRepresentation();
		FieldWithMetaDayCountFractionEnumBuilder getOrCreateDayCountFraction();
		FieldWithMetaDayCountFractionEnumBuilder getDayCountFraction();
		DiscountingMethod.DiscountingMethodBuilder getOrCreateDiscountingMethod();
		DiscountingMethod.DiscountingMethodBuilder getDiscountingMethod();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		AdjustableDate.AdjustableDateBuilder getOrCreatePaymentDate();
		AdjustableDate.AdjustableDateBuilder getPaymentDate();
		PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates();
		PaymentDates.PaymentDatesBuilder getPaymentDates();
		PrincipalExchanges.PrincipalExchangesBuilder getOrCreatePrincipalExchanges();
		PrincipalExchanges.PrincipalExchangesBuilder getPrincipalExchanges();
		RateSpecification.RateSpecificationBuilder getOrCreateRateSpecification();
		RateSpecification.RateSpecificationBuilder getRateSpecification();
		ResetDates.ResetDatesBuilder getOrCreateResetDates();
		ResetDates.ResetDatesBuilder getResetDates();
		StubPeriod.StubPeriodBuilder getOrCreateStubPeriod();
		StubPeriod.StubPeriodBuilder getStubPeriod();
		InterestRatePayout.InterestRatePayoutBuilder setBondReference(BondReference bondReference);
		InterestRatePayout.InterestRatePayoutBuilder setCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates);
		InterestRatePayout.InterestRatePayoutBuilder setCashflowRepresentation(CashflowRepresentation cashflowRepresentation);
		InterestRatePayout.InterestRatePayoutBuilder setCompoundingMethod(CompoundingMethodEnum compoundingMethod);
		InterestRatePayout.InterestRatePayoutBuilder setDayCountFraction(FieldWithMetaDayCountFractionEnum dayCountFraction);
		InterestRatePayout.InterestRatePayoutBuilder setDayCountFractionValue(DayCountFractionEnum dayCountFraction);
		InterestRatePayout.InterestRatePayoutBuilder setDiscountingMethod(DiscountingMethod discountingMethod);
		InterestRatePayout.InterestRatePayoutBuilder setFixedAmount(String fixedAmount);
		InterestRatePayout.InterestRatePayoutBuilder setFloatingAmount(String floatingAmount);
		InterestRatePayout.InterestRatePayoutBuilder setMeta(MetaFields meta);
		InterestRatePayout.InterestRatePayoutBuilder setPaymentDate(AdjustableDate paymentDate);
		InterestRatePayout.InterestRatePayoutBuilder setPaymentDates(PaymentDates paymentDates);
		InterestRatePayout.InterestRatePayoutBuilder setPaymentDelay(Boolean paymentDelay);
		InterestRatePayout.InterestRatePayoutBuilder setPrincipalExchanges(PrincipalExchanges principalExchanges);
		InterestRatePayout.InterestRatePayoutBuilder setRateSpecification(RateSpecification rateSpecification);
		InterestRatePayout.InterestRatePayoutBuilder setResetDates(ResetDates resetDates);
		InterestRatePayout.InterestRatePayoutBuilder setStubPeriod(StubPeriod stubPeriod);
		InterestRatePayout.InterestRatePayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		InterestRatePayout.InterestRatePayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity);
		InterestRatePayout.InterestRatePayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PayoutBase.PayoutBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
			processor.processBasic(path.newSubPath("fixedAmount"), String.class, getFixedAmount(), this);
			processor.processBasic(path.newSubPath("floatingAmount"), String.class, getFloatingAmount(), this);
			processor.processBasic(path.newSubPath("paymentDelay"), Boolean.class, getPaymentDelay(), this);
			
			processRosetta(path.newSubPath("bondReference"), processor, BondReference.BondReferenceBuilder.class, getBondReference());
			processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.CalculationPeriodDatesBuilder.class, getCalculationPeriodDates());
			processRosetta(path.newSubPath("cashflowRepresentation"), processor, CashflowRepresentation.CashflowRepresentationBuilder.class, getCashflowRepresentation());
			processRosetta(path.newSubPath("dayCountFraction"), processor, FieldWithMetaDayCountFractionEnumBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("discountingMethod"), processor, DiscountingMethod.DiscountingMethodBuilder.class, getDiscountingMethod());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.PaymentDatesBuilder.class, getPaymentDates());
			processRosetta(path.newSubPath("principalExchanges"), processor, PrincipalExchanges.PrincipalExchangesBuilder.class, getPrincipalExchanges());
			processRosetta(path.newSubPath("rateSpecification"), processor, RateSpecification.RateSpecificationBuilder.class, getRateSpecification());
			processRosetta(path.newSubPath("resetDates"), processor, ResetDates.ResetDatesBuilder.class, getResetDates());
			processRosetta(path.newSubPath("stubPeriod"), processor, StubPeriod.StubPeriodBuilder.class, getStubPeriod());
		}
		
	}
	
	//InterestRatePayout.InterestRatePayoutImpl
	class InterestRatePayoutImpl extends PayoutBase.PayoutBaseImpl implements InterestRatePayout {
		private final BondReference bondReference;
		private final CalculationPeriodDates calculationPeriodDates;
		private final CashflowRepresentation cashflowRepresentation;
		private final CompoundingMethodEnum compoundingMethod;
		private final FieldWithMetaDayCountFractionEnum dayCountFraction;
		private final DiscountingMethod discountingMethod;
		private final String fixedAmount;
		private final String floatingAmount;
		private final MetaFields meta;
		private final AdjustableDate paymentDate;
		private final PaymentDates paymentDates;
		private final Boolean paymentDelay;
		private final PrincipalExchanges principalExchanges;
		private final RateSpecification rateSpecification;
		private final ResetDates resetDates;
		private final StubPeriod stubPeriod;
		
		protected InterestRatePayoutImpl(InterestRatePayout.InterestRatePayoutBuilder builder) {
			super(builder);
			this.bondReference = ofNullable(builder.getBondReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodDates = ofNullable(builder.getCalculationPeriodDates()).map(f->f.build()).orElse(null);
			this.cashflowRepresentation = ofNullable(builder.getCashflowRepresentation()).map(f->f.build()).orElse(null);
			this.compoundingMethod = builder.getCompoundingMethod();
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.discountingMethod = ofNullable(builder.getDiscountingMethod()).map(f->f.build()).orElse(null);
			this.fixedAmount = builder.getFixedAmount();
			this.floatingAmount = builder.getFloatingAmount();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.paymentDelay = builder.getPaymentDelay();
			this.principalExchanges = ofNullable(builder.getPrincipalExchanges()).map(f->f.build()).orElse(null);
			this.rateSpecification = ofNullable(builder.getRateSpecification()).map(f->f.build()).orElse(null);
			this.resetDates = ofNullable(builder.getResetDates()).map(f->f.build()).orElse(null);
			this.stubPeriod = ofNullable(builder.getStubPeriod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BondReference getBondReference() {
			return bondReference;
		}
		
		@Override
		public CalculationPeriodDates getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		public CashflowRepresentation getCashflowRepresentation() {
			return cashflowRepresentation;
		}
		
		@Override
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnum getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DiscountingMethod getDiscountingMethod() {
			return discountingMethod;
		}
		
		@Override
		public String getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		public String getFloatingAmount() {
			return floatingAmount;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public AdjustableDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public PaymentDates getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public Boolean getPaymentDelay() {
			return paymentDelay;
		}
		
		@Override
		public PrincipalExchanges getPrincipalExchanges() {
			return principalExchanges;
		}
		
		@Override
		public RateSpecification getRateSpecification() {
			return rateSpecification;
		}
		
		@Override
		public ResetDates getResetDates() {
			return resetDates;
		}
		
		@Override
		public StubPeriod getStubPeriod() {
			return stubPeriod;
		}
		
		@Override
		public InterestRatePayout build() {
			return this;
		}
		
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder toBuilder() {
			InterestRatePayout.InterestRatePayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRatePayout.InterestRatePayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBondReference()).ifPresent(builder::setBondReference);
			ofNullable(getCalculationPeriodDates()).ifPresent(builder::setCalculationPeriodDates);
			ofNullable(getCashflowRepresentation()).ifPresent(builder::setCashflowRepresentation);
			ofNullable(getCompoundingMethod()).ifPresent(builder::setCompoundingMethod);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getDiscountingMethod()).ifPresent(builder::setDiscountingMethod);
			ofNullable(getFixedAmount()).ifPresent(builder::setFixedAmount);
			ofNullable(getFloatingAmount()).ifPresent(builder::setFloatingAmount);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getPaymentDelay()).ifPresent(builder::setPaymentDelay);
			ofNullable(getPrincipalExchanges()).ifPresent(builder::setPrincipalExchanges);
			ofNullable(getRateSpecification()).ifPresent(builder::setRateSpecification);
			ofNullable(getResetDates()).ifPresent(builder::setResetDates);
			ofNullable(getStubPeriod()).ifPresent(builder::setStubPeriod);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestRatePayout _that = getType().cast(o);
		
			if (!Objects.equals(bondReference, _that.getBondReference())) return false;
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(cashflowRepresentation, _that.getCashflowRepresentation())) return false;
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(discountingMethod, _that.getDiscountingMethod())) return false;
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			if (!Objects.equals(floatingAmount, _that.getFloatingAmount())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(paymentDelay, _that.getPaymentDelay())) return false;
			if (!Objects.equals(principalExchanges, _that.getPrincipalExchanges())) return false;
			if (!Objects.equals(rateSpecification, _that.getRateSpecification())) return false;
			if (!Objects.equals(resetDates, _that.getResetDates())) return false;
			if (!Objects.equals(stubPeriod, _that.getStubPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (bondReference != null ? bondReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (cashflowRepresentation != null ? cashflowRepresentation.hashCode() : 0);
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (discountingMethod != null ? discountingMethod.hashCode() : 0);
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			_result = 31 * _result + (floatingAmount != null ? floatingAmount.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDelay != null ? paymentDelay.hashCode() : 0);
			_result = 31 * _result + (principalExchanges != null ? principalExchanges.hashCode() : 0);
			_result = 31 * _result + (rateSpecification != null ? rateSpecification.hashCode() : 0);
			_result = 31 * _result + (resetDates != null ? resetDates.hashCode() : 0);
			_result = 31 * _result + (stubPeriod != null ? stubPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRatePayout {" +
				"bondReference=" + this.bondReference + ", " +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"cashflowRepresentation=" + this.cashflowRepresentation + ", " +
				"compoundingMethod=" + this.compoundingMethod + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"discountingMethod=" + this.discountingMethod + ", " +
				"fixedAmount=" + this.fixedAmount + ", " +
				"floatingAmount=" + this.floatingAmount + ", " +
				"meta=" + this.meta + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"paymentDelay=" + this.paymentDelay + ", " +
				"principalExchanges=" + this.principalExchanges + ", " +
				"rateSpecification=" + this.rateSpecification + ", " +
				"resetDates=" + this.resetDates + ", " +
				"stubPeriod=" + this.stubPeriod +
			'}' + " " + super.toString();
		}
	}
	
	//InterestRatePayout.InterestRatePayoutBuilderImpl
	class InterestRatePayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl  implements InterestRatePayout.InterestRatePayoutBuilder, GlobalKeyBuilder {
	
		protected BondReference.BondReferenceBuilder bondReference;
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates;
		protected CashflowRepresentation.CashflowRepresentationBuilder cashflowRepresentation;
		protected CompoundingMethodEnum compoundingMethod;
		protected FieldWithMetaDayCountFractionEnumBuilder dayCountFraction;
		protected DiscountingMethod.DiscountingMethodBuilder discountingMethod;
		protected String fixedAmount;
		protected String floatingAmount;
		protected MetaFields.MetaFieldsBuilder meta;
		protected AdjustableDate.AdjustableDateBuilder paymentDate;
		protected PaymentDates.PaymentDatesBuilder paymentDates;
		protected Boolean paymentDelay;
		protected PrincipalExchanges.PrincipalExchangesBuilder principalExchanges;
		protected RateSpecification.RateSpecificationBuilder rateSpecification;
		protected ResetDates.ResetDatesBuilder resetDates;
		protected StubPeriod.StubPeriodBuilder stubPeriod;
	
		public InterestRatePayoutBuilderImpl() {
		}
	
		@Override
		public BondReference.BondReferenceBuilder getBondReference() {
			return bondReference;
		}
		
		@Override
		public BondReference.BondReferenceBuilder getOrCreateBondReference() {
			BondReference.BondReferenceBuilder result;
			if (bondReference!=null) {
				result = bondReference;
			}
			else {
				result = bondReference = BondReference.builder();
			}
			
			return result;
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates() {
			CalculationPeriodDates.CalculationPeriodDatesBuilder result;
			if (calculationPeriodDates!=null) {
				result = calculationPeriodDates;
			}
			else {
				result = calculationPeriodDates = CalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		public CashflowRepresentation.CashflowRepresentationBuilder getCashflowRepresentation() {
			return cashflowRepresentation;
		}
		
		@Override
		public CashflowRepresentation.CashflowRepresentationBuilder getOrCreateCashflowRepresentation() {
			CashflowRepresentation.CashflowRepresentationBuilder result;
			if (cashflowRepresentation!=null) {
				result = cashflowRepresentation;
			}
			else {
				result = cashflowRepresentation = CashflowRepresentation.builder();
			}
			
			return result;
		}
		
		@Override
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnumBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnumBuilder getOrCreateDayCountFraction() {
			FieldWithMetaDayCountFractionEnumBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = FieldWithMetaDayCountFractionEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public DiscountingMethod.DiscountingMethodBuilder getDiscountingMethod() {
			return discountingMethod;
		}
		
		@Override
		public DiscountingMethod.DiscountingMethodBuilder getOrCreateDiscountingMethod() {
			DiscountingMethod.DiscountingMethodBuilder result;
			if (discountingMethod!=null) {
				result = discountingMethod;
			}
			else {
				result = discountingMethod = DiscountingMethod.builder();
			}
			
			return result;
		}
		
		@Override
		public String getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		public String getFloatingAmount() {
			return floatingAmount;
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
		public AdjustableDate.AdjustableDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreatePaymentDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates() {
			PaymentDates.PaymentDatesBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = PaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getPaymentDelay() {
			return paymentDelay;
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder getPrincipalExchanges() {
			return principalExchanges;
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder getOrCreatePrincipalExchanges() {
			PrincipalExchanges.PrincipalExchangesBuilder result;
			if (principalExchanges!=null) {
				result = principalExchanges;
			}
			else {
				result = principalExchanges = PrincipalExchanges.builder();
			}
			
			return result;
		}
		
		@Override
		public RateSpecification.RateSpecificationBuilder getRateSpecification() {
			return rateSpecification;
		}
		
		@Override
		public RateSpecification.RateSpecificationBuilder getOrCreateRateSpecification() {
			RateSpecification.RateSpecificationBuilder result;
			if (rateSpecification!=null) {
				result = rateSpecification;
			}
			else {
				result = rateSpecification = RateSpecification.builder();
			}
			
			return result;
		}
		
		@Override
		public ResetDates.ResetDatesBuilder getResetDates() {
			return resetDates;
		}
		
		@Override
		public ResetDates.ResetDatesBuilder getOrCreateResetDates() {
			ResetDates.ResetDatesBuilder result;
			if (resetDates!=null) {
				result = resetDates;
			}
			else {
				result = resetDates = ResetDates.builder();
			}
			
			return result;
		}
		
		@Override
		public StubPeriod.StubPeriodBuilder getStubPeriod() {
			return stubPeriod;
		}
		
		@Override
		public StubPeriod.StubPeriodBuilder getOrCreateStubPeriod() {
			StubPeriod.StubPeriodBuilder result;
			if (stubPeriod!=null) {
				result = stubPeriod;
			}
			else {
				result = stubPeriod = StubPeriod.builder();
			}
			
			return result;
		}
		
	
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setBondReference(BondReference bondReference) {
			this.bondReference = bondReference==null?null:bondReference.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates) {
			this.calculationPeriodDates = calculationPeriodDates==null?null:calculationPeriodDates.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setCashflowRepresentation(CashflowRepresentation cashflowRepresentation) {
			this.cashflowRepresentation = cashflowRepresentation==null?null:cashflowRepresentation.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setCompoundingMethod(CompoundingMethodEnum compoundingMethod) {
			this.compoundingMethod = compoundingMethod==null?null:compoundingMethod;
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setDayCountFraction(FieldWithMetaDayCountFractionEnum dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setDayCountFractionValue(DayCountFractionEnum dayCountFraction) {
			this.getOrCreateDayCountFraction().setValue(dayCountFraction);
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setDiscountingMethod(DiscountingMethod discountingMethod) {
			this.discountingMethod = discountingMethod==null?null:discountingMethod.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setFixedAmount(String fixedAmount) {
			this.fixedAmount = fixedAmount==null?null:fixedAmount;
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setFloatingAmount(String floatingAmount) {
			this.floatingAmount = floatingAmount==null?null:floatingAmount;
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setPaymentDate(AdjustableDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setPaymentDates(PaymentDates paymentDates) {
			this.paymentDates = paymentDates==null?null:paymentDates.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setPaymentDelay(Boolean paymentDelay) {
			this.paymentDelay = paymentDelay==null?null:paymentDelay;
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setPrincipalExchanges(PrincipalExchanges principalExchanges) {
			this.principalExchanges = principalExchanges==null?null:principalExchanges.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setRateSpecification(RateSpecification rateSpecification) {
			this.rateSpecification = rateSpecification==null?null:rateSpecification.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setResetDates(ResetDates resetDates) {
			this.resetDates = resetDates==null?null:resetDates.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setStubPeriod(StubPeriod stubPeriod) {
			this.stubPeriod = stubPeriod==null?null:stubPeriod.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity) {
			this.payoutQuantity = payoutQuantity==null?null:payoutQuantity.toBuilder();
			return this;
		}
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public InterestRatePayout build() {
			return new InterestRatePayout.InterestRatePayoutImpl(this);
		}
		
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder prune() {
			super.prune();
			if (bondReference!=null && !bondReference.prune().hasData()) bondReference = null;
			if (calculationPeriodDates!=null && !calculationPeriodDates.prune().hasData()) calculationPeriodDates = null;
			if (cashflowRepresentation!=null && !cashflowRepresentation.prune().hasData()) cashflowRepresentation = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (discountingMethod!=null && !discountingMethod.prune().hasData()) discountingMethod = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (principalExchanges!=null && !principalExchanges.prune().hasData()) principalExchanges = null;
			if (rateSpecification!=null && !rateSpecification.prune().hasData()) rateSpecification = null;
			if (resetDates!=null && !resetDates.prune().hasData()) resetDates = null;
			if (stubPeriod!=null && !stubPeriod.prune().hasData()) stubPeriod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBondReference()!=null && getBondReference().hasData()) return true;
			if (getCalculationPeriodDates()!=null && getCalculationPeriodDates().hasData()) return true;
			if (getCashflowRepresentation()!=null && getCashflowRepresentation().hasData()) return true;
			if (getCompoundingMethod()!=null) return true;
			if (getDayCountFraction()!=null) return true;
			if (getDiscountingMethod()!=null && getDiscountingMethod().hasData()) return true;
			if (getFixedAmount()!=null) return true;
			if (getFloatingAmount()!=null) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getPaymentDelay()!=null) return true;
			if (getPrincipalExchanges()!=null && getPrincipalExchanges().hasData()) return true;
			if (getRateSpecification()!=null && getRateSpecification().hasData()) return true;
			if (getResetDates()!=null && getResetDates().hasData()) return true;
			if (getStubPeriod()!=null && getStubPeriod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InterestRatePayout.InterestRatePayoutBuilder o = (InterestRatePayout.InterestRatePayoutBuilder) other;
			
			merger.mergeRosetta(getBondReference(), o.getBondReference(), this::setBondReference);
			merger.mergeRosetta(getCalculationPeriodDates(), o.getCalculationPeriodDates(), this::setCalculationPeriodDates);
			merger.mergeRosetta(getCashflowRepresentation(), o.getCashflowRepresentation(), this::setCashflowRepresentation);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getDiscountingMethod(), o.getDiscountingMethod(), this::setDiscountingMethod);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getPrincipalExchanges(), o.getPrincipalExchanges(), this::setPrincipalExchanges);
			merger.mergeRosetta(getRateSpecification(), o.getRateSpecification(), this::setRateSpecification);
			merger.mergeRosetta(getResetDates(), o.getResetDates(), this::setResetDates);
			merger.mergeRosetta(getStubPeriod(), o.getStubPeriod(), this::setStubPeriod);
			
			merger.mergeBasic(getCompoundingMethod(), o.getCompoundingMethod(), this::setCompoundingMethod);
			merger.mergeBasic(getFixedAmount(), o.getFixedAmount(), this::setFixedAmount);
			merger.mergeBasic(getFloatingAmount(), o.getFloatingAmount(), this::setFloatingAmount);
			merger.mergeBasic(getPaymentDelay(), o.getPaymentDelay(), this::setPaymentDelay);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestRatePayout _that = getType().cast(o);
		
			if (!Objects.equals(bondReference, _that.getBondReference())) return false;
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(cashflowRepresentation, _that.getCashflowRepresentation())) return false;
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(discountingMethod, _that.getDiscountingMethod())) return false;
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			if (!Objects.equals(floatingAmount, _that.getFloatingAmount())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(paymentDelay, _that.getPaymentDelay())) return false;
			if (!Objects.equals(principalExchanges, _that.getPrincipalExchanges())) return false;
			if (!Objects.equals(rateSpecification, _that.getRateSpecification())) return false;
			if (!Objects.equals(resetDates, _that.getResetDates())) return false;
			if (!Objects.equals(stubPeriod, _that.getStubPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (bondReference != null ? bondReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (cashflowRepresentation != null ? cashflowRepresentation.hashCode() : 0);
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (discountingMethod != null ? discountingMethod.hashCode() : 0);
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			_result = 31 * _result + (floatingAmount != null ? floatingAmount.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDelay != null ? paymentDelay.hashCode() : 0);
			_result = 31 * _result + (principalExchanges != null ? principalExchanges.hashCode() : 0);
			_result = 31 * _result + (rateSpecification != null ? rateSpecification.hashCode() : 0);
			_result = 31 * _result + (resetDates != null ? resetDates.hashCode() : 0);
			_result = 31 * _result + (stubPeriod != null ? stubPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRatePayoutBuilder {" +
				"bondReference=" + this.bondReference + ", " +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"cashflowRepresentation=" + this.cashflowRepresentation + ", " +
				"compoundingMethod=" + this.compoundingMethod + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"discountingMethod=" + this.discountingMethod + ", " +
				"fixedAmount=" + this.fixedAmount + ", " +
				"floatingAmount=" + this.floatingAmount + ", " +
				"meta=" + this.meta + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"paymentDelay=" + this.paymentDelay + ", " +
				"principalExchanges=" + this.principalExchanges + ", " +
				"rateSpecification=" + this.rateSpecification + ", " +
				"resetDates=" + this.resetDates + ", " +
				"stubPeriod=" + this.stubPeriod +
			'}' + " " + super.toString();
		}
	}
}
