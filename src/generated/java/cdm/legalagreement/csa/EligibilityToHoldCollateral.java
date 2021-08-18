package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.EligibilityToHoldCollateralMeta;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the conditions under which a party and its custodian(s) are entitled to hold collateral. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h)(i): Eligibility to Hold Posted Collateral (VM) Custodians (VM).
 * @version ${project.version}
 */
@RosettaClass

public interface EligibilityToHoldCollateral extends RosettaModelObject {
	EligibilityToHoldCollateral build();
	EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder toBuilder();
	
	/**
	 * The restrictions that might be required by a party from the other party&#39;s custodian agent to hold its posted collateral.
	 */
	CustodianTerms getCustodianTerms();
	/**
	 * The restrictions that might be required by a party from the other party in terms of country(ies) where collateral can be held.
	 */
	List<? extends FieldWithMetaString> getEligibleCountry();
	/**
	 * The condition(s) required by a party from the other party to hold its posted collateral.
	 */
	List<? extends HoldingPostedCollateralEnum> getPartyTerms();
	final static EligibilityToHoldCollateralMeta metaData = new EligibilityToHoldCollateralMeta();
	
	@Override
	default RosettaMetaData<? extends EligibilityToHoldCollateral> metaData() {
		return metaData;
	} 
			
	static EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder builder() {
		return new EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilderImpl();
	}
	
	default Class<? extends EligibilityToHoldCollateral> getType() {
		return EligibilityToHoldCollateral.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("partyTerms"), HoldingPostedCollateralEnum.class, getPartyTerms(), this);
		
