package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.ApplicableRegimeMeta;
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
 * A class to specify the applicable regulatory regime(s) that parties to a legal agreement, such as the ISDA 2016 and 2018 CSA for Initial Margin, might be subject to.
 * @version ${project.version}
 */
@RosettaClass

public interface ApplicableRegime extends RosettaModelObject {
	ApplicableRegime build();
	ApplicableRegime.ApplicableRegimeBuilder toBuilder();
	
	/**
	 * The additional regulatory regime as specified by the parties.
	 */
	String getAdditionalRegime();
	/**
	 * The bespoke Additional Type for the purposes of Covered Transactions (IM).
	 */
	String getAdditionalTerms();
	/**
	 * The Additional Type of transaction that can require the collection or delivery of initial margin under the specified regulatory regime for the purposes of Covered Transactions, as specified in ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b)(B).
	 */
	AdditionalTypeEnum getAdditionalType();
	/**
	 * The applicable regulatory regime, as specified through an enumeration.
	 */
	RegulatoryRegimeEnum getRegime();
	/**
	 * A class that is used by the ApplicableRegime and the AdditionalRegime classes to specify the terms that are specific to each party and regime which are referred to in the Regime Table as part of certain legal agreements, such as such as the ISDA 2016 and 2018 CSA for Initial Margin.
	 */
	List<? extends RegimeTerms> getRegimeTerms();
	final static ApplicableRegimeMeta metaData = new ApplicableRegimeMeta();
	
	@Override
	default RosettaMetaData<? extends ApplicableRegime> metaData() {
		return metaData;
	} 
			
	static ApplicableRegime.ApplicableRegimeBuilder builder() {
		return new ApplicableRegime.ApplicableRegimeBuilderImpl();
	}
	
	default Class<? extends ApplicableRegime> getType() {
		return ApplicableRegime.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("additionalRegime"), String.class, getAdditionalRegime(), this);
		processor.processBasic(path.newSubPath("additionalTerms"), String.class, getAdditionalTerms(), this);
		processor.processBasic(path.newSubPath("additionalType"), AdditionalTypeEnum.class, getAdditionalType(), this);
		processor.processBasic(path.newSubPath("regime"), RegulatoryRegimeEnum.class, getRegime(), this);
		
