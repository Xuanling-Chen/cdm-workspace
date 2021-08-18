package cdm.observable.event;

import cdm.observable.asset.Money;
import cdm.observable.event.meta.CreditEventsMeta;
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
 * A class to specify the applicable Credit Events that would trigger a settlement, as specified in the related Confirmation and defined in the ISDA 2014 Credit Definition article IV section 4.1.
 * @version ${project.version}
 */
@RosettaClass

public interface CreditEvents extends RosettaModelObject, GlobalKey {
	CreditEvents build();
	CreditEvents.CreditEventsBuilder toBuilder();
	
	/**
	 * A credit event. The reference entity has been dissolved or has become insolvent. It also covers events that may be a precursor to insolvency such as instigation of bankruptcy or insolvency proceedings. Sovereign trades are not subject to Bankruptcy as &#39;technically&#39; a Sovereign cannot become bankrupt. ISDA 2003 Term: Bankruptcy.
	 */
	Boolean getBankruptcy();
	/**
	 * A specified condition to settlement. An irrevocable written or verbal notice that describes a credit event that has occurred. The notice is sent from the notifying party (either the buyer or the seller) to the counterparty. It provides information relevant to determining that a credit event has occurred. This is typically accompanied by Publicly Available Information. ISDA 2003 Term: Credit Event Notice.
	 */
	CreditEventNotice getCreditEventNotice();
	/**
	 * In relation to certain credit events, serves as a threshold for Obligation Acceleration, Obligation Default, Repudiation/Moratorium and Restructuring. Market standard is USD 10,000,000 (JPY 1,000,000,000 for all Japanese Yen trades). This is applied on an aggregate or total basis across all Obligations of the Reference Entity. Used to prevent technical/operational errors from triggering credit events. ISDA 2003 Term: Default Requirement.
	 */
	Money getDefaultRequirement();
	/**
	 * A credit event. Results from the fact that the rating of the reference obligation is down-graded to a distressed rating level. From a usage standpoint, this credit event is typically not applicable in case of RMBS trades.
	 */
	Boolean getDistressedRatingsDowngrade();
	/**
	 * A credit event. This credit event triggers, after the expiration of any applicable grace period, if the reference entity fails to make due payments in an aggregate amount of not less than the payment requirement on one or more obligations (e.g. a missed coupon payment). ISDA 2003 Term: Failure to Pay.
	 */
	FailureToPay getFailureToPay();
	/**
	 * A credit event. Corresponds to the failure by the Reference Entity to pay an expected interest amount or the payment of an actual interest amount that is less than the expected interest amount. ISDA 2003 Term: Failure to Pay Interest.
	 */
	Boolean getFailureToPayInterest();
	/**
	 * A credit event. Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal.
	 */
	Boolean getFailureToPayPrincipal();
	/**
	 * A credit event. A governmental intervention is an event resulting from an action by a governmental authority that materially impacts the reference entity&#39;s obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2014 Term: Governmental Intervention.
	 */
	Boolean getGovernmentalIntervention();
	/**
	 * A credit event. Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation.
	 */
	Boolean getImpliedWritedown();
	/**
	 * A credit event. Results from the fact that the underlier fails to make principal payments as expected.
	 */
	Boolean getMaturityExtension();
	/**
	 */
	MetaFields getMeta();
	/**
	 * A credit event. One or more of the obligations have been declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay (preferred by the market over Obligation Default, because more definitive and encompasses the definition of Obligation Default - this is more favorable to the Seller). Subject to the default requirement amount. ISDA 2003 Term: Obligation Acceleration.
	 */
	Boolean getObligationAcceleration();
	/**
	 * A credit event. One or more of the obligations have become capable of being declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay. ISDA 2003 Term: Obligation Default.
	 */
	Boolean getObligationDefault();
	/**
	 * A credit event. The reference entity, or a governmental authority, either refuses to recognise or challenges the validity of one or more obligations of the reference entity, or imposes a moratorium thereby postponing payments on one or more of the obligations of the reference entity. Subject to the default requirement amount. ISDA 2003 Term: Repudiation/Moratorium.
	 */
	Boolean getRepudiationMoratorium();
	/**
	 * A credit event. A restructuring is an event that materially impacts the reference entity&#39;s obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2003 Term: Restructuring.
	 */
	Restructuring getRestructuring();
	/**
	 * A credit event. Results from the fact that the underlier writes down its outstanding principal amount.
	 */
	Boolean getWritedown();
	final static CreditEventsMeta metaData = new CreditEventsMeta();
	
