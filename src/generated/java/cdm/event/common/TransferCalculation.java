package cdm.event.common;

import cdm.event.common.meta.TransferCalculationMeta;
import cdm.product.common.schedule.CalculationPeriodBase;
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
 * @version ${project.version}
 */
@RosettaClass

public interface TransferCalculation extends RosettaModelObject {
	TransferCalculation build();
	TransferCalculation.TransferCalculationBuilder toBuilder();
	
	/**
	 * This is a conceptual placeholder for providing the breakdown into the cashflow calculation components, leveraging the fact that the CDM provides calculation components, starting with the FixedAmount and the FloatingAmount. Further evaluation of expected usage needs to take place to confirm and prioritize such implementation.
	 */
	String getCalculationOutcome();
	/**
	 * The lineage into the components used for the calculation.
	 */
	List<? extends Lineage> getLineage();
	/**
	 * The period adjusted start and end dates.
	 */
	CalculationPeriodBase getPeriod();
	final static TransferCalculationMeta metaData = new TransferCalculationMeta();
	
	@Override
	default RosettaMetaData<? extends TransferCalculation> metaData() {
		return metaData;
	} 
			
	static TransferCalculation.TransferCalculationBuilder builder() {
		return new TransferCalculation.TransferCalculationBuilderImpl();
	}
	
	default Class<? extends TransferCalculation> getType() {
		return TransferCalculation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("calculationOutcome"), String.class, getCalculationOutcome(), this);
		
