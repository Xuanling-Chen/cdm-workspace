package cdm.observable.asset;

import cdm.base.staticdata.party.AncillaryEntity;
import cdm.base.staticdata.party.ReferenceBanks;
import cdm.observable.asset.meta.ValuationSourceMeta;
import cdm.observable.asset.metafields.ReferenceWithMetaQuotedCurrencyPair;
import cdm.observable.asset.metafields.ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder;
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
 * A class describing the method for obtaining a settlement rate, specified through either an information source (page), a settlement rate option (fixing) or by using quotes from reference banks.
 * @version ${project.version}
 */
@RosettaClass

public interface ValuationSource extends RosettaModelObject {
	ValuationSource build();
	ValuationSource.ValuationSourceBuilder toBuilder();
	
	/**
	 * Holds an identifier for the reference entity that is agreed by both parties as a basis for cash settlement calculations. This could be a dealer from whom quotations are obtained by the calculation agent on the reference obligation for purposes of cash settlement in a credit event. ISDA 2003 Term: Dealer. This could be the clearing organization (CCP, DCO) to which the trade should be cleared, as applicable for cash-settled swaptions.
	 */
	AncillaryEntity getDealerOrCCP();
	/**
	 * The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 */
	FxSpotRateSource getInformationSource();
	/**
	 * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.  This attribute was formerly part of &#39;fxSettlementTerms&#39;, which is now being harmonised into a common &#39;CashSettlementTerms&#39; that includes a &#39;ValuationDate&#39;.
	 */
	ReferenceWithMetaQuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * A container for a set of reference institutions that may be called upon to provide rate quotations as part of the method to determine the applicable cash settlement amount. If institutions are not specified, it is assumed that reference institutions will be agreed between the parties on the exercise date, or in the case of swap transaction to which mandatory early termination is applicable, the cash settlement valuation date.
	 */
	ReferenceBanks getReferenceBanks();
	/**
	 * The rate option to use for the fixing. Currently only applicable to foreign exchange fixing in case of cross-currency settlement.
	 */
	SettlementRateOption getSettlementRateOption();
	final static ValuationSourceMeta metaData = new ValuationSourceMeta();
	
	@Override
	default RosettaMetaData<? extends ValuationSource> metaData() {
		return metaData;
	} 
			
	static ValuationSource.ValuationSourceBuilder builder() {
		return new ValuationSource.ValuationSourceBuilderImpl();
	}
	
