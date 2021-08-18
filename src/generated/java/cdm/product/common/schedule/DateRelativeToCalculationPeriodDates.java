package cdm.product.common.schedule;

import cdm.product.common.schedule.meta.DateRelativeToCalculationPeriodDatesMeta;
import cdm.product.common.schedule.metafields.ReferenceWithMetaCalculationPeriodDates;
import cdm.product.common.schedule.metafields.ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder;
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
 * A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 * @version ${project.version}
 */
@RosettaClass

public interface DateRelativeToCalculationPeriodDates extends RosettaModelObject {
	DateRelativeToCalculationPeriodDates build();
	DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder toBuilder();
	
	/**
	 * A set of href pointers to calculation period dates defined somewhere else in the document.
	 */
	List<? extends ReferenceWithMetaCalculationPeriodDates> getCalculationPeriodDatesReference();
	final static DateRelativeToCalculationPeriodDatesMeta metaData = new DateRelativeToCalculationPeriodDatesMeta();
	
	@Override
	default RosettaMetaData<? extends DateRelativeToCalculationPeriodDates> metaData() {
		return metaData;
	} 
			
	static DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder() {
		return new DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilderImpl();
	}
	
	default Class<? extends DateRelativeToCalculationPeriodDates> getType() {
		return DateRelativeToCalculationPeriodDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, ReferenceWithMetaCalculationPeriodDates.class, getCalculationPeriodDatesReference());
	}
	
	
	interface DateRelativeToCalculationPeriodDatesBuilder extends DateRelativeToCalculationPeriodDates, RosettaModelObjectBuilder {
		ReferenceWithMetaCalculationPeriodDatesBuilder getOrCreateCalculationPeriodDatesReference(int _index);
		List<? extends ReferenceWithMetaCalculationPeriodDatesBuilder> getCalculationPeriodDatesReference();
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(ReferenceWithMetaCalculationPeriodDates calculationPeriodDatesReference);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(ReferenceWithMetaCalculationPeriodDates calculationPeriodDatesReference, int _idx);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(CalculationPeriodDates calculationPeriodDatesReference);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(CalculationPeriodDates calculationPeriodDatesReference, int _idx);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(List<? extends ReferenceWithMetaCalculationPeriodDates> calculationPeriodDatesReference);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder setCalculationPeriodDatesReference(List<? extends ReferenceWithMetaCalculationPeriodDates> calculationPeriodDatesReference);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(List<? extends CalculationPeriodDates> calculationPeriodDatesReference);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder setCalculationPeriodDatesReferenceValue(List<? extends CalculationPeriodDates> calculationPeriodDatesReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, ReferenceWithMetaCalculationPeriodDatesBuilder.class, getCalculationPeriodDatesReference());
		}
		
	}
	
	//DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesImpl
	class DateRelativeToCalculationPeriodDatesImpl implements DateRelativeToCalculationPeriodDates {
		private final List<? extends ReferenceWithMetaCalculationPeriodDates> calculationPeriodDatesReference;
		
		protected DateRelativeToCalculationPeriodDatesImpl(DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder) {
			this.calculationPeriodDatesReference = ofNullable(builder.getCalculationPeriodDatesReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends ReferenceWithMetaCalculationPeriodDates> getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates build() {
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder toBuilder() {
			DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder) {
			ofNullable(getCalculationPeriodDatesReference()).ifPresent(builder::setCalculationPeriodDatesReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToCalculationPeriodDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToCalculationPeriodDates {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference +
			'}';
		}
	}
	
	//DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilderImpl
	class DateRelativeToCalculationPeriodDatesBuilderImpl implements DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder {
	
		protected List<ReferenceWithMetaCalculationPeriodDatesBuilder> calculationPeriodDatesReference = new ArrayList<>();
	
		public DateRelativeToCalculationPeriodDatesBuilderImpl() {
		}
	
		@Override
		public List<? extends ReferenceWithMetaCalculationPeriodDatesBuilder> getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		public ReferenceWithMetaCalculationPeriodDatesBuilder getOrCreateCalculationPeriodDatesReference(int _index) {
		
			if (calculationPeriodDatesReference==null) {
				this.calculationPeriodDatesReference = new ArrayList<>();
			}
			ReferenceWithMetaCalculationPeriodDatesBuilder result;
			return getIndex(calculationPeriodDatesReference, _index, () -> {
						ReferenceWithMetaCalculationPeriodDatesBuilder newCalculationPeriodDatesReference = ReferenceWithMetaCalculationPeriodDates.builder();
						return newCalculationPeriodDatesReference;
					});
		}
		
	
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(ReferenceWithMetaCalculationPeriodDates calculationPeriodDatesReference) {
			if (calculationPeriodDatesReference!=null) this.calculationPeriodDatesReference.add(calculationPeriodDatesReference.toBuilder());
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(ReferenceWithMetaCalculationPeriodDates calculationPeriodDatesReference, int _idx) {
			getIndex(this.calculationPeriodDatesReference, _idx, () -> calculationPeriodDatesReference.toBuilder());
			return this;
		}
		
			@Override
			public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(CalculationPeriodDates calculationPeriodDatesReference) {
				this.getOrCreateCalculationPeriodDatesReference(-1).setValue(calculationPeriodDatesReference.toBuilder());
				return this;
			}
			
			@Override
			public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(CalculationPeriodDates calculationPeriodDatesReference, int _idx) {
				this.getOrCreateCalculationPeriodDatesReference(_idx).setValue(calculationPeriodDatesReference.toBuilder());
				return this;
			}
		@Override 
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(List<? extends ReferenceWithMetaCalculationPeriodDates> calculationPeriodDatesReferences) {
			if (calculationPeriodDatesReferences != null) {
				for (ReferenceWithMetaCalculationPeriodDates toAdd : calculationPeriodDatesReferences) {
					this.calculationPeriodDatesReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder setCalculationPeriodDatesReference(List<? extends ReferenceWithMetaCalculationPeriodDates> calculationPeriodDatesReferences) {
			if (calculationPeriodDatesReferences == null)  {
				this.calculationPeriodDatesReference = new ArrayList<>();
			}
			else {
				this.calculationPeriodDatesReference = calculationPeriodDatesReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(List<? extends CalculationPeriodDates> calculationPeriodDatesReferences) {
			if (calculationPeriodDatesReferences != null) {
				for (CalculationPeriodDates toAdd : calculationPeriodDatesReferences) {
					this.addCalculationPeriodDatesReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder setCalculationPeriodDatesReferenceValue(List<? extends CalculationPeriodDates> calculationPeriodDatesReferences) {
			this.calculationPeriodDatesReference.clear();
			if (calculationPeriodDatesReferences!=null) {
				calculationPeriodDatesReferences.forEach(this::addCalculationPeriodDatesReferenceValue);
			}
			return this;
		}
		
		
		@Override
		public DateRelativeToCalculationPeriodDates build() {
			return new DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesImpl(this);
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder prune() {
			calculationPeriodDatesReference = calculationPeriodDatesReference.stream().filter(b->b!=null).<ReferenceWithMetaCalculationPeriodDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodDatesReference()!=null && getCalculationPeriodDatesReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder o = (DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDatesReference(), o.getCalculationPeriodDatesReference(), this::getOrCreateCalculationPeriodDatesReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToCalculationPeriodDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToCalculationPeriodDatesBuilder {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference +
			'}';
		}
	}
}
