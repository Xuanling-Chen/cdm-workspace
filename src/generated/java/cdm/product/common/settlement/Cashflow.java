package cdm.product.common.settlement;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.Money;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.meta.CashflowMeta;
import cdm.product.template.PremiumExpression;
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
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Class to specify a cashflow, i.e. the outcome of either of computation (e.g. interest accrual) or an assessment of some sort (e.g. a fee). The cashflow can then be turned into a cash transfer, artefact to be used as the input to a payment system or the outcome of it. The associated globalKey denotes the ability to associate a hash value to the Cashflow instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version ${project.version}
 */
@RosettaClass

public interface Cashflow extends PayoutBase, GlobalKey {
	Cashflow build();
	Cashflow.CashflowBuilder toBuilder();
	
	/**
	 * SCHEDULED FOR DEPRECATION, QUANTITY HANDLED IN PAYOUTBASE. The currency amount of the payment.
	 */
	Money getCashflowAmount();
	/**
	 * This is a conceptual placeholder for providing the breakdown into the cashflow calculation components, leveraging the fact that the CDM provides calculation components, starting with the FixedAmount and the FloatingAmount. Further evaluation of expected usage needs to take place to confirm and prioritize such implementation.
	 */
	String getCashflowCalculation();
	/**
	 */
	AdjustableOrAdjustedOrRelativeDate getCashflowDate();
	/**
	 * The qualification of the type of cashflow, e.g. brokerage fee, premium, upfront fee etc. Particularly relevant when it cannot be inferred directly through lineage.
	 */
	CashflowTypeEnum getCashflowType();
	/**
	 * The value representing the discount factor used to calculate the present value of the cashflow.
	 */
	BigDecimal getDiscountFactor();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Applicable to CDS on MBS to specify whether payment delays are applicable to the fixed Amount. RMBS typically have a payment delay of 5 days between the coupon date of the reference obligation and the payment date of the synthetic swap. CMBS do not, on the other hand, with both payment dates being on the 25th of each month.
	 */
	Boolean getPaymentDelay();
	/**
	 * FpML specifies the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.
	 */
	PaymentDiscounting getPaymentDiscounting();
	/**
	 * FpML specifies the Premium.model group for representing the option premium when expressed in a way other than an amount.
	 */
	PremiumExpression getPremiumExpression();
	/**
	 * The amount representing the present value of the forecast payment.
	 */
	Money getPresentValueAmount();
	final static CashflowMeta metaData = new CashflowMeta();
	
	@Override
	default RosettaMetaData<? extends Cashflow> metaData() {
		return metaData;
	} 
			
	static Cashflow.CashflowBuilder builder() {
		return new Cashflow.CashflowBuilderImpl();
	}
	
	default Class<? extends Cashflow> getType() {
		return Cashflow.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.common.settlement.PayoutBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("cashflowCalculation"), String.class, getCashflowCalculation(), this);
		processor.processBasic(path.newSubPath("cashflowType"), CashflowTypeEnum.class, getCashflowType(), this);
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processor.processBasic(path.newSubPath("paymentDelay"), Boolean.class, getPaymentDelay(), this);
		
