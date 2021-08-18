package cdm.event.common;

import cdm.event.common.meta.ReallocationInstructionMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the information required for the reallocation of a transaction.
 * @version ${project.version}
 */
@RosettaClass

public interface ReallocationInstruction extends RosettaModelObject {
	ReallocationInstruction build();
	ReallocationInstruction.ReallocationInstructionBuilder toBuilder();
	
	/**
	 * Specifies the breakdowns of any new trades created as part of the reallocation event.
	 */
	List<? extends AllocationBreakdown> getBreakdowns();
	/**
	 * Specifies the trades to be decreased as part of the reallocation event.
	 */
	List<? extends DecreasedTrade> getDecrease();
	/**
	 * Specifies the effective date of the reallocation.
	 */
	Date getEffectiveDate();
	/**
	 * Specifies the trades to be increased as part of the reallocation event.  Note this attribute cannot be used until the Increase model has been developed in the ISDA CDM.
	 */
	List<? extends IncreasedTrade> getIncrease();
	final static ReallocationInstructionMeta metaData = new ReallocationInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends ReallocationInstruction> metaData() {
		return metaData;
	} 
			
	static ReallocationInstruction.ReallocationInstructionBuilder builder() {
		return new ReallocationInstruction.ReallocationInstructionBuilderImpl();
	}
	
