package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.DistributionAndInterestPaymentMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Distributions and Interest Payment provisions applicable to the Japanese Law ISDA 2016 CSA for Initial Margin and the New York Law ISDA 2016 CSA for Variation Margin. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n): Distributions and Interest Payment (IM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i): Distributions and Interest Payment (VM).
 * @version ${project.version}
 */
@RosettaClass

public interface DistributionAndInterestPayment extends RosettaModelObject {
	DistributionAndInterestPayment build();
	DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder toBuilder();
	
	/**
	 * When the alternative provision clause is specified, it means that the ISDA CSA Japanese Law provisions specified in Paragraph 6(c)(ii) don&#39;t apply and are overwritten by this election. When it is not specified, it means that the ISDA CSA Japanese Law provisions specified in Paragraph 6(c)(ii) apply. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(iv): Alternative to Interest Amount (IM) and Interest Payment (IM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(iv): Alternative to Interest Amount (VM) and Interest Payment (VM).
	 */
	String getAlternativeProvision();
	/**
	 * Daily interest compounding is applicable when True, and not applicable when False. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(iii): Other Interest Elections. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(iii): Other Interest Elections.
	 */
	Boolean getDailyInterestCompounding();
	/**
	 * To election to specify whether the Interest Adjustment is applicable and what its periodicity is. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(ii): Transfer of Interest Payment (VM) or application of Interest Amount (VM).
	 */
	InterestAdjustment getInterestAdjustment();
	/**
	 * The application of Interest Amount with respect to the Delivery Amount and the Return Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).
	 */
	InterestAmount getInterestAmount();
	/**
	 * The Interest Payment Netting is applicable when True. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii): Transfer of Interest Payment (IM) or application of Interest Amount (IM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(ii): Transfer of Interest Payment (VM) or application of Interest Amount (VM).
	 */
	Boolean getInterestPaymentNetting();
	/**
	 * The Interest Payment Transfer is applicable when True. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii): Transfer of Interest Payment (IM) or application of Interest Amount (IM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(ii): Transfer of Interest Payment (VM) or application of Interest Amount (VM).
	 */
	Boolean getInterestPaymentTransfer();
	/**
	 * The interest rate associated with initial or variation margin collateral, depending upon the type of credit agreement that this election is associated with. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(i): Interest Rate (IM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(i): Interest Rate (VM).
	 */
	List<? extends EligibleCurrencyInterestRate> getInterestRate();
	/**
	 * Negative Interest is applicable when True, and not applicable when False. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(iii): Other Interest Elections. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(iii): Other Interest Elections.
	 */
	Boolean getNegativeInterest();
	final static DistributionAndInterestPaymentMeta metaData = new DistributionAndInterestPaymentMeta();
	
	@Override
	default RosettaMetaData<? extends DistributionAndInterestPayment> metaData() {
		return metaData;
	} 
			
	static DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder builder() {
		return new DistributionAndInterestPayment.DistributionAndInterestPaymentBuilderImpl();
	}
	
	default Class<? extends DistributionAndInterestPayment> getType() {
		return DistributionAndInterestPayment.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("alternativeProvision"), String.class, getAlternativeProvision(), this);
		processor.processBasic(path.newSubPath("dailyInterestCompounding"), Boolean.class, getDailyInterestCompounding(), this);
		processor.processBasic(path.newSubPath("interestPaymentNetting"), Boolean.class, getInterestPaymentNetting(), this);
		processor.processBasic(path.newSubPath("interestPaymentTransfer"), Boolean.class, getInterestPaymentTransfer(), this);
		processor.processBasic(path.newSubPath("negativeInterest"), Boolean.class, getNegativeInterest(), this);
		
