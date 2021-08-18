package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.SubstitutedRegimeMeta;
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
 * A class to specify each party&#39;s election with respect to the Substituted Regimes that will be applicable...
 * @version ${project.version}
 */
@RosettaClass

public interface SubstitutedRegime extends RosettaModelObject {
	SubstitutedRegime build();
	SubstitutedRegime.SubstitutedRegimeBuilder toBuilder();
	
	/**
	 * The additional regulatory regime as specified by the parties.
	 */
	String getAdditionalRegime();
	/**
	 * The applicable regulatory regime, as specified through an enumeration.
	 */
	RegulatoryRegimeEnum getRegime();
	/**
	 * Specifies the applicability of the Substituted Regime as denoted in the Substituted Regime Table as part of certain legal agreements, such as such as the ISDA 2016 and 2018 CSA for Initial Margin.
	 */
	List<? extends SubstitutedRegimeTerms> getRegimeTerms();
	final static SubstitutedRegimeMeta metaData = new SubstitutedRegimeMeta();
	
	@Override
	default RosettaMetaData<? extends SubstitutedRegime> metaData() {
		return metaData;
	} 
			
	static SubstitutedRegime.SubstitutedRegimeBuilder builder() {
		return new SubstitutedRegime.SubstitutedRegimeBuilderImpl();
	}
	
	default Class<? extends SubstitutedRegime> getType() {
		return SubstitutedRegime.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("additionalRegime"), String.class, getAdditionalRegime(), this);
		processor.processBasic(path.newSubPath("regime"), RegulatoryRegimeEnum.class, getRegime(), this);
		
