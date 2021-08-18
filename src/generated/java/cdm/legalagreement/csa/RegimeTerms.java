package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.RegimeTermsMeta;
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
 * A class that is used by the ApplicableRegime and the AdditionalRegime classes to specify the regulatory regime terms which are referred to as part of certain legal agreements, such as such as the ISDA 2016 and 2018 CSA for Initial Margin.
 * @version ${project.version}
 */
@RosettaClass

public interface RegimeTerms extends RosettaModelObject {
	RegimeTerms build();
	RegimeTerms.RegimeTermsBuilder toBuilder();
	
	/**
	 * The bespoke party specific Regime term elections applicable when specified.
	 */
	String getAsSpecified();
	/**
	 * The specification of whether the regime is elected as applicable to the party when acting as collateral taker.
	 */
	ExceptionEnum getIsApplicable();
	/**
	 * The party for which the regime terms are being specified when acting as collateral taker.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * ISDA 2016 CSA for Initial Margin, paragraph 13 (b)(i): if `Retrospective Effect` is specified as applicable to a Regime (a `Retrospective Regime`) then all Covered Transactions (IM) under all other Regimes with an earlier Regime Effective Time will, to the extent that they would have been Covered Transactions (IM) under such Retrospective Regime had such Transactions been entered into at or after the Regime Effective Time of the Retrospective Regime, be deemed to be Covered Transactions (IM) for such Retrospective Regime.
	 */
	RetrospectiveEffect getRetrospectiveEffect();
	/**
	 * The election for SIMM exception to the regulatory regime clause of the ISDA 2016 and 2018 CSA for Initial Margin as either a normalized value specified as part of an enumeration or a customized value specified of type string. ISDA 2016 Credit Support Annex for Initial Margin paragraph 13, Regime: SIMM Exception.
	 */
	SimmException getSimmException();
	final static RegimeTermsMeta metaData = new RegimeTermsMeta();
	
	@Override
	default RosettaMetaData<? extends RegimeTerms> metaData() {
		return metaData;
	} 
			
	static RegimeTerms.RegimeTermsBuilder builder() {
		return new RegimeTerms.RegimeTermsBuilderImpl();
	}
	
