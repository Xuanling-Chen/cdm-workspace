package cdm.product.asset;

import cdm.product.asset.meta.GeneralTermsMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 *  A class specifying a set of non-monetary terms for the Credit Derivative Transaction, including the buyer and seller and selected items from the ISDA 2014 Credit Definition article II, such as the reference obligation and related terms. The CDM GeneralTerms class corresponds to the FpML GeneralTerms complex type, except that the effectiveDate and scheduledTerminationDate have been positioned as part of the InterestRatePayout class in the CDM instead of in GeneralTerms.
 * @version ${project.version}
 */
@RosettaClass

public interface GeneralTerms extends RosettaModelObject {
	GeneralTerms build();
	GeneralTerms.GeneralTermsBuilder toBuilder();
	
	/**
	 * This attribute is used for representing information contained in the Additional Terms field of the 2003 Master Credit Derivatives confirm.
	 */
	List<? extends FieldWithMetaString> getAdditionalTerm();
	/**
	 * This attribute contains all the terms relevant to defining the Credit Default Swap Basket.
	 */
	BasketReferenceInformation getBasketReferenceInformation();
	/**
	 * This attribute contains all the terms relevant to defining the Credit DefaultSwap Index.
	 */
	IndexReferenceInformation getIndexReferenceInformation();
	/**
	 * Value of this attribute set to &#39;true&#39; indicates that modified equity delivery is applicable.
	 */
	Boolean getModifiedEquityDelivery();
	/**
	 * This attribute contains all the terms relevant to defining the reference entity and reference obligation(s).
	 */
	ReferenceInformation getReferenceInformation();
	/**
	 * Value of this attribute set to &#39;true&#39; indicates that substitution is applicable.
	 */
	Boolean getSubstitution();
	final static GeneralTermsMeta metaData = new GeneralTermsMeta();
	
	@Override
	default RosettaMetaData<? extends GeneralTerms> metaData() {
		return metaData;
	} 
			
	static GeneralTerms.GeneralTermsBuilder builder() {
		return new GeneralTerms.GeneralTermsBuilderImpl();
	}
	
	default Class<? extends GeneralTerms> getType() {
		return GeneralTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("modifiedEquityDelivery"), Boolean.class, getModifiedEquityDelivery(), this);
		processor.processBasic(path.newSubPath("substitution"), Boolean.class, getSubstitution(), this);
		