		processRosetta(path.newSubPath("lineage"), processor, Lineage.class, getLineage());
		processRosetta(path.newSubPath("period"), processor, CalculationPeriodBase.class, getPeriod());
	}
	
	
	interface TransferCalculationBuilder extends TransferCalculation, RosettaModelObjectBuilder {
		Lineage.LineageBuilder getOrCreateLineage(int _index);
		List<? extends Lineage.LineageBuilder> getLineage();
		CalculationPeriodBase.CalculationPeriodBaseBuilder getOrCreatePeriod();
		CalculationPeriodBase.CalculationPeriodBaseBuilder getPeriod();
		TransferCalculation.TransferCalculationBuilder setCalculationOutcome(String calculationOutcome);
		TransferCalculation.TransferCalculationBuilder addLineage(Lineage lineage);
		TransferCalculation.TransferCalculationBuilder addLineage(Lineage lineage, int _idx);
		TransferCalculation.TransferCalculationBuilder addLineage(List<? extends Lineage> lineage);
		TransferCalculation.TransferCalculationBuilder setLineage(List<? extends Lineage> lineage);
		TransferCalculation.TransferCalculationBuilder setPeriod(CalculationPeriodBase period);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("calculationOutcome"), String.class, getCalculationOutcome(), this);
			
			processRosetta(path.newSubPath("lineage"), processor, Lineage.LineageBuilder.class, getLineage());
			processRosetta(path.newSubPath("period"), processor, CalculationPeriodBase.CalculationPeriodBaseBuilder.class, getPeriod());
		}
		
	}
	
	//TransferCalculation.TransferCalculationImpl
	class TransferCalculationImpl implements TransferCalculation {
		private final String calculationOutcome;
		private final List<? extends Lineage> lineage;
		private final CalculationPeriodBase period;
		
		protected TransferCalculationImpl(TransferCalculation.TransferCalculationBuilder builder) {
			this.calculationOutcome = builder.getCalculationOutcome();
			this.lineage = ofNullable(builder.getLineage()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.period = ofNullable(builder.getPeriod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public String getCalculationOutcome() {
			return calculationOutcome;
		}
		
		@Override
		public List<? extends Lineage> getLineage() {
			return lineage;
		}
		
		@Override
		public CalculationPeriodBase getPeriod() {
			return period;
		}
		
		@Override
		public TransferCalculation build() {
			return this;
		}
		
		@Override
		public TransferCalculation.TransferCalculationBuilder toBuilder() {
			TransferCalculation.TransferCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransferCalculation.TransferCalculationBuilder builder) {
			ofNullable(getCalculationOutcome()).ifPresent(builder::setCalculationOutcome);
			ofNullable(getLineage()).ifPresent(builder::setLineage);
			ofNullable(getPeriod()).ifPresent(builder::setPeriod);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferCalculation _that = getType().cast(o);
		
			if (!Objects.equals(calculationOutcome, _that.getCalculationOutcome())) return false;
			if (!ListEquals.listEquals(lineage, _that.getLineage())) return false;
			if (!Objects.equals(period, _that.getPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationOutcome != null ? calculationOutcome.hashCode() : 0);
			_result = 31 * _result + (lineage != null ? lineage.hashCode() : 0);
			_result = 31 * _result + (period != null ? period.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferCalculation {" +
				"calculationOutcome=" + this.calculationOutcome + ", " +
				"lineage=" + this.lineage + ", " +
				"period=" + this.period +
			'}';
		}
	}
	
	//TransferCalculation.TransferCalculationBuilderImpl
	class TransferCalculationBuilderImpl implements TransferCalculation.TransferCalculationBuilder {
	
		protected String calculationOutcome;
		protected List<Lineage.LineageBuilder> lineage = new ArrayList<>();
		protected CalculationPeriodBase.CalculationPeriodBaseBuilder period;
	
		public TransferCalculationBuilderImpl() {
		}
	
		@Override
		public String getCalculationOutcome() {
			return calculationOutcome;
		}
		
		@Override
		public List<? extends Lineage.LineageBuilder> getLineage() {
			return lineage;
		}
		
		public Lineage.LineageBuilder getOrCreateLineage(int _index) {
		
			if (lineage==null) {
				this.lineage = new ArrayList<>();
			}
			Lineage.LineageBuilder result;
			return getIndex(lineage, _index, () -> {
						Lineage.LineageBuilder newLineage = Lineage.builder();
						return newLineage;
					});
		}
		
		@Override
		public CalculationPeriodBase.CalculationPeriodBaseBuilder getPeriod() {
			return period;
		}
		
		@Override
		public CalculationPeriodBase.CalculationPeriodBaseBuilder getOrCreatePeriod() {
			CalculationPeriodBase.CalculationPeriodBaseBuilder result;
			if (period!=null) {
				result = period;
			}
			else {
				result = period = CalculationPeriodBase.builder();
			}
			
			return result;
		}
		
	
		@Override
		public TransferCalculation.TransferCalculationBuilder setCalculationOutcome(String calculationOutcome) {
			this.calculationOutcome = calculationOutcome==null?null:calculationOutcome;
			return this;
		}
		@Override
		public TransferCalculation.TransferCalculationBuilder addLineage(Lineage lineage) {
			if (lineage!=null) this.lineage.add(lineage.toBuilder());
			return this;
		}
		
		@Override
		public TransferCalculation.TransferCalculationBuilder addLineage(Lineage lineage, int _idx) {
			getIndex(this.lineage, _idx, () -> lineage.toBuilder());
			return this;
		}
		@Override 
		public TransferCalculation.TransferCalculationBuilder addLineage(List<? extends Lineage> lineages) {
			if (lineages != null) {
				for (Lineage toAdd : lineages) {
					this.lineage.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TransferCalculation.TransferCalculationBuilder setLineage(List<? extends Lineage> lineages) {
			if (lineages == null)  {
				this.lineage = new ArrayList<>();
			}
			else {
				this.lineage = lineages.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TransferCalculation.TransferCalculationBuilder setPeriod(CalculationPeriodBase period) {
			this.period = period==null?null:period.toBuilder();
			return this;
		}
		
		@Override
		public TransferCalculation build() {
			return new TransferCalculation.TransferCalculationImpl(this);
		}
		
		@Override
		public TransferCalculation.TransferCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferCalculation.TransferCalculationBuilder prune() {
			lineage = lineage.stream().filter(b->b!=null).<Lineage.LineageBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (period!=null && !period.prune().hasData()) period = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationOutcome()!=null) return true;
			if (getLineage()!=null && getLineage().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPeriod()!=null && getPeriod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferCalculation.TransferCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransferCalculation.TransferCalculationBuilder o = (TransferCalculation.TransferCalculationBuilder) other;
			
			merger.mergeRosetta(getLineage(), o.getLineage(), this::getOrCreateLineage);
			merger.mergeRosetta(getPeriod(), o.getPeriod(), this::setPeriod);
			
			merger.mergeBasic(getCalculationOutcome(), o.getCalculationOutcome(), this::setCalculationOutcome);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferCalculation _that = getType().cast(o);
		
			if (!Objects.equals(calculationOutcome, _that.getCalculationOutcome())) return false;
			if (!ListEquals.listEquals(lineage, _that.getLineage())) return false;
			if (!Objects.equals(period, _that.getPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationOutcome != null ? calculationOutcome.hashCode() : 0);
			_result = 31 * _result + (lineage != null ? lineage.hashCode() : 0);
			_result = 31 * _result + (period != null ? period.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferCalculationBuilder {" +
				"calculationOutcome=" + this.calculationOutcome + ", " +
				"lineage=" + this.lineage + ", " +
				"period=" + this.period +
			'}';
		}
	}
}
