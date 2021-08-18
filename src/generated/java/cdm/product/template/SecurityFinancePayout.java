package cdm.product.template;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.Money;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.meta.SecurityFinancePayoutMeta;
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
 * Security payout specification in case the product payout involves some form of security collateral, as in a securities financing transaction.
 * @version ${project.version}
 */
@RosettaClass

public interface SecurityFinancePayout extends PayoutBase, GlobalKey {
	SecurityFinancePayout build();
	SecurityFinancePayout.SecurityFinancePayoutBuilder toBuilder();
	
	/**
	 * Specifies collateral provisions for a Security Finance transaction, including Collateral Type and Margin Percentage.
	 */
	CollateralProvisions getCollateralProvisions();
	/**
	 * Specifies the terms under which dividends received by the borrower are passed through to the lender.
	 */
	DividendTerms getDividendTerms();
	/**
	 * Specifies the Duration Terms of the Security Finance transaction. e.g. Open or Term.
	 */
	Duration getDurationType();
	/**
	 */
	MetaFields getMeta();
	/**
	 * A contractual minimum amount which the borrower will pay, regardless of the duration of the loan. A mechanism for making sure that a trade generates enough income.
	 */
	Money getMinimumFee();
	/**
	 * Each SecurityLeg represent a buy/sell at different dates, typically 1 near leg and 1 far leg in a securities financing transaction.
	 */
	List<? extends SecurityFinanceLeg> getSecurityFinanceLeg();
	/**
	 * Specifies the reference asset.  This is The base type which all products extend (similar to FpML model). Within SecurityPayout we include a condition which validates that the product must be a Security (see below condition &#39;ProductMustBeSecurity&#39;).
	 */
	Product getSecurityInformation();
	final static SecurityFinancePayoutMeta metaData = new SecurityFinancePayoutMeta();
	
	@Override
	default RosettaMetaData<? extends SecurityFinancePayout> metaData() {
		return metaData;
	} 
			
	static SecurityFinancePayout.SecurityFinancePayoutBuilder builder() {
		return new SecurityFinancePayout.SecurityFinancePayoutBuilderImpl();
	}
	
