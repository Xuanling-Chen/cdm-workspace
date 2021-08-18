package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.PostedCreditSupportItemMeta;
import cdm.observable.asset.Money;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Posted Credit Support item with corresponding Valuation Percentage, FX Haircut Percentage and any related disputed Posted Credit Support valuation.
 * @version ${project.version}
 */
@RosettaClass

public interface PostedCreditSupportItem extends RosettaModelObject {
	PostedCreditSupportItem build();
	PostedCreditSupportItem.PostedCreditSupportItemBuilder toBuilder();
	
	/**
	 * Percentage value of any additional haircut to be applied to a collateral asset,the percentage value is expressed as the discount haircut to the value of the collateral- as an example a 5% haircut would be expressed as 0.05. 
	 */
	BigDecimal getAdditionalHaircutPercentage();
	/**
	 * The Base Currency Equivalent of Cash or Security.
	 */
	Money getCashOrSecurityValue();
	/**
	 * Paragraph 5. If a party (a &#39;Disputing Party&#39;) disputes the Value of any Posted Credit Support (IM).
	 */
	Money getDisputedCashOrSecurityValue();
	/**
	 * FX Haircut Percentage means, for any item of Eligible Collateral (IM), the percentage specified in accordance with Paragraph 13.
	 */
	BigDecimal getFxHaircutPercentage();
	/**
	 * Valuation Percentage means, for any item of Eligible Collateral (IM), the percentage specified in accordance with Paragraph 13.
	 */
	BigDecimal getHaircutPercentage();
	final static PostedCreditSupportItemMeta metaData = new PostedCreditSupportItemMeta();
	
	@Override
	default RosettaMetaData<? extends PostedCreditSupportItem> metaData() {
		return metaData;
	} 
			
	static PostedCreditSupportItem.PostedCreditSupportItemBuilder builder() {
		return new PostedCreditSupportItem.PostedCreditSupportItemBuilderImpl();
	}
	
	default Class<? extends PostedCreditSupportItem> getType() {
		return PostedCreditSupportItem.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("additionalHaircutPercentage"), BigDecimal.class, getAdditionalHaircutPercentage(), this);
		processor.processBasic(path.newSubPath("fxHaircutPercentage"), BigDecimal.class, getFxHaircutPercentage(), this);
		processor.processBasic(path.newSubPath("haircutPercentage"), BigDecimal.class, getHaircutPercentage(), this);
		