		processRosetta(path.newSubPath("additionalTerm"), processor, FieldWithMetaString.class, getAdditionalTerm());
		processRosetta(path.newSubPath("basketReferenceInformation"), processor, BasketReferenceInformation.class, getBasketReferenceInformation());
		processRosetta(path.newSubPath("indexReferenceInformation"), processor, IndexReferenceInformation.class, getIndexReferenceInformation());
		processRosetta(path.newSubPath("referenceInformation"), processor, ReferenceInformation.class, getReferenceInformation());
	}
	
	
	interface GeneralTermsBuilder extends GeneralTerms, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateAdditionalTerm(int _index);
		List<? extends FieldWithMetaStringBuilder> getAdditionalTerm();
		BasketReferenceInformation.BasketReferenceInformationBuilder getOrCreateBasketReferenceInformation();
		BasketReferenceInformation.BasketReferenceInformationBuilder getBasketReferenceInformation();
		IndexReferenceInformation.IndexReferenceInformationBuilder getOrCreateIndexReferenceInformation();
		IndexReferenceInformation.IndexReferenceInformationBuilder getIndexReferenceInformation();
		ReferenceInformation.ReferenceInformationBuilder getOrCreateReferenceInformation();
		ReferenceInformation.ReferenceInformationBuilder getReferenceInformation();
		GeneralTerms.GeneralTermsBuilder addAdditionalTerm(FieldWithMetaString additionalTerm);
		GeneralTerms.GeneralTermsBuilder addAdditionalTerm(FieldWithMetaString additionalTerm, int _idx);
		GeneralTerms.GeneralTermsBuilder addAdditionalTermValue(String additionalTerm);
		GeneralTerms.GeneralTermsBuilder addAdditionalTermValue(String additionalTerm, int _idx);
		GeneralTerms.GeneralTermsBuilder addAdditionalTerm(List<? extends FieldWithMetaString> additionalTerm);
		GeneralTerms.GeneralTermsBuilder setAdditionalTerm(List<? extends FieldWithMetaString> additionalTerm);
		GeneralTerms.GeneralTermsBuilder addAdditionalTermValue(List<? extends String> additionalTerm);
		GeneralTerms.GeneralTermsBuilder setAdditionalTermValue(List<? extends String> additionalTerm);
		GeneralTerms.GeneralTermsBuilder setBasketReferenceInformation(BasketReferenceInformation basketReferenceInformation);
		GeneralTerms.GeneralTermsBuilder setIndexReferenceInformation(IndexReferenceInformation indexReferenceInformation);
		GeneralTerms.GeneralTermsBuilder setModifiedEquityDelivery(Boolean modifiedEquityDelivery);
		GeneralTerms.GeneralTermsBuilder setReferenceInformation(ReferenceInformation referenceInformation);
		GeneralTerms.GeneralTermsBuilder setSubstitution(Boolean substitution);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("modifiedEquityDelivery"), Boolean.class, getModifiedEquityDelivery(), this);
			processor.processBasic(path.newSubPath("substitution"), Boolean.class, getSubstitution(), this);
			
			processRosetta(path.newSubPath("additionalTerm"), processor, FieldWithMetaStringBuilder.class, getAdditionalTerm());
			processRosetta(path.newSubPath("basketReferenceInformation"), processor, BasketReferenceInformation.BasketReferenceInformationBuilder.class, getBasketReferenceInformation());
			processRosetta(path.newSubPath("indexReferenceInformation"), processor, IndexReferenceInformation.IndexReferenceInformationBuilder.class, getIndexReferenceInformation());
			processRosetta(path.newSubPath("referenceInformation"), processor, ReferenceInformation.ReferenceInformationBuilder.class, getReferenceInformation());
		}
		
	}
	
	//GeneralTerms.GeneralTermsImpl
	class GeneralTermsImpl implements GeneralTerms {
		private final List<? extends FieldWithMetaString> additionalTerm;
		private final BasketReferenceInformation basketReferenceInformation;
		private final IndexReferenceInformation indexReferenceInformation;
		private final Boolean modifiedEquityDelivery;
		private final ReferenceInformation referenceInformation;
		private final Boolean substitution;
		
		protected GeneralTermsImpl(GeneralTerms.GeneralTermsBuilder builder) {
			this.additionalTerm = ofNullable(builder.getAdditionalTerm()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.basketReferenceInformation = ofNullable(builder.getBasketReferenceInformation()).map(f->f.build()).orElse(null);
			this.indexReferenceInformation = ofNullable(builder.getIndexReferenceInformation()).map(f->f.build()).orElse(null);
			this.modifiedEquityDelivery = builder.getModifiedEquityDelivery();
			this.referenceInformation = ofNullable(builder.getReferenceInformation()).map(f->f.build()).orElse(null);
			this.substitution = builder.getSubstitution();
		}
		
		@Override
		public List<? extends FieldWithMetaString> getAdditionalTerm() {
			return additionalTerm;
		}
		
		@Override
		public BasketReferenceInformation getBasketReferenceInformation() {
			return basketReferenceInformation;
		}
		
		@Override
		public IndexReferenceInformation getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		public Boolean getModifiedEquityDelivery() {
			return modifiedEquityDelivery;
		}
		
		@Override
		public ReferenceInformation getReferenceInformation() {
			return referenceInformation;
		}
		
		@Override
		public Boolean getSubstitution() {
			return substitution;
		}
		
		@Override
		public GeneralTerms build() {
			return this;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder toBuilder() {
			GeneralTerms.GeneralTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GeneralTerms.GeneralTermsBuilder builder) {
			ofNullable(getAdditionalTerm()).ifPresent(builder::setAdditionalTerm);
			ofNullable(getBasketReferenceInformation()).ifPresent(builder::setBasketReferenceInformation);
			ofNullable(getIndexReferenceInformation()).ifPresent(builder::setIndexReferenceInformation);
			ofNullable(getModifiedEquityDelivery()).ifPresent(builder::setModifiedEquityDelivery);
			ofNullable(getReferenceInformation()).ifPresent(builder::setReferenceInformation);
			ofNullable(getSubstitution()).ifPresent(builder::setSubstitution);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(additionalTerm, _that.getAdditionalTerm())) return false;
			if (!Objects.equals(basketReferenceInformation, _that.getBasketReferenceInformation())) return false;
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(modifiedEquityDelivery, _that.getModifiedEquityDelivery())) return false;
			if (!Objects.equals(referenceInformation, _that.getReferenceInformation())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalTerm != null ? additionalTerm.hashCode() : 0);
			_result = 31 * _result + (basketReferenceInformation != null ? basketReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (modifiedEquityDelivery != null ? modifiedEquityDelivery.hashCode() : 0);
			_result = 31 * _result + (referenceInformation != null ? referenceInformation.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralTerms {" +
				"additionalTerm=" + this.additionalTerm + ", " +
				"basketReferenceInformation=" + this.basketReferenceInformation + ", " +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"modifiedEquityDelivery=" + this.modifiedEquityDelivery + ", " +
				"referenceInformation=" + this.referenceInformation + ", " +
				"substitution=" + this.substitution +
			'}';
		}
	}
	
	//GeneralTerms.GeneralTermsBuilderImpl
	class GeneralTermsBuilderImpl implements GeneralTerms.GeneralTermsBuilder {
	
		protected List<FieldWithMetaStringBuilder> additionalTerm = new ArrayList<>();
		protected BasketReferenceInformation.BasketReferenceInformationBuilder basketReferenceInformation;
		protected IndexReferenceInformation.IndexReferenceInformationBuilder indexReferenceInformation;
		protected Boolean modifiedEquityDelivery;
		protected ReferenceInformation.ReferenceInformationBuilder referenceInformation;
		protected Boolean substitution;
	
		public GeneralTermsBuilderImpl() {
		}
	
		@Override
		public List<? extends FieldWithMetaStringBuilder> getAdditionalTerm() {
			return additionalTerm;
		}
		
		public FieldWithMetaStringBuilder getOrCreateAdditionalTerm(int _index) {
		
			if (additionalTerm==null) {
				this.additionalTerm = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(additionalTerm, _index, () -> {
						FieldWithMetaStringBuilder newAdditionalTerm = FieldWithMetaString.builder();
						return newAdditionalTerm;
					});
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder getBasketReferenceInformation() {
			return basketReferenceInformation;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder getOrCreateBasketReferenceInformation() {
			BasketReferenceInformation.BasketReferenceInformationBuilder result;
			if (basketReferenceInformation!=null) {
				result = basketReferenceInformation;
			}
			else {
				result = basketReferenceInformation = BasketReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder getOrCreateIndexReferenceInformation() {
			IndexReferenceInformation.IndexReferenceInformationBuilder result;
			if (indexReferenceInformation!=null) {
				result = indexReferenceInformation;
			}
			else {
				result = indexReferenceInformation = IndexReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getModifiedEquityDelivery() {
			return modifiedEquityDelivery;
		}
		
		@Override
		public ReferenceInformation.ReferenceInformationBuilder getReferenceInformation() {
			return referenceInformation;
		}
		
		@Override
		public ReferenceInformation.ReferenceInformationBuilder getOrCreateReferenceInformation() {
			ReferenceInformation.ReferenceInformationBuilder result;
			if (referenceInformation!=null) {
				result = referenceInformation;
			}
			else {
				result = referenceInformation = ReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getSubstitution() {
			return substitution;
		}
		
	
		@Override
		public GeneralTerms.GeneralTermsBuilder addAdditionalTerm(FieldWithMetaString additionalTerm) {
			if (additionalTerm!=null) this.additionalTerm.add(additionalTerm.toBuilder());
			return this;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder addAdditionalTerm(FieldWithMetaString additionalTerm, int _idx) {
			getIndex(this.additionalTerm, _idx, () -> additionalTerm.toBuilder());
			return this;
		}
		
			@Override
			public GeneralTerms.GeneralTermsBuilder addAdditionalTermValue(String additionalTerm) {
				this.getOrCreateAdditionalTerm(-1).setValue(additionalTerm);
				return this;
			}
			
			@Override
			public GeneralTerms.GeneralTermsBuilder addAdditionalTermValue(String additionalTerm, int _idx) {
				this.getOrCreateAdditionalTerm(_idx).setValue(additionalTerm);
				return this;
			}
		@Override 
		public GeneralTerms.GeneralTermsBuilder addAdditionalTerm(List<? extends FieldWithMetaString> additionalTerms) {
			if (additionalTerms != null) {
				for (FieldWithMetaString toAdd : additionalTerms) {
					this.additionalTerm.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public GeneralTerms.GeneralTermsBuilder setAdditionalTerm(List<? extends FieldWithMetaString> additionalTerms) {
			if (additionalTerms == null)  {
				this.additionalTerm = new ArrayList<>();
			}
			else {
				this.additionalTerm = additionalTerms.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder addAdditionalTermValue(List<? extends String> additionalTerms) {
			if (additionalTerms != null) {
				for (String toAdd : additionalTerms) {
					this.addAdditionalTermValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder setAdditionalTermValue(List<? extends String> additionalTerms) {
			this.additionalTerm.clear();
			if (additionalTerms!=null) {
				additionalTerms.forEach(this::addAdditionalTermValue);
			}
			return this;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder setBasketReferenceInformation(BasketReferenceInformation basketReferenceInformation) {
			this.basketReferenceInformation = basketReferenceInformation==null?null:basketReferenceInformation.toBuilder();
			return this;
		}
		@Override
		public GeneralTerms.GeneralTermsBuilder setIndexReferenceInformation(IndexReferenceInformation indexReferenceInformation) {
			this.indexReferenceInformation = indexReferenceInformation==null?null:indexReferenceInformation.toBuilder();
			return this;
		}
		@Override
		public GeneralTerms.GeneralTermsBuilder setModifiedEquityDelivery(Boolean modifiedEquityDelivery) {
			this.modifiedEquityDelivery = modifiedEquityDelivery==null?null:modifiedEquityDelivery;
			return this;
		}
		@Override
		public GeneralTerms.GeneralTermsBuilder setReferenceInformation(ReferenceInformation referenceInformation) {
			this.referenceInformation = referenceInformation==null?null:referenceInformation.toBuilder();
			return this;
		}
		@Override
		public GeneralTerms.GeneralTermsBuilder setSubstitution(Boolean substitution) {
			this.substitution = substitution==null?null:substitution;
			return this;
		}
		
		@Override
		public GeneralTerms build() {
			return new GeneralTerms.GeneralTermsImpl(this);
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralTerms.GeneralTermsBuilder prune() {
			additionalTerm = additionalTerm.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (basketReferenceInformation!=null && !basketReferenceInformation.prune().hasData()) basketReferenceInformation = null;
			if (indexReferenceInformation!=null && !indexReferenceInformation.prune().hasData()) indexReferenceInformation = null;
			if (referenceInformation!=null && !referenceInformation.prune().hasData()) referenceInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalTerm()!=null && !getAdditionalTerm().isEmpty()) return true;
			if (getBasketReferenceInformation()!=null && getBasketReferenceInformation().hasData()) return true;
			if (getIndexReferenceInformation()!=null && getIndexReferenceInformation().hasData()) return true;
			if (getModifiedEquityDelivery()!=null) return true;
			if (getReferenceInformation()!=null && getReferenceInformation().hasData()) return true;
			if (getSubstitution()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralTerms.GeneralTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GeneralTerms.GeneralTermsBuilder o = (GeneralTerms.GeneralTermsBuilder) other;
			
			merger.mergeRosetta(getAdditionalTerm(), o.getAdditionalTerm(), this::getOrCreateAdditionalTerm);
			merger.mergeRosetta(getBasketReferenceInformation(), o.getBasketReferenceInformation(), this::setBasketReferenceInformation);
			merger.mergeRosetta(getIndexReferenceInformation(), o.getIndexReferenceInformation(), this::setIndexReferenceInformation);
			merger.mergeRosetta(getReferenceInformation(), o.getReferenceInformation(), this::setReferenceInformation);
			
			merger.mergeBasic(getModifiedEquityDelivery(), o.getModifiedEquityDelivery(), this::setModifiedEquityDelivery);
			merger.mergeBasic(getSubstitution(), o.getSubstitution(), this::setSubstitution);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(additionalTerm, _that.getAdditionalTerm())) return false;
			if (!Objects.equals(basketReferenceInformation, _that.getBasketReferenceInformation())) return false;
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(modifiedEquityDelivery, _that.getModifiedEquityDelivery())) return false;
			if (!Objects.equals(referenceInformation, _that.getReferenceInformation())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalTerm != null ? additionalTerm.hashCode() : 0);
			_result = 31 * _result + (basketReferenceInformation != null ? basketReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (modifiedEquityDelivery != null ? modifiedEquityDelivery.hashCode() : 0);
			_result = 31 * _result + (referenceInformation != null ? referenceInformation.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralTermsBuilder {" +
				"additionalTerm=" + this.additionalTerm + ", " +
				"basketReferenceInformation=" + this.basketReferenceInformation + ", " +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"modifiedEquityDelivery=" + this.modifiedEquityDelivery + ", " +
				"referenceInformation=" + this.referenceInformation + ", " +
				"substitution=" + this.substitution +
			'}';
		}
	}
}
