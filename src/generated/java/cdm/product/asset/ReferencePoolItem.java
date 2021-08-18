package cdm.product.asset;

import cdm.product.asset.meta.ReferencePoolItemMeta;
import cdm.product.asset.metafields.ReferenceWithMetaProtectionTerms;
import cdm.product.asset.metafields.ReferenceWithMetaProtectionTerms.ReferenceWithMetaProtectionTermsBuilder;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashSettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder;
import cdm.product.common.settlement.metafields.ReferenceWithMetaPhysicalSettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder;
import cdm.product.template.ConstituentWeight;
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
 * This type contains all the constituent weight and reference information.
 * @version ${project.version}
 */
@RosettaClass

public interface ReferencePoolItem extends RosettaModelObject {
	ReferencePoolItem build();
	ReferencePoolItem.ReferencePoolItemBuilder toBuilder();
	
	/**
	 * Reference to the cash settlement terms applicable to this item.
	 */
	ReferenceWithMetaCashSettlementTerms getCashSettlementTermsReference();
	/**
	 * Describes the weight of each of the constituents within the basket. If not provided, it is assumed to be equal weighted.
	 */
	ConstituentWeight getConstituentWeight();
	/**
	 * Reference to the physical settlement terms applicable to this item.
	 */
	ReferenceWithMetaPhysicalSettlementTerms getPhysicalSettlementTermsReference();
	/**
	 * Reference to the documentation terms applicable to this item.
	 */
	ReferenceWithMetaProtectionTerms getProtectionTermsReference();
	/**
	 */
	ReferencePair getReferencePair();
	final static ReferencePoolItemMeta metaData = new ReferencePoolItemMeta();
	
	@Override
	default RosettaMetaData<? extends ReferencePoolItem> metaData() {
		return metaData;
	} 
			
	static ReferencePoolItem.ReferencePoolItemBuilder builder() {
		return new ReferencePoolItem.ReferencePoolItemBuilderImpl();
	}
	