		processRosetta(path.newSubPath("cashOrSecurityValue"), processor, Money.class, getCashOrSecurityValue());
		processRosetta(path.newSubPath("disputedCashOrSecurityValue"), processor, Money.class, getDisputedCashOrSecurityValue());
	}
	
	
	interface PostedCreditSupportItemBuilder extends PostedCreditSupportItem, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateCashOrSecurityValue();
		Money.MoneyBuilder getCashOrSecurityValue();
		Money.MoneyBuilder getOrCreateDisputedCashOrSecurityValue();
		Money.MoneyBuilder getDisputedCashOrSecurityValue();
		PostedCreditSupportItem.PostedCreditSupportItemBuilder setAdditionalHaircutPercentage(BigDecimal additionalHaircutPercentage);
		PostedCreditSupportItem.PostedCreditSupportItemBuilder setCashOrSecurityValue(Money cashOrSecurityValue);
		PostedCreditSupportItem.PostedCreditSupportItemBuilder setDisputedCashOrSecurityValue(Money disputedCashOrSecurityValue);
		PostedCreditSupportItem.PostedCreditSupportItemBuilder setFxHaircutPercentage(BigDecimal fxHaircutPercentage);
		PostedCreditSupportItem.PostedCreditSupportItemBuilder setHaircutPercentage(BigDecimal haircutPercentage);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("additionalHaircutPercentage"), BigDecimal.class, getAdditionalHaircutPercentage(), this);
			processor.processBasic(path.newSubPath("fxHaircutPercentage"), BigDecimal.class, getFxHaircutPercentage(), this);
			processor.processBasic(path.newSubPath("haircutPercentage"), BigDecimal.class, getHaircutPercentage(), this);
			
			processRosetta(path.newSubPath("cashOrSecurityValue"), processor, Money.MoneyBuilder.class, getCashOrSecurityValue());
			processRosetta(path.newSubPath("disputedCashOrSecurityValue"), processor, Money.MoneyBuilder.class, getDisputedCashOrSecurityValue());
		}
		
	}
	
	//PostedCreditSupportItem.PostedCreditSupportItemImpl
	class PostedCreditSupportItemImpl implements PostedCreditSupportItem {
		private final BigDecimal additionalHaircutPercentage;
		private final Money cashOrSecurityValue;
		private final Money disputedCashOrSecurityValue;
		private final BigDecimal fxHaircutPercentage;
		private final BigDecimal haircutPercentage;
		
		protected PostedCreditSupportItemImpl(PostedCreditSupportItem.PostedCreditSupportItemBuilder builder) {
			this.additionalHaircutPercentage = builder.getAdditionalHaircutPercentage();
			this.cashOrSecurityValue = ofNullable(builder.getCashOrSecurityValue()).map(f->f.build()).orElse(null);
			this.disputedCashOrSecurityValue = ofNullable(builder.getDisputedCashOrSecurityValue()).map(f->f.build()).orElse(null);
			this.fxHaircutPercentage = builder.getFxHaircutPercentage();
			this.haircutPercentage = builder.getHaircutPercentage();
		}
		
		@Override
		public BigDecimal getAdditionalHaircutPercentage() {
			return additionalHaircutPercentage;
		}
		
		@Override
		public Money getCashOrSecurityValue() {
			return cashOrSecurityValue;
		}
		
		@Override
		public Money getDisputedCashOrSecurityValue() {
			return disputedCashOrSecurityValue;
		}
		
		@Override
		public BigDecimal getFxHaircutPercentage() {
			return fxHaircutPercentage;
		}
		
		@Override
		public BigDecimal getHaircutPercentage() {
			return haircutPercentage;
		}
		
		@Override
		public PostedCreditSupportItem build() {
			return this;
		}
		
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder toBuilder() {
			PostedCreditSupportItem.PostedCreditSupportItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostedCreditSupportItem.PostedCreditSupportItemBuilder builder) {
			ofNullable(getAdditionalHaircutPercentage()).ifPresent(builder::setAdditionalHaircutPercentage);
			ofNullable(getCashOrSecurityValue()).ifPresent(builder::setCashOrSecurityValue);
			ofNullable(getDisputedCashOrSecurityValue()).ifPresent(builder::setDisputedCashOrSecurityValue);
			ofNullable(getFxHaircutPercentage()).ifPresent(builder::setFxHaircutPercentage);
			ofNullable(getHaircutPercentage()).ifPresent(builder::setHaircutPercentage);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostedCreditSupportItem _that = getType().cast(o);
		
			if (!Objects.equals(additionalHaircutPercentage, _that.getAdditionalHaircutPercentage())) return false;
			if (!Objects.equals(cashOrSecurityValue, _that.getCashOrSecurityValue())) return false;
			if (!Objects.equals(disputedCashOrSecurityValue, _that.getDisputedCashOrSecurityValue())) return false;
			if (!Objects.equals(fxHaircutPercentage, _that.getFxHaircutPercentage())) return false;
			if (!Objects.equals(haircutPercentage, _that.getHaircutPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalHaircutPercentage != null ? additionalHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (cashOrSecurityValue != null ? cashOrSecurityValue.hashCode() : 0);
			_result = 31 * _result + (disputedCashOrSecurityValue != null ? disputedCashOrSecurityValue.hashCode() : 0);
			_result = 31 * _result + (fxHaircutPercentage != null ? fxHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (haircutPercentage != null ? haircutPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostedCreditSupportItem {" +
				"additionalHaircutPercentage=" + this.additionalHaircutPercentage + ", " +
				"cashOrSecurityValue=" + this.cashOrSecurityValue + ", " +
				"disputedCashOrSecurityValue=" + this.disputedCashOrSecurityValue + ", " +
				"fxHaircutPercentage=" + this.fxHaircutPercentage + ", " +
				"haircutPercentage=" + this.haircutPercentage +
			'}';
		}
	}
	
	//PostedCreditSupportItem.PostedCreditSupportItemBuilderImpl
	class PostedCreditSupportItemBuilderImpl implements PostedCreditSupportItem.PostedCreditSupportItemBuilder {
	
		protected BigDecimal additionalHaircutPercentage;
		protected Money.MoneyBuilder cashOrSecurityValue;
		protected Money.MoneyBuilder disputedCashOrSecurityValue;
		protected BigDecimal fxHaircutPercentage;
		protected BigDecimal haircutPercentage;
	
		public PostedCreditSupportItemBuilderImpl() {
		}
	
		@Override
		public BigDecimal getAdditionalHaircutPercentage() {
			return additionalHaircutPercentage;
		}
		
		@Override
		public Money.MoneyBuilder getCashOrSecurityValue() {
			return cashOrSecurityValue;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCashOrSecurityValue() {
			Money.MoneyBuilder result;
			if (cashOrSecurityValue!=null) {
				result = cashOrSecurityValue;
			}
			else {
				result = cashOrSecurityValue = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public Money.MoneyBuilder getDisputedCashOrSecurityValue() {
			return disputedCashOrSecurityValue;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateDisputedCashOrSecurityValue() {
			Money.MoneyBuilder result;
			if (disputedCashOrSecurityValue!=null) {
				result = disputedCashOrSecurityValue;
			}
			else {
				result = disputedCashOrSecurityValue = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getFxHaircutPercentage() {
			return fxHaircutPercentage;
		}
		
		@Override
		public BigDecimal getHaircutPercentage() {
			return haircutPercentage;
		}
		
	
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder setAdditionalHaircutPercentage(BigDecimal additionalHaircutPercentage) {
			this.additionalHaircutPercentage = additionalHaircutPercentage==null?null:additionalHaircutPercentage;
			return this;
		}
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder setCashOrSecurityValue(Money cashOrSecurityValue) {
			this.cashOrSecurityValue = cashOrSecurityValue==null?null:cashOrSecurityValue.toBuilder();
			return this;
		}
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder setDisputedCashOrSecurityValue(Money disputedCashOrSecurityValue) {
			this.disputedCashOrSecurityValue = disputedCashOrSecurityValue==null?null:disputedCashOrSecurityValue.toBuilder();
			return this;
		}
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder setFxHaircutPercentage(BigDecimal fxHaircutPercentage) {
			this.fxHaircutPercentage = fxHaircutPercentage==null?null:fxHaircutPercentage;
			return this;
		}
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder setHaircutPercentage(BigDecimal haircutPercentage) {
			this.haircutPercentage = haircutPercentage==null?null:haircutPercentage;
			return this;
		}
		
		@Override
		public PostedCreditSupportItem build() {
			return new PostedCreditSupportItem.PostedCreditSupportItemImpl(this);
		}
		
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder prune() {
			if (cashOrSecurityValue!=null && !cashOrSecurityValue.prune().hasData()) cashOrSecurityValue = null;
			if (disputedCashOrSecurityValue!=null && !disputedCashOrSecurityValue.prune().hasData()) disputedCashOrSecurityValue = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalHaircutPercentage()!=null) return true;
			if (getCashOrSecurityValue()!=null && getCashOrSecurityValue().hasData()) return true;
			if (getDisputedCashOrSecurityValue()!=null && getDisputedCashOrSecurityValue().hasData()) return true;
			if (getFxHaircutPercentage()!=null) return true;
			if (getHaircutPercentage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PostedCreditSupportItem.PostedCreditSupportItemBuilder o = (PostedCreditSupportItem.PostedCreditSupportItemBuilder) other;
			
			merger.mergeRosetta(getCashOrSecurityValue(), o.getCashOrSecurityValue(), this::setCashOrSecurityValue);
			merger.mergeRosetta(getDisputedCashOrSecurityValue(), o.getDisputedCashOrSecurityValue(), this::setDisputedCashOrSecurityValue);
			
			merger.mergeBasic(getAdditionalHaircutPercentage(), o.getAdditionalHaircutPercentage(), this::setAdditionalHaircutPercentage);
			merger.mergeBasic(getFxHaircutPercentage(), o.getFxHaircutPercentage(), this::setFxHaircutPercentage);
			merger.mergeBasic(getHaircutPercentage(), o.getHaircutPercentage(), this::setHaircutPercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostedCreditSupportItem _that = getType().cast(o);
		
			if (!Objects.equals(additionalHaircutPercentage, _that.getAdditionalHaircutPercentage())) return false;
			if (!Objects.equals(cashOrSecurityValue, _that.getCashOrSecurityValue())) return false;
			if (!Objects.equals(disputedCashOrSecurityValue, _that.getDisputedCashOrSecurityValue())) return false;
			if (!Objects.equals(fxHaircutPercentage, _that.getFxHaircutPercentage())) return false;
			if (!Objects.equals(haircutPercentage, _that.getHaircutPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalHaircutPercentage != null ? additionalHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (cashOrSecurityValue != null ? cashOrSecurityValue.hashCode() : 0);
			_result = 31 * _result + (disputedCashOrSecurityValue != null ? disputedCashOrSecurityValue.hashCode() : 0);
			_result = 31 * _result + (fxHaircutPercentage != null ? fxHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (haircutPercentage != null ? haircutPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostedCreditSupportItemBuilder {" +
				"additionalHaircutPercentage=" + this.additionalHaircutPercentage + ", " +
				"cashOrSecurityValue=" + this.cashOrSecurityValue + ", " +
				"disputedCashOrSecurityValue=" + this.disputedCashOrSecurityValue + ", " +
				"fxHaircutPercentage=" + this.fxHaircutPercentage + ", " +
				"haircutPercentage=" + this.haircutPercentage +
			'}';
		}
	}
}
