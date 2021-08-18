package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CreditSupportObligationsMeta;
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
 * A class to specify the Credit Support Obligations applicable to the Initial Margin Credit Support Annex and which are common among the English, Japanese and New York governing laws. This excludes the Other Eligible Support election (which only applies to the Japanese Law and New York Law agreements) and the Transfer Timing election (which only applies to the English Law and the New York Law agreements). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c): Credit Support Obligations. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d): Credit Support Obligations. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c): Credit Support Obligations.
 * @version ${project.version}
 */
@RosettaClass

public interface CreditSupportObligations extends RosettaModelObject {
	CreditSupportObligations build();
	CreditSupportObligations.CreditSupportObligationsBuilder toBuilder();
	
	/**
	 * The time by which the transfer of collateral must take place when different from the Regular Settlement Day as a result of parties&#39; election.
	 */
	BespokeTransferTiming getBespokeTransferTiming();
	/**
	 * The specification of Credit Support Obligations applicable to Variation Margin agreements.
	 */
	CreditSupportObligationsVariationMargin getCreditSupportObligationsVariationMargin();
	/**
	 * Delivery Amount (VM) has the meaning specified in Paragraph 3(a), unless otherwise specified here.
	 */
	String getDeliveryAmount();
	/**
	 * The selection of Margin Approach applicable to the agreement.
	 */
	MarginApproach getMarginApproach();
	/**
	 * The net amount of exposure reached before collateral has to be posted or returned. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(B): Minimum Transfer Amount. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(B): Minimum Transfer Amount. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(B): Minimum Transfer Amount.
	 */
	MinimumTransferAmount getMinimumTransferAmount();
	/**
	 * The Other Eligible Support election. If not specified, this election is deemed as not applicable.
	 */
	String getOtherEligibleSupport();
	/**
	 * Return Amount (VM) has the meaning specified in Paragraph 3(a), unless otherwise specified here.
	 */
	String getReturnAmount();
	/**
	 * The rounding methodology applicable to the Delivery Amount and the Return Amount in terms of nearest integral multiple of Base Currency units. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(C): Rounding. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(C): Rounding. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(C): Rounding.
	 */
	CollateralRounding getRounding();
	/**
	 * The amount of net exposure that a party is willing to bear in relation to the other party before it requires asking for collateral. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(A): Threshold. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(A): Threshold. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(A): Threshold.
	 */
	Threshold getThreshold();
	final static CreditSupportObligationsMeta metaData = new CreditSupportObligationsMeta();
	
	@Override
	default RosettaMetaData<? extends CreditSupportObligations> metaData() {
		return metaData;
	} 
			
	static CreditSupportObligations.CreditSupportObligationsBuilder builder() {
		return new CreditSupportObligations.CreditSupportObligationsBuilderImpl();
	}
	
	default Class<? extends CreditSupportObligations> getType() {
		return CreditSupportObligations.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("deliveryAmount"), String.class, getDeliveryAmount(), this);
		processor.processBasic(path.newSubPath("otherEligibleSupport"), String.class, getOtherEligibleSupport(), this);
		processor.processBasic(path.newSubPath("returnAmount"), String.class, getReturnAmount(), this);
		
