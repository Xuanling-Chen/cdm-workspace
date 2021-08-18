package cdm.observable.asset;

import cdm.base.math.QuantifierEnum;
import cdm.observable.asset.meta.MultipleCreditNotationsMeta;
import cdm.observable.asset.metafields.FieldWithMetaCreditNotation;
import cdm.observable.asset.metafields.FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder;
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

public interface MultipleCreditNotations extends RosettaModelObject {
	MultipleCreditNotations build();
	MultipleCreditNotations.MultipleCreditNotationsBuilder toBuilder();
	
	/**
	 * An enumerated element, to qualify whether All or Any credit notation applies.
	 */
	QuantifierEnum getCondition();
	/**
	 * At least two credit notations much be specified.
	 */
	List<? extends FieldWithMetaCreditNotation> getCreditNotation();
	/**
	 */
	CreditNotationMismatchResolutionEnum getMismatchResolution();
	/**
	 */
	CreditRatingAgencyEnum getReferenceAgency();
	final static MultipleCreditNotationsMeta metaData = new MultipleCreditNotationsMeta();
	
	@Override
	default RosettaMetaData<? extends MultipleCreditNotations> metaData() {
		return metaData;
	} 
			
	static MultipleCreditNotations.MultipleCreditNotationsBuilder builder() {
		return new MultipleCreditNotations.MultipleCreditNotationsBuilderImpl();
	}
	
