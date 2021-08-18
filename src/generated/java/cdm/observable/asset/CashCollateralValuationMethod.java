package cdm.observable.asset;

import cdm.observable.asset.meta.CashCollateralValuationMethodMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * This type is a generic structure that can represent the parameters of several mid-market valuation and replacement value methods described in the 2021 ISDA Definitions.
 * @version ${project.version}
 */
@RosettaClass

public interface CashCollateralValuationMethod extends RosettaModelObject {
	CashCollateralValuationMethod build();
	CashCollateralValuationMethod.CashCollateralValuationMethodBuilder toBuilder();
	
	/**
	 * This may be used to indicate the discount rate to be used for cash collateral for cash settlement purposes.
	 */
	FieldWithMetaString getAgreedDiscountRate();
	/**
	 * This may be used to specify what type of CSA (credit support annex/agreement) is to be used for cash settlement purposes.
	 */
	CsaTypeEnum getApplicableCsa();
	/**
	 * This may be used to indicate the currency of cash collateral for cash settlement purposes.
	 */
	String getCashCollateralCurrency();
	/**
	 * This may be used to indicate the interest rate to be used for cash collateral for cash settlement purposes.
	 */
	FieldWithMetaString getCashCollateralInterestRate();
	/**
	 * This may be used to indicate that &#39;prescribed documentation adjustment&#39; is applicable.
	 */
	Boolean getPrescribedDocumentationAdjustment();
	/**
	 * This may be used to specify which party is protected (e.g. under Replacement Value cash settlement methods).
	 */
	List<? extends PartyDeterminationEnum> getProtectedParty();
	final static CashCollateralValuationMethodMeta metaData = new CashCollateralValuationMethodMeta();
	
	@Override
	default RosettaMetaData<? extends CashCollateralValuationMethod> metaData() {
		return metaData;
	} 
			
	static CashCollateralValuationMethod.CashCollateralValuationMethodBuilder builder() {
		return new CashCollateralValuationMethod.CashCollateralValuationMethodBuilderImpl();
	}
	
	default Class<? extends CashCollateralValuationMethod> getType() {
		return CashCollateralValuationMethod.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicableCsa"), CsaTypeEnum.class, getApplicableCsa(), this);
		processor.processBasic(path.newSubPath("cashCollateralCurrency"), String.class, getCashCollateralCurrency(), this);
		processor.processBasic(path.newSubPath("prescribedDocumentationAdjustment"), Boolean.class, getPrescribedDocumentationAdjustment(), this);
		processor.processBasic(path.newSubPath("protectedParty"), PartyDeterminationEnum.class, getProtectedParty(), this);
		
		processRosetta(path.newSubPath("agreedDiscountRate"), processor, FieldWithMetaString.class, getAgreedDiscountRate());
		processRosetta(path.newSubPath("cashCollateralInterestRate"), processor, FieldWithMetaString.class, getCashCollateralInterestRate());
	}
	
	
	interface CashCollateralValuationMethodBuilder extends CashCollateralValuationMethod, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateAgreedDiscountRate();
		FieldWithMetaStringBuilder getAgreedDiscountRate();
		FieldWithMetaStringBuilder getOrCreateCashCollateralInterestRate();
		FieldWithMetaStringBuilder getCashCollateralInterestRate();
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setAgreedDiscountRate(FieldWithMetaString agreedDiscountRate);
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setAgreedDiscountRateValue(String agreedDiscountRate);
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setApplicableCsa(CsaTypeEnum applicableCsa);
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setCashCollateralCurrency(String cashCollateralCurrency);
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setCashCollateralInterestRate(FieldWithMetaString cashCollateralInterestRate);
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setCashCollateralInterestRateValue(String cashCollateralInterestRate);
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setPrescribedDocumentationAdjustment(Boolean prescribedDocumentationAdjustment);
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder addProtectedParty(PartyDeterminationEnum protectedParty);
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder addProtectedParty(PartyDeterminationEnum protectedParty, int _idx);
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder addProtectedParty(List<? extends PartyDeterminationEnum> protectedParty);
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setProtectedParty(List<? extends PartyDeterminationEnum> protectedParty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("applicableCsa"), CsaTypeEnum.class, getApplicableCsa(), this);
			processor.processBasic(path.newSubPath("cashCollateralCurrency"), String.class, getCashCollateralCurrency(), this);
			processor.processBasic(path.newSubPath("prescribedDocumentationAdjustment"), Boolean.class, getPrescribedDocumentationAdjustment(), this);
			processor.processBasic(path.newSubPath("protectedParty"), PartyDeterminationEnum.class, getProtectedParty(), this);
			
