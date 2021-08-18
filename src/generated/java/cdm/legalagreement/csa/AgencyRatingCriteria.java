package cdm.legalagreement.csa;

import cdm.base.math.QuantifierEnum;
import cdm.legalagreement.csa.meta.AgencyRatingCriteriaMeta;
import cdm.observable.asset.CreditNotation;
import cdm.observable.asset.CreditNotationBoundaryEnum;
import cdm.observable.asset.CreditNotationMismatchResolutionEnum;
import cdm.observable.asset.CreditRatingAgencyEnum;
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
 * A class to specify multiple credit notations alongside a conditional &#39;any&#39; or &#39;all&#39; qualifier.
 * @version ${project.version}
 */
@RosettaClass

public interface AgencyRatingCriteria extends RosettaModelObject {
	AgencyRatingCriteria build();
	AgencyRatingCriteria.AgencyRatingCriteriaBuilder toBuilder();
	
	/**
	 * Indicates the boundary of a credit agency rating i.e minimum or maximum.
	 */
	CreditNotationBoundaryEnum getBoundary();
	/**
	 * Indicates the agency rating criteria specified for the asset or issuer.
	 */
	List<? extends CreditNotation> getCreditNotation();
	/**
	 * Indicator for options to be used if several agency ratings (&gt;1) are specified and its necessary to identify specific charateristics. i.e (lowest or highest).
	 */
	CreditNotationMismatchResolutionEnum getMismatchResolution();
	/**
	 * Indicates whether all or any agency ratings apply.
	 */
	QuantifierEnum getQualifier();
	/**
	 * To identify The dominant reference agency if there is a missmatch and several reference agencies exsist.
	 */
	CreditRatingAgencyEnum getReferenceAgency();
	final static AgencyRatingCriteriaMeta metaData = new AgencyRatingCriteriaMeta();
	
	@Override
	default RosettaMetaData<? extends AgencyRatingCriteria> metaData() {
		return metaData;
	} 
			
	static AgencyRatingCriteria.AgencyRatingCriteriaBuilder builder() {
		return new AgencyRatingCriteria.AgencyRatingCriteriaBuilderImpl();
	}
	
	default Class<? extends AgencyRatingCriteria> getType() {
		return AgencyRatingCriteria.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("boundary"), CreditNotationBoundaryEnum.class, getBoundary(), this);
		processor.processBasic(path.newSubPath("mismatchResolution"), CreditNotationMismatchResolutionEnum.class, getMismatchResolution(), this);
		processor.processBasic(path.newSubPath("qualifier"), QuantifierEnum.class, getQualifier(), this);
		processor.processBasic(path.newSubPath("referenceAgency"), CreditRatingAgencyEnum.class, getReferenceAgency(), this);
		
