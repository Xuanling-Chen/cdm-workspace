package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.RegimeMeta;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify one or more regimes that may be specified as relevant to a legal agreement. 2016/2018 ISDA Credit Support Annex for Initial Margin: Regime.
 * @version ${project.version}
 */
@RosettaClass

public interface Regime extends RosettaModelObject {
	Regime build();
	Regime.RegimeBuilder toBuilder();
	
	/**
	 * A class to specify the regime(s) that parties to a legal agreement, such as the ISDA 2016 and 2018 CSA for Initial Margin, might agree to apply to one or both parties when acting as collateral taker, and specific terms associated with that application.
	 */
	List<? extends ApplicableRegime> getApplicableRegime();
	/**
	 * The specification of the number of days after effective delivery of notice that Mandatory method fallback applies. Specification is only required when one or more Regimes have Fall Back to Mandatory Method elected as a SIMM exception.
	 */
	BigDecimal getFallbackToMandatoryMethodDays();
	final static RegimeMeta metaData = new RegimeMeta();
	
	@Override
	default RosettaMetaData<? extends Regime> metaData() {
		return metaData;
	} 
			
	static Regime.RegimeBuilder builder() {
		return new Regime.RegimeBuilderImpl();
	}
	
	default Class<? extends Regime> getType() {
		return Regime.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fallbackToMandatoryMethodDays"), BigDecimal.class, getFallbackToMandatoryMethodDays(), this);
		
		processRosetta(path.newSubPath("applicableRegime"), processor, ApplicableRegime.class, getApplicableRegime());
	}
	
	
	interface RegimeBuilder extends Regime, RosettaModelObjectBuilder {
		ApplicableRegime.ApplicableRegimeBuilder getOrCreateApplicableRegime(int _index);
		List<? extends ApplicableRegime.ApplicableRegimeBuilder> getApplicableRegime();
		Regime.RegimeBuilder addApplicableRegime(ApplicableRegime applicableRegime);
		Regime.RegimeBuilder addApplicableRegime(ApplicableRegime applicableRegime, int _idx);
		Regime.RegimeBuilder addApplicableRegime(List<? extends ApplicableRegime> applicableRegime);
		Regime.RegimeBuilder setApplicableRegime(List<? extends ApplicableRegime> applicableRegime);
		Regime.RegimeBuilder setFallbackToMandatoryMethodDays(BigDecimal fallbackToMandatoryMethodDays);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("fallbackToMandatoryMethodDays"), BigDecimal.class, getFallbackToMandatoryMethodDays(), this);
			
