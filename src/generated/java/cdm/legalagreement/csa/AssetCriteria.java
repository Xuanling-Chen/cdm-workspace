package cdm.legalagreement.csa;

import cdm.base.datetime.PeriodRange;
import cdm.base.staticdata.asset.common.AssetType;
import cdm.base.staticdata.asset.common.CollateralTaxonomy;
import cdm.base.staticdata.asset.common.MaturityTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.legalagreement.csa.meta.AssetCriteriaMeta;
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
 * Criteria used to specify eligible collateral assets.
 * @version ${project.version}
 */
@RosettaClass

public interface AssetCriteria extends RosettaModelObject {
	AssetCriteria build();
	AssetCriteria.AssetCriteriaBuilder toBuilder();
	
	/**
	 * Agency rating based on default risk and creditors claim in event of default associated with specific instrument.
	 */
	List<? extends AgencyRatingCriteria> getAgencyRating();
	/**
	 * Filter based on the issuing entity country of origin.
	 */
	List<? extends FieldWithMetaString> getAssetCountryOfOrigin();
	/**
	 * Filter based on the asset product type.
	 */
	List<? extends AssetType> getCollateralAssetType();
	/**
	 * Specifies the collateral taxonomy,which is composed of a taxonomy value and a taxonomy source.
	 */
	List<? extends CollateralTaxonomy> getCollateralTaxonomy();
	/**
	 * Filter based on the underlying asset denominated currency.
	 */
	List<? extends FieldWithMetaString> getDenominatedCurrency();
	/**
	 * Identifies that the Security must be denominated in the domestic currency of the issuer.
	 */
	Boolean getDomesticCurrencyIssued();
	/**
	 * Specifies the exchange, index or sector specific to listing of a security.
	 */
	ListingType getListing();
	/**
	 * Filter based on the underlying asset maturity.
	 */
	PeriodRange getMaturityRange();
	/**
	 * Specifies whether the maturity range is the remaining or original maturity.
	 */
	MaturityTypeEnum getMaturityType();
	/**
	 * Filter based on specific instrument identifiers (e.g. specific ISINs, CUSIPs etc).
	 */
	List<? extends ProductIdentifier> getProductIdentifier();
	final static AssetCriteriaMeta metaData = new AssetCriteriaMeta();
	
	@Override
	default RosettaMetaData<? extends AssetCriteria> metaData() {
		return metaData;
	} 
			
	static AssetCriteria.AssetCriteriaBuilder builder() {
		return new AssetCriteria.AssetCriteriaBuilderImpl();
	}
	
	default Class<? extends AssetCriteria> getType() {
		return AssetCriteria.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("domesticCurrencyIssued"), Boolean.class, getDomesticCurrencyIssued(), this);
		processor.processBasic(path.newSubPath("maturityType"), MaturityTypeEnum.class, getMaturityType(), this);
		