	default Class<? extends ReferencePoolItem> getType() {
		return ReferencePoolItem.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("cashSettlementTermsReference"), processor, ReferenceWithMetaCashSettlementTerms.class, getCashSettlementTermsReference());
		processRosetta(path.newSubPath("constituentWeight"), processor, ConstituentWeight.class, getConstituentWeight());
		processRosetta(path.newSubPath("physicalSettlementTermsReference"), processor, ReferenceWithMetaPhysicalSettlementTerms.class, getPhysicalSettlementTermsReference());
		processRosetta(path.newSubPath("protectionTermsReference"), processor, ReferenceWithMetaProtectionTerms.class, getProtectionTermsReference());
		processRosetta(path.newSubPath("referencePair"), processor, ReferencePair.class, getReferencePair());
	}
	
	
	interface ReferencePoolItemBuilder extends ReferencePoolItem, RosettaModelObjectBuilder {
		ReferenceWithMetaCashSettlementTermsBuilder getOrCreateCashSettlementTermsReference();
		ReferenceWithMetaCashSettlementTermsBuilder getCashSettlementTermsReference();
		ConstituentWeight.ConstituentWeightBuilder getOrCreateConstituentWeight();
		ConstituentWeight.ConstituentWeightBuilder getConstituentWeight();
		ReferenceWithMetaPhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTermsReference();
		ReferenceWithMetaPhysicalSettlementTermsBuilder getPhysicalSettlementTermsReference();
		ReferenceWithMetaProtectionTermsBuilder getOrCreateProtectionTermsReference();
		ReferenceWithMetaProtectionTermsBuilder getProtectionTermsReference();
		ReferencePair.ReferencePairBuilder getOrCreateReferencePair();
		ReferencePair.ReferencePairBuilder getReferencePair();
		ReferencePoolItem.ReferencePoolItemBuilder setCashSettlementTermsReference(ReferenceWithMetaCashSettlementTerms cashSettlementTermsReference);
		ReferencePoolItem.ReferencePoolItemBuilder setCashSettlementTermsReferenceValue(CashSettlementTerms cashSettlementTermsReference);
		ReferencePoolItem.ReferencePoolItemBuilder setConstituentWeight(ConstituentWeight constituentWeight);
		ReferencePoolItem.ReferencePoolItemBuilder setPhysicalSettlementTermsReference(ReferenceWithMetaPhysicalSettlementTerms physicalSettlementTermsReference);
		ReferencePoolItem.ReferencePoolItemBuilder setPhysicalSettlementTermsReferenceValue(PhysicalSettlementTerms physicalSettlementTermsReference);
		ReferencePoolItem.ReferencePoolItemBuilder setProtectionTermsReference(ReferenceWithMetaProtectionTerms protectionTermsReference);
		ReferencePoolItem.ReferencePoolItemBuilder setProtectionTermsReferenceValue(ProtectionTerms protectionTermsReference);
		ReferencePoolItem.ReferencePoolItemBuilder setReferencePair(ReferencePair referencePair);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("cashSettlementTermsReference"), processor, ReferenceWithMetaCashSettlementTermsBuilder.class, getCashSettlementTermsReference());
			processRosetta(path.newSubPath("constituentWeight"), processor, ConstituentWeight.ConstituentWeightBuilder.class, getConstituentWeight());
			processRosetta(path.newSubPath("physicalSettlementTermsReference"), processor, ReferenceWithMetaPhysicalSettlementTermsBuilder.class, getPhysicalSettlementTermsReference());
			processRosetta(path.newSubPath("protectionTermsReference"), processor, ReferenceWithMetaProtectionTermsBuilder.class, getProtectionTermsReference());
			processRosetta(path.newSubPath("referencePair"), processor, ReferencePair.ReferencePairBuilder.class, getReferencePair());
		}
		
	}
	
	//ReferencePoolItem.ReferencePoolItemImpl
	class ReferencePoolItemImpl implements ReferencePoolItem {
		private final ReferenceWithMetaCashSettlementTerms cashSettlementTermsReference;
		private final ConstituentWeight constituentWeight;
		private final ReferenceWithMetaPhysicalSettlementTerms physicalSettlementTermsReference;
		private final ReferenceWithMetaProtectionTerms protectionTermsReference;
		private final ReferencePair referencePair;
		
		protected ReferencePoolItemImpl(ReferencePoolItem.ReferencePoolItemBuilder builder) {
			this.cashSettlementTermsReference = ofNullable(builder.getCashSettlementTermsReference()).map(f->f.build()).orElse(null);
			this.constituentWeight = ofNullable(builder.getConstituentWeight()).map(f->f.build()).orElse(null);
			this.physicalSettlementTermsReference = ofNullable(builder.getPhysicalSettlementTermsReference()).map(f->f.build()).orElse(null);
			this.protectionTermsReference = ofNullable(builder.getProtectionTermsReference()).map(f->f.build()).orElse(null);
			this.referencePair = ofNullable(builder.getReferencePair()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaCashSettlementTerms getCashSettlementTermsReference() {
			return cashSettlementTermsReference;
		}
		
		@Override
		public ConstituentWeight getConstituentWeight() {
			return constituentWeight;
		}
		
		@Override
		public ReferenceWithMetaPhysicalSettlementTerms getPhysicalSettlementTermsReference() {
			return physicalSettlementTermsReference;
		}
		
		@Override
		public ReferenceWithMetaProtectionTerms getProtectionTermsReference() {
			return protectionTermsReference;
		}
		
		@Override
		public ReferencePair getReferencePair() {
			return referencePair;
		}
		
		@Override
		public ReferencePoolItem build() {
			return this;
		}
		
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder toBuilder() {
			ReferencePoolItem.ReferencePoolItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferencePoolItem.ReferencePoolItemBuilder builder) {
			ofNullable(getCashSettlementTermsReference()).ifPresent(builder::setCashSettlementTermsReference);
			ofNullable(getConstituentWeight()).ifPresent(builder::setConstituentWeight);
			ofNullable(getPhysicalSettlementTermsReference()).ifPresent(builder::setPhysicalSettlementTermsReference);
			ofNullable(getProtectionTermsReference()).ifPresent(builder::setProtectionTermsReference);
			ofNullable(getReferencePair()).ifPresent(builder::setReferencePair);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferencePoolItem _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementTermsReference, _that.getCashSettlementTermsReference())) return false;
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			if (!Objects.equals(physicalSettlementTermsReference, _that.getPhysicalSettlementTermsReference())) return false;
			if (!Objects.equals(protectionTermsReference, _that.getProtectionTermsReference())) return false;
			if (!Objects.equals(referencePair, _that.getReferencePair())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementTermsReference != null ? cashSettlementTermsReference.hashCode() : 0);
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTermsReference != null ? physicalSettlementTermsReference.hashCode() : 0);
			_result = 31 * _result + (protectionTermsReference != null ? protectionTermsReference.hashCode() : 0);
			_result = 31 * _result + (referencePair != null ? referencePair.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferencePoolItem {" +
				"cashSettlementTermsReference=" + this.cashSettlementTermsReference + ", " +
				"constituentWeight=" + this.constituentWeight + ", " +
				"physicalSettlementTermsReference=" + this.physicalSettlementTermsReference + ", " +
				"protectionTermsReference=" + this.protectionTermsReference + ", " +
				"referencePair=" + this.referencePair +
			'}';
		}
	}
	
	//ReferencePoolItem.ReferencePoolItemBuilderImpl
	class ReferencePoolItemBuilderImpl implements ReferencePoolItem.ReferencePoolItemBuilder {
	
		protected ReferenceWithMetaCashSettlementTermsBuilder cashSettlementTermsReference;
		protected ConstituentWeight.ConstituentWeightBuilder constituentWeight;
		protected ReferenceWithMetaPhysicalSettlementTermsBuilder physicalSettlementTermsReference;
		protected ReferenceWithMetaProtectionTermsBuilder protectionTermsReference;
		protected ReferencePair.ReferencePairBuilder referencePair;
	
		public ReferencePoolItemBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaCashSettlementTermsBuilder getCashSettlementTermsReference() {
			return cashSettlementTermsReference;
		}
		
		@Override
		public ReferenceWithMetaCashSettlementTermsBuilder getOrCreateCashSettlementTermsReference() {
			ReferenceWithMetaCashSettlementTermsBuilder result;
			if (cashSettlementTermsReference!=null) {
				result = cashSettlementTermsReference;
			}
			else {
				result = cashSettlementTermsReference = ReferenceWithMetaCashSettlementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public ConstituentWeight.ConstituentWeightBuilder getConstituentWeight() {
			return constituentWeight;
		}
		
		@Override
		public ConstituentWeight.ConstituentWeightBuilder getOrCreateConstituentWeight() {
			ConstituentWeight.ConstituentWeightBuilder result;
			if (constituentWeight!=null) {
				result = constituentWeight;
			}
			else {
				result = constituentWeight = ConstituentWeight.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaPhysicalSettlementTermsBuilder getPhysicalSettlementTermsReference() {
			return physicalSettlementTermsReference;
		}
		
		@Override
		public ReferenceWithMetaPhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTermsReference() {
			ReferenceWithMetaPhysicalSettlementTermsBuilder result;
			if (physicalSettlementTermsReference!=null) {
				result = physicalSettlementTermsReference;
			}
			else {
				result = physicalSettlementTermsReference = ReferenceWithMetaPhysicalSettlementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaProtectionTermsBuilder getProtectionTermsReference() {
			return protectionTermsReference;
		}
		
		@Override
		public ReferenceWithMetaProtectionTermsBuilder getOrCreateProtectionTermsReference() {
			ReferenceWithMetaProtectionTermsBuilder result;
			if (protectionTermsReference!=null) {
				result = protectionTermsReference;
			}
			else {
				result = protectionTermsReference = ReferenceWithMetaProtectionTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferencePair.ReferencePairBuilder getReferencePair() {
			return referencePair;
		}
		
		@Override
		public ReferencePair.ReferencePairBuilder getOrCreateReferencePair() {
			ReferencePair.ReferencePairBuilder result;
			if (referencePair!=null) {
				result = referencePair;
			}
			else {
				result = referencePair = ReferencePair.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder setCashSettlementTermsReference(ReferenceWithMetaCashSettlementTerms cashSettlementTermsReference) {
			this.cashSettlementTermsReference = cashSettlementTermsReference==null?null:cashSettlementTermsReference.toBuilder();
			return this;
		}
		
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder setCashSettlementTermsReferenceValue(CashSettlementTerms cashSettlementTermsReference) {
			this.getOrCreateCashSettlementTermsReference().setValue(cashSettlementTermsReference);
			return this;
		}
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder setConstituentWeight(ConstituentWeight constituentWeight) {
			this.constituentWeight = constituentWeight==null?null:constituentWeight.toBuilder();
			return this;
		}
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder setPhysicalSettlementTermsReference(ReferenceWithMetaPhysicalSettlementTerms physicalSettlementTermsReference) {
			this.physicalSettlementTermsReference = physicalSettlementTermsReference==null?null:physicalSettlementTermsReference.toBuilder();
			return this;
		}
		
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder setPhysicalSettlementTermsReferenceValue(PhysicalSettlementTerms physicalSettlementTermsReference) {
			this.getOrCreatePhysicalSettlementTermsReference().setValue(physicalSettlementTermsReference);
			return this;
		}
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder setProtectionTermsReference(ReferenceWithMetaProtectionTerms protectionTermsReference) {
			this.protectionTermsReference = protectionTermsReference==null?null:protectionTermsReference.toBuilder();
			return this;
		}
		
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder setProtectionTermsReferenceValue(ProtectionTerms protectionTermsReference) {
			this.getOrCreateProtectionTermsReference().setValue(protectionTermsReference);
			return this;
		}
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder setReferencePair(ReferencePair referencePair) {
			this.referencePair = referencePair==null?null:referencePair.toBuilder();
			return this;
		}
		
		@Override
		public ReferencePoolItem build() {
			return new ReferencePoolItem.ReferencePoolItemImpl(this);
		}
		
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder prune() {
			if (cashSettlementTermsReference!=null && !cashSettlementTermsReference.prune().hasData()) cashSettlementTermsReference = null;
			if (constituentWeight!=null && !constituentWeight.prune().hasData()) constituentWeight = null;
			if (physicalSettlementTermsReference!=null && !physicalSettlementTermsReference.prune().hasData()) physicalSettlementTermsReference = null;
			if (protectionTermsReference!=null && !protectionTermsReference.prune().hasData()) protectionTermsReference = null;
			if (referencePair!=null && !referencePair.prune().hasData()) referencePair = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementTermsReference()!=null && getCashSettlementTermsReference().hasData()) return true;
			if (getConstituentWeight()!=null && getConstituentWeight().hasData()) return true;
			if (getPhysicalSettlementTermsReference()!=null && getPhysicalSettlementTermsReference().hasData()) return true;
			if (getProtectionTermsReference()!=null && getProtectionTermsReference().hasData()) return true;
			if (getReferencePair()!=null && getReferencePair().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferencePoolItem.ReferencePoolItemBuilder o = (ReferencePoolItem.ReferencePoolItemBuilder) other;
			
			merger.mergeRosetta(getCashSettlementTermsReference(), o.getCashSettlementTermsReference(), this::setCashSettlementTermsReference);
			merger.mergeRosetta(getConstituentWeight(), o.getConstituentWeight(), this::setConstituentWeight);
			merger.mergeRosetta(getPhysicalSettlementTermsReference(), o.getPhysicalSettlementTermsReference(), this::setPhysicalSettlementTermsReference);
			merger.mergeRosetta(getProtectionTermsReference(), o.getProtectionTermsReference(), this::setProtectionTermsReference);
			merger.mergeRosetta(getReferencePair(), o.getReferencePair(), this::setReferencePair);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferencePoolItem _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementTermsReference, _that.getCashSettlementTermsReference())) return false;
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			if (!Objects.equals(physicalSettlementTermsReference, _that.getPhysicalSettlementTermsReference())) return false;
			if (!Objects.equals(protectionTermsReference, _that.getProtectionTermsReference())) return false;
			if (!Objects.equals(referencePair, _that.getReferencePair())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementTermsReference != null ? cashSettlementTermsReference.hashCode() : 0);
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTermsReference != null ? physicalSettlementTermsReference.hashCode() : 0);
			_result = 31 * _result + (protectionTermsReference != null ? protectionTermsReference.hashCode() : 0);
			_result = 31 * _result + (referencePair != null ? referencePair.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferencePoolItemBuilder {" +
				"cashSettlementTermsReference=" + this.cashSettlementTermsReference + ", " +
				"constituentWeight=" + this.constituentWeight + ", " +
				"physicalSettlementTermsReference=" + this.physicalSettlementTermsReference + ", " +
				"protectionTermsReference=" + this.protectionTermsReference + ", " +
				"referencePair=" + this.referencePair +
			'}';
		}
	}
}
