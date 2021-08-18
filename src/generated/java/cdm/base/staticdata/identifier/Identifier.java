package cdm.base.staticdata.identifier;

import cdm.base.staticdata.identifier.meta.IdentifierMeta;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify a generic identifier, applicable to CDM artefacts such as executions, contracts, lifecycle events and legal documents. An issuer can be associated with the actual identifier value as a way to properly qualify it.
 * @version ${project.version}
 */
@RosettaClass

public interface Identifier extends RosettaModelObject, GlobalKey {
	Identifier build();
	Identifier.IdentifierBuilder toBuilder();
	
	/**
	 * The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
	 */
	List<? extends AssignedIdentifier> getAssignedIdentifier();
	/**
	 * The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
	 */
	FieldWithMetaString getIssuer();
	/**
	 * The identifier issuer, when specified by reference to a party specified as part of the transaction.
	 */
	ReferenceWithMetaParty getIssuerReference();
	/**
	 */
	MetaFields getMeta();
	final static IdentifierMeta metaData = new IdentifierMeta();
	
	@Override
	default RosettaMetaData<? extends Identifier> metaData() {
		return metaData;
	} 
			
	static Identifier.IdentifierBuilder builder() {
		return new Identifier.IdentifierBuilderImpl();
	}
	
	default Class<? extends Identifier> getType() {
		return Identifier.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("assignedIdentifier"), processor, AssignedIdentifier.class, getAssignedIdentifier());
		processRosetta(path.newSubPath("issuer"), processor, FieldWithMetaString.class, getIssuer());
		processRosetta(path.newSubPath("issuerReference"), processor, ReferenceWithMetaParty.class, getIssuerReference());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface IdentifierBuilder extends Identifier, RosettaModelObjectBuilder {
		AssignedIdentifier.AssignedIdentifierBuilder getOrCreateAssignedIdentifier(int _index);
		List<? extends AssignedIdentifier.AssignedIdentifierBuilder> getAssignedIdentifier();
		FieldWithMetaStringBuilder getOrCreateIssuer();
		FieldWithMetaStringBuilder getIssuer();
		ReferenceWithMetaPartyBuilder getOrCreateIssuerReference();
		ReferenceWithMetaPartyBuilder getIssuerReference();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Identifier.IdentifierBuilder addAssignedIdentifier(AssignedIdentifier assignedIdentifier);
		Identifier.IdentifierBuilder addAssignedIdentifier(AssignedIdentifier assignedIdentifier, int _idx);
		Identifier.IdentifierBuilder addAssignedIdentifier(List<? extends AssignedIdentifier> assignedIdentifier);
		Identifier.IdentifierBuilder setAssignedIdentifier(List<? extends AssignedIdentifier> assignedIdentifier);
		Identifier.IdentifierBuilder setIssuer(FieldWithMetaString issuer);
		Identifier.IdentifierBuilder setIssuerValue(String issuer);
		Identifier.IdentifierBuilder setIssuerReference(ReferenceWithMetaParty issuerReference);
		Identifier.IdentifierBuilder setIssuerReferenceValue(Party issuerReference);
		Identifier.IdentifierBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("assignedIdentifier"), processor, AssignedIdentifier.AssignedIdentifierBuilder.class, getAssignedIdentifier());
			processRosetta(path.newSubPath("issuer"), processor, FieldWithMetaStringBuilder.class, getIssuer());
			processRosetta(path.newSubPath("issuerReference"), processor, ReferenceWithMetaPartyBuilder.class, getIssuerReference());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//Identifier.IdentifierImpl
	class IdentifierImpl implements Identifier {
		private final List<? extends AssignedIdentifier> assignedIdentifier;
		private final FieldWithMetaString issuer;
		private final ReferenceWithMetaParty issuerReference;
		private final MetaFields meta;
		
