package cdm.legalagreement.master;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.Party;
import cdm.legalagreement.common.SpecifiedEntityTermsEnum;
import cdm.legalagreement.master.meta.SpecifiedEntityMeta;
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
 * Description
 * @version ${project.version}
 */
@RosettaClass

public interface SpecifiedEntity extends RosettaModelObject {
	SpecifiedEntity build();
	SpecifiedEntity.SpecifiedEntityBuilder toBuilder();
	
	/**
	 * The meaning of Material Subsidiary for the Event of Default or Termination Event specified.
	 */
	String getMaterialSubsidiaryTerms();
	/**
	 * The non standard terms for the Event of Default or Termination Event specified.
	 */
	String getOtherSpecifiedEntityTerms();
	/**
	 * The elective party
	 */
	Party getParty();
	/**
	 * The specified entities for the Event of Default or Termination Event specified.
	 */
	List<? extends LegalEntity> getSpecifiedEntity();
	/**
	 * The specified entity terms for the Event of Default or Termination Event specified.
	 */
	SpecifiedEntityTermsEnum getSpecifiedEntityTerms();
	final static SpecifiedEntityMeta metaData = new SpecifiedEntityMeta();
	
	@Override
	default RosettaMetaData<? extends SpecifiedEntity> metaData() {
		return metaData;
	} 
			
	static SpecifiedEntity.SpecifiedEntityBuilder builder() {
		return new SpecifiedEntity.SpecifiedEntityBuilderImpl();
	}
	
