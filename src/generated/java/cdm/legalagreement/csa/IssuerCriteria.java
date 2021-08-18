package cdm.legalagreement.csa;

import cdm.base.staticdata.asset.common.CollateralIssuerType;
import cdm.base.staticdata.party.LegalEntity;
import cdm.legalagreement.csa.meta.IssuerCriteriaMeta;
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
 * Criteria used to specify eligible collateral issuers.
 * @version ${project.version}
 */
@RosettaClass

public interface IssuerCriteria extends RosettaModelObject {
	IssuerCriteria build();
	IssuerCriteria.IssuerCriteriaBuilder toBuilder();
	
	/**
	 * Filter based on whether it is permitted for the the underlying asset to be issued by the posting entity or part of their corporate family.
	 */
	Boolean getCounterpartyOwnIssuePermitted();
	/**
	 * Agency rating based on default risk and creditors claim in event of default associated with asset issuer.
	 */
	List<? extends AgencyRatingCriteria> getIssuerAgencyRating();
	/**
	 * Filter based on the issuing entity country of origin, which is the same as filtering by eligible Sovereigns.
	 */
	List<? extends FieldWithMetaString> getIssuerCountryOfOrigin();
	/**
	 * Filter based on the issuing entity name or LEI.
	 */
	List<? extends LegalEntity> getIssuerName();
	/**
	 * Filter based on the type of entity issuing the asset.
	 */
	List<? extends CollateralIssuerType> getIssuerType();
	/**
	 * Agency rating based on default risk of country.
	 */
	List<? extends AgencyRatingCriteria> getSovereignAgencyRating();
	final static IssuerCriteriaMeta metaData = new IssuerCriteriaMeta();
	
	@Override
	default RosettaMetaData<? extends IssuerCriteria> metaData() {
		return metaData;
	} 
			
	static IssuerCriteria.IssuerCriteriaBuilder builder() {
		return new IssuerCriteria.IssuerCriteriaBuilderImpl();
	}
	
	default Class<? extends IssuerCriteria> getType() {
		return IssuerCriteria.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("counterpartyOwnIssuePermitted"), Boolean.class, getCounterpartyOwnIssuePermitted(), this);
		
