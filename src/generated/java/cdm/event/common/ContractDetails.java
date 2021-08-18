package cdm.event.common;

import cdm.event.common.meta.ContractDetailsMeta;
import cdm.legalagreement.common.GoverningLawEnum;
import cdm.legalagreement.common.GoverningLawEnum;
import cdm.legalagreement.common.RelatedAgreement;
import cdm.legalagreement.common.metafields.FieldWithMetaGoverningLawEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder;
import cdm.legalagreement.contract.PartyContractInformation;
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
 * Defines specific attributes that relate to contractual details of trades.
 * @version ${project.version}
 */
@RosettaClass

public interface ContractDetails extends RosettaModelObject, GlobalKey {
	ContractDetails build();
	ContractDetails.ContractDetailsBuilder toBuilder();
	
	/**
	 * Represents the legal document(s) that governs a trade and associated contractual product terms, either as a reference to such documents when specified as part of the CDM, or through identification of some of the key terms of those documents, such as the type of document, the document identifier, the publisher, the document vintage and the agreement date.
	 */
	List<? extends RelatedAgreement> getDocumentation();
	/**
	 * Represents the law governing the trade and associated contractual product terms.
	 */
	FieldWithMetaGoverningLawEnum getGoverningLaw();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Represents additional contractual information provided by each involved party.
	 */
	List<? extends PartyContractInformation> getPartyContractInformation();
	final static ContractDetailsMeta metaData = new ContractDetailsMeta();
	
	@Override
	default RosettaMetaData<? extends ContractDetails> metaData() {
		return metaData;
	} 
			
	static ContractDetails.ContractDetailsBuilder builder() {
		return new ContractDetails.ContractDetailsBuilderImpl();
	}
	