		processRosetta(path.newSubPath("creditNotation"), processor, CreditNotation.class, getCreditNotation());
	}
	
	
	interface AgencyRatingCriteriaBuilder extends AgencyRatingCriteria, RosettaModelObjectBuilder {
		CreditNotation.CreditNotationBuilder getOrCreateCreditNotation(int _index);
		List<? extends CreditNotation.CreditNotationBuilder> getCreditNotation();
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder setBoundary(CreditNotationBoundaryEnum boundary);
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder addCreditNotation(CreditNotation creditNotation);
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder addCreditNotation(CreditNotation creditNotation, int _idx);
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder addCreditNotation(List<? extends CreditNotation> creditNotation);
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder setCreditNotation(List<? extends CreditNotation> creditNotation);
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder setMismatchResolution(CreditNotationMismatchResolutionEnum mismatchResolution);
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder setQualifier(QuantifierEnum qualifier);
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder setReferenceAgency(CreditRatingAgencyEnum referenceAgency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("boundary"), CreditNotationBoundaryEnum.class, getBoundary(), this);
			processor.processBasic(path.newSubPath("mismatchResolution"), CreditNotationMismatchResolutionEnum.class, getMismatchResolution(), this);
			processor.processBasic(path.newSubPath("qualifier"), QuantifierEnum.class, getQualifier(), this);
			processor.processBasic(path.newSubPath("referenceAgency"), CreditRatingAgencyEnum.class, getReferenceAgency(), this);
			
			processRosetta(path.newSubPath("creditNotation"), processor, CreditNotation.CreditNotationBuilder.class, getCreditNotation());
		}
		
	}
	
	//AgencyRatingCriteria.AgencyRatingCriteriaImpl
	class AgencyRatingCriteriaImpl implements AgencyRatingCriteria {
		private final CreditNotationBoundaryEnum boundary;
		private final List<? extends CreditNotation> creditNotation;
		private final CreditNotationMismatchResolutionEnum mismatchResolution;
		private final QuantifierEnum qualifier;
		private final CreditRatingAgencyEnum referenceAgency;
		
		protected AgencyRatingCriteriaImpl(AgencyRatingCriteria.AgencyRatingCriteriaBuilder builder) {
			this.boundary = builder.getBoundary();
			this.creditNotation = ofNullable(builder.getCreditNotation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.mismatchResolution = builder.getMismatchResolution();
			this.qualifier = builder.getQualifier();
			this.referenceAgency = builder.getReferenceAgency();
		}
		
		@Override
		public CreditNotationBoundaryEnum getBoundary() {
			return boundary;
		}
		
		@Override
		public List<? extends CreditNotation> getCreditNotation() {
			return creditNotation;
		}
		
		@Override
		public CreditNotationMismatchResolutionEnum getMismatchResolution() {
			return mismatchResolution;
		}
		
		@Override
		public QuantifierEnum getQualifier() {
			return qualifier;
		}
		
		@Override
		public CreditRatingAgencyEnum getReferenceAgency() {
			return referenceAgency;
		}
		
		@Override
		public AgencyRatingCriteria build() {
			return this;
		}
		
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder toBuilder() {
			AgencyRatingCriteria.AgencyRatingCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgencyRatingCriteria.AgencyRatingCriteriaBuilder builder) {
			ofNullable(getBoundary()).ifPresent(builder::setBoundary);
			ofNullable(getCreditNotation()).ifPresent(builder::setCreditNotation);
			ofNullable(getMismatchResolution()).ifPresent(builder::setMismatchResolution);
			ofNullable(getQualifier()).ifPresent(builder::setQualifier);
			ofNullable(getReferenceAgency()).ifPresent(builder::setReferenceAgency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgencyRatingCriteria _that = getType().cast(o);
		
			if (!Objects.equals(boundary, _that.getBoundary())) return false;
			if (!ListEquals.listEquals(creditNotation, _that.getCreditNotation())) return false;
			if (!Objects.equals(mismatchResolution, _that.getMismatchResolution())) return false;
			if (!Objects.equals(qualifier, _that.getQualifier())) return false;
			if (!Objects.equals(referenceAgency, _that.getReferenceAgency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (boundary != null ? boundary.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditNotation != null ? creditNotation.hashCode() : 0);
			_result = 31 * _result + (mismatchResolution != null ? mismatchResolution.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (qualifier != null ? qualifier.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceAgency != null ? referenceAgency.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgencyRatingCriteria {" +
				"boundary=" + this.boundary + ", " +
				"creditNotation=" + this.creditNotation + ", " +
				"mismatchResolution=" + this.mismatchResolution + ", " +
				"qualifier=" + this.qualifier + ", " +
				"referenceAgency=" + this.referenceAgency +
			'}';
		}
	}
	
	//AgencyRatingCriteria.AgencyRatingCriteriaBuilderImpl
	class AgencyRatingCriteriaBuilderImpl implements AgencyRatingCriteria.AgencyRatingCriteriaBuilder {
	
		protected CreditNotationBoundaryEnum boundary;
		protected List<CreditNotation.CreditNotationBuilder> creditNotation = new ArrayList<>();
		protected CreditNotationMismatchResolutionEnum mismatchResolution;
		protected QuantifierEnum qualifier;
		protected CreditRatingAgencyEnum referenceAgency;
	
		public AgencyRatingCriteriaBuilderImpl() {
		}
	
		@Override
		public CreditNotationBoundaryEnum getBoundary() {
			return boundary;
		}
		
		@Override
		public List<? extends CreditNotation.CreditNotationBuilder> getCreditNotation() {
			return creditNotation;
		}
		
		public CreditNotation.CreditNotationBuilder getOrCreateCreditNotation(int _index) {
		
			if (creditNotation==null) {
				this.creditNotation = new ArrayList<>();
			}
			CreditNotation.CreditNotationBuilder result;
			return getIndex(creditNotation, _index, () -> {
						CreditNotation.CreditNotationBuilder newCreditNotation = CreditNotation.builder();
						return newCreditNotation;
					});
		}
		
		@Override
		public CreditNotationMismatchResolutionEnum getMismatchResolution() {
			return mismatchResolution;
		}
		
		@Override
		public QuantifierEnum getQualifier() {
			return qualifier;
		}
		
		@Override
		public CreditRatingAgencyEnum getReferenceAgency() {
			return referenceAgency;
		}
		
	
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder setBoundary(CreditNotationBoundaryEnum boundary) {
			this.boundary = boundary==null?null:boundary;
			return this;
		}
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder addCreditNotation(CreditNotation creditNotation) {
			if (creditNotation!=null) this.creditNotation.add(creditNotation.toBuilder());
			return this;
		}
		
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder addCreditNotation(CreditNotation creditNotation, int _idx) {
			getIndex(this.creditNotation, _idx, () -> creditNotation.toBuilder());
			return this;
		}
		@Override 
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder addCreditNotation(List<? extends CreditNotation> creditNotations) {
			if (creditNotations != null) {
				for (CreditNotation toAdd : creditNotations) {
					this.creditNotation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder setCreditNotation(List<? extends CreditNotation> creditNotations) {
			if (creditNotations == null)  {
				this.creditNotation = new ArrayList<>();
			}
			else {
				this.creditNotation = creditNotations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder setMismatchResolution(CreditNotationMismatchResolutionEnum mismatchResolution) {
			this.mismatchResolution = mismatchResolution==null?null:mismatchResolution;
			return this;
		}
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder setQualifier(QuantifierEnum qualifier) {
			this.qualifier = qualifier==null?null:qualifier;
			return this;
		}
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder setReferenceAgency(CreditRatingAgencyEnum referenceAgency) {
			this.referenceAgency = referenceAgency==null?null:referenceAgency;
			return this;
		}
		
		@Override
		public AgencyRatingCriteria build() {
			return new AgencyRatingCriteria.AgencyRatingCriteriaImpl(this);
		}
		
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder prune() {
			creditNotation = creditNotation.stream().filter(b->b!=null).<CreditNotation.CreditNotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBoundary()!=null) return true;
			if (getCreditNotation()!=null && getCreditNotation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMismatchResolution()!=null) return true;
			if (getQualifier()!=null) return true;
			if (getReferenceAgency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgencyRatingCriteria.AgencyRatingCriteriaBuilder o = (AgencyRatingCriteria.AgencyRatingCriteriaBuilder) other;
			
			merger.mergeRosetta(getCreditNotation(), o.getCreditNotation(), this::getOrCreateCreditNotation);
			
			merger.mergeBasic(getBoundary(), o.getBoundary(), this::setBoundary);
			merger.mergeBasic(getMismatchResolution(), o.getMismatchResolution(), this::setMismatchResolution);
			merger.mergeBasic(getQualifier(), o.getQualifier(), this::setQualifier);
			merger.mergeBasic(getReferenceAgency(), o.getReferenceAgency(), this::setReferenceAgency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgencyRatingCriteria _that = getType().cast(o);
		
			if (!Objects.equals(boundary, _that.getBoundary())) return false;
			if (!ListEquals.listEquals(creditNotation, _that.getCreditNotation())) return false;
			if (!Objects.equals(mismatchResolution, _that.getMismatchResolution())) return false;
			if (!Objects.equals(qualifier, _that.getQualifier())) return false;
			if (!Objects.equals(referenceAgency, _that.getReferenceAgency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (boundary != null ? boundary.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditNotation != null ? creditNotation.hashCode() : 0);
			_result = 31 * _result + (mismatchResolution != null ? mismatchResolution.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (qualifier != null ? qualifier.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceAgency != null ? referenceAgency.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgencyRatingCriteriaBuilder {" +
				"boundary=" + this.boundary + ", " +
				"creditNotation=" + this.creditNotation + ", " +
				"mismatchResolution=" + this.mismatchResolution + ", " +
				"qualifier=" + this.qualifier + ", " +
				"referenceAgency=" + this.referenceAgency +
			'}';
		}
	}
}
