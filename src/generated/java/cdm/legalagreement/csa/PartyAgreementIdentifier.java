package cdm.legalagreement.csa;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
import cdm.legalagreement.csa.meta.PartyAgreementIdentifierMeta;
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
 * A class defining a legal agreement identifier issued by the indicated party.
 * @version ${project.version}
 */
@RosettaClass

public interface PartyAgreementIdentifier extends RosettaModelObject, GlobalKey {
	PartyAgreementIdentifier build();
	PartyAgreementIdentifier.PartyAgreementIdentifierBuilder toBuilder();
	
	/**
	 * While FpML specifies the document identifier with a value and an associated scheme, the CDM makes use of the Identifier, which has an explicit issuer. The issuer of this identifier is not necessarily the same as the party reference.
	 */
	List<? extends FieldWithMetaIdentifier> getDocumentIdentifier();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Party that issued the document identifier.
	 */
	ReferenceWithMetaParty getPartyReference();
	final static PartyAgreementIdentifierMeta metaData = new PartyAgreementIdentifierMeta();
	
	@Override
	default RosettaMetaData<? extends PartyAgreementIdentifier> metaData() {
		return metaData;
	} 
			
	static PartyAgreementIdentifier.PartyAgreementIdentifierBuilder builder() {
		return new PartyAgreementIdentifier.PartyAgreementIdentifierBuilderImpl();
	}
	
