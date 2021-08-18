package cdm.event.common;

import cdm.event.common.meta.InstructionMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Instruction to a function that will be used to perform a business event
 * @version ${project.version}
 */
@RosettaClass

public interface Instruction extends RosettaModelObject {
	Instruction build();
	Instruction.InstructionBuilder toBuilder();
	
	/**
	 * Instruction to allocate
	 */
	AllocationInstruction getAllocation();
	/**
	 * Instruction to clear
	 */
	ClearingInstruction getClearing();
	/**
	 * Specifies instructions for transition from execution to a fully formed contract, consisting of an execution and an optional legal agreement.
	 */
	ContractFormationInstruction getContractFormation();
	/**
	 * Specifies the inputs needed to process a trade decrease / unwind, containing the quantity of the trade lot(s) to be decreased and at what price.
	 */
	DecreaseInstruction getDecrease();
	/**
	 * Specifies instructions for execution of a transaction, consisting of a product, price, quantity, parties, trade identifier, and a trade date.
	 */
	ExecutionInstruction getExecution();
	/**
	 * Specifies the information required to communicate the choices made by the exercising party, in a financial product endowing the party with at least one option.
	 */
	ExerciseInstruction getExercise();
	/**
	 * Specifies the inputs needed to process a trade increase, containing the price and quantity of the new trade lot to add.
	 */
	IncreaseInstruction getIncrease();
	/**
	 * Specifies inputs needed to process a Index Transition business event.
	 */
	IndexTransitionInstruction getIndexTransition();
	/**
	 * Specifies the function that will be called
	 */
	String getInstructionFunction();
	/**
	 * Specifies inputs needed to process a Reset business event.
	 */
	ResetInstruction getReset();
	/**
	 * Specifies inputs needed to process a Transfer business event.
	 */
	TransferInstruction getTransfer();
	final static InstructionMeta metaData = new InstructionMeta();
	
	@Override
	default RosettaMetaData<? extends Instruction> metaData() {
		return metaData;
	} 
			
	static Instruction.InstructionBuilder builder() {
		return new Instruction.InstructionBuilderImpl();
	}
	
	default Class<? extends Instruction> getType() {
		return Instruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("instructionFunction"), String.class, getInstructionFunction(), this);
		