		processRosetta(path.newSubPath("regimeTerms"), processor, SubstitutedRegimeTerms.class, getRegimeTerms());
	}
	
	
	interface SubstitutedRegimeBuilder extends SubstitutedRegime, RosettaModelObjectBuilder {
		SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder getOrCreateRegimeTerms(int _index);
		List<? extends SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder> getRegimeTerms();
		SubstitutedRegime.SubstitutedRegimeBuilder setAdditionalRegime(String additionalRegime);
		SubstitutedRegime.SubstitutedRegimeBuilder setRegime(RegulatoryRegimeEnum regime);
		SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(SubstitutedRegimeTerms regimeTerms);
		SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(SubstitutedRegimeTerms regimeTerms, int _idx);
		SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(List<? extends SubstitutedRegimeTerms> regimeTerms);
		SubstitutedRegime.SubstitutedRegimeBuilder setRegimeTerms(List<? extends SubstitutedRegimeTerms> regimeTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("additionalRegime"), String.class, getAdditionalRegime(), this);
			processor.processBasic(path.newSubPath("regime"), RegulatoryRegimeEnum.class, getRegime(), this);
			
			processRosetta(path.newSubPath("regimeTerms"), processor, SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder.class, getRegimeTerms());
		}
		
	}
	
	//SubstitutedRegime.SubstitutedRegimeImpl
	class SubstitutedRegimeImpl implements SubstitutedRegime {
		private final String additionalRegime;
		private final RegulatoryRegimeEnum regime;
		private final List<? extends SubstitutedRegimeTerms> regimeTerms;
		
		protected SubstitutedRegimeImpl(SubstitutedRegime.SubstitutedRegimeBuilder builder) {
			this.additionalRegime = builder.getAdditionalRegime();
			this.regime = builder.getRegime();
			this.regimeTerms = ofNullable(builder.getRegimeTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public String getAdditionalRegime() {
			return additionalRegime;
		}
		
		@Override
		public RegulatoryRegimeEnum getRegime() {
			return regime;
		}
		
		@Override
		public List<? extends SubstitutedRegimeTerms> getRegimeTerms() {
			return regimeTerms;
		}
		
		@Override
		public SubstitutedRegime build() {
			return this;
		}
		
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder toBuilder() {
			SubstitutedRegime.SubstitutedRegimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SubstitutedRegime.SubstitutedRegimeBuilder builder) {
			ofNullable(getAdditionalRegime()).ifPresent(builder::setAdditionalRegime);
			ofNullable(getRegime()).ifPresent(builder::setRegime);
			ofNullable(getRegimeTerms()).ifPresent(builder::setRegimeTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutedRegime _that = getType().cast(o);
		
			if (!Objects.equals(additionalRegime, _that.getAdditionalRegime())) return false;
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!ListEquals.listEquals(regimeTerms, _that.getRegimeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalRegime != null ? additionalRegime.hashCode() : 0);
			_result = 31 * _result + (regime != null ? regime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (regimeTerms != null ? regimeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutedRegime {" +
				"additionalRegime=" + this.additionalRegime + ", " +
				"regime=" + this.regime + ", " +
				"regimeTerms=" + this.regimeTerms +
			'}';
		}
	}
	
	//SubstitutedRegime.SubstitutedRegimeBuilderImpl
	class SubstitutedRegimeBuilderImpl implements SubstitutedRegime.SubstitutedRegimeBuilder {
	
		protected String additionalRegime;
		protected RegulatoryRegimeEnum regime;
		protected List<SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder> regimeTerms = new ArrayList<>();
	
		public SubstitutedRegimeBuilderImpl() {
		}
	
		@Override
		public String getAdditionalRegime() {
			return additionalRegime;
		}
		
		@Override
		public RegulatoryRegimeEnum getRegime() {
			return regime;
		}
		
		@Override
		public List<? extends SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder> getRegimeTerms() {
			return regimeTerms;
		}
		
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder getOrCreateRegimeTerms(int _index) {
		
			if (regimeTerms==null) {
				this.regimeTerms = new ArrayList<>();
			}
			SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder result;
			return getIndex(regimeTerms, _index, () -> {
						SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder newRegimeTerms = SubstitutedRegimeTerms.builder();
						return newRegimeTerms;
					});
		}
		
	
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder setAdditionalRegime(String additionalRegime) {
			this.additionalRegime = additionalRegime==null?null:additionalRegime;
			return this;
		}
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder setRegime(RegulatoryRegimeEnum regime) {
			this.regime = regime==null?null:regime;
			return this;
		}
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(SubstitutedRegimeTerms regimeTerms) {
			if (regimeTerms!=null) this.regimeTerms.add(regimeTerms.toBuilder());
			return this;
		}
		
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(SubstitutedRegimeTerms regimeTerms, int _idx) {
			getIndex(this.regimeTerms, _idx, () -> regimeTerms.toBuilder());
			return this;
		}
		@Override 
		public SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(List<? extends SubstitutedRegimeTerms> regimeTermss) {
			if (regimeTermss != null) {
				for (SubstitutedRegimeTerms toAdd : regimeTermss) {
					this.regimeTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SubstitutedRegime.SubstitutedRegimeBuilder setRegimeTerms(List<? extends SubstitutedRegimeTerms> regimeTermss) {
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
		public SubstitutedRegime build() {
			return new SubstitutedRegime.SubstitutedRegimeImpl(this);
		}
		
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder prune() {
			regimeTerms = regimeTerms.stream().filter(b->b!=null).<SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalRegime()!=null) return true;
			if (getRegime()!=null) return true;
			if (getRegimeTerms()!=null && getRegimeTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SubstitutedRegime.SubstitutedRegimeBuilder o = (SubstitutedRegime.SubstitutedRegimeBuilder) other;
			
			merger.mergeRosetta(getRegimeTerms(), o.getRegimeTerms(), this::getOrCreateRegimeTerms);
			
			merger.mergeBasic(getAdditionalRegime(), o.getAdditionalRegime(), this::setAdditionalRegime);
			merger.mergeBasic(getRegime(), o.getRegime(), this::setRegime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutedRegime _that = getType().cast(o);
		
			if (!Objects.equals(additionalRegime, _that.getAdditionalRegime())) return false;
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!ListEquals.listEquals(regimeTerms, _that.getRegimeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalRegime != null ? additionalRegime.hashCode() : 0);
			_result = 31 * _result + (regime != null ? regime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (regimeTerms != null ? regimeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutedRegimeBuilder {" +
				"additionalRegime=" + this.additionalRegime + ", " +
				"regime=" + this.regime + ", " +
				"regimeTerms=" + this.regimeTerms +
			'}';
		}
	}
}