		processRosetta(path.newSubPath("agencyRating"), processor, AgencyRatingCriteria.class, getAgencyRating());
		processRosetta(path.newSubPath("assetCountryOfOrigin"), processor, FieldWithMetaString.class, getAssetCountryOfOrigin());
		processRosetta(path.newSubPath("collateralAssetType"), processor, AssetType.class, getCollateralAssetType());
		processRosetta(path.newSubPath("collateralTaxonomy"), processor, CollateralTaxonomy.class, getCollateralTaxonomy());
		processRosetta(path.newSubPath("denominatedCurrency"), processor, FieldWithMetaString.class, getDenominatedCurrency());
		processRosetta(path.newSubPath("listing"), processor, ListingType.class, getListing());
		processRosetta(path.newSubPath("maturityRange"), processor, PeriodRange.class, getMaturityRange());
		processRosetta(path.newSubPath("productIdentifier"), processor, ProductIdentifier.class, getProductIdentifier());
	}
	
	
	interface AssetCriteriaBuilder extends AssetCriteria, RosettaModelObjectBuilder {
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateAgencyRating(int _index);
		List<? extends AgencyRatingCriteria.AgencyRatingCriteriaBuilder> getAgencyRating();
		FieldWithMetaStringBuilder getOrCreateAssetCountryOfOrigin(int _index);
		List<? extends FieldWithMetaStringBuilder> getAssetCountryOfOrigin();
		AssetType.AssetTypeBuilder getOrCreateCollateralAssetType(int _index);
		List<? extends AssetType.AssetTypeBuilder> getCollateralAssetType();
		CollateralTaxonomy.CollateralTaxonomyBuilder getOrCreateCollateralTaxonomy(int _index);
		List<? extends CollateralTaxonomy.CollateralTaxonomyBuilder> getCollateralTaxonomy();
		FieldWithMetaStringBuilder getOrCreateDenominatedCurrency(int _index);
		List<? extends FieldWithMetaStringBuilder> getDenominatedCurrency();
		ListingType.ListingTypeBuilder getOrCreateListing();
		ListingType.ListingTypeBuilder getListing();
		PeriodRange.PeriodRangeBuilder getOrCreateMaturityRange();
		PeriodRange.PeriodRangeBuilder getMaturityRange();
		ProductIdentifier.ProductIdentifierBuilder getOrCreateProductIdentifier(int _index);
		List<? extends ProductIdentifier.ProductIdentifierBuilder> getProductIdentifier();
		AssetCriteria.AssetCriteriaBuilder addAgencyRating(AgencyRatingCriteria agencyRating);
		AssetCriteria.AssetCriteriaBuilder addAgencyRating(AgencyRatingCriteria agencyRating, int _idx);
		AssetCriteria.AssetCriteriaBuilder addAgencyRating(List<? extends AgencyRatingCriteria> agencyRating);
		AssetCriteria.AssetCriteriaBuilder setAgencyRating(List<? extends AgencyRatingCriteria> agencyRating);
		AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOrigin(FieldWithMetaString assetCountryOfOrigin);
		AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOrigin(FieldWithMetaString assetCountryOfOrigin, int _idx);
		AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOriginValue(String assetCountryOfOrigin);
		AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOriginValue(String assetCountryOfOrigin, int _idx);
		AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOrigin(List<? extends FieldWithMetaString> assetCountryOfOrigin);
		AssetCriteria.AssetCriteriaBuilder setAssetCountryOfOrigin(List<? extends FieldWithMetaString> assetCountryOfOrigin);
		AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOriginValue(List<? extends String> assetCountryOfOrigin);
		AssetCriteria.AssetCriteriaBuilder setAssetCountryOfOriginValue(List<? extends String> assetCountryOfOrigin);
		AssetCriteria.AssetCriteriaBuilder addCollateralAssetType(AssetType collateralAssetType);
		AssetCriteria.AssetCriteriaBuilder addCollateralAssetType(AssetType collateralAssetType, int _idx);
		AssetCriteria.AssetCriteriaBuilder addCollateralAssetType(List<? extends AssetType> collateralAssetType);
		AssetCriteria.AssetCriteriaBuilder setCollateralAssetType(List<? extends AssetType> collateralAssetType);
		AssetCriteria.AssetCriteriaBuilder addCollateralTaxonomy(CollateralTaxonomy collateralTaxonomy);
		AssetCriteria.AssetCriteriaBuilder addCollateralTaxonomy(CollateralTaxonomy collateralTaxonomy, int _idx);
		AssetCriteria.AssetCriteriaBuilder addCollateralTaxonomy(List<? extends CollateralTaxonomy> collateralTaxonomy);
		AssetCriteria.AssetCriteriaBuilder setCollateralTaxonomy(List<? extends CollateralTaxonomy> collateralTaxonomy);
		AssetCriteria.AssetCriteriaBuilder addDenominatedCurrency(FieldWithMetaString denominatedCurrency);
		AssetCriteria.AssetCriteriaBuilder addDenominatedCurrency(FieldWithMetaString denominatedCurrency, int _idx);
		AssetCriteria.AssetCriteriaBuilder addDenominatedCurrencyValue(String denominatedCurrency);
		AssetCriteria.AssetCriteriaBuilder addDenominatedCurrencyValue(String denominatedCurrency, int _idx);
		AssetCriteria.AssetCriteriaBuilder addDenominatedCurrency(List<? extends FieldWithMetaString> denominatedCurrency);
		AssetCriteria.AssetCriteriaBuilder setDenominatedCurrency(List<? extends FieldWithMetaString> denominatedCurrency);
		AssetCriteria.AssetCriteriaBuilder addDenominatedCurrencyValue(List<? extends String> denominatedCurrency);
		AssetCriteria.AssetCriteriaBuilder setDenominatedCurrencyValue(List<? extends String> denominatedCurrency);
		AssetCriteria.AssetCriteriaBuilder setDomesticCurrencyIssued(Boolean domesticCurrencyIssued);
		AssetCriteria.AssetCriteriaBuilder setListing(ListingType listing);
		AssetCriteria.AssetCriteriaBuilder setMaturityRange(PeriodRange maturityRange);
		AssetCriteria.AssetCriteriaBuilder setMaturityType(MaturityTypeEnum maturityType);
		AssetCriteria.AssetCriteriaBuilder addProductIdentifier(ProductIdentifier productIdentifier);
		AssetCriteria.AssetCriteriaBuilder addProductIdentifier(ProductIdentifier productIdentifier, int _idx);
		AssetCriteria.AssetCriteriaBuilder addProductIdentifier(List<? extends ProductIdentifier> productIdentifier);
		AssetCriteria.AssetCriteriaBuilder setProductIdentifier(List<? extends ProductIdentifier> productIdentifier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("domesticCurrencyIssued"), Boolean.class, getDomesticCurrencyIssued(), this);
			processor.processBasic(path.newSubPath("maturityType"), MaturityTypeEnum.class, getMaturityType(), this);
			
			processRosetta(path.newSubPath("agencyRating"), processor, AgencyRatingCriteria.AgencyRatingCriteriaBuilder.class, getAgencyRating());
			processRosetta(path.newSubPath("assetCountryOfOrigin"), processor, FieldWithMetaStringBuilder.class, getAssetCountryOfOrigin());
			processRosetta(path.newSubPath("collateralAssetType"), processor, AssetType.AssetTypeBuilder.class, getCollateralAssetType());
			processRosetta(path.newSubPath("collateralTaxonomy"), processor, CollateralTaxonomy.CollateralTaxonomyBuilder.class, getCollateralTaxonomy());
			processRosetta(path.newSubPath("denominatedCurrency"), processor, FieldWithMetaStringBuilder.class, getDenominatedCurrency());
			processRosetta(path.newSubPath("listing"), processor, ListingType.ListingTypeBuilder.class, getListing());
			processRosetta(path.newSubPath("maturityRange"), processor, PeriodRange.PeriodRangeBuilder.class, getMaturityRange());
			processRosetta(path.newSubPath("productIdentifier"), processor, ProductIdentifier.ProductIdentifierBuilder.class, getProductIdentifier());
		}
		
	}
	
	//AssetCriteria.AssetCriteriaImpl
	class AssetCriteriaImpl implements AssetCriteria {
		private final List<? extends AgencyRatingCriteria> agencyRating;
		private final List<? extends FieldWithMetaString> assetCountryOfOrigin;
		private final List<? extends AssetType> collateralAssetType;
		private final List<? extends CollateralTaxonomy> collateralTaxonomy;
		private final List<? extends FieldWithMetaString> denominatedCurrency;
		private final Boolean domesticCurrencyIssued;
		private final ListingType listing;
		private final PeriodRange maturityRange;
		private final MaturityTypeEnum maturityType;
		private final List<? extends ProductIdentifier> productIdentifier;
		
		protected AssetCriteriaImpl(AssetCriteria.AssetCriteriaBuilder builder) {
			this.agencyRating = ofNullable(builder.getAgencyRating()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.assetCountryOfOrigin = ofNullable(builder.getAssetCountryOfOrigin()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.collateralAssetType = ofNullable(builder.getCollateralAssetType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.collateralTaxonomy = ofNullable(builder.getCollateralTaxonomy()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.denominatedCurrency = ofNullable(builder.getDenominatedCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.domesticCurrencyIssued = builder.getDomesticCurrencyIssued();
			this.listing = ofNullable(builder.getListing()).map(f->f.build()).orElse(null);
			this.maturityRange = ofNullable(builder.getMaturityRange()).map(f->f.build()).orElse(null);
			this.maturityType = builder.getMaturityType();
			this.productIdentifier = ofNullable(builder.getProductIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends AgencyRatingCriteria> getAgencyRating() {
			return agencyRating;
		}
		
		@Override
		public List<? extends FieldWithMetaString> getAssetCountryOfOrigin() {
			return assetCountryOfOrigin;
		}
		
		@Override
		public List<? extends AssetType> getCollateralAssetType() {
			return collateralAssetType;
		}
		
		@Override
		public List<? extends CollateralTaxonomy> getCollateralTaxonomy() {
			return collateralTaxonomy;
		}
		
		@Override
		public List<? extends FieldWithMetaString> getDenominatedCurrency() {
			return denominatedCurrency;
		}
		
		@Override
		public Boolean getDomesticCurrencyIssued() {
			return domesticCurrencyIssued;
		}
		
		@Override
		public ListingType getListing() {
			return listing;
		}
		
		@Override
		public PeriodRange getMaturityRange() {
			return maturityRange;
		}
		
		@Override
		public MaturityTypeEnum getMaturityType() {
			return maturityType;
		}
		
		@Override
		public List<? extends ProductIdentifier> getProductIdentifier() {
			return productIdentifier;
		}
		
		@Override
		public AssetCriteria build() {
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder toBuilder() {
			AssetCriteria.AssetCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetCriteria.AssetCriteriaBuilder builder) {
			ofNullable(getAgencyRating()).ifPresent(builder::setAgencyRating);
			ofNullable(getAssetCountryOfOrigin()).ifPresent(builder::setAssetCountryOfOrigin);
			ofNullable(getCollateralAssetType()).ifPresent(builder::setCollateralAssetType);
			ofNullable(getCollateralTaxonomy()).ifPresent(builder::setCollateralTaxonomy);
			ofNullable(getDenominatedCurrency()).ifPresent(builder::setDenominatedCurrency);
			ofNullable(getDomesticCurrencyIssued()).ifPresent(builder::setDomesticCurrencyIssued);
			ofNullable(getListing()).ifPresent(builder::setListing);
			ofNullable(getMaturityRange()).ifPresent(builder::setMaturityRange);
			ofNullable(getMaturityType()).ifPresent(builder::setMaturityType);
			ofNullable(getProductIdentifier()).ifPresent(builder::setProductIdentifier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetCriteria _that = getType().cast(o);
		
			if (!ListEquals.listEquals(agencyRating, _that.getAgencyRating())) return false;
			if (!ListEquals.listEquals(assetCountryOfOrigin, _that.getAssetCountryOfOrigin())) return false;
			if (!ListEquals.listEquals(collateralAssetType, _that.getCollateralAssetType())) return false;
			if (!ListEquals.listEquals(collateralTaxonomy, _that.getCollateralTaxonomy())) return false;
			if (!ListEquals.listEquals(denominatedCurrency, _that.getDenominatedCurrency())) return false;
			if (!Objects.equals(domesticCurrencyIssued, _that.getDomesticCurrencyIssued())) return false;
			if (!Objects.equals(listing, _that.getListing())) return false;
			if (!Objects.equals(maturityRange, _that.getMaturityRange())) return false;
			if (!Objects.equals(maturityType, _that.getMaturityType())) return false;
			if (!ListEquals.listEquals(productIdentifier, _that.getProductIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agencyRating != null ? agencyRating.hashCode() : 0);
			_result = 31 * _result + (assetCountryOfOrigin != null ? assetCountryOfOrigin.hashCode() : 0);
			_result = 31 * _result + (collateralAssetType != null ? collateralAssetType.hashCode() : 0);
			_result = 31 * _result + (collateralTaxonomy != null ? collateralTaxonomy.hashCode() : 0);
			_result = 31 * _result + (denominatedCurrency != null ? denominatedCurrency.hashCode() : 0);
			_result = 31 * _result + (domesticCurrencyIssued != null ? domesticCurrencyIssued.hashCode() : 0);
			_result = 31 * _result + (listing != null ? listing.hashCode() : 0);
			_result = 31 * _result + (maturityRange != null ? maturityRange.hashCode() : 0);
			_result = 31 * _result + (maturityType != null ? maturityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (productIdentifier != null ? productIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetCriteria {" +
				"agencyRating=" + this.agencyRating + ", " +
				"assetCountryOfOrigin=" + this.assetCountryOfOrigin + ", " +
				"collateralAssetType=" + this.collateralAssetType + ", " +
				"collateralTaxonomy=" + this.collateralTaxonomy + ", " +
				"denominatedCurrency=" + this.denominatedCurrency + ", " +
				"domesticCurrencyIssued=" + this.domesticCurrencyIssued + ", " +
				"listing=" + this.listing + ", " +
				"maturityRange=" + this.maturityRange + ", " +
				"maturityType=" + this.maturityType + ", " +
				"productIdentifier=" + this.productIdentifier +
			'}';
		}
	}
	
	//AssetCriteria.AssetCriteriaBuilderImpl
	class AssetCriteriaBuilderImpl implements AssetCriteria.AssetCriteriaBuilder {
	
		protected List<AgencyRatingCriteria.AgencyRatingCriteriaBuilder> agencyRating = new ArrayList<>();
		protected List<FieldWithMetaStringBuilder> assetCountryOfOrigin = new ArrayList<>();
		protected List<AssetType.AssetTypeBuilder> collateralAssetType = new ArrayList<>();
		protected List<CollateralTaxonomy.CollateralTaxonomyBuilder> collateralTaxonomy = new ArrayList<>();
		protected List<FieldWithMetaStringBuilder> denominatedCurrency = new ArrayList<>();
		protected Boolean domesticCurrencyIssued;
		protected ListingType.ListingTypeBuilder listing;
		protected PeriodRange.PeriodRangeBuilder maturityRange;
		protected MaturityTypeEnum maturityType;
		protected List<ProductIdentifier.ProductIdentifierBuilder> productIdentifier = new ArrayList<>();
	
		public AssetCriteriaBuilderImpl() {
		}
	
		@Override
		public List<? extends AgencyRatingCriteria.AgencyRatingCriteriaBuilder> getAgencyRating() {
			return agencyRating;
		}
		
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateAgencyRating(int _index) {
		
			if (agencyRating==null) {
				this.agencyRating = new ArrayList<>();
			}
			AgencyRatingCriteria.AgencyRatingCriteriaBuilder result;
			return getIndex(agencyRating, _index, () -> {
						AgencyRatingCriteria.AgencyRatingCriteriaBuilder newAgencyRating = AgencyRatingCriteria.builder();
						return newAgencyRating;
					});
		}
		
		@Override
		public List<? extends FieldWithMetaStringBuilder> getAssetCountryOfOrigin() {
			return assetCountryOfOrigin;
		}
		
		public FieldWithMetaStringBuilder getOrCreateAssetCountryOfOrigin(int _index) {
		
			if (assetCountryOfOrigin==null) {
				this.assetCountryOfOrigin = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(assetCountryOfOrigin, _index, () -> {
						FieldWithMetaStringBuilder newAssetCountryOfOrigin = FieldWithMetaString.builder();
						return newAssetCountryOfOrigin;
					});
		}
		
		@Override
		public List<? extends AssetType.AssetTypeBuilder> getCollateralAssetType() {
			return collateralAssetType;
		}
		
		public AssetType.AssetTypeBuilder getOrCreateCollateralAssetType(int _index) {
		
			if (collateralAssetType==null) {
				this.collateralAssetType = new ArrayList<>();
			}
			AssetType.AssetTypeBuilder result;
			return getIndex(collateralAssetType, _index, () -> {
						AssetType.AssetTypeBuilder newCollateralAssetType = AssetType.builder();
						return newCollateralAssetType;
					});
		}
		
		@Override
		public List<? extends CollateralTaxonomy.CollateralTaxonomyBuilder> getCollateralTaxonomy() {
			return collateralTaxonomy;
		}
		
		public CollateralTaxonomy.CollateralTaxonomyBuilder getOrCreateCollateralTaxonomy(int _index) {
		
			if (collateralTaxonomy==null) {
				this.collateralTaxonomy = new ArrayList<>();
			}
			CollateralTaxonomy.CollateralTaxonomyBuilder result;
			return getIndex(collateralTaxonomy, _index, () -> {
						CollateralTaxonomy.CollateralTaxonomyBuilder newCollateralTaxonomy = CollateralTaxonomy.builder();
						return newCollateralTaxonomy;
					});
		}
		
		@Override
		public List<? extends FieldWithMetaStringBuilder> getDenominatedCurrency() {
			return denominatedCurrency;
		}
		
		public FieldWithMetaStringBuilder getOrCreateDenominatedCurrency(int _index) {
		
			if (denominatedCurrency==null) {
				this.denominatedCurrency = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(denominatedCurrency, _index, () -> {
						FieldWithMetaStringBuilder newDenominatedCurrency = FieldWithMetaString.builder();
						return newDenominatedCurrency;
					});
		}
		
		@Override
		public Boolean getDomesticCurrencyIssued() {
			return domesticCurrencyIssued;
		}
		
		@Override
		public ListingType.ListingTypeBuilder getListing() {
			return listing;
		}
		
		@Override
		public ListingType.ListingTypeBuilder getOrCreateListing() {
			ListingType.ListingTypeBuilder result;
			if (listing!=null) {
				result = listing;
			}
			else {
				result = listing = ListingType.builder();
			}
			
			return result;
		}
		
		@Override
		public PeriodRange.PeriodRangeBuilder getMaturityRange() {
			return maturityRange;
		}
		
		@Override
		public PeriodRange.PeriodRangeBuilder getOrCreateMaturityRange() {
			PeriodRange.PeriodRangeBuilder result;
			if (maturityRange!=null) {
				result = maturityRange;
			}
			else {
				result = maturityRange = PeriodRange.builder();
			}
			
			return result;
		}
		
		@Override
		public MaturityTypeEnum getMaturityType() {
			return maturityType;
		}
		
		@Override
		public List<? extends ProductIdentifier.ProductIdentifierBuilder> getProductIdentifier() {
			return productIdentifier;
		}
		
		public ProductIdentifier.ProductIdentifierBuilder getOrCreateProductIdentifier(int _index) {
		
			if (productIdentifier==null) {
				this.productIdentifier = new ArrayList<>();
			}
			ProductIdentifier.ProductIdentifierBuilder result;
			return getIndex(productIdentifier, _index, () -> {
						ProductIdentifier.ProductIdentifierBuilder newProductIdentifier = ProductIdentifier.builder();
						return newProductIdentifier;
					});
		}
		
	
		@Override
		public AssetCriteria.AssetCriteriaBuilder addAgencyRating(AgencyRatingCriteria agencyRating) {
			if (agencyRating!=null) this.agencyRating.add(agencyRating.toBuilder());
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addAgencyRating(AgencyRatingCriteria agencyRating, int _idx) {
			getIndex(this.agencyRating, _idx, () -> agencyRating.toBuilder());
			return this;
		}
		@Override 
		public AssetCriteria.AssetCriteriaBuilder addAgencyRating(List<? extends AgencyRatingCriteria> agencyRatings) {
			if (agencyRatings != null) {
				for (AgencyRatingCriteria toAdd : agencyRatings) {
					this.agencyRating.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AssetCriteria.AssetCriteriaBuilder setAgencyRating(List<? extends AgencyRatingCriteria> agencyRatings) {
			if (agencyRatings == null)  {
				this.agencyRating = new ArrayList<>();
			}
			else {
				this.agencyRating = agencyRatings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOrigin(FieldWithMetaString assetCountryOfOrigin) {
			if (assetCountryOfOrigin!=null) this.assetCountryOfOrigin.add(assetCountryOfOrigin.toBuilder());
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOrigin(FieldWithMetaString assetCountryOfOrigin, int _idx) {
			getIndex(this.assetCountryOfOrigin, _idx, () -> assetCountryOfOrigin.toBuilder());
			return this;
		}
		
			@Override
			public AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOriginValue(String assetCountryOfOrigin) {
				this.getOrCreateAssetCountryOfOrigin(-1).setValue(assetCountryOfOrigin);
				return this;
			}
			
			@Override
			public AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOriginValue(String assetCountryOfOrigin, int _idx) {
				this.getOrCreateAssetCountryOfOrigin(_idx).setValue(assetCountryOfOrigin);
				return this;
			}
		@Override 
		public AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOrigin(List<? extends FieldWithMetaString> assetCountryOfOrigins) {
			if (assetCountryOfOrigins != null) {
				for (FieldWithMetaString toAdd : assetCountryOfOrigins) {
					this.assetCountryOfOrigin.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AssetCriteria.AssetCriteriaBuilder setAssetCountryOfOrigin(List<? extends FieldWithMetaString> assetCountryOfOrigins) {
			if (assetCountryOfOrigins == null)  {
				this.assetCountryOfOrigin = new ArrayList<>();
			}
			else {
				this.assetCountryOfOrigin = assetCountryOfOrigins.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addAssetCountryOfOriginValue(List<? extends String> assetCountryOfOrigins) {
			if (assetCountryOfOrigins != null) {
				for (String toAdd : assetCountryOfOrigins) {
					this.addAssetCountryOfOriginValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder setAssetCountryOfOriginValue(List<? extends String> assetCountryOfOrigins) {
			this.assetCountryOfOrigin.clear();
			if (assetCountryOfOrigins!=null) {
				assetCountryOfOrigins.forEach(this::addAssetCountryOfOriginValue);
			}
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addCollateralAssetType(AssetType collateralAssetType) {
			if (collateralAssetType!=null) this.collateralAssetType.add(collateralAssetType.toBuilder());
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addCollateralAssetType(AssetType collateralAssetType, int _idx) {
			getIndex(this.collateralAssetType, _idx, () -> collateralAssetType.toBuilder());
			return this;
		}
		@Override 
		public AssetCriteria.AssetCriteriaBuilder addCollateralAssetType(List<? extends AssetType> collateralAssetTypes) {
			if (collateralAssetTypes != null) {
				for (AssetType toAdd : collateralAssetTypes) {
					this.collateralAssetType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AssetCriteria.AssetCriteriaBuilder setCollateralAssetType(List<? extends AssetType> collateralAssetTypes) {
			if (collateralAssetTypes == null)  {
				this.collateralAssetType = new ArrayList<>();
			}
			else {
				this.collateralAssetType = collateralAssetTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addCollateralTaxonomy(CollateralTaxonomy collateralTaxonomy) {
			if (collateralTaxonomy!=null) this.collateralTaxonomy.add(collateralTaxonomy.toBuilder());
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addCollateralTaxonomy(CollateralTaxonomy collateralTaxonomy, int _idx) {
			getIndex(this.collateralTaxonomy, _idx, () -> collateralTaxonomy.toBuilder());
			return this;
		}
		@Override 
		public AssetCriteria.AssetCriteriaBuilder addCollateralTaxonomy(List<? extends CollateralTaxonomy> collateralTaxonomys) {
			if (collateralTaxonomys != null) {
				for (CollateralTaxonomy toAdd : collateralTaxonomys) {
					this.collateralTaxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AssetCriteria.AssetCriteriaBuilder setCollateralTaxonomy(List<? extends CollateralTaxonomy> collateralTaxonomys) {
			if (collateralTaxonomys == null)  {
				this.collateralTaxonomy = new ArrayList<>();
			}
			else {
				this.collateralTaxonomy = collateralTaxonomys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addDenominatedCurrency(FieldWithMetaString denominatedCurrency) {
			if (denominatedCurrency!=null) this.denominatedCurrency.add(denominatedCurrency.toBuilder());
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addDenominatedCurrency(FieldWithMetaString denominatedCurrency, int _idx) {
			getIndex(this.denominatedCurrency, _idx, () -> denominatedCurrency.toBuilder());
			return this;
		}
		
			@Override
			public AssetCriteria.AssetCriteriaBuilder addDenominatedCurrencyValue(String denominatedCurrency) {
				this.getOrCreateDenominatedCurrency(-1).setValue(denominatedCurrency);
				return this;
			}
			
			@Override
			public AssetCriteria.AssetCriteriaBuilder addDenominatedCurrencyValue(String denominatedCurrency, int _idx) {
				this.getOrCreateDenominatedCurrency(_idx).setValue(denominatedCurrency);
				return this;
			}
		@Override 
		public AssetCriteria.AssetCriteriaBuilder addDenominatedCurrency(List<? extends FieldWithMetaString> denominatedCurrencys) {
			if (denominatedCurrencys != null) {
				for (FieldWithMetaString toAdd : denominatedCurrencys) {
					this.denominatedCurrency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AssetCriteria.AssetCriteriaBuilder setDenominatedCurrency(List<? extends FieldWithMetaString> denominatedCurrencys) {
			if (denominatedCurrencys == null)  {
				this.denominatedCurrency = new ArrayList<>();
			}
			else {
				this.denominatedCurrency = denominatedCurrencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addDenominatedCurrencyValue(List<? extends String> denominatedCurrencys) {
			if (denominatedCurrencys != null) {
				for (String toAdd : denominatedCurrencys) {
					this.addDenominatedCurrencyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder setDenominatedCurrencyValue(List<? extends String> denominatedCurrencys) {
			this.denominatedCurrency.clear();
			if (denominatedCurrencys!=null) {
				denominatedCurrencys.forEach(this::addDenominatedCurrencyValue);
			}
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder setDomesticCurrencyIssued(Boolean domesticCurrencyIssued) {
			this.domesticCurrencyIssued = domesticCurrencyIssued==null?null:domesticCurrencyIssued;
			return this;
		}
		@Override
		public AssetCriteria.AssetCriteriaBuilder setListing(ListingType listing) {
			this.listing = listing==null?null:listing.toBuilder();
			return this;
		}
		@Override
		public AssetCriteria.AssetCriteriaBuilder setMaturityRange(PeriodRange maturityRange) {
			this.maturityRange = maturityRange==null?null:maturityRange.toBuilder();
			return this;
		}
		@Override
		public AssetCriteria.AssetCriteriaBuilder setMaturityType(MaturityTypeEnum maturityType) {
			this.maturityType = maturityType==null?null:maturityType;
			return this;
		}
		@Override
		public AssetCriteria.AssetCriteriaBuilder addProductIdentifier(ProductIdentifier productIdentifier) {
			if (productIdentifier!=null) this.productIdentifier.add(productIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder addProductIdentifier(ProductIdentifier productIdentifier, int _idx) {
			getIndex(this.productIdentifier, _idx, () -> productIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AssetCriteria.AssetCriteriaBuilder addProductIdentifier(List<? extends ProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ProductIdentifier toAdd : productIdentifiers) {
					this.productIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AssetCriteria.AssetCriteriaBuilder setProductIdentifier(List<? extends ProductIdentifier> productIdentifiers) {
			if (productIdentifiers == null)  {
				this.productIdentifier = new ArrayList<>();
			}
			else {
				this.productIdentifier = productIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AssetCriteria build() {
			return new AssetCriteria.AssetCriteriaImpl(this);
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetCriteria.AssetCriteriaBuilder prune() {
			agencyRating = agencyRating.stream().filter(b->b!=null).<AgencyRatingCriteria.AgencyRatingCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			assetCountryOfOrigin = assetCountryOfOrigin.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			collateralAssetType = collateralAssetType.stream().filter(b->b!=null).<AssetType.AssetTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			collateralTaxonomy = collateralTaxonomy.stream().filter(b->b!=null).<CollateralTaxonomy.CollateralTaxonomyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			denominatedCurrency = denominatedCurrency.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (listing!=null && !listing.prune().hasData()) listing = null;
			if (maturityRange!=null && !maturityRange.prune().hasData()) maturityRange = null;
			productIdentifier = productIdentifier.stream().filter(b->b!=null).<ProductIdentifier.ProductIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAgencyRating()!=null && getAgencyRating().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAssetCountryOfOrigin()!=null && !getAssetCountryOfOrigin().isEmpty()) return true;
			if (getCollateralAssetType()!=null && getCollateralAssetType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCollateralTaxonomy()!=null && getCollateralTaxonomy().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDenominatedCurrency()!=null && !getDenominatedCurrency().isEmpty()) return true;
			if (getDomesticCurrencyIssued()!=null) return true;
			if (getListing()!=null && getListing().hasData()) return true;
			if (getMaturityRange()!=null && getMaturityRange().hasData()) return true;
			if (getMaturityType()!=null) return true;
			if (getProductIdentifier()!=null && getProductIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetCriteria.AssetCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetCriteria.AssetCriteriaBuilder o = (AssetCriteria.AssetCriteriaBuilder) other;
			
			merger.mergeRosetta(getAgencyRating(), o.getAgencyRating(), this::getOrCreateAgencyRating);
			merger.mergeRosetta(getAssetCountryOfOrigin(), o.getAssetCountryOfOrigin(), this::getOrCreateAssetCountryOfOrigin);
			merger.mergeRosetta(getCollateralAssetType(), o.getCollateralAssetType(), this::getOrCreateCollateralAssetType);
			merger.mergeRosetta(getCollateralTaxonomy(), o.getCollateralTaxonomy(), this::getOrCreateCollateralTaxonomy);
			merger.mergeRosetta(getDenominatedCurrency(), o.getDenominatedCurrency(), this::getOrCreateDenominatedCurrency);
			merger.mergeRosetta(getListing(), o.getListing(), this::setListing);
			merger.mergeRosetta(getMaturityRange(), o.getMaturityRange(), this::setMaturityRange);
			merger.mergeRosetta(getProductIdentifier(), o.getProductIdentifier(), this::getOrCreateProductIdentifier);
			
			merger.mergeBasic(getDomesticCurrencyIssued(), o.getDomesticCurrencyIssued(), this::setDomesticCurrencyIssued);
			merger.mergeBasic(getMaturityType(), o.getMaturityType(), this::setMaturityType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetCriteria _that = getType().cast(o);
		
			if (!ListEquals.listEquals(agencyRating, _that.getAgencyRating())) return false;
			if (!ListEquals.listEquals(assetCountryOfOrigin, _that.getAssetCountryOfOrigin())) return false;
			if (!ListEquals.listEquals(collateralAssetType, _that.getCollateralAssetType())) return false;
			if (!ListEquals.listEquals(collateralTaxonomy, _that.getCollateralTaxonomy())) return false;
			if (!ListEquals.listEquals(denominatedCurrency, _that.getDenominatedCurrency())) return false;
			if (!Objects.equals(domesticCurrencyIssued, _that.getDomesticCurrencyIssued())) return false;
			if (!Objects.equals(listing, _that.getListing())) return false;
			if (!Objects.equals(maturityRange, _that.getMaturityRange())) return false;
			if (!Objects.equals(maturityType, _that.getMaturityType())) return false;
			if (!ListEquals.listEquals(productIdentifier, _that.getProductIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agencyRating != null ? agencyRating.hashCode() : 0);
			_result = 31 * _result + (assetCountryOfOrigin != null ? assetCountryOfOrigin.hashCode() : 0);
			_result = 31 * _result + (collateralAssetType != null ? collateralAssetType.hashCode() : 0);
			_result = 31 * _result + (collateralTaxonomy != null ? collateralTaxonomy.hashCode() : 0);
			_result = 31 * _result + (denominatedCurrency != null ? denominatedCurrency.hashCode() : 0);
			_result = 31 * _result + (domesticCurrencyIssued != null ? domesticCurrencyIssued.hashCode() : 0);
			_result = 31 * _result + (listing != null ? listing.hashCode() : 0);
			_result = 31 * _result + (maturityRange != null ? maturityRange.hashCode() : 0);
			_result = 31 * _result + (maturityType != null ? maturityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (productIdentifier != null ? productIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetCriteriaBuilder {" +
				"agencyRating=" + this.agencyRating + ", " +
				"assetCountryOfOrigin=" + this.assetCountryOfOrigin + ", " +
				"collateralAssetType=" + this.collateralAssetType + ", " +
				"collateralTaxonomy=" + this.collateralTaxonomy + ", " +
				"denominatedCurrency=" + this.denominatedCurrency + ", " +
				"domesticCurrencyIssued=" + this.domesticCurrencyIssued + ", " +
				"listing=" + this.listing + ", " +
				"maturityRange=" + this.maturityRange + ", " +
				"maturityType=" + this.maturityType + ", " +
				"productIdentifier=" + this.productIdentifier +
			'}';
		}
	}
}
