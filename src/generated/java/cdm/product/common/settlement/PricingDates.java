package cdm.product.common.settlement;

import cdm.base.datetime.AdjustableDates;
import cdm.product.common.settlement.meta.PricingDatesMeta;
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
 * Specifies specific dates or parametric rules for the dates on which the price will be determined
 * @version ${project.version}
 */
@RosettaClass

public interface PricingDates extends RosettaModelObject {
	PricingDates build();
	PricingDates.PricingDatesBuilder toBuilder();
	
	/**
	 * Defines rules for the dates on which the price will be determined.
	 */
	ParametricDates getParametricDates();
	/**
	 * Defines specified dates on which the price will be determined.
	 */
	List<? extends AdjustableDates> getSpecifiedDates();
	final static PricingDatesMeta metaData = new PricingDatesMeta();
	
	@Override
	default RosettaMetaData<? extends PricingDates> metaData() {
		return metaData;
	} 
			
	static PricingDates.PricingDatesBuilder builder() {
		return new PricingDates.PricingDatesBuilderImpl();
	}
	
	default Class<? extends PricingDates> getType() {
		return PricingDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("parametricDates"), processor, ParametricDates.class, getParametricDates());
		processRosetta(path.newSubPath("specifiedDates"), processor, AdjustableDates.class, getSpecifiedDates());
	}
	
	
	interface PricingDatesBuilder extends PricingDates, RosettaModelObjectBuilder {
		ParametricDates.ParametricDatesBuilder getOrCreateParametricDates();
		ParametricDates.ParametricDatesBuilder getParametricDates();
		AdjustableDates.AdjustableDatesBuilder getOrCreateSpecifiedDates(int _index);
		List<? extends AdjustableDates.AdjustableDatesBuilder> getSpecifiedDates();
		PricingDates.PricingDatesBuilder setParametricDates(ParametricDates parametricDates);
		PricingDates.PricingDatesBuilder addSpecifiedDates(AdjustableDates specifiedDates);
		PricingDates.PricingDatesBuilder addSpecifiedDates(AdjustableDates specifiedDates, int _idx);
		PricingDates.PricingDatesBuilder addSpecifiedDates(List<? extends AdjustableDates> specifiedDates);
		PricingDates.PricingDatesBuilder setSpecifiedDates(List<? extends AdjustableDates> specifiedDates);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("parametricDates"), processor, ParametricDates.ParametricDatesBuilder.class, getParametricDates());
			processRosetta(path.newSubPath("specifiedDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getSpecifiedDates());
		}
		
	}
	
	//PricingDates.PricingDatesImpl
	class PricingDatesImpl implements PricingDates {
		private final ParametricDates parametricDates;
		private final List<? extends AdjustableDates> specifiedDates;
		
		protected PricingDatesImpl(PricingDates.PricingDatesBuilder builder) {
			this.parametricDates = ofNullable(builder.getParametricDates()).map(f->f.build()).orElse(null);
			this.specifiedDates = ofNullable(builder.getSpecifiedDates()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public ParametricDates getParametricDates() {
			return parametricDates;
		}
		
		@Override
		public List<? extends AdjustableDates> getSpecifiedDates() {
			return specifiedDates;
		}
		
		@Override
		public PricingDates build() {
			return this;
		}
		
		@Override
		public PricingDates.PricingDatesBuilder toBuilder() {
			PricingDates.PricingDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingDates.PricingDatesBuilder builder) {
			ofNullable(getParametricDates()).ifPresent(builder::setParametricDates);
			ofNullable(getSpecifiedDates()).ifPresent(builder::setSpecifiedDates);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingDates _that = getType().cast(o);
		
			if (!Objects.equals(parametricDates, _that.getParametricDates())) return false;
			if (!ListEquals.listEquals(specifiedDates, _that.getSpecifiedDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parametricDates != null ? parametricDates.hashCode() : 0);
			_result = 31 * _result + (specifiedDates != null ? specifiedDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingDates {" +
				"parametricDates=" + this.parametricDates + ", " +
				"specifiedDates=" + this.specifiedDates +
			'}';
		}
	}
	
	//PricingDates.PricingDatesBuilderImpl
	class PricingDatesBuilderImpl implements PricingDates.PricingDatesBuilder {
	
		protected ParametricDates.ParametricDatesBuilder parametricDates;
		protected List<AdjustableDates.AdjustableDatesBuilder> specifiedDates = new ArrayList<>();
	
		public PricingDatesBuilderImpl() {
		}
	
		@Override
		public ParametricDates.ParametricDatesBuilder getParametricDates() {
			return parametricDates;
		}
		
		@Override
		public ParametricDates.ParametricDatesBuilder getOrCreateParametricDates() {
			ParametricDates.ParametricDatesBuilder result;
			if (parametricDates!=null) {
				result = parametricDates;
			}
			else {
				result = parametricDates = ParametricDates.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends AdjustableDates.AdjustableDatesBuilder> getSpecifiedDates() {
			return specifiedDates;
		}
		
		public AdjustableDates.AdjustableDatesBuilder getOrCreateSpecifiedDates(int _index) {
		
			if (specifiedDates==null) {
				this.specifiedDates = new ArrayList<>();
			}
			AdjustableDates.AdjustableDatesBuilder result;
			return getIndex(specifiedDates, _index, () -> {
						AdjustableDates.AdjustableDatesBuilder newSpecifiedDates = AdjustableDates.builder();
						return newSpecifiedDates;
					});
		}
		
	
		@Override
		public PricingDates.PricingDatesBuilder setParametricDates(ParametricDates parametricDates) {
			this.parametricDates = parametricDates==null?null:parametricDates.toBuilder();
			return this;
		}
		@Override
		public PricingDates.PricingDatesBuilder addSpecifiedDates(AdjustableDates specifiedDates) {
			if (specifiedDates!=null) this.specifiedDates.add(specifiedDates.toBuilder());
			return this;
		}
		
		@Override
		public PricingDates.PricingDatesBuilder addSpecifiedDates(AdjustableDates specifiedDates, int _idx) {
			getIndex(this.specifiedDates, _idx, () -> specifiedDates.toBuilder());
			return this;
		}
		@Override 
		public PricingDates.PricingDatesBuilder addSpecifiedDates(List<? extends AdjustableDates> specifiedDatess) {
			if (specifiedDatess != null) {
				for (AdjustableDates toAdd : specifiedDatess) {
					this.specifiedDates.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PricingDates.PricingDatesBuilder setSpecifiedDates(List<? extends AdjustableDates> specifiedDatess) {
			if (specifiedDatess == null)  {
				this.specifiedDates = new ArrayList<>();
			}
			else {
				this.specifiedDates = specifiedDatess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public PricingDates build() {
			return new PricingDates.PricingDatesImpl(this);
		}
		
		@Override
		public PricingDates.PricingDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingDates.PricingDatesBuilder prune() {
			if (parametricDates!=null && !parametricDates.prune().hasData()) parametricDates = null;
			specifiedDates = specifiedDates.stream().filter(b->b!=null).<AdjustableDates.AdjustableDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParametricDates()!=null && getParametricDates().hasData()) return true;
			if (getSpecifiedDates()!=null && getSpecifiedDates().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingDates.PricingDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingDates.PricingDatesBuilder o = (PricingDates.PricingDatesBuilder) other;
			
			merger.mergeRosetta(getParametricDates(), o.getParametricDates(), this::setParametricDates);
			merger.mergeRosetta(getSpecifiedDates(), o.getSpecifiedDates(), this::getOrCreateSpecifiedDates);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingDates _that = getType().cast(o);
		
			if (!Objects.equals(parametricDates, _that.getParametricDates())) return false;
			if (!ListEquals.listEquals(specifiedDates, _that.getSpecifiedDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parametricDates != null ? parametricDates.hashCode() : 0);
			_result = 31 * _result + (specifiedDates != null ? specifiedDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingDatesBuilder {" +
				"parametricDates=" + this.parametricDates + ", " +
				"specifiedDates=" + this.specifiedDates +
			'}';
		}
	}
}
