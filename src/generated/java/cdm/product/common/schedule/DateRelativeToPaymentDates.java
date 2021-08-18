package cdm.product.common.schedule;

import cdm.product.common.schedule.meta.DateRelativeToPaymentDatesMeta;
import cdm.product.common.schedule.metafields.ReferenceWithMetaPaymentDates;
import cdm.product.common.schedule.metafields.ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder;
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

public interface DateRelativeToPaymentDates extends RosettaModelObject {
	DateRelativeToPaymentDates build();
	DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder toBuilder();
	
	/**
	 * A set of href pointers to payment dates defined somewhere else in the document.
	 */
	List<? extends ReferenceWithMetaPaymentDates> getPaymentDatesReference();
	final static DateRelativeToPaymentDatesMeta metaData = new DateRelativeToPaymentDatesMeta();
	
	@Override
	default RosettaMetaData<? extends DateRelativeToPaymentDates> metaData() {
		return metaData;
	} 
			
	static DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder() {
		return new DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilderImpl();
	}
	
	default Class<? extends DateRelativeToPaymentDates> getType() {
		return DateRelativeToPaymentDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("paymentDatesReference"), processor, ReferenceWithMetaPaymentDates.class, getPaymentDatesReference());
	}
	
	
	interface DateRelativeToPaymentDatesBuilder extends DateRelativeToPaymentDates, RosettaModelObjectBuilder {
		ReferenceWithMetaPaymentDatesBuilder getOrCreatePaymentDatesReference(int _index);
		List<? extends ReferenceWithMetaPaymentDatesBuilder> getPaymentDatesReference();
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(ReferenceWithMetaPaymentDates paymentDatesReference);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(ReferenceWithMetaPaymentDates paymentDatesReference, int _idx);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReferenceValue(PaymentDates paymentDatesReference);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReferenceValue(PaymentDates paymentDatesReference, int _idx);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(List<? extends ReferenceWithMetaPaymentDates> paymentDatesReference);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder setPaymentDatesReference(List<? extends ReferenceWithMetaPaymentDates> paymentDatesReference);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReferenceValue(List<? extends PaymentDates> paymentDatesReference);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder setPaymentDatesReferenceValue(List<? extends PaymentDates> paymentDatesReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("paymentDatesReference"), processor, ReferenceWithMetaPaymentDatesBuilder.class, getPaymentDatesReference());
		}
		
	}
	
	//DateRelativeToPaymentDates.DateRelativeToPaymentDatesImpl
	class DateRelativeToPaymentDatesImpl implements DateRelativeToPaymentDates {
		private final List<? extends ReferenceWithMetaPaymentDates> paymentDatesReference;
		
		protected DateRelativeToPaymentDatesImpl(DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder) {
			this.paymentDatesReference = ofNullable(builder.getPaymentDatesReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends ReferenceWithMetaPaymentDates> getPaymentDatesReference() {
			return paymentDatesReference;
		}
		
		@Override
		public DateRelativeToPaymentDates build() {
			return this;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder toBuilder() {
			DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder) {
			ofNullable(getPaymentDatesReference()).ifPresent(builder::setPaymentDatesReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToPaymentDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentDatesReference, _that.getPaymentDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentDatesReference != null ? paymentDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToPaymentDates {" +
				"paymentDatesReference=" + this.paymentDatesReference +
			'}';
		}
	}
	
	//DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilderImpl
	class DateRelativeToPaymentDatesBuilderImpl implements DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder {
	
		protected List<ReferenceWithMetaPaymentDatesBuilder> paymentDatesReference = new ArrayList<>();
	
		public DateRelativeToPaymentDatesBuilderImpl() {
		}
	
		@Override
		public List<? extends ReferenceWithMetaPaymentDatesBuilder> getPaymentDatesReference() {
			return paymentDatesReference;
		}
		
		public ReferenceWithMetaPaymentDatesBuilder getOrCreatePaymentDatesReference(int _index) {
		
			if (paymentDatesReference==null) {
				this.paymentDatesReference = new ArrayList<>();
			}
			ReferenceWithMetaPaymentDatesBuilder result;
			return getIndex(paymentDatesReference, _index, () -> {
						ReferenceWithMetaPaymentDatesBuilder newPaymentDatesReference = ReferenceWithMetaPaymentDates.builder();
						return newPaymentDatesReference;
					});
		}
		
	
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(ReferenceWithMetaPaymentDates paymentDatesReference) {
			if (paymentDatesReference!=null) this.paymentDatesReference.add(paymentDatesReference.toBuilder());
			return this;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(ReferenceWithMetaPaymentDates paymentDatesReference, int _idx) {
			getIndex(this.paymentDatesReference, _idx, () -> paymentDatesReference.toBuilder());
			return this;
		}
		
			@Override
			public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReferenceValue(PaymentDates paymentDatesReference) {
				this.getOrCreatePaymentDatesReference(-1).setValue(paymentDatesReference.toBuilder());
				return this;
			}
			
			@Override
			public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReferenceValue(PaymentDates paymentDatesReference, int _idx) {
				this.getOrCreatePaymentDatesReference(_idx).setValue(paymentDatesReference.toBuilder());
				return this;
			}
		@Override 
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(List<? extends ReferenceWithMetaPaymentDates> paymentDatesReferences) {
			if (paymentDatesReferences != null) {
				for (ReferenceWithMetaPaymentDates toAdd : paymentDatesReferences) {
					this.paymentDatesReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder setPaymentDatesReference(List<? extends ReferenceWithMetaPaymentDates> paymentDatesReferences) {
			if (paymentDatesReferences == null)  {
				this.paymentDatesReference = new ArrayList<>();
			}
			else {
				this.paymentDatesReference = paymentDatesReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReferenceValue(List<? extends PaymentDates> paymentDatesReferences) {
			if (paymentDatesReferences != null) {
				for (PaymentDates toAdd : paymentDatesReferences) {
					this.addPaymentDatesReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder setPaymentDatesReferenceValue(List<? extends PaymentDates> paymentDatesReferences) {
			this.paymentDatesReference.clear();
			if (paymentDatesReferences!=null) {
				paymentDatesReferences.forEach(this::addPaymentDatesReferenceValue);
			}
			return this;
		}
		
		
		@Override
		public DateRelativeToPaymentDates build() {
			return new DateRelativeToPaymentDates.DateRelativeToPaymentDatesImpl(this);
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder prune() {
			paymentDatesReference = paymentDatesReference.stream().filter(b->b!=null).<ReferenceWithMetaPaymentDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentDatesReference()!=null && getPaymentDatesReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder o = (DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder) other;
			
			merger.mergeRosetta(getPaymentDatesReference(), o.getPaymentDatesReference(), this::getOrCreatePaymentDatesReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToPaymentDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentDatesReference, _that.getPaymentDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentDatesReference != null ? paymentDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToPaymentDatesBuilder {" +
				"paymentDatesReference=" + this.paymentDatesReference +
			'}';
		}
	}
}
