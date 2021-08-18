package cdm.product.asset;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.asset.meta.DividendReturnTermsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.BasicReferenceWithMetaDate;
import com.rosetta.model.metafields.BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class describing the conditions governing the payment of dividends to the receiver of the equity return, with the exception of the dividend payout ratio, which is defined for each of the underlying components.
 * @version ${project.version}
 */
@RosettaClass

public interface DividendReturnTerms extends RosettaModelObject {
	DividendReturnTerms build();
	DividendReturnTerms.DividendReturnTermsBuilder toBuilder();
	
	/**
	 * Specifies whether the dividend is paid with respect to the Dividend Period.
	 */
	DividendAmountTypeEnum getDividendAmountType();
	/**
	 * Specifies the currency in which the dividend will be denominated, e.g. the dividend currency, or a specified currency. This class is not specified as such in FpML, which makes use of the CurrencyAndDeterminationMethod.model to specify such terms.
	 */
	DividendCurrency getDividendCurrency();
	/**
	 * Defines the date on which the receiver of the equity return is entitled to the dividend.
	 */
	DividendEntitlementEnum getDividendEntitlement();
	/**
	 * Specifies when the dividend will be paid to the receiver of the equity return. Has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. Is not applicable in the case of a dividend reinvestment election.
	 */
	DividendPaymentDate getDividendPaymentDate();
	/**
	 * Specifies the dividend payout ratio associated with the underlier. In FpML 5.10 the payout is positioned at the underlier level, although there is an intent to reconsider this approach and position it at the leg level. This is approach adopted by the CDM.
	 */
	DividendPayout getDividendPayout();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Dividend Period as either the First Period or the Second Period. | 
	 */
	DividendPeriodEnum getDividendPeriod();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Dividend Period as such other period determined as provided in the related Confirmation. | 
	 */
	BasicReferenceWithMetaDate getDividendPeriodEffectiveDate();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Dividend Period as such other period determined as provided in the related Confirmation.
	 */
	BasicReferenceWithMetaDate getDividendPeriodEndDate();
	/**
	 * Boolean element that defines whether the dividend will be reinvested or not.
	 */
	Boolean getDividendReinvestment();
	/**
	 * Determination of Gross Cash Dividend per Share.
	 */
	DividendAmountTypeEnum getExcessDividendAmount();
	/**
	 * Specifies the party which determines if dividends are extraordinary in relation to normal levels.
	 */
	AncillaryRoleEnum getExtraordinaryDividendsParty();
	final static DividendReturnTermsMeta metaData = new DividendReturnTermsMeta();
	
	@Override
	default RosettaMetaData<? extends DividendReturnTerms> metaData() {
		return metaData;
	} 
			
	static DividendReturnTerms.DividendReturnTermsBuilder builder() {
		return new DividendReturnTerms.DividendReturnTermsBuilderImpl();
	}
	