		processRosetta(path.newSubPath("issuerAgencyRating"), processor, AgencyRatingCriteria.class, getIssuerAgencyRating());
		processRosetta(path.newSubPath("issuerCountryOfOrigin"), processor, FieldWithMetaString.class, getIssuerCountryOfOrigin());
		processRosetta(path.newSubPath("issuerName"), processor, LegalEntity.class, getIssuerName());
		processRosetta(path.newSubPath("issuerType"), processor, CollateralIssuerType.class, getIssuerType());
		processRosetta(path.newSubPath("sovereignAgencyRating"), processor, AgencyRatingCriteria.class, getSovereignAgencyRating());
	}
	
	
	interface IssuerCriteriaBuilder extends IssuerCriteria, RosettaModelObjectBuilder {
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateIssuerAgencyRating(int _index);
		List<? extends AgencyRatingCriteria.AgencyRatingCriteriaBuilder> getIssuerAgencyRating();
		FieldWithMetaStringBuilder getOrCreateIssuerCountryOfOrigin(int _index);
		List<? extends FieldWithMetaStringBuilder> getIssuerCountryOfOrigin();
		LegalEntity.LegalEntityBuilder getOrCreateIssuerName(int _index);
		List<? extends LegalEntity.LegalEntityBuilder> getIssuerName();
		CollateralIssuerType.CollateralIssuerTypeBuilder getOrCreateIssuerType(int _index);
		List<? extends CollateralIssuerType.CollateralIssuerTypeBuilder> getIssuerType();
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateSovereignAgencyRating(int _index);
		List<? extends AgencyRatingCriteria.AgencyRatingCriteriaBuilder> getSovereignAgencyRating();
		IssuerCriteria.IssuerCriteriaBuilder setCounterpartyOwnIssuePermitted(Boolean counterpartyOwnIssuePermitted);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerAgencyRating(AgencyRatingCriteria issuerAgencyRating);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerAgencyRating(AgencyRatingCriteria issuerAgencyRating, int _idx);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerAgencyRating(List<? extends AgencyRatingCriteria> issuerAgencyRating);
		IssuerCriteria.IssuerCriteriaBuilder setIssuerAgencyRating(List<? extends AgencyRatingCriteria> issuerAgencyRating);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOrigin(FieldWithMetaString issuerCountryOfOrigin);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOrigin(FieldWithMetaString issuerCountryOfOrigin, int _idx);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOriginValue(String issuerCountryOfOrigin);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOriginValue(String issuerCountryOfOrigin, int _idx);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOrigin(List<? extends FieldWithMetaString> issuerCountryOfOrigin);
		IssuerCriteria.IssuerCriteriaBuilder setIssuerCountryOfOrigin(List<? extends FieldWithMetaString> issuerCountryOfOrigin);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOriginValue(List<? extends String> issuerCountryOfOrigin);
		IssuerCriteria.IssuerCriteriaBuilder setIssuerCountryOfOriginValue(List<? extends String> issuerCountryOfOrigin);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerName(LegalEntity issuerName);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerName(LegalEntity issuerName, int _idx);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerName(List<? extends LegalEntity> issuerName);
		IssuerCriteria.IssuerCriteriaBuilder setIssuerName(List<? extends LegalEntity> issuerName);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerType(CollateralIssuerType issuerType);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerType(CollateralIssuerType issuerType, int _idx);
		IssuerCriteria.IssuerCriteriaBuilder addIssuerType(List<? extends CollateralIssuerType> issuerType);
		IssuerCriteria.IssuerCriteriaBuilder setIssuerType(List<? extends CollateralIssuerType> issuerType);
		IssuerCriteria.IssuerCriteriaBuilder addSovereignAgencyRating(AgencyRatingCriteria sovereignAgencyRating);
		IssuerCriteria.IssuerCriteriaBuilder addSovereignAgencyRating(AgencyRatingCriteria sovereignAgencyRating, int _idx);
		IssuerCriteria.IssuerCriteriaBuilder addSovereignAgencyRating(List<? extends AgencyRatingCriteria> sovereignAgencyRating);
		IssuerCriteria.IssuerCriteriaBuilder setSovereignAgencyRating(List<? extends AgencyRatingCriteria> sovereignAgencyRating);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("counterpartyOwnIssuePermitted"), Boolean.class, getCounterpartyOwnIssuePermitted(), this);
			
			processRosetta(path.newSubPath("issuerAgencyRating"), processor, AgencyRatingCriteria.AgencyRatingCriteriaBuilder.class, getIssuerAgencyRating());
			processRosetta(path.newSubPath("issuerCountryOfOrigin"), processor, FieldWithMetaStringBuilder.class, getIssuerCountryOfOrigin());
			processRosetta(path.newSubPath("issuerName"), processor, LegalEntity.LegalEntityBuilder.class, getIssuerName());
			processRosetta(path.newSubPath("issuerType"), processor, CollateralIssuerType.CollateralIssuerTypeBuilder.class, getIssuerType());
			processRosetta(path.newSubPath("sovereignAgencyRating"), processor, AgencyRatingCriteria.AgencyRatingCriteriaBuilder.class, getSovereignAgencyRating());
		}
		
	}
	
	//IssuerCriteria.IssuerCriteriaImpl
	class IssuerCriteriaImpl implements IssuerCriteria {
		private final Boolean counterpartyOwnIssuePermitted;
		private final List<? extends AgencyRatingCriteria> issuerAgencyRating;
		private final List<? extends FieldWithMetaString> issuerCountryOfOrigin;
		private final List<? extends LegalEntity> issuerName;
		private final List<? extends CollateralIssuerType> issuerType;
		private final List<? extends AgencyRatingCriteria> sovereignAgencyRating;
		
		protected IssuerCriteriaImpl(IssuerCriteria.IssuerCriteriaBuilder builder) {
			this.counterpartyOwnIssuePermitted = builder.getCounterpartyOwnIssuePermitted();
			this.issuerAgencyRating = ofNullable(builder.getIssuerAgencyRating()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.issuerCountryOfOrigin = ofNullable(builder.getIssuerCountryOfOrigin()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.issuerName = ofNullable(builder.getIssuerName()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.issuerType = ofNullable(builder.getIssuerType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.sovereignAgencyRating = ofNullable(builder.getSovereignAgencyRating()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public Boolean getCounterpartyOwnIssuePermitted() {
			return counterpartyOwnIssuePermitted;
		}
		
		@Override
		public List<? extends AgencyRatingCriteria> getIssuerAgencyRating() {
			return issuerAgencyRating;
		}
		
		@Override
		public List<? extends FieldWithMetaString> getIssuerCountryOfOrigin() {
			return issuerCountryOfOrigin;
		}
		
		@Override
		public List<? extends LegalEntity> getIssuerName() {
			return issuerName;
		}
		
		@Override
		public List<? extends CollateralIssuerType> getIssuerType() {
			return issuerType;
		}
		
		@Override
		public List<? extends AgencyRatingCriteria> getSovereignAgencyRating() {
			return sovereignAgencyRating;
		}
		
		@Override
		public IssuerCriteria build() {
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder toBuilder() {
			IssuerCriteria.IssuerCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IssuerCriteria.IssuerCriteriaBuilder builder) {
			ofNullable(getCounterpartyOwnIssuePermitted()).ifPresent(builder::setCounterpartyOwnIssuePermitted);
			ofNullable(getIssuerAgencyRating()).ifPresent(builder::setIssuerAgencyRating);
			ofNullable(getIssuerCountryOfOrigin()).ifPresent(builder::setIssuerCountryOfOrigin);
			ofNullable(getIssuerName()).ifPresent(builder::setIssuerName);
			ofNullable(getIssuerType()).ifPresent(builder::setIssuerType);
			ofNullable(getSovereignAgencyRating()).ifPresent(builder::setSovereignAgencyRating);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerCriteria _that = getType().cast(o);
		
			if (!Objects.equals(counterpartyOwnIssuePermitted, _that.getCounterpartyOwnIssuePermitted())) return false;
			if (!ListEquals.listEquals(issuerAgencyRating, _that.getIssuerAgencyRating())) return false;
			if (!ListEquals.listEquals(issuerCountryOfOrigin, _that.getIssuerCountryOfOrigin())) return false;
			if (!ListEquals.listEquals(issuerName, _that.getIssuerName())) return false;
			if (!ListEquals.listEquals(issuerType, _that.getIssuerType())) return false;
			if (!ListEquals.listEquals(sovereignAgencyRating, _that.getSovereignAgencyRating())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (counterpartyOwnIssuePermitted != null ? counterpartyOwnIssuePermitted.hashCode() : 0);
			_result = 31 * _result + (issuerAgencyRating != null ? issuerAgencyRating.hashCode() : 0);
			_result = 31 * _result + (issuerCountryOfOrigin != null ? issuerCountryOfOrigin.hashCode() : 0);
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			_result = 31 * _result + (issuerType != null ? issuerType.hashCode() : 0);
			_result = 31 * _result + (sovereignAgencyRating != null ? sovereignAgencyRating.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerCriteria {" +
				"counterpartyOwnIssuePermitted=" + this.counterpartyOwnIssuePermitted + ", " +
				"issuerAgencyRating=" + this.issuerAgencyRating + ", " +
				"issuerCountryOfOrigin=" + this.issuerCountryOfOrigin + ", " +
				"issuerName=" + this.issuerName + ", " +
				"issuerType=" + this.issuerType + ", " +
				"sovereignAgencyRating=" + this.sovereignAgencyRating +
			'}';
		}
	}
	
	//IssuerCriteria.IssuerCriteriaBuilderImpl
	class IssuerCriteriaBuilderImpl implements IssuerCriteria.IssuerCriteriaBuilder {
	
		protected Boolean counterpartyOwnIssuePermitted;
		protected List<AgencyRatingCriteria.AgencyRatingCriteriaBuilder> issuerAgencyRating = new ArrayList<>();
		protected List<FieldWithMetaStringBuilder> issuerCountryOfOrigin = new ArrayList<>();
		protected List<LegalEntity.LegalEntityBuilder> issuerName = new ArrayList<>();
		protected List<CollateralIssuerType.CollateralIssuerTypeBuilder> issuerType = new ArrayList<>();
		protected List<AgencyRatingCriteria.AgencyRatingCriteriaBuilder> sovereignAgencyRating = new ArrayList<>();
	
		public IssuerCriteriaBuilderImpl() {
		}
	
		@Override
		public Boolean getCounterpartyOwnIssuePermitted() {
			return counterpartyOwnIssuePermitted;
		}
		
		@Override
		public List<? extends AgencyRatingCriteria.AgencyRatingCriteriaBuilder> getIssuerAgencyRating() {
			return issuerAgencyRating;
		}
		
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateIssuerAgencyRating(int _index) {
		
			if (issuerAgencyRating==null) {
				this.issuerAgencyRating = new ArrayList<>();
			}
			AgencyRatingCriteria.AgencyRatingCriteriaBuilder result;
			return getIndex(issuerAgencyRating, _index, () -> {
						AgencyRatingCriteria.AgencyRatingCriteriaBuilder newIssuerAgencyRating = AgencyRatingCriteria.builder();
						return newIssuerAgencyRating;
					});
		}
		
		@Override
		public List<? extends FieldWithMetaStringBuilder> getIssuerCountryOfOrigin() {
			return issuerCountryOfOrigin;
		}
		
		public FieldWithMetaStringBuilder getOrCreateIssuerCountryOfOrigin(int _index) {
		
			if (issuerCountryOfOrigin==null) {
				this.issuerCountryOfOrigin = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(issuerCountryOfOrigin, _index, () -> {
						FieldWithMetaStringBuilder newIssuerCountryOfOrigin = FieldWithMetaString.builder();
						return newIssuerCountryOfOrigin;
					});
		}
		
		@Override
		public List<? extends LegalEntity.LegalEntityBuilder> getIssuerName() {
			return issuerName;
		}
		
		public LegalEntity.LegalEntityBuilder getOrCreateIssuerName(int _index) {
		
			if (issuerName==null) {
				this.issuerName = new ArrayList<>();
			}
			LegalEntity.LegalEntityBuilder result;
			return getIndex(issuerName, _index, () -> {
						LegalEntity.LegalEntityBuilder newIssuerName = LegalEntity.builder();
						return newIssuerName;
					});
		}
		
		@Override
		public List<? extends CollateralIssuerType.CollateralIssuerTypeBuilder> getIssuerType() {
			return issuerType;
		}
		
		public CollateralIssuerType.CollateralIssuerTypeBuilder getOrCreateIssuerType(int _index) {
		
			if (issuerType==null) {
				this.issuerType = new ArrayList<>();
			}
			CollateralIssuerType.CollateralIssuerTypeBuilder result;
			return getIndex(issuerType, _index, () -> {
						CollateralIssuerType.CollateralIssuerTypeBuilder newIssuerType = CollateralIssuerType.builder();
						return newIssuerType;
					});
		}
		
		@Override
		public List<? extends AgencyRatingCriteria.AgencyRatingCriteriaBuilder> getSovereignAgencyRating() {
			return sovereignAgencyRating;
		}
		
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateSovereignAgencyRating(int _index) {
		
			if (sovereignAgencyRating==null) {
				this.sovereignAgencyRating = new ArrayList<>();
			}
			AgencyRatingCriteria.AgencyRatingCriteriaBuilder result;
			return getIndex(sovereignAgencyRating, _index, () -> {
						AgencyRatingCriteria.AgencyRatingCriteriaBuilder newSovereignAgencyRating = AgencyRatingCriteria.builder();
						return newSovereignAgencyRating;
					});
		}
		
	
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder setCounterpartyOwnIssuePermitted(Boolean counterpartyOwnIssuePermitted) {
			this.counterpartyOwnIssuePermitted = counterpartyOwnIssuePermitted==null?null:counterpartyOwnIssuePermitted;
			return this;
		}
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerAgencyRating(AgencyRatingCriteria issuerAgencyRating) {
			if (issuerAgencyRating!=null) this.issuerAgencyRating.add(issuerAgencyRating.toBuilder());
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerAgencyRating(AgencyRatingCriteria issuerAgencyRating, int _idx) {
			getIndex(this.issuerAgencyRating, _idx, () -> issuerAgencyRating.toBuilder());
			return this;
		}
		@Override 
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerAgencyRating(List<? extends AgencyRatingCriteria> issuerAgencyRatings) {
			if (issuerAgencyRatings != null) {
				for (AgencyRatingCriteria toAdd : issuerAgencyRatings) {
					this.issuerAgencyRating.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IssuerCriteria.IssuerCriteriaBuilder setIssuerAgencyRating(List<? extends AgencyRatingCriteria> issuerAgencyRatings) {
			if (issuerAgencyRatings == null)  {
				this.issuerAgencyRating = new ArrayList<>();
			}
			else {
				this.issuerAgencyRating = issuerAgencyRatings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOrigin(FieldWithMetaString issuerCountryOfOrigin) {
			if (issuerCountryOfOrigin!=null) this.issuerCountryOfOrigin.add(issuerCountryOfOrigin.toBuilder());
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOrigin(FieldWithMetaString issuerCountryOfOrigin, int _idx) {
			getIndex(this.issuerCountryOfOrigin, _idx, () -> issuerCountryOfOrigin.toBuilder());
			return this;
		}
		
			@Override
			public IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOriginValue(String issuerCountryOfOrigin) {
				this.getOrCreateIssuerCountryOfOrigin(-1).setValue(issuerCountryOfOrigin);
				return this;
			}
			
			@Override
			public IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOriginValue(String issuerCountryOfOrigin, int _idx) {
				this.getOrCreateIssuerCountryOfOrigin(_idx).setValue(issuerCountryOfOrigin);
				return this;
			}
		@Override 
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOrigin(List<? extends FieldWithMetaString> issuerCountryOfOrigins) {
			if (issuerCountryOfOrigins != null) {
				for (FieldWithMetaString toAdd : issuerCountryOfOrigins) {
					this.issuerCountryOfOrigin.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IssuerCriteria.IssuerCriteriaBuilder setIssuerCountryOfOrigin(List<? extends FieldWithMetaString> issuerCountryOfOrigins) {
			if (issuerCountryOfOrigins == null)  {
				this.issuerCountryOfOrigin = new ArrayList<>();
			}
			else {
				this.issuerCountryOfOrigin = issuerCountryOfOrigins.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerCountryOfOriginValue(List<? extends String> issuerCountryOfOrigins) {
			if (issuerCountryOfOrigins != null) {
				for (String toAdd : issuerCountryOfOrigins) {
					this.addIssuerCountryOfOriginValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder setIssuerCountryOfOriginValue(List<? extends String> issuerCountryOfOrigins) {
			this.issuerCountryOfOrigin.clear();
			if (issuerCountryOfOrigins!=null) {
				issuerCountryOfOrigins.forEach(this::addIssuerCountryOfOriginValue);
			}
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerName(LegalEntity issuerName) {
			if (issuerName!=null) this.issuerName.add(issuerName.toBuilder());
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerName(LegalEntity issuerName, int _idx) {
			getIndex(this.issuerName, _idx, () -> issuerName.toBuilder());
			return this;
		}
		@Override 
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerName(List<? extends LegalEntity> issuerNames) {
			if (issuerNames != null) {
				for (LegalEntity toAdd : issuerNames) {
					this.issuerName.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IssuerCriteria.IssuerCriteriaBuilder setIssuerName(List<? extends LegalEntity> issuerNames) {
			if (issuerNames == null)  {
				this.issuerName = new ArrayList<>();
			}
			else {
				this.issuerName = issuerNames.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerType(CollateralIssuerType issuerType) {
			if (issuerType!=null) this.issuerType.add(issuerType.toBuilder());
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerType(CollateralIssuerType issuerType, int _idx) {
			getIndex(this.issuerType, _idx, () -> issuerType.toBuilder());
			return this;
		}
		@Override 
		public IssuerCriteria.IssuerCriteriaBuilder addIssuerType(List<? extends CollateralIssuerType> issuerTypes) {
			if (issuerTypes != null) {
				for (CollateralIssuerType toAdd : issuerTypes) {
					this.issuerType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IssuerCriteria.IssuerCriteriaBuilder setIssuerType(List<? extends CollateralIssuerType> issuerTypes) {
			if (issuerTypes == null)  {
				this.issuerType = new ArrayList<>();
			}
			else {
				this.issuerType = issuerTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder addSovereignAgencyRating(AgencyRatingCriteria sovereignAgencyRating) {
			if (sovereignAgencyRating!=null) this.sovereignAgencyRating.add(sovereignAgencyRating.toBuilder());
			return this;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder addSovereignAgencyRating(AgencyRatingCriteria sovereignAgencyRating, int _idx) {
			getIndex(this.sovereignAgencyRating, _idx, () -> sovereignAgencyRating.toBuilder());
			return this;
		}
		@Override 
		public IssuerCriteria.IssuerCriteriaBuilder addSovereignAgencyRating(List<? extends AgencyRatingCriteria> sovereignAgencyRatings) {
			if (sovereignAgencyRatings != null) {
				for (AgencyRatingCriteria toAdd : sovereignAgencyRatings) {
					this.sovereignAgencyRating.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IssuerCriteria.IssuerCriteriaBuilder setSovereignAgencyRating(List<? extends AgencyRatingCriteria> sovereignAgencyRatings) {
			if (sovereignAgencyRatings == null)  {
				this.sovereignAgencyRating = new ArrayList<>();
			}
			else {
				this.sovereignAgencyRating = sovereignAgencyRatings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public IssuerCriteria build() {
			return new IssuerCriteria.IssuerCriteriaImpl(this);
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder prune() {
			issuerAgencyRating = issuerAgencyRating.stream().filter(b->b!=null).<AgencyRatingCriteria.AgencyRatingCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			issuerCountryOfOrigin = issuerCountryOfOrigin.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			issuerName = issuerName.stream().filter(b->b!=null).<LegalEntity.LegalEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			issuerType = issuerType.stream().filter(b->b!=null).<CollateralIssuerType.CollateralIssuerTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			sovereignAgencyRating = sovereignAgencyRating.stream().filter(b->b!=null).<AgencyRatingCriteria.AgencyRatingCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCounterpartyOwnIssuePermitted()!=null) return true;
			if (getIssuerAgencyRating()!=null && getIssuerAgencyRating().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIssuerCountryOfOrigin()!=null && !getIssuerCountryOfOrigin().isEmpty()) return true;
			if (getIssuerName()!=null && getIssuerName().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIssuerType()!=null && getIssuerType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSovereignAgencyRating()!=null && getSovereignAgencyRating().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IssuerCriteria.IssuerCriteriaBuilder o = (IssuerCriteria.IssuerCriteriaBuilder) other;
			
			merger.mergeRosetta(getIssuerAgencyRating(), o.getIssuerAgencyRating(), this::getOrCreateIssuerAgencyRating);
			merger.mergeRosetta(getIssuerCountryOfOrigin(), o.getIssuerCountryOfOrigin(), this::getOrCreateIssuerCountryOfOrigin);
			merger.mergeRosetta(getIssuerName(), o.getIssuerName(), this::getOrCreateIssuerName);
			merger.mergeRosetta(getIssuerType(), o.getIssuerType(), this::getOrCreateIssuerType);
			merger.mergeRosetta(getSovereignAgencyRating(), o.getSovereignAgencyRating(), this::getOrCreateSovereignAgencyRating);
			
			merger.mergeBasic(getCounterpartyOwnIssuePermitted(), o.getCounterpartyOwnIssuePermitted(), this::setCounterpartyOwnIssuePermitted);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerCriteria _that = getType().cast(o);
		
			if (!Objects.equals(counterpartyOwnIssuePermitted, _that.getCounterpartyOwnIssuePermitted())) return false;
			if (!ListEquals.listEquals(issuerAgencyRating, _that.getIssuerAgencyRating())) return false;
			if (!ListEquals.listEquals(issuerCountryOfOrigin, _that.getIssuerCountryOfOrigin())) return false;
			if (!ListEquals.listEquals(issuerName, _that.getIssuerName())) return false;
			if (!ListEquals.listEquals(issuerType, _that.getIssuerType())) return false;
			if (!ListEquals.listEquals(sovereignAgencyRating, _that.getSovereignAgencyRating())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (counterpartyOwnIssuePermitted != null ? counterpartyOwnIssuePermitted.hashCode() : 0);
			_result = 31 * _result + (issuerAgencyRating != null ? issuerAgencyRating.hashCode() : 0);
			_result = 31 * _result + (issuerCountryOfOrigin != null ? issuerCountryOfOrigin.hashCode() : 0);
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			_result = 31 * _result + (issuerType != null ? issuerType.hashCode() : 0);
			_result = 31 * _result + (sovereignAgencyRating != null ? sovereignAgencyRating.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerCriteriaBuilder {" +
				"counterpartyOwnIssuePermitted=" + this.counterpartyOwnIssuePermitted + ", " +
				"issuerAgencyRating=" + this.issuerAgencyRating + ", " +
				"issuerCountryOfOrigin=" + this.issuerCountryOfOrigin + ", " +
				"issuerName=" + this.issuerName + ", " +
				"issuerType=" + this.issuerType + ", " +
				"sovereignAgencyRating=" + this.sovereignAgencyRating +
			'}';
		}
	}
}
