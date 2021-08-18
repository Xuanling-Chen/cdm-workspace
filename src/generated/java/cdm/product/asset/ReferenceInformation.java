package cdm.product.asset;

import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.Price;
import cdm.product.asset.meta.ReferenceInformationMeta;
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
 * A class specifying the Credit Default Swap Reference Information.
 * @version ${project.version}
 */
@RosettaClass

public interface ReferenceInformation extends RosettaModelObject {
	ReferenceInformation build();
	ReferenceInformation.ReferenceInformationBuilder toBuilder();
	
	/**
	 * Indicates whether an obligation of the Reference Entity, guaranteed by the Reference Entity on behalf of a non-Affiliate, is to be considered an Obligation for the purpose of the transaction. It will be considered an obligation if allGuarantees is applicable (true) and not if allGuarantees is inapplicable (false). ISDA 2003 Term: All Guarantees.
	 */
	Boolean getAllGuarantees();
	/**
	 * Used to indicate that there is no Reference Obligation associated with this Credit Default Swap and that there will never be one.
	 */
	Boolean getNoReferenceObligation();
	/**
	 * The corporate or sovereign entity which is subject to the swap transaction and any successor that assumes all or substantially all of its contractual and other obligations. Reference Entities cannot be senior or subordinated. It is the obligations of the Reference Entities that can be senior or subordinated. ISDA 2014 Credit definitions article II section 2.1: `Reference Entity` means the entity specified as such in the related Confirmation.
	 */
	LegalEntity getReferenceEntity();
	/**
	 * The Reference Obligation is a financial instrument that is either issued or guaranteed by the reference entity. It serves to clarify the precise reference entity protection is being offered upon, and its legal position with regard to other related firms (parents/subsidiaries). Furthermore the Reference Obligation is ALWAYS deliverable and establishes the Pari Passu ranking (as the deliverable bonds must rank equal to the reference obligation). ISDA 2003 Term: Reference Obligation.
	 */
	List<? extends ReferenceObligation> getReferenceObligation();
	/**
	 * Applicable to the transactions on mortgage-backed security, which can make use of a reference policy. Presence of the element with value set to &#39;true&#39; indicates that the reference policy is applicable; absence implies that it is not.
	 */
	Boolean getReferencePolicy();
	/**
	 * Used to determine (a) for physically settled trades, the Physical Settlement Amount, which equals the Floating Rate Payer Calculation Amount times the Reference Price and (b) for cash settled trades, the Cash Settlement Amount, which equals the greater of (i) the difference between the Reference Price and the Final Price and (ii) zero. ISDA 2003 Term: Reference Price.
	 */
	Price getReferencePrice();
	/**
	 * With respect to any day, the list of Syndicated Secured Obligations of the Designated Priority of the Reference Entity published by Markit Group Limited or any successor thereto appointed by the Specified Dealers (the &#39;Secured List Publisher&#39;) on or most recently before such day, which list is currently available at [http://www.markit.com]. ISDA 2003 Term: Relevant Secured List.
	 */
	Boolean getSecuredList();
	/**
	 * Used to indicate that the Reference obligation associated with the Credit Default Swap is currently not known. This is not valid for Legal Confirmation purposes, but is valid for earlier stages in the trade life cycle (e.g. Broker Confirmation).
	 */
	Boolean getUnknownReferenceObligation();
	final static ReferenceInformationMeta metaData = new ReferenceInformationMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceInformation> metaData() {
		return metaData;
	} 
			
	static ReferenceInformation.ReferenceInformationBuilder builder() {
		return new ReferenceInformation.ReferenceInformationBuilderImpl();
	}
	
	default Class<? extends ReferenceInformation> getType() {
		return ReferenceInformation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("allGuarantees"), Boolean.class, getAllGuarantees(), this);
		processor.processBasic(path.newSubPath("noReferenceObligation"), Boolean.class, getNoReferenceObligation(), this);
		processor.processBasic(path.newSubPath("referencePolicy"), Boolean.class, getReferencePolicy(), this);
		processor.processBasic(path.newSubPath("securedList"), Boolean.class, getSecuredList(), this);
		processor.processBasic(path.newSubPath("unknownReferenceObligation"), Boolean.class, getUnknownReferenceObligation(), this);
		
		processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.class, getReferenceEntity());
		processRosetta(path.newSubPath("referenceObligation"), processor, ReferenceObligation.class, getReferenceObligation());
		processRosetta(path.newSubPath("referencePrice"), processor, Price.class, getReferencePrice());
	}
	
	
	interface ReferenceInformationBuilder extends ReferenceInformation, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity();
		LegalEntity.LegalEntityBuilder getReferenceEntity();
		ReferenceObligation.ReferenceObligationBuilder getOrCreateReferenceObligation(int _index);
		List<? extends ReferenceObligation.ReferenceObligationBuilder> getReferenceObligation();
		Price.PriceBuilder getOrCreateReferencePrice();
		Price.PriceBuilder getReferencePrice();
		ReferenceInformation.ReferenceInformationBuilder setAllGuarantees(Boolean allGuarantees);
		ReferenceInformation.ReferenceInformationBuilder setNoReferenceObligation(Boolean noReferenceObligation);
		ReferenceInformation.ReferenceInformationBuilder setReferenceEntity(LegalEntity referenceEntity);
		ReferenceInformation.ReferenceInformationBuilder addReferenceObligation(ReferenceObligation referenceObligation);
		ReferenceInformation.ReferenceInformationBuilder addReferenceObligation(ReferenceObligation referenceObligation, int _idx);
		ReferenceInformation.ReferenceInformationBuilder addReferenceObligation(List<? extends ReferenceObligation> referenceObligation);
		ReferenceInformation.ReferenceInformationBuilder setReferenceObligation(List<? extends ReferenceObligation> referenceObligation);
		ReferenceInformation.ReferenceInformationBuilder setReferencePolicy(Boolean referencePolicy);
		ReferenceInformation.ReferenceInformationBuilder setReferencePrice(Price referencePrice);
		ReferenceInformation.ReferenceInformationBuilder setSecuredList(Boolean securedList);
		ReferenceInformation.ReferenceInformationBuilder setUnknownReferenceObligation(Boolean unknownReferenceObligation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("allGuarantees"), Boolean.class, getAllGuarantees(), this);
			processor.processBasic(path.newSubPath("noReferenceObligation"), Boolean.class, getNoReferenceObligation(), this);
			processor.processBasic(path.newSubPath("referencePolicy"), Boolean.class, getReferencePolicy(), this);
			processor.processBasic(path.newSubPath("securedList"), Boolean.class, getSecuredList(), this);
			processor.processBasic(path.newSubPath("unknownReferenceObligation"), Boolean.class, getUnknownReferenceObligation(), this);
			
			processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getReferenceEntity());
			processRosetta(path.newSubPath("referenceObligation"), processor, ReferenceObligation.ReferenceObligationBuilder.class, getReferenceObligation());
			processRosetta(path.newSubPath("referencePrice"), processor, Price.PriceBuilder.class, getReferencePrice());
		}
		
	}
	
	//ReferenceInformation.ReferenceInformationImpl
	class ReferenceInformationImpl implements ReferenceInformation {
		private final Boolean allGuarantees;
		private final Boolean noReferenceObligation;
		private final LegalEntity referenceEntity;
		private final List<? extends ReferenceObligation> referenceObligation;
		private final Boolean referencePolicy;
		private final Price referencePrice;
		private final Boolean securedList;
		private final Boolean unknownReferenceObligation;
		
		protected ReferenceInformationImpl(ReferenceInformation.ReferenceInformationBuilder builder) {
			this.allGuarantees = builder.getAllGuarantees();
			this.noReferenceObligation = builder.getNoReferenceObligation();
			this.referenceEntity = ofNullable(builder.getReferenceEntity()).map(f->f.build()).orElse(null);
			this.referenceObligation = ofNullable(builder.getReferenceObligation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.referencePolicy = builder.getReferencePolicy();
			this.referencePrice = ofNullable(builder.getReferencePrice()).map(f->f.build()).orElse(null);
			this.securedList = builder.getSecuredList();
			this.unknownReferenceObligation = builder.getUnknownReferenceObligation();
		}
		
		@Override
		public Boolean getAllGuarantees() {
			return allGuarantees;
		}
		
		@Override
		public Boolean getNoReferenceObligation() {
			return noReferenceObligation;
		}
		
		@Override
		public LegalEntity getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		public List<? extends ReferenceObligation> getReferenceObligation() {
			return referenceObligation;
		}
		
		@Override
		public Boolean getReferencePolicy() {
			return referencePolicy;
		}
		
		@Override
		public Price getReferencePrice() {
			return referencePrice;
		}
		
		@Override
		public Boolean getSecuredList() {
			return securedList;
		}
		
		@Override
		public Boolean getUnknownReferenceObligation() {
			return unknownReferenceObligation;
		}
		
		@Override
		public ReferenceInformation build() {
			return this;
		}
		
		@Override
		public ReferenceInformation.ReferenceInformationBuilder toBuilder() {
			ReferenceInformation.ReferenceInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceInformation.ReferenceInformationBuilder builder) {
			ofNullable(getAllGuarantees()).ifPresent(builder::setAllGuarantees);
			ofNullable(getNoReferenceObligation()).ifPresent(builder::setNoReferenceObligation);
			ofNullable(getReferenceEntity()).ifPresent(builder::setReferenceEntity);
			ofNullable(getReferenceObligation()).ifPresent(builder::setReferenceObligation);
			ofNullable(getReferencePolicy()).ifPresent(builder::setReferencePolicy);
			ofNullable(getReferencePrice()).ifPresent(builder::setReferencePrice);
			ofNullable(getSecuredList()).ifPresent(builder::setSecuredList);
			ofNullable(getUnknownReferenceObligation()).ifPresent(builder::setUnknownReferenceObligation);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(allGuarantees, _that.getAllGuarantees())) return false;
			if (!Objects.equals(noReferenceObligation, _that.getNoReferenceObligation())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!ListEquals.listEquals(referenceObligation, _that.getReferenceObligation())) return false;
			if (!Objects.equals(referencePolicy, _that.getReferencePolicy())) return false;
			if (!Objects.equals(referencePrice, _that.getReferencePrice())) return false;
			if (!Objects.equals(securedList, _that.getSecuredList())) return false;
			if (!Objects.equals(unknownReferenceObligation, _that.getUnknownReferenceObligation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allGuarantees != null ? allGuarantees.hashCode() : 0);
			_result = 31 * _result + (noReferenceObligation != null ? noReferenceObligation.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (referenceObligation != null ? referenceObligation.hashCode() : 0);
			_result = 31 * _result + (referencePolicy != null ? referencePolicy.hashCode() : 0);
			_result = 31 * _result + (referencePrice != null ? referencePrice.hashCode() : 0);
			_result = 31 * _result + (securedList != null ? securedList.hashCode() : 0);
			_result = 31 * _result + (unknownReferenceObligation != null ? unknownReferenceObligation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceInformation {" +
				"allGuarantees=" + this.allGuarantees + ", " +
				"noReferenceObligation=" + this.noReferenceObligation + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"referenceObligation=" + this.referenceObligation + ", " +
				"referencePolicy=" + this.referencePolicy + ", " +
				"referencePrice=" + this.referencePrice + ", " +
				"securedList=" + this.securedList + ", " +
				"unknownReferenceObligation=" + this.unknownReferenceObligation +
			'}';
		}
	}
	
	//ReferenceInformation.ReferenceInformationBuilderImpl
	class ReferenceInformationBuilderImpl implements ReferenceInformation.ReferenceInformationBuilder {
	
		protected Boolean allGuarantees;
		protected Boolean noReferenceObligation;
		protected LegalEntity.LegalEntityBuilder referenceEntity;
		protected List<ReferenceObligation.ReferenceObligationBuilder> referenceObligation = new ArrayList<>();
		protected Boolean referencePolicy;
		protected Price.PriceBuilder referencePrice;
		protected Boolean securedList;
		protected Boolean unknownReferenceObligation;
	
		public ReferenceInformationBuilderImpl() {
		}
	
		@Override
		public Boolean getAllGuarantees() {
			return allGuarantees;
		}
		
		@Override
		public Boolean getNoReferenceObligation() {
			return noReferenceObligation;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity() {
			LegalEntity.LegalEntityBuilder result;
			if (referenceEntity!=null) {
				result = referenceEntity;
			}
			else {
				result = referenceEntity = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends ReferenceObligation.ReferenceObligationBuilder> getReferenceObligation() {
			return referenceObligation;
		}
		
		public ReferenceObligation.ReferenceObligationBuilder getOrCreateReferenceObligation(int _index) {
		
			if (referenceObligation==null) {
				this.referenceObligation = new ArrayList<>();
			}
			ReferenceObligation.ReferenceObligationBuilder result;
			return getIndex(referenceObligation, _index, () -> {
						ReferenceObligation.ReferenceObligationBuilder newReferenceObligation = ReferenceObligation.builder();
						return newReferenceObligation;
					});
		}
		
		@Override
		public Boolean getReferencePolicy() {
			return referencePolicy;
		}
		
		@Override
		public Price.PriceBuilder getReferencePrice() {
			return referencePrice;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateReferencePrice() {
			Price.PriceBuilder result;
			if (referencePrice!=null) {
				result = referencePrice;
			}
			else {
				result = referencePrice = Price.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getSecuredList() {
			return securedList;
		}
		
		@Override
		public Boolean getUnknownReferenceObligation() {
			return unknownReferenceObligation;
		}
		
	
		@Override
		public ReferenceInformation.ReferenceInformationBuilder setAllGuarantees(Boolean allGuarantees) {
			this.allGuarantees = allGuarantees==null?null:allGuarantees;
			return this;
		}
		@Override
		public ReferenceInformation.ReferenceInformationBuilder setNoReferenceObligation(Boolean noReferenceObligation) {
			this.noReferenceObligation = noReferenceObligation==null?null:noReferenceObligation;
			return this;
		}
		@Override
		public ReferenceInformation.ReferenceInformationBuilder setReferenceEntity(LegalEntity referenceEntity) {
			this.referenceEntity = referenceEntity==null?null:referenceEntity.toBuilder();
			return this;
		}
		@Override
		public ReferenceInformation.ReferenceInformationBuilder addReferenceObligation(ReferenceObligation referenceObligation) {
			if (referenceObligation!=null) this.referenceObligation.add(referenceObligation.toBuilder());
			return this;
		}
		
		@Override
		public ReferenceInformation.ReferenceInformationBuilder addReferenceObligation(ReferenceObligation referenceObligation, int _idx) {
			getIndex(this.referenceObligation, _idx, () -> referenceObligation.toBuilder());
			return this;
		}
		@Override 
		public ReferenceInformation.ReferenceInformationBuilder addReferenceObligation(List<? extends ReferenceObligation> referenceObligations) {
			if (referenceObligations != null) {
				for (ReferenceObligation toAdd : referenceObligations) {
					this.referenceObligation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReferenceInformation.ReferenceInformationBuilder setReferenceObligation(List<? extends ReferenceObligation> referenceObligations) {
			if (referenceObligations == null)  {
				this.referenceObligation = new ArrayList<>();
			}
			else {
				this.referenceObligation = referenceObligations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ReferenceInformation.ReferenceInformationBuilder setReferencePolicy(Boolean referencePolicy) {
			this.referencePolicy = referencePolicy==null?null:referencePolicy;
			return this;
		}
		@Override
		public ReferenceInformation.ReferenceInformationBuilder setReferencePrice(Price referencePrice) {
			this.referencePrice = referencePrice==null?null:referencePrice.toBuilder();
			return this;
		}
		@Override
		public ReferenceInformation.ReferenceInformationBuilder setSecuredList(Boolean securedList) {
			this.securedList = securedList==null?null:securedList;
			return this;
		}
		@Override
		public ReferenceInformation.ReferenceInformationBuilder setUnknownReferenceObligation(Boolean unknownReferenceObligation) {
			this.unknownReferenceObligation = unknownReferenceObligation==null?null:unknownReferenceObligation;
			return this;
		}
		
		@Override
		public ReferenceInformation build() {
			return new ReferenceInformation.ReferenceInformationImpl(this);
		}
		
		@Override
		public ReferenceInformation.ReferenceInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceInformation.ReferenceInformationBuilder prune() {
			if (referenceEntity!=null && !referenceEntity.prune().hasData()) referenceEntity = null;
			referenceObligation = referenceObligation.stream().filter(b->b!=null).<ReferenceObligation.ReferenceObligationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (referencePrice!=null && !referencePrice.prune().hasData()) referencePrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllGuarantees()!=null) return true;
			if (getNoReferenceObligation()!=null) return true;
			if (getReferenceEntity()!=null && getReferenceEntity().hasData()) return true;
			if (getReferenceObligation()!=null && getReferenceObligation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReferencePolicy()!=null) return true;
			if (getReferencePrice()!=null && getReferencePrice().hasData()) return true;
			if (getSecuredList()!=null) return true;
			if (getUnknownReferenceObligation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceInformation.ReferenceInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceInformation.ReferenceInformationBuilder o = (ReferenceInformation.ReferenceInformationBuilder) other;
			
			merger.mergeRosetta(getReferenceEntity(), o.getReferenceEntity(), this::setReferenceEntity);
			merger.mergeRosetta(getReferenceObligation(), o.getReferenceObligation(), this::getOrCreateReferenceObligation);
			merger.mergeRosetta(getReferencePrice(), o.getReferencePrice(), this::setReferencePrice);
			
			merger.mergeBasic(getAllGuarantees(), o.getAllGuarantees(), this::setAllGuarantees);
			merger.mergeBasic(getNoReferenceObligation(), o.getNoReferenceObligation(), this::setNoReferenceObligation);
			merger.mergeBasic(getReferencePolicy(), o.getReferencePolicy(), this::setReferencePolicy);
			merger.mergeBasic(getSecuredList(), o.getSecuredList(), this::setSecuredList);
			merger.mergeBasic(getUnknownReferenceObligation(), o.getUnknownReferenceObligation(), this::setUnknownReferenceObligation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(allGuarantees, _that.getAllGuarantees())) return false;
			if (!Objects.equals(noReferenceObligation, _that.getNoReferenceObligation())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!ListEquals.listEquals(referenceObligation, _that.getReferenceObligation())) return false;
			if (!Objects.equals(referencePolicy, _that.getReferencePolicy())) return false;
			if (!Objects.equals(referencePrice, _that.getReferencePrice())) return false;
			if (!Objects.equals(securedList, _that.getSecuredList())) return false;
			if (!Objects.equals(unknownReferenceObligation, _that.getUnknownReferenceObligation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allGuarantees != null ? allGuarantees.hashCode() : 0);
			_result = 31 * _result + (noReferenceObligation != null ? noReferenceObligation.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (referenceObligation != null ? referenceObligation.hashCode() : 0);
			_result = 31 * _result + (referencePolicy != null ? referencePolicy.hashCode() : 0);
			_result = 31 * _result + (referencePrice != null ? referencePrice.hashCode() : 0);
			_result = 31 * _result + (securedList != null ? securedList.hashCode() : 0);
			_result = 31 * _result + (unknownReferenceObligation != null ? unknownReferenceObligation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceInformationBuilder {" +
				"allGuarantees=" + this.allGuarantees + ", " +
				"noReferenceObligation=" + this.noReferenceObligation + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"referenceObligation=" + this.referenceObligation + ", " +
				"referencePolicy=" + this.referencePolicy + ", " +
				"referencePrice=" + this.referencePrice + ", " +
				"securedList=" + this.securedList + ", " +
				"unknownReferenceObligation=" + this.unknownReferenceObligation +
			'}';
		}
	}
}
