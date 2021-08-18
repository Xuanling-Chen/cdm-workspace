package cdm.product.template;

import cdm.observable.asset.Money;
import cdm.product.asset.DividendEntitlementEnum;
import cdm.product.asset.DividendPayout;
import cdm.product.template.meta.DividendTermsMeta;
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
 * Information related to dividends and payments.
 * @version ${project.version}
 */
@RosettaClass

public interface DividendTerms extends RosettaModelObject {
	DividendTerms build();
	DividendTerms.DividendTermsBuilder toBuilder();
	
	/**
	 * Defines the date on which the receiver of the equity return is entitled to the dividend.
	 */
	DividendEntitlementEnum getDividendEntitlement();
	/**
	 * Specifies the proportion of the value of the dividend on the borrowed shares that the borrower is legally obligated to return to the lender.
	 */
	DividendPayout getManufacturedIncomeRequirement();
	/**
	 * daily fee increments accrue until a threshold is crossed, at which point payment becomes due)
	 */
	Money getMinimumBillingAmount();
	final static DividendTermsMeta metaData = new DividendTermsMeta();
	
	@Override
	default RosettaMetaData<? extends DividendTerms> metaData() {
		return metaData;
	} 
			
	static DividendTerms.DividendTermsBuilder builder() {
		return new DividendTerms.DividendTermsBuilderImpl();
	}
	
	default Class<? extends DividendTerms> getType() {
		return DividendTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dividendEntitlement"), DividendEntitlementEnum.class, getDividendEntitlement(), this);
		
		processRosetta(path.newSubPath("manufacturedIncomeRequirement"), processor, DividendPayout.class, getManufacturedIncomeRequirement());
		processRosetta(path.newSubPath("minimumBillingAmount"), processor, Money.class, getMinimumBillingAmount());
	}
	
	
	interface DividendTermsBuilder extends DividendTerms, RosettaModelObjectBuilder {
		DividendPayout.DividendPayoutBuilder getOrCreateManufacturedIncomeRequirement();
		DividendPayout.DividendPayoutBuilder getManufacturedIncomeRequirement();
		Money.MoneyBuilder getOrCreateMinimumBillingAmount();
		Money.MoneyBuilder getMinimumBillingAmount();
		DividendTerms.DividendTermsBuilder setDividendEntitlement(DividendEntitlementEnum dividendEntitlement);
		DividendTerms.DividendTermsBuilder setManufacturedIncomeRequirement(DividendPayout manufacturedIncomeRequirement);
		DividendTerms.DividendTermsBuilder setMinimumBillingAmount(Money minimumBillingAmount);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("dividendEntitlement"), DividendEntitlementEnum.class, getDividendEntitlement(), this);
			