	default Class<? extends ValuationSource> getType() {
		return ValuationSource.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("dealerOrCCP"), processor, AncillaryEntity.class, getDealerOrCCP());
		processRosetta(path.newSubPath("informationSource"), processor, FxSpotRateSource.class, getInformationSource());
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, ReferenceWithMetaQuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("referenceBanks"), processor, ReferenceBanks.class, getReferenceBanks());
		processRosetta(path.newSubPath("settlementRateOption"), processor, SettlementRateOption.class, getSettlementRateOption());
	}
	
	
	interface ValuationSourceBuilder extends ValuationSource, RosettaModelObjectBuilder {
		AncillaryEntity.AncillaryEntityBuilder getOrCreateDealerOrCCP();
		AncillaryEntity.AncillaryEntityBuilder getDealerOrCCP();
		FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateInformationSource();
		FxSpotRateSource.FxSpotRateSourceBuilder getInformationSource();
		ReferenceWithMetaQuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		ReferenceWithMetaQuotedCurrencyPairBuilder getQuotedCurrencyPair();
		ReferenceBanks.ReferenceBanksBuilder getOrCreateReferenceBanks();
		ReferenceBanks.ReferenceBanksBuilder getReferenceBanks();
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateSettlementRateOption();
		SettlementRateOption.SettlementRateOptionBuilder getSettlementRateOption();
		ValuationSource.ValuationSourceBuilder setDealerOrCCP(AncillaryEntity dealerOrCCP);
		ValuationSource.ValuationSourceBuilder setInformationSource(FxSpotRateSource informationSource);
		ValuationSource.ValuationSourceBuilder setQuotedCurrencyPair(ReferenceWithMetaQuotedCurrencyPair quotedCurrencyPair);
		ValuationSource.ValuationSourceBuilder setQuotedCurrencyPairValue(QuotedCurrencyPair quotedCurrencyPair);
		ValuationSource.ValuationSourceBuilder setReferenceBanks(ReferenceBanks referenceBanks);
		ValuationSource.ValuationSourceBuilder setSettlementRateOption(SettlementRateOption settlementRateOption);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("dealerOrCCP"), processor, AncillaryEntity.AncillaryEntityBuilder.class, getDealerOrCCP());
			processRosetta(path.newSubPath("informationSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, ReferenceWithMetaQuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("referenceBanks"), processor, ReferenceBanks.ReferenceBanksBuilder.class, getReferenceBanks());
			processRosetta(path.newSubPath("settlementRateOption"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getSettlementRateOption());
		}
		
	}
	
	//ValuationSource.ValuationSourceImpl
	class ValuationSourceImpl implements ValuationSource {
		private final AncillaryEntity dealerOrCCP;
		private final FxSpotRateSource informationSource;
		private final ReferenceWithMetaQuotedCurrencyPair quotedCurrencyPair;
		private final ReferenceBanks referenceBanks;
		private final SettlementRateOption settlementRateOption;
		
		protected ValuationSourceImpl(ValuationSource.ValuationSourceBuilder builder) {
			this.dealerOrCCP = ofNullable(builder.getDealerOrCCP()).map(f->f.build()).orElse(null);
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.referenceBanks = ofNullable(builder.getReferenceBanks()).map(f->f.build()).orElse(null);
			this.settlementRateOption = ofNullable(builder.getSettlementRateOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AncillaryEntity getDealerOrCCP() {
			return dealerOrCCP;
		}
		
		@Override
		public FxSpotRateSource getInformationSource() {
			return informationSource;
		}
		
		@Override
		public ReferenceWithMetaQuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public ReferenceBanks getReferenceBanks() {
			return referenceBanks;
		}
		
		@Override
		public SettlementRateOption getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		public ValuationSource build() {
			return this;
		}
		
		@Override
		public ValuationSource.ValuationSourceBuilder toBuilder() {
			ValuationSource.ValuationSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationSource.ValuationSourceBuilder builder) {
			ofNullable(getDealerOrCCP()).ifPresent(builder::setDealerOrCCP);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getReferenceBanks()).ifPresent(builder::setReferenceBanks);
			ofNullable(getSettlementRateOption()).ifPresent(builder::setSettlementRateOption);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationSource _that = getType().cast(o);
		
			if (!Objects.equals(dealerOrCCP, _that.getDealerOrCCP())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(referenceBanks, _that.getReferenceBanks())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealerOrCCP != null ? dealerOrCCP.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (referenceBanks != null ? referenceBanks.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationSource {" +
				"dealerOrCCP=" + this.dealerOrCCP + ", " +
				"informationSource=" + this.informationSource + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"referenceBanks=" + this.referenceBanks + ", " +
				"settlementRateOption=" + this.settlementRateOption +
			'}';
		}
	}
	
	//ValuationSource.ValuationSourceBuilderImpl
	class ValuationSourceBuilderImpl implements ValuationSource.ValuationSourceBuilder {
	
		protected AncillaryEntity.AncillaryEntityBuilder dealerOrCCP;
		protected FxSpotRateSource.FxSpotRateSourceBuilder informationSource;
		protected ReferenceWithMetaQuotedCurrencyPairBuilder quotedCurrencyPair;
		protected ReferenceBanks.ReferenceBanksBuilder referenceBanks;
		protected SettlementRateOption.SettlementRateOptionBuilder settlementRateOption;
	
		public ValuationSourceBuilderImpl() {
		}
	
		@Override
		public AncillaryEntity.AncillaryEntityBuilder getDealerOrCCP() {
			return dealerOrCCP;
		}
		
		@Override
		public AncillaryEntity.AncillaryEntityBuilder getOrCreateDealerOrCCP() {
			AncillaryEntity.AncillaryEntityBuilder result;
			if (dealerOrCCP!=null) {
				result = dealerOrCCP;
			}
			else {
				result = dealerOrCCP = AncillaryEntity.builder();
			}
			
			return result;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateInformationSource() {
			FxSpotRateSource.FxSpotRateSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = FxSpotRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaQuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public ReferenceWithMetaQuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			ReferenceWithMetaQuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = ReferenceWithMetaQuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceBanks.ReferenceBanksBuilder getReferenceBanks() {
			return referenceBanks;
		}
		
		@Override
		public ReferenceBanks.ReferenceBanksBuilder getOrCreateReferenceBanks() {
			ReferenceBanks.ReferenceBanksBuilder result;
			if (referenceBanks!=null) {
				result = referenceBanks;
			}
			else {
				result = referenceBanks = ReferenceBanks.builder();
			}
			
			return result;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreateSettlementRateOption() {
			SettlementRateOption.SettlementRateOptionBuilder result;
			if (settlementRateOption!=null) {
				result = settlementRateOption;
			}
			else {
				result = settlementRateOption = SettlementRateOption.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ValuationSource.ValuationSourceBuilder setDealerOrCCP(AncillaryEntity dealerOrCCP) {
			this.dealerOrCCP = dealerOrCCP==null?null:dealerOrCCP.toBuilder();
			return this;
		}
		@Override
		public ValuationSource.ValuationSourceBuilder setInformationSource(FxSpotRateSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		@Override
		public ValuationSource.ValuationSourceBuilder setQuotedCurrencyPair(ReferenceWithMetaQuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@Override
		public ValuationSource.ValuationSourceBuilder setQuotedCurrencyPairValue(QuotedCurrencyPair quotedCurrencyPair) {
			this.getOrCreateQuotedCurrencyPair().setValue(quotedCurrencyPair);
			return this;
		}
		@Override
		public ValuationSource.ValuationSourceBuilder setReferenceBanks(ReferenceBanks referenceBanks) {
			this.referenceBanks = referenceBanks==null?null:referenceBanks.toBuilder();
			return this;
		}
		@Override
		public ValuationSource.ValuationSourceBuilder setSettlementRateOption(SettlementRateOption settlementRateOption) {
			this.settlementRateOption = settlementRateOption==null?null:settlementRateOption.toBuilder();
			return this;
		}
		
		@Override
		public ValuationSource build() {
			return new ValuationSource.ValuationSourceImpl(this);
		}
		
		@Override
		public ValuationSource.ValuationSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationSource.ValuationSourceBuilder prune() {
			if (dealerOrCCP!=null && !dealerOrCCP.prune().hasData()) dealerOrCCP = null;
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (referenceBanks!=null && !referenceBanks.prune().hasData()) referenceBanks = null;
			if (settlementRateOption!=null && !settlementRateOption.prune().hasData()) settlementRateOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDealerOrCCP()!=null && getDealerOrCCP().hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getReferenceBanks()!=null && getReferenceBanks().hasData()) return true;
			if (getSettlementRateOption()!=null && getSettlementRateOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationSource.ValuationSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationSource.ValuationSourceBuilder o = (ValuationSource.ValuationSourceBuilder) other;
			
			merger.mergeRosetta(getDealerOrCCP(), o.getDealerOrCCP(), this::setDealerOrCCP);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getReferenceBanks(), o.getReferenceBanks(), this::setReferenceBanks);
			merger.mergeRosetta(getSettlementRateOption(), o.getSettlementRateOption(), this::setSettlementRateOption);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationSource _that = getType().cast(o);
		
			if (!Objects.equals(dealerOrCCP, _that.getDealerOrCCP())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(referenceBanks, _that.getReferenceBanks())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealerOrCCP != null ? dealerOrCCP.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (referenceBanks != null ? referenceBanks.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationSourceBuilder {" +
				"dealerOrCCP=" + this.dealerOrCCP + ", " +
				"informationSource=" + this.informationSource + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"referenceBanks=" + this.referenceBanks + ", " +
				"settlementRateOption=" + this.settlementRateOption +
			'}';
		}
	}
}
