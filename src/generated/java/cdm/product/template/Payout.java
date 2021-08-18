package cdm.product.template;

import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.CommodityPayout;
import cdm.product.template.meta.PayoutMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 *  A class to represent the set of future cashflow methodologies in the form of specific payout class(es) that can be associated for the purpose of specifying a financial product. For example, two interest rate payouts can be combined to specify an interest rate swap, or one interest rate payout can be combined with a credit default payout to specify a credit default swap.
 * @version ${project.version}
 */
@RosettaClass

public interface Payout extends RosettaModelObject, GlobalKey {
	Payout build();
	Payout.PayoutBuilder toBuilder();
	
	/**
	 * A cashflow between the parties to the trade. For interest rate and equity products, this corresponds to the FpML additionalPayment element. For credit default swaps, this corresponds to the FpML initialPayment element and the singlePayment element of the fee leg. For option products, it represents the FpML premium element.
	 */
	List<? extends Cashflow> getCashflow();
	/**
	 * Defines the payout for the floating leg of a Commodity Swap.
	 */
	List<? extends CommodityPayout> getCommodityPayout();
	/**
	 * The credit default payout, which provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms.
	 */
	CreditDefaultPayout getCreditDefaultPayout();
	/**
	 * The equity payout, which encompasses the equity price returns, dividend returns, volatility and variance return provisions.
	 */
	List<? extends EquityPayout> getEquityPayout();
	/**
	 * Defines a payout in which one or more forward payouts are defined as a fixed price.
	 */
	List<? extends FixedForwardPayout> getFixedForwardPayout();
	/**
	 * Represents a forward settling payout. The &#39;Underlier&#39; attribute captures the underlying payout, which is settled according to the &#39;SettlementTerms&#39; attribute. Both FX Spot and FX Forward should use this component.
	 */
	List<? extends ForwardPayout> getForwardPayout();
	/**
	 * All of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg).
	 */
	List<? extends InterestRatePayout> getInterestRatePayout();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The option payout.
	 */
	List<? extends OptionPayout> getOptionPayout();
	/**
	 * The security payout when the product involves some form of securities, such as collateral in a securities financing transaction
	 */
	List<? extends SecurityFinancePayout> getSecurityFinancePayout();
	/**
	 * The security payout when the product involves some form of securities, such as collateral in a securities financing transaction
	 */
	List<? extends SecurityPayout> getSecurityPayout();
	final static PayoutMeta metaData = new PayoutMeta();
	
	@Override
	default RosettaMetaData<? extends Payout> metaData() {
		return metaData;
	} 
			
	static Payout.PayoutBuilder builder() {
		return new Payout.PayoutBuilderImpl();
	}
	