	default Class<? extends RegimeTerms> getType() {
		return RegimeTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
		processor.processBasic(path.newSubPath("isApplicable"), ExceptionEnum.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
		processRosetta(path.newSubPath("retrospectiveEffect"), processor, RetrospectiveEffect.class, getRetrospectiveEffect());
		processRosetta(path.newSubPath("simmException"), processor, SimmException.class, getSimmException());
	}
	
	
	interface RegimeTermsBuilder extends RegimeTerms, RosettaModelObjectBuilder {
		RetrospectiveEffect.RetrospectiveEffectBuilder getOrCreateRetrospectiveEffect();
		RetrospectiveEffect.RetrospectiveEffectBuilder getRetrospectiveEffect();
		SimmException.SimmExceptionBuilder getOrCreateSimmException();
		SimmException.SimmExceptionBuilder getSimmException();
		RegimeTerms.RegimeTermsBuilder setAsSpecified(String asSpecified);
		RegimeTerms.RegimeTermsBuilder setIsApplicable(ExceptionEnum isApplicable);
		RegimeTerms.RegimeTermsBuilder setParty(CounterpartyRoleEnum party);
		RegimeTerms.RegimeTermsBuilder setRetrospectiveEffect(RetrospectiveEffect retrospectiveEffect);
		RegimeTerms.RegimeTermsBuilder setSimmException(SimmException simmException);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
			processor.processBasic(path.newSubPath("isApplicable"), ExceptionEnum.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
			processRosetta(path.newSubPath("retrospectiveEffect"), processor, RetrospectiveEffect.RetrospectiveEffectBuilder.class, getRetrospectiveEffect());
			processRosetta(path.newSubPath("simmException"), processor, SimmException.SimmExceptionBuilder.class, getSimmException());
		}
		
	}
	
	//RegimeTerms.RegimeTermsImpl
	class RegimeTermsImpl implements RegimeTerms {
		private final String asSpecified;
		private final ExceptionEnum isApplicable;
		private final CounterpartyRoleEnum party;
		private final RetrospectiveEffect retrospectiveEffect;
		private final SimmException simmException;
		
		protected RegimeTermsImpl(RegimeTerms.RegimeTermsBuilder builder) {
			this.asSpecified = builder.getAsSpecified();
			this.isApplicable = builder.getIsApplicable();
			this.party = builder.getParty();
			this.retrospectiveEffect = ofNullable(builder.getRetrospectiveEffect()).map(f->f.build()).orElse(null);
			this.simmException = ofNullable(builder.getSimmException()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		public ExceptionEnum getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public RetrospectiveEffect getRetrospectiveEffect() {
			return retrospectiveEffect;
		}
		
		@Override
		public SimmException getSimmException() {
			return simmException;
		}
		
		@Override
		public RegimeTerms build() {
			return this;
		}
		
		@Override
		public RegimeTerms.RegimeTermsBuilder toBuilder() {
			RegimeTerms.RegimeTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegimeTerms.RegimeTermsBuilder builder) {
			ofNullable(getAsSpecified()).ifPresent(builder::setAsSpecified);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getRetrospectiveEffect()).ifPresent(builder::setRetrospectiveEffect);
			ofNullable(getSimmException()).ifPresent(builder::setSimmException);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegimeTerms _that = getType().cast(o);
		
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(retrospectiveEffect, _that.getRetrospectiveEffect())) return false;
			if (!Objects.equals(simmException, _that.getSimmException())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (retrospectiveEffect != null ? retrospectiveEffect.hashCode() : 0);
			_result = 31 * _result + (simmException != null ? simmException.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegimeTerms {" +
				"asSpecified=" + this.asSpecified + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party + ", " +
				"retrospectiveEffect=" + this.retrospectiveEffect + ", " +
				"simmException=" + this.simmException +
			'}';
		}
	}
	
	//RegimeTerms.RegimeTermsBuilderImpl
	class RegimeTermsBuilderImpl implements RegimeTerms.RegimeTermsBuilder {
	
		protected String asSpecified;
		protected ExceptionEnum isApplicable;
		protected CounterpartyRoleEnum party;
		protected RetrospectiveEffect.RetrospectiveEffectBuilder retrospectiveEffect;
		protected SimmException.SimmExceptionBuilder simmException;
	
		public RegimeTermsBuilderImpl() {
		}
	
		@Override
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		public ExceptionEnum getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder getRetrospectiveEffect() {
			return retrospectiveEffect;
		}
		
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder getOrCreateRetrospectiveEffect() {
			RetrospectiveEffect.RetrospectiveEffectBuilder result;
			if (retrospectiveEffect!=null) {
				result = retrospectiveEffect;
			}
			else {
				result = retrospectiveEffect = RetrospectiveEffect.builder();
			}
			
			return result;
		}
		
		@Override
		public SimmException.SimmExceptionBuilder getSimmException() {
			return simmException;
		}
		
		@Override
		public SimmException.SimmExceptionBuilder getOrCreateSimmException() {
			SimmException.SimmExceptionBuilder result;
			if (simmException!=null) {
				result = simmException;
			}
			else {
				result = simmException = SimmException.builder();
			}
			
			return result;
		}
		
	
		@Override
		public RegimeTerms.RegimeTermsBuilder setAsSpecified(String asSpecified) {
			this.asSpecified = asSpecified==null?null:asSpecified;
			return this;
		}
		@Override
		public RegimeTerms.RegimeTermsBuilder setIsApplicable(ExceptionEnum isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public RegimeTerms.RegimeTermsBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		@Override
		public RegimeTerms.RegimeTermsBuilder setRetrospectiveEffect(RetrospectiveEffect retrospectiveEffect) {
			this.retrospectiveEffect = retrospectiveEffect==null?null:retrospectiveEffect.toBuilder();
			return this;
		}
		@Override
		public RegimeTerms.RegimeTermsBuilder setSimmException(SimmException simmException) {
			this.simmException = simmException==null?null:simmException.toBuilder();
			return this;
		}
		
		@Override
		public RegimeTerms build() {
			return new RegimeTerms.RegimeTermsImpl(this);
		}
		
		@Override
		public RegimeTerms.RegimeTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegimeTerms.RegimeTermsBuilder prune() {
			if (retrospectiveEffect!=null && !retrospectiveEffect.prune().hasData()) retrospectiveEffect = null;
			if (simmException!=null && !simmException.prune().hasData()) simmException = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsSpecified()!=null) return true;
			if (getIsApplicable()!=null) return true;
			if (getParty()!=null) return true;
			if (getRetrospectiveEffect()!=null && getRetrospectiveEffect().hasData()) return true;
			if (getSimmException()!=null && getSimmException().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegimeTerms.RegimeTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegimeTerms.RegimeTermsBuilder o = (RegimeTerms.RegimeTermsBuilder) other;
			
			merger.mergeRosetta(getRetrospectiveEffect(), o.getRetrospectiveEffect(), this::setRetrospectiveEffect);
			merger.mergeRosetta(getSimmException(), o.getSimmException(), this::setSimmException);
			
			merger.mergeBasic(getAsSpecified(), o.getAsSpecified(), this::setAsSpecified);
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegimeTerms _that = getType().cast(o);
		
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(retrospectiveEffect, _that.getRetrospectiveEffect())) return false;
			if (!Objects.equals(simmException, _that.getSimmException())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (retrospectiveEffect != null ? retrospectiveEffect.hashCode() : 0);
			_result = 31 * _result + (simmException != null ? simmException.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegimeTermsBuilder {" +
				"asSpecified=" + this.asSpecified + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party + ", " +
				"retrospectiveEffect=" + this.retrospectiveEffect + ", " +
				"simmException=" + this.simmException +
			'}';
		}
	}
}