	default Class<? extends DividendReturnTerms> getType() {
		return DividendReturnTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dividendAmountType"), DividendAmountTypeEnum.class, getDividendAmountType(), this);
		processor.processBasic(path.newSubPath("dividendEntitlement"), DividendEntitlementEnum.class, getDividendEntitlement(), this);
		processor.processBasic(path.newSubPath("dividendPeriod"), DividendPeriodEnum.class, getDividendPeriod(), this);
		processor.processBasic(path.newSubPath("dividendReinvestment"), Boolean.class, getDividendReinvestment(), this);
		processor.processBasic(path.newSubPath("excessDividendAmount"), DividendAmountTypeEnum.class, getExcessDividendAmount(), this);
		processor.processBasic(path.newSubPath("extraordinaryDividendsParty"), AncillaryRoleEnum.class, getExtraordinaryDividendsParty(), this);
		
		processRosetta(path.newSubPath("dividendCurrency"), processor, DividendCurrency.class, getDividendCurrency());
		processRosetta(path.newSubPath("dividendPaymentDate"), processor, DividendPaymentDate.class, getDividendPaymentDate());
		processRosetta(path.newSubPath("dividendPayout"), processor, DividendPayout.class, getDividendPayout());
		processRosetta(path.newSubPath("dividendPeriodEffectiveDate"), processor, BasicReferenceWithMetaDate.class, getDividendPeriodEffectiveDate());
		processRosetta(path.newSubPath("dividendPeriodEndDate"), processor, BasicReferenceWithMetaDate.class, getDividendPeriodEndDate());
	}
	
	
	interface DividendReturnTermsBuilder extends DividendReturnTerms, RosettaModelObjectBuilder {
		DividendCurrency.DividendCurrencyBuilder getOrCreateDividendCurrency();
		DividendCurrency.DividendCurrencyBuilder getDividendCurrency();
		DividendPaymentDate.DividendPaymentDateBuilder getOrCreateDividendPaymentDate();
		DividendPaymentDate.DividendPaymentDateBuilder getDividendPaymentDate();
		DividendPayout.DividendPayoutBuilder getOrCreateDividendPayout();
		DividendPayout.DividendPayoutBuilder getDividendPayout();
		BasicReferenceWithMetaDateBuilder getOrCreateDividendPeriodEffectiveDate();
		BasicReferenceWithMetaDateBuilder getDividendPeriodEffectiveDate();
		BasicReferenceWithMetaDateBuilder getOrCreateDividendPeriodEndDate();
		BasicReferenceWithMetaDateBuilder getDividendPeriodEndDate();
		DividendReturnTerms.DividendReturnTermsBuilder setDividendAmountType(DividendAmountTypeEnum dividendAmountType);
		DividendReturnTerms.DividendReturnTermsBuilder setDividendCurrency(DividendCurrency dividendCurrency);
		DividendReturnTerms.DividendReturnTermsBuilder setDividendEntitlement(DividendEntitlementEnum dividendEntitlement);
		DividendReturnTerms.DividendReturnTermsBuilder setDividendPaymentDate(DividendPaymentDate dividendPaymentDate);
		DividendReturnTerms.DividendReturnTermsBuilder setDividendPayout(DividendPayout dividendPayout);
		DividendReturnTerms.DividendReturnTermsBuilder setDividendPeriod(DividendPeriodEnum dividendPeriod);
		DividendReturnTerms.DividendReturnTermsBuilder setDividendPeriodEffectiveDate(BasicReferenceWithMetaDate dividendPeriodEffectiveDate);
		DividendReturnTerms.DividendReturnTermsBuilder setDividendPeriodEffectiveDateValue(Date dividendPeriodEffectiveDate);
		DividendReturnTerms.DividendReturnTermsBuilder setDividendPeriodEndDate(BasicReferenceWithMetaDate dividendPeriodEndDate);
		DividendReturnTerms.DividendReturnTermsBuilder setDividendPeriodEndDateValue(Date dividendPeriodEndDate);
		DividendReturnTerms.DividendReturnTermsBuilder setDividendReinvestment(Boolean dividendReinvestment);
		DividendReturnTerms.DividendReturnTermsBuilder setExcessDividendAmount(DividendAmountTypeEnum excessDividendAmount);
		DividendReturnTerms.DividendReturnTermsBuilder setExtraordinaryDividendsParty(AncillaryRoleEnum extraordinaryDividendsParty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("dividendAmountType"), DividendAmountTypeEnum.class, getDividendAmountType(), this);
			processor.processBasic(path.newSubPath("dividendEntitlement"), DividendEntitlementEnum.class, getDividendEntitlement(), this);
			processor.processBasic(path.newSubPath("dividendPeriod"), DividendPeriodEnum.class, getDividendPeriod(), this);
			processor.processBasic(path.newSubPath("dividendReinvestment"), Boolean.class, getDividendReinvestment(), this);
			processor.processBasic(path.newSubPath("excessDividendAmount"), DividendAmountTypeEnum.class, getExcessDividendAmount(), this);
			processor.processBasic(path.newSubPath("extraordinaryDividendsParty"), AncillaryRoleEnum.class, getExtraordinaryDividendsParty(), this);
			