	default Class<? extends SecurityFinancePayout> getType() {
		return SecurityFinancePayout.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.common.settlement.PayoutBase.super.process(path, processor);
		
		processRosetta(path.newSubPath("collateralProvisions"), processor, CollateralProvisions.class, getCollateralProvisions());
		processRosetta(path.newSubPath("dividendTerms"), processor, DividendTerms.class, getDividendTerms());
		processRosetta(path.newSubPath("durationType"), processor, Duration.class, getDurationType());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("minimumFee"), processor, Money.class, getMinimumFee());
		processRosetta(path.newSubPath("securityFinanceLeg"), processor, SecurityFinanceLeg.class, getSecurityFinanceLeg());
		processRosetta(path.newSubPath("securityInformation"), processor, Product.class, getSecurityInformation());
	}
	
	
	interface SecurityFinancePayoutBuilder extends SecurityFinancePayout, PayoutBase.PayoutBaseBuilder, RosettaModelObjectBuilder {
		CollateralProvisions.CollateralProvisionsBuilder getOrCreateCollateralProvisions();
		CollateralProvisions.CollateralProvisionsBuilder getCollateralProvisions();
		DividendTerms.DividendTermsBuilder getOrCreateDividendTerms();
		DividendTerms.DividendTermsBuilder getDividendTerms();
		Duration.DurationBuilder getOrCreateDurationType();
		Duration.DurationBuilder getDurationType();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Money.MoneyBuilder getOrCreateMinimumFee();
		Money.MoneyBuilder getMinimumFee();
		SecurityFinanceLeg.SecurityFinanceLegBuilder getOrCreateSecurityFinanceLeg(int _index);
		List<? extends SecurityFinanceLeg.SecurityFinanceLegBuilder> getSecurityFinanceLeg();
		Product.ProductBuilder getOrCreateSecurityInformation();
		Product.ProductBuilder getSecurityInformation();
		SecurityFinancePayout.SecurityFinancePayoutBuilder setCollateralProvisions(CollateralProvisions collateralProvisions);
		SecurityFinancePayout.SecurityFinancePayoutBuilder setDividendTerms(DividendTerms dividendTerms);
		SecurityFinancePayout.SecurityFinancePayoutBuilder setDurationType(Duration durationType);
		SecurityFinancePayout.SecurityFinancePayoutBuilder setMeta(MetaFields meta);
		SecurityFinancePayout.SecurityFinancePayoutBuilder setMinimumFee(Money minimumFee);
		SecurityFinancePayout.SecurityFinancePayoutBuilder addSecurityFinanceLeg(SecurityFinanceLeg securityFinanceLeg);
		SecurityFinancePayout.SecurityFinancePayoutBuilder addSecurityFinanceLeg(SecurityFinanceLeg securityFinanceLeg, int _idx);
		SecurityFinancePayout.SecurityFinancePayoutBuilder addSecurityFinanceLeg(List<? extends SecurityFinanceLeg> securityFinanceLeg);
		SecurityFinancePayout.SecurityFinancePayoutBuilder setSecurityFinanceLeg(List<? extends SecurityFinanceLeg> securityFinanceLeg);
		SecurityFinancePayout.SecurityFinancePayoutBuilder setSecurityInformation(Product securityInformation);
		SecurityFinancePayout.SecurityFinancePayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		SecurityFinancePayout.SecurityFinancePayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity);
		SecurityFinancePayout.SecurityFinancePayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PayoutBase.PayoutBaseBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("collateralProvisions"), processor, CollateralProvisions.CollateralProvisionsBuilder.class, getCollateralProvisions());
			processRosetta(path.newSubPath("dividendTerms"), processor, DividendTerms.DividendTermsBuilder.class, getDividendTerms());
			processRosetta(path.newSubPath("durationType"), processor, Duration.DurationBuilder.class, getDurationType());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("minimumFee"), processor, Money.MoneyBuilder.class, getMinimumFee());
			processRosetta(path.newSubPath("securityFinanceLeg"), processor, SecurityFinanceLeg.SecurityFinanceLegBuilder.class, getSecurityFinanceLeg());
			processRosetta(path.newSubPath("securityInformation"), processor, Product.ProductBuilder.class, getSecurityInformation());
		}
		
	}
	
	//SecurityFinancePayout.SecurityFinancePayoutImpl
	class SecurityFinancePayoutImpl extends PayoutBase.PayoutBaseImpl implements SecurityFinancePayout {
		private final CollateralProvisions collateralProvisions;
		private final DividendTerms dividendTerms;
		private final Duration durationType;
		private final MetaFields meta;
		private final Money minimumFee;
		private final List<? extends SecurityFinanceLeg> securityFinanceLeg;
		private final Product securityInformation;
		
		protected SecurityFinancePayoutImpl(SecurityFinancePayout.SecurityFinancePayoutBuilder builder) {
			super(builder);
			this.collateralProvisions = ofNullable(builder.getCollateralProvisions()).map(f->f.build()).orElse(null);
			this.dividendTerms = ofNullable(builder.getDividendTerms()).map(f->f.build()).orElse(null);
			this.durationType = ofNullable(builder.getDurationType()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.minimumFee = ofNullable(builder.getMinimumFee()).map(f->f.build()).orElse(null);
			this.securityFinanceLeg = ofNullable(builder.getSecurityFinanceLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.securityInformation = ofNullable(builder.getSecurityInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CollateralProvisions getCollateralProvisions() {
			return collateralProvisions;
		}
		
		@Override
		public DividendTerms getDividendTerms() {
			return dividendTerms;
		}
		
		@Override
		public Duration getDurationType() {
			return durationType;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Money getMinimumFee() {
			return minimumFee;
		}
		
		@Override
		public List<? extends SecurityFinanceLeg> getSecurityFinanceLeg() {
			return securityFinanceLeg;
		}
		
		@Override
		public Product getSecurityInformation() {
			return securityInformation;
		}
		
		@Override
		public SecurityFinancePayout build() {
			return this;
		}
		
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder toBuilder() {
			SecurityFinancePayout.SecurityFinancePayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityFinancePayout.SecurityFinancePayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCollateralProvisions()).ifPresent(builder::setCollateralProvisions);
			ofNullable(getDividendTerms()).ifPresent(builder::setDividendTerms);
			ofNullable(getDurationType()).ifPresent(builder::setDurationType);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getMinimumFee()).ifPresent(builder::setMinimumFee);
			ofNullable(getSecurityFinanceLeg()).ifPresent(builder::setSecurityFinanceLeg);
			ofNullable(getSecurityInformation()).ifPresent(builder::setSecurityInformation);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SecurityFinancePayout _that = getType().cast(o);
		
			if (!Objects.equals(collateralProvisions, _that.getCollateralProvisions())) return false;
			if (!Objects.equals(dividendTerms, _that.getDividendTerms())) return false;
			if (!Objects.equals(durationType, _that.getDurationType())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(minimumFee, _that.getMinimumFee())) return false;
			if (!ListEquals.listEquals(securityFinanceLeg, _that.getSecurityFinanceLeg())) return false;
			if (!Objects.equals(securityInformation, _that.getSecurityInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (collateralProvisions != null ? collateralProvisions.hashCode() : 0);
			_result = 31 * _result + (dividendTerms != null ? dividendTerms.hashCode() : 0);
			_result = 31 * _result + (durationType != null ? durationType.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (minimumFee != null ? minimumFee.hashCode() : 0);
			_result = 31 * _result + (securityFinanceLeg != null ? securityFinanceLeg.hashCode() : 0);
			_result = 31 * _result + (securityInformation != null ? securityInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityFinancePayout {" +
				"collateralProvisions=" + this.collateralProvisions + ", " +
				"dividendTerms=" + this.dividendTerms + ", " +
				"durationType=" + this.durationType + ", " +
				"meta=" + this.meta + ", " +
				"minimumFee=" + this.minimumFee + ", " +
				"securityFinanceLeg=" + this.securityFinanceLeg + ", " +
				"securityInformation=" + this.securityInformation +
			'}' + " " + super.toString();
		}
	}
	
	//SecurityFinancePayout.SecurityFinancePayoutBuilderImpl
	class SecurityFinancePayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl  implements SecurityFinancePayout.SecurityFinancePayoutBuilder, GlobalKeyBuilder {
	
		protected CollateralProvisions.CollateralProvisionsBuilder collateralProvisions;
		protected DividendTerms.DividendTermsBuilder dividendTerms;
		protected Duration.DurationBuilder durationType;
		protected MetaFields.MetaFieldsBuilder meta;
		protected Money.MoneyBuilder minimumFee;
		protected List<SecurityFinanceLeg.SecurityFinanceLegBuilder> securityFinanceLeg = new ArrayList<>();
		protected Product.ProductBuilder securityInformation;
	
		public SecurityFinancePayoutBuilderImpl() {
		}
	
		@Override
		public CollateralProvisions.CollateralProvisionsBuilder getCollateralProvisions() {
			return collateralProvisions;
		}
		
		@Override
		public CollateralProvisions.CollateralProvisionsBuilder getOrCreateCollateralProvisions() {
			CollateralProvisions.CollateralProvisionsBuilder result;
			if (collateralProvisions!=null) {
				result = collateralProvisions;
			}
			else {
				result = collateralProvisions = CollateralProvisions.builder();
			}
			
			return result;
		}
		
		@Override
		public DividendTerms.DividendTermsBuilder getDividendTerms() {
			return dividendTerms;
		}
		
		@Override
		public DividendTerms.DividendTermsBuilder getOrCreateDividendTerms() {
			DividendTerms.DividendTermsBuilder result;
			if (dividendTerms!=null) {
				result = dividendTerms;
			}
			else {
				result = dividendTerms = DividendTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public Duration.DurationBuilder getDurationType() {
			return durationType;
		}
		
		@Override
		public Duration.DurationBuilder getOrCreateDurationType() {
			Duration.DurationBuilder result;
			if (durationType!=null) {
				result = durationType;
			}
			else {
				result = durationType = Duration.builder();
			}
			
			return result;
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
		public Money.MoneyBuilder getMinimumFee() {
			return minimumFee;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateMinimumFee() {
			Money.MoneyBuilder result;
			if (minimumFee!=null) {
				result = minimumFee;
			}
			else {
				result = minimumFee = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends SecurityFinanceLeg.SecurityFinanceLegBuilder> getSecurityFinanceLeg() {
			return securityFinanceLeg;
		}
		
		public SecurityFinanceLeg.SecurityFinanceLegBuilder getOrCreateSecurityFinanceLeg(int _index) {
		
			if (securityFinanceLeg==null) {
				this.securityFinanceLeg = new ArrayList<>();
			}
			SecurityFinanceLeg.SecurityFinanceLegBuilder result;
			return getIndex(securityFinanceLeg, _index, () -> {
						SecurityFinanceLeg.SecurityFinanceLegBuilder newSecurityFinanceLeg = SecurityFinanceLeg.builder();
						return newSecurityFinanceLeg;
					});
		}
		
		@Override
		public Product.ProductBuilder getSecurityInformation() {
			return securityInformation;
		}
		
		@Override
		public Product.ProductBuilder getOrCreateSecurityInformation() {
			Product.ProductBuilder result;
			if (securityInformation!=null) {
				result = securityInformation;
			}
			else {
				result = securityInformation = Product.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder setCollateralProvisions(CollateralProvisions collateralProvisions) {
			this.collateralProvisions = collateralProvisions==null?null:collateralProvisions.toBuilder();
			return this;
		}
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder setDividendTerms(DividendTerms dividendTerms) {
			this.dividendTerms = dividendTerms==null?null:dividendTerms.toBuilder();
			return this;
		}
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder setDurationType(Duration durationType) {
			this.durationType = durationType==null?null:durationType.toBuilder();
			return this;
		}
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder setMinimumFee(Money minimumFee) {
			this.minimumFee = minimumFee==null?null:minimumFee.toBuilder();
			return this;
		}
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder addSecurityFinanceLeg(SecurityFinanceLeg securityFinanceLeg) {
			if (securityFinanceLeg!=null) this.securityFinanceLeg.add(securityFinanceLeg.toBuilder());
			return this;
		}
		
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder addSecurityFinanceLeg(SecurityFinanceLeg securityFinanceLeg, int _idx) {
			getIndex(this.securityFinanceLeg, _idx, () -> securityFinanceLeg.toBuilder());
			return this;
		}
		@Override 
		public SecurityFinancePayout.SecurityFinancePayoutBuilder addSecurityFinanceLeg(List<? extends SecurityFinanceLeg> securityFinanceLegs) {
			if (securityFinanceLegs != null) {
				for (SecurityFinanceLeg toAdd : securityFinanceLegs) {
					this.securityFinanceLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SecurityFinancePayout.SecurityFinancePayoutBuilder setSecurityFinanceLeg(List<? extends SecurityFinanceLeg> securityFinanceLegs) {
			if (securityFinanceLegs == null)  {
				this.securityFinanceLeg = new ArrayList<>();
			}
			else {
				this.securityFinanceLeg = securityFinanceLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder setSecurityInformation(Product securityInformation) {
			this.securityInformation = securityInformation==null?null:securityInformation.toBuilder();
			return this;
		}
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity) {
			this.payoutQuantity = payoutQuantity==null?null:payoutQuantity.toBuilder();
			return this;
		}
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public SecurityFinancePayout build() {
			return new SecurityFinancePayout.SecurityFinancePayoutImpl(this);
		}
		
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder prune() {
			super.prune();
			if (collateralProvisions!=null && !collateralProvisions.prune().hasData()) collateralProvisions = null;
			if (dividendTerms!=null && !dividendTerms.prune().hasData()) dividendTerms = null;
			if (durationType!=null && !durationType.prune().hasData()) durationType = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (minimumFee!=null && !minimumFee.prune().hasData()) minimumFee = null;
			securityFinanceLeg = securityFinanceLeg.stream().filter(b->b!=null).<SecurityFinanceLeg.SecurityFinanceLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (securityInformation!=null && !securityInformation.prune().hasData()) securityInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCollateralProvisions()!=null && getCollateralProvisions().hasData()) return true;
			if (getDividendTerms()!=null && getDividendTerms().hasData()) return true;
			if (getDurationType()!=null && getDurationType().hasData()) return true;
			if (getMinimumFee()!=null && getMinimumFee().hasData()) return true;
			if (getSecurityFinanceLeg()!=null && getSecurityFinanceLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSecurityInformation()!=null && getSecurityInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityFinancePayout.SecurityFinancePayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SecurityFinancePayout.SecurityFinancePayoutBuilder o = (SecurityFinancePayout.SecurityFinancePayoutBuilder) other;
			
			merger.mergeRosetta(getCollateralProvisions(), o.getCollateralProvisions(), this::setCollateralProvisions);
			merger.mergeRosetta(getDividendTerms(), o.getDividendTerms(), this::setDividendTerms);
			merger.mergeRosetta(getDurationType(), o.getDurationType(), this::setDurationType);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getMinimumFee(), o.getMinimumFee(), this::setMinimumFee);
			merger.mergeRosetta(getSecurityFinanceLeg(), o.getSecurityFinanceLeg(), this::getOrCreateSecurityFinanceLeg);
			merger.mergeRosetta(getSecurityInformation(), o.getSecurityInformation(), this::setSecurityInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SecurityFinancePayout _that = getType().cast(o);
		
			if (!Objects.equals(collateralProvisions, _that.getCollateralProvisions())) return false;
			if (!Objects.equals(dividendTerms, _that.getDividendTerms())) return false;
			if (!Objects.equals(durationType, _that.getDurationType())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(minimumFee, _that.getMinimumFee())) return false;
			if (!ListEquals.listEquals(securityFinanceLeg, _that.getSecurityFinanceLeg())) return false;
			if (!Objects.equals(securityInformation, _that.getSecurityInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (collateralProvisions != null ? collateralProvisions.hashCode() : 0);
			_result = 31 * _result + (dividendTerms != null ? dividendTerms.hashCode() : 0);
			_result = 31 * _result + (durationType != null ? durationType.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (minimumFee != null ? minimumFee.hashCode() : 0);
			_result = 31 * _result + (securityFinanceLeg != null ? securityFinanceLeg.hashCode() : 0);
			_result = 31 * _result + (securityInformation != null ? securityInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityFinancePayoutBuilder {" +
				"collateralProvisions=" + this.collateralProvisions + ", " +
				"dividendTerms=" + this.dividendTerms + ", " +
				"durationType=" + this.durationType + ", " +
				"meta=" + this.meta + ", " +
				"minimumFee=" + this.minimumFee + ", " +
				"securityFinanceLeg=" + this.securityFinanceLeg + ", " +
				"securityInformation=" + this.securityInformation +
			'}' + " " + super.toString();
		}
	}
}
