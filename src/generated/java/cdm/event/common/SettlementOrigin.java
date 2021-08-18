package cdm.event.common;

import cdm.event.common.meta.SettlementOriginMeta;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.metafields.ReferenceWithMetaInterestRatePayout;
import cdm.product.asset.metafields.ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashSettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashflow;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashflow.ReferenceWithMetaCashflowBuilder;
import cdm.product.common.settlement.metafields.ReferenceWithMetaPhysicalSettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder;
import cdm.product.common.settlement.metafields.ReferenceWithMetaSettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder;
import cdm.product.template.EquityPayout;
import cdm.product.template.EquityPayout;
import cdm.product.template.SecurityFinancePayout;
import cdm.product.template.SecurityFinancePayout;
import cdm.product.template.SecurityPayout;
import cdm.product.template.SecurityPayout;
import cdm.product.template.metafields.ReferenceWithMetaEquityPayout;
import cdm.product.template.metafields.ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder;
import cdm.product.template.metafields.ReferenceWithMetaSecurityFinancePayout;
import cdm.product.template.metafields.ReferenceWithMetaSecurityFinancePayout.ReferenceWithMetaSecurityFinancePayoutBuilder;
import cdm.product.template.metafields.ReferenceWithMetaSecurityPayout;
import cdm.product.template.metafields.ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder;
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
 * Defines the various model elements where transfers can arrise.
 * @version ${project.version}
 */
@RosettaClass

public interface SettlementOrigin extends RosettaModelObject {
	SettlementOrigin build();
	SettlementOrigin.SettlementOriginBuilder toBuilder();
	
	/**
	 * Represents a reference to cash settlement terms.
	 */
	ReferenceWithMetaCashSettlementTerms getCashSettlementTerms();
	/**
	 * Represents a reference to an Cashflow Payout.
	 */
	ReferenceWithMetaCashflow getCashflow();
	/**
	 * Represents a reference to an Equity Payout.
	 */
	ReferenceWithMetaEquityPayout getEquityPayout();
	/**
	 * Represents a reference to an Interest Rate Payout.
	 */
	ReferenceWithMetaInterestRatePayout getInterestRatePayout();
	/**
	 * Represents a reference to physical settlement terms.
	 */
	ReferenceWithMetaPhysicalSettlementTerms getPhysicalSettlementTerms();
	/**
	 * Represents a reference to a Security Lending Payout.
	 */
	ReferenceWithMetaSecurityFinancePayout getSecurityFinancePayout();
	/**
	 * Represents a reference to a Security Payout.
	 */
	ReferenceWithMetaSecurityPayout getSecurityPayout();
	/**
	 * Represents a reference to settlement terms, which may have been specified at execution.
	 */
	ReferenceWithMetaSettlementTerms getSettlementTerms();
	final static SettlementOriginMeta metaData = new SettlementOriginMeta();
	
	@Override
	default RosettaMetaData<? extends SettlementOrigin> metaData() {
		return metaData;
	} 
			
	static SettlementOrigin.SettlementOriginBuilder builder() {
		return new SettlementOrigin.SettlementOriginBuilderImpl();
	}
	