		protected IdentifierImpl(Identifier.IdentifierBuilder builder) {
			this.assignedIdentifier = ofNullable(builder.getAssignedIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.issuer = ofNullable(builder.getIssuer()).map(f->f.build()).orElse(null);
			this.issuerReference = ofNullable(builder.getIssuerReference()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends AssignedIdentifier> getAssignedIdentifier() {
			return assignedIdentifier;
		}
		
		@Override
		public FieldWithMetaString getIssuer() {
			return issuer;
		}
		
		@Override
		public ReferenceWithMetaParty getIssuerReference() {
			return issuerReference;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Identifier build() {
			return this;
		}
		
		@Override
		public Identifier.IdentifierBuilder toBuilder() {
			Identifier.IdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Identifier.IdentifierBuilder builder) {
			ofNullable(getAssignedIdentifier()).ifPresent(builder::setAssignedIdentifier);
			ofNullable(getIssuer()).ifPresent(builder::setIssuer);
			ofNullable(getIssuerReference()).ifPresent(builder::setIssuerReference);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Identifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(assignedIdentifier, _that.getAssignedIdentifier())) return false;
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(issuerReference, _that.getIssuerReference())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assignedIdentifier != null ? assignedIdentifier.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (issuerReference != null ? issuerReference.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Identifier {" +
				"assignedIdentifier=" + this.assignedIdentifier + ", " +
				"issuer=" + this.issuer + ", " +
				"issuerReference=" + this.issuerReference + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//Identifier.IdentifierBuilderImpl
	class IdentifierBuilderImpl implements Identifier.IdentifierBuilder, GlobalKeyBuilder {
	
		protected List<AssignedIdentifier.AssignedIdentifierBuilder> assignedIdentifier = new ArrayList<>();
		protected FieldWithMetaStringBuilder issuer;
		protected ReferenceWithMetaPartyBuilder issuerReference;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public IdentifierBuilderImpl() {
		}
	
		@Override
		public List<? extends AssignedIdentifier.AssignedIdentifierBuilder> getAssignedIdentifier() {
			return assignedIdentifier;
		}
		
		public AssignedIdentifier.AssignedIdentifierBuilder getOrCreateAssignedIdentifier(int _index) {
		
			if (assignedIdentifier==null) {
				this.assignedIdentifier = new ArrayList<>();
			}
			AssignedIdentifier.AssignedIdentifierBuilder result;
			return getIndex(assignedIdentifier, _index, () -> {
						AssignedIdentifier.AssignedIdentifierBuilder newAssignedIdentifier = AssignedIdentifier.builder();
						return newAssignedIdentifier;
					});
		}
		
		@Override
		public FieldWithMetaStringBuilder getIssuer() {
			return issuer;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateIssuer() {
			FieldWithMetaStringBuilder result;
			if (issuer!=null) {
				result = issuer;
			}
			else {
				result = issuer = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getIssuerReference() {
			return issuerReference;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreateIssuerReference() {
			ReferenceWithMetaPartyBuilder result;
			if (issuerReference!=null) {
				result = issuerReference;
			}
			else {
				result = issuerReference = ReferenceWithMetaParty.builder();
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
		public Identifier.IdentifierBuilder addAssignedIdentifier(AssignedIdentifier assignedIdentifier) {
			if (assignedIdentifier!=null) this.assignedIdentifier.add(assignedIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Identifier.IdentifierBuilder addAssignedIdentifier(AssignedIdentifier assignedIdentifier, int _idx) {
			getIndex(this.assignedIdentifier, _idx, () -> assignedIdentifier.toBuilder());
			return this;
		}
		@Override 
		public Identifier.IdentifierBuilder addAssignedIdentifier(List<? extends AssignedIdentifier> assignedIdentifiers) {
			if (assignedIdentifiers != null) {
				for (AssignedIdentifier toAdd : assignedIdentifiers) {
					this.assignedIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Identifier.IdentifierBuilder setAssignedIdentifier(List<? extends AssignedIdentifier> assignedIdentifiers) {
			if (assignedIdentifiers == null)  {
				this.assignedIdentifier = new ArrayList<>();
			}
			else {
				this.assignedIdentifier = assignedIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Identifier.IdentifierBuilder setIssuer(FieldWithMetaString issuer) {
			this.issuer = issuer==null?null:issuer.toBuilder();
			return this;
		}
		
		@Override
		public Identifier.IdentifierBuilder setIssuerValue(String issuer) {
			this.getOrCreateIssuer().setValue(issuer);
			return this;
		}
		@Override
		public Identifier.IdentifierBuilder setIssuerReference(ReferenceWithMetaParty issuerReference) {
			this.issuerReference = issuerReference==null?null:issuerReference.toBuilder();
			return this;
		}
		
		@Override
		public Identifier.IdentifierBuilder setIssuerReferenceValue(Party issuerReference) {
			this.getOrCreateIssuerReference().setValue(issuerReference);
			return this;
		}
		@Override
		public Identifier.IdentifierBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public Identifier build() {
			return new Identifier.IdentifierImpl(this);
		}
		
		@Override
		public Identifier.IdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Identifier.IdentifierBuilder prune() {
			assignedIdentifier = assignedIdentifier.stream().filter(b->b!=null).<AssignedIdentifier.AssignedIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (issuer!=null && !issuer.prune().hasData()) issuer = null;
			if (issuerReference!=null && !issuerReference.prune().hasData()) issuerReference = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssignedIdentifier()!=null && getAssignedIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIssuer()!=null) return true;
			if (getIssuerReference()!=null && getIssuerReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Identifier.IdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Identifier.IdentifierBuilder o = (Identifier.IdentifierBuilder) other;
			
			merger.mergeRosetta(getAssignedIdentifier(), o.getAssignedIdentifier(), this::getOrCreateAssignedIdentifier);
			merger.mergeRosetta(getIssuer(), o.getIssuer(), this::setIssuer);
			merger.mergeRosetta(getIssuerReference(), o.getIssuerReference(), this::setIssuerReference);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Identifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(assignedIdentifier, _that.getAssignedIdentifier())) return false;
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(issuerReference, _that.getIssuerReference())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assignedIdentifier != null ? assignedIdentifier.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (issuerReference != null ? issuerReference.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifierBuilder {" +
				"assignedIdentifier=" + this.assignedIdentifier + ", " +
				"issuer=" + this.issuer + ", " +
				"issuerReference=" + this.issuerReference + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
