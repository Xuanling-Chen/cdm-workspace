package cdm.product.common.settlement;

import cdm.base.datetime.BusinessCenterTime;
import cdm.observable.asset.Money;
import cdm.observable.asset.ValuationMethod;
import cdm.product.common.settlement.meta.CashSettlementTermsMeta;
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
 * Defines the terms required to compute and settle a cash settlement amount according to a fixing value, including the fixing source, fixing method and fixing date. In FpML, PhysicalSettlementTerms and CashSettlementTerms extend SettlementTerms. In the CDM, this extension paradigm has not been used because SettlementTerms class has been used for purposes related to securities transactions, while it is not used as such in the FpML standard (i.e. only as an abstract construct.
 * @version ${project.version}
 */
@RosettaClass

public interface CashSettlementTerms extends RosettaModelObject, GlobalKey {
	CashSettlementTerms build();
	CashSettlementTerms.CashSettlementTermsBuilder toBuilder();
	
	/**
	 * Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest.
	 */
	Boolean getAccruedInterest();
	/**
	 * The amount paid by the seller to the buyer for cash settlement on the cash settlement date. If not otherwise specified, would typically be calculated as 100 (or the Reference Price) minus the price of the Reference Obligation (all expressed as a percentage) times Floating Rate Payer Calculation Amount. ISDA 2003 Term: Cash Settlement Amount.
	 */
	Money getCashSettlementAmount();
	/**
	 * Specifies the type of cash settlement method: cash price, yield curve etc.
	 */
	CashSettlementMethodEnum getCashSettlementMethod();
	/**
	 * Used for Recovery Lock, to indicate whether fixed Settlement is Applicable or Not Applicable. If Buyer fails to deliver an effective Notice of Physical Settlement on or before the Buyer NOPS Cut-off Date, and if Seller fails to deliver an effective Seller NOPS on or before the Seller NOPS Cut-off Date, then either: (a) if Fixed Settlement is specified in the related Confirmation as not applicable, then the Seller NOPS Cut-off Date shall be the Termination Date; or (b) if Fixed Settlement is specified in the related Confirmation as applicable, then: (i) if the Fixed Settlement Amount is a positive number, Seller shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the Fixed Settlement Amount to Buyer on the Fixed Settlement Payment Date; and (ii) if the Fixed Settlement Amount is a negative number, Buyer shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the absolute value of the Fixed Settlement Amount to Seller on the Fixed Settlement Payment Date.
	 */
	Boolean getFixedSettlement();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Used for fixed recovery, specifies the recovery level, determined at contract formation, to be applied on a default. Used to calculate the amount paid by the seller to the buyer for cash settlement on the cash settlement date. Amount calculation is (1 minus the Recovery Factor) multiplied by the Floating Rate Payer Calculation Amount. The currency will be derived from the Floating Rate Payer Calculation Amount.
	 */
	BigDecimal getRecoveryFactor();
	/**
	 * Defines the different methods to specify a valuation date, as used for cash settlement. The Single / Multiple ValuationDate is used for the determination of recovery in a credit event, the RelativeDateOffset is used for cash-settled option, and FxFixingDate is used for cross-currency settlement.
	 */
	ValuationDate getValuationDate();
	/**
	 * Specifies the parameters required to obtain a valuation, including the source, quotation method (bid, mid etc.) and any applicable quotation amount.
	 */
	ValuationMethod getValuationMethod();
	/**
	 * The time of the cash settlement valuation date when the cash settlement amount will be determined according to the cash settlement method, if the parties have not otherwise been able to agree the cash settlement amount. When using quations, this is the time of day in the specified business center when the calculation agent seeks quotations for an amount of the reference obligation for purposes of cash settlement. ISDA 2003 Term: Valuation Time.
	 */
	BusinessCenterTime getValuationTime();
	final static CashSettlementTermsMeta metaData = new CashSettlementTermsMeta();
	
	@Override
	default RosettaMetaData<? extends CashSettlementTerms> metaData() {
		return metaData;
	} 
			
	static CashSettlementTerms.CashSettlementTermsBuilder builder() {
		return new CashSettlementTerms.CashSettlementTermsBuilderImpl();
	}
	
	default Class<? extends CashSettlementTerms> getType() {
		return CashSettlementTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("accruedInterest"), Boolean.class, getAccruedInterest(), this);
		processor.processBasic(path.newSubPath("cashSettlementMethod"), CashSettlementMethodEnum.class, getCashSettlementMethod(), this);
		processor.processBasic(path.newSubPath("fixedSettlement"), Boolean.class, getFixedSettlement(), this);
		processor.processBasic(path.newSubPath("recoveryFactor"), BigDecimal.class, getRecoveryFactor(), this);
		
		processRosetta(path.newSubPath("cashSettlementAmount"), processor, Money.class, getCashSettlementAmount());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("valuationDate"), processor, ValuationDate.class, getValuationDate());
		processRosetta(path.newSubPath("valuationMethod"), processor, ValuationMethod.class, getValuationMethod());
		processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.class, getValuationTime());
	}
	
	
	interface CashSettlementTermsBuilder extends CashSettlementTerms, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateCashSettlementAmount();
		Money.MoneyBuilder getCashSettlementAmount();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		ValuationDate.ValuationDateBuilder getOrCreateValuationDate();
		ValuationDate.ValuationDateBuilder getValuationDate();
		ValuationMethod.ValuationMethodBuilder getOrCreateValuationMethod();
		ValuationMethod.ValuationMethodBuilder getValuationMethod();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime();
		CashSettlementTerms.CashSettlementTermsBuilder setAccruedInterest(Boolean accruedInterest);
		CashSettlementTerms.CashSettlementTermsBuilder setCashSettlementAmount(Money cashSettlementAmount);
		CashSettlementTerms.CashSettlementTermsBuilder setCashSettlementMethod(CashSettlementMethodEnum cashSettlementMethod);
		CashSettlementTerms.CashSettlementTermsBuilder setFixedSettlement(Boolean fixedSettlement);
		CashSettlementTerms.CashSettlementTermsBuilder setMeta(MetaFields meta);
		CashSettlementTerms.CashSettlementTermsBuilder setRecoveryFactor(BigDecimal recoveryFactor);
		CashSettlementTerms.CashSettlementTermsBuilder setValuationDate(ValuationDate valuationDate);
		CashSettlementTerms.CashSettlementTermsBuilder setValuationMethod(ValuationMethod valuationMethod);
		CashSettlementTerms.CashSettlementTermsBuilder setValuationTime(BusinessCenterTime valuationTime);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("accruedInterest"), Boolean.class, getAccruedInterest(), this);
			processor.processBasic(path.newSubPath("cashSettlementMethod"), CashSettlementMethodEnum.class, getCashSettlementMethod(), this);
			processor.processBasic(path.newSubPath("fixedSettlement"), Boolean.class, getFixedSettlement(), this);
			processor.processBasic(path.newSubPath("recoveryFactor"), BigDecimal.class, getRecoveryFactor(), this);
			
			processRosetta(path.newSubPath("cashSettlementAmount"), processor, Money.MoneyBuilder.class, getCashSettlementAmount());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("valuationDate"), processor, ValuationDate.ValuationDateBuilder.class, getValuationDate());
			processRosetta(path.newSubPath("valuationMethod"), processor, ValuationMethod.ValuationMethodBuilder.class, getValuationMethod());
			processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getValuationTime());
		}
		
	}
	
	//CashSettlementTerms.CashSettlementTermsImpl
	class CashSettlementTermsImpl implements CashSettlementTerms {
		private final Boolean accruedInterest;
		private final Money cashSettlementAmount;
		private final CashSettlementMethodEnum cashSettlementMethod;
		private final Boolean fixedSettlement;
		private final MetaFields meta;
		private final BigDecimal recoveryFactor;
		private final ValuationDate valuationDate;
		private final ValuationMethod valuationMethod;
		private final BusinessCenterTime valuationTime;
		
		protected CashSettlementTermsImpl(CashSettlementTerms.CashSettlementTermsBuilder builder) {
			this.accruedInterest = builder.getAccruedInterest();
			this.cashSettlementAmount = ofNullable(builder.getCashSettlementAmount()).map(f->f.build()).orElse(null);
			this.cashSettlementMethod = builder.getCashSettlementMethod();
			this.fixedSettlement = builder.getFixedSettlement();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.recoveryFactor = builder.getRecoveryFactor();
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
			this.valuationMethod = ofNullable(builder.getValuationMethod()).map(f->f.build()).orElse(null);
			this.valuationTime = ofNullable(builder.getValuationTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Boolean getAccruedInterest() {
			return accruedInterest;
		}
		
		@Override
		public Money getCashSettlementAmount() {
			return cashSettlementAmount;
		}
		
		@Override
		public CashSettlementMethodEnum getCashSettlementMethod() {
			return cashSettlementMethod;
		}
		
		@Override
		public Boolean getFixedSettlement() {
			return fixedSettlement;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public BigDecimal getRecoveryFactor() {
			return recoveryFactor;
		}
		
		@Override
		public ValuationDate getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public ValuationMethod getValuationMethod() {
			return valuationMethod;
		}
		
		@Override
		public BusinessCenterTime getValuationTime() {
			return valuationTime;
		}
		
		@Override
		public CashSettlementTerms build() {
			return this;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder toBuilder() {
			CashSettlementTerms.CashSettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashSettlementTerms.CashSettlementTermsBuilder builder) {
			ofNullable(getAccruedInterest()).ifPresent(builder::setAccruedInterest);
			ofNullable(getCashSettlementAmount()).ifPresent(builder::setCashSettlementAmount);
			ofNullable(getCashSettlementMethod()).ifPresent(builder::setCashSettlementMethod);
			ofNullable(getFixedSettlement()).ifPresent(builder::setFixedSettlement);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getRecoveryFactor()).ifPresent(builder::setRecoveryFactor);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getValuationMethod()).ifPresent(builder::setValuationMethod);
			ofNullable(getValuationTime()).ifPresent(builder::setValuationTime);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(accruedInterest, _that.getAccruedInterest())) return false;
			if (!Objects.equals(cashSettlementAmount, _that.getCashSettlementAmount())) return false;
			if (!Objects.equals(cashSettlementMethod, _that.getCashSettlementMethod())) return false;
			if (!Objects.equals(fixedSettlement, _that.getFixedSettlement())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(recoveryFactor, _that.getRecoveryFactor())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationMethod, _that.getValuationMethod())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accruedInterest != null ? accruedInterest.hashCode() : 0);
			_result = 31 * _result + (cashSettlementAmount != null ? cashSettlementAmount.hashCode() : 0);
			_result = 31 * _result + (cashSettlementMethod != null ? cashSettlementMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixedSettlement != null ? fixedSettlement.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (recoveryFactor != null ? recoveryFactor.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationMethod != null ? valuationMethod.hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementTerms {" +
				"accruedInterest=" + this.accruedInterest + ", " +
				"cashSettlementAmount=" + this.cashSettlementAmount + ", " +
				"cashSettlementMethod=" + this.cashSettlementMethod + ", " +
				"fixedSettlement=" + this.fixedSettlement + ", " +
				"meta=" + this.meta + ", " +
				"recoveryFactor=" + this.recoveryFactor + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationMethod=" + this.valuationMethod + ", " +
				"valuationTime=" + this.valuationTime +
			'}';
		}
	}
	
	//CashSettlementTerms.CashSettlementTermsBuilderImpl
	class CashSettlementTermsBuilderImpl implements CashSettlementTerms.CashSettlementTermsBuilder, GlobalKeyBuilder {
	
		protected Boolean accruedInterest;
		protected Money.MoneyBuilder cashSettlementAmount;
		protected CashSettlementMethodEnum cashSettlementMethod;
		protected Boolean fixedSettlement;
		protected MetaFields.MetaFieldsBuilder meta;
		protected BigDecimal recoveryFactor;
		protected ValuationDate.ValuationDateBuilder valuationDate;
		protected ValuationMethod.ValuationMethodBuilder valuationMethod;
		protected BusinessCenterTime.BusinessCenterTimeBuilder valuationTime;
	
		public CashSettlementTermsBuilderImpl() {
		}
	
		@Override
		public Boolean getAccruedInterest() {
			return accruedInterest;
		}
		
		@Override
		public Money.MoneyBuilder getCashSettlementAmount() {
			return cashSettlementAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCashSettlementAmount() {
			Money.MoneyBuilder result;
			if (cashSettlementAmount!=null) {
				result = cashSettlementAmount;
			}
			else {
				result = cashSettlementAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public CashSettlementMethodEnum getCashSettlementMethod() {
			return cashSettlementMethod;
		}
		
		@Override
		public Boolean getFixedSettlement() {
			return fixedSettlement;
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
		public BigDecimal getRecoveryFactor() {
			return recoveryFactor;
		}
		
		@Override
		public ValuationDate.ValuationDateBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public ValuationDate.ValuationDateBuilder getOrCreateValuationDate() {
			ValuationDate.ValuationDateBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = ValuationDate.builder();
			}
			
			return result;
		}
		
		@Override
		public ValuationMethod.ValuationMethodBuilder getValuationMethod() {
			return valuationMethod;
		}
		
		@Override
		public ValuationMethod.ValuationMethodBuilder getOrCreateValuationMethod() {
			ValuationMethod.ValuationMethodBuilder result;
			if (valuationMethod!=null) {
				result = valuationMethod;
			}
			else {
				result = valuationMethod = ValuationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime() {
			return valuationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (valuationTime!=null) {
				result = valuationTime;
			}
			else {
				result = valuationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setAccruedInterest(Boolean accruedInterest) {
			this.accruedInterest = accruedInterest==null?null:accruedInterest;
			return this;
		}
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setCashSettlementAmount(Money cashSettlementAmount) {
			this.cashSettlementAmount = cashSettlementAmount==null?null:cashSettlementAmount.toBuilder();
			return this;
		}
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setCashSettlementMethod(CashSettlementMethodEnum cashSettlementMethod) {
			this.cashSettlementMethod = cashSettlementMethod==null?null:cashSettlementMethod;
			return this;
		}
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setFixedSettlement(Boolean fixedSettlement) {
			this.fixedSettlement = fixedSettlement==null?null:fixedSettlement;
			return this;
		}
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setRecoveryFactor(BigDecimal recoveryFactor) {
			this.recoveryFactor = recoveryFactor==null?null:recoveryFactor;
			return this;
		}
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setValuationDate(ValuationDate valuationDate) {
			this.valuationDate = valuationDate==null?null:valuationDate.toBuilder();
			return this;
		}
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setValuationMethod(ValuationMethod valuationMethod) {
			this.valuationMethod = valuationMethod==null?null:valuationMethod.toBuilder();
			return this;
		}
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setValuationTime(BusinessCenterTime valuationTime) {
			this.valuationTime = valuationTime==null?null:valuationTime.toBuilder();
			return this;
		}
		
		@Override
		public CashSettlementTerms build() {
			return new CashSettlementTerms.CashSettlementTermsImpl(this);
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder prune() {
			if (cashSettlementAmount!=null && !cashSettlementAmount.prune().hasData()) cashSettlementAmount = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			if (valuationMethod!=null && !valuationMethod.prune().hasData()) valuationMethod = null;
			if (valuationTime!=null && !valuationTime.prune().hasData()) valuationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccruedInterest()!=null) return true;
			if (getCashSettlementAmount()!=null && getCashSettlementAmount().hasData()) return true;
			if (getCashSettlementMethod()!=null) return true;
			if (getFixedSettlement()!=null) return true;
			if (getRecoveryFactor()!=null) return true;
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			if (getValuationMethod()!=null && getValuationMethod().hasData()) return true;
			if (getValuationTime()!=null && getValuationTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashSettlementTerms.CashSettlementTermsBuilder o = (CashSettlementTerms.CashSettlementTermsBuilder) other;
			
			merger.mergeRosetta(getCashSettlementAmount(), o.getCashSettlementAmount(), this::setCashSettlementAmount);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeRosetta(getValuationMethod(), o.getValuationMethod(), this::setValuationMethod);
			merger.mergeRosetta(getValuationTime(), o.getValuationTime(), this::setValuationTime);
			
			merger.mergeBasic(getAccruedInterest(), o.getAccruedInterest(), this::setAccruedInterest);
			merger.mergeBasic(getCashSettlementMethod(), o.getCashSettlementMethod(), this::setCashSettlementMethod);
			merger.mergeBasic(getFixedSettlement(), o.getFixedSettlement(), this::setFixedSettlement);
			merger.mergeBasic(getRecoveryFactor(), o.getRecoveryFactor(), this::setRecoveryFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(accruedInterest, _that.getAccruedInterest())) return false;
			if (!Objects.equals(cashSettlementAmount, _that.getCashSettlementAmount())) return false;
			if (!Objects.equals(cashSettlementMethod, _that.getCashSettlementMethod())) return false;
			if (!Objects.equals(fixedSettlement, _that.getFixedSettlement())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(recoveryFactor, _that.getRecoveryFactor())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationMethod, _that.getValuationMethod())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accruedInterest != null ? accruedInterest.hashCode() : 0);
			_result = 31 * _result + (cashSettlementAmount != null ? cashSettlementAmount.hashCode() : 0);
			_result = 31 * _result + (cashSettlementMethod != null ? cashSettlementMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixedSettlement != null ? fixedSettlement.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (recoveryFactor != null ? recoveryFactor.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationMethod != null ? valuationMethod.hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementTermsBuilder {" +
				"accruedInterest=" + this.accruedInterest + ", " +
				"cashSettlementAmount=" + this.cashSettlementAmount + ", " +
				"cashSettlementMethod=" + this.cashSettlementMethod + ", " +
				"fixedSettlement=" + this.fixedSettlement + ", " +
				"meta=" + this.meta + ", " +
				"recoveryFactor=" + this.recoveryFactor + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationMethod=" + this.valuationMethod + ", " +
				"valuationTime=" + this.valuationTime +
			'}';
		}
	}
}