	default Class<? extends SettlementOrigin> getType() {
		return SettlementOrigin.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("cashSettlementTerms"), processor, ReferenceWithMetaCashSettlementTerms.class, getCashSettlementTerms());
		processRosetta(path.newSubPath("cashflow"), processor, ReferenceWithMetaCashflow.class, getCashflow());
		processRosetta(path.newSubPath("equityPayout"), processor, ReferenceWithMetaEquityPayout.class, getEquityPayout());
		processRosetta(path.newSubPath("interestRatePayout"), processor, ReferenceWithMetaInterestRatePayout.class, getInterestRatePayout());
		processRosetta(path.newSubPath("physicalSettlementTerms"), processor, ReferenceWithMetaPhysicalSettlementTerms.class, getPhysicalSettlementTerms());
		processRosetta(path.newSubPath("securityFinancePayout"), processor, ReferenceWithMetaSecurityFinancePayout.class, getSecurityFinancePayout());
		processRosetta(path.newSubPath("securityPayout"), processor, ReferenceWithMetaSecurityPayout.class, getSecurityPayout());
		processRosetta(path.newSubPath("settlementTerms"), processor, ReferenceWithMetaSettlementTerms.class, getSettlementTerms());
	}
	
	
	interface SettlementOriginBuilder extends SettlementOrigin, RosettaModelObjectBuilder {
		ReferenceWithMetaCashSettlementTermsBuilder getOrCreateCashSettlementTerms();
		ReferenceWithMetaCashSettlementTermsBuilder getCashSettlementTerms();
		ReferenceWithMetaCashflowBuilder getOrCreateCashflow();
		ReferenceWithMetaCashflowBuilder getCashflow();
		ReferenceWithMetaEquityPayoutBuilder getOrCreateEquityPayout();
		ReferenceWithMetaEquityPayoutBuilder getEquityPayout();
		ReferenceWithMetaInterestRatePayoutBuilder getOrCreateInterestRatePayout();
		ReferenceWithMetaInterestRatePayoutBuilder getInterestRatePayout();
		ReferenceWithMetaPhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTerms();
		ReferenceWithMetaPhysicalSettlementTermsBuilder getPhysicalSettlementTerms();
		ReferenceWithMetaSecurityFinancePayoutBuilder getOrCreateSecurityFinancePayout();
		ReferenceWithMetaSecurityFinancePayoutBuilder getSecurityFinancePayout();
		ReferenceWithMetaSecurityPayoutBuilder getOrCreateSecurityPayout();
		ReferenceWithMetaSecurityPayoutBuilder getSecurityPayout();
		ReferenceWithMetaSettlementTermsBuilder getOrCreateSettlementTerms();
		ReferenceWithMetaSettlementTermsBuilder getSettlementTerms();
		SettlementOrigin.SettlementOriginBuilder setCashSettlementTerms(ReferenceWithMetaCashSettlementTerms cashSettlementTerms);
		SettlementOrigin.SettlementOriginBuilder setCashSettlementTermsValue(CashSettlementTerms cashSettlementTerms);
		SettlementOrigin.SettlementOriginBuilder setCashflow(ReferenceWithMetaCashflow cashflow);
		SettlementOrigin.SettlementOriginBuilder setCashflowValue(Cashflow cashflow);
		SettlementOrigin.SettlementOriginBuilder setEquityPayout(ReferenceWithMetaEquityPayout equityPayout);
		SettlementOrigin.SettlementOriginBuilder setEquityPayoutValue(EquityPayout equityPayout);
		SettlementOrigin.SettlementOriginBuilder setInterestRatePayout(ReferenceWithMetaInterestRatePayout interestRatePayout);
		SettlementOrigin.SettlementOriginBuilder setInterestRatePayoutValue(InterestRatePayout interestRatePayout);
		SettlementOrigin.SettlementOriginBuilder setPhysicalSettlementTerms(ReferenceWithMetaPhysicalSettlementTerms physicalSettlementTerms);
		SettlementOrigin.SettlementOriginBuilder setPhysicalSettlementTermsValue(PhysicalSettlementTerms physicalSettlementTerms);
		SettlementOrigin.SettlementOriginBuilder setSecurityFinancePayout(ReferenceWithMetaSecurityFinancePayout securityFinancePayout);
		SettlementOrigin.SettlementOriginBuilder setSecurityFinancePayoutValue(SecurityFinancePayout securityFinancePayout);
		SettlementOrigin.SettlementOriginBuilder setSecurityPayout(ReferenceWithMetaSecurityPayout securityPayout);
		SettlementOrigin.SettlementOriginBuilder setSecurityPayoutValue(SecurityPayout securityPayout);
		SettlementOrigin.SettlementOriginBuilder setSettlementTerms(ReferenceWithMetaSettlementTerms settlementTerms);
		SettlementOrigin.SettlementOriginBuilder setSettlementTermsValue(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("cashSettlementTerms"), processor, ReferenceWithMetaCashSettlementTermsBuilder.class, getCashSettlementTerms());
			processRosetta(path.newSubPath("cashflow"), processor, ReferenceWithMetaCashflowBuilder.class, getCashflow());
			processRosetta(path.newSubPath("equityPayout"), processor, ReferenceWithMetaEquityPayoutBuilder.class, getEquityPayout());
			processRosetta(path.newSubPath("interestRatePayout"), processor, ReferenceWithMetaInterestRatePayoutBuilder.class, getInterestRatePayout());
			processRosetta(path.newSubPath("physicalSettlementTerms"), processor, ReferenceWithMetaPhysicalSettlementTermsBuilder.class, getPhysicalSettlementTerms());
			processRosetta(path.newSubPath("securityFinancePayout"), processor, ReferenceWithMetaSecurityFinancePayoutBuilder.class, getSecurityFinancePayout());
			processRosetta(path.newSubPath("securityPayout"), processor, ReferenceWithMetaSecurityPayoutBuilder.class, getSecurityPayout());
			processRosetta(path.newSubPath("settlementTerms"), processor, ReferenceWithMetaSettlementTermsBuilder.class, getSettlementTerms());
		}
		
	}
	
	//SettlementOrigin.SettlementOriginImpl
	class SettlementOriginImpl implements SettlementOrigin {
		private final ReferenceWithMetaCashSettlementTerms cashSettlementTerms;
		private final ReferenceWithMetaCashflow cashflow;
		private final ReferenceWithMetaEquityPayout equityPayout;
		private final ReferenceWithMetaInterestRatePayout interestRatePayout;
		private final ReferenceWithMetaPhysicalSettlementTerms physicalSettlementTerms;
		private final ReferenceWithMetaSecurityFinancePayout securityFinancePayout;
		private final ReferenceWithMetaSecurityPayout securityPayout;
		private final ReferenceWithMetaSettlementTerms settlementTerms;
		
		protected SettlementOriginImpl(SettlementOrigin.SettlementOriginBuilder builder) {
			this.cashSettlementTerms = ofNullable(builder.getCashSettlementTerms()).map(f->f.build()).orElse(null);
			this.cashflow = ofNullable(builder.getCashflow()).map(f->f.build()).orElse(null);
			this.equityPayout = ofNullable(builder.getEquityPayout()).map(f->f.build()).orElse(null);
			this.interestRatePayout = ofNullable(builder.getInterestRatePayout()).map(f->f.build()).orElse(null);
			this.physicalSettlementTerms = ofNullable(builder.getPhysicalSettlementTerms()).map(f->f.build()).orElse(null);
			this.securityFinancePayout = ofNullable(builder.getSecurityFinancePayout()).map(f->f.build()).orElse(null);
			this.securityPayout = ofNullable(builder.getSecurityPayout()).map(f->f.build()).orElse(null);
			this.settlementTerms = ofNullable(builder.getSettlementTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaCashSettlementTerms getCashSettlementTerms() {
			return cashSettlementTerms;
		}
		
		@Override
		public ReferenceWithMetaCashflow getCashflow() {
			return cashflow;
		}
		
		@Override
		public ReferenceWithMetaEquityPayout getEquityPayout() {
			return equityPayout;
		}
		
		@Override
		public ReferenceWithMetaInterestRatePayout getInterestRatePayout() {
			return interestRatePayout;
		}
		
		@Override
		public ReferenceWithMetaPhysicalSettlementTerms getPhysicalSettlementTerms() {
			return physicalSettlementTerms;
		}
		
		@Override
		public ReferenceWithMetaSecurityFinancePayout getSecurityFinancePayout() {
			return securityFinancePayout;
		}
		
		@Override
		public ReferenceWithMetaSecurityPayout getSecurityPayout() {
			return securityPayout;
		}
		
		@Override
		public ReferenceWithMetaSettlementTerms getSettlementTerms() {
			return settlementTerms;
		}
		
		@Override
		public SettlementOrigin build() {
			return this;
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder toBuilder() {
			SettlementOrigin.SettlementOriginBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementOrigin.SettlementOriginBuilder builder) {
			ofNullable(getCashSettlementTerms()).ifPresent(builder::setCashSettlementTerms);
			ofNullable(getCashflow()).ifPresent(builder::setCashflow);
			ofNullable(getEquityPayout()).ifPresent(builder::setEquityPayout);
			ofNullable(getInterestRatePayout()).ifPresent(builder::setInterestRatePayout);
			ofNullable(getPhysicalSettlementTerms()).ifPresent(builder::setPhysicalSettlementTerms);
			ofNullable(getSecurityFinancePayout()).ifPresent(builder::setSecurityFinancePayout);
			ofNullable(getSecurityPayout()).ifPresent(builder::setSecurityPayout);
			ofNullable(getSettlementTerms()).ifPresent(builder::setSettlementTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementOrigin _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementTerms, _that.getCashSettlementTerms())) return false;
			if (!Objects.equals(cashflow, _that.getCashflow())) return false;
			if (!Objects.equals(equityPayout, _that.getEquityPayout())) return false;
			if (!Objects.equals(interestRatePayout, _that.getInterestRatePayout())) return false;
			if (!Objects.equals(physicalSettlementTerms, _that.getPhysicalSettlementTerms())) return false;
			if (!Objects.equals(securityFinancePayout, _that.getSecurityFinancePayout())) return false;
			if (!Objects.equals(securityPayout, _that.getSecurityPayout())) return false;
			if (!Objects.equals(settlementTerms, _that.getSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementTerms != null ? cashSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (cashflow != null ? cashflow.hashCode() : 0);
			_result = 31 * _result + (equityPayout != null ? equityPayout.hashCode() : 0);
			_result = 31 * _result + (interestRatePayout != null ? interestRatePayout.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTerms != null ? physicalSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (securityFinancePayout != null ? securityFinancePayout.hashCode() : 0);
			_result = 31 * _result + (securityPayout != null ? securityPayout.hashCode() : 0);
			_result = 31 * _result + (settlementTerms != null ? settlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementOrigin {" +
				"cashSettlementTerms=" + this.cashSettlementTerms + ", " +
				"cashflow=" + this.cashflow + ", " +
				"equityPayout=" + this.equityPayout + ", " +
				"interestRatePayout=" + this.interestRatePayout + ", " +
				"physicalSettlementTerms=" + this.physicalSettlementTerms + ", " +
				"securityFinancePayout=" + this.securityFinancePayout + ", " +
				"securityPayout=" + this.securityPayout + ", " +
				"settlementTerms=" + this.settlementTerms +
			'}';
		}
	}
	
	//SettlementOrigin.SettlementOriginBuilderImpl
	class SettlementOriginBuilderImpl implements SettlementOrigin.SettlementOriginBuilder {
	
		protected ReferenceWithMetaCashSettlementTermsBuilder cashSettlementTerms;
		protected ReferenceWithMetaCashflowBuilder cashflow;
		protected ReferenceWithMetaEquityPayoutBuilder equityPayout;
		protected ReferenceWithMetaInterestRatePayoutBuilder interestRatePayout;
		protected ReferenceWithMetaPhysicalSettlementTermsBuilder physicalSettlementTerms;
		protected ReferenceWithMetaSecurityFinancePayoutBuilder securityFinancePayout;
		protected ReferenceWithMetaSecurityPayoutBuilder securityPayout;
		protected ReferenceWithMetaSettlementTermsBuilder settlementTerms;
	
		public SettlementOriginBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaCashSettlementTermsBuilder getCashSettlementTerms() {
			return cashSettlementTerms;
		}
		
		@Override
		public ReferenceWithMetaCashSettlementTermsBuilder getOrCreateCashSettlementTerms() {
			ReferenceWithMetaCashSettlementTermsBuilder result;
			if (cashSettlementTerms!=null) {
				result = cashSettlementTerms;
			}
			else {
				result = cashSettlementTerms = ReferenceWithMetaCashSettlementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaCashflowBuilder getCashflow() {
			return cashflow;
		}
		
		@Override
		public ReferenceWithMetaCashflowBuilder getOrCreateCashflow() {
			ReferenceWithMetaCashflowBuilder result;
			if (cashflow!=null) {
				result = cashflow;
			}
			else {
				result = cashflow = ReferenceWithMetaCashflow.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaEquityPayoutBuilder getEquityPayout() {
			return equityPayout;
		}
		
		@Override
		public ReferenceWithMetaEquityPayoutBuilder getOrCreateEquityPayout() {
			ReferenceWithMetaEquityPayoutBuilder result;
			if (equityPayout!=null) {
				result = equityPayout;
			}
			else {
				result = equityPayout = ReferenceWithMetaEquityPayout.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaInterestRatePayoutBuilder getInterestRatePayout() {
			return interestRatePayout;
		}
		
		@Override
		public ReferenceWithMetaInterestRatePayoutBuilder getOrCreateInterestRatePayout() {
			ReferenceWithMetaInterestRatePayoutBuilder result;
			if (interestRatePayout!=null) {
				result = interestRatePayout;
			}
			else {
				result = interestRatePayout = ReferenceWithMetaInterestRatePayout.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaPhysicalSettlementTermsBuilder getPhysicalSettlementTerms() {
			return physicalSettlementTerms;
		}
		
		@Override
		public ReferenceWithMetaPhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTerms() {
			ReferenceWithMetaPhysicalSettlementTermsBuilder result;
			if (physicalSettlementTerms!=null) {
				result = physicalSettlementTerms;
			}
			else {
				result = physicalSettlementTerms = ReferenceWithMetaPhysicalSettlementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaSecurityFinancePayoutBuilder getSecurityFinancePayout() {
			return securityFinancePayout;
		}
		
		@Override
		public ReferenceWithMetaSecurityFinancePayoutBuilder getOrCreateSecurityFinancePayout() {
			ReferenceWithMetaSecurityFinancePayoutBuilder result;
			if (securityFinancePayout!=null) {
				result = securityFinancePayout;
			}
			else {
				result = securityFinancePayout = ReferenceWithMetaSecurityFinancePayout.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaSecurityPayoutBuilder getSecurityPayout() {
			return securityPayout;
		}
		
		@Override
		public ReferenceWithMetaSecurityPayoutBuilder getOrCreateSecurityPayout() {
			ReferenceWithMetaSecurityPayoutBuilder result;
			if (securityPayout!=null) {
				result = securityPayout;
			}
			else {
				result = securityPayout = ReferenceWithMetaSecurityPayout.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaSettlementTermsBuilder getSettlementTerms() {
			return settlementTerms;
		}
		
		@Override
		public ReferenceWithMetaSettlementTermsBuilder getOrCreateSettlementTerms() {
			ReferenceWithMetaSettlementTermsBuilder result;
			if (settlementTerms!=null) {
				result = settlementTerms;
			}
			else {
				result = settlementTerms = ReferenceWithMetaSettlementTerms.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SettlementOrigin.SettlementOriginBuilder setCashSettlementTerms(ReferenceWithMetaCashSettlementTerms cashSettlementTerms) {
			this.cashSettlementTerms = cashSettlementTerms==null?null:cashSettlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder setCashSettlementTermsValue(CashSettlementTerms cashSettlementTerms) {
			this.getOrCreateCashSettlementTerms().setValue(cashSettlementTerms);
			return this;
		}
		@Override
		public SettlementOrigin.SettlementOriginBuilder setCashflow(ReferenceWithMetaCashflow cashflow) {
			this.cashflow = cashflow==null?null:cashflow.toBuilder();
			return this;
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder setCashflowValue(Cashflow cashflow) {
			this.getOrCreateCashflow().setValue(cashflow);
			return this;
		}
		@Override
		public SettlementOrigin.SettlementOriginBuilder setEquityPayout(ReferenceWithMetaEquityPayout equityPayout) {
			this.equityPayout = equityPayout==null?null:equityPayout.toBuilder();
			return this;
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder setEquityPayoutValue(EquityPayout equityPayout) {
			this.getOrCreateEquityPayout().setValue(equityPayout);
			return this;
		}
		@Override
		public SettlementOrigin.SettlementOriginBuilder setInterestRatePayout(ReferenceWithMetaInterestRatePayout interestRatePayout) {
			this.interestRatePayout = interestRatePayout==null?null:interestRatePayout.toBuilder();
			return this;
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder setInterestRatePayoutValue(InterestRatePayout interestRatePayout) {
			this.getOrCreateInterestRatePayout().setValue(interestRatePayout);
			return this;
		}
		@Override
		public SettlementOrigin.SettlementOriginBuilder setPhysicalSettlementTerms(ReferenceWithMetaPhysicalSettlementTerms physicalSettlementTerms) {
			this.physicalSettlementTerms = physicalSettlementTerms==null?null:physicalSettlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder setPhysicalSettlementTermsValue(PhysicalSettlementTerms physicalSettlementTerms) {
			this.getOrCreatePhysicalSettlementTerms().setValue(physicalSettlementTerms);
			return this;
		}
		@Override
		public SettlementOrigin.SettlementOriginBuilder setSecurityFinancePayout(ReferenceWithMetaSecurityFinancePayout securityFinancePayout) {
			this.securityFinancePayout = securityFinancePayout==null?null:securityFinancePayout.toBuilder();
			return this;
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder setSecurityFinancePayoutValue(SecurityFinancePayout securityFinancePayout) {
			this.getOrCreateSecurityFinancePayout().setValue(securityFinancePayout);
			return this;
		}
		@Override
		public SettlementOrigin.SettlementOriginBuilder setSecurityPayout(ReferenceWithMetaSecurityPayout securityPayout) {
			this.securityPayout = securityPayout==null?null:securityPayout.toBuilder();
			return this;
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder setSecurityPayoutValue(SecurityPayout securityPayout) {
			this.getOrCreateSecurityPayout().setValue(securityPayout);
			return this;
		}
		@Override
		public SettlementOrigin.SettlementOriginBuilder setSettlementTerms(ReferenceWithMetaSettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder setSettlementTermsValue(SettlementTerms settlementTerms) {
			this.getOrCreateSettlementTerms().setValue(settlementTerms);
			return this;
		}
		
		@Override
		public SettlementOrigin build() {
			return new SettlementOrigin.SettlementOriginImpl(this);
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementOrigin.SettlementOriginBuilder prune() {
			if (cashSettlementTerms!=null && !cashSettlementTerms.prune().hasData()) cashSettlementTerms = null;
			if (cashflow!=null && !cashflow.prune().hasData()) cashflow = null;
			if (equityPayout!=null && !equityPayout.prune().hasData()) equityPayout = null;
			if (interestRatePayout!=null && !interestRatePayout.prune().hasData()) interestRatePayout = null;
			if (physicalSettlementTerms!=null && !physicalSettlementTerms.prune().hasData()) physicalSettlementTerms = null;
			if (securityFinancePayout!=null && !securityFinancePayout.prune().hasData()) securityFinancePayout = null;
			if (securityPayout!=null && !securityPayout.prune().hasData()) securityPayout = null;
			if (settlementTerms!=null && !settlementTerms.prune().hasData()) settlementTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementTerms()!=null && getCashSettlementTerms().hasData()) return true;
			if (getCashflow()!=null && getCashflow().hasData()) return true;
			if (getEquityPayout()!=null && getEquityPayout().hasData()) return true;
			if (getInterestRatePayout()!=null && getInterestRatePayout().hasData()) return true;
			if (getPhysicalSettlementTerms()!=null && getPhysicalSettlementTerms().hasData()) return true;
			if (getSecurityFinancePayout()!=null && getSecurityFinancePayout().hasData()) return true;
			if (getSecurityPayout()!=null && getSecurityPayout().hasData()) return true;
			if (getSettlementTerms()!=null && getSettlementTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementOrigin.SettlementOriginBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementOrigin.SettlementOriginBuilder o = (SettlementOrigin.SettlementOriginBuilder) other;
			
			merger.mergeRosetta(getCashSettlementTerms(), o.getCashSettlementTerms(), this::setCashSettlementTerms);
			merger.mergeRosetta(getCashflow(), o.getCashflow(), this::setCashflow);
			merger.mergeRosetta(getEquityPayout(), o.getEquityPayout(), this::setEquityPayout);
			merger.mergeRosetta(getInterestRatePayout(), o.getInterestRatePayout(), this::setInterestRatePayout);
			merger.mergeRosetta(getPhysicalSettlementTerms(), o.getPhysicalSettlementTerms(), this::setPhysicalSettlementTerms);
			merger.mergeRosetta(getSecurityFinancePayout(), o.getSecurityFinancePayout(), this::setSecurityFinancePayout);
			merger.mergeRosetta(getSecurityPayout(), o.getSecurityPayout(), this::setSecurityPayout);
			merger.mergeRosetta(getSettlementTerms(), o.getSettlementTerms(), this::setSettlementTerms);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementOrigin _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementTerms, _that.getCashSettlementTerms())) return false;
			if (!Objects.equals(cashflow, _that.getCashflow())) return false;
			if (!Objects.equals(equityPayout, _that.getEquityPayout())) return false;
			if (!Objects.equals(interestRatePayout, _that.getInterestRatePayout())) return false;
			if (!Objects.equals(physicalSettlementTerms, _that.getPhysicalSettlementTerms())) return false;
			if (!Objects.equals(securityFinancePayout, _that.getSecurityFinancePayout())) return false;
			if (!Objects.equals(securityPayout, _that.getSecurityPayout())) return false;
			if (!Objects.equals(settlementTerms, _that.getSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementTerms != null ? cashSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (cashflow != null ? cashflow.hashCode() : 0);
			_result = 31 * _result + (equityPayout != null ? equityPayout.hashCode() : 0);
			_result = 31 * _result + (interestRatePayout != null ? interestRatePayout.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTerms != null ? physicalSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (securityFinancePayout != null ? securityFinancePayout.hashCode() : 0);
			_result = 31 * _result + (securityPayout != null ? securityPayout.hashCode() : 0);
			_result = 31 * _result + (settlementTerms != null ? settlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementOriginBuilder {" +
				"cashSettlementTerms=" + this.cashSettlementTerms + ", " +
				"cashflow=" + this.cashflow + ", " +
				"equityPayout=" + this.equityPayout + ", " +
				"interestRatePayout=" + this.interestRatePayout + ", " +
				"physicalSettlementTerms=" + this.physicalSettlementTerms + ", " +
				"securityFinancePayout=" + this.securityFinancePayout + ", " +
				"securityPayout=" + this.securityPayout + ", " +
				"settlementTerms=" + this.settlementTerms +
			'}';
		}
	}
}