	default Class<? extends PartyAgreementIdentifier> getType() {
		return PartyAgreementIdentifier.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("documentIdentifier"), processor, FieldWithMetaIdentifier.class, getDocumentIdentifier());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
	}
	
	
	interface PartyAgreementIdentifierBuilder extends PartyAgreementIdentifier, RosettaModelObjectBuilder {
		FieldWithMetaIdentifierBuilder getOrCreateDocumentIdentifier(int _index);
		List<? extends FieldWithMetaIdentifierBuilder> getDocumentIdentifier();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		ReferenceWithMetaPartyBuilder getPartyReference();
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(FieldWithMetaIdentifier documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(FieldWithMetaIdentifier documentIdentifier, int _idx);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(Identifier documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(Identifier documentIdentifier, int _idx);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(List<? extends FieldWithMetaIdentifier> documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setDocumentIdentifier(List<? extends FieldWithMetaIdentifier> documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(List<? extends Identifier> documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setDocumentIdentifierValue(List<? extends Identifier> documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setMeta(MetaFields meta);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setPartyReferenceValue(Party partyReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("documentIdentifier"), processor, FieldWithMetaIdentifierBuilder.class, getDocumentIdentifier());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaPartyBuilder.class, getPartyReference());
		}
		
	}
	
	//PartyAgreementIdentifier.PartyAgreementIdentifierImpl
	class PartyAgreementIdentifierImpl implements PartyAgreementIdentifier {
		private final List<? extends FieldWithMetaIdentifier> documentIdentifier;
		private final MetaFields meta;
		private final ReferenceWithMetaParty partyReference;
		
		protected PartyAgreementIdentifierImpl(PartyAgreementIdentifier.PartyAgreementIdentifierBuilder builder) {
			this.documentIdentifier = ofNullable(builder.getDocumentIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends FieldWithMetaIdentifier> getDocumentIdentifier() {
			return documentIdentifier;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ReferenceWithMetaParty getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyAgreementIdentifier build() {
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder toBuilder() {
			PartyAgreementIdentifier.PartyAgreementIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyAgreementIdentifier.PartyAgreementIdentifierBuilder builder) {
			ofNullable(getDocumentIdentifier()).ifPresent(builder::setDocumentIdentifier);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyAgreementIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(documentIdentifier, _that.getDocumentIdentifier())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (documentIdentifier != null ? documentIdentifier.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyAgreementIdentifier {" +
				"documentIdentifier=" + this.documentIdentifier + ", " +
				"meta=" + this.meta + ", " +
				"partyReference=" + this.partyReference +
			'}';
		}
	}
	
	//PartyAgreementIdentifier.PartyAgreementIdentifierBuilderImpl
	class PartyAgreementIdentifierBuilderImpl implements PartyAgreementIdentifier.PartyAgreementIdentifierBuilder, GlobalKeyBuilder {
	
		protected List<FieldWithMetaIdentifierBuilder> documentIdentifier = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		protected ReferenceWithMetaPartyBuilder partyReference;
	
		public PartyAgreementIdentifierBuilderImpl() {
		}
	
		@Override
		public List<? extends FieldWithMetaIdentifierBuilder> getDocumentIdentifier() {
			return documentIdentifier;
		}
		
		public FieldWithMetaIdentifierBuilder getOrCreateDocumentIdentifier(int _index) {
		
			if (documentIdentifier==null) {
				this.documentIdentifier = new ArrayList<>();
			}
			FieldWithMetaIdentifierBuilder result;
			return getIndex(documentIdentifier, _index, () -> {
						FieldWithMetaIdentifierBuilder newDocumentIdentifier = FieldWithMetaIdentifier.builder();
						return newDocumentIdentifier;
					});
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
		public ReferenceWithMetaPartyBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreatePartyReference() {
			ReferenceWithMetaPartyBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(FieldWithMetaIdentifier documentIdentifier) {
			if (documentIdentifier!=null) this.documentIdentifier.add(documentIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(FieldWithMetaIdentifier documentIdentifier, int _idx) {
			getIndex(this.documentIdentifier, _idx, () -> documentIdentifier.toBuilder());
			return this;
		}
		
			@Override
			public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(Identifier documentIdentifier) {
				this.getOrCreateDocumentIdentifier(-1).setValue(documentIdentifier.toBuilder());
				return this;
			}
			
			@Override
			public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(Identifier documentIdentifier, int _idx) {
				this.getOrCreateDocumentIdentifier(_idx).setValue(documentIdentifier.toBuilder());
				return this;
			}
		@Override 
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(List<? extends FieldWithMetaIdentifier> documentIdentifiers) {
			if (documentIdentifiers != null) {
				for (FieldWithMetaIdentifier toAdd : documentIdentifiers) {
					this.documentIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setDocumentIdentifier(List<? extends FieldWithMetaIdentifier> documentIdentifiers) {
			if (documentIdentifiers == null)  {
				this.documentIdentifier = new ArrayList<>();
			}
			else {
				this.documentIdentifier = documentIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(List<? extends Identifier> documentIdentifiers) {
			if (documentIdentifiers != null) {
				for (Identifier toAdd : documentIdentifiers) {
					this.addDocumentIdentifierValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setDocumentIdentifierValue(List<? extends Identifier> documentIdentifiers) {
			this.documentIdentifier.clear();
			if (documentIdentifiers!=null) {
				documentIdentifiers.forEach(this::addDocumentIdentifierValue);
			}
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setPartyReference(ReferenceWithMetaParty partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setPartyReferenceValue(Party partyReference) {
			this.getOrCreatePartyReference().setValue(partyReference);
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier build() {
			return new PartyAgreementIdentifier.PartyAgreementIdentifierImpl(this);
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder prune() {
			documentIdentifier = documentIdentifier.stream().filter(b->b!=null).<FieldWithMetaIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDocumentIdentifier()!=null && getDocumentIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyAgreementIdentifier.PartyAgreementIdentifierBuilder o = (PartyAgreementIdentifier.PartyAgreementIdentifierBuilder) other;
			
			merger.mergeRosetta(getDocumentIdentifier(), o.getDocumentIdentifier(), this::getOrCreateDocumentIdentifier);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyAgreementIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(documentIdentifier, _that.getDocumentIdentifier())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (documentIdentifier != null ? documentIdentifier.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyAgreementIdentifierBuilder {" +
				"documentIdentifier=" + this.documentIdentifier + ", " +
				"meta=" + this.meta + ", " +
				"partyReference=" + this.partyReference +
			'}';
		}
	}
}