		processRosetta(path.newSubPath("allocation"), processor, AllocationInstruction.class, getAllocation());
		processRosetta(path.newSubPath("clearing"), processor, ClearingInstruction.class, getClearing());
		processRosetta(path.newSubPath("contractFormation"), processor, ContractFormationInstruction.class, getContractFormation());
		processRosetta(path.newSubPath("decrease"), processor, DecreaseInstruction.class, getDecrease());
		processRosetta(path.newSubPath("execution"), processor, ExecutionInstruction.class, getExecution());
		processRosetta(path.newSubPath("exercise"), processor, ExerciseInstruction.class, getExercise());
		processRosetta(path.newSubPath("increase"), processor, IncreaseInstruction.class, getIncrease());
		processRosetta(path.newSubPath("indexTransition"), processor, IndexTransitionInstruction.class, getIndexTransition());
		processRosetta(path.newSubPath("reset"), processor, ResetInstruction.class, getReset());
		processRosetta(path.newSubPath("transfer"), processor, TransferInstruction.class, getTransfer());
	}
	
	
	interface InstructionBuilder extends Instruction, RosettaModelObjectBuilder {
		AllocationInstruction.AllocationInstructionBuilder getOrCreateAllocation();
		AllocationInstruction.AllocationInstructionBuilder getAllocation();
		ClearingInstruction.ClearingInstructionBuilder getOrCreateClearing();
		ClearingInstruction.ClearingInstructionBuilder getClearing();
		ContractFormationInstruction.ContractFormationInstructionBuilder getOrCreateContractFormation();
		ContractFormationInstruction.ContractFormationInstructionBuilder getContractFormation();
		DecreaseInstruction.DecreaseInstructionBuilder getOrCreateDecrease();
		DecreaseInstruction.DecreaseInstructionBuilder getDecrease();
		ExecutionInstruction.ExecutionInstructionBuilder getOrCreateExecution();
		ExecutionInstruction.ExecutionInstructionBuilder getExecution();
		ExerciseInstruction.ExerciseInstructionBuilder getOrCreateExercise();
		ExerciseInstruction.ExerciseInstructionBuilder getExercise();
		IncreaseInstruction.IncreaseInstructionBuilder getOrCreateIncrease();
		IncreaseInstruction.IncreaseInstructionBuilder getIncrease();
		IndexTransitionInstruction.IndexTransitionInstructionBuilder getOrCreateIndexTransition();
		IndexTransitionInstruction.IndexTransitionInstructionBuilder getIndexTransition();
		ResetInstruction.ResetInstructionBuilder getOrCreateReset();
		ResetInstruction.ResetInstructionBuilder getReset();
		TransferInstruction.TransferInstructionBuilder getOrCreateTransfer();
		TransferInstruction.TransferInstructionBuilder getTransfer();
		Instruction.InstructionBuilder setAllocation(AllocationInstruction allocation);
		Instruction.InstructionBuilder setClearing(ClearingInstruction clearing);
		Instruction.InstructionBuilder setContractFormation(ContractFormationInstruction contractFormation);
		Instruction.InstructionBuilder setDecrease(DecreaseInstruction decrease);
		Instruction.InstructionBuilder setExecution(ExecutionInstruction execution);
		Instruction.InstructionBuilder setExercise(ExerciseInstruction exercise);
		Instruction.InstructionBuilder setIncrease(IncreaseInstruction increase);
		Instruction.InstructionBuilder setIndexTransition(IndexTransitionInstruction indexTransition);
		Instruction.InstructionBuilder setInstructionFunction(String instructionFunction);
		Instruction.InstructionBuilder setReset(ResetInstruction reset);
		Instruction.InstructionBuilder setTransfer(TransferInstruction transfer);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("instructionFunction"), String.class, getInstructionFunction(), this);
			
			processRosetta(path.newSubPath("allocation"), processor, AllocationInstruction.AllocationInstructionBuilder.class, getAllocation());
			processRosetta(path.newSubPath("clearing"), processor, ClearingInstruction.ClearingInstructionBuilder.class, getClearing());
			processRosetta(path.newSubPath("contractFormation"), processor, ContractFormationInstruction.ContractFormationInstructionBuilder.class, getContractFormation());
			processRosetta(path.newSubPath("decrease"), processor, DecreaseInstruction.DecreaseInstructionBuilder.class, getDecrease());
			processRosetta(path.newSubPath("execution"), processor, ExecutionInstruction.ExecutionInstructionBuilder.class, getExecution());
			processRosetta(path.newSubPath("exercise"), processor, ExerciseInstruction.ExerciseInstructionBuilder.class, getExercise());
			processRosetta(path.newSubPath("increase"), processor, IncreaseInstruction.IncreaseInstructionBuilder.class, getIncrease());
			processRosetta(path.newSubPath("indexTransition"), processor, IndexTransitionInstruction.IndexTransitionInstructionBuilder.class, getIndexTransition());
			processRosetta(path.newSubPath("reset"), processor, ResetInstruction.ResetInstructionBuilder.class, getReset());
			processRosetta(path.newSubPath("transfer"), processor, TransferInstruction.TransferInstructionBuilder.class, getTransfer());
		}
		
	}
	
	//Instruction.InstructionImpl
	class InstructionImpl implements Instruction {
		private final AllocationInstruction allocation;
		private final ClearingInstruction clearing;
		private final ContractFormationInstruction contractFormation;
		private final DecreaseInstruction decrease;
		private final ExecutionInstruction execution;
		private final ExerciseInstruction exercise;
		private final IncreaseInstruction increase;
		private final IndexTransitionInstruction indexTransition;
		private final String instructionFunction;
		private final ResetInstruction reset;
		private final TransferInstruction transfer;
		
		protected InstructionImpl(Instruction.InstructionBuilder builder) {
			this.allocation = ofNullable(builder.getAllocation()).map(f->f.build()).orElse(null);
			this.clearing = ofNullable(builder.getClearing()).map(f->f.build()).orElse(null);
			this.contractFormation = ofNullable(builder.getContractFormation()).map(f->f.build()).orElse(null);
			this.decrease = ofNullable(builder.getDecrease()).map(f->f.build()).orElse(null);
			this.execution = ofNullable(builder.getExecution()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.increase = ofNullable(builder.getIncrease()).map(f->f.build()).orElse(null);
			this.indexTransition = ofNullable(builder.getIndexTransition()).map(f->f.build()).orElse(null);
			this.instructionFunction = builder.getInstructionFunction();
			this.reset = ofNullable(builder.getReset()).map(f->f.build()).orElse(null);
			this.transfer = ofNullable(builder.getTransfer()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AllocationInstruction getAllocation() {
			return allocation;
		}
		
		@Override
		public ClearingInstruction getClearing() {
			return clearing;
		}
		
		@Override
		public ContractFormationInstruction getContractFormation() {
			return contractFormation;
		}
		
		@Override
		public DecreaseInstruction getDecrease() {
			return decrease;
		}
		
		@Override
		public ExecutionInstruction getExecution() {
			return execution;
		}
		
		@Override
		public ExerciseInstruction getExercise() {
			return exercise;
		}
		
		@Override
		public IncreaseInstruction getIncrease() {
			return increase;
		}
		
		@Override
		public IndexTransitionInstruction getIndexTransition() {
			return indexTransition;
		}
		
		@Override
		public String getInstructionFunction() {
			return instructionFunction;
		}
		
		@Override
		public ResetInstruction getReset() {
			return reset;
		}
		
		@Override
		public TransferInstruction getTransfer() {
			return transfer;
		}
		
		@Override
		public Instruction build() {
			return this;
		}
		
		@Override
		public Instruction.InstructionBuilder toBuilder() {
			Instruction.InstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Instruction.InstructionBuilder builder) {
			ofNullable(getAllocation()).ifPresent(builder::setAllocation);
			ofNullable(getClearing()).ifPresent(builder::setClearing);
			ofNullable(getContractFormation()).ifPresent(builder::setContractFormation);
			ofNullable(getDecrease()).ifPresent(builder::setDecrease);
			ofNullable(getExecution()).ifPresent(builder::setExecution);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getIncrease()).ifPresent(builder::setIncrease);
			ofNullable(getIndexTransition()).ifPresent(builder::setIndexTransition);
			ofNullable(getInstructionFunction()).ifPresent(builder::setInstructionFunction);
			ofNullable(getReset()).ifPresent(builder::setReset);
			ofNullable(getTransfer()).ifPresent(builder::setTransfer);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Instruction _that = getType().cast(o);
		
			if (!Objects.equals(allocation, _that.getAllocation())) return false;
			if (!Objects.equals(clearing, _that.getClearing())) return false;
			if (!Objects.equals(contractFormation, _that.getContractFormation())) return false;
			if (!Objects.equals(decrease, _that.getDecrease())) return false;
			if (!Objects.equals(execution, _that.getExecution())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(increase, _that.getIncrease())) return false;
			if (!Objects.equals(indexTransition, _that.getIndexTransition())) return false;
			if (!Objects.equals(instructionFunction, _that.getInstructionFunction())) return false;
			if (!Objects.equals(reset, _that.getReset())) return false;
			if (!Objects.equals(transfer, _that.getTransfer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocation != null ? allocation.hashCode() : 0);
			_result = 31 * _result + (clearing != null ? clearing.hashCode() : 0);
			_result = 31 * _result + (contractFormation != null ? contractFormation.hashCode() : 0);
			_result = 31 * _result + (decrease != null ? decrease.hashCode() : 0);
			_result = 31 * _result + (execution != null ? execution.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (increase != null ? increase.hashCode() : 0);
			_result = 31 * _result + (indexTransition != null ? indexTransition.hashCode() : 0);
			_result = 31 * _result + (instructionFunction != null ? instructionFunction.hashCode() : 0);
			_result = 31 * _result + (reset != null ? reset.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Instruction {" +
				"allocation=" + this.allocation + ", " +
				"clearing=" + this.clearing + ", " +
				"contractFormation=" + this.contractFormation + ", " +
				"decrease=" + this.decrease + ", " +
				"execution=" + this.execution + ", " +
				"exercise=" + this.exercise + ", " +
				"increase=" + this.increase + ", " +
				"indexTransition=" + this.indexTransition + ", " +
				"instructionFunction=" + this.instructionFunction + ", " +
				"reset=" + this.reset + ", " +
				"transfer=" + this.transfer +
			'}';
		}
	}
	
	//Instruction.InstructionBuilderImpl
	class InstructionBuilderImpl implements Instruction.InstructionBuilder {
	
		protected AllocationInstruction.AllocationInstructionBuilder allocation;
		protected ClearingInstruction.ClearingInstructionBuilder clearing;
		protected ContractFormationInstruction.ContractFormationInstructionBuilder contractFormation;
		protected DecreaseInstruction.DecreaseInstructionBuilder decrease;
		protected ExecutionInstruction.ExecutionInstructionBuilder execution;
		protected ExerciseInstruction.ExerciseInstructionBuilder exercise;
		protected IncreaseInstruction.IncreaseInstructionBuilder increase;
		protected IndexTransitionInstruction.IndexTransitionInstructionBuilder indexTransition;
		protected String instructionFunction;
		protected ResetInstruction.ResetInstructionBuilder reset;
		protected TransferInstruction.TransferInstructionBuilder transfer;
	
		public InstructionBuilderImpl() {
		}
	
		@Override
		public AllocationInstruction.AllocationInstructionBuilder getAllocation() {
			return allocation;
		}
		
		@Override
		public AllocationInstruction.AllocationInstructionBuilder getOrCreateAllocation() {
			AllocationInstruction.AllocationInstructionBuilder result;
			if (allocation!=null) {
				result = allocation;
			}
			else {
				result = allocation = AllocationInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		public ClearingInstruction.ClearingInstructionBuilder getClearing() {
			return clearing;
		}
		
		@Override
		public ClearingInstruction.ClearingInstructionBuilder getOrCreateClearing() {
			ClearingInstruction.ClearingInstructionBuilder result;
			if (clearing!=null) {
				result = clearing;
			}
			else {
				result = clearing = ClearingInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		public ContractFormationInstruction.ContractFormationInstructionBuilder getContractFormation() {
			return contractFormation;
		}
		
		@Override
		public ContractFormationInstruction.ContractFormationInstructionBuilder getOrCreateContractFormation() {
			ContractFormationInstruction.ContractFormationInstructionBuilder result;
			if (contractFormation!=null) {
				result = contractFormation;
			}
			else {
				result = contractFormation = ContractFormationInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		public DecreaseInstruction.DecreaseInstructionBuilder getDecrease() {
			return decrease;
		}
		
		@Override
		public DecreaseInstruction.DecreaseInstructionBuilder getOrCreateDecrease() {
			DecreaseInstruction.DecreaseInstructionBuilder result;
			if (decrease!=null) {
				result = decrease;
			}
			else {
				result = decrease = DecreaseInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder getExecution() {
			return execution;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder getOrCreateExecution() {
			ExecutionInstruction.ExecutionInstructionBuilder result;
			if (execution!=null) {
				result = execution;
			}
			else {
				result = execution = ExecutionInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder getOrCreateExercise() {
			ExerciseInstruction.ExerciseInstructionBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = ExerciseInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		public IncreaseInstruction.IncreaseInstructionBuilder getIncrease() {
			return increase;
		}
		
		@Override
		public IncreaseInstruction.IncreaseInstructionBuilder getOrCreateIncrease() {
			IncreaseInstruction.IncreaseInstructionBuilder result;
			if (increase!=null) {
				result = increase;
			}
			else {
				result = increase = IncreaseInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder getIndexTransition() {
			return indexTransition;
		}
		
		@Override
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder getOrCreateIndexTransition() {
			IndexTransitionInstruction.IndexTransitionInstructionBuilder result;
			if (indexTransition!=null) {
				result = indexTransition;
			}
			else {
				result = indexTransition = IndexTransitionInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		public String getInstructionFunction() {
			return instructionFunction;
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder getReset() {
			return reset;
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder getOrCreateReset() {
			ResetInstruction.ResetInstructionBuilder result;
			if (reset!=null) {
				result = reset;
			}
			else {
				result = reset = ResetInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		public TransferInstruction.TransferInstructionBuilder getTransfer() {
			return transfer;
		}
		
		@Override
		public TransferInstruction.TransferInstructionBuilder getOrCreateTransfer() {
			TransferInstruction.TransferInstructionBuilder result;
			if (transfer!=null) {
				result = transfer;
			}
			else {
				result = transfer = TransferInstruction.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Instruction.InstructionBuilder setAllocation(AllocationInstruction allocation) {
			this.allocation = allocation==null?null:allocation.toBuilder();
			return this;
		}
		@Override
		public Instruction.InstructionBuilder setClearing(ClearingInstruction clearing) {
			this.clearing = clearing==null?null:clearing.toBuilder();
			return this;
		}
		@Override
		public Instruction.InstructionBuilder setContractFormation(ContractFormationInstruction contractFormation) {
			this.contractFormation = contractFormation==null?null:contractFormation.toBuilder();
			return this;
		}
		@Override
		public Instruction.InstructionBuilder setDecrease(DecreaseInstruction decrease) {
			this.decrease = decrease==null?null:decrease.toBuilder();
			return this;
		}
		@Override
		public Instruction.InstructionBuilder setExecution(ExecutionInstruction execution) {
			this.execution = execution==null?null:execution.toBuilder();
			return this;
		}
		@Override
		public Instruction.InstructionBuilder setExercise(ExerciseInstruction exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		public Instruction.InstructionBuilder setIncrease(IncreaseInstruction increase) {
			this.increase = increase==null?null:increase.toBuilder();
			return this;
		}
		@Override
		public Instruction.InstructionBuilder setIndexTransition(IndexTransitionInstruction indexTransition) {
			this.indexTransition = indexTransition==null?null:indexTransition.toBuilder();
			return this;
		}
		@Override
		public Instruction.InstructionBuilder setInstructionFunction(String instructionFunction) {
			this.instructionFunction = instructionFunction==null?null:instructionFunction;
			return this;
		}
		@Override
		public Instruction.InstructionBuilder setReset(ResetInstruction reset) {
			this.reset = reset==null?null:reset.toBuilder();
			return this;
		}
		@Override
		public Instruction.InstructionBuilder setTransfer(TransferInstruction transfer) {
			this.transfer = transfer==null?null:transfer.toBuilder();
			return this;
		}
		
		@Override
		public Instruction build() {
			return new Instruction.InstructionImpl(this);
		}
		
		@Override
		public Instruction.InstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Instruction.InstructionBuilder prune() {
			if (allocation!=null && !allocation.prune().hasData()) allocation = null;
			if (clearing!=null && !clearing.prune().hasData()) clearing = null;
			if (contractFormation!=null && !contractFormation.prune().hasData()) contractFormation = null;
			if (decrease!=null && !decrease.prune().hasData()) decrease = null;
			if (execution!=null && !execution.prune().hasData()) execution = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (increase!=null && !increase.prune().hasData()) increase = null;
			if (indexTransition!=null && !indexTransition.prune().hasData()) indexTransition = null;
			if (reset!=null && !reset.prune().hasData()) reset = null;
			if (transfer!=null && !transfer.prune().hasData()) transfer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllocation()!=null && getAllocation().hasData()) return true;
			if (getClearing()!=null && getClearing().hasData()) return true;
			if (getContractFormation()!=null && getContractFormation().hasData()) return true;
			if (getDecrease()!=null && getDecrease().hasData()) return true;
			if (getExecution()!=null && getExecution().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getIncrease()!=null && getIncrease().hasData()) return true;
			if (getIndexTransition()!=null && getIndexTransition().hasData()) return true;
			if (getInstructionFunction()!=null) return true;
			if (getReset()!=null && getReset().hasData()) return true;
			if (getTransfer()!=null && getTransfer().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Instruction.InstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Instruction.InstructionBuilder o = (Instruction.InstructionBuilder) other;
			
			merger.mergeRosetta(getAllocation(), o.getAllocation(), this::setAllocation);
			merger.mergeRosetta(getClearing(), o.getClearing(), this::setClearing);
			merger.mergeRosetta(getContractFormation(), o.getContractFormation(), this::setContractFormation);
			merger.mergeRosetta(getDecrease(), o.getDecrease(), this::setDecrease);
			merger.mergeRosetta(getExecution(), o.getExecution(), this::setExecution);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getIncrease(), o.getIncrease(), this::setIncrease);
			merger.mergeRosetta(getIndexTransition(), o.getIndexTransition(), this::setIndexTransition);
			merger.mergeRosetta(getReset(), o.getReset(), this::setReset);
			merger.mergeRosetta(getTransfer(), o.getTransfer(), this::setTransfer);
			
			merger.mergeBasic(getInstructionFunction(), o.getInstructionFunction(), this::setInstructionFunction);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Instruction _that = getType().cast(o);
		
			if (!Objects.equals(allocation, _that.getAllocation())) return false;
			if (!Objects.equals(clearing, _that.getClearing())) return false;
			if (!Objects.equals(contractFormation, _that.getContractFormation())) return false;
			if (!Objects.equals(decrease, _that.getDecrease())) return false;
			if (!Objects.equals(execution, _that.getExecution())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(increase, _that.getIncrease())) return false;
			if (!Objects.equals(indexTransition, _that.getIndexTransition())) return false;
			if (!Objects.equals(instructionFunction, _that.getInstructionFunction())) return false;
			if (!Objects.equals(reset, _that.getReset())) return false;
			if (!Objects.equals(transfer, _that.getTransfer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocation != null ? allocation.hashCode() : 0);
			_result = 31 * _result + (clearing != null ? clearing.hashCode() : 0);
			_result = 31 * _result + (contractFormation != null ? contractFormation.hashCode() : 0);
			_result = 31 * _result + (decrease != null ? decrease.hashCode() : 0);
			_result = 31 * _result + (execution != null ? execution.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (increase != null ? increase.hashCode() : 0);
			_result = 31 * _result + (indexTransition != null ? indexTransition.hashCode() : 0);
			_result = 31 * _result + (instructionFunction != null ? instructionFunction.hashCode() : 0);
			_result = 31 * _result + (reset != null ? reset.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstructionBuilder {" +
				"allocation=" + this.allocation + ", " +
				"clearing=" + this.clearing + ", " +
				"contractFormation=" + this.contractFormation + ", " +
				"decrease=" + this.decrease + ", " +
				"execution=" + this.execution + ", " +
				"exercise=" + this.exercise + ", " +
				"increase=" + this.increase + ", " +
				"indexTransition=" + this.indexTransition + ", " +
				"instructionFunction=" + this.instructionFunction + ", " +
				"reset=" + this.reset + ", " +
				"transfer=" + this.transfer +
			'}';
		}
	}
}
