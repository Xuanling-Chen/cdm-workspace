package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CollateralTreatmentMeta;
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
 * Specifies the treatment terms for the eligible collateral criteria specified.
 * @version ${project.version}
 */
@RosettaClass

public interface CollateralTreatment extends RosettaModelObject {
	CollateralTreatment build();
	CollateralTreatment.CollateralTreatmentBuilder toBuilder();
	
	/**
	 * Specification of concentration limits applicable to the collateral criteria.
	 */
	List<? extends ConcentrationLimit> getConcentrationLimit();
	/**
	 * A boolean attribute to specify whether collateral critieria are inclusion (True) or exclusion (False) criteria
	 */
	Boolean getIsIncluded();
	/**
	 * Specification of the valuation treatment for the specified collateral.
	 */
	CollateralValuationTreatment getValuationTreatment();
	final static CollateralTreatmentMeta metaData = new CollateralTreatmentMeta();
	
	@Override
	default RosettaMetaData<? extends CollateralTreatment> metaData() {
		return metaData;
	} 
			
	static CollateralTreatment.CollateralTreatmentBuilder builder() {
		return new CollateralTreatment.CollateralTreatmentBuilderImpl();
	}
	
	default Class<? extends CollateralTreatment> getType() {
		return CollateralTreatment.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isIncluded"), Boolean.class, getIsIncluded(), this);
		
		processRosetta(path.newSubPath("concentrationLimit"), processor, ConcentrationLimit.class, getConcentrationLimit());
		processRosetta(path.newSubPath("valuationTreatment"), processor, CollateralValuationTreatment.class, getValuationTreatment());
	}
	
	
	interface CollateralTreatmentBuilder extends CollateralTreatment, RosettaModelObjectBuilder {
		ConcentrationLimit.ConcentrationLimitBuilder getOrCreateConcentrationLimit(int _index);
		List<? extends ConcentrationLimit.ConcentrationLimitBuilder> getConcentrationLimit();
		CollateralValuationTreatment.CollateralValuationTreatmentBuilder getOrCreateValuationTreatment();
		CollateralValuationTreatment.CollateralValuationTreatmentBuilder getValuationTreatment();
		CollateralTreatment.CollateralTreatmentBuilder addConcentrationLimit(ConcentrationLimit concentrationLimit);
		CollateralTreatment.CollateralTreatmentBuilder addConcentrationLimit(ConcentrationLimit concentrationLimit, int _idx);
		CollateralTreatment.CollateralTreatmentBuilder addConcentrationLimit(List<? extends ConcentrationLimit> concentrationLimit);
		CollateralTreatment.CollateralTreatmentBuilder setConcentrationLimit(List<? extends ConcentrationLimit> concentrationLimit);
		CollateralTreatment.CollateralTreatmentBuilder setIsIncluded(Boolean isIncluded);
		CollateralTreatment.CollateralTreatmentBuilder setValuationTreatment(CollateralValuationTreatment valuationTreatment);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isIncluded"), Boolean.class, getIsIncluded(), this);
			