		processRosetta(path.newSubPath("interestAdjustment"), processor, InterestAdjustment.class, getInterestAdjustment());
		processRosetta(path.newSubPath("interestAmount"), processor, InterestAmount.class, getInterestAmount());
		processRosetta(path.newSubPath("interestRate"), processor, EligibleCurrencyInterestRate.class, getInterestRate());
	}
	
	
	interface DistributionAndInterestPaymentBuilder extends DistributionAndInterestPayment, RosettaModelObjectBuilder {
		InterestAdjustment.InterestAdjustmentBuilder getOrCreateInterestAdjustment();
		InterestAdjustment.InterestAdjustmentBuilder getInterestAdjustment();
		InterestAmount.InterestAmountBuilder getOrCreateInterestAmount();
		InterestAmount.InterestAmountBuilder getInterestAmount();
		EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder getOrCreateInterestRate(int _index);
		List<? extends EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder> getInterestRate();
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setAlternativeProvision(String alternativeProvision);
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setDailyInterestCompounding(Boolean dailyInterestCompounding);
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setInterestAdjustment(InterestAdjustment interestAdjustment);
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setInterestAmount(InterestAmount interestAmount);
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setInterestPaymentNetting(Boolean interestPaymentNetting);
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setInterestPaymentTransfer(Boolean interestPaymentTransfer);
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder addInterestRate(EligibleCurrencyInterestRate interestRate);
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder addInterestRate(EligibleCurrencyInterestRate interestRate, int _idx);
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder addInterestRate(List<? extends EligibleCurrencyInterestRate> interestRate);
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setInterestRate(List<? extends EligibleCurrencyInterestRate> interestRate);
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setNegativeInterest(Boolean negativeInterest);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("alternativeProvision"), String.class, getAlternativeProvision(), this);
			processor.processBasic(path.newSubPath("dailyInterestCompounding"), Boolean.class, getDailyInterestCompounding(), this);
			processor.processBasic(path.newSubPath("interestPaymentNetting"), Boolean.class, getInterestPaymentNetting(), this);
			processor.processBasic(path.newSubPath("interestPaymentTransfer"), Boolean.class, getInterestPaymentTransfer(), this);
			processor.processBasic(path.newSubPath("negativeInterest"), Boolean.class, getNegativeInterest(), this);
			
			processRosetta(path.newSubPath("interestAdjustment"), processor, InterestAdjustment.InterestAdjustmentBuilder.class, getInterestAdjustment());
			processRosetta(path.newSubPath("interestAmount"), processor, InterestAmount.InterestAmountBuilder.class, getInterestAmount());
			processRosetta(path.newSubPath("interestRate"), processor, EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder.class, getInterestRate());
		}
		
	}
	
	//DistributionAndInterestPayment.DistributionAndInterestPaymentImpl
	class DistributionAndInterestPaymentImpl implements DistributionAndInterestPayment {
		private final String alternativeProvision;
		private final Boolean dailyInterestCompounding;
		private final InterestAdjustment interestAdjustment;
		private final InterestAmount interestAmount;
		private final Boolean interestPaymentNetting;
		private final Boolean interestPaymentTransfer;
		private final List<? extends EligibleCurrencyInterestRate> interestRate;
		private final Boolean negativeInterest;
		
		protected DistributionAndInterestPaymentImpl(DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder builder) {
			this.alternativeProvision = builder.getAlternativeProvision();
			this.dailyInterestCompounding = builder.getDailyInterestCompounding();
			this.interestAdjustment = ofNullable(builder.getInterestAdjustment()).map(f->f.build()).orElse(null);
			this.interestAmount = ofNullable(builder.getInterestAmount()).map(f->f.build()).orElse(null);
			this.interestPaymentNetting = builder.getInterestPaymentNetting();
			this.interestPaymentTransfer = builder.getInterestPaymentTransfer();
			this.interestRate = ofNullable(builder.getInterestRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.negativeInterest = builder.getNegativeInterest();
		}
		
		@Override
		public String getAlternativeProvision() {
			return alternativeProvision;
		}
		
		@Override
		public Boolean getDailyInterestCompounding() {
			return dailyInterestCompounding;
		}
		
		@Override
		public InterestAdjustment getInterestAdjustment() {
			return interestAdjustment;
		}
		
		@Override
		public InterestAmount getInterestAmount() {
			return interestAmount;
		}
		
		@Override
		public Boolean getInterestPaymentNetting() {
			return interestPaymentNetting;
		}
		
		@Override
		public Boolean getInterestPaymentTransfer() {
			return interestPaymentTransfer;
		}
		
		@Override
		public List<? extends EligibleCurrencyInterestRate> getInterestRate() {
			return interestRate;
		}
		
		@Override
		public Boolean getNegativeInterest() {
			return negativeInterest;
		}
		
		@Override
		public DistributionAndInterestPayment build() {
			return this;
		}
		
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder toBuilder() {
			DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder builder) {
			ofNullable(getAlternativeProvision()).ifPresent(builder::setAlternativeProvision);
			ofNullable(getDailyInterestCompounding()).ifPresent(builder::setDailyInterestCompounding);
			ofNullable(getInterestAdjustment()).ifPresent(builder::setInterestAdjustment);
			ofNullable(getInterestAmount()).ifPresent(builder::setInterestAmount);
			ofNullable(getInterestPaymentNetting()).ifPresent(builder::setInterestPaymentNetting);
			ofNullable(getInterestPaymentTransfer()).ifPresent(builder::setInterestPaymentTransfer);
			ofNullable(getInterestRate()).ifPresent(builder::setInterestRate);
			ofNullable(getNegativeInterest()).ifPresent(builder::setNegativeInterest);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DistributionAndInterestPayment _that = getType().cast(o);
		
			if (!Objects.equals(alternativeProvision, _that.getAlternativeProvision())) return false;
			if (!Objects.equals(dailyInterestCompounding, _that.getDailyInterestCompounding())) return false;
			if (!Objects.equals(interestAdjustment, _that.getInterestAdjustment())) return false;
			if (!Objects.equals(interestAmount, _that.getInterestAmount())) return false;
			if (!Objects.equals(interestPaymentNetting, _that.getInterestPaymentNetting())) return false;
			if (!Objects.equals(interestPaymentTransfer, _that.getInterestPaymentTransfer())) return false;
			if (!ListEquals.listEquals(interestRate, _that.getInterestRate())) return false;
			if (!Objects.equals(negativeInterest, _that.getNegativeInterest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (alternativeProvision != null ? alternativeProvision.hashCode() : 0);
			_result = 31 * _result + (dailyInterestCompounding != null ? dailyInterestCompounding.hashCode() : 0);
			_result = 31 * _result + (interestAdjustment != null ? interestAdjustment.hashCode() : 0);
			_result = 31 * _result + (interestAmount != null ? interestAmount.hashCode() : 0);
			_result = 31 * _result + (interestPaymentNetting != null ? interestPaymentNetting.hashCode() : 0);
			_result = 31 * _result + (interestPaymentTransfer != null ? interestPaymentTransfer.hashCode() : 0);
			_result = 31 * _result + (interestRate != null ? interestRate.hashCode() : 0);
			_result = 31 * _result + (negativeInterest != null ? negativeInterest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DistributionAndInterestPayment {" +
				"alternativeProvision=" + this.alternativeProvision + ", " +
				"dailyInterestCompounding=" + this.dailyInterestCompounding + ", " +
				"interestAdjustment=" + this.interestAdjustment + ", " +
				"interestAmount=" + this.interestAmount + ", " +
				"interestPaymentNetting=" + this.interestPaymentNetting + ", " +
				"interestPaymentTransfer=" + this.interestPaymentTransfer + ", " +
				"interestRate=" + this.interestRate + ", " +
				"negativeInterest=" + this.negativeInterest +
			'}';
		}
	}
	
	//DistributionAndInterestPayment.DistributionAndInterestPaymentBuilderImpl
	class DistributionAndInterestPaymentBuilderImpl implements DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder {
	
		protected String alternativeProvision;
		protected Boolean dailyInterestCompounding;
		protected InterestAdjustment.InterestAdjustmentBuilder interestAdjustment;
		protected InterestAmount.InterestAmountBuilder interestAmount;
		protected Boolean interestPaymentNetting;
		protected Boolean interestPaymentTransfer;
		protected List<EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder> interestRate = new ArrayList<>();
		protected Boolean negativeInterest;
	
		public DistributionAndInterestPaymentBuilderImpl() {
		}
	
		@Override
		public String getAlternativeProvision() {
			return alternativeProvision;
		}
		
		@Override
		public Boolean getDailyInterestCompounding() {
			return dailyInterestCompounding;
		}
		
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder getInterestAdjustment() {
			return interestAdjustment;
		}
		
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder getOrCreateInterestAdjustment() {
			InterestAdjustment.InterestAdjustmentBuilder result;
			if (interestAdjustment!=null) {
				result = interestAdjustment;
			}
			else {
				result = interestAdjustment = InterestAdjustment.builder();
			}
			
			return result;
		}
		
		@Override
		public InterestAmount.InterestAmountBuilder getInterestAmount() {
			return interestAmount;
		}
		
		@Override
		public InterestAmount.InterestAmountBuilder getOrCreateInterestAmount() {
			InterestAmount.InterestAmountBuilder result;
			if (interestAmount!=null) {
				result = interestAmount;
			}
			else {
				result = interestAmount = InterestAmount.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getInterestPaymentNetting() {
			return interestPaymentNetting;
		}
		
		@Override
		public Boolean getInterestPaymentTransfer() {
			return interestPaymentTransfer;
		}
		
		@Override
		public List<? extends EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder> getInterestRate() {
			return interestRate;
		}
		
		public EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder getOrCreateInterestRate(int _index) {
		
			if (interestRate==null) {
				this.interestRate = new ArrayList<>();
			}
			EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder result;
			return getIndex(interestRate, _index, () -> {
						EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder newInterestRate = EligibleCurrencyInterestRate.builder();
						return newInterestRate;
					});
		}
		
		@Override
		public Boolean getNegativeInterest() {
			return negativeInterest;
		}
		
	
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setAlternativeProvision(String alternativeProvision) {
			this.alternativeProvision = alternativeProvision==null?null:alternativeProvision;
			return this;
		}
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setDailyInterestCompounding(Boolean dailyInterestCompounding) {
			this.dailyInterestCompounding = dailyInterestCompounding==null?null:dailyInterestCompounding;
			return this;
		}
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setInterestAdjustment(InterestAdjustment interestAdjustment) {
			this.interestAdjustment = interestAdjustment==null?null:interestAdjustment.toBuilder();
			return this;
		}
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setInterestAmount(InterestAmount interestAmount) {
			this.interestAmount = interestAmount==null?null:interestAmount.toBuilder();
			return this;
		}
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setInterestPaymentNetting(Boolean interestPaymentNetting) {
			this.interestPaymentNetting = interestPaymentNetting==null?null:interestPaymentNetting;
			return this;
		}
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setInterestPaymentTransfer(Boolean interestPaymentTransfer) {
			this.interestPaymentTransfer = interestPaymentTransfer==null?null:interestPaymentTransfer;
			return this;
		}
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder addInterestRate(EligibleCurrencyInterestRate interestRate) {
			if (interestRate!=null) this.interestRate.add(interestRate.toBuilder());
			return this;
		}
		
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder addInterestRate(EligibleCurrencyInterestRate interestRate, int _idx) {
			getIndex(this.interestRate, _idx, () -> interestRate.toBuilder());
			return this;
		}
		@Override 
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder addInterestRate(List<? extends EligibleCurrencyInterestRate> interestRates) {
			if (interestRates != null) {
				for (EligibleCurrencyInterestRate toAdd : interestRates) {
					this.interestRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setInterestRate(List<? extends EligibleCurrencyInterestRate> interestRates) {
			if (interestRates == null)  {
				this.interestRate = new ArrayList<>();
			}
			else {
				this.interestRate = interestRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder setNegativeInterest(Boolean negativeInterest) {
			this.negativeInterest = negativeInterest==null?null:negativeInterest;
			return this;
		}
		
		@Override
		public DistributionAndInterestPayment build() {
			return new DistributionAndInterestPayment.DistributionAndInterestPaymentImpl(this);
		}
		
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder prune() {
			if (interestAdjustment!=null && !interestAdjustment.prune().hasData()) interestAdjustment = null;
			if (interestAmount!=null && !interestAmount.prune().hasData()) interestAmount = null;
			interestRate = interestRate.stream().filter(b->b!=null).<EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAlternativeProvision()!=null) return true;
			if (getDailyInterestCompounding()!=null) return true;
			if (getInterestAdjustment()!=null && getInterestAdjustment().hasData()) return true;
			if (getInterestAmount()!=null && getInterestAmount().hasData()) return true;
			if (getInterestPaymentNetting()!=null) return true;
			if (getInterestPaymentTransfer()!=null) return true;
			if (getInterestRate()!=null && getInterestRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNegativeInterest()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder o = (DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder) other;
			
			merger.mergeRosetta(getInterestAdjustment(), o.getInterestAdjustment(), this::setInterestAdjustment);
			merger.mergeRosetta(getInterestAmount(), o.getInterestAmount(), this::setInterestAmount);
			merger.mergeRosetta(getInterestRate(), o.getInterestRate(), this::getOrCreateInterestRate);
			
			merger.mergeBasic(getAlternativeProvision(), o.getAlternativeProvision(), this::setAlternativeProvision);
			merger.mergeBasic(getDailyInterestCompounding(), o.getDailyInterestCompounding(), this::setDailyInterestCompounding);
			merger.mergeBasic(getInterestPaymentNetting(), o.getInterestPaymentNetting(), this::setInterestPaymentNetting);
			merger.mergeBasic(getInterestPaymentTransfer(), o.getInterestPaymentTransfer(), this::setInterestPaymentTransfer);
			merger.mergeBasic(getNegativeInterest(), o.getNegativeInterest(), this::setNegativeInterest);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DistributionAndInterestPayment _that = getType().cast(o);
		
			if (!Objects.equals(alternativeProvision, _that.getAlternativeProvision())) return false;
			if (!Objects.equals(dailyInterestCompounding, _that.getDailyInterestCompounding())) return false;
			if (!Objects.equals(interestAdjustment, _that.getInterestAdjustment())) return false;
			if (!Objects.equals(interestAmount, _that.getInterestAmount())) return false;
			if (!Objects.equals(interestPaymentNetting, _that.getInterestPaymentNetting())) return false;
			if (!Objects.equals(interestPaymentTransfer, _that.getInterestPaymentTransfer())) return false;
			if (!ListEquals.listEquals(interestRate, _that.getInterestRate())) return false;
			if (!Objects.equals(negativeInterest, _that.getNegativeInterest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (alternativeProvision != null ? alternativeProvision.hashCode() : 0);
			_result = 31 * _result + (dailyInterestCompounding != null ? dailyInterestCompounding.hashCode() : 0);
			_result = 31 * _result + (interestAdjustment != null ? interestAdjustment.hashCode() : 0);
			_result = 31 * _result + (interestAmount != null ? interestAmount.hashCode() : 0);
			_result = 31 * _result + (interestPaymentNetting != null ? interestPaymentNetting.hashCode() : 0);
			_result = 31 * _result + (interestPaymentTransfer != null ? interestPaymentTransfer.hashCode() : 0);
			_result = 31 * _result + (interestRate != null ? interestRate.hashCode() : 0);
			_result = 31 * _result + (negativeInterest != null ? negativeInterest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DistributionAndInterestPaymentBuilder {" +
				"alternativeProvision=" + this.alternativeProvision + ", " +
				"dailyInterestCompounding=" + this.dailyInterestCompounding + ", " +
				"interestAdjustment=" + this.interestAdjustment + ", " +
				"interestAmount=" + this.interestAmount + ", " +
				"interestPaymentNetting=" + this.interestPaymentNetting + ", " +
				"interestPaymentTransfer=" + this.interestPaymentTransfer + ", " +
				"interestRate=" + this.interestRate + ", " +
				"negativeInterest=" + this.negativeInterest +
			'}';
		}
	}
}