	default Class<? extends ContractDetails> getType() {
		return ContractDetails.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("documentation"), processor, RelatedAgreement.class, getDocumentation());
		processRosetta(path.newSubPath("governingLaw"), processor, FieldWithMetaGoverningLawEnum.class, getGoverningLaw());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("partyContractInformation"), processor, PartyContractInformation.class, getPartyContractInformation());
	}
	
	
	interface ContractDetailsBuilder extends ContractDetails, RosettaModelObjectBuilder {
		RelatedAgreement.RelatedAgreementBuilder getOrCreateDocumentation(int _index);
		List<? extends RelatedAgreement.RelatedAgreementBuilder> getDocumentation();
		FieldWithMetaGoverningLawEnumBuilder getOrCreateGoverningLaw();
		FieldWithMetaGoverningLawEnumBuilder getGoverningLaw();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		PartyContractInformation.PartyContractInformationBuilder getOrCreatePartyContractInformation(int _index);
		List<? extends PartyContractInformation.PartyContractInformationBuilder> getPartyContractInformation();
		ContractDetails.ContractDetailsBuilder addDocumentation(RelatedAgreement documentation);
		ContractDetails.ContractDetailsBuilder addDocumentation(RelatedAgreement documentation, int _idx);
		ContractDetails.ContractDetailsBuilder addDocumentation(List<? extends RelatedAgreement> documentation);
		ContractDetails.ContractDetailsBuilder setDocumentation(List<? extends RelatedAgreement> documentation);
		ContractDetails.ContractDetailsBuilder setGoverningLaw(FieldWithMetaGoverningLawEnum governingLaw);
		ContractDetails.ContractDetailsBuilder setGoverningLawValue(GoverningLawEnum governingLaw);
		ContractDetails.ContractDetailsBuilder setMeta(MetaFields meta);
		ContractDetails.ContractDetailsBuilder addPartyContractInformation(PartyContractInformation partyContractInformation);
		ContractDetails.ContractDetailsBuilder addPartyContractInformation(PartyContractInformation partyContractInformation, int _idx);
		ContractDetails.ContractDetailsBuilder addPartyContractInformation(List<? extends PartyContractInformation> partyContractInformation);
		ContractDetails.ContractDetailsBuilder setPartyContractInformation(List<? extends PartyContractInformation> partyContractInformation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("documentation"), processor, RelatedAgreement.RelatedAgreementBuilder.class, getDocumentation());
			processRosetta(path.newSubPath("governingLaw"), processor, FieldWithMetaGoverningLawEnumBuilder.class, getGoverningLaw());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("partyContractInformation"), processor, PartyContractInformation.PartyContractInformationBuilder.class, getPartyContractInformation());
		}
		
	}
	
	//ContractDetails.ContractDetailsImpl
	class ContractDetailsImpl implements ContractDetails {
		private final List<? extends RelatedAgreement> documentation;
		private final FieldWithMetaGoverningLawEnum governingLaw;
		private final MetaFields meta;
		private final List<? extends PartyContractInformation> partyContractInformation;
		
		protected ContractDetailsImpl(ContractDetails.ContractDetailsBuilder builder) {
			this.documentation = ofNullable(builder.getDocumentation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.governingLaw = ofNullable(builder.getGoverningLaw()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.partyContractInformation = ofNullable(builder.getPartyContractInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends RelatedAgreement> getDocumentation() {
			return documentation;
		}
		
		@Override
		public FieldWithMetaGoverningLawEnum getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends PartyContractInformation> getPartyContractInformation() {
			return partyContractInformation;
		}
		
		@Override
		public ContractDetails build() {
			return this;
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder toBuilder() {
			ContractDetails.ContractDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractDetails.ContractDetailsBuilder builder) {
			ofNullable(getDocumentation()).ifPresent(builder::setDocumentation);
			ofNullable(getGoverningLaw()).ifPresent(builder::setGoverningLaw);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPartyContractInformation()).ifPresent(builder::setPartyContractInformation);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(documentation, _that.getDocumentation())) return false;
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(partyContractInformation, _that.getPartyContractInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			_result = 31 * _result + (governingLaw != null ? governingLaw.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (partyContractInformation != null ? partyContractInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractDetails {" +
				"documentation=" + this.documentation + ", " +
				"governingLaw=" + this.governingLaw + ", " +
				"meta=" + this.meta + ", " +
				"partyContractInformation=" + this.partyContractInformation +
			'}';
		}
	}
	
	//ContractDetails.ContractDetailsBuilderImpl
	class ContractDetailsBuilderImpl implements ContractDetails.ContractDetailsBuilder, GlobalKeyBuilder {
	
		protected List<RelatedAgreement.RelatedAgreementBuilder> documentation = new ArrayList<>();
		protected FieldWithMetaGoverningLawEnumBuilder governingLaw;
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<PartyContractInformation.PartyContractInformationBuilder> partyContractInformation = new ArrayList<>();
	
		public ContractDetailsBuilderImpl() {
		}
	
		@Override
		public List<? extends RelatedAgreement.RelatedAgreementBuilder> getDocumentation() {
			return documentation;
		}
		
		public RelatedAgreement.RelatedAgreementBuilder getOrCreateDocumentation(int _index) {
		
			if (documentation==null) {
				this.documentation = new ArrayList<>();
			}
			RelatedAgreement.RelatedAgreementBuilder result;
			return getIndex(documentation, _index, () -> {
						RelatedAgreement.RelatedAgreementBuilder newDocumentation = RelatedAgreement.builder();
						return newDocumentation;
					});
		}
		
		@Override
		public FieldWithMetaGoverningLawEnumBuilder getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		public FieldWithMetaGoverningLawEnumBuilder getOrCreateGoverningLaw() {
			FieldWithMetaGoverningLawEnumBuilder result;
			if (governingLaw!=null) {
				result = governingLaw;
			}
			else {
				result = governingLaw = FieldWithMetaGoverningLawEnum.builder();
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
		public List<? extends PartyContractInformation.PartyContractInformationBuilder> getPartyContractInformation() {
			return partyContractInformation;
		}
		
		public PartyContractInformation.PartyContractInformationBuilder getOrCreatePartyContractInformation(int _index) {
		
			if (partyContractInformation==null) {
				this.partyContractInformation = new ArrayList<>();
			}
			PartyContractInformation.PartyContractInformationBuilder result;
			return getIndex(partyContractInformation, _index, () -> {
						PartyContractInformation.PartyContractInformationBuilder newPartyContractInformation = PartyContractInformation.builder();
						return newPartyContractInformation;
					});
		}
		
	
		@Override
		public ContractDetails.ContractDetailsBuilder addDocumentation(RelatedAgreement documentation) {
			if (documentation!=null) this.documentation.add(documentation.toBuilder());
			return this;
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder addDocumentation(RelatedAgreement documentation, int _idx) {
			getIndex(this.documentation, _idx, () -> documentation.toBuilder());
			return this;
		}
		@Override 
		public ContractDetails.ContractDetailsBuilder addDocumentation(List<? extends RelatedAgreement> documentations) {
			if (documentations != null) {
				for (RelatedAgreement toAdd : documentations) {
					this.documentation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ContractDetails.ContractDetailsBuilder setDocumentation(List<? extends RelatedAgreement> documentations) {
			if (documentations == null)  {
				this.documentation = new ArrayList<>();
			}
			else {
				this.documentation = documentations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder setGoverningLaw(FieldWithMetaGoverningLawEnum governingLaw) {
			this.governingLaw = governingLaw==null?null:governingLaw.toBuilder();
			return this;
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder setGoverningLawValue(GoverningLawEnum governingLaw) {
			this.getOrCreateGoverningLaw().setValue(governingLaw);
			return this;
		}
		@Override
		public ContractDetails.ContractDetailsBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public ContractDetails.ContractDetailsBuilder addPartyContractInformation(PartyContractInformation partyContractInformation) {
			if (partyContractInformation!=null) this.partyContractInformation.add(partyContractInformation.toBuilder());
			return this;
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder addPartyContractInformation(PartyContractInformation partyContractInformation, int _idx) {
			getIndex(this.partyContractInformation, _idx, () -> partyContractInformation.toBuilder());
			return this;
		}
		@Override 
		public ContractDetails.ContractDetailsBuilder addPartyContractInformation(List<? extends PartyContractInformation> partyContractInformations) {
			if (partyContractInformations != null) {
				for (PartyContractInformation toAdd : partyContractInformations) {
					this.partyContractInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ContractDetails.ContractDetailsBuilder setPartyContractInformation(List<? extends PartyContractInformation> partyContractInformations) {
			if (partyContractInformations == null)  {
				this.partyContractInformation = new ArrayList<>();
			}
			else {
				this.partyContractInformation = partyContractInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ContractDetails build() {
			return new ContractDetails.ContractDetailsImpl(this);
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractDetails.ContractDetailsBuilder prune() {
			documentation = documentation.stream().filter(b->b!=null).<RelatedAgreement.RelatedAgreementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (governingLaw!=null && !governingLaw.prune().hasData()) governingLaw = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			partyContractInformation = partyContractInformation.stream().filter(b->b!=null).<PartyContractInformation.PartyContractInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDocumentation()!=null && getDocumentation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getGoverningLaw()!=null) return true;
			if (getPartyContractInformation()!=null && getPartyContractInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractDetails.ContractDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractDetails.ContractDetailsBuilder o = (ContractDetails.ContractDetailsBuilder) other;
			
			merger.mergeRosetta(getDocumentation(), o.getDocumentation(), this::getOrCreateDocumentation);
			merger.mergeRosetta(getGoverningLaw(), o.getGoverningLaw(), this::setGoverningLaw);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPartyContractInformation(), o.getPartyContractInformation(), this::getOrCreatePartyContractInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(documentation, _that.getDocumentation())) return false;
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(partyContractInformation, _that.getPartyContractInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			_result = 31 * _result + (governingLaw != null ? governingLaw.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (partyContractInformation != null ? partyContractInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractDetailsBuilder {" +
				"documentation=" + this.documentation + ", " +
				"governingLaw=" + this.governingLaw + ", " +
				"meta=" + this.meta + ", " +
				"partyContractInformation=" + this.partyContractInformation +
			'}';
		}
	}
}