			processRosetta(path.newSubPath("concentrationLimit"), processor, ConcentrationLimit.ConcentrationLimitBuilder.class, getConcentrationLimit());
			processRosetta(path.newSubPath("valuationTreatment"), processor, CollateralValuationTreatment.CollateralValuationTreatmentBuilder.class, getValuationTreatment());
		}
		
	}
	
	//CollateralTreatment.CollateralTreatmentImpl
	class CollateralTreatmentImpl implements CollateralTreatment {
		private final List<? extends ConcentrationLimit> concentrationLimit;
		private final Boolean isIncluded;
		private final CollateralValuationTreatment valuationTreatment;
		
		protected CollateralTreatmentImpl(CollateralTreatment.CollateralTreatmentBuilder builder) {
			this.concentrationLimit = ofNullable(builder.getConcentrationLimit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.isIncluded = builder.getIsIncluded();
			this.valuationTreatment = ofNullable(builder.getValuationTreatment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends ConcentrationLimit> getConcentrationLimit() {
			return concentrationLimit;
		}
		
		@Override
		public Boolean getIsIncluded() {
			return isIncluded;
		}
		
		@Override
		public CollateralValuationTreatment getValuationTreatment() {
			return valuationTreatment;
		}
		
		@Override
		public CollateralTreatment build() {
			return this;
		}
		
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder toBuilder() {
			CollateralTreatment.CollateralTreatmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralTreatment.CollateralTreatmentBuilder builder) {
			ofNullable(getConcentrationLimit()).ifPresent(builder::setConcentrationLimit);
			ofNullable(getIsIncluded()).ifPresent(builder::setIsIncluded);
			ofNullable(getValuationTreatment()).ifPresent(builder::setValuationTreatment);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralTreatment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(concentrationLimit, _that.getConcentrationLimit())) return false;
			if (!Objects.equals(isIncluded, _that.getIsIncluded())) return false;
			if (!Objects.equals(valuationTreatment, _that.getValuationTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (concentrationLimit != null ? concentrationLimit.hashCode() : 0);
			_result = 31 * _result + (isIncluded != null ? isIncluded.hashCode() : 0);
			_result = 31 * _result + (valuationTreatment != null ? valuationTreatment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralTreatment {" +
				"concentrationLimit=" + this.concentrationLimit + ", " +
				"isIncluded=" + this.isIncluded + ", " +
				"valuationTreatment=" + this.valuationTreatment +
			'}';
		}
	}
	
	//CollateralTreatment.CollateralTreatmentBuilderImpl
	class CollateralTreatmentBuilderImpl implements CollateralTreatment.CollateralTreatmentBuilder {
	
		protected List<ConcentrationLimit.ConcentrationLimitBuilder> concentrationLimit = new ArrayList<>();
		protected Boolean isIncluded;
		protected CollateralValuationTreatment.CollateralValuationTreatmentBuilder valuationTreatment;
	
		public CollateralTreatmentBuilderImpl() {
		}
	
		@Override
		public List<? extends ConcentrationLimit.ConcentrationLimitBuilder> getConcentrationLimit() {
			return concentrationLimit;
		}
		
		public ConcentrationLimit.ConcentrationLimitBuilder getOrCreateConcentrationLimit(int _index) {
		
			if (concentrationLimit==null) {
				this.concentrationLimit = new ArrayList<>();
			}
			ConcentrationLimit.ConcentrationLimitBuilder result;
			return getIndex(concentrationLimit, _index, () -> {
						ConcentrationLimit.ConcentrationLimitBuilder newConcentrationLimit = ConcentrationLimit.builder();
						return newConcentrationLimit;
					});
		}
		
		@Override
		public Boolean getIsIncluded() {
			return isIncluded;
		}
		
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder getValuationTreatment() {
			return valuationTreatment;
		}
		
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder getOrCreateValuationTreatment() {
			CollateralValuationTreatment.CollateralValuationTreatmentBuilder result;
			if (valuationTreatment!=null) {
				result = valuationTreatment;
			}
			else {
				result = valuationTreatment = CollateralValuationTreatment.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder addConcentrationLimit(ConcentrationLimit concentrationLimit) {
			if (concentrationLimit!=null) this.concentrationLimit.add(concentrationLimit.toBuilder());
			return this;
		}
		
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder addConcentrationLimit(ConcentrationLimit concentrationLimit, int _idx) {
			getIndex(this.concentrationLimit, _idx, () -> concentrationLimit.toBuilder());
			return this;
		}
		@Override 
		public CollateralTreatment.CollateralTreatmentBuilder addConcentrationLimit(List<? extends ConcentrationLimit> concentrationLimits) {
			if (concentrationLimits != null) {
				for (ConcentrationLimit toAdd : concentrationLimits) {
					this.concentrationLimit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CollateralTreatment.CollateralTreatmentBuilder setConcentrationLimit(List<? extends ConcentrationLimit> concentrationLimits) {
			if (concentrationLimits == null)  {
				this.concentrationLimit = new ArrayList<>();
			}
			else {
				this.concentrationLimit = concentrationLimits.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder setIsIncluded(Boolean isIncluded) {
			this.isIncluded = isIncluded==null?null:isIncluded;
			return this;
		}
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder setValuationTreatment(CollateralValuationTreatment valuationTreatment) {
			this.valuationTreatment = valuationTreatment==null?null:valuationTreatment.toBuilder();
			return this;
		}
		
		@Override
		public CollateralTreatment build() {
			return new CollateralTreatment.CollateralTreatmentImpl(this);
		}
		
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder prune() {
			concentrationLimit = concentrationLimit.stream().filter(b->b!=null).<ConcentrationLimit.ConcentrationLimitBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (valuationTreatment!=null && !valuationTreatment.prune().hasData()) valuationTreatment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConcentrationLimit()!=null && getConcentrationLimit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIsIncluded()!=null) return true;
			if (getValuationTreatment()!=null && getValuationTreatment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralTreatment.CollateralTreatmentBuilder o = (CollateralTreatment.CollateralTreatmentBuilder) other;
			
			merger.mergeRosetta(getConcentrationLimit(), o.getConcentrationLimit(), this::getOrCreateConcentrationLimit);
			merger.mergeRosetta(getValuationTreatment(), o.getValuationTreatment(), this::setValuationTreatment);
			
			merger.mergeBasic(getIsIncluded(), o.getIsIncluded(), this::setIsIncluded);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralTreatment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(concentrationLimit, _that.getConcentrationLimit())) return false;
			if (!Objects.equals(isIncluded, _that.getIsIncluded())) return false;
			if (!Objects.equals(valuationTreatment, _that.getValuationTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (concentrationLimit != null ? concentrationLimit.hashCode() : 0);
			_result = 31 * _result + (isIncluded != null ? isIncluded.hashCode() : 0);
			_result = 31 * _result + (valuationTreatment != null ? valuationTreatment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralTreatmentBuilder {" +
				"concentrationLimit=" + this.concentrationLimit + ", " +
				"isIncluded=" + this.isIncluded + ", " +
				"valuationTreatment=" + this.valuationTreatment +
			'}';
		}
	}
}
