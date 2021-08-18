package cdm.event.common;

import cdm.event.common.meta.PrimitiveEventMeta;
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
 * A primitive event is defined by one and only one atomic change in state of a trade. An example of this is a contract formation where the legal terms of the contact are added to the trade. A Primitive event contains a before and after state where the before is a reference to another after state of a primitive event in order to preserve lineage.
 * @version ${project.version}
 */
@RosettaClass

public interface PrimitiveEvent extends RosettaModelObject {
	PrimitiveEvent build();
	PrimitiveEvent.PrimitiveEventBuilder toBuilder();
	
	/**
	 */
	ContractFormationPrimitive getContractFormation();
	/**
	 */
	ExecutionPrimitive getExecution();
	/**
	 */
	QuantityChangePrimitive getQuantityChange();
	/**
	 */
	ResetPrimitive getReset();
	/**
	 */
	SplitPrimitive getSplit();
	/**
	 */
	TermsChangePrimitive getTermsChange();
	/**
	 */
	TransferPrimitive getTransfer();
	final static PrimitiveEventMeta metaData = new PrimitiveEventMeta();
	
	@Override
	default RosettaMetaData<? extends PrimitiveEvent> metaData() {
		return metaData;
	} 
			
	static PrimitiveEvent.PrimitiveEventBuilder builder() {
		return new PrimitiveEvent.PrimitiveEventBuilderImpl();
	}
	
