package cdm.event.common;

import cdm.event.common.meta.AllocationInstructionMeta;
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

public interface AllocationInstruction extends RosettaModelObject {
	AllocationInstruction build();
	AllocationInstruction.AllocationInstructionBuilder toBuilder();
	
	/**
	 * The set of allocation breakdowns to be applied to a block trade
	 */
	List<? extends AllocationBreakdown> getBreakdowns();
	final static AllocationInstructionMeta metaData = new AllocationInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends AllocationInstruction> metaData() {
		return metaData;
	} 
			
	static AllocationInstruction.AllocationInstructionBuilder builder() {
		return new AllocationInstruction.AllocationInstructionBuilderImpl();
	}
	
	default Class<? extends AllocationInstruction> getType() {
		return AllocationInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("breakdowns"), processor, AllocationBreakdown.class, getBreakdowns());
	}
	
	
	interface AllocationInstructionBuilder extends AllocationInstruction, RosettaModelObjectBuilder {
		AllocationBreakdown.AllocationBreakdownBuilder getOrCreateBreakdowns(int _index);
		List<? extends AllocationBreakdown.AllocationBreakdownBuilder> getBreakdowns();
		AllocationInstruction.AllocationInstructionBuilder addBreakdowns(AllocationBreakdown breakdowns);
		AllocationInstruction.AllocationInstructionBuilder addBreakdowns(AllocationBreakdown breakdowns, int _idx);
		AllocationInstruction.AllocationInstructionBuilder addBreakdowns(List<? extends AllocationBreakdown> breakdowns);
		AllocationInstruction.AllocationInstructionBuilder setBreakdowns(List<? extends AllocationBreakdown> breakdowns);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("breakdowns"), processor, AllocationBreakdown.AllocationBreakdownBuilder.class, getBreakdowns());
		}
		
	}
	
	//AllocationInstruction.AllocationInstructionImpl
	class AllocationInstructionImpl implements AllocationInstruction {
		private final List<? extends AllocationBreakdown> breakdowns;
		
		protected AllocationInstructionImpl(AllocationInstruction.AllocationInstructionBuilder builder) {
			this.breakdowns = ofNullable(builder.getBreakdowns()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends AllocationBreakdown> getBreakdowns() {
			return breakdowns;
		}
		
		@Override
		public AllocationInstruction build() {
			return this;
		}
		
		@Override
		public AllocationInstruction.AllocationInstructionBuilder toBuilder() {
			AllocationInstruction.AllocationInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AllocationInstruction.AllocationInstructionBuilder builder) {
			ofNullable(getBreakdowns()).ifPresent(builder::setBreakdowns);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllocationInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(breakdowns, _that.getBreakdowns())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (breakdowns != null ? breakdowns.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationInstruction {" +
				"breakdowns=" + this.breakdowns +
			'}';
		}
	}
	
	//AllocationInstruction.AllocationInstructionBuilderImpl
	class AllocationInstructionBuilderImpl implements AllocationInstruction.AllocationInstructionBuilder {
	
		protected List<AllocationBreakdown.AllocationBreakdownBuilder> breakdowns = new ArrayList<>();
	
		public AllocationInstructionBuilderImpl() {
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
		public AllocationInstruction.AllocationInstructionBuilder addBreakdowns(AllocationBreakdown breakdowns) {
			if (breakdowns!=null) this.breakdowns.add(breakdowns.toBuilder());
			return this;
		}
		
		@Override
		public AllocationInstruction.AllocationInstructionBuilder addBreakdowns(AllocationBreakdown breakdowns, int _idx) {
			getIndex(this.breakdowns, _idx, () -> breakdowns.toBuilder());
			return this;
		}
		@Override 
		public AllocationInstruction.AllocationInstructionBuilder addBreakdowns(List<? extends AllocationBreakdown> breakdownss) {
			if (breakdownss != null) {
				for (AllocationBreakdown toAdd : breakdownss) {
					this.breakdowns.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AllocationInstruction.AllocationInstructionBuilder setBreakdowns(List<? extends AllocationBreakdown> breakdownss) {
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
		public AllocationInstruction build() {
			return new AllocationInstruction.AllocationInstructionImpl(this);
		}
		
		@Override
		public AllocationInstruction.AllocationInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationInstruction.AllocationInstructionBuilder prune() {
			breakdowns = breakdowns.stream().filter(b->b!=null).<AllocationBreakdown.AllocationBreakdownBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBreakdowns()!=null && getBreakdowns().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationInstruction.AllocationInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AllocationInstruction.AllocationInstructionBuilder o = (AllocationInstruction.AllocationInstructionBuilder) other;
			
			merger.mergeRosetta(getBreakdowns(), o.getBreakdowns(), this::getOrCreateBreakdowns);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllocationInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(breakdowns, _that.getBreakdowns())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (breakdowns != null ? breakdowns.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationInstructionBuilder {" +
				"breakdowns=" + this.breakdowns +
			'}';
		}
	}
}