		processRosetta(path.newSubPath("cashflowAmount"), processor, Money.class, getCashflowAmount());
		processRosetta(path.newSubPath("cashflowDate"), processor, AdjustableOrAdjustedOrRelativeDate.class, getCashflowDate());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("paymentDiscounting"), processor, PaymentDiscounting.class, getPaymentDiscounting());
		processRosetta(path.newSubPath("premiumExpression"), processor, PremiumExpression.class, getPremiumExpression());
		processRosetta(path.newSubPath("presentValueAmount"), processor, Money.class, getPresentValueAmount());
	}
	
	
	interface CashflowBuilder extends Cashflow, PayoutBase.PayoutBaseBuilder, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateCashflowAmount();
		Money.MoneyBuilder getCashflowAmount();
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getOrCreateCashflowDate();
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getCashflowDate();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		PaymentDiscounting.PaymentDiscountingBuilder getOrCreatePaymentDiscounting();
		PaymentDiscounting.PaymentDiscountingBuilder getPaymentDiscounting();
		PremiumExpression.PremiumExpressionBuilder getOrCreatePremiumExpression();
		PremiumExpression.PremiumExpressionBuilder getPremiumExpression();
		Money.MoneyBuilder getOrCreatePresentValueAmount();
		Money.MoneyBuilder getPresentValueAmount();
		Cashflow.CashflowBuilder setCashflowAmount(Money cashflowAmount);
		Cashflow.CashflowBuilder setCashflowCalculation(String cashflowCalculation);
		Cashflow.CashflowBuilder setCashflowDate(AdjustableOrAdjustedOrRelativeDate cashflowDate);
		Cashflow.CashflowBuilder setCashflowType(CashflowTypeEnum cashflowType);
		Cashflow.CashflowBuilder setDiscountFactor(BigDecimal discountFactor);
		Cashflow.CashflowBuilder setMeta(MetaFields meta);
		Cashflow.CashflowBuilder setPaymentDelay(Boolean paymentDelay);
		Cashflow.CashflowBuilder setPaymentDiscounting(PaymentDiscounting paymentDiscounting);
		Cashflow.CashflowBuilder setPremiumExpression(PremiumExpression premiumExpression);
		Cashflow.CashflowBuilder setPresentValueAmount(Money presentValueAmount);
		Cashflow.CashflowBuilder setPayerReceiver(PayerReceiver payerReceiver);
		Cashflow.CashflowBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity);
		Cashflow.CashflowBuilder setSettlementTerms(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PayoutBase.PayoutBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("cashflowCalculation"), String.class, getCashflowCalculation(), this);
			processor.processBasic(path.newSubPath("cashflowType"), CashflowTypeEnum.class, getCashflowType(), this);
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processor.processBasic(path.newSubPath("paymentDelay"), Boolean.class, getPaymentDelay(), this);
			
			processRosetta(path.newSubPath("cashflowAmount"), processor, Money.MoneyBuilder.class, getCashflowAmount());
			processRosetta(path.newSubPath("cashflowDate"), processor, AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder.class, getCashflowDate());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("paymentDiscounting"), processor, PaymentDiscounting.PaymentDiscountingBuilder.class, getPaymentDiscounting());
			processRosetta(path.newSubPath("premiumExpression"), processor, PremiumExpression.PremiumExpressionBuilder.class, getPremiumExpression());
			processRosetta(path.newSubPath("presentValueAmount"), processor, Money.MoneyBuilder.class, getPresentValueAmount());
		}
		
	}
	
	//Cashflow.CashflowImpl
	class CashflowImpl extends PayoutBase.PayoutBaseImpl implements Cashflow {
		private final Money cashflowAmount;
		private final String cashflowCalculation;
		private final AdjustableOrAdjustedOrRelativeDate cashflowDate;
		private final CashflowTypeEnum cashflowType;
		private final BigDecimal discountFactor;
		private final MetaFields meta;
		private final Boolean paymentDelay;
		private final PaymentDiscounting paymentDiscounting;
		private final PremiumExpression premiumExpression;
		private final Money presentValueAmount;
		
		protected CashflowImpl(Cashflow.CashflowBuilder builder) {
			super(builder);
			this.cashflowAmount = ofNullable(builder.getCashflowAmount()).map(f->f.build()).orElse(null);
			this.cashflowCalculation = builder.getCashflowCalculation();
			this.cashflowDate = ofNullable(builder.getCashflowDate()).map(f->f.build()).orElse(null);
			this.cashflowType = builder.getCashflowType();
			this.discountFactor = builder.getDiscountFactor();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.paymentDelay = builder.getPaymentDelay();
			this.paymentDiscounting = ofNullable(builder.getPaymentDiscounting()).map(f->f.build()).orElse(null);
			this.premiumExpression = ofNullable(builder.getPremiumExpression()).map(f->f.build()).orElse(null);
			this.presentValueAmount = ofNullable(builder.getPresentValueAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Money getCashflowAmount() {
			return cashflowAmount;
		}
		
		@Override
		public String getCashflowCalculation() {
			return cashflowCalculation;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate getCashflowDate() {
			return cashflowDate;
		}
		
		@Override
		public CashflowTypeEnum getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Boolean getPaymentDelay() {
			return paymentDelay;
		}
		
		@Override
		public PaymentDiscounting getPaymentDiscounting() {
			return paymentDiscounting;
		}
		
		@Override
		public PremiumExpression getPremiumExpression() {
			return premiumExpression;
		}
		
		@Override
		public Money getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		public Cashflow build() {
			return this;
		}
		
		@Override
		public Cashflow.CashflowBuilder toBuilder() {
			Cashflow.CashflowBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Cashflow.CashflowBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCashflowAmount()).ifPresent(builder::setCashflowAmount);
			ofNullable(getCashflowCalculation()).ifPresent(builder::setCashflowCalculation);
			ofNullable(getCashflowDate()).ifPresent(builder::setCashflowDate);
			ofNullable(getCashflowType()).ifPresent(builder::setCashflowType);
			ofNullable(getDiscountFactor()).ifPresent(builder::setDiscountFactor);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPaymentDelay()).ifPresent(builder::setPaymentDelay);
			ofNullable(getPaymentDiscounting()).ifPresent(builder::setPaymentDiscounting);
			ofNullable(getPremiumExpression()).ifPresent(builder::setPremiumExpression);
			ofNullable(getPresentValueAmount()).ifPresent(builder::setPresentValueAmount);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Cashflow _that = getType().cast(o);
		
			if (!Objects.equals(cashflowAmount, _that.getCashflowAmount())) return false;
			if (!Objects.equals(cashflowCalculation, _that.getCashflowCalculation())) return false;
			if (!Objects.equals(cashflowDate, _that.getCashflowDate())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(paymentDelay, _that.getPaymentDelay())) return false;
			if (!Objects.equals(paymentDiscounting, _that.getPaymentDiscounting())) return false;
			if (!Objects.equals(premiumExpression, _that.getPremiumExpression())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cashflowAmount != null ? cashflowAmount.hashCode() : 0);
			_result = 31 * _result + (cashflowCalculation != null ? cashflowCalculation.hashCode() : 0);
			_result = 31 * _result + (cashflowDate != null ? cashflowDate.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (paymentDelay != null ? paymentDelay.hashCode() : 0);
			_result = 31 * _result + (paymentDiscounting != null ? paymentDiscounting.hashCode() : 0);
			_result = 31 * _result + (premiumExpression != null ? premiumExpression.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Cashflow {" +
				"cashflowAmount=" + this.cashflowAmount + ", " +
				"cashflowCalculation=" + this.cashflowCalculation + ", " +
				"cashflowDate=" + this.cashflowDate + ", " +
				"cashflowType=" + this.cashflowType + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"meta=" + this.meta + ", " +
				"paymentDelay=" + this.paymentDelay + ", " +
				"paymentDiscounting=" + this.paymentDiscounting + ", " +
				"premiumExpression=" + this.premiumExpression + ", " +
				"presentValueAmount=" + this.presentValueAmount +
			'}' + " " + super.toString();
		}
	}
	
	//Cashflow.CashflowBuilderImpl
	class CashflowBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl  implements Cashflow.CashflowBuilder, GlobalKeyBuilder {
	
		protected Money.MoneyBuilder cashflowAmount;
		protected String cashflowCalculation;
		protected AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder cashflowDate;
		protected CashflowTypeEnum cashflowType;
		protected BigDecimal discountFactor;
		protected MetaFields.MetaFieldsBuilder meta;
		protected Boolean paymentDelay;
		protected PaymentDiscounting.PaymentDiscountingBuilder paymentDiscounting;
		protected PremiumExpression.PremiumExpressionBuilder premiumExpression;
		protected Money.MoneyBuilder presentValueAmount;
	
		public CashflowBuilderImpl() {
		}
	
		@Override
		public Money.MoneyBuilder getCashflowAmount() {
			return cashflowAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCashflowAmount() {
			Money.MoneyBuilder result;
			if (cashflowAmount!=null) {
				result = cashflowAmount;
			}
			else {
				result = cashflowAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public String getCashflowCalculation() {
			return cashflowCalculation;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getCashflowDate() {
			return cashflowDate;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getOrCreateCashflowDate() {
			AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder result;
			if (cashflowDate!=null) {
				result = cashflowDate;
			}
			else {
				result = cashflowDate = AdjustableOrAdjustedOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		public CashflowTypeEnum getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public BigDecimal getDiscountFactor() {
			return discountFactor;
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
		public Boolean getPaymentDelay() {
			return paymentDelay;
		}
		
		@Override
		public PaymentDiscounting.PaymentDiscountingBuilder getPaymentDiscounting() {
			return paymentDiscounting;
		}
		
		@Override
		public PaymentDiscounting.PaymentDiscountingBuilder getOrCreatePaymentDiscounting() {
			PaymentDiscounting.PaymentDiscountingBuilder result;
			if (paymentDiscounting!=null) {
				result = paymentDiscounting;
			}
			else {
				result = paymentDiscounting = PaymentDiscounting.builder();
			}
			
			return result;
		}
		
		@Override
		public PremiumExpression.PremiumExpressionBuilder getPremiumExpression() {
			return premiumExpression;
		}
		
		@Override
		public PremiumExpression.PremiumExpressionBuilder getOrCreatePremiumExpression() {
			PremiumExpression.PremiumExpressionBuilder result;
			if (premiumExpression!=null) {
				result = premiumExpression;
			}
			else {
				result = premiumExpression = PremiumExpression.builder();
			}
			
			return result;
		}
		
		@Override
		public Money.MoneyBuilder getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePresentValueAmount() {
			Money.MoneyBuilder result;
			if (presentValueAmount!=null) {
				result = presentValueAmount;
			}
			else {
				result = presentValueAmount = Money.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Cashflow.CashflowBuilder setCashflowAmount(Money cashflowAmount) {
			this.cashflowAmount = cashflowAmount==null?null:cashflowAmount.toBuilder();
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setCashflowCalculation(String cashflowCalculation) {
			this.cashflowCalculation = cashflowCalculation==null?null:cashflowCalculation;
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setCashflowDate(AdjustableOrAdjustedOrRelativeDate cashflowDate) {
			this.cashflowDate = cashflowDate==null?null:cashflowDate.toBuilder();
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setCashflowType(CashflowTypeEnum cashflowType) {
			this.cashflowType = cashflowType==null?null:cashflowType;
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setDiscountFactor(BigDecimal discountFactor) {
			this.discountFactor = discountFactor==null?null:discountFactor;
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setPaymentDelay(Boolean paymentDelay) {
			this.paymentDelay = paymentDelay==null?null:paymentDelay;
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setPaymentDiscounting(PaymentDiscounting paymentDiscounting) {
			this.paymentDiscounting = paymentDiscounting==null?null:paymentDiscounting.toBuilder();
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setPremiumExpression(PremiumExpression premiumExpression) {
			this.premiumExpression = premiumExpression==null?null:premiumExpression.toBuilder();
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setPresentValueAmount(Money presentValueAmount) {
			this.presentValueAmount = presentValueAmount==null?null:presentValueAmount.toBuilder();
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity) {
			this.payoutQuantity = payoutQuantity==null?null:payoutQuantity.toBuilder();
			return this;
		}
		@Override
		public Cashflow.CashflowBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public Cashflow build() {
			return new Cashflow.CashflowImpl(this);
		}
		
		@Override
		public Cashflow.CashflowBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cashflow.CashflowBuilder prune() {
			super.prune();
			if (cashflowAmount!=null && !cashflowAmount.prune().hasData()) cashflowAmount = null;
			if (cashflowDate!=null && !cashflowDate.prune().hasData()) cashflowDate = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (paymentDiscounting!=null && !paymentDiscounting.prune().hasData()) paymentDiscounting = null;
			if (premiumExpression!=null && !premiumExpression.prune().hasData()) premiumExpression = null;
			if (presentValueAmount!=null && !presentValueAmount.prune().hasData()) presentValueAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCashflowAmount()!=null && getCashflowAmount().hasData()) return true;
			if (getCashflowCalculation()!=null) return true;
			if (getCashflowDate()!=null && getCashflowDate().hasData()) return true;
			if (getCashflowType()!=null) return true;
			if (getDiscountFactor()!=null) return true;
			if (getPaymentDelay()!=null) return true;
			if (getPaymentDiscounting()!=null && getPaymentDiscounting().hasData()) return true;
			if (getPremiumExpression()!=null && getPremiumExpression().hasData()) return true;
			if (getPresentValueAmount()!=null && getPresentValueAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cashflow.CashflowBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Cashflow.CashflowBuilder o = (Cashflow.CashflowBuilder) other;
			
			merger.mergeRosetta(getCashflowAmount(), o.getCashflowAmount(), this::setCashflowAmount);
			merger.mergeRosetta(getCashflowDate(), o.getCashflowDate(), this::setCashflowDate);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPaymentDiscounting(), o.getPaymentDiscounting(), this::setPaymentDiscounting);
			merger.mergeRosetta(getPremiumExpression(), o.getPremiumExpression(), this::setPremiumExpression);
			merger.mergeRosetta(getPresentValueAmount(), o.getPresentValueAmount(), this::setPresentValueAmount);
			
			merger.mergeBasic(getCashflowCalculation(), o.getCashflowCalculation(), this::setCashflowCalculation);
			merger.mergeBasic(getCashflowType(), o.getCashflowType(), this::setCashflowType);
			merger.mergeBasic(getDiscountFactor(), o.getDiscountFactor(), this::setDiscountFactor);
			merger.mergeBasic(getPaymentDelay(), o.getPaymentDelay(), this::setPaymentDelay);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Cashflow _that = getType().cast(o);
		
			if (!Objects.equals(cashflowAmount, _that.getCashflowAmount())) return false;
			if (!Objects.equals(cashflowCalculation, _that.getCashflowCalculation())) return false;
			if (!Objects.equals(cashflowDate, _that.getCashflowDate())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(paymentDelay, _that.getPaymentDelay())) return false;
			if (!Objects.equals(paymentDiscounting, _that.getPaymentDiscounting())) return false;
			if (!Objects.equals(premiumExpression, _that.getPremiumExpression())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cashflowAmount != null ? cashflowAmount.hashCode() : 0);
			_result = 31 * _result + (cashflowCalculation != null ? cashflowCalculation.hashCode() : 0);
			_result = 31 * _result + (cashflowDate != null ? cashflowDate.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (paymentDelay != null ? paymentDelay.hashCode() : 0);
			_result = 31 * _result + (paymentDiscounting != null ? paymentDiscounting.hashCode() : 0);
			_result = 31 * _result + (premiumExpression != null ? premiumExpression.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowBuilder {" +
				"cashflowAmount=" + this.cashflowAmount + ", " +
				"cashflowCalculation=" + this.cashflowCalculation + ", " +
				"cashflowDate=" + this.cashflowDate + ", " +
				"cashflowType=" + this.cashflowType + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"meta=" + this.meta + ", " +
				"paymentDelay=" + this.paymentDelay + ", " +
				"paymentDiscounting=" + this.paymentDiscounting + ", " +
				"premiumExpression=" + this.premiumExpression + ", " +
				"presentValueAmount=" + this.presentValueAmount +
			'}' + " " + super.toString();
		}
	}
}