		processRosetta(path.newSubPath("custodianTerms"), processor, CustodianTerms.class, getCustodianTerms());
		processRosetta(path.newSubPath("eligibleCountry"), processor, FieldWithMetaString.class, getEligibleCountry());
	}
	
	
	interface EligibilityToHoldCollateralBuilder extends EligibilityToHoldCollateral, RosettaModelObjectBuilder {
		CustodianTerms.CustodianTermsBuilder getOrCreateCustodianTerms();
		CustodianTerms.CustodianTermsBuilder getCustodianTerms();
		FieldWithMetaStringBuilder getOrCreateEligibleCountry(int _index);
		List<? extends FieldWithMetaStringBuilder> getEligibleCountry();
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setCustodianTerms(CustodianTerms custodianTerms);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(FieldWithMetaString eligibleCountry);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(FieldWithMetaString eligibleCountry, int _idx);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(String eligibleCountry);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(String eligibleCountry, int _idx);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(List<? extends FieldWithMetaString> eligibleCountry);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setEligibleCountry(List<? extends FieldWithMetaString> eligibleCountry);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(List<? extends String> eligibleCountry);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setEligibleCountryValue(List<? extends String> eligibleCountry);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(HoldingPostedCollateralEnum partyTerms);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(HoldingPostedCollateralEnum partyTerms, int _idx);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(List<? extends HoldingPostedCollateralEnum> partyTerms);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setPartyTerms(List<? extends HoldingPostedCollateralEnum> partyTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("partyTerms"), HoldingPostedCollateralEnum.class, getPartyTerms(), this);
			
			processRosetta(path.newSubPath("custodianTerms"), processor, CustodianTerms.CustodianTermsBuilder.class, getCustodianTerms());
			processRosetta(path.newSubPath("eligibleCountry"), processor, FieldWithMetaStringBuilder.class, getEligibleCountry());
		}
		
	}
	
	//EligibilityToHoldCollateral.EligibilityToHoldCollateralImpl
	class EligibilityToHoldCollateralImpl implements EligibilityToHoldCollateral {
		private final CustodianTerms custodianTerms;
		private final List<? extends FieldWithMetaString> eligibleCountry;
		private final List<? extends HoldingPostedCollateralEnum> partyTerms;
		
		protected EligibilityToHoldCollateralImpl(EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder builder) {
			this.custodianTerms = ofNullable(builder.getCustodianTerms()).map(f->f.build()).orElse(null);
			this.eligibleCountry = ofNullable(builder.getEligibleCountry()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTerms = ofNullable(builder.getPartyTerms()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		public CustodianTerms getCustodianTerms() {
			return custodianTerms;
		}
		
		@Override
		public List<? extends FieldWithMetaString> getEligibleCountry() {
			return eligibleCountry;
		}
		
		@Override
		public List<? extends HoldingPostedCollateralEnum> getPartyTerms() {
			return partyTerms;
		}
		
		@Override
		public EligibilityToHoldCollateral build() {
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder toBuilder() {
			EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder builder) {
			ofNullable(getCustodianTerms()).ifPresent(builder::setCustodianTerms);
			ofNullable(getEligibleCountry()).ifPresent(builder::setEligibleCountry);
			ofNullable(getPartyTerms()).ifPresent(builder::setPartyTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibilityToHoldCollateral _that = getType().cast(o);
		
			if (!Objects.equals(custodianTerms, _that.getCustodianTerms())) return false;
			if (!ListEquals.listEquals(eligibleCountry, _that.getEligibleCountry())) return false;
			if (!ListEquals.listEquals(partyTerms, _that.getPartyTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (custodianTerms != null ? custodianTerms.hashCode() : 0);
			_result = 31 * _result + (eligibleCountry != null ? eligibleCountry.hashCode() : 0);
			_result = 31 * _result + (partyTerms != null ? partyTerms.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibilityToHoldCollateral {" +
				"custodianTerms=" + this.custodianTerms + ", " +
				"eligibleCountry=" + this.eligibleCountry + ", " +
				"partyTerms=" + this.partyTerms +
			'}';
		}
	}
	
	//EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilderImpl
	class EligibilityToHoldCollateralBuilderImpl implements EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder {
	
		protected CustodianTerms.CustodianTermsBuilder custodianTerms;
		protected List<FieldWithMetaStringBuilder> eligibleCountry = new ArrayList<>();
		protected List<HoldingPostedCollateralEnum> partyTerms = new ArrayList<>();
	
		public EligibilityToHoldCollateralBuilderImpl() {
		}
	
		@Override
		public CustodianTerms.CustodianTermsBuilder getCustodianTerms() {
			return custodianTerms;
		}
		
		@Override
		public CustodianTerms.CustodianTermsBuilder getOrCreateCustodianTerms() {
			CustodianTerms.CustodianTermsBuilder result;
			if (custodianTerms!=null) {
				result = custodianTerms;
			}
			else {
				result = custodianTerms = CustodianTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends FieldWithMetaStringBuilder> getEligibleCountry() {
			return eligibleCountry;
		}
		
		public FieldWithMetaStringBuilder getOrCreateEligibleCountry(int _index) {
		
			if (eligibleCountry==null) {
				this.eligibleCountry = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(eligibleCountry, _index, () -> {
						FieldWithMetaStringBuilder newEligibleCountry = FieldWithMetaString.builder();
						return newEligibleCountry;
					});
		}
		
		@Override
		public List<? extends HoldingPostedCollateralEnum> getPartyTerms() {
			return partyTerms;
		}
		
	
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setCustodianTerms(CustodianTerms custodianTerms) {
			this.custodianTerms = custodianTerms==null?null:custodianTerms.toBuilder();
			return this;
		}
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(FieldWithMetaString eligibleCountry) {
			if (eligibleCountry!=null) this.eligibleCountry.add(eligibleCountry.toBuilder());
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(FieldWithMetaString eligibleCountry, int _idx) {
			getIndex(this.eligibleCountry, _idx, () -> eligibleCountry.toBuilder());
			return this;
		}
		
			@Override
			public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(String eligibleCountry) {
				this.getOrCreateEligibleCountry(-1).setValue(eligibleCountry);
				return this;
			}
			
			@Override
			public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(String eligibleCountry, int _idx) {
				this.getOrCreateEligibleCountry(_idx).setValue(eligibleCountry);
				return this;
			}
		@Override 
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(List<? extends FieldWithMetaString> eligibleCountrys) {
			if (eligibleCountrys != null) {
				for (FieldWithMetaString toAdd : eligibleCountrys) {
					this.eligibleCountry.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setEligibleCountry(List<? extends FieldWithMetaString> eligibleCountrys) {
			if (eligibleCountrys == null)  {
				this.eligibleCountry = new ArrayList<>();
			}
			else {
				this.eligibleCountry = eligibleCountrys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(List<? extends String> eligibleCountrys) {
			if (eligibleCountrys != null) {
				for (String toAdd : eligibleCountrys) {
					this.addEligibleCountryValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setEligibleCountryValue(List<? extends String> eligibleCountrys) {
			this.eligibleCountry.clear();
			if (eligibleCountrys!=null) {
				eligibleCountrys.forEach(this::addEligibleCountryValue);
			}
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(HoldingPostedCollateralEnum partyTerms) {
			if (partyTerms!=null) this.partyTerms.add(partyTerms);
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(HoldingPostedCollateralEnum partyTerms, int _idx) {
			getIndex(this.partyTerms, _idx, () -> partyTerms);
			return this;
		}
		@Override 
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(List<? extends HoldingPostedCollateralEnum> partyTermss) {
			if (partyTermss != null) {
				for (HoldingPostedCollateralEnum toAdd : partyTermss) {
					this.partyTerms.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setPartyTerms(List<? extends HoldingPostedCollateralEnum> partyTermss) {
			if (partyTermss == null)  {
				this.partyTerms = new ArrayList<>();
			}
			else {
				this.partyTerms = partyTermss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public EligibilityToHoldCollateral build() {
			return new EligibilityToHoldCollateral.EligibilityToHoldCollateralImpl(this);
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder prune() {
			if (custodianTerms!=null && !custodianTerms.prune().hasData()) custodianTerms = null;
			eligibleCountry = eligibleCountry.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustodianTerms()!=null && getCustodianTerms().hasData()) return true;
			if (getEligibleCountry()!=null && !getEligibleCountry().isEmpty()) return true;
			if (getPartyTerms()!=null && !getPartyTerms().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder o = (EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder) other;
			
			merger.mergeRosetta(getCustodianTerms(), o.getCustodianTerms(), this::setCustodianTerms);
			merger.mergeRosetta(getEligibleCountry(), o.getEligibleCountry(), this::getOrCreateEligibleCountry);
			
			merger.mergeBasic(getPartyTerms(), o.getPartyTerms(), (Consumer<HoldingPostedCollateralEnum>) this::addPartyTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibilityToHoldCollateral _that = getType().cast(o);
		
			if (!Objects.equals(custodianTerms, _that.getCustodianTerms())) return false;
			if (!ListEquals.listEquals(eligibleCountry, _that.getEligibleCountry())) return false;
			if (!ListEquals.listEquals(partyTerms, _that.getPartyTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (custodianTerms != null ? custodianTerms.hashCode() : 0);
			_result = 31 * _result + (eligibleCountry != null ? eligibleCountry.hashCode() : 0);
			_result = 31 * _result + (partyTerms != null ? partyTerms.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibilityToHoldCollateralBuilder {" +
				"custodianTerms=" + this.custodianTerms + ", " +
				"eligibleCountry=" + this.eligibleCountry + ", " +
				"partyTerms=" + this.partyTerms +
			'}';
		}
	}
}