	default Class<? extends PrimitiveEvent> getType() {
		return PrimitiveEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("contractFormation"), processor, ContractFormationPrimitive.class, getContractFormation());
		processRosetta(path.newSubPath("execution"), processor, ExecutionPrimitive.class, getExecution());
		processRosetta(path.newSubPath("quantityChange"), processor, QuantityChangePrimitive.class, getQuantityChange());
		processRosetta(path.newSubPath("reset"), processor, ResetPrimitive.class, getReset());
		processRosetta(path.newSubPath("split"), processor, SplitPrimitive.class, getSplit());
		processRosetta(path.newSubPath("termsChange"), processor, TermsChangePrimitive.class, getTermsChange());
		processRosetta(path.newSubPath("transfer"), processor, TransferPrimitive.class, getTransfer());
	}
	
	
	interface PrimitiveEventBuilder extends PrimitiveEvent, RosettaModelObjectBuilder {
		ContractFormationPrimitive.ContractFormationPrimitiveBuilder getOrCreateContractFormation();
		ContractFormationPrimitive.ContractFormationPrimitiveBuilder getContractFormation();
		ExecutionPrimitive.ExecutionPrimitiveBuilder getOrCreateExecution();
		ExecutionPrimitive.ExecutionPrimitiveBuilder getExecution();
		QuantityChangePrimitive.QuantityChangePrimitiveBuilder getOrCreateQuantityChange();
		QuantityChangePrimitive.QuantityChangePrimitiveBuilder getQuantityChange();
		ResetPrimitive.ResetPrimitiveBuilder getOrCreateReset();
		ResetPrimitive.ResetPrimitiveBuilder getReset();
		SplitPrimitive.SplitPrimitiveBuilder getOrCreateSplit();
		SplitPrimitive.SplitPrimitiveBuilder getSplit();
		TermsChangePrimitive.TermsChangePrimitiveBuilder getOrCreateTermsChange();
		TermsChangePrimitive.TermsChangePrimitiveBuilder getTermsChange();
		TransferPrimitive.TransferPrimitiveBuilder getOrCreateTransfer();
		TransferPrimitive.TransferPrimitiveBuilder getTransfer();
		PrimitiveEvent.PrimitiveEventBuilder setContractFormation(ContractFormationPrimitive contractFormation);
		PrimitiveEvent.PrimitiveEventBuilder setExecution(ExecutionPrimitive execution);
		PrimitiveEvent.PrimitiveEventBuilder setQuantityChange(QuantityChangePrimitive quantityChange);
		PrimitiveEvent.PrimitiveEventBuilder setReset(ResetPrimitive reset);
		PrimitiveEvent.PrimitiveEventBuilder setSplit(SplitPrimitive split);
		PrimitiveEvent.PrimitiveEventBuilder setTermsChange(TermsChangePrimitive termsChange);
		PrimitiveEvent.PrimitiveEventBuilder setTransfer(TransferPrimitive transfer);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("contractFormation"), processor, ContractFormationPrimitive.ContractFormationPrimitiveBuilder.class, getContractFormation());
			processRosetta(path.newSubPath("execution"), processor, ExecutionPrimitive.ExecutionPrimitiveBuilder.class, getExecution());
			processRosetta(path.newSubPath("quantityChange"), processor, QuantityChangePrimitive.QuantityChangePrimitiveBuilder.class, getQuantityChange());
			processRosetta(path.newSubPath("reset"), processor, ResetPrimitive.ResetPrimitiveBuilder.class, getReset());
			processRosetta(path.newSubPath("split"), processor, SplitPrimitive.SplitPrimitiveBuilder.class, getSplit());
			processRosetta(path.newSubPath("termsChange"), processor, TermsChangePrimitive.TermsChangePrimitiveBuilder.class, getTermsChange());
			processRosetta(path.newSubPath("transfer"), processor, TransferPrimitive.TransferPrimitiveBuilder.class, getTransfer());
		}
		
	}
	
	//PrimitiveEvent.PrimitiveEventImpl
	class PrimitiveEventImpl implements PrimitiveEvent {
		private final ContractFormationPrimitive contractFormation;
		private final ExecutionPrimitive execution;
		private final QuantityChangePrimitive quantityChange;
		private final ResetPrimitive reset;
		private final SplitPrimitive split;
		private final TermsChangePrimitive termsChange;
		private final TransferPrimitive transfer;
		
		protected PrimitiveEventImpl(PrimitiveEvent.PrimitiveEventBuilder builder) {
			this.contractFormation = ofNullable(builder.getContractFormation()).map(f->f.build()).orElse(null);
			this.execution = ofNullable(builder.getExecution()).map(f->f.build()).orElse(null);
			this.quantityChange = ofNullable(builder.getQuantityChange()).map(f->f.build()).orElse(null);
			this.reset = ofNullable(builder.getReset()).map(f->f.build()).orElse(null);
			this.split = ofNullable(builder.getSplit()).map(f->f.build()).orElse(null);
			this.termsChange = ofNullable(builder.getTermsChange()).map(f->f.build()).orElse(null);
			this.transfer = ofNullable(builder.getTransfer()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ContractFormationPrimitive getContractFormation() {
			return contractFormation;
		}
		
		@Override
		public ExecutionPrimitive getExecution() {
			return execution;
		}
		
		@Override
		public QuantityChangePrimitive getQuantityChange() {
			return quantityChange;
		}
		
		@Override
		public ResetPrimitive getReset() {
			return reset;
		}
		
		@Override
		public SplitPrimitive getSplit() {
			return split;
		}
		
		@Override
		public TermsChangePrimitive getTermsChange() {
			return termsChange;
		}
		
		@Override
		public TransferPrimitive getTransfer() {
			return transfer;
		}
		
		@Override
		public PrimitiveEvent build() {
			return this;
		}
		
		@Override
		public PrimitiveEvent.PrimitiveEventBuilder toBuilder() {
			PrimitiveEvent.PrimitiveEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrimitiveEvent.PrimitiveEventBuilder builder) {
			ofNullable(getContractFormation()).ifPresent(builder::setContractFormation);
			ofNullable(getExecution()).ifPresent(builder::setExecution);
			ofNullable(getQuantityChange()).ifPresent(builder::setQuantityChange);
			ofNullable(getReset()).ifPresent(builder::setReset);
			ofNullable(getSplit()).ifPresent(builder::setSplit);
			ofNullable(getTermsChange()).ifPresent(builder::setTermsChange);
			ofNullable(getTransfer()).ifPresent(builder::setTransfer);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrimitiveEvent _that = getType().cast(o);
		
			if (!Objects.equals(contractFormation, _that.getContractFormation())) return false;
			if (!Objects.equals(execution, _that.getExecution())) return false;
			if (!Objects.equals(quantityChange, _that.getQuantityChange())) return false;
			if (!Objects.equals(reset, _that.getReset())) return false;
			if (!Objects.equals(split, _that.getSplit())) return false;
			if (!Objects.equals(termsChange, _that.getTermsChange())) return false;
			if (!Objects.equals(transfer, _that.getTransfer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractFormation != null ? contractFormation.hashCode() : 0);
			_result = 31 * _result + (execution != null ? execution.hashCode() : 0);
			_result = 31 * _result + (quantityChange != null ? quantityChange.hashCode() : 0);
			_result = 31 * _result + (reset != null ? reset.hashCode() : 0);
			_result = 31 * _result + (split != null ? split.hashCode() : 0);
			_result = 31 * _result + (termsChange != null ? termsChange.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrimitiveEvent {" +
				"contractFormation=" + this.contractFormation + ", " +
				"execution=" + this.execution + ", " +
				"quantityChange=" + this.quantityChange + ", " +
				"reset=" + this.reset + ", " +
				"split=" + this.split + ", " +
				"termsChange=" + this.termsChange + ", " +
				"transfer=" + this.transfer +
			'}';
		}
	}
	
	//PrimitiveEvent.PrimitiveEventBuilderImpl
	class PrimitiveEventBuilderImpl implements PrimitiveEvent.PrimitiveEventBuilder {
	
		protected ContractFormationPrimitive.ContractFormationPrimitiveBuilder contractFormation;
		protected ExecutionPrimitive.ExecutionPrimitiveBuilder execution;
		protected QuantityChangePrimitive.QuantityChangePrimitiveBuilder quantityChange;
		protected ResetPrimitive.ResetPrimitiveBuilder reset;
		protected SplitPrimitive.SplitPrimitiveBuilder split;
		protected TermsChangePrimitive.TermsChangePrimitiveBuilder termsChange;
		protected TransferPrimitive.TransferPrimitiveBuilder transfer;
	
		public PrimitiveEventBuilderImpl() {
		}
	
		@Override
		public ContractFormationPrimitive.ContractFormationPrimitiveBuilder getContractFormation() {
			return contractFormation;
		}
		
		@Override
		public ContractFormationPrimitive.ContractFormationPrimitiveBuilder getOrCreateContractFormation() {
			ContractFormationPrimitive.ContractFormationPrimitiveBuilder result;
			if (contractFormation!=null) {
				result = contractFormation;
			}
			else {
				result = contractFormation = ContractFormationPrimitive.builder();
			}
			
			return result;
		}
		
		@Override
		public ExecutionPrimitive.ExecutionPrimitiveBuilder getExecution() {
			return execution;
		}
		
		@Override
		public ExecutionPrimitive.ExecutionPrimitiveBuilder getOrCreateExecution() {
			ExecutionPrimitive.ExecutionPrimitiveBuilder result;
			if (execution!=null) {
				result = execution;
			}
			else {
				result = execution = ExecutionPrimitive.builder();
			}
			
			return result;
		}
		
		@Override
		public QuantityChangePrimitive.QuantityChangePrimitiveBuilder getQuantityChange() {
			return quantityChange;
		}
		
		@Override
		public QuantityChangePrimitive.QuantityChangePrimitiveBuilder getOrCreateQuantityChange() {
			QuantityChangePrimitive.QuantityChangePrimitiveBuilder result;
			if (quantityChange!=null) {
				result = quantityChange;
			}
			else {
				result = quantityChange = QuantityChangePrimitive.builder();
			}
			
			return result;
		}
		
		@Override
		public ResetPrimitive.ResetPrimitiveBuilder getReset() {
			return reset;
		}
		
		@Override
		public ResetPrimitive.ResetPrimitiveBuilder getOrCreateReset() {
			ResetPrimitive.ResetPrimitiveBuilder result;
			if (reset!=null) {
				result = reset;
			}
			else {
				result = reset = ResetPrimitive.builder();
			}
			
			return result;
		}
		
		@Override
		public SplitPrimitive.SplitPrimitiveBuilder getSplit() {
			return split;
		}
		
		@Override
		public SplitPrimitive.SplitPrimitiveBuilder getOrCreateSplit() {
			SplitPrimitive.SplitPrimitiveBuilder result;
			if (split!=null) {
				result = split;
			}
			else {
				result = split = SplitPrimitive.builder();
			}
			
			return result;
		}
		
		@Override
		public TermsChangePrimitive.TermsChangePrimitiveBuilder getTermsChange() {
			return termsChange;
		}
		
		@Override
		public TermsChangePrimitive.TermsChangePrimitiveBuilder getOrCreateTermsChange() {
			TermsChangePrimitive.TermsChangePrimitiveBuilder result;
			if (termsChange!=null) {
				result = termsChange;
			}
			else {
				result = termsChange = TermsChangePrimitive.builder();
			}
			
			return result;
		}
		
		@Override
		public TransferPrimitive.TransferPrimitiveBuilder getTransfer() {
			return transfer;
		}
		
		@Override
		public TransferPrimitive.TransferPrimitiveBuilder getOrCreateTransfer() {
			TransferPrimitive.TransferPrimitiveBuilder result;
			if (transfer!=null) {
				result = transfer;
			}
			else {
				result = transfer = TransferPrimitive.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PrimitiveEvent.PrimitiveEventBuilder setContractFormation(ContractFormationPrimitive contractFormation) {
			this.contractFormation = contractFormation==null?null:contractFormation.toBuilder();
			return this;
		}
		@Override
		public PrimitiveEvent.PrimitiveEventBuilder setExecution(ExecutionPrimitive execution) {
			this.execution = execution==null?null:execution.toBuilder();
			return this;
		}
		@Override
		public PrimitiveEvent.PrimitiveEventBuilder setQuantityChange(QuantityChangePrimitive quantityChange) {
			this.quantityChange = quantityChange==null?null:quantityChange.toBuilder();
			return this;
		}
		@Override
		public PrimitiveEvent.PrimitiveEventBuilder setReset(ResetPrimitive reset) {
			this.reset = reset==null?null:reset.toBuilder();
			return this;
		}
		@Override
		public PrimitiveEvent.PrimitiveEventBuilder setSplit(SplitPrimitive split) {
			this.split = split==null?null:split.toBuilder();
			return this;
		}
		@Override
		public PrimitiveEvent.PrimitiveEventBuilder setTermsChange(TermsChangePrimitive termsChange) {
			this.termsChange = termsChange==null?null:termsChange.toBuilder();
			return this;
		}
		@Override
		public PrimitiveEvent.PrimitiveEventBuilder setTransfer(TransferPrimitive transfer) {
			this.transfer = transfer==null?null:transfer.toBuilder();
			return this;
		}
		
		@Override
		public PrimitiveEvent build() {
			return new PrimitiveEvent.PrimitiveEventImpl(this);
		}
		
		@Override
		public PrimitiveEvent.PrimitiveEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrimitiveEvent.PrimitiveEventBuilder prune() {
			if (contractFormation!=null && !contractFormation.prune().hasData()) contractFormation = null;
			if (execution!=null && !execution.prune().hasData()) execution = null;
			if (quantityChange!=null && !quantityChange.prune().hasData()) quantityChange = null;
			if (reset!=null && !reset.prune().hasData()) reset = null;
			if (split!=null && !split.prune().hasData()) split = null;
			if (termsChange!=null && !termsChange.prune().hasData()) termsChange = null;
			if (transfer!=null && !transfer.prune().hasData()) transfer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContractFormation()!=null && getContractFormation().hasData()) return true;
			if (getExecution()!=null && getExecution().hasData()) return true;
			if (getQuantityChange()!=null && getQuantityChange().hasData()) return true;
			if (getReset()!=null && getReset().hasData()) return true;
			if (getSplit()!=null && getSplit().hasData()) return true;
			if (getTermsChange()!=null && getTermsChange().hasData()) return true;
			if (getTransfer()!=null && getTransfer().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrimitiveEvent.PrimitiveEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrimitiveEvent.PrimitiveEventBuilder o = (PrimitiveEvent.PrimitiveEventBuilder) other;
			
			merger.mergeRosetta(getContractFormation(), o.getContractFormation(), this::setContractFormation);
			merger.mergeRosetta(getExecution(), o.getExecution(), this::setExecution);
			merger.mergeRosetta(getQuantityChange(), o.getQuantityChange(), this::setQuantityChange);
			merger.mergeRosetta(getReset(), o.getReset(), this::setReset);
			merger.mergeRosetta(getSplit(), o.getSplit(), this::setSplit);
			merger.mergeRosetta(getTermsChange(), o.getTermsChange(), this::setTermsChange);
			merger.mergeRosetta(getTransfer(), o.getTransfer(), this::setTransfer);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrimitiveEvent _that = getType().cast(o);
		
			if (!Objects.equals(contractFormation, _that.getContractFormation())) return false;
			if (!Objects.equals(execution, _that.getExecution())) return false;
			if (!Objects.equals(quantityChange, _that.getQuantityChange())) return false;
			if (!Objects.equals(reset, _that.getReset())) return false;
			if (!Objects.equals(split, _that.getSplit())) return false;
			if (!Objects.equals(termsChange, _that.getTermsChange())) return false;
			if (!Objects.equals(transfer, _that.getTransfer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractFormation != null ? contractFormation.hashCode() : 0);
			_result = 31 * _result + (execution != null ? execution.hashCode() : 0);
			_result = 31 * _result + (quantityChange != null ? quantityChange.hashCode() : 0);
			_result = 31 * _result + (reset != null ? reset.hashCode() : 0);
			_result = 31 * _result + (split != null ? split.hashCode() : 0);
			_result = 31 * _result + (termsChange != null ? termsChange.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrimitiveEventBuilder {" +
				"contractFormation=" + this.contractFormation + ", " +
				"execution=" + this.execution + ", " +
				"quantityChange=" + this.quantityChange + ", " +
				"reset=" + this.reset + ", " +
				"split=" + this.split + ", " +
				"termsChange=" + this.termsChange + ", " +
				"transfer=" + this.transfer +
			'}';
		}
	}
}