	default Class<? extends ReallocationInstruction> getType() {
		return ReallocationInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		
		processRosetta(path.newSubPath("breakdowns"), processor, AllocationBreakdown.class, getBreakdowns());
		processRosetta(path.newSubPath("decrease"), processor, DecreasedTrade.class, getDecrease());
		processRosetta(path.newSubPath("increase"), processor, IncreasedTrade.class, getIncrease());
	}
	
	
	interface ReallocationInstructionBuilder extends ReallocationInstruction, RosettaModelObjectBuilder {
		AllocationBreakdown.AllocationBreakdownBuilder getOrCreateBreakdowns(int _index);
		List<? extends AllocationBreakdown.AllocationBreakdownBuilder> getBreakdowns();
		DecreasedTrade.DecreasedTradeBuilder getOrCreateDecrease(int _index);
		List<? extends DecreasedTrade.DecreasedTradeBuilder> getDecrease();
		IncreasedTrade.IncreasedTradeBuilder getOrCreateIncrease(int _index);
		List<? extends IncreasedTrade.IncreasedTradeBuilder> getIncrease();
		ReallocationInstruction.ReallocationInstructionBuilder addBreakdowns(AllocationBreakdown breakdowns);
		ReallocationInstruction.ReallocationInstructionBuilder addBreakdowns(AllocationBreakdown breakdowns, int _idx);
		ReallocationInstruction.ReallocationInstructionBuilder addBreakdowns(List<? extends AllocationBreakdown> breakdowns);
		ReallocationInstruction.ReallocationInstructionBuilder setBreakdowns(List<? extends AllocationBreakdown> breakdowns);
		ReallocationInstruction.ReallocationInstructionBuilder addDecrease(DecreasedTrade decrease);
		ReallocationInstruction.ReallocationInstructionBuilder addDecrease(DecreasedTrade decrease, int _idx);
		ReallocationInstruction.ReallocationInstructionBuilder addDecrease(List<? extends DecreasedTrade> decrease);
		ReallocationInstruction.ReallocationInstructionBuilder setDecrease(List<? extends DecreasedTrade> decrease);
		ReallocationInstruction.ReallocationInstructionBuilder setEffectiveDate(Date effectiveDate);
		ReallocationInstruction.ReallocationInstructionBuilder addIncrease(IncreasedTrade increase);
		ReallocationInstruction.ReallocationInstructionBuilder addIncrease(IncreasedTrade increase, int _idx);
		ReallocationInstruction.ReallocationInstructionBuilder addIncrease(List<? extends IncreasedTrade> increase);
		ReallocationInstruction.ReallocationInstructionBuilder setIncrease(List<? extends IncreasedTrade> increase);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			
			processRosetta(path.newSubPath("breakdowns"), processor, AllocationBreakdown.AllocationBreakdownBuilder.class, getBreakdowns());
			processRosetta(path.newSubPath("decrease"), processor, DecreasedTrade.DecreasedTradeBuilder.class, getDecrease());
			processRosetta(path.newSubPath("increase"), processor, IncreasedTrade.IncreasedTradeBuilder.class, getIncrease());
		}
		
	}
	
	//ReallocationInstruction.ReallocationInstructionImpl
	class ReallocationInstructionImpl implements ReallocationInstruction {
		private final List<? extends AllocationBreakdown> breakdowns;
		private final List<? extends DecreasedTrade> decrease;
		private final Date effectiveDate;
		private final List<? extends IncreasedTrade> increase;
		
		protected ReallocationInstructionImpl(ReallocationInstruction.ReallocationInstructionBuilder builder) {
			this.breakdowns = ofNullable(builder.getBreakdowns()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.decrease = ofNullable(builder.getDecrease()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.increase = ofNullable(builder.getIncrease()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends AllocationBreakdown> getBreakdowns() {
			return breakdowns;
		}
		
		@Override
		public List<? extends DecreasedTrade> getDecrease() {
			return decrease;
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public List<? extends IncreasedTrade> getIncrease() {
			return increase;
		}
		
		@Override
		public ReallocationInstruction build() {
			return this;
		}
		
		@Override
		public ReallocationInstruction.ReallocationInstructionBuilder toBuilder() {
			ReallocationInstruction.ReallocationInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReallocationInstruction.ReallocationInstructionBuilder builder) {
			ofNullable(getBreakdowns()).ifPresent(builder::setBreakdowns);
			ofNullable(getDecrease()).ifPresent(builder::setDecrease);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getIncrease()).ifPresent(builder::setIncrease);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReallocationInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(breakdowns, _that.getBreakdowns())) return false;
			if (!ListEquals.listEquals(decrease, _that.getDecrease())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(increase, _that.getIncrease())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (breakdowns != null ? breakdowns.hashCode() : 0);
			_result = 31 * _result + (decrease != null ? decrease.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (increase != null ? increase.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReallocationInstruction {" +
				"breakdowns=" + this.breakdowns + ", " +
				"decrease=" + this.decrease + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"increase=" + this.increase +
			'}';
		}
	}
	
	//ReallocationInstruction.ReallocationInstructionBuilderImpl
	class ReallocationInstructionBuilderImpl implements ReallocationInstruction.ReallocationInstructionBuilder {
	
		protected List<AllocationBreakdown.AllocationBreakdownBuilder> breakdowns = new ArrayList<>();
		protected List<DecreasedTrade.DecreasedTradeBuilder> decrease = new ArrayList<>();
		protected Date effectiveDate;
		protected List<IncreasedTrade.IncreasedTradeBuilder> increase = new ArrayList<>();
	
		public ReallocationInstructionBuilderImpl() {
		}
	
		@Override
		public List<? extends AllocationBreakdown.AllocationBreakdownBuilder> getBreakdowns() {
			return breakdowns;
		}
		
		public AllocationBreakdown.AllocationBreakdownBuilder getOrCreateBreakdowns(int _index) {
		
			if (breakdowns==null) {
				this.breakdowns = new ArrayList<>();
			}
			AllocationBreakdown.AllocationBreakdownBuilder result;
			return getIndex(breakdowns, _index, () -> {
						AllocationBreakdown.AllocationBreakdownBuilder newBreakdowns = AllocationBreakdown.builder();
						return newBreakdowns;
					});
		}
		
		@Override
		public List<? extends DecreasedTrade.DecreasedTradeBuilder> getDecrease() {
			return decrease;
		}
		
		public DecreasedTrade.DecreasedTradeBuilder getOrCreateDecrease(int _index) {
		
			if (decrease==null) {
				this.decrease = new ArrayList<>();
			}
			DecreasedTrade.DecreasedTradeBuilder result;
			return getIndex(decrease, _index, () -> {
						DecreasedTrade.DecreasedTradeBuilder newDecrease = DecreasedTrade.builder();
						return newDecrease;
					});
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public List<? extends IncreasedTrade.IncreasedTradeBuilder> getIncrease() {
			return increase;
		}
		
		public IncreasedTrade.IncreasedTradeBuilder getOrCreateIncrease(int _index) {
		
			if (increase==null) {
				this.increase = new ArrayList<>();
			}
			IncreasedTrade.IncreasedTradeBuilder result;
			return getIndex(increase, _index, () -> {
						IncreasedTrade.IncreasedTradeBuilder newIncrease = IncreasedTrade.builder();
						return newIncrease;
					});
		}
		
	
		@Override
		public ReallocationInstruction.ReallocationInstructionBuilder addBreakdowns(AllocationBreakdown breakdowns) {
			if (breakdowns!=null) this.breakdowns.add(breakdowns.toBuilder());
			return this;
		}
		
		@Override
		public ReallocationInstruction.ReallocationInstructionBuilder addBreakdowns(AllocationBreakdown breakdowns, int _idx) {
			getIndex(this.breakdowns, _idx, () -> breakdowns.toBuilder());
			return this;
		}
		@Override 
		public ReallocationInstruction.ReallocationInstructionBuilder addBreakdowns(List<? extends AllocationBreakdown> breakdownss) {
			if (breakdownss != null) {
				for (AllocationBreakdown toAdd : breakdownss) {
					this.breakdowns.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReallocationInstruction.ReallocationInstructionBuilder setBreakdowns(List<? extends AllocationBreakdown> breakdownss) {
			if (breakdownss == null)  {
				this.breakdowns = new ArrayList<>();
			}
			else {
				this.breakdowns = breakdownss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ReallocationInstruction.ReallocationInstructionBuilder addDecrease(DecreasedTrade decrease) {
			if (decrease!=null) this.decrease.add(decrease.toBuilder());
			return this;
		}
		
		@Override
		public ReallocationInstruction.ReallocationInstructionBuilder addDecrease(DecreasedTrade decrease, int _idx) {
			getIndex(this.decrease, _idx, () -> decrease.toBuilder());
			return this;
		}
		@Override 
		public ReallocationInstruction.ReallocationInstructionBuilder addDecrease(List<? extends DecreasedTrade> decreases) {
			if (decreases != null) {
				for (DecreasedTrade toAdd : decreases) {
					this.decrease.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReallocationInstruction.ReallocationInstructionBuilder setDecrease(List<? extends DecreasedTrade> decreases) {
			if (decreases == null)  {
				this.decrease = new ArrayList<>();
			}
			else {
				this.decrease = decreases.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ReallocationInstruction.ReallocationInstructionBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		public ReallocationInstruction.ReallocationInstructionBuilder addIncrease(IncreasedTrade increase) {
			if (increase!=null) this.increase.add(increase.toBuilder());
			return this;
		}
		
		@Override
		public ReallocationInstruction.ReallocationInstructionBuilder addIncrease(IncreasedTrade increase, int _idx) {
			getIndex(this.increase, _idx, () -> increase.toBuilder());
			return this;
		}
		@Override 
		public ReallocationInstruction.ReallocationInstructionBuilder addIncrease(List<? extends IncreasedTrade> increases) {
			if (increases != null) {
				for (IncreasedTrade toAdd : increases) {
					this.increase.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReallocationInstruction.ReallocationInstructionBuilder setIncrease(List<? extends IncreasedTrade> increases) {
			if (increases == null)  {
				this.increase = new ArrayList<>();
			}
			else {
				this.increase = increases.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ReallocationInstruction build() {
			return new ReallocationInstruction.ReallocationInstructionImpl(this);
		}
		
		@Override
		public ReallocationInstruction.ReallocationInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReallocationInstruction.ReallocationInstructionBuilder prune() {
			breakdowns = breakdowns.stream().filter(b->b!=null).<AllocationBreakdown.AllocationBreakdownBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			decrease = decrease.stream().filter(b->b!=null).<DecreasedTrade.DecreasedTradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			increase = increase.stream().filter(b->b!=null).<IncreasedTrade.IncreasedTradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBreakdowns()!=null && getBreakdowns().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDecrease()!=null && getDecrease().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEffectiveDate()!=null) return true;
			if (getIncrease()!=null && getIncrease().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReallocationInstruction.ReallocationInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReallocationInstruction.ReallocationInstructionBuilder o = (ReallocationInstruction.ReallocationInstructionBuilder) other;
			
			merger.mergeRosetta(getBreakdowns(), o.getBreakdowns(), this::getOrCreateBreakdowns);
			merger.mergeRosetta(getDecrease(), o.getDecrease(), this::getOrCreateDecrease);
			merger.mergeRosetta(getIncrease(), o.getIncrease(), this::getOrCreateIncrease);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReallocationInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(breakdowns, _that.getBreakdowns())) return false;
			if (!ListEquals.listEquals(decrease, _that.getDecrease())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(increase, _that.getIncrease())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (breakdowns != null ? breakdowns.hashCode() : 0);
			_result = 31 * _result + (decrease != null ? decrease.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (increase != null ? increase.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReallocationInstructionBuilder {" +
				"breakdowns=" + this.breakdowns + ", " +
				"decrease=" + this.decrease + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"increase=" + this.increase +
			'}';
		}
	}
}