	default Class<? extends Payout> getType() {
		return Payout.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("cashflow"), processor, Cashflow.class, getCashflow());
		processRosetta(path.newSubPath("commodityPayout"), processor, CommodityPayout.class, getCommodityPayout());
		processRosetta(path.newSubPath("creditDefaultPayout"), processor, CreditDefaultPayout.class, getCreditDefaultPayout());
		processRosetta(path.newSubPath("equityPayout"), processor, EquityPayout.class, getEquityPayout());
		processRosetta(path.newSubPath("fixedForwardPayout"), processor, FixedForwardPayout.class, getFixedForwardPayout());
		processRosetta(path.newSubPath("forwardPayout"), processor, ForwardPayout.class, getForwardPayout());
		processRosetta(path.newSubPath("interestRatePayout"), processor, InterestRatePayout.class, getInterestRatePayout());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("optionPayout"), processor, OptionPayout.class, getOptionPayout());
		processRosetta(path.newSubPath("securityFinancePayout"), processor, SecurityFinancePayout.class, getSecurityFinancePayout());
		processRosetta(path.newSubPath("securityPayout"), processor, SecurityPayout.class, getSecurityPayout());
	}
	
	
	interface PayoutBuilder extends Payout, RosettaModelObjectBuilder {
		Cashflow.CashflowBuilder getOrCreateCashflow(int _index);
		List<? extends Cashflow.CashflowBuilder> getCashflow();
		CommodityPayout.CommodityPayoutBuilder getOrCreateCommodityPayout(int _index);
		List<? extends CommodityPayout.CommodityPayoutBuilder> getCommodityPayout();
		CreditDefaultPayout.CreditDefaultPayoutBuilder getOrCreateCreditDefaultPayout();
		CreditDefaultPayout.CreditDefaultPayoutBuilder getCreditDefaultPayout();
		EquityPayout.EquityPayoutBuilder getOrCreateEquityPayout(int _index);
		List<? extends EquityPayout.EquityPayoutBuilder> getEquityPayout();
		FixedForwardPayout.FixedForwardPayoutBuilder getOrCreateFixedForwardPayout(int _index);
		List<? extends FixedForwardPayout.FixedForwardPayoutBuilder> getFixedForwardPayout();
		ForwardPayout.ForwardPayoutBuilder getOrCreateForwardPayout(int _index);
		List<? extends ForwardPayout.ForwardPayoutBuilder> getForwardPayout();
		InterestRatePayout.InterestRatePayoutBuilder getOrCreateInterestRatePayout(int _index);
		List<? extends InterestRatePayout.InterestRatePayoutBuilder> getInterestRatePayout();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		OptionPayout.OptionPayoutBuilder getOrCreateOptionPayout(int _index);
		List<? extends OptionPayout.OptionPayoutBuilder> getOptionPayout();
		SecurityFinancePayout.SecurityFinancePayoutBuilder getOrCreateSecurityFinancePayout(int _index);
		List<? extends SecurityFinancePayout.SecurityFinancePayoutBuilder> getSecurityFinancePayout();
		SecurityPayout.SecurityPayoutBuilder getOrCreateSecurityPayout(int _index);
		List<? extends SecurityPayout.SecurityPayoutBuilder> getSecurityPayout();
		Payout.PayoutBuilder addCashflow(Cashflow cashflow);
		Payout.PayoutBuilder addCashflow(Cashflow cashflow, int _idx);
		Payout.PayoutBuilder addCashflow(List<? extends Cashflow> cashflow);
		Payout.PayoutBuilder setCashflow(List<? extends Cashflow> cashflow);
		Payout.PayoutBuilder addCommodityPayout(CommodityPayout commodityPayout);
		Payout.PayoutBuilder addCommodityPayout(CommodityPayout commodityPayout, int _idx);
		Payout.PayoutBuilder addCommodityPayout(List<? extends CommodityPayout> commodityPayout);
		Payout.PayoutBuilder setCommodityPayout(List<? extends CommodityPayout> commodityPayout);
		Payout.PayoutBuilder setCreditDefaultPayout(CreditDefaultPayout creditDefaultPayout);
		Payout.PayoutBuilder addEquityPayout(EquityPayout equityPayout);
		Payout.PayoutBuilder addEquityPayout(EquityPayout equityPayout, int _idx);
		Payout.PayoutBuilder addEquityPayout(List<? extends EquityPayout> equityPayout);
		Payout.PayoutBuilder setEquityPayout(List<? extends EquityPayout> equityPayout);
		Payout.PayoutBuilder addFixedForwardPayout(FixedForwardPayout fixedForwardPayout);
		Payout.PayoutBuilder addFixedForwardPayout(FixedForwardPayout fixedForwardPayout, int _idx);
		Payout.PayoutBuilder addFixedForwardPayout(List<? extends FixedForwardPayout> fixedForwardPayout);
		Payout.PayoutBuilder setFixedForwardPayout(List<? extends FixedForwardPayout> fixedForwardPayout);
		Payout.PayoutBuilder addForwardPayout(ForwardPayout forwardPayout);
		Payout.PayoutBuilder addForwardPayout(ForwardPayout forwardPayout, int _idx);
		Payout.PayoutBuilder addForwardPayout(List<? extends ForwardPayout> forwardPayout);
		Payout.PayoutBuilder setForwardPayout(List<? extends ForwardPayout> forwardPayout);
		Payout.PayoutBuilder addInterestRatePayout(InterestRatePayout interestRatePayout);
		Payout.PayoutBuilder addInterestRatePayout(InterestRatePayout interestRatePayout, int _idx);
		Payout.PayoutBuilder addInterestRatePayout(List<? extends InterestRatePayout> interestRatePayout);
		Payout.PayoutBuilder setInterestRatePayout(List<? extends InterestRatePayout> interestRatePayout);
		Payout.PayoutBuilder setMeta(MetaFields meta);
		Payout.PayoutBuilder addOptionPayout(OptionPayout optionPayout);
		Payout.PayoutBuilder addOptionPayout(OptionPayout optionPayout, int _idx);
		Payout.PayoutBuilder addOptionPayout(List<? extends OptionPayout> optionPayout);
		Payout.PayoutBuilder setOptionPayout(List<? extends OptionPayout> optionPayout);
		Payout.PayoutBuilder addSecurityFinancePayout(SecurityFinancePayout securityFinancePayout);
		Payout.PayoutBuilder addSecurityFinancePayout(SecurityFinancePayout securityFinancePayout, int _idx);
		Payout.PayoutBuilder addSecurityFinancePayout(List<? extends SecurityFinancePayout> securityFinancePayout);
		Payout.PayoutBuilder setSecurityFinancePayout(List<? extends SecurityFinancePayout> securityFinancePayout);
		Payout.PayoutBuilder addSecurityPayout(SecurityPayout securityPayout);
		Payout.PayoutBuilder addSecurityPayout(SecurityPayout securityPayout, int _idx);
		Payout.PayoutBuilder addSecurityPayout(List<? extends SecurityPayout> securityPayout);
		Payout.PayoutBuilder setSecurityPayout(List<? extends SecurityPayout> securityPayout);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("cashflow"), processor, Cashflow.CashflowBuilder.class, getCashflow());
			processRosetta(path.newSubPath("commodityPayout"), processor, CommodityPayout.CommodityPayoutBuilder.class, getCommodityPayout());
			processRosetta(path.newSubPath("creditDefaultPayout"), processor, CreditDefaultPayout.CreditDefaultPayoutBuilder.class, getCreditDefaultPayout());
			processRosetta(path.newSubPath("equityPayout"), processor, EquityPayout.EquityPayoutBuilder.class, getEquityPayout());
			processRosetta(path.newSubPath("fixedForwardPayout"), processor, FixedForwardPayout.FixedForwardPayoutBuilder.class, getFixedForwardPayout());
			processRosetta(path.newSubPath("forwardPayout"), processor, ForwardPayout.ForwardPayoutBuilder.class, getForwardPayout());
			processRosetta(path.newSubPath("interestRatePayout"), processor, InterestRatePayout.InterestRatePayoutBuilder.class, getInterestRatePayout());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("optionPayout"), processor, OptionPayout.OptionPayoutBuilder.class, getOptionPayout());
			processRosetta(path.newSubPath("securityFinancePayout"), processor, SecurityFinancePayout.SecurityFinancePayoutBuilder.class, getSecurityFinancePayout());
			processRosetta(path.newSubPath("securityPayout"), processor, SecurityPayout.SecurityPayoutBuilder.class, getSecurityPayout());
		}
		
	}
	
	//Payout.PayoutImpl
	class PayoutImpl implements Payout {
		private final List<? extends Cashflow> cashflow;
		private final List<? extends CommodityPayout> commodityPayout;
		private final CreditDefaultPayout creditDefaultPayout;
		private final List<? extends EquityPayout> equityPayout;
		private final List<? extends FixedForwardPayout> fixedForwardPayout;
		private final List<? extends ForwardPayout> forwardPayout;
		private final List<? extends InterestRatePayout> interestRatePayout;
		private final MetaFields meta;
		private final List<? extends OptionPayout> optionPayout;
		private final List<? extends SecurityFinancePayout> securityFinancePayout;
		private final List<? extends SecurityPayout> securityPayout;
		
		protected PayoutImpl(Payout.PayoutBuilder builder) {
			this.cashflow = ofNullable(builder.getCashflow()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityPayout = ofNullable(builder.getCommodityPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditDefaultPayout = ofNullable(builder.getCreditDefaultPayout()).map(f->f.build()).orElse(null);
			this.equityPayout = ofNullable(builder.getEquityPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fixedForwardPayout = ofNullable(builder.getFixedForwardPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.forwardPayout = ofNullable(builder.getForwardPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.interestRatePayout = ofNullable(builder.getInterestRatePayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.optionPayout = ofNullable(builder.getOptionPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.securityFinancePayout = ofNullable(builder.getSecurityFinancePayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.securityPayout = ofNullable(builder.getSecurityPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends Cashflow> getCashflow() {
			return cashflow;
		}
		
		@Override
		public List<? extends CommodityPayout> getCommodityPayout() {
			return commodityPayout;
		}
		
		@Override
		public CreditDefaultPayout getCreditDefaultPayout() {
			return creditDefaultPayout;
		}
		
		@Override
		public List<? extends EquityPayout> getEquityPayout() {
			return equityPayout;
		}
		
		@Override
		public List<? extends FixedForwardPayout> getFixedForwardPayout() {
			return fixedForwardPayout;
		}
		
		@Override
		public List<? extends ForwardPayout> getForwardPayout() {
			return forwardPayout;
		}
		
		@Override
		public List<? extends InterestRatePayout> getInterestRatePayout() {
			return interestRatePayout;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends OptionPayout> getOptionPayout() {
			return optionPayout;
		}
		
		@Override
		public List<? extends SecurityFinancePayout> getSecurityFinancePayout() {
			return securityFinancePayout;
		}
		
		@Override
		public List<? extends SecurityPayout> getSecurityPayout() {
			return securityPayout;
		}
		
		@Override
		public Payout build() {
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder toBuilder() {
			Payout.PayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Payout.PayoutBuilder builder) {
			ofNullable(getCashflow()).ifPresent(builder::setCashflow);
			ofNullable(getCommodityPayout()).ifPresent(builder::setCommodityPayout);
			ofNullable(getCreditDefaultPayout()).ifPresent(builder::setCreditDefaultPayout);
			ofNullable(getEquityPayout()).ifPresent(builder::setEquityPayout);
			ofNullable(getFixedForwardPayout()).ifPresent(builder::setFixedForwardPayout);
			ofNullable(getForwardPayout()).ifPresent(builder::setForwardPayout);
			ofNullable(getInterestRatePayout()).ifPresent(builder::setInterestRatePayout);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getOptionPayout()).ifPresent(builder::setOptionPayout);
			ofNullable(getSecurityFinancePayout()).ifPresent(builder::setSecurityFinancePayout);
			ofNullable(getSecurityPayout()).ifPresent(builder::setSecurityPayout);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Payout _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cashflow, _that.getCashflow())) return false;
			if (!ListEquals.listEquals(commodityPayout, _that.getCommodityPayout())) return false;
			if (!Objects.equals(creditDefaultPayout, _that.getCreditDefaultPayout())) return false;
			if (!ListEquals.listEquals(equityPayout, _that.getEquityPayout())) return false;
			if (!ListEquals.listEquals(fixedForwardPayout, _that.getFixedForwardPayout())) return false;
			if (!ListEquals.listEquals(forwardPayout, _that.getForwardPayout())) return false;
			if (!ListEquals.listEquals(interestRatePayout, _that.getInterestRatePayout())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(optionPayout, _that.getOptionPayout())) return false;
			if (!ListEquals.listEquals(securityFinancePayout, _that.getSecurityFinancePayout())) return false;
			if (!ListEquals.listEquals(securityPayout, _that.getSecurityPayout())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflow != null ? cashflow.hashCode() : 0);
			_result = 31 * _result + (commodityPayout != null ? commodityPayout.hashCode() : 0);
			_result = 31 * _result + (creditDefaultPayout != null ? creditDefaultPayout.hashCode() : 0);
			_result = 31 * _result + (equityPayout != null ? equityPayout.hashCode() : 0);
			_result = 31 * _result + (fixedForwardPayout != null ? fixedForwardPayout.hashCode() : 0);
			_result = 31 * _result + (forwardPayout != null ? forwardPayout.hashCode() : 0);
			_result = 31 * _result + (interestRatePayout != null ? interestRatePayout.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (optionPayout != null ? optionPayout.hashCode() : 0);
			_result = 31 * _result + (securityFinancePayout != null ? securityFinancePayout.hashCode() : 0);
			_result = 31 * _result + (securityPayout != null ? securityPayout.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Payout {" +
				"cashflow=" + this.cashflow + ", " +
				"commodityPayout=" + this.commodityPayout + ", " +
				"creditDefaultPayout=" + this.creditDefaultPayout + ", " +
				"equityPayout=" + this.equityPayout + ", " +
				"fixedForwardPayout=" + this.fixedForwardPayout + ", " +
				"forwardPayout=" + this.forwardPayout + ", " +
				"interestRatePayout=" + this.interestRatePayout + ", " +
				"meta=" + this.meta + ", " +
				"optionPayout=" + this.optionPayout + ", " +
				"securityFinancePayout=" + this.securityFinancePayout + ", " +
				"securityPayout=" + this.securityPayout +
			'}';
		}
	}
	
	//Payout.PayoutBuilderImpl
	class PayoutBuilderImpl implements Payout.PayoutBuilder, GlobalKeyBuilder {
	
		protected List<Cashflow.CashflowBuilder> cashflow = new ArrayList<>();
		protected List<CommodityPayout.CommodityPayoutBuilder> commodityPayout = new ArrayList<>();
		protected CreditDefaultPayout.CreditDefaultPayoutBuilder creditDefaultPayout;
		protected List<EquityPayout.EquityPayoutBuilder> equityPayout = new ArrayList<>();
		protected List<FixedForwardPayout.FixedForwardPayoutBuilder> fixedForwardPayout = new ArrayList<>();
		protected List<ForwardPayout.ForwardPayoutBuilder> forwardPayout = new ArrayList<>();
		protected List<InterestRatePayout.InterestRatePayoutBuilder> interestRatePayout = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<OptionPayout.OptionPayoutBuilder> optionPayout = new ArrayList<>();
		protected List<SecurityFinancePayout.SecurityFinancePayoutBuilder> securityFinancePayout = new ArrayList<>();
		protected List<SecurityPayout.SecurityPayoutBuilder> securityPayout = new ArrayList<>();
	
		public PayoutBuilderImpl() {
		}
	
		@Override
		public List<? extends Cashflow.CashflowBuilder> getCashflow() {
			return cashflow;
		}
		
		public Cashflow.CashflowBuilder getOrCreateCashflow(int _index) {
		
			if (cashflow==null) {
				this.cashflow = new ArrayList<>();
			}
			Cashflow.CashflowBuilder result;
			return getIndex(cashflow, _index, () -> {
						Cashflow.CashflowBuilder newCashflow = Cashflow.builder();
						return newCashflow;
					});
		}
		
		@Override
		public List<? extends CommodityPayout.CommodityPayoutBuilder> getCommodityPayout() {
			return commodityPayout;
		}
		
		public CommodityPayout.CommodityPayoutBuilder getOrCreateCommodityPayout(int _index) {
		
			if (commodityPayout==null) {
				this.commodityPayout = new ArrayList<>();
			}
			CommodityPayout.CommodityPayoutBuilder result;
			return getIndex(commodityPayout, _index, () -> {
						CommodityPayout.CommodityPayoutBuilder newCommodityPayout = CommodityPayout.builder();
						return newCommodityPayout;
					});
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder getCreditDefaultPayout() {
			return creditDefaultPayout;
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder getOrCreateCreditDefaultPayout() {
			CreditDefaultPayout.CreditDefaultPayoutBuilder result;
			if (creditDefaultPayout!=null) {
				result = creditDefaultPayout;
			}
			else {
				result = creditDefaultPayout = CreditDefaultPayout.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends EquityPayout.EquityPayoutBuilder> getEquityPayout() {
			return equityPayout;
		}
		
		public EquityPayout.EquityPayoutBuilder getOrCreateEquityPayout(int _index) {
		
			if (equityPayout==null) {
				this.equityPayout = new ArrayList<>();
			}
			EquityPayout.EquityPayoutBuilder result;
			return getIndex(equityPayout, _index, () -> {
						EquityPayout.EquityPayoutBuilder newEquityPayout = EquityPayout.builder();
						return newEquityPayout;
					});
		}
		
		@Override
		public List<? extends FixedForwardPayout.FixedForwardPayoutBuilder> getFixedForwardPayout() {
			return fixedForwardPayout;
		}
		
		public FixedForwardPayout.FixedForwardPayoutBuilder getOrCreateFixedForwardPayout(int _index) {
		
			if (fixedForwardPayout==null) {
				this.fixedForwardPayout = new ArrayList<>();
			}
			FixedForwardPayout.FixedForwardPayoutBuilder result;
			return getIndex(fixedForwardPayout, _index, () -> {
						FixedForwardPayout.FixedForwardPayoutBuilder newFixedForwardPayout = FixedForwardPayout.builder();
						return newFixedForwardPayout;
					});
		}
		
		@Override
		public List<? extends ForwardPayout.ForwardPayoutBuilder> getForwardPayout() {
			return forwardPayout;
		}
		
		public ForwardPayout.ForwardPayoutBuilder getOrCreateForwardPayout(int _index) {
		
			if (forwardPayout==null) {
				this.forwardPayout = new ArrayList<>();
			}
			ForwardPayout.ForwardPayoutBuilder result;
			return getIndex(forwardPayout, _index, () -> {
						ForwardPayout.ForwardPayoutBuilder newForwardPayout = ForwardPayout.builder();
						return newForwardPayout;
					});
		}
		
		@Override
		public List<? extends InterestRatePayout.InterestRatePayoutBuilder> getInterestRatePayout() {
			return interestRatePayout;
		}
		
		public InterestRatePayout.InterestRatePayoutBuilder getOrCreateInterestRatePayout(int _index) {
		
			if (interestRatePayout==null) {
				this.interestRatePayout = new ArrayList<>();
			}
			InterestRatePayout.InterestRatePayoutBuilder result;
			return getIndex(interestRatePayout, _index, () -> {
						InterestRatePayout.InterestRatePayoutBuilder newInterestRatePayout = InterestRatePayout.builder();
						return newInterestRatePayout;
					});
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
		public List<? extends OptionPayout.OptionPayoutBuilder> getOptionPayout() {
			return optionPayout;
		}
		
		public OptionPayout.OptionPayoutBuilder getOrCreateOptionPayout(int _index) {
		
			if (optionPayout==null) {
				this.optionPayout = new ArrayList<>();
			}
			OptionPayout.OptionPayoutBuilder result;
			return getIndex(optionPayout, _index, () -> {
						OptionPayout.OptionPayoutBuilder newOptionPayout = OptionPayout.builder();
						return newOptionPayout;
					});
		}
		
		@Override
		public List<? extends SecurityFinancePayout.SecurityFinancePayoutBuilder> getSecurityFinancePayout() {
			return securityFinancePayout;
		}
		
		public SecurityFinancePayout.SecurityFinancePayoutBuilder getOrCreateSecurityFinancePayout(int _index) {
		
			if (securityFinancePayout==null) {
				this.securityFinancePayout = new ArrayList<>();
			}
			SecurityFinancePayout.SecurityFinancePayoutBuilder result;
			return getIndex(securityFinancePayout, _index, () -> {
						SecurityFinancePayout.SecurityFinancePayoutBuilder newSecurityFinancePayout = SecurityFinancePayout.builder();
						return newSecurityFinancePayout;
					});
		}
		
		@Override
		public List<? extends SecurityPayout.SecurityPayoutBuilder> getSecurityPayout() {
			return securityPayout;
		}
		
		public SecurityPayout.SecurityPayoutBuilder getOrCreateSecurityPayout(int _index) {
		
			if (securityPayout==null) {
				this.securityPayout = new ArrayList<>();
			}
			SecurityPayout.SecurityPayoutBuilder result;
			return getIndex(securityPayout, _index, () -> {
						SecurityPayout.SecurityPayoutBuilder newSecurityPayout = SecurityPayout.builder();
						return newSecurityPayout;
					});
		}
		
	
		@Override
		public Payout.PayoutBuilder addCashflow(Cashflow cashflow) {
			if (cashflow!=null) this.cashflow.add(cashflow.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addCashflow(Cashflow cashflow, int _idx) {
			getIndex(this.cashflow, _idx, () -> cashflow.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addCashflow(List<? extends Cashflow> cashflows) {
			if (cashflows != null) {
				for (Cashflow toAdd : cashflows) {
					this.cashflow.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setCashflow(List<? extends Cashflow> cashflows) {
			if (cashflows == null)  {
				this.cashflow = new ArrayList<>();
			}
			else {
				this.cashflow = cashflows.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addCommodityPayout(CommodityPayout commodityPayout) {
			if (commodityPayout!=null) this.commodityPayout.add(commodityPayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addCommodityPayout(CommodityPayout commodityPayout, int _idx) {
			getIndex(this.commodityPayout, _idx, () -> commodityPayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addCommodityPayout(List<? extends CommodityPayout> commodityPayouts) {
			if (commodityPayouts != null) {
				for (CommodityPayout toAdd : commodityPayouts) {
					this.commodityPayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setCommodityPayout(List<? extends CommodityPayout> commodityPayouts) {
			if (commodityPayouts == null)  {
				this.commodityPayout = new ArrayList<>();
			}
			else {
				this.commodityPayout = commodityPayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder setCreditDefaultPayout(CreditDefaultPayout creditDefaultPayout) {
			this.creditDefaultPayout = creditDefaultPayout==null?null:creditDefaultPayout.toBuilder();
			return this;
		}
		@Override
		public Payout.PayoutBuilder addEquityPayout(EquityPayout equityPayout) {
			if (equityPayout!=null) this.equityPayout.add(equityPayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addEquityPayout(EquityPayout equityPayout, int _idx) {
			getIndex(this.equityPayout, _idx, () -> equityPayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addEquityPayout(List<? extends EquityPayout> equityPayouts) {
			if (equityPayouts != null) {
				for (EquityPayout toAdd : equityPayouts) {
					this.equityPayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setEquityPayout(List<? extends EquityPayout> equityPayouts) {
			if (equityPayouts == null)  {
				this.equityPayout = new ArrayList<>();
			}
			else {
				this.equityPayout = equityPayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addFixedForwardPayout(FixedForwardPayout fixedForwardPayout) {
			if (fixedForwardPayout!=null) this.fixedForwardPayout.add(fixedForwardPayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addFixedForwardPayout(FixedForwardPayout fixedForwardPayout, int _idx) {
			getIndex(this.fixedForwardPayout, _idx, () -> fixedForwardPayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addFixedForwardPayout(List<? extends FixedForwardPayout> fixedForwardPayouts) {
			if (fixedForwardPayouts != null) {
				for (FixedForwardPayout toAdd : fixedForwardPayouts) {
					this.fixedForwardPayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setFixedForwardPayout(List<? extends FixedForwardPayout> fixedForwardPayouts) {
			if (fixedForwardPayouts == null)  {
				this.fixedForwardPayout = new ArrayList<>();
			}
			else {
				this.fixedForwardPayout = fixedForwardPayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addForwardPayout(ForwardPayout forwardPayout) {
			if (forwardPayout!=null) this.forwardPayout.add(forwardPayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addForwardPayout(ForwardPayout forwardPayout, int _idx) {
			getIndex(this.forwardPayout, _idx, () -> forwardPayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addForwardPayout(List<? extends ForwardPayout> forwardPayouts) {
			if (forwardPayouts != null) {
				for (ForwardPayout toAdd : forwardPayouts) {
					this.forwardPayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setForwardPayout(List<? extends ForwardPayout> forwardPayouts) {
			if (forwardPayouts == null)  {
				this.forwardPayout = new ArrayList<>();
			}
			else {
				this.forwardPayout = forwardPayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addInterestRatePayout(InterestRatePayout interestRatePayout) {
			if (interestRatePayout!=null) this.interestRatePayout.add(interestRatePayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addInterestRatePayout(InterestRatePayout interestRatePayout, int _idx) {
			getIndex(this.interestRatePayout, _idx, () -> interestRatePayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addInterestRatePayout(List<? extends InterestRatePayout> interestRatePayouts) {
			if (interestRatePayouts != null) {
				for (InterestRatePayout toAdd : interestRatePayouts) {
					this.interestRatePayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setInterestRatePayout(List<? extends InterestRatePayout> interestRatePayouts) {
			if (interestRatePayouts == null)  {
				this.interestRatePayout = new ArrayList<>();
			}
			else {
				this.interestRatePayout = interestRatePayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Payout.PayoutBuilder addOptionPayout(OptionPayout optionPayout) {
			if (optionPayout!=null) this.optionPayout.add(optionPayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addOptionPayout(OptionPayout optionPayout, int _idx) {
			getIndex(this.optionPayout, _idx, () -> optionPayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addOptionPayout(List<? extends OptionPayout> optionPayouts) {
			if (optionPayouts != null) {
				for (OptionPayout toAdd : optionPayouts) {
					this.optionPayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setOptionPayout(List<? extends OptionPayout> optionPayouts) {
			if (optionPayouts == null)  {
				this.optionPayout = new ArrayList<>();
			}
			else {
				this.optionPayout = optionPayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addSecurityFinancePayout(SecurityFinancePayout securityFinancePayout) {
			if (securityFinancePayout!=null) this.securityFinancePayout.add(securityFinancePayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addSecurityFinancePayout(SecurityFinancePayout securityFinancePayout, int _idx) {
			getIndex(this.securityFinancePayout, _idx, () -> securityFinancePayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addSecurityFinancePayout(List<? extends SecurityFinancePayout> securityFinancePayouts) {
			if (securityFinancePayouts != null) {
				for (SecurityFinancePayout toAdd : securityFinancePayouts) {
					this.securityFinancePayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setSecurityFinancePayout(List<? extends SecurityFinancePayout> securityFinancePayouts) {
			if (securityFinancePayouts == null)  {
				this.securityFinancePayout = new ArrayList<>();
			}
			else {
				this.securityFinancePayout = securityFinancePayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addSecurityPayout(SecurityPayout securityPayout) {
			if (securityPayout!=null) this.securityPayout.add(securityPayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addSecurityPayout(SecurityPayout securityPayout, int _idx) {
			getIndex(this.securityPayout, _idx, () -> securityPayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addSecurityPayout(List<? extends SecurityPayout> securityPayouts) {
			if (securityPayouts != null) {
				for (SecurityPayout toAdd : securityPayouts) {
					this.securityPayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setSecurityPayout(List<? extends SecurityPayout> securityPayouts) {
			if (securityPayouts == null)  {
				this.securityPayout = new ArrayList<>();
			}
			else {
				this.securityPayout = securityPayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Payout build() {
			return new Payout.PayoutImpl(this);
		}
		
		@Override
		public Payout.PayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Payout.PayoutBuilder prune() {
			cashflow = cashflow.stream().filter(b->b!=null).<Cashflow.CashflowBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			commodityPayout = commodityPayout.stream().filter(b->b!=null).<CommodityPayout.CommodityPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (creditDefaultPayout!=null && !creditDefaultPayout.prune().hasData()) creditDefaultPayout = null;
			equityPayout = equityPayout.stream().filter(b->b!=null).<EquityPayout.EquityPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			fixedForwardPayout = fixedForwardPayout.stream().filter(b->b!=null).<FixedForwardPayout.FixedForwardPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			forwardPayout = forwardPayout.stream().filter(b->b!=null).<ForwardPayout.ForwardPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			interestRatePayout = interestRatePayout.stream().filter(b->b!=null).<InterestRatePayout.InterestRatePayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			optionPayout = optionPayout.stream().filter(b->b!=null).<OptionPayout.OptionPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			securityFinancePayout = securityFinancePayout.stream().filter(b->b!=null).<SecurityFinancePayout.SecurityFinancePayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			securityPayout = securityPayout.stream().filter(b->b!=null).<SecurityPayout.SecurityPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashflow()!=null && getCashflow().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityPayout()!=null && getCommodityPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditDefaultPayout()!=null && getCreditDefaultPayout().hasData()) return true;
			if (getEquityPayout()!=null && getEquityPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFixedForwardPayout()!=null && getFixedForwardPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getForwardPayout()!=null && getForwardPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInterestRatePayout()!=null && getInterestRatePayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOptionPayout()!=null && getOptionPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSecurityFinancePayout()!=null && getSecurityFinancePayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSecurityPayout()!=null && getSecurityPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Payout.PayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Payout.PayoutBuilder o = (Payout.PayoutBuilder) other;
			
			merger.mergeRosetta(getCashflow(), o.getCashflow(), this::getOrCreateCashflow);
			merger.mergeRosetta(getCommodityPayout(), o.getCommodityPayout(), this::getOrCreateCommodityPayout);
			merger.mergeRosetta(getCreditDefaultPayout(), o.getCreditDefaultPayout(), this::setCreditDefaultPayout);
			merger.mergeRosetta(getEquityPayout(), o.getEquityPayout(), this::getOrCreateEquityPayout);
			merger.mergeRosetta(getFixedForwardPayout(), o.getFixedForwardPayout(), this::getOrCreateFixedForwardPayout);
			merger.mergeRosetta(getForwardPayout(), o.getForwardPayout(), this::getOrCreateForwardPayout);
			merger.mergeRosetta(getInterestRatePayout(), o.getInterestRatePayout(), this::getOrCreateInterestRatePayout);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getOptionPayout(), o.getOptionPayout(), this::getOrCreateOptionPayout);
			merger.mergeRosetta(getSecurityFinancePayout(), o.getSecurityFinancePayout(), this::getOrCreateSecurityFinancePayout);
			merger.mergeRosetta(getSecurityPayout(), o.getSecurityPayout(), this::getOrCreateSecurityPayout);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Payout _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cashflow, _that.getCashflow())) return false;
			if (!ListEquals.listEquals(commodityPayout, _that.getCommodityPayout())) return false;
			if (!Objects.equals(creditDefaultPayout, _that.getCreditDefaultPayout())) return false;
			if (!ListEquals.listEquals(equityPayout, _that.getEquityPayout())) return false;
			if (!ListEquals.listEquals(fixedForwardPayout, _that.getFixedForwardPayout())) return false;
			if (!ListEquals.listEquals(forwardPayout, _that.getForwardPayout())) return false;
			if (!ListEquals.listEquals(interestRatePayout, _that.getInterestRatePayout())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(optionPayout, _that.getOptionPayout())) return false;
			if (!ListEquals.listEquals(securityFinancePayout, _that.getSecurityFinancePayout())) return false;
			if (!ListEquals.listEquals(securityPayout, _that.getSecurityPayout())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflow != null ? cashflow.hashCode() : 0);
			_result = 31 * _result + (commodityPayout != null ? commodityPayout.hashCode() : 0);
			_result = 31 * _result + (creditDefaultPayout != null ? creditDefaultPayout.hashCode() : 0);
			_result = 31 * _result + (equityPayout != null ? equityPayout.hashCode() : 0);
			_result = 31 * _result + (fixedForwardPayout != null ? fixedForwardPayout.hashCode() : 0);
			_result = 31 * _result + (forwardPayout != null ? forwardPayout.hashCode() : 0);
			_result = 31 * _result + (interestRatePayout != null ? interestRatePayout.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (optionPayout != null ? optionPayout.hashCode() : 0);
			_result = 31 * _result + (securityFinancePayout != null ? securityFinancePayout.hashCode() : 0);
			_result = 31 * _result + (securityPayout != null ? securityPayout.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayoutBuilder {" +
				"cashflow=" + this.cashflow + ", " +
				"commodityPayout=" + this.commodityPayout + ", " +
				"creditDefaultPayout=" + this.creditDefaultPayout + ", " +
				"equityPayout=" + this.equityPayout + ", " +
				"fixedForwardPayout=" + this.fixedForwardPayout + ", " +
				"forwardPayout=" + this.forwardPayout + ", " +
				"interestRatePayout=" + this.interestRatePayout + ", " +
				"meta=" + this.meta + ", " +
				"optionPayout=" + this.optionPayout + ", " +
				"securityFinancePayout=" + this.securityFinancePayout + ", " +
				"securityPayout=" + this.securityPayout +
			'}';
		}
	}
}