			processRosetta(path.newSubPath("applicableRegime"), processor, ApplicableRegime.ApplicableRegimeBuilder.class, getApplicableRegime());
		}
		
	}
	
	//Regime.RegimeImpl
	class RegimeImpl implements Regime {
		private final List<? extends ApplicableRegime> applicableRegime;
		private final BigDecimal fallbackToMandatoryMethodDays;
		
		protected RegimeImpl(Regime.RegimeBuilder builder) {
			this.applicableRegime = ofNullable(builder.getApplicableRegime()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fallbackToMandatoryMethodDays = builder.getFallbackToMandatoryMethodDays();
		}
		
		@Override
		public List<? extends ApplicableRegime> getApplicableRegime() {
			return applicableRegime;
		}
		
		@Override
		public BigDecimal getFallbackToMandatoryMethodDays() {
			return fallbackToMandatoryMethodDays;
		}
		
		@Override
		public Regime build() {
			return this;
		}
		
		@Override
		public Regime.RegimeBuilder toBuilder() {
			Regime.RegimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Regime.RegimeBuilder builder) {
			ofNullable(getApplicableRegime()).ifPresent(builder::setApplicableRegime);
			ofNullable(getFallbackToMandatoryMethodDays()).ifPresent(builder::setFallbackToMandatoryMethodDays);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Regime _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableRegime, _that.getApplicableRegime())) return false;
			if (!Objects.equals(fallbackToMandatoryMethodDays, _that.getFallbackToMandatoryMethodDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableRegime != null ? applicableRegime.hashCode() : 0);
			_result = 31 * _result + (fallbackToMandatoryMethodDays != null ? fallbackToMandatoryMethodDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Regime {" +
				"applicableRegime=" + this.applicableRegime + ", " +
				"fallbackToMandatoryMethodDays=" + this.fallbackToMandatoryMethodDays +
			'}';
		}
	}
	
	//Regime.RegimeBuilderImpl
	class RegimeBuilderImpl implements Regime.RegimeBuilder {
	
		protected List<ApplicableRegime.ApplicableRegimeBuilder> applicableRegime = new ArrayList<>();
		protected BigDecimal fallbackToMandatoryMethodDays;
	
		public RegimeBuilderImpl() {
		}
	
		@Override
		public List<? extends ApplicableRegime.ApplicableRegimeBuilder> getApplicableRegime() {
			return applicableRegime;
		}
		
		public ApplicableRegime.ApplicableRegimeBuilder getOrCreateApplicableRegime(int _index) {
		
			if (applicableRegime==null) {
				this.applicableRegime = new ArrayList<>();
			}
			ApplicableRegime.ApplicableRegimeBuilder result;
			return getIndex(applicableRegime, _index, () -> {
						ApplicableRegime.ApplicableRegimeBuilder newApplicableRegime = ApplicableRegime.builder();
						return newApplicableRegime;
					});
		}
		
		@Override
		public BigDecimal getFallbackToMandatoryMethodDays() {
			return fallbackToMandatoryMethodDays;
		}
		
	
		@Override
		public Regime.RegimeBuilder addApplicableRegime(ApplicableRegime applicableRegime) {
			if (applicableRegime!=null) this.applicableRegime.add(applicableRegime.toBuilder());
			return this;
		}
		
		@Override
		public Regime.RegimeBuilder addApplicableRegime(ApplicableRegime applicableRegime, int _idx) {
			getIndex(this.applicableRegime, _idx, () -> applicableRegime.toBuilder());
			return this;
		}
		@Override 
		public Regime.RegimeBuilder addApplicableRegime(List<? extends ApplicableRegime> applicableRegimes) {
			if (applicableRegimes != null) {
				for (ApplicableRegime toAdd : applicableRegimes) {
					this.applicableRegime.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Regime.RegimeBuilder setApplicableRegime(List<? extends ApplicableRegime> applicableRegimes) {
			if (applicableRegimes == null)  {
				this.applicableRegime = new ArrayList<>();
			}
			else {
				this.applicableRegime = applicableRegimes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Regime.RegimeBuilder setFallbackToMandatoryMethodDays(BigDecimal fallbackToMandatoryMethodDays) {
			this.fallbackToMandatoryMethodDays = fallbackToMandatoryMethodDays==null?null:fallbackToMandatoryMethodDays;
			return this;
		}
		
		@Override
		public Regime build() {
			return new Regime.RegimeImpl(this);
		}
		
		@Override
		public Regime.RegimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Regime.RegimeBuilder prune() {
			applicableRegime = applicableRegime.stream().filter(b->b!=null).<ApplicableRegime.ApplicableRegimeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicableRegime()!=null && getApplicableRegime().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFallbackToMandatoryMethodDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Regime.RegimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Regime.RegimeBuilder o = (Regime.RegimeBuilder) other;
			
			merger.mergeRosetta(getApplicableRegime(), o.getApplicableRegime(), this::getOrCreateApplicableRegime);
			
			merger.mergeBasic(getFallbackToMandatoryMethodDays(), o.getFallbackToMandatoryMethodDays(), this::setFallbackToMandatoryMethodDays);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Regime _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableRegime, _that.getApplicableRegime())) return false;
			if (!Objects.equals(fallbackToMandatoryMethodDays, _that.getFallbackToMandatoryMethodDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableRegime != null ? applicableRegime.hashCode() : 0);
			_result = 31 * _result + (fallbackToMandatoryMethodDays != null ? fallbackToMandatoryMethodDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegimeBuilder {" +
				"applicableRegime=" + this.applicableRegime + ", " +
				"fallbackToMandatoryMethodDays=" + this.fallbackToMandatoryMethodDays +
			'}';
		}
	}
}