			processRosetta(path.newSubPath("agreedDiscountRate"), processor, FieldWithMetaStringBuilder.class, getAgreedDiscountRate());
			processRosetta(path.newSubPath("cashCollateralInterestRate"), processor, FieldWithMetaStringBuilder.class, getCashCollateralInterestRate());
		}
		
	}
	
	//CashCollateralValuationMethod.CashCollateralValuationMethodImpl
	class CashCollateralValuationMethodImpl implements CashCollateralValuationMethod {
		private final FieldWithMetaString agreedDiscountRate;
		private final CsaTypeEnum applicableCsa;
		private final String cashCollateralCurrency;
		private final FieldWithMetaString cashCollateralInterestRate;
		private final Boolean prescribedDocumentationAdjustment;
		private final List<? extends PartyDeterminationEnum> protectedParty;
		
		protected CashCollateralValuationMethodImpl(CashCollateralValuationMethod.CashCollateralValuationMethodBuilder builder) {
			this.agreedDiscountRate = ofNullable(builder.getAgreedDiscountRate()).map(f->f.build()).orElse(null);
			this.applicableCsa = builder.getApplicableCsa();
			this.cashCollateralCurrency = builder.getCashCollateralCurrency();
			this.cashCollateralInterestRate = ofNullable(builder.getCashCollateralInterestRate()).map(f->f.build()).orElse(null);
			this.prescribedDocumentationAdjustment = builder.getPrescribedDocumentationAdjustment();
			this.protectedParty = ofNullable(builder.getProtectedParty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		public FieldWithMetaString getAgreedDiscountRate() {
			return agreedDiscountRate;
		}
		
		@Override
		public CsaTypeEnum getApplicableCsa() {
			return applicableCsa;
		}
		
		@Override
		public String getCashCollateralCurrency() {
			return cashCollateralCurrency;
		}
		
		@Override
		public FieldWithMetaString getCashCollateralInterestRate() {
			return cashCollateralInterestRate;
		}
		
		@Override
		public Boolean getPrescribedDocumentationAdjustment() {
			return prescribedDocumentationAdjustment;
		}
		
		@Override
		public List<? extends PartyDeterminationEnum> getProtectedParty() {
			return protectedParty;
		}
		
		@Override
		public CashCollateralValuationMethod build() {
			return this;
		}
		
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder toBuilder() {
			CashCollateralValuationMethod.CashCollateralValuationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashCollateralValuationMethod.CashCollateralValuationMethodBuilder builder) {
			ofNullable(getAgreedDiscountRate()).ifPresent(builder::setAgreedDiscountRate);
			ofNullable(getApplicableCsa()).ifPresent(builder::setApplicableCsa);
			ofNullable(getCashCollateralCurrency()).ifPresent(builder::setCashCollateralCurrency);
			ofNullable(getCashCollateralInterestRate()).ifPresent(builder::setCashCollateralInterestRate);
			ofNullable(getPrescribedDocumentationAdjustment()).ifPresent(builder::setPrescribedDocumentationAdjustment);
			ofNullable(getProtectedParty()).ifPresent(builder::setProtectedParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashCollateralValuationMethod _that = getType().cast(o);
		
			if (!Objects.equals(agreedDiscountRate, _that.getAgreedDiscountRate())) return false;
			if (!Objects.equals(applicableCsa, _that.getApplicableCsa())) return false;
			if (!Objects.equals(cashCollateralCurrency, _that.getCashCollateralCurrency())) return false;
			if (!Objects.equals(cashCollateralInterestRate, _that.getCashCollateralInterestRate())) return false;
			if (!Objects.equals(prescribedDocumentationAdjustment, _that.getPrescribedDocumentationAdjustment())) return false;
			if (!ListEquals.listEquals(protectedParty, _that.getProtectedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreedDiscountRate != null ? agreedDiscountRate.hashCode() : 0);
			_result = 31 * _result + (applicableCsa != null ? applicableCsa.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashCollateralCurrency != null ? cashCollateralCurrency.hashCode() : 0);
			_result = 31 * _result + (cashCollateralInterestRate != null ? cashCollateralInterestRate.hashCode() : 0);
			_result = 31 * _result + (prescribedDocumentationAdjustment != null ? prescribedDocumentationAdjustment.hashCode() : 0);
			_result = 31 * _result + (protectedParty != null ? protectedParty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashCollateralValuationMethod {" +
				"agreedDiscountRate=" + this.agreedDiscountRate + ", " +
				"applicableCsa=" + this.applicableCsa + ", " +
				"cashCollateralCurrency=" + this.cashCollateralCurrency + ", " +
				"cashCollateralInterestRate=" + this.cashCollateralInterestRate + ", " +
				"prescribedDocumentationAdjustment=" + this.prescribedDocumentationAdjustment + ", " +
				"protectedParty=" + this.protectedParty +
			'}';
		}
	}
	
	//CashCollateralValuationMethod.CashCollateralValuationMethodBuilderImpl
	class CashCollateralValuationMethodBuilderImpl implements CashCollateralValuationMethod.CashCollateralValuationMethodBuilder {
	
		protected FieldWithMetaStringBuilder agreedDiscountRate;
		protected CsaTypeEnum applicableCsa;
		protected String cashCollateralCurrency;
		protected FieldWithMetaStringBuilder cashCollateralInterestRate;
		protected Boolean prescribedDocumentationAdjustment;
		protected List<PartyDeterminationEnum> protectedParty = new ArrayList<>();
	
		public CashCollateralValuationMethodBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getAgreedDiscountRate() {
			return agreedDiscountRate;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateAgreedDiscountRate() {
			FieldWithMetaStringBuilder result;
			if (agreedDiscountRate!=null) {
				result = agreedDiscountRate;
			}
			else {
				result = agreedDiscountRate = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public CsaTypeEnum getApplicableCsa() {
			return applicableCsa;
		}
		
		@Override
		public String getCashCollateralCurrency() {
			return cashCollateralCurrency;
		}
		
		@Override
		public FieldWithMetaStringBuilder getCashCollateralInterestRate() {
			return cashCollateralInterestRate;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateCashCollateralInterestRate() {
			FieldWithMetaStringBuilder result;
			if (cashCollateralInterestRate!=null) {
				result = cashCollateralInterestRate;
			}
			else {
				result = cashCollateralInterestRate = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getPrescribedDocumentationAdjustment() {
			return prescribedDocumentationAdjustment;
		}
		
		@Override
		public List<? extends PartyDeterminationEnum> getProtectedParty() {
			return protectedParty;
		}
		
	
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setAgreedDiscountRate(FieldWithMetaString agreedDiscountRate) {
			this.agreedDiscountRate = agreedDiscountRate==null?null:agreedDiscountRate.toBuilder();
			return this;
		}
		
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setAgreedDiscountRateValue(String agreedDiscountRate) {
			this.getOrCreateAgreedDiscountRate().setValue(agreedDiscountRate);
			return this;
		}
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setApplicableCsa(CsaTypeEnum applicableCsa) {
			this.applicableCsa = applicableCsa==null?null:applicableCsa;
			return this;
		}
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setCashCollateralCurrency(String cashCollateralCurrency) {
			this.cashCollateralCurrency = cashCollateralCurrency==null?null:cashCollateralCurrency;
			return this;
		}
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setCashCollateralInterestRate(FieldWithMetaString cashCollateralInterestRate) {
			this.cashCollateralInterestRate = cashCollateralInterestRate==null?null:cashCollateralInterestRate.toBuilder();
			return this;
		}
		
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setCashCollateralInterestRateValue(String cashCollateralInterestRate) {
			this.getOrCreateCashCollateralInterestRate().setValue(cashCollateralInterestRate);
			return this;
		}
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setPrescribedDocumentationAdjustment(Boolean prescribedDocumentationAdjustment) {
			this.prescribedDocumentationAdjustment = prescribedDocumentationAdjustment==null?null:prescribedDocumentationAdjustment;
			return this;
		}
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder addProtectedParty(PartyDeterminationEnum protectedParty) {
			if (protectedParty!=null) this.protectedParty.add(protectedParty);
			return this;
		}
		
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder addProtectedParty(PartyDeterminationEnum protectedParty, int _idx) {
			getIndex(this.protectedParty, _idx, () -> protectedParty);
			return this;
		}
		@Override 
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder addProtectedParty(List<? extends PartyDeterminationEnum> protectedPartys) {
			if (protectedPartys != null) {
				for (PartyDeterminationEnum toAdd : protectedPartys) {
					this.protectedParty.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder setProtectedParty(List<? extends PartyDeterminationEnum> protectedPartys) {
			if (protectedPartys == null)  {
				this.protectedParty = new ArrayList<>();
			}
			else {
				this.protectedParty = protectedPartys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CashCollateralValuationMethod build() {
			return new CashCollateralValuationMethod.CashCollateralValuationMethodImpl(this);
		}
		
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder prune() {
			if (agreedDiscountRate!=null && !agreedDiscountRate.prune().hasData()) agreedDiscountRate = null;
			if (cashCollateralInterestRate!=null && !cashCollateralInterestRate.prune().hasData()) cashCollateralInterestRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAgreedDiscountRate()!=null) return true;
			if (getApplicableCsa()!=null) return true;
			if (getCashCollateralCurrency()!=null) return true;
			if (getCashCollateralInterestRate()!=null) return true;
			if (getPrescribedDocumentationAdjustment()!=null) return true;
			if (getProtectedParty()!=null && !getProtectedParty().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashCollateralValuationMethod.CashCollateralValuationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashCollateralValuationMethod.CashCollateralValuationMethodBuilder o = (CashCollateralValuationMethod.CashCollateralValuationMethodBuilder) other;
			
			merger.mergeRosetta(getAgreedDiscountRate(), o.getAgreedDiscountRate(), this::setAgreedDiscountRate);
			merger.mergeRosetta(getCashCollateralInterestRate(), o.getCashCollateralInterestRate(), this::setCashCollateralInterestRate);
			
			merger.mergeBasic(getApplicableCsa(), o.getApplicableCsa(), this::setApplicableCsa);
			merger.mergeBasic(getCashCollateralCurrency(), o.getCashCollateralCurrency(), this::setCashCollateralCurrency);
			merger.mergeBasic(getPrescribedDocumentationAdjustment(), o.getPrescribedDocumentationAdjustment(), this::setPrescribedDocumentationAdjustment);
			merger.mergeBasic(getProtectedParty(), o.getProtectedParty(), (Consumer<PartyDeterminationEnum>) this::addProtectedParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashCollateralValuationMethod _that = getType().cast(o);
		
			if (!Objects.equals(agreedDiscountRate, _that.getAgreedDiscountRate())) return false;
			if (!Objects.equals(applicableCsa, _that.getApplicableCsa())) return false;
			if (!Objects.equals(cashCollateralCurrency, _that.getCashCollateralCurrency())) return false;
			if (!Objects.equals(cashCollateralInterestRate, _that.getCashCollateralInterestRate())) return false;
			if (!Objects.equals(prescribedDocumentationAdjustment, _that.getPrescribedDocumentationAdjustment())) return false;
			if (!ListEquals.listEquals(protectedParty, _that.getProtectedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreedDiscountRate != null ? agreedDiscountRate.hashCode() : 0);
			_result = 31 * _result + (applicableCsa != null ? applicableCsa.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashCollateralCurrency != null ? cashCollateralCurrency.hashCode() : 0);
			_result = 31 * _result + (cashCollateralInterestRate != null ? cashCollateralInterestRate.hashCode() : 0);
			_result = 31 * _result + (prescribedDocumentationAdjustment != null ? prescribedDocumentationAdjustment.hashCode() : 0);
			_result = 31 * _result + (protectedParty != null ? protectedParty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashCollateralValuationMethodBuilder {" +
				"agreedDiscountRate=" + this.agreedDiscountRate + ", " +
				"applicableCsa=" + this.applicableCsa + ", " +
				"cashCollateralCurrency=" + this.cashCollateralCurrency + ", " +
				"cashCollateralInterestRate=" + this.cashCollateralInterestRate + ", " +
				"prescribedDocumentationAdjustment=" + this.prescribedDocumentationAdjustment + ", " +
				"protectedParty=" + this.protectedParty +
			'}';
		}
	}
}
