package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.AncillaryPartyMeta;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
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
 * Defines an ancillary role enumerated value with an associated party reference. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
 * @version ${project.version}
 */
@RosettaClass

public interface AncillaryParty extends RosettaModelObject {
	AncillaryParty build();
	AncillaryParty.AncillaryPartyBuilder toBuilder();
	
	/**
	 * Optionally specifies the counterparty that the ancillary party is acting on behalf of.
	 */
	CounterpartyRoleEnum getOnBehalfOf();
	/**
	 * Specifies the party, or parties, associated to the ancillary role.
	 */
	List<? extends ReferenceWithMetaParty> getPartyReference();
	/**
	 * Specifies the AncillaryRoleEnum that is associated to the party reference. An ancillary party is any involved party that is not one of the two principal parties to the transaction.
	 */
	AncillaryRoleEnum getRole();
	final static AncillaryPartyMeta metaData = new AncillaryPartyMeta();
	
	@Override
	default RosettaMetaData<? extends AncillaryParty> metaData() {
		return metaData;
	} 
			
	static AncillaryParty.AncillaryPartyBuilder builder() {
		return new AncillaryParty.AncillaryPartyBuilderImpl();
	}
	
	default Class<? extends AncillaryParty> getType() {
		return AncillaryParty.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("onBehalfOf"), CounterpartyRoleEnum.class, getOnBehalfOf(), this);
		processor.processBasic(path.newSubPath("role"), AncillaryRoleEnum.class, getRole(), this);
		
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
	}
	
	
	interface AncillaryPartyBuilder extends AncillaryParty, RosettaModelObjectBuilder {
		ReferenceWithMetaPartyBuilder getOrCreatePartyReference(int _index);
		List<? extends ReferenceWithMetaPartyBuilder> getPartyReference();
		AncillaryParty.AncillaryPartyBuilder setOnBehalfOf(CounterpartyRoleEnum onBehalfOf);
		AncillaryParty.AncillaryPartyBuilder addPartyReference(ReferenceWithMetaParty partyReference);
		AncillaryParty.AncillaryPartyBuilder addPartyReference(ReferenceWithMetaParty partyReference, int _idx);
		AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(Party partyReference);
		AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(Party partyReference, int _idx);
		AncillaryParty.AncillaryPartyBuilder addPartyReference(List<? extends ReferenceWithMetaParty> partyReference);
		AncillaryParty.AncillaryPartyBuilder setPartyReference(List<? extends ReferenceWithMetaParty> partyReference);
		AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(List<? extends Party> partyReference);
		AncillaryParty.AncillaryPartyBuilder setPartyReferenceValue(List<? extends Party> partyReference);
		AncillaryParty.AncillaryPartyBuilder setRole(AncillaryRoleEnum role);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("onBehalfOf"), CounterpartyRoleEnum.class, getOnBehalfOf(), this);
			processor.processBasic(path.newSubPath("role"), AncillaryRoleEnum.class, getRole(), this);
			
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaPartyBuilder.class, getPartyReference());
		}
		
	}
	
	//AncillaryParty.AncillaryPartyImpl
	class AncillaryPartyImpl implements AncillaryParty {
		private final CounterpartyRoleEnum onBehalfOf;
		private final List<? extends ReferenceWithMetaParty> partyReference;
		private final AncillaryRoleEnum role;
		
		protected AncillaryPartyImpl(AncillaryParty.AncillaryPartyBuilder builder) {
			this.onBehalfOf = builder.getOnBehalfOf();
			this.partyReference = ofNullable(builder.getPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.role = builder.getRole();
		}
		
		@Override
		public CounterpartyRoleEnum getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public List<? extends ReferenceWithMetaParty> getPartyReference() {
			return partyReference;
		}
		
		@Override
		public AncillaryRoleEnum getRole() {
			return role;
		}
		
		@Override
		public AncillaryParty build() {
			return this;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder toBuilder() {
			AncillaryParty.AncillaryPartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AncillaryParty.AncillaryPartyBuilder builder) {
			ofNullable(getOnBehalfOf()).ifPresent(builder::setOnBehalfOf);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getRole()).ifPresent(builder::setRole);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AncillaryParty _that = getType().cast(o);
		
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!ListEquals.listEquals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AncillaryParty {" +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
	
	//AncillaryParty.AncillaryPartyBuilderImpl
	class AncillaryPartyBuilderImpl implements AncillaryParty.AncillaryPartyBuilder {
	
		protected CounterpartyRoleEnum onBehalfOf;
		protected List<ReferenceWithMetaPartyBuilder> partyReference = new ArrayList<>();
		protected AncillaryRoleEnum role;
	
		public AncillaryPartyBuilderImpl() {
		}
	
		@Override
		public CounterpartyRoleEnum getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public List<? extends ReferenceWithMetaPartyBuilder> getPartyReference() {
			return partyReference;
		}
		
		public ReferenceWithMetaPartyBuilder getOrCreatePartyReference(int _index) {
		
			if (partyReference==null) {
				this.partyReference = new ArrayList<>();
			}
			ReferenceWithMetaPartyBuilder result;
			return getIndex(partyReference, _index, () -> {
						ReferenceWithMetaPartyBuilder newPartyReference = ReferenceWithMetaParty.builder();
						return newPartyReference;
					});
		}
		
		@Override
		public AncillaryRoleEnum getRole() {
			return role;
		}
		
	
		@Override
		public AncillaryParty.AncillaryPartyBuilder setOnBehalfOf(CounterpartyRoleEnum onBehalfOf) {
			this.onBehalfOf = onBehalfOf==null?null:onBehalfOf;
			return this;
		}
		@Override
		public AncillaryParty.AncillaryPartyBuilder addPartyReference(ReferenceWithMetaParty partyReference) {
			if (partyReference!=null) this.partyReference.add(partyReference.toBuilder());
			return this;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder addPartyReference(ReferenceWithMetaParty partyReference, int _idx) {
			getIndex(this.partyReference, _idx, () -> partyReference.toBuilder());
			return this;
		}
		
			@Override
			public AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(Party partyReference) {
				this.getOrCreatePartyReference(-1).setValue(partyReference.toBuilder());
				return this;
			}
			
			@Override
			public AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(Party partyReference, int _idx) {
				this.getOrCreatePartyReference(_idx).setValue(partyReference.toBuilder());
				return this;
			}
		@Override 
		public AncillaryParty.AncillaryPartyBuilder addPartyReference(List<? extends ReferenceWithMetaParty> partyReferences) {
			if (partyReferences != null) {
				for (ReferenceWithMetaParty toAdd : partyReferences) {
					this.partyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AncillaryParty.AncillaryPartyBuilder setPartyReference(List<? extends ReferenceWithMetaParty> partyReferences) {
			if (partyReferences == null)  {
				this.partyReference = new ArrayList<>();
			}
			else {
				this.partyReference = partyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(List<? extends Party> partyReferences) {
			if (partyReferences != null) {
				for (Party toAdd : partyReferences) {
					this.addPartyReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder setPartyReferenceValue(List<? extends Party> partyReferences) {
			this.partyReference.clear();
			if (partyReferences!=null) {
				partyReferences.forEach(this::addPartyReferenceValue);
			}
			return this;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder setRole(AncillaryRoleEnum role) {
			this.role = role==null?null:role;
			return this;
		}
		
		@Override
		public AncillaryParty build() {
			return new AncillaryParty.AncillaryPartyImpl(this);
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AncillaryParty.AncillaryPartyBuilder prune() {
			partyReference = partyReference.stream().filter(b->b!=null).<ReferenceWithMetaPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOnBehalfOf()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRole()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AncillaryParty.AncillaryPartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AncillaryParty.AncillaryPartyBuilder o = (AncillaryParty.AncillaryPartyBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::getOrCreatePartyReference);
			
			merger.mergeBasic(getOnBehalfOf(), o.getOnBehalfOf(), this::setOnBehalfOf);
			merger.mergeBasic(getRole(), o.getRole(), this::setRole);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AncillaryParty _that = getType().cast(o);
		
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!ListEquals.listEquals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AncillaryPartyBuilder {" +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
}