		processRosetta(path.newSubPath("bespokeTransferTiming"), processor, BespokeTransferTiming.class, getBespokeTransferTiming());
		processRosetta(path.newSubPath("creditSupportObligationsVariationMargin"), processor, CreditSupportObligationsVariationMargin.class, getCreditSupportObligationsVariationMargin());
		processRosetta(path.newSubPath("marginApproach"), processor, MarginApproach.class, getMarginApproach());
		processRosetta(path.newSubPath("minimumTransferAmount"), processor, MinimumTransferAmount.class, getMinimumTransferAmount());
		processRosetta(path.newSubPath("rounding"), processor, CollateralRounding.class, getRounding());
		processRosetta(path.newSubPath("threshold"), processor, Threshold.class, getThreshold());
	}
	
	
	interface CreditSupportObligationsBuilder extends CreditSupportObligations, RosettaModelObjectBuilder {
		BespokeTransferTiming.BespokeTransferTimingBuilder getOrCreateBespokeTransferTiming();
		BespokeTransferTiming.BespokeTransferTimingBuilder getBespokeTransferTiming();
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder getOrCreateCreditSupportObligationsVariationMargin();
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder getCreditSupportObligationsVariationMargin();
		MarginApproach.MarginApproachBuilder getOrCreateMarginApproach();
		MarginApproach.MarginApproachBuilder getMarginApproach();
		MinimumTransferAmount.MinimumTransferAmountBuilder getOrCreateMinimumTransferAmount();
		MinimumTransferAmount.MinimumTransferAmountBuilder getMinimumTransferAmount();
		CollateralRounding.CollateralRoundingBuilder getOrCreateRounding();
		CollateralRounding.CollateralRoundingBuilder getRounding();
		Threshold.ThresholdBuilder getOrCreateThreshold();
		Threshold.ThresholdBuilder getThreshold();
		CreditSupportObligations.CreditSupportObligationsBuilder setBespokeTransferTiming(BespokeTransferTiming bespokeTransferTiming);
		CreditSupportObligations.CreditSupportObligationsBuilder setCreditSupportObligationsVariationMargin(CreditSupportObligationsVariationMargin creditSupportObligationsVariationMargin);
		CreditSupportObligations.CreditSupportObligationsBuilder setDeliveryAmount(String deliveryAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder setMarginApproach(MarginApproach marginApproach);
		CreditSupportObligations.CreditSupportObligationsBuilder setMinimumTransferAmount(MinimumTransferAmount minimumTransferAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder setOtherEligibleSupport(String otherEligibleSupport);
		CreditSupportObligations.CreditSupportObligationsBuilder setReturnAmount(String returnAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder setRounding(CollateralRounding rounding);
		CreditSupportObligations.CreditSupportObligationsBuilder setThreshold(Threshold threshold);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("deliveryAmount"), String.class, getDeliveryAmount(), this);
			processor.processBasic(path.newSubPath("otherEligibleSupport"), String.class, getOtherEligibleSupport(), this);
			processor.processBasic(path.newSubPath("returnAmount"), String.class, getReturnAmount(), this);
			
			processRosetta(path.newSubPath("bespokeTransferTiming"), processor, BespokeTransferTiming.BespokeTransferTimingBuilder.class, getBespokeTransferTiming());
			processRosetta(path.newSubPath("creditSupportObligationsVariationMargin"), processor, CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder.class, getCreditSupportObligationsVariationMargin());
			processRosetta(path.newSubPath("marginApproach"), processor, MarginApproach.MarginApproachBuilder.class, getMarginApproach());
			processRosetta(path.newSubPath("minimumTransferAmount"), processor, MinimumTransferAmount.MinimumTransferAmountBuilder.class, getMinimumTransferAmount());
			processRosetta(path.newSubPath("rounding"), processor, CollateralRounding.CollateralRoundingBuilder.class, getRounding());
			processRosetta(path.newSubPath("threshold"), processor, Threshold.ThresholdBuilder.class, getThreshold());
		}
		
	}
	
	//CreditSupportObligations.CreditSupportObligationsImpl
	class CreditSupportObligationsImpl implements CreditSupportObligations {
		private final BespokeTransferTiming bespokeTransferTiming;
		private final CreditSupportObligationsVariationMargin creditSupportObligationsVariationMargin;
		private final String deliveryAmount;
		private final MarginApproach marginApproach;
		private final MinimumTransferAmount minimumTransferAmount;
		private final String otherEligibleSupport;
		private final String returnAmount;
		private final CollateralRounding rounding;
		private final Threshold threshold;
		
		protected CreditSupportObligationsImpl(CreditSupportObligations.CreditSupportObligationsBuilder builder) {
			this.bespokeTransferTiming = ofNullable(builder.getBespokeTransferTiming()).map(f->f.build()).orElse(null);
			this.creditSupportObligationsVariationMargin = ofNullable(builder.getCreditSupportObligationsVariationMargin()).map(f->f.build()).orElse(null);
			this.deliveryAmount = builder.getDeliveryAmount();
			this.marginApproach = ofNullable(builder.getMarginApproach()).map(f->f.build()).orElse(null);
			this.minimumTransferAmount = ofNullable(builder.getMinimumTransferAmount()).map(f->f.build()).orElse(null);
			this.otherEligibleSupport = builder.getOtherEligibleSupport();
			this.returnAmount = builder.getReturnAmount();
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
			this.threshold = ofNullable(builder.getThreshold()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BespokeTransferTiming getBespokeTransferTiming() {
			return bespokeTransferTiming;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin getCreditSupportObligationsVariationMargin() {
			return creditSupportObligationsVariationMargin;
		}
		
		@Override
		public String getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		public MarginApproach getMarginApproach() {
			return marginApproach;
		}
		
		@Override
		public MinimumTransferAmount getMinimumTransferAmount() {
			return minimumTransferAmount;
		}
		
		@Override
		public String getOtherEligibleSupport() {
			return otherEligibleSupport;
		}
		
		@Override
		public String getReturnAmount() {
			return returnAmount;
		}
		
		@Override
		public CollateralRounding getRounding() {
			return rounding;
		}
		
		@Override
		public Threshold getThreshold() {
			return threshold;
		}
		
		@Override
		public CreditSupportObligations build() {
			return this;
		}
		
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder toBuilder() {
			CreditSupportObligations.CreditSupportObligationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportObligations.CreditSupportObligationsBuilder builder) {
			ofNullable(getBespokeTransferTiming()).ifPresent(builder::setBespokeTransferTiming);
			ofNullable(getCreditSupportObligationsVariationMargin()).ifPresent(builder::setCreditSupportObligationsVariationMargin);
			ofNullable(getDeliveryAmount()).ifPresent(builder::setDeliveryAmount);
			ofNullable(getMarginApproach()).ifPresent(builder::setMarginApproach);
			ofNullable(getMinimumTransferAmount()).ifPresent(builder::setMinimumTransferAmount);
			ofNullable(getOtherEligibleSupport()).ifPresent(builder::setOtherEligibleSupport);
			ofNullable(getReturnAmount()).ifPresent(builder::setReturnAmount);
			ofNullable(getRounding()).ifPresent(builder::setRounding);
			ofNullable(getThreshold()).ifPresent(builder::setThreshold);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportObligations _that = getType().cast(o);
		
			if (!Objects.equals(bespokeTransferTiming, _that.getBespokeTransferTiming())) return false;
			if (!Objects.equals(creditSupportObligationsVariationMargin, _that.getCreditSupportObligationsVariationMargin())) return false;
			if (!Objects.equals(deliveryAmount, _that.getDeliveryAmount())) return false;
			if (!Objects.equals(marginApproach, _that.getMarginApproach())) return false;
			if (!Objects.equals(minimumTransferAmount, _that.getMinimumTransferAmount())) return false;
			if (!Objects.equals(otherEligibleSupport, _that.getOtherEligibleSupport())) return false;
			if (!Objects.equals(returnAmount, _that.getReturnAmount())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			if (!Objects.equals(threshold, _that.getThreshold())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeTransferTiming != null ? bespokeTransferTiming.hashCode() : 0);
			_result = 31 * _result + (creditSupportObligationsVariationMargin != null ? creditSupportObligationsVariationMargin.hashCode() : 0);
			_result = 31 * _result + (deliveryAmount != null ? deliveryAmount.hashCode() : 0);
			_result = 31 * _result + (marginApproach != null ? marginApproach.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmount != null ? minimumTransferAmount.hashCode() : 0);
			_result = 31 * _result + (otherEligibleSupport != null ? otherEligibleSupport.hashCode() : 0);
			_result = 31 * _result + (returnAmount != null ? returnAmount.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			_result = 31 * _result + (threshold != null ? threshold.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportObligations {" +
				"bespokeTransferTiming=" + this.bespokeTransferTiming + ", " +
				"creditSupportObligationsVariationMargin=" + this.creditSupportObligationsVariationMargin + ", " +
				"deliveryAmount=" + this.deliveryAmount + ", " +
				"marginApproach=" + this.marginApproach + ", " +
				"minimumTransferAmount=" + this.minimumTransferAmount + ", " +
				"otherEligibleSupport=" + this.otherEligibleSupport + ", " +
				"returnAmount=" + this.returnAmount + ", " +
				"rounding=" + this.rounding + ", " +
				"threshold=" + this.threshold +
			'}';
		}
	}
	
	//CreditSupportObligations.CreditSupportObligationsBuilderImpl
	class CreditSupportObligationsBuilderImpl implements CreditSupportObligations.CreditSupportObligationsBuilder {
	
		protected BespokeTransferTiming.BespokeTransferTimingBuilder bespokeTransferTiming;
		protected CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder creditSupportObligationsVariationMargin;
		protected String deliveryAmount;
		protected MarginApproach.MarginApproachBuilder marginApproach;
		protected MinimumTransferAmount.MinimumTransferAmountBuilder minimumTransferAmount;
		protected String otherEligibleSupport;
		protected String returnAmount;
		protected CollateralRounding.CollateralRoundingBuilder rounding;
		protected Threshold.ThresholdBuilder threshold;
	
		public CreditSupportObligationsBuilderImpl() {
		}
	
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder getBespokeTransferTiming() {
			return bespokeTransferTiming;
		}
		
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder getOrCreateBespokeTransferTiming() {
			BespokeTransferTiming.BespokeTransferTimingBuilder result;
			if (bespokeTransferTiming!=null) {
				result = bespokeTransferTiming;
			}
			else {
				result = bespokeTransferTiming = BespokeTransferTiming.builder();
			}
			
			return result;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder getCreditSupportObligationsVariationMargin() {
			return creditSupportObligationsVariationMargin;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder getOrCreateCreditSupportObligationsVariationMargin() {
			CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder result;
			if (creditSupportObligationsVariationMargin!=null) {
				result = creditSupportObligationsVariationMargin;
			}
			else {
				result = creditSupportObligationsVariationMargin = CreditSupportObligationsVariationMargin.builder();
			}
			
			return result;
		}
		
		@Override
		public String getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		public MarginApproach.MarginApproachBuilder getMarginApproach() {
			return marginApproach;
		}
		
		@Override
		public MarginApproach.MarginApproachBuilder getOrCreateMarginApproach() {
			MarginApproach.MarginApproachBuilder result;
			if (marginApproach!=null) {
				result = marginApproach;
			}
			else {
				result = marginApproach = MarginApproach.builder();
			}
			
			return result;
		}
		
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder getMinimumTransferAmount() {
			return minimumTransferAmount;
		}
		
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder getOrCreateMinimumTransferAmount() {
			MinimumTransferAmount.MinimumTransferAmountBuilder result;
			if (minimumTransferAmount!=null) {
				result = minimumTransferAmount;
			}
			else {
				result = minimumTransferAmount = MinimumTransferAmount.builder();
			}
			
			return result;
		}
		
		@Override
		public String getOtherEligibleSupport() {
			return otherEligibleSupport;
		}
		
		@Override
		public String getReturnAmount() {
			return returnAmount;
		}
		
		@Override
		public CollateralRounding.CollateralRoundingBuilder getRounding() {
			return rounding;
		}
		
		@Override
		public CollateralRounding.CollateralRoundingBuilder getOrCreateRounding() {
			CollateralRounding.CollateralRoundingBuilder result;
			if (rounding!=null) {
				result = rounding;
			}
			else {
				result = rounding = CollateralRounding.builder();
			}
			
			return result;
		}
		
		@Override
		public Threshold.ThresholdBuilder getThreshold() {
			return threshold;
		}
		
		@Override
		public Threshold.ThresholdBuilder getOrCreateThreshold() {
			Threshold.ThresholdBuilder result;
			if (threshold!=null) {
				result = threshold;
			}
			else {
				result = threshold = Threshold.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setBespokeTransferTiming(BespokeTransferTiming bespokeTransferTiming) {
			this.bespokeTransferTiming = bespokeTransferTiming==null?null:bespokeTransferTiming.toBuilder();
			return this;
		}
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setCreditSupportObligationsVariationMargin(CreditSupportObligationsVariationMargin creditSupportObligationsVariationMargin) {
			this.creditSupportObligationsVariationMargin = creditSupportObligationsVariationMargin==null?null:creditSupportObligationsVariationMargin.toBuilder();
			return this;
		}
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setDeliveryAmount(String deliveryAmount) {
			this.deliveryAmount = deliveryAmount==null?null:deliveryAmount;
			return this;
		}
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setMarginApproach(MarginApproach marginApproach) {
			this.marginApproach = marginApproach==null?null:marginApproach.toBuilder();
			return this;
		}
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setMinimumTransferAmount(MinimumTransferAmount minimumTransferAmount) {
			this.minimumTransferAmount = minimumTransferAmount==null?null:minimumTransferAmount.toBuilder();
			return this;
		}
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setOtherEligibleSupport(String otherEligibleSupport) {
			this.otherEligibleSupport = otherEligibleSupport==null?null:otherEligibleSupport;
			return this;
		}
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setReturnAmount(String returnAmount) {
			this.returnAmount = returnAmount==null?null:returnAmount;
			return this;
		}
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setRounding(CollateralRounding rounding) {
			this.rounding = rounding==null?null:rounding.toBuilder();
			return this;
		}
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setThreshold(Threshold threshold) {
			this.threshold = threshold==null?null:threshold.toBuilder();
			return this;
		}
		
		@Override
		public CreditSupportObligations build() {
			return new CreditSupportObligations.CreditSupportObligationsImpl(this);
		}
		
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder prune() {
			if (bespokeTransferTiming!=null && !bespokeTransferTiming.prune().hasData()) bespokeTransferTiming = null;
			if (creditSupportObligationsVariationMargin!=null && !creditSupportObligationsVariationMargin.prune().hasData()) creditSupportObligationsVariationMargin = null;
			if (marginApproach!=null && !marginApproach.prune().hasData()) marginApproach = null;
			if (minimumTransferAmount!=null && !minimumTransferAmount.prune().hasData()) minimumTransferAmount = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			if (threshold!=null && !threshold.prune().hasData()) threshold = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBespokeTransferTiming()!=null && getBespokeTransferTiming().hasData()) return true;
			if (getCreditSupportObligationsVariationMargin()!=null && getCreditSupportObligationsVariationMargin().hasData()) return true;
			if (getDeliveryAmount()!=null) return true;
			if (getMarginApproach()!=null && getMarginApproach().hasData()) return true;
			if (getMinimumTransferAmount()!=null && getMinimumTransferAmount().hasData()) return true;
			if (getOtherEligibleSupport()!=null) return true;
			if (getReturnAmount()!=null) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			if (getThreshold()!=null && getThreshold().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportObligations.CreditSupportObligationsBuilder o = (CreditSupportObligations.CreditSupportObligationsBuilder) other;
			
			merger.mergeRosetta(getBespokeTransferTiming(), o.getBespokeTransferTiming(), this::setBespokeTransferTiming);
			merger.mergeRosetta(getCreditSupportObligationsVariationMargin(), o.getCreditSupportObligationsVariationMargin(), this::setCreditSupportObligationsVariationMargin);
			merger.mergeRosetta(getMarginApproach(), o.getMarginApproach(), this::setMarginApproach);
			merger.mergeRosetta(getMinimumTransferAmount(), o.getMinimumTransferAmount(), this::setMinimumTransferAmount);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			merger.mergeRosetta(getThreshold(), o.getThreshold(), this::setThreshold);
			
			merger.mergeBasic(getDeliveryAmount(), o.getDeliveryAmount(), this::setDeliveryAmount);
			merger.mergeBasic(getOtherEligibleSupport(), o.getOtherEligibleSupport(), this::setOtherEligibleSupport);
			merger.mergeBasic(getReturnAmount(), o.getReturnAmount(), this::setReturnAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportObligations _that = getType().cast(o);
		
			if (!Objects.equals(bespokeTransferTiming, _that.getBespokeTransferTiming())) return false;
			if (!Objects.equals(creditSupportObligationsVariationMargin, _that.getCreditSupportObligationsVariationMargin())) return false;
			if (!Objects.equals(deliveryAmount, _that.getDeliveryAmount())) return false;
			if (!Objects.equals(marginApproach, _that.getMarginApproach())) return false;
			if (!Objects.equals(minimumTransferAmount, _that.getMinimumTransferAmount())) return false;
			if (!Objects.equals(otherEligibleSupport, _that.getOtherEligibleSupport())) return false;
			if (!Objects.equals(returnAmount, _that.getReturnAmount())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			if (!Objects.equals(threshold, _that.getThreshold())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeTransferTiming != null ? bespokeTransferTiming.hashCode() : 0);
			_result = 31 * _result + (creditSupportObligationsVariationMargin != null ? creditSupportObligationsVariationMargin.hashCode() : 0);
			_result = 31 * _result + (deliveryAmount != null ? deliveryAmount.hashCode() : 0);
			_result = 31 * _result + (marginApproach != null ? marginApproach.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmount != null ? minimumTransferAmount.hashCode() : 0);
			_result = 31 * _result + (otherEligibleSupport != null ? otherEligibleSupport.hashCode() : 0);
			_result = 31 * _result + (returnAmount != null ? returnAmount.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			_result = 31 * _result + (threshold != null ? threshold.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportObligationsBuilder {" +
				"bespokeTransferTiming=" + this.bespokeTransferTiming + ", " +
				"creditSupportObligationsVariationMargin=" + this.creditSupportObligationsVariationMargin + ", " +
				"deliveryAmount=" + this.deliveryAmount + ", " +
				"marginApproach=" + this.marginApproach + ", " +
				"minimumTransferAmount=" + this.minimumTransferAmount + ", " +
				"otherEligibleSupport=" + this.otherEligibleSupport + ", " +
				"returnAmount=" + this.returnAmount + ", " +
				"rounding=" + this.rounding + ", " +
				"threshold=" + this.threshold +
			'}';
		}
	}
}