			processRosetta(path.newSubPath("manufacturedIncomeRequirement"), processor, DividendPayout.DividendPayoutBuilder.class, getManufacturedIncomeRequirement());
			processRosetta(path.newSubPath("minimumBillingAmount"), processor, Money.MoneyBuilder.class, getMinimumBillingAmount());
		}
		
	}
	
	//DividendTerms.DividendTermsImpl
	class DividendTermsImpl implements DividendTerms {
		private final DividendEntitlementEnum dividendEntitlement;
		private final DividendPayout manufacturedIncomeRequirement;
		private final Money minimumBillingAmount;
		
		protected DividendTermsImpl(DividendTerms.DividendTermsBuilder builder) {
			this.dividendEntitlement = builder.getDividendEntitlement();
			this.manufacturedIncomeRequirement = ofNullable(builder.getManufacturedIncomeRequirement()).map(f->f.build()).orElse(null);
			this.minimumBillingAmount = ofNullable(builder.getMinimumBillingAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public DividendEntitlementEnum getDividendEntitlement() {
			return dividendEntitlement;
		}
		
		@Override
		public DividendPayout getManufacturedIncomeRequirement() {
			return manufacturedIncomeRequirement;
		}
		
		@Override
		public Money getMinimumBillingAmount() {
			return minimumBillingAmount;
		}
		
		@Override
		public DividendTerms build() {
			return this;
		}
		
		@Override
		public DividendTerms.DividendTermsBuilder toBuilder() {
			DividendTerms.DividendTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendTerms.DividendTermsBuilder builder) {
			ofNullable(getDividendEntitlement()).ifPresent(builder::setDividendEntitlement);
			ofNullable(getManufacturedIncomeRequirement()).ifPresent(builder::setManufacturedIncomeRequirement);
			ofNullable(getMinimumBillingAmount()).ifPresent(builder::setMinimumBillingAmount);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendTerms _that = getType().cast(o);
		
			if (!Objects.equals(dividendEntitlement, _that.getDividendEntitlement())) return false;
			if (!Objects.equals(manufacturedIncomeRequirement, _that.getManufacturedIncomeRequirement())) return false;
			if (!Objects.equals(minimumBillingAmount, _that.getMinimumBillingAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendEntitlement != null ? dividendEntitlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (manufacturedIncomeRequirement != null ? manufacturedIncomeRequirement.hashCode() : 0);
			_result = 31 * _result + (minimumBillingAmount != null ? minimumBillingAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendTerms {" +
				"dividendEntitlement=" + this.dividendEntitlement + ", " +
				"manufacturedIncomeRequirement=" + this.manufacturedIncomeRequirement + ", " +
				"minimumBillingAmount=" + this.minimumBillingAmount +
			'}';
		}
	}
	
	//DividendTerms.DividendTermsBuilderImpl
	class DividendTermsBuilderImpl implements DividendTerms.DividendTermsBuilder {
	
		protected DividendEntitlementEnum dividendEntitlement;
		protected DividendPayout.DividendPayoutBuilder manufacturedIncomeRequirement;
		protected Money.MoneyBuilder minimumBillingAmount;
	
		public DividendTermsBuilderImpl() {
		}
	
		@Override
		public DividendEntitlementEnum getDividendEntitlement() {
			return dividendEntitlement;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder getManufacturedIncomeRequirement() {
			return manufacturedIncomeRequirement;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder getOrCreateManufacturedIncomeRequirement() {
			DividendPayout.DividendPayoutBuilder result;
			if (manufacturedIncomeRequirement!=null) {
				result = manufacturedIncomeRequirement;
			}
			else {
				result = manufacturedIncomeRequirement = DividendPayout.builder();
			}
			
			return result;
		}
		
		@Override
		public Money.MoneyBuilder getMinimumBillingAmount() {
			return minimumBillingAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateMinimumBillingAmount() {
			Money.MoneyBuilder result;
			if (minimumBillingAmount!=null) {
				result = minimumBillingAmount;
			}
			else {
				result = minimumBillingAmount = Money.builder();
			}
			
			return result;
		}
		
	
		@Override
		public DividendTerms.DividendTermsBuilder setDividendEntitlement(DividendEntitlementEnum dividendEntitlement) {
			this.dividendEntitlement = dividendEntitlement==null?null:dividendEntitlement;
			return this;
		}
		@Override
		public DividendTerms.DividendTermsBuilder setManufacturedIncomeRequirement(DividendPayout manufacturedIncomeRequirement) {
			this.manufacturedIncomeRequirement = manufacturedIncomeRequirement==null?null:manufacturedIncomeRequirement.toBuilder();
			return this;
		}
		@Override
		public DividendTerms.DividendTermsBuilder setMinimumBillingAmount(Money minimumBillingAmount) {
			this.minimumBillingAmount = minimumBillingAmount==null?null:minimumBillingAmount.toBuilder();
			return this;
		}
		
		@Override
		public DividendTerms build() {
			return new DividendTerms.DividendTermsImpl(this);
		}
		
		@Override
		public DividendTerms.DividendTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendTerms.DividendTermsBuilder prune() {
			if (manufacturedIncomeRequirement!=null && !manufacturedIncomeRequirement.prune().hasData()) manufacturedIncomeRequirement = null;
			if (minimumBillingAmount!=null && !minimumBillingAmount.prune().hasData()) minimumBillingAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendEntitlement()!=null) return true;
			if (getManufacturedIncomeRequirement()!=null && getManufacturedIncomeRequirement().hasData()) return true;
			if (getMinimumBillingAmount()!=null && getMinimumBillingAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendTerms.DividendTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendTerms.DividendTermsBuilder o = (DividendTerms.DividendTermsBuilder) other;
			
			merger.mergeRosetta(getManufacturedIncomeRequirement(), o.getManufacturedIncomeRequirement(), this::setManufacturedIncomeRequirement);
			merger.mergeRosetta(getMinimumBillingAmount(), o.getMinimumBillingAmount(), this::setMinimumBillingAmount);
			
			merger.mergeBasic(getDividendEntitlement(), o.getDividendEntitlement(), this::setDividendEntitlement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendTerms _that = getType().cast(o);
		
			if (!Objects.equals(dividendEntitlement, _that.getDividendEntitlement())) return false;
			if (!Objects.equals(manufacturedIncomeRequirement, _that.getManufacturedIncomeRequirement())) return false;
			if (!Objects.equals(minimumBillingAmount, _that.getMinimumBillingAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendEntitlement != null ? dividendEntitlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (manufacturedIncomeRequirement != null ? manufacturedIncomeRequirement.hashCode() : 0);
			_result = 31 * _result + (minimumBillingAmount != null ? minimumBillingAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendTermsBuilder {" +
				"dividendEntitlement=" + this.dividendEntitlement + ", " +
				"manufacturedIncomeRequirement=" + this.manufacturedIncomeRequirement + ", " +
				"minimumBillingAmount=" + this.minimumBillingAmount +
			'}';
		}
	}
}
