package cdm.event.common;

import cdm.event.common.meta.ContractFormationInstructionMeta;
import cdm.legalagreement.common.LegalAgreement;
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
 * Specifies instructions for transition from execution to a fully formed contract, consisting of an execution and an optional legal agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface ContractFormationInstruction extends RosettaModelObject {
	ContractFormationInstruction build();
	ContractFormationInstruction.ContractFormationInstructionBuilder toBuilder();
	
	/**
	 * Execution consisting of the economic terms which are agreed between the parties.
	 */
	TradeState getExecution();
	/**
	 * Optional legal agreements associated to the contract being formed, for instance a master agreement.
	 */
	List<? extends LegalAgreement> getLegalAgreement();
	final static ContractFormationInstructionMeta metaData = new ContractFormationInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends ContractFormationInstruction> metaData() {
		return metaData;
	} 
			
	static ContractFormationInstruction.ContractFormationInstructionBuilder builder() {
		return new ContractFormationInstruction.ContractFormationInstructionBuilderImpl();
	}
	
	default Class<? extends ContractFormationInstruction> getType() {
		return ContractFormationInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("execution"), processor, TradeState.class, getExecution());
		processRosetta(path.newSubPath("legalAgreement"), processor, LegalAgreement.class, getLegalAgreement());
	}
	
	
	interface ContractFormationInstructionBuilder extends ContractFormationInstruction, RosettaModelObjectBuilder {
		TradeState.TradeStateBuilder getOrCreateExecution();
		TradeState.TradeStateBuilder getExecution();
		LegalAgreement.LegalAgreementBuilder getOrCreateLegalAgreement(int _index);
		List<? extends LegalAgreement.LegalAgreementBuilder> getLegalAgreement();
		ContractFormationInstruction.ContractFormationInstructionBuilder setExecution(TradeState execution);
		ContractFormationInstruction.ContractFormationInstructionBuilder addLegalAgreement(LegalAgreement legalAgreement);
		ContractFormationInstruction.ContractFormationInstructionBuilder addLegalAgreement(LegalAgreement legalAgreement, int _idx);
		ContractFormationInstruction.ContractFormationInstructionBuilder addLegalAgreement(List<? extends LegalAgreement> legalAgreement);
		ContractFormationInstruction.ContractFormationInstructionBuilder setLegalAgreement(List<? extends LegalAgreement> legalAgreement);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("execution"), processor, TradeState.TradeStateBuilder.class, getExecution());
			processRosetta(path.newSubPath("legalAgreement"), processor, LegalAgreement.LegalAgreementBuilder.class, getLegalAgreement());
		}
		
	}
	
	//ContractFormationInstruction.ContractFormationInstructionImpl
	class ContractFormationInstructionImpl implements ContractFormationInstruction {
		private final TradeState execution;
		private final List<? extends LegalAgreement> legalAgreement;
		
		protected ContractFormationInstructionImpl(ContractFormationInstruction.ContractFormationInstructionBuilder builder) {
			this.execution = ofNullable(builder.getExecution()).map(f->f.build()).orElse(null);
			this.legalAgreement = ofNullable(builder.getLegalAgreement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public TradeState getExecution() {
			return execution;
		}
		
		@Override
		public List<? extends LegalAgreement> getLegalAgreement() {
			return legalAgreement;
		}
		
		@Override
		public ContractFormationInstruction build() {
			return this;
		}
		
		@Override
		public ContractFormationInstruction.ContractFormationInstructionBuilder toBuilder() {
			ContractFormationInstruction.ContractFormationInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractFormationInstruction.ContractFormationInstructionBuilder builder) {
			ofNullable(getExecution()).ifPresent(builder::setExecution);
			ofNullable(getLegalAgreement()).ifPresent(builder::setLegalAgreement);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractFormationInstruction _that = getType().cast(o);
		
			if (!Objects.equals(execution, _that.getExecution())) return false;
			if (!ListEquals.listEquals(legalAgreement, _that.getLegalAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (execution != null ? execution.hashCode() : 0);
			_result = 31 * _result + (legalAgreement != null ? legalAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractFormationInstruction {" +
				"execution=" + this.execution + ", " +
				"legalAgreement=" + this.legalAgreement +
			'}';
		}
	}
	
	//ContractFormationInstruction.ContractFormationInstructionBuilderImpl
	class ContractFormationInstructionBuilderImpl implements ContractFormationInstruction.ContractFormationInstructionBuilder {
	
		protected TradeState.TradeStateBuilder execution;
		protected List<LegalAgreement.LegalAgreementBuilder> legalAgreement = new ArrayList<>();
	
		public ContractFormationInstructionBuilderImpl() {
		}
	
		@Override
		public TradeState.TradeStateBuilder getExecution() {
			return execution;
		}
		
		@Override
		public TradeState.TradeStateBuilder getOrCreateExecution() {
			TradeState.TradeStateBuilder result;
			if (execution!=null) {
				result = execution;
			}
			else {
				result = execution = TradeState.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends LegalAgreement.LegalAgreementBuilder> getLegalAgreement() {
			return legalAgreement;
		}
		
		public LegalAgreement.LegalAgreementBuilder getOrCreateLegalAgreement(int _index) {
		
			if (legalAgreement==null) {
				this.legalAgreement = new ArrayList<>();
			}
			LegalAgreement.LegalAgreementBuilder result;
			return getIndex(legalAgreement, _index, () -> {
						LegalAgreement.LegalAgreementBuilder newLegalAgreement = LegalAgreement.builder();
						return newLegalAgreement;
					});
		}
		
	
		@Override
		public ContractFormationInstruction.ContractFormationInstructionBuilder setExecution(TradeState execution) {
			this.execution = execution==null?null:execution.toBuilder();
			return this;
		}
		@Override
		public ContractFormationInstruction.ContractFormationInstructionBuilder addLegalAgreement(LegalAgreement legalAgreement) {
			if (legalAgreement!=null) this.legalAgreement.add(legalAgreement.toBuilder());
			return this;
		}
		
		@Override
		public ContractFormationInstruction.ContractFormationInstructionBuilder addLegalAgreement(LegalAgreement legalAgreement, int _idx) {
			getIndex(this.legalAgreement, _idx, () -> legalAgreement.toBuilder());
			return this;
		}
		@Override 
		public ContractFormationInstruction.ContractFormationInstructionBuilder addLegalAgreement(List<? extends LegalAgreement> legalAgreements) {
			if (legalAgreements != null) {
				for (LegalAgreement toAdd : legalAgreements) {
					this.legalAgreement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ContractFormationInstruction.ContractFormationInstructionBuilder setLegalAgreement(List<? extends LegalAgreement> legalAgreements) {
			if (legalAgreements == null)  {
				this.legalAgreement = new ArrayList<>();
			}
			else {
				this.legalAgreement = legalAgreements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ContractFormationInstruction build() {
			return new ContractFormationInstruction.ContractFormationInstructionImpl(this);
		}
		
		@Override
		public ContractFormationInstruction.ContractFormationInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractFormationInstruction.ContractFormationInstructionBuilder prune() {
			if (execution!=null && !execution.prune().hasData()) execution = null;
			legalAgreement = legalAgreement.stream().filter(b->b!=null).<LegalAgreement.LegalAgreementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExecution()!=null && getExecution().hasData()) return true;
			if (getLegalAgreement()!=null && getLegalAgreement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractFormationInstruction.ContractFormationInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractFormationInstruction.ContractFormationInstructionBuilder o = (ContractFormationInstruction.ContractFormationInstructionBuilder) other;
			
			merger.mergeRosetta(getExecution(), o.getExecution(), this::setExecution);
			merger.mergeRosetta(getLegalAgreement(), o.getLegalAgreement(), this::getOrCreateLegalAgreement);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractFormationInstruction _that = getType().cast(o);
		
			if (!Objects.equals(execution, _that.getExecution())) return false;
			if (!ListEquals.listEquals(legalAgreement, _that.getLegalAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (execution != null ? execution.hashCode() : 0);
			_result = 31 * _result + (legalAgreement != null ? legalAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractFormationInstructionBuilder {" +
				"execution=" + this.execution + ", " +
				"legalAgreement=" + this.legalAgreement +
			'}';
		}
	}
}