	default Class<? extends MultipleCreditNotations> getType() {
		return MultipleCreditNotations.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), QuantifierEnum.class, getCondition(), this);
		processor.processBasic(path.newSubPath("mismatchResolution"), CreditNotationMismatchResolutionEnum.class, getMismatchResolution(), this);
		processor.processBasic(path.newSubPath("referenceAgency"), CreditRatingAgencyEnum.class, getReferenceAgency(), this);
		
		processRosetta(path.newSubPath("creditNotation"), processor, FieldWithMetaCreditNotation.class, getCreditNotation());
	}
	
	
	interface MultipleCreditNotationsBuilder extends MultipleCreditNotations, RosettaModelObjectBuilder {
		FieldWithMetaCreditNotationBuilder getOrCreateCreditNotation(int _index);
		List<? extends FieldWithMetaCreditNotationBuilder> getCreditNotation();
		MultipleCreditNotations.MultipleCreditNotationsBuilder setCondition(QuantifierEnum condition);
		MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotation(FieldWithMetaCreditNotation creditNotation);
		MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotation(FieldWithMetaCreditNotation creditNotation, int _idx);
		MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotationValue(CreditNotation creditNotation);
		MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotationValue(CreditNotation creditNotation, int _idx);
		MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotation(List<? extends FieldWithMetaCreditNotation> creditNotation);
		MultipleCreditNotations.MultipleCreditNotationsBuilder setCreditNotation(List<? extends FieldWithMetaCreditNotation> creditNotation);
		MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotationValue(List<? extends CreditNotation> creditNotation);
		MultipleCreditNotations.MultipleCreditNotationsBuilder setCreditNotationValue(List<? extends CreditNotation> creditNotation);
		MultipleCreditNotations.MultipleCreditNotationsBuilder setMismatchResolution(CreditNotationMismatchResolutionEnum mismatchResolution);
		MultipleCreditNotations.MultipleCreditNotationsBuilder setReferenceAgency(CreditRatingAgencyEnum referenceAgency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("condition"), QuantifierEnum.class, getCondition(), this);
			processor.processBasic(path.newSubPath("mismatchResolution"), CreditNotationMismatchResolutionEnum.class, getMismatchResolution(), this);
			processor.processBasic(path.newSubPath("referenceAgency"), CreditRatingAgencyEnum.class, getReferenceAgency(), this);
			
			processRosetta(path.newSubPath("creditNotation"), processor, FieldWithMetaCreditNotationBuilder.class, getCreditNotation());
		}
		
	}
	
	//MultipleCreditNotations.MultipleCreditNotationsImpl
	class MultipleCreditNotationsImpl implements MultipleCreditNotations {
		private final QuantifierEnum condition;
		private final List<? extends FieldWithMetaCreditNotation> creditNotation;
		private final CreditNotationMismatchResolutionEnum mismatchResolution;
		private final CreditRatingAgencyEnum referenceAgency;
		
		protected MultipleCreditNotationsImpl(MultipleCreditNotations.MultipleCreditNotationsBuilder builder) {
			this.condition = builder.getCondition();
			this.creditNotation = ofNullable(builder.getCreditNotation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.mismatchResolution = builder.getMismatchResolution();
			this.referenceAgency = builder.getReferenceAgency();
		}
		
		@Override
		public QuantifierEnum getCondition() {
			return condition;
		}
		
		@Override
		public List<? extends FieldWithMetaCreditNotation> getCreditNotation() {
			return creditNotation;
		}
		
		@Override
		public CreditNotationMismatchResolutionEnum getMismatchResolution() {
			return mismatchResolution;
		}
		
		@Override
		public CreditRatingAgencyEnum getReferenceAgency() {
			return referenceAgency;
		}
		
		@Override
		public MultipleCreditNotations build() {
			return this;
		}
		
		@Override
		public MultipleCreditNotations.MultipleCreditNotationsBuilder toBuilder() {
			MultipleCreditNotations.MultipleCreditNotationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MultipleCreditNotations.MultipleCreditNotationsBuilder builder) {
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getCreditNotation()).ifPresent(builder::setCreditNotation);
			ofNullable(getMismatchResolution()).ifPresent(builder::setMismatchResolution);
			ofNullable(getReferenceAgency()).ifPresent(builder::setReferenceAgency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MultipleCreditNotations _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!ListEquals.listEquals(creditNotation, _that.getCreditNotation())) return false;
			if (!Objects.equals(mismatchResolution, _that.getMismatchResolution())) return false;
			if (!Objects.equals(referenceAgency, _that.getReferenceAgency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditNotation != null ? creditNotation.hashCode() : 0);
			_result = 31 * _result + (mismatchResolution != null ? mismatchResolution.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceAgency != null ? referenceAgency.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultipleCreditNotations {" +
				"condition=" + this.condition + ", " +
				"creditNotation=" + this.creditNotation + ", " +
				"mismatchResolution=" + this.mismatchResolution + ", " +
				"referenceAgency=" + this.referenceAgency +
			'}';
		}
	}
	
	//MultipleCreditNotations.MultipleCreditNotationsBuilderImpl
	class MultipleCreditNotationsBuilderImpl implements MultipleCreditNotations.MultipleCreditNotationsBuilder {
	
		protected QuantifierEnum condition;
		protected List<FieldWithMetaCreditNotationBuilder> creditNotation = new ArrayList<>();
		protected CreditNotationMismatchResolutionEnum mismatchResolution;
		protected CreditRatingAgencyEnum referenceAgency;
	
		public MultipleCreditNotationsBuilderImpl() {
		}
	
		@Override
		public QuantifierEnum getCondition() {
			return condition;
		}
		
		@Override
		public List<? extends FieldWithMetaCreditNotationBuilder> getCreditNotation() {
			return creditNotation;
		}
		
		public FieldWithMetaCreditNotationBuilder getOrCreateCreditNotation(int _index) {
		
			if (creditNotation==null) {
				this.creditNotation = new ArrayList<>();
			}
			FieldWithMetaCreditNotationBuilder result;
			return getIndex(creditNotation, _index, () -> {
						FieldWithMetaCreditNotationBuilder newCreditNotation = FieldWithMetaCreditNotation.builder();
						return newCreditNotation;
					});
		}
		
		@Override
		public CreditNotationMismatchResolutionEnum getMismatchResolution() {
			return mismatchResolution;
		}
		
		@Override
		public CreditRatingAgencyEnum getReferenceAgency() {
			return referenceAgency;
		}
		
	
		@Override
		public MultipleCreditNotations.MultipleCreditNotationsBuilder setCondition(QuantifierEnum condition) {
			this.condition = condition==null?null:condition;
			return this;
		}
		@Override
		public MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotation(FieldWithMetaCreditNotation creditNotation) {
			if (creditNotation!=null) this.creditNotation.add(creditNotation.toBuilder());
			return this;
		}
		
		@Override
		public MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotation(FieldWithMetaCreditNotation creditNotation, int _idx) {
			getIndex(this.creditNotation, _idx, () -> creditNotation.toBuilder());
			return this;
		}
		
			@Override
			public MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotationValue(CreditNotation creditNotation) {
				this.getOrCreateCreditNotation(-1).setValue(creditNotation.toBuilder());
				return this;
			}
			
			@Override
			public MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotationValue(CreditNotation creditNotation, int _idx) {
				this.getOrCreateCreditNotation(_idx).setValue(creditNotation.toBuilder());
				return this;
			}
		@Override 
		public MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotation(List<? extends FieldWithMetaCreditNotation> creditNotations) {
			if (creditNotations != null) {
				for (FieldWithMetaCreditNotation toAdd : creditNotations) {
					this.creditNotation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MultipleCreditNotations.MultipleCreditNotationsBuilder setCreditNotation(List<? extends FieldWithMetaCreditNotation> creditNotations) {
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
		public MultipleCreditNotations.MultipleCreditNotationsBuilder addCreditNotationValue(List<? extends CreditNotation> creditNotations) {
			if (creditNotations != null) {
				for (CreditNotation toAdd : creditNotations) {
					this.addCreditNotationValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public MultipleCreditNotations.MultipleCreditNotationsBuilder setCreditNotationValue(List<? extends CreditNotation> creditNotations) {
			this.creditNotation.clear();
			if (creditNotations!=null) {
				creditNotations.forEach(this::addCreditNotationValue);
			}
			return this;
		}
		
		@Override
		public MultipleCreditNotations.MultipleCreditNotationsBuilder setMismatchResolution(CreditNotationMismatchResolutionEnum mismatchResolution) {
			this.mismatchResolution = mismatchResolution==null?null:mismatchResolution;
			return this;
		}
		@Override
		public MultipleCreditNotations.MultipleCreditNotationsBuilder setReferenceAgency(CreditRatingAgencyEnum referenceAgency) {
			this.referenceAgency = referenceAgency==null?null:referenceAgency;
			return this;
		}
		
		@Override
		public MultipleCreditNotations build() {
			return new MultipleCreditNotations.MultipleCreditNotationsImpl(this);
		}
		
		@Override
		public MultipleCreditNotations.MultipleCreditNotationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultipleCreditNotations.MultipleCreditNotationsBuilder prune() {
			creditNotation = creditNotation.stream().filter(b->b!=null).<FieldWithMetaCreditNotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCondition()!=null) return true;
			if (getCreditNotation()!=null && getCreditNotation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMismatchResolution()!=null) return true;
			if (getReferenceAgency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultipleCreditNotations.MultipleCreditNotationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MultipleCreditNotations.MultipleCreditNotationsBuilder o = (MultipleCreditNotations.MultipleCreditNotationsBuilder) other;
			
			merger.mergeRosetta(getCreditNotation(), o.getCreditNotation(), this::getOrCreateCreditNotation);
			
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			merger.mergeBasic(getMismatchResolution(), o.getMismatchResolution(), this::setMismatchResolution);
			merger.mergeBasic(getReferenceAgency(), o.getReferenceAgency(), this::setReferenceAgency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MultipleCreditNotations _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!ListEquals.listEquals(creditNotation, _that.getCreditNotation())) return false;
			if (!Objects.equals(mismatchResolution, _that.getMismatchResolution())) return false;
			if (!Objects.equals(referenceAgency, _that.getReferenceAgency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditNotation != null ? creditNotation.hashCode() : 0);
			_result = 31 * _result + (mismatchResolution != null ? mismatchResolution.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceAgency != null ? referenceAgency.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultipleCreditNotationsBuilder {" +
				"condition=" + this.condition + ", " +
				"creditNotation=" + this.creditNotation + ", " +
				"mismatchResolution=" + this.mismatchResolution + ", " +
				"referenceAgency=" + this.referenceAgency +
			'}';
		}
	}
}