			processRosetta(path.newSubPath("dividendCurrency"), processor, DividendCurrency.DividendCurrencyBuilder.class, getDividendCurrency());
			processRosetta(path.newSubPath("dividendPaymentDate"), processor, DividendPaymentDate.DividendPaymentDateBuilder.class, getDividendPaymentDate());
			processRosetta(path.newSubPath("dividendPayout"), processor, DividendPayout.DividendPayoutBuilder.class, getDividendPayout());
			processRosetta(path.newSubPath("dividendPeriodEffectiveDate"), processor, BasicReferenceWithMetaDateBuilder.class, getDividendPeriodEffectiveDate());
			processRosetta(path.newSubPath("dividendPeriodEndDate"), processor, BasicReferenceWithMetaDateBuilder.class, getDividendPeriodEndDate());
		}
		
	}
	
	//DividendReturnTerms.DividendReturnTermsImpl
	class DividendReturnTermsImpl implements DividendReturnTerms {
		private final DividendAmountTypeEnum dividendAmountType;
		private final DividendCurrency dividendCurrency;
		private final DividendEntitlementEnum dividendEntitlement;
		private final DividendPaymentDate dividendPaymentDate;
		private final DividendPayout dividendPayout;
		private final DividendPeriodEnum dividendPeriod;
		private final BasicReferenceWithMetaDate dividendPeriodEffectiveDate;
		private final BasicReferenceWithMetaDate dividendPeriodEndDate;
		private final Boolean dividendReinvestment;
		private final DividendAmountTypeEnum excessDividendAmount;
		private final AncillaryRoleEnum extraordinaryDividendsParty;
		
		protected DividendReturnTermsImpl(DividendReturnTerms.DividendReturnTermsBuilder builder) {
			this.dividendAmountType = builder.getDividendAmountType();
			this.dividendCurrency = ofNullable(builder.getDividendCurrency()).map(f->f.build()).orElse(null);
			this.dividendEntitlement = builder.getDividendEntitlement();
			this.dividendPaymentDate = ofNullable(builder.getDividendPaymentDate()).map(f->f.build()).orElse(null);
			this.dividendPayout = ofNullable(builder.getDividendPayout()).map(f->f.build()).orElse(null);
			this.dividendPeriod = builder.getDividendPeriod();
			this.dividendPeriodEffectiveDate = ofNullable(builder.getDividendPeriodEffectiveDate()).map(f->f.build()).orElse(null);
			this.dividendPeriodEndDate = ofNullable(builder.getDividendPeriodEndDate()).map(f->f.build()).orElse(null);
			this.dividendReinvestment = builder.getDividendReinvestment();
			this.excessDividendAmount = builder.getExcessDividendAmount();
			this.extraordinaryDividendsParty = builder.getExtraordinaryDividendsParty();
		}
		
		@Override
		public DividendAmountTypeEnum getDividendAmountType() {
			return dividendAmountType;
		}
		
		@Override
		public DividendCurrency getDividendCurrency() {
			return dividendCurrency;
		}
		
		@Override
		public DividendEntitlementEnum getDividendEntitlement() {
			return dividendEntitlement;
		}
		
		@Override
		public DividendPaymentDate getDividendPaymentDate() {
			return dividendPaymentDate;
		}
		
		@Override
		public DividendPayout getDividendPayout() {
			return dividendPayout;
		}
		
		@Override
		public DividendPeriodEnum getDividendPeriod() {
			return dividendPeriod;
		}
		
		@Override
		public BasicReferenceWithMetaDate getDividendPeriodEffectiveDate() {
			return dividendPeriodEffectiveDate;
		}
		
		@Override
		public BasicReferenceWithMetaDate getDividendPeriodEndDate() {
			return dividendPeriodEndDate;
		}
		
		@Override
		public Boolean getDividendReinvestment() {
			return dividendReinvestment;
		}
		
		@Override
		public DividendAmountTypeEnum getExcessDividendAmount() {
			return excessDividendAmount;
		}
		
		@Override
		public AncillaryRoleEnum getExtraordinaryDividendsParty() {
			return extraordinaryDividendsParty;
		}
		
		@Override
		public DividendReturnTerms build() {
			return this;
		}
		
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder toBuilder() {
			DividendReturnTerms.DividendReturnTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendReturnTerms.DividendReturnTermsBuilder builder) {
			ofNullable(getDividendAmountType()).ifPresent(builder::setDividendAmountType);
			ofNullable(getDividendCurrency()).ifPresent(builder::setDividendCurrency);
			ofNullable(getDividendEntitlement()).ifPresent(builder::setDividendEntitlement);
			ofNullable(getDividendPaymentDate()).ifPresent(builder::setDividendPaymentDate);
			ofNullable(getDividendPayout()).ifPresent(builder::setDividendPayout);
			ofNullable(getDividendPeriod()).ifPresent(builder::setDividendPeriod);
			ofNullable(getDividendPeriodEffectiveDate()).ifPresent(builder::setDividendPeriodEffectiveDate);
			ofNullable(getDividendPeriodEndDate()).ifPresent(builder::setDividendPeriodEndDate);
			ofNullable(getDividendReinvestment()).ifPresent(builder::setDividendReinvestment);
			ofNullable(getExcessDividendAmount()).ifPresent(builder::setExcessDividendAmount);
			ofNullable(getExtraordinaryDividendsParty()).ifPresent(builder::setExtraordinaryDividendsParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(dividendAmountType, _that.getDividendAmountType())) return false;
			if (!Objects.equals(dividendCurrency, _that.getDividendCurrency())) return false;
			if (!Objects.equals(dividendEntitlement, _that.getDividendEntitlement())) return false;
			if (!Objects.equals(dividendPaymentDate, _that.getDividendPaymentDate())) return false;
			if (!Objects.equals(dividendPayout, _that.getDividendPayout())) return false;
			if (!Objects.equals(dividendPeriod, _that.getDividendPeriod())) return false;
			if (!Objects.equals(dividendPeriodEffectiveDate, _that.getDividendPeriodEffectiveDate())) return false;
			if (!Objects.equals(dividendPeriodEndDate, _that.getDividendPeriodEndDate())) return false;
			if (!Objects.equals(dividendReinvestment, _that.getDividendReinvestment())) return false;
			if (!Objects.equals(excessDividendAmount, _that.getExcessDividendAmount())) return false;
			if (!Objects.equals(extraordinaryDividendsParty, _that.getExtraordinaryDividendsParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendAmountType != null ? dividendAmountType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendCurrency != null ? dividendCurrency.hashCode() : 0);
			_result = 31 * _result + (dividendEntitlement != null ? dividendEntitlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendPaymentDate != null ? dividendPaymentDate.hashCode() : 0);
			_result = 31 * _result + (dividendPayout != null ? dividendPayout.hashCode() : 0);
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendPeriodEffectiveDate != null ? dividendPeriodEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (dividendPeriodEndDate != null ? dividendPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (dividendReinvestment != null ? dividendReinvestment.hashCode() : 0);
			_result = 31 * _result + (excessDividendAmount != null ? excessDividendAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extraordinaryDividendsParty != null ? extraordinaryDividendsParty.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendReturnTerms {" +
				"dividendAmountType=" + this.dividendAmountType + ", " +
				"dividendCurrency=" + this.dividendCurrency + ", " +
				"dividendEntitlement=" + this.dividendEntitlement + ", " +
				"dividendPaymentDate=" + this.dividendPaymentDate + ", " +
				"dividendPayout=" + this.dividendPayout + ", " +
				"dividendPeriod=" + this.dividendPeriod + ", " +
				"dividendPeriodEffectiveDate=" + this.dividendPeriodEffectiveDate + ", " +
				"dividendPeriodEndDate=" + this.dividendPeriodEndDate + ", " +
				"dividendReinvestment=" + this.dividendReinvestment + ", " +
				"excessDividendAmount=" + this.excessDividendAmount + ", " +
				"extraordinaryDividendsParty=" + this.extraordinaryDividendsParty +
			'}';
		}
	}
	
	//DividendReturnTerms.DividendReturnTermsBuilderImpl
	class DividendReturnTermsBuilderImpl implements DividendReturnTerms.DividendReturnTermsBuilder {
	
		protected DividendAmountTypeEnum dividendAmountType;
		protected DividendCurrency.DividendCurrencyBuilder dividendCurrency;
		protected DividendEntitlementEnum dividendEntitlement;
		protected DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate;
		protected DividendPayout.DividendPayoutBuilder dividendPayout;
		protected DividendPeriodEnum dividendPeriod;
		protected BasicReferenceWithMetaDateBuilder dividendPeriodEffectiveDate;
		protected BasicReferenceWithMetaDateBuilder dividendPeriodEndDate;
		protected Boolean dividendReinvestment;
		protected DividendAmountTypeEnum excessDividendAmount;
		protected AncillaryRoleEnum extraordinaryDividendsParty;
	
		public DividendReturnTermsBuilderImpl() {
		}
	
		@Override
		public DividendAmountTypeEnum getDividendAmountType() {
			return dividendAmountType;
		}
		
		@Override
		public DividendCurrency.DividendCurrencyBuilder getDividendCurrency() {
			return dividendCurrency;
		}
		
		@Override
		public DividendCurrency.DividendCurrencyBuilder getOrCreateDividendCurrency() {
			DividendCurrency.DividendCurrencyBuilder result;
			if (dividendCurrency!=null) {
				result = dividendCurrency;
			}
			else {
				result = dividendCurrency = DividendCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		public DividendEntitlementEnum getDividendEntitlement() {
			return dividendEntitlement;
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder getDividendPaymentDate() {
			return dividendPaymentDate;
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder getOrCreateDividendPaymentDate() {
			DividendPaymentDate.DividendPaymentDateBuilder result;
			if (dividendPaymentDate!=null) {
				result = dividendPaymentDate;
			}
			else {
				result = dividendPaymentDate = DividendPaymentDate.builder();
			}
			
			return result;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder getDividendPayout() {
			return dividendPayout;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder getOrCreateDividendPayout() {
			DividendPayout.DividendPayoutBuilder result;
			if (dividendPayout!=null) {
				result = dividendPayout;
			}
			else {
				result = dividendPayout = DividendPayout.builder();
			}
			
			return result;
		}
		
		@Override
		public DividendPeriodEnum getDividendPeriod() {
			return dividendPeriod;
		}
		
		@Override
		public BasicReferenceWithMetaDateBuilder getDividendPeriodEffectiveDate() {
			return dividendPeriodEffectiveDate;
		}
		
		@Override
		public BasicReferenceWithMetaDateBuilder getOrCreateDividendPeriodEffectiveDate() {
			BasicReferenceWithMetaDateBuilder result;
			if (dividendPeriodEffectiveDate!=null) {
				result = dividendPeriodEffectiveDate;
			}
			else {
				result = dividendPeriodEffectiveDate = BasicReferenceWithMetaDate.builder();
			}
			
			return result;
		}
		
		@Override
		public BasicReferenceWithMetaDateBuilder getDividendPeriodEndDate() {
			return dividendPeriodEndDate;
		}
		
		@Override
		public BasicReferenceWithMetaDateBuilder getOrCreateDividendPeriodEndDate() {
			BasicReferenceWithMetaDateBuilder result;
			if (dividendPeriodEndDate!=null) {
				result = dividendPeriodEndDate;
			}
			else {
				result = dividendPeriodEndDate = BasicReferenceWithMetaDate.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getDividendReinvestment() {
			return dividendReinvestment;
		}
		
		@Override
		public DividendAmountTypeEnum getExcessDividendAmount() {
			return excessDividendAmount;
		}
		
		@Override
		public AncillaryRoleEnum getExtraordinaryDividendsParty() {
			return extraordinaryDividendsParty;
		}
		
	
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setDividendAmountType(DividendAmountTypeEnum dividendAmountType) {
			this.dividendAmountType = dividendAmountType==null?null:dividendAmountType;
			return this;
		}
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setDividendCurrency(DividendCurrency dividendCurrency) {
			this.dividendCurrency = dividendCurrency==null?null:dividendCurrency.toBuilder();
			return this;
		}
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setDividendEntitlement(DividendEntitlementEnum dividendEntitlement) {
			this.dividendEntitlement = dividendEntitlement==null?null:dividendEntitlement;
			return this;
		}
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setDividendPaymentDate(DividendPaymentDate dividendPaymentDate) {
			this.dividendPaymentDate = dividendPaymentDate==null?null:dividendPaymentDate.toBuilder();
			return this;
		}
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setDividendPayout(DividendPayout dividendPayout) {
			this.dividendPayout = dividendPayout==null?null:dividendPayout.toBuilder();
			return this;
		}
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setDividendPeriod(DividendPeriodEnum dividendPeriod) {
			this.dividendPeriod = dividendPeriod==null?null:dividendPeriod;
			return this;
		}
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setDividendPeriodEffectiveDate(BasicReferenceWithMetaDate dividendPeriodEffectiveDate) {
			this.dividendPeriodEffectiveDate = dividendPeriodEffectiveDate==null?null:dividendPeriodEffectiveDate.toBuilder();
			return this;
		}
		
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setDividendPeriodEffectiveDateValue(Date dividendPeriodEffectiveDate) {
			this.getOrCreateDividendPeriodEffectiveDate().setValue(dividendPeriodEffectiveDate);
			return this;
		}
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setDividendPeriodEndDate(BasicReferenceWithMetaDate dividendPeriodEndDate) {
			this.dividendPeriodEndDate = dividendPeriodEndDate==null?null:dividendPeriodEndDate.toBuilder();
			return this;
		}
		
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setDividendPeriodEndDateValue(Date dividendPeriodEndDate) {
			this.getOrCreateDividendPeriodEndDate().setValue(dividendPeriodEndDate);
			return this;
		}
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setDividendReinvestment(Boolean dividendReinvestment) {
			this.dividendReinvestment = dividendReinvestment==null?null:dividendReinvestment;
			return this;
		}
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setExcessDividendAmount(DividendAmountTypeEnum excessDividendAmount) {
			this.excessDividendAmount = excessDividendAmount==null?null:excessDividendAmount;
			return this;
		}
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder setExtraordinaryDividendsParty(AncillaryRoleEnum extraordinaryDividendsParty) {
			this.extraordinaryDividendsParty = extraordinaryDividendsParty==null?null:extraordinaryDividendsParty;
			return this;
		}
		
		@Override
		public DividendReturnTerms build() {
			return new DividendReturnTerms.DividendReturnTermsImpl(this);
		}
		
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder prune() {
			if (dividendCurrency!=null && !dividendCurrency.prune().hasData()) dividendCurrency = null;
			if (dividendPaymentDate!=null && !dividendPaymentDate.prune().hasData()) dividendPaymentDate = null;
			if (dividendPayout!=null && !dividendPayout.prune().hasData()) dividendPayout = null;
			if (dividendPeriodEffectiveDate!=null && !dividendPeriodEffectiveDate.prune().hasData()) dividendPeriodEffectiveDate = null;
			if (dividendPeriodEndDate!=null && !dividendPeriodEndDate.prune().hasData()) dividendPeriodEndDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendAmountType()!=null) return true;
			if (getDividendCurrency()!=null && getDividendCurrency().hasData()) return true;
			if (getDividendEntitlement()!=null) return true;
			if (getDividendPaymentDate()!=null && getDividendPaymentDate().hasData()) return true;
			if (getDividendPayout()!=null && getDividendPayout().hasData()) return true;
			if (getDividendPeriod()!=null) return true;
			if (getDividendPeriodEffectiveDate()!=null) return true;
			if (getDividendPeriodEndDate()!=null) return true;
			if (getDividendReinvestment()!=null) return true;
			if (getExcessDividendAmount()!=null) return true;
			if (getExtraordinaryDividendsParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendReturnTerms.DividendReturnTermsBuilder o = (DividendReturnTerms.DividendReturnTermsBuilder) other;
			
			merger.mergeRosetta(getDividendCurrency(), o.getDividendCurrency(), this::setDividendCurrency);
			merger.mergeRosetta(getDividendPaymentDate(), o.getDividendPaymentDate(), this::setDividendPaymentDate);
			merger.mergeRosetta(getDividendPayout(), o.getDividendPayout(), this::setDividendPayout);
			merger.mergeRosetta(getDividendPeriodEffectiveDate(), o.getDividendPeriodEffectiveDate(), this::setDividendPeriodEffectiveDate);
			merger.mergeRosetta(getDividendPeriodEndDate(), o.getDividendPeriodEndDate(), this::setDividendPeriodEndDate);
			
			merger.mergeBasic(getDividendAmountType(), o.getDividendAmountType(), this::setDividendAmountType);
			merger.mergeBasic(getDividendEntitlement(), o.getDividendEntitlement(), this::setDividendEntitlement);
			merger.mergeBasic(getDividendPeriod(), o.getDividendPeriod(), this::setDividendPeriod);
			merger.mergeBasic(getDividendReinvestment(), o.getDividendReinvestment(), this::setDividendReinvestment);
			merger.mergeBasic(getExcessDividendAmount(), o.getExcessDividendAmount(), this::setExcessDividendAmount);
			merger.mergeBasic(getExtraordinaryDividendsParty(), o.getExtraordinaryDividendsParty(), this::setExtraordinaryDividendsParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(dividendAmountType, _that.getDividendAmountType())) return false;
			if (!Objects.equals(dividendCurrency, _that.getDividendCurrency())) return false;
			if (!Objects.equals(dividendEntitlement, _that.getDividendEntitlement())) return false;
			if (!Objects.equals(dividendPaymentDate, _that.getDividendPaymentDate())) return false;
			if (!Objects.equals(dividendPayout, _that.getDividendPayout())) return false;
			if (!Objects.equals(dividendPeriod, _that.getDividendPeriod())) return false;
			if (!Objects.equals(dividendPeriodEffectiveDate, _that.getDividendPeriodEffectiveDate())) return false;
			if (!Objects.equals(dividendPeriodEndDate, _that.getDividendPeriodEndDate())) return false;
			if (!Objects.equals(dividendReinvestment, _that.getDividendReinvestment())) return false;
			if (!Objects.equals(excessDividendAmount, _that.getExcessDividendAmount())) return false;
			if (!Objects.equals(extraordinaryDividendsParty, _that.getExtraordinaryDividendsParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendAmountType != null ? dividendAmountType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendCurrency != null ? dividendCurrency.hashCode() : 0);
			_result = 31 * _result + (dividendEntitlement != null ? dividendEntitlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendPaymentDate != null ? dividendPaymentDate.hashCode() : 0);
			_result = 31 * _result + (dividendPayout != null ? dividendPayout.hashCode() : 0);
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendPeriodEffectiveDate != null ? dividendPeriodEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (dividendPeriodEndDate != null ? dividendPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (dividendReinvestment != null ? dividendReinvestment.hashCode() : 0);
			_result = 31 * _result + (excessDividendAmount != null ? excessDividendAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extraordinaryDividendsParty != null ? extraordinaryDividendsParty.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendReturnTermsBuilder {" +
				"dividendAmountType=" + this.dividendAmountType + ", " +
				"dividendCurrency=" + this.dividendCurrency + ", " +
				"dividendEntitlement=" + this.dividendEntitlement + ", " +
				"dividendPaymentDate=" + this.dividendPaymentDate + ", " +
				"dividendPayout=" + this.dividendPayout + ", " +
				"dividendPeriod=" + this.dividendPeriod + ", " +
				"dividendPeriodEffectiveDate=" + this.dividendPeriodEffectiveDate + ", " +
				"dividendPeriodEndDate=" + this.dividendPeriodEndDate + ", " +
				"dividendReinvestment=" + this.dividendReinvestment + ", " +
				"excessDividendAmount=" + this.excessDividendAmount + ", " +
				"extraordinaryDividendsParty=" + this.extraordinaryDividendsParty +
			'}';
		}
	}
}