	@Override
	default RosettaMetaData<? extends CreditEvents> metaData() {
		return metaData;
	} 
			
	static CreditEvents.CreditEventsBuilder builder() {
		return new CreditEvents.CreditEventsBuilderImpl();
	}
	
	default Class<? extends CreditEvents> getType() {
		return CreditEvents.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bankruptcy"), Boolean.class, getBankruptcy(), this);
		processor.processBasic(path.newSubPath("distressedRatingsDowngrade"), Boolean.class, getDistressedRatingsDowngrade(), this);
		processor.processBasic(path.newSubPath("failureToPayInterest"), Boolean.class, getFailureToPayInterest(), this);
		processor.processBasic(path.newSubPath("failureToPayPrincipal"), Boolean.class, getFailureToPayPrincipal(), this);
		processor.processBasic(path.newSubPath("governmentalIntervention"), Boolean.class, getGovernmentalIntervention(), this);
		processor.processBasic(path.newSubPath("impliedWritedown"), Boolean.class, getImpliedWritedown(), this);
		processor.processBasic(path.newSubPath("maturityExtension"), Boolean.class, getMaturityExtension(), this);
		processor.processBasic(path.newSubPath("obligationAcceleration"), Boolean.class, getObligationAcceleration(), this);
		processor.processBasic(path.newSubPath("obligationDefault"), Boolean.class, getObligationDefault(), this);
		processor.processBasic(path.newSubPath("repudiationMoratorium"), Boolean.class, getRepudiationMoratorium(), this);
		processor.processBasic(path.newSubPath("writedown"), Boolean.class, getWritedown(), this);
		
		processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNotice.class, getCreditEventNotice());
		processRosetta(path.newSubPath("defaultRequirement"), processor, Money.class, getDefaultRequirement());
		processRosetta(path.newSubPath("failureToPay"), processor, FailureToPay.class, getFailureToPay());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("restructuring"), processor, Restructuring.class, getRestructuring());
	}
	
	
	interface CreditEventsBuilder extends CreditEvents, RosettaModelObjectBuilder {
		CreditEventNotice.CreditEventNoticeBuilder getOrCreateCreditEventNotice();
		CreditEventNotice.CreditEventNoticeBuilder getCreditEventNotice();
		Money.MoneyBuilder getOrCreateDefaultRequirement();
		Money.MoneyBuilder getDefaultRequirement();
		FailureToPay.FailureToPayBuilder getOrCreateFailureToPay();
		FailureToPay.FailureToPayBuilder getFailureToPay();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Restructuring.RestructuringBuilder getOrCreateRestructuring();
		Restructuring.RestructuringBuilder getRestructuring();
		CreditEvents.CreditEventsBuilder setBankruptcy(Boolean bankruptcy);
		CreditEvents.CreditEventsBuilder setCreditEventNotice(CreditEventNotice creditEventNotice);
		CreditEvents.CreditEventsBuilder setDefaultRequirement(Money defaultRequirement);
		CreditEvents.CreditEventsBuilder setDistressedRatingsDowngrade(Boolean distressedRatingsDowngrade);
		CreditEvents.CreditEventsBuilder setFailureToPay(FailureToPay failureToPay);
		CreditEvents.CreditEventsBuilder setFailureToPayInterest(Boolean failureToPayInterest);
		CreditEvents.CreditEventsBuilder setFailureToPayPrincipal(Boolean failureToPayPrincipal);
		CreditEvents.CreditEventsBuilder setGovernmentalIntervention(Boolean governmentalIntervention);
		CreditEvents.CreditEventsBuilder setImpliedWritedown(Boolean impliedWritedown);
		CreditEvents.CreditEventsBuilder setMaturityExtension(Boolean maturityExtension);
		CreditEvents.CreditEventsBuilder setMeta(MetaFields meta);
		CreditEvents.CreditEventsBuilder setObligationAcceleration(Boolean obligationAcceleration);
		CreditEvents.CreditEventsBuilder setObligationDefault(Boolean obligationDefault);
		CreditEvents.CreditEventsBuilder setRepudiationMoratorium(Boolean repudiationMoratorium);
		CreditEvents.CreditEventsBuilder setRestructuring(Restructuring restructuring);
		CreditEvents.CreditEventsBuilder setWritedown(Boolean writedown);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("bankruptcy"), Boolean.class, getBankruptcy(), this);
			processor.processBasic(path.newSubPath("distressedRatingsDowngrade"), Boolean.class, getDistressedRatingsDowngrade(), this);
			processor.processBasic(path.newSubPath("failureToPayInterest"), Boolean.class, getFailureToPayInterest(), this);
			processor.processBasic(path.newSubPath("failureToPayPrincipal"), Boolean.class, getFailureToPayPrincipal(), this);
			processor.processBasic(path.newSubPath("governmentalIntervention"), Boolean.class, getGovernmentalIntervention(), this);
			processor.processBasic(path.newSubPath("impliedWritedown"), Boolean.class, getImpliedWritedown(), this);
			processor.processBasic(path.newSubPath("maturityExtension"), Boolean.class, getMaturityExtension(), this);
			processor.processBasic(path.newSubPath("obligationAcceleration"), Boolean.class, getObligationAcceleration(), this);
			processor.processBasic(path.newSubPath("obligationDefault"), Boolean.class, getObligationDefault(), this);
			processor.processBasic(path.newSubPath("repudiationMoratorium"), Boolean.class, getRepudiationMoratorium(), this);
			processor.processBasic(path.newSubPath("writedown"), Boolean.class, getWritedown(), this);
			
			processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNotice.CreditEventNoticeBuilder.class, getCreditEventNotice());
			processRosetta(path.newSubPath("defaultRequirement"), processor, Money.MoneyBuilder.class, getDefaultRequirement());
			processRosetta(path.newSubPath("failureToPay"), processor, FailureToPay.FailureToPayBuilder.class, getFailureToPay());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("restructuring"), processor, Restructuring.RestructuringBuilder.class, getRestructuring());
		}
		
	}
	
	//CreditEvents.CreditEventsImpl
	class CreditEventsImpl implements CreditEvents {
		private final Boolean bankruptcy;
		private final CreditEventNotice creditEventNotice;
		private final Money defaultRequirement;
		private final Boolean distressedRatingsDowngrade;
		private final FailureToPay failureToPay;
		private final Boolean failureToPayInterest;
		private final Boolean failureToPayPrincipal;
		private final Boolean governmentalIntervention;
		private final Boolean impliedWritedown;
		private final Boolean maturityExtension;
		private final MetaFields meta;
		private final Boolean obligationAcceleration;
		private final Boolean obligationDefault;
		private final Boolean repudiationMoratorium;
		private final Restructuring restructuring;
		private final Boolean writedown;
		
		protected CreditEventsImpl(CreditEvents.CreditEventsBuilder builder) {
			this.bankruptcy = builder.getBankruptcy();
			this.creditEventNotice = ofNullable(builder.getCreditEventNotice()).map(f->f.build()).orElse(null);
			this.defaultRequirement = ofNullable(builder.getDefaultRequirement()).map(f->f.build()).orElse(null);
			this.distressedRatingsDowngrade = builder.getDistressedRatingsDowngrade();
			this.failureToPay = ofNullable(builder.getFailureToPay()).map(f->f.build()).orElse(null);
			this.failureToPayInterest = builder.getFailureToPayInterest();
			this.failureToPayPrincipal = builder.getFailureToPayPrincipal();
			this.governmentalIntervention = builder.getGovernmentalIntervention();
			this.impliedWritedown = builder.getImpliedWritedown();
			this.maturityExtension = builder.getMaturityExtension();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.obligationAcceleration = builder.getObligationAcceleration();
			this.obligationDefault = builder.getObligationDefault();
			this.repudiationMoratorium = builder.getRepudiationMoratorium();
			this.restructuring = ofNullable(builder.getRestructuring()).map(f->f.build()).orElse(null);
			this.writedown = builder.getWritedown();
		}
		
		@Override
		public Boolean getBankruptcy() {
			return bankruptcy;
		}
		
		@Override
		public CreditEventNotice getCreditEventNotice() {
			return creditEventNotice;
		}
		
		@Override
		public Money getDefaultRequirement() {
			return defaultRequirement;
		}
		
		@Override
		public Boolean getDistressedRatingsDowngrade() {
			return distressedRatingsDowngrade;
		}
		
		@Override
		public FailureToPay getFailureToPay() {
			return failureToPay;
		}
		
		@Override
		public Boolean getFailureToPayInterest() {
			return failureToPayInterest;
		}
		
		@Override
		public Boolean getFailureToPayPrincipal() {
			return failureToPayPrincipal;
		}
		
		@Override
		public Boolean getGovernmentalIntervention() {
			return governmentalIntervention;
		}
		
		@Override
		public Boolean getImpliedWritedown() {
			return impliedWritedown;
		}
		
		@Override
		public Boolean getMaturityExtension() {
			return maturityExtension;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Boolean getObligationAcceleration() {
			return obligationAcceleration;
		}
		
		@Override
		public Boolean getObligationDefault() {
			return obligationDefault;
		}
		
		@Override
		public Boolean getRepudiationMoratorium() {
			return repudiationMoratorium;
		}
		
		@Override
		public Restructuring getRestructuring() {
			return restructuring;
		}
		
		@Override
		public Boolean getWritedown() {
			return writedown;
		}
		
		@Override
		public CreditEvents build() {
			return this;
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder toBuilder() {
			CreditEvents.CreditEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEvents.CreditEventsBuilder builder) {
			ofNullable(getBankruptcy()).ifPresent(builder::setBankruptcy);
			ofNullable(getCreditEventNotice()).ifPresent(builder::setCreditEventNotice);
			ofNullable(getDefaultRequirement()).ifPresent(builder::setDefaultRequirement);
			ofNullable(getDistressedRatingsDowngrade()).ifPresent(builder::setDistressedRatingsDowngrade);
			ofNullable(getFailureToPay()).ifPresent(builder::setFailureToPay);
			ofNullable(getFailureToPayInterest()).ifPresent(builder::setFailureToPayInterest);
			ofNullable(getFailureToPayPrincipal()).ifPresent(builder::setFailureToPayPrincipal);
			ofNullable(getGovernmentalIntervention()).ifPresent(builder::setGovernmentalIntervention);
			ofNullable(getImpliedWritedown()).ifPresent(builder::setImpliedWritedown);
			ofNullable(getMaturityExtension()).ifPresent(builder::setMaturityExtension);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getObligationAcceleration()).ifPresent(builder::setObligationAcceleration);
			ofNullable(getObligationDefault()).ifPresent(builder::setObligationDefault);
			ofNullable(getRepudiationMoratorium()).ifPresent(builder::setRepudiationMoratorium);
			ofNullable(getRestructuring()).ifPresent(builder::setRestructuring);
			ofNullable(getWritedown()).ifPresent(builder::setWritedown);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEvents _that = getType().cast(o);
		
			if (!Objects.equals(bankruptcy, _that.getBankruptcy())) return false;
			if (!Objects.equals(creditEventNotice, _that.getCreditEventNotice())) return false;
			if (!Objects.equals(defaultRequirement, _that.getDefaultRequirement())) return false;
			if (!Objects.equals(distressedRatingsDowngrade, _that.getDistressedRatingsDowngrade())) return false;
			if (!Objects.equals(failureToPay, _that.getFailureToPay())) return false;
			if (!Objects.equals(failureToPayInterest, _that.getFailureToPayInterest())) return false;
			if (!Objects.equals(failureToPayPrincipal, _that.getFailureToPayPrincipal())) return false;
			if (!Objects.equals(governmentalIntervention, _that.getGovernmentalIntervention())) return false;
			if (!Objects.equals(impliedWritedown, _that.getImpliedWritedown())) return false;
			if (!Objects.equals(maturityExtension, _that.getMaturityExtension())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(obligationAcceleration, _that.getObligationAcceleration())) return false;
			if (!Objects.equals(obligationDefault, _that.getObligationDefault())) return false;
			if (!Objects.equals(repudiationMoratorium, _that.getRepudiationMoratorium())) return false;
			if (!Objects.equals(restructuring, _that.getRestructuring())) return false;
			if (!Objects.equals(writedown, _that.getWritedown())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bankruptcy != null ? bankruptcy.hashCode() : 0);
			_result = 31 * _result + (creditEventNotice != null ? creditEventNotice.hashCode() : 0);
			_result = 31 * _result + (defaultRequirement != null ? defaultRequirement.hashCode() : 0);
			_result = 31 * _result + (distressedRatingsDowngrade != null ? distressedRatingsDowngrade.hashCode() : 0);
			_result = 31 * _result + (failureToPay != null ? failureToPay.hashCode() : 0);
			_result = 31 * _result + (failureToPayInterest != null ? failureToPayInterest.hashCode() : 0);
			_result = 31 * _result + (failureToPayPrincipal != null ? failureToPayPrincipal.hashCode() : 0);
			_result = 31 * _result + (governmentalIntervention != null ? governmentalIntervention.hashCode() : 0);
			_result = 31 * _result + (impliedWritedown != null ? impliedWritedown.hashCode() : 0);
			_result = 31 * _result + (maturityExtension != null ? maturityExtension.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (obligationAcceleration != null ? obligationAcceleration.hashCode() : 0);
			_result = 31 * _result + (obligationDefault != null ? obligationDefault.hashCode() : 0);
			_result = 31 * _result + (repudiationMoratorium != null ? repudiationMoratorium.hashCode() : 0);
			_result = 31 * _result + (restructuring != null ? restructuring.hashCode() : 0);
			_result = 31 * _result + (writedown != null ? writedown.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEvents {" +
				"bankruptcy=" + this.bankruptcy + ", " +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"defaultRequirement=" + this.defaultRequirement + ", " +
				"distressedRatingsDowngrade=" + this.distressedRatingsDowngrade + ", " +
				"failureToPay=" + this.failureToPay + ", " +
				"failureToPayInterest=" + this.failureToPayInterest + ", " +
				"failureToPayPrincipal=" + this.failureToPayPrincipal + ", " +
				"governmentalIntervention=" + this.governmentalIntervention + ", " +
				"impliedWritedown=" + this.impliedWritedown + ", " +
				"maturityExtension=" + this.maturityExtension + ", " +
				"meta=" + this.meta + ", " +
				"obligationAcceleration=" + this.obligationAcceleration + ", " +
				"obligationDefault=" + this.obligationDefault + ", " +
				"repudiationMoratorium=" + this.repudiationMoratorium + ", " +
				"restructuring=" + this.restructuring + ", " +
				"writedown=" + this.writedown +
			'}';
		}
	}
	
	//CreditEvents.CreditEventsBuilderImpl
	class CreditEventsBuilderImpl implements CreditEvents.CreditEventsBuilder, GlobalKeyBuilder {
	
		protected Boolean bankruptcy;
		protected CreditEventNotice.CreditEventNoticeBuilder creditEventNotice;
		protected Money.MoneyBuilder defaultRequirement;
		protected Boolean distressedRatingsDowngrade;
		protected FailureToPay.FailureToPayBuilder failureToPay;
		protected Boolean failureToPayInterest;
		protected Boolean failureToPayPrincipal;
		protected Boolean governmentalIntervention;
		protected Boolean impliedWritedown;
		protected Boolean maturityExtension;
		protected MetaFields.MetaFieldsBuilder meta;
		protected Boolean obligationAcceleration;
		protected Boolean obligationDefault;
		protected Boolean repudiationMoratorium;
		protected Restructuring.RestructuringBuilder restructuring;
		protected Boolean writedown;
	
		public CreditEventsBuilderImpl() {
		}
	
		@Override
		public Boolean getBankruptcy() {
			return bankruptcy;
		}
		
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder getCreditEventNotice() {
			return creditEventNotice;
		}
		
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder getOrCreateCreditEventNotice() {
			CreditEventNotice.CreditEventNoticeBuilder result;
			if (creditEventNotice!=null) {
				result = creditEventNotice;
			}
			else {
				result = creditEventNotice = CreditEventNotice.builder();
			}
			
			return result;
		}
		
		@Override
		public Money.MoneyBuilder getDefaultRequirement() {
			return defaultRequirement;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateDefaultRequirement() {
			Money.MoneyBuilder result;
			if (defaultRequirement!=null) {
				result = defaultRequirement;
			}
			else {
				result = defaultRequirement = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getDistressedRatingsDowngrade() {
			return distressedRatingsDowngrade;
		}
		
		@Override
		public FailureToPay.FailureToPayBuilder getFailureToPay() {
			return failureToPay;
		}
		
		@Override
		public FailureToPay.FailureToPayBuilder getOrCreateFailureToPay() {
			FailureToPay.FailureToPayBuilder result;
			if (failureToPay!=null) {
				result = failureToPay;
			}
			else {
				result = failureToPay = FailureToPay.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getFailureToPayInterest() {
			return failureToPayInterest;
		}
		
		@Override
		public Boolean getFailureToPayPrincipal() {
			return failureToPayPrincipal;
		}
		
		@Override
		public Boolean getGovernmentalIntervention() {
			return governmentalIntervention;
		}
		
		@Override
		public Boolean getImpliedWritedown() {
			return impliedWritedown;
		}
		
		@Override
		public Boolean getMaturityExtension() {
			return maturityExtension;
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
		public Boolean getObligationAcceleration() {
			return obligationAcceleration;
		}
		
		@Override
		public Boolean getObligationDefault() {
			return obligationDefault;
		}
		
		@Override
		public Boolean getRepudiationMoratorium() {
			return repudiationMoratorium;
		}
		
		@Override
		public Restructuring.RestructuringBuilder getRestructuring() {
			return restructuring;
		}
		
		@Override
		public Restructuring.RestructuringBuilder getOrCreateRestructuring() {
			Restructuring.RestructuringBuilder result;
			if (restructuring!=null) {
				result = restructuring;
			}
			else {
				result = restructuring = Restructuring.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getWritedown() {
			return writedown;
		}
		
	
		@Override
		public CreditEvents.CreditEventsBuilder setBankruptcy(Boolean bankruptcy) {
			this.bankruptcy = bankruptcy==null?null:bankruptcy;
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setCreditEventNotice(CreditEventNotice creditEventNotice) {
			this.creditEventNotice = creditEventNotice==null?null:creditEventNotice.toBuilder();
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setDefaultRequirement(Money defaultRequirement) {
			this.defaultRequirement = defaultRequirement==null?null:defaultRequirement.toBuilder();
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setDistressedRatingsDowngrade(Boolean distressedRatingsDowngrade) {
			this.distressedRatingsDowngrade = distressedRatingsDowngrade==null?null:distressedRatingsDowngrade;
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setFailureToPay(FailureToPay failureToPay) {
			this.failureToPay = failureToPay==null?null:failureToPay.toBuilder();
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setFailureToPayInterest(Boolean failureToPayInterest) {
			this.failureToPayInterest = failureToPayInterest==null?null:failureToPayInterest;
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setFailureToPayPrincipal(Boolean failureToPayPrincipal) {
			this.failureToPayPrincipal = failureToPayPrincipal==null?null:failureToPayPrincipal;
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setGovernmentalIntervention(Boolean governmentalIntervention) {
			this.governmentalIntervention = governmentalIntervention==null?null:governmentalIntervention;
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setImpliedWritedown(Boolean impliedWritedown) {
			this.impliedWritedown = impliedWritedown==null?null:impliedWritedown;
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setMaturityExtension(Boolean maturityExtension) {
			this.maturityExtension = maturityExtension==null?null:maturityExtension;
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setObligationAcceleration(Boolean obligationAcceleration) {
			this.obligationAcceleration = obligationAcceleration==null?null:obligationAcceleration;
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setObligationDefault(Boolean obligationDefault) {
			this.obligationDefault = obligationDefault==null?null:obligationDefault;
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setRepudiationMoratorium(Boolean repudiationMoratorium) {
			this.repudiationMoratorium = repudiationMoratorium==null?null:repudiationMoratorium;
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setRestructuring(Restructuring restructuring) {
			this.restructuring = restructuring==null?null:restructuring.toBuilder();
			return this;
		}
		@Override
		public CreditEvents.CreditEventsBuilder setWritedown(Boolean writedown) {
			this.writedown = writedown==null?null:writedown;
			return this;
		}
		
		@Override
		public CreditEvents build() {
			return new CreditEvents.CreditEventsImpl(this);
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEvents.CreditEventsBuilder prune() {
			if (creditEventNotice!=null && !creditEventNotice.prune().hasData()) creditEventNotice = null;
			if (defaultRequirement!=null && !defaultRequirement.prune().hasData()) defaultRequirement = null;
			if (failureToPay!=null && !failureToPay.prune().hasData()) failureToPay = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (restructuring!=null && !restructuring.prune().hasData()) restructuring = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBankruptcy()!=null) return true;
			if (getCreditEventNotice()!=null && getCreditEventNotice().hasData()) return true;
			if (getDefaultRequirement()!=null && getDefaultRequirement().hasData()) return true;
			if (getDistressedRatingsDowngrade()!=null) return true;
			if (getFailureToPay()!=null && getFailureToPay().hasData()) return true;
			if (getFailureToPayInterest()!=null) return true;
			if (getFailureToPayPrincipal()!=null) return true;
			if (getGovernmentalIntervention()!=null) return true;
			if (getImpliedWritedown()!=null) return true;
			if (getMaturityExtension()!=null) return true;
			if (getObligationAcceleration()!=null) return true;
			if (getObligationDefault()!=null) return true;
			if (getRepudiationMoratorium()!=null) return true;
			if (getRestructuring()!=null && getRestructuring().hasData()) return true;
			if (getWritedown()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEvents.CreditEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditEvents.CreditEventsBuilder o = (CreditEvents.CreditEventsBuilder) other;
			
			merger.mergeRosetta(getCreditEventNotice(), o.getCreditEventNotice(), this::setCreditEventNotice);
			merger.mergeRosetta(getDefaultRequirement(), o.getDefaultRequirement(), this::setDefaultRequirement);
			merger.mergeRosetta(getFailureToPay(), o.getFailureToPay(), this::setFailureToPay);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getRestructuring(), o.getRestructuring(), this::setRestructuring);
			
			merger.mergeBasic(getBankruptcy(), o.getBankruptcy(), this::setBankruptcy);
			merger.mergeBasic(getDistressedRatingsDowngrade(), o.getDistressedRatingsDowngrade(), this::setDistressedRatingsDowngrade);
			merger.mergeBasic(getFailureToPayInterest(), o.getFailureToPayInterest(), this::setFailureToPayInterest);
			merger.mergeBasic(getFailureToPayPrincipal(), o.getFailureToPayPrincipal(), this::setFailureToPayPrincipal);
			merger.mergeBasic(getGovernmentalIntervention(), o.getGovernmentalIntervention(), this::setGovernmentalIntervention);
			merger.mergeBasic(getImpliedWritedown(), o.getImpliedWritedown(), this::setImpliedWritedown);
			merger.mergeBasic(getMaturityExtension(), o.getMaturityExtension(), this::setMaturityExtension);
			merger.mergeBasic(getObligationAcceleration(), o.getObligationAcceleration(), this::setObligationAcceleration);
			merger.mergeBasic(getObligationDefault(), o.getObligationDefault(), this::setObligationDefault);
			merger.mergeBasic(getRepudiationMoratorium(), o.getRepudiationMoratorium(), this::setRepudiationMoratorium);
			merger.mergeBasic(getWritedown(), o.getWritedown(), this::setWritedown);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEvents _that = getType().cast(o);
		
			if (!Objects.equals(bankruptcy, _that.getBankruptcy())) return false;
			if (!Objects.equals(creditEventNotice, _that.getCreditEventNotice())) return false;
			if (!Objects.equals(defaultRequirement, _that.getDefaultRequirement())) return false;
			if (!Objects.equals(distressedRatingsDowngrade, _that.getDistressedRatingsDowngrade())) return false;
			if (!Objects.equals(failureToPay, _that.getFailureToPay())) return false;
			if (!Objects.equals(failureToPayInterest, _that.getFailureToPayInterest())) return false;
			if (!Objects.equals(failureToPayPrincipal, _that.getFailureToPayPrincipal())) return false;
			if (!Objects.equals(governmentalIntervention, _that.getGovernmentalIntervention())) return false;
			if (!Objects.equals(impliedWritedown, _that.getImpliedWritedown())) return false;
			if (!Objects.equals(maturityExtension, _that.getMaturityExtension())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(obligationAcceleration, _that.getObligationAcceleration())) return false;
			if (!Objects.equals(obligationDefault, _that.getObligationDefault())) return false;
			if (!Objects.equals(repudiationMoratorium, _that.getRepudiationMoratorium())) return false;
			if (!Objects.equals(restructuring, _that.getRestructuring())) return false;
			if (!Objects.equals(writedown, _that.getWritedown())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bankruptcy != null ? bankruptcy.hashCode() : 0);
			_result = 31 * _result + (creditEventNotice != null ? creditEventNotice.hashCode() : 0);
			_result = 31 * _result + (defaultRequirement != null ? defaultRequirement.hashCode() : 0);
			_result = 31 * _result + (distressedRatingsDowngrade != null ? distressedRatingsDowngrade.hashCode() : 0);
			_result = 31 * _result + (failureToPay != null ? failureToPay.hashCode() : 0);
			_result = 31 * _result + (failureToPayInterest != null ? failureToPayInterest.hashCode() : 0);
			_result = 31 * _result + (failureToPayPrincipal != null ? failureToPayPrincipal.hashCode() : 0);
			_result = 31 * _result + (governmentalIntervention != null ? governmentalIntervention.hashCode() : 0);
			_result = 31 * _result + (impliedWritedown != null ? impliedWritedown.hashCode() : 0);
			_result = 31 * _result + (maturityExtension != null ? maturityExtension.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (obligationAcceleration != null ? obligationAcceleration.hashCode() : 0);
			_result = 31 * _result + (obligationDefault != null ? obligationDefault.hashCode() : 0);
			_result = 31 * _result + (repudiationMoratorium != null ? repudiationMoratorium.hashCode() : 0);
			_result = 31 * _result + (restructuring != null ? restructuring.hashCode() : 0);
			_result = 31 * _result + (writedown != null ? writedown.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventsBuilder {" +
				"bankruptcy=" + this.bankruptcy + ", " +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"defaultRequirement=" + this.defaultRequirement + ", " +
				"distressedRatingsDowngrade=" + this.distressedRatingsDowngrade + ", " +
				"failureToPay=" + this.failureToPay + ", " +
				"failureToPayInterest=" + this.failureToPayInterest + ", " +
				"failureToPayPrincipal=" + this.failureToPayPrincipal + ", " +
				"governmentalIntervention=" + this.governmentalIntervention + ", " +
				"impliedWritedown=" + this.impliedWritedown + ", " +
				"maturityExtension=" + this.maturityExtension + ", " +
				"meta=" + this.meta + ", " +
				"obligationAcceleration=" + this.obligationAcceleration + ", " +
				"obligationDefault=" + this.obligationDefault + ", " +
				"repudiationMoratorium=" + this.repudiationMoratorium + ", " +
				"restructuring=" + this.restructuring + ", " +
				"writedown=" + this.writedown +
			'}';
		}
	}
}