	default Class<? extends SpecifiedEntity> getType() {
		return SpecifiedEntity.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("materialSubsidiaryTerms"), String.class, getMaterialSubsidiaryTerms(), this);
		processor.processBasic(path.newSubPath("otherSpecifiedEntityTerms"), String.class, getOtherSpecifiedEntityTerms(), this);
		processor.processBasic(path.newSubPath("specifiedEntityTerms"), SpecifiedEntityTermsEnum.class, getSpecifiedEntityTerms(), this);
		
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("specifiedEntity"), processor, LegalEntity.class, getSpecifiedEntity());
	}
	
	
	interface SpecifiedEntityBuilder extends SpecifiedEntity, RosettaModelObjectBuilder {
		Party.PartyBuilder getOrCreateParty();
		Party.PartyBuilder getParty();
		LegalEntity.LegalEntityBuilder getOrCreateSpecifiedEntity(int _index);
		List<? extends LegalEntity.LegalEntityBuilder> getSpecifiedEntity();
		SpecifiedEntity.SpecifiedEntityBuilder setMaterialSubsidiaryTerms(String materialSubsidiaryTerms);
		SpecifiedEntity.SpecifiedEntityBuilder setOtherSpecifiedEntityTerms(String otherSpecifiedEntityTerms);
		SpecifiedEntity.SpecifiedEntityBuilder setParty(Party party);
		SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(LegalEntity specifiedEntity);
		SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(LegalEntity specifiedEntity, int _idx);
		SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(List<? extends LegalEntity> specifiedEntity);
		SpecifiedEntity.SpecifiedEntityBuilder setSpecifiedEntity(List<? extends LegalEntity> specifiedEntity);
		SpecifiedEntity.SpecifiedEntityBuilder setSpecifiedEntityTerms(SpecifiedEntityTermsEnum specifiedEntityTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("materialSubsidiaryTerms"), String.class, getMaterialSubsidiaryTerms(), this);
			processor.processBasic(path.newSubPath("otherSpecifiedEntityTerms"), String.class, getOtherSpecifiedEntityTerms(), this);
			processor.processBasic(path.newSubPath("specifiedEntityTerms"), SpecifiedEntityTermsEnum.class, getSpecifiedEntityTerms(), this);
			
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("specifiedEntity"), processor, LegalEntity.LegalEntityBuilder.class, getSpecifiedEntity());
		}
		
	}
	
	//SpecifiedEntity.SpecifiedEntityImpl
	class SpecifiedEntityImpl implements SpecifiedEntity {
		private final String materialSubsidiaryTerms;
		private final String otherSpecifiedEntityTerms;
		private final Party party;
		private final List<? extends LegalEntity> specifiedEntity;
		private final SpecifiedEntityTermsEnum specifiedEntityTerms;
		
		protected SpecifiedEntityImpl(SpecifiedEntity.SpecifiedEntityBuilder builder) {
			this.materialSubsidiaryTerms = builder.getMaterialSubsidiaryTerms();
			this.otherSpecifiedEntityTerms = builder.getOtherSpecifiedEntityTerms();
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
			this.specifiedEntity = ofNullable(builder.getSpecifiedEntity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.specifiedEntityTerms = builder.getSpecifiedEntityTerms();
		}
		
		@Override
		public String getMaterialSubsidiaryTerms() {
			return materialSubsidiaryTerms;
		}
		
		@Override
		public String getOtherSpecifiedEntityTerms() {
			return otherSpecifiedEntityTerms;
		}
		
		@Override
		public Party getParty() {
			return party;
		}
		
		@Override
		public List<? extends LegalEntity> getSpecifiedEntity() {
			return specifiedEntity;
		}
		
		@Override
		public SpecifiedEntityTermsEnum getSpecifiedEntityTerms() {
			return specifiedEntityTerms;
		}
		
		@Override
		public SpecifiedEntity build() {
			return this;
		}
		
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder toBuilder() {
			SpecifiedEntity.SpecifiedEntityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpecifiedEntity.SpecifiedEntityBuilder builder) {
			ofNullable(getMaterialSubsidiaryTerms()).ifPresent(builder::setMaterialSubsidiaryTerms);
			ofNullable(getOtherSpecifiedEntityTerms()).ifPresent(builder::setOtherSpecifiedEntityTerms);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getSpecifiedEntity()).ifPresent(builder::setSpecifiedEntity);
			ofNullable(getSpecifiedEntityTerms()).ifPresent(builder::setSpecifiedEntityTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedEntity _that = getType().cast(o);
		
			if (!Objects.equals(materialSubsidiaryTerms, _that.getMaterialSubsidiaryTerms())) return false;
			if (!Objects.equals(otherSpecifiedEntityTerms, _that.getOtherSpecifiedEntityTerms())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(specifiedEntity, _that.getSpecifiedEntity())) return false;
			if (!Objects.equals(specifiedEntityTerms, _that.getSpecifiedEntityTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (materialSubsidiaryTerms != null ? materialSubsidiaryTerms.hashCode() : 0);
			_result = 31 * _result + (otherSpecifiedEntityTerms != null ? otherSpecifiedEntityTerms.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (specifiedEntity != null ? specifiedEntity.hashCode() : 0);
			_result = 31 * _result + (specifiedEntityTerms != null ? specifiedEntityTerms.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedEntity {" +
				"materialSubsidiaryTerms=" + this.materialSubsidiaryTerms + ", " +
				"otherSpecifiedEntityTerms=" + this.otherSpecifiedEntityTerms + ", " +
				"party=" + this.party + ", " +
				"specifiedEntity=" + this.specifiedEntity + ", " +
				"specifiedEntityTerms=" + this.specifiedEntityTerms +
			'}';
		}
	}
	
	//SpecifiedEntity.SpecifiedEntityBuilderImpl
	class SpecifiedEntityBuilderImpl implements SpecifiedEntity.SpecifiedEntityBuilder {
	
		protected String materialSubsidiaryTerms;
		protected String otherSpecifiedEntityTerms;
		protected Party.PartyBuilder party;
		protected List<LegalEntity.LegalEntityBuilder> specifiedEntity = new ArrayList<>();
		protected SpecifiedEntityTermsEnum specifiedEntityTerms;
	
		public SpecifiedEntityBuilderImpl() {
		}
	
		@Override
		public String getMaterialSubsidiaryTerms() {
			return materialSubsidiaryTerms;
		}
		
		@Override
		public String getOtherSpecifiedEntityTerms() {
			return otherSpecifiedEntityTerms;
		}
		
		@Override
		public Party.PartyBuilder getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty() {
			Party.PartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = Party.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends LegalEntity.LegalEntityBuilder> getSpecifiedEntity() {
			return specifiedEntity;
		}
		
		public LegalEntity.LegalEntityBuilder getOrCreateSpecifiedEntity(int _index) {
		
			if (specifiedEntity==null) {
				this.specifiedEntity = new ArrayList<>();
			}
			LegalEntity.LegalEntityBuilder result;
			return getIndex(specifiedEntity, _index, () -> {
						LegalEntity.LegalEntityBuilder newSpecifiedEntity = LegalEntity.builder();
						return newSpecifiedEntity;
					});
		}
		
		@Override
		public SpecifiedEntityTermsEnum getSpecifiedEntityTerms() {
			return specifiedEntityTerms;
		}
		
	
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder setMaterialSubsidiaryTerms(String materialSubsidiaryTerms) {
			this.materialSubsidiaryTerms = materialSubsidiaryTerms==null?null:materialSubsidiaryTerms;
			return this;
		}
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder setOtherSpecifiedEntityTerms(String otherSpecifiedEntityTerms) {
			this.otherSpecifiedEntityTerms = otherSpecifiedEntityTerms==null?null:otherSpecifiedEntityTerms;
			return this;
		}
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder setParty(Party party) {
			this.party = party==null?null:party.toBuilder();
			return this;
		}
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(LegalEntity specifiedEntity) {
			if (specifiedEntity!=null) this.specifiedEntity.add(specifiedEntity.toBuilder());
			return this;
		}
		
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(LegalEntity specifiedEntity, int _idx) {
			getIndex(this.specifiedEntity, _idx, () -> specifiedEntity.toBuilder());
			return this;
		}
		@Override 
		public SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(List<? extends LegalEntity> specifiedEntitys) {
			if (specifiedEntitys != null) {
				for (LegalEntity toAdd : specifiedEntitys) {
					this.specifiedEntity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SpecifiedEntity.SpecifiedEntityBuilder setSpecifiedEntity(List<? extends LegalEntity> specifiedEntitys) {
			if (specifiedEntitys == null)  {
				this.specifiedEntity = new ArrayList<>();
			}
			else {
				this.specifiedEntity = specifiedEntitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder setSpecifiedEntityTerms(SpecifiedEntityTermsEnum specifiedEntityTerms) {
			this.specifiedEntityTerms = specifiedEntityTerms==null?null:specifiedEntityTerms;
			return this;
		}
		
		@Override
		public SpecifiedEntity build() {
			return new SpecifiedEntity.SpecifiedEntityImpl(this);
		}
		
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder prune() {
			if (party!=null && !party.prune().hasData()) party = null;
			specifiedEntity = specifiedEntity.stream().filter(b->b!=null).<LegalEntity.LegalEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMaterialSubsidiaryTerms()!=null) return true;
			if (getOtherSpecifiedEntityTerms()!=null) return true;
			if (getParty()!=null && getParty().hasData()) return true;
			if (getSpecifiedEntity()!=null && getSpecifiedEntity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpecifiedEntityTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SpecifiedEntity.SpecifiedEntityBuilder o = (SpecifiedEntity.SpecifiedEntityBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			merger.mergeRosetta(getSpecifiedEntity(), o.getSpecifiedEntity(), this::getOrCreateSpecifiedEntity);
			
			merger.mergeBasic(getMaterialSubsidiaryTerms(), o.getMaterialSubsidiaryTerms(), this::setMaterialSubsidiaryTerms);
			merger.mergeBasic(getOtherSpecifiedEntityTerms(), o.getOtherSpecifiedEntityTerms(), this::setOtherSpecifiedEntityTerms);
			merger.mergeBasic(getSpecifiedEntityTerms(), o.getSpecifiedEntityTerms(), this::setSpecifiedEntityTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedEntity _that = getType().cast(o);
		
			if (!Objects.equals(materialSubsidiaryTerms, _that.getMaterialSubsidiaryTerms())) return false;
			if (!Objects.equals(otherSpecifiedEntityTerms, _that.getOtherSpecifiedEntityTerms())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(specifiedEntity, _that.getSpecifiedEntity())) return false;
			if (!Objects.equals(specifiedEntityTerms, _that.getSpecifiedEntityTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (materialSubsidiaryTerms != null ? materialSubsidiaryTerms.hashCode() : 0);
			_result = 31 * _result + (otherSpecifiedEntityTerms != null ? otherSpecifiedEntityTerms.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (specifiedEntity != null ? specifiedEntity.hashCode() : 0);
			_result = 31 * _result + (specifiedEntityTerms != null ? specifiedEntityTerms.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedEntityBuilder {" +
				"materialSubsidiaryTerms=" + this.materialSubsidiaryTerms + ", " +
				"otherSpecifiedEntityTerms=" + this.otherSpecifiedEntityTerms + ", " +
				"party=" + this.party + ", " +
				"specifiedEntity=" + this.specifiedEntity + ", " +
				"specifiedEntityTerms=" + this.specifiedEntityTerms +
			'}';
		}
	}
}