		processRosetta(path.newSubPath("regimeTerms"), processor, RegimeTerms.class, getRegimeTerms());
	}
	
	
	interface ApplicableRegimeBuilder extends ApplicableRegime, RosettaModelObjectBuilder {
		RegimeTerms.RegimeTermsBuilder getOrCreateRegimeTerms(int _index);
		List<? extends RegimeTerms.RegimeTermsBuilder> getRegimeTerms();
		ApplicableRegime.ApplicableRegimeBuilder setAdditionalRegime(String additionalRegime);
		ApplicableRegime.ApplicableRegimeBuilder setAdditionalTerms(String additionalTerms);
		ApplicableRegime.ApplicableRegimeBuilder setAdditionalType(AdditionalTypeEnum additionalType);
		ApplicableRegime.ApplicableRegimeBuilder setRegime(RegulatoryRegimeEnum regime);
		ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(RegimeTerms regimeTerms);
		ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(RegimeTerms regimeTerms, int _idx);
		ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(List<? extends RegimeTerms> regimeTerms);
		ApplicableRegime.ApplicableRegimeBuilder setRegimeTerms(List<? extends RegimeTerms> regimeTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("additionalRegime"), String.class, getAdditionalRegime(), this);
			processor.processBasic(path.newSubPath("additionalTerms"), String.class, getAdditionalTerms(), this);
			processor.processBasic(path.newSubPath("additionalType"), AdditionalTypeEnum.class, getAdditionalType(), this);
			processor.processBasic(path.newSubPath("regime"), RegulatoryRegimeEnum.class, getRegime(), this);
			
			processRosetta(path.newSubPath("regimeTerms"), processor, RegimeTerms.RegimeTermsBuilder.class, getRegimeTerms());
		}
		
	}
	
	//ApplicableRegime.ApplicableRegimeImpl
	class ApplicableRegimeImpl implements ApplicableRegime {
		private final String additionalRegime;
		private final String additionalTerms;
		private final AdditionalTypeEnum additionalType;
		private final RegulatoryRegimeEnum regime;
		private final List<? extends RegimeTerms> regimeTerms;
		
		protected ApplicableRegimeImpl(ApplicableRegime.ApplicableRegimeBuilder builder) {
			this.additionalRegime = builder.getAdditionalRegime();
			this.additionalTerms = builder.getAdditionalTerms();
			this.additionalType = builder.getAdditionalType();
			this.regime = builder.getRegime();
			this.regimeTerms = ofNullable(builder.getRegimeTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public String getAdditionalRegime() {
			return additionalRegime;
		}
		
		@Override
		public String getAdditionalTerms() {
			return additionalTerms;
		}
		
		@Override
		public AdditionalTypeEnum getAdditionalType() {
			return additionalType;
		}
		
		@Override
		public RegulatoryRegimeEnum getRegime() {
			return regime;
		}
		
		@Override
		public List<? extends RegimeTerms> getRegimeTerms() {
			return regimeTerms;
		}
		
		@Override
		public ApplicableRegime build() {
			return this;
		}
		
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder toBuilder() {
			ApplicableRegime.ApplicableRegimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableRegime.ApplicableRegimeBuilder builder) {
			ofNullable(getAdditionalRegime()).ifPresent(builder::setAdditionalRegime);
			ofNullable(getAdditionalTerms()).ifPresent(builder::setAdditionalTerms);
			ofNullable(getAdditionalType()).ifPresent(builder::setAdditionalType);
			ofNullable(getRegime()).ifPresent(builder::setRegime);
			ofNullable(getRegimeTerms()).ifPresent(builder::setRegimeTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableRegime _that = getType().cast(o);
		
			if (!Objects.equals(additionalRegime, _that.getAdditionalRegime())) return false;
			if (!Objects.equals(additionalTerms, _that.getAdditionalTerms())) return false;
			if (!Objects.equals(additionalType, _that.getAdditionalType())) return false;
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!ListEquals.listEquals(regimeTerms, _that.getRegimeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalRegime != null ? additionalRegime.hashCode() : 0);
			_result = 31 * _result + (additionalTerms != null ? additionalTerms.hashCode() : 0);
			_result = 31 * _result + (additionalType != null ? additionalType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (regime != null ? regime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (regimeTerms != null ? regimeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableRegime {" +
				"additionalRegime=" + this.additionalRegime + ", " +
				"additionalTerms=" + this.additionalTerms + ", " +
				"additionalType=" + this.additionalType + ", " +
				"regime=" + this.regime + ", " +
				"regimeTerms=" + this.regimeTerms +
			'}';
		}
	}
	
	//ApplicableRegime.ApplicableRegimeBuilderImpl
	class ApplicableRegimeBuilderImpl implements ApplicableRegime.ApplicableRegimeBuilder {
	
		protected String additionalRegime;
		protected String additionalTerms;
		protected AdditionalTypeEnum additionalType;
		protected RegulatoryRegimeEnum regime;
		protected List<RegimeTerms.RegimeTermsBuilder> regimeTerms = new ArrayList<>();
	
		public ApplicableRegimeBuilderImpl() {
		}
	
		@Override
		public String getAdditionalRegime() {
			return additionalRegime;
		}
		
		@Override
		public String getAdditionalTerms() {
			return additionalTerms;
		}
		
		@Override
		public AdditionalTypeEnum getAdditionalType() {
			return additionalType;
		}
		
		@Override
		public RegulatoryRegimeEnum getRegime() {
			return regime;
		}
		
		@Override
		public List<? extends RegimeTerms.RegimeTermsBuilder> getRegimeTerms() {
			return regimeTerms;
		}
		
		public RegimeTerms.RegimeTermsBuilder getOrCreateRegimeTerms(int _index) {
		
			if (regimeTerms==null) {
				this.regimeTerms = new ArrayList<>();
			}
			RegimeTerms.RegimeTermsBuilder result;
			return getIndex(regimeTerms, _index, () -> {
						RegimeTerms.RegimeTermsBuilder newRegimeTerms = RegimeTerms.builder();
						return newRegimeTerms;
					});
		}
		
	
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder setAdditionalRegime(String additionalRegime) {
			this.additionalRegime = additionalRegime==null?null:additionalRegime;
			return this;
		}
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder setAdditionalTerms(String additionalTerms) {
			this.additionalTerms = additionalTerms==null?null:additionalTerms;
			return this;
		}
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder setAdditionalType(AdditionalTypeEnum additionalType) {
			this.additionalType = additionalType==null?null:additionalType;
			return this;
		}
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder setRegime(RegulatoryRegimeEnum regime) {
			this.regime = regime==null?null:regime;
			return this;
		}
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(RegimeTerms regimeTerms) {
			if (regimeTerms!=null) this.regimeTerms.add(regimeTerms.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(RegimeTerms regimeTerms, int _idx) {
			getIndex(this.regimeTerms, _idx, () -> regimeTerms.toBuilder());
			return this;
		}
		@Override 
		public ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(List<? extends RegimeTerms> regimeTermss) {
			if (regimeTermss != null) {
				for (RegimeTerms toAdd : regimeTermss) {
					this.regimeTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ApplicableRegime.ApplicableRegimeBuilder setRegimeTerms(List<? extends RegimeTerms> regimeTermss) {
			if (regimeTermss == null)  {
				this.regimeTerms = new ArrayList<>();
			}
			else {
				this.regimeTerms = regimeTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ApplicableRegime build() {
			return new ApplicableRegime.ApplicableRegimeImpl(this);
		}
		
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder prune() {
			regimeTerms = regimeTerms.stream().filter(b->b!=null).<RegimeTerms.RegimeTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalRegime()!=null) return true;
			if (getAdditionalTerms()!=null) return true;
			if (getAdditionalType()!=null) return true;
			if (getRegime()!=null) return true;
			if (getRegimeTerms()!=null && getRegimeTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApplicableRegime.ApplicableRegimeBuilder o = (ApplicableRegime.ApplicableRegimeBuilder) other;
			
			merger.mergeRosetta(getRegimeTerms(), o.getRegimeTerms(), this::getOrCreateRegimeTerms);
			
			merger.mergeBasic(getAdditionalRegime(), o.getAdditionalRegime(), this::setAdditionalRegime);
			merger.mergeBasic(getAdditionalTerms(), o.getAdditionalTerms(), this::setAdditionalTerms);
			merger.mergeBasic(getAdditionalType(), o.getAdditionalType(), this::setAdditionalType);
			merger.mergeBasic(getRegime(), o.getRegime(), this::setRegime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableRegime _that = getType().cast(o);
		
			if (!Objects.equals(additionalRegime, _that.getAdditionalRegime())) return false;
			if (!Objects.equals(additionalTerms, _that.getAdditionalTerms())) return false;
			if (!Objects.equals(additionalType, _that.getAdditionalType())) return false;
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!ListEquals.listEquals(regimeTerms, _that.getRegimeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalRegime != null ? additionalRegime.hashCode() : 0);
			_result = 31 * _result + (additionalTerms != null ? additionalTerms.hashCode() : 0);
			_result = 31 * _result + (additionalType != null ? additionalType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (regime != null ? regime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (regimeTerms != null ? regimeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableRegimeBuilder {" +
				"additionalRegime=" + this.additionalRegime + ", " +
				"additionalTerms=" + this.additionalTerms + ", " +
				"additionalType=" + this.additionalType + ", " +
				"regime=" + this.regime + ", " +
				"regimeTerms=" + this.regimeTerms +
			'}';
		}
	}
}
