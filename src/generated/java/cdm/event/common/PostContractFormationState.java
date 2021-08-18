package cdm.event.common;

import cdm.event.common.ContractState.ContractStateBuilder;
import cdm.event.common.ContractState.ContractStateBuilderImpl;
import cdm.event.common.ContractState.ContractStateImpl;
import cdm.event.common.meta.PostContractFormationStateMeta;
import cdm.event.workflow.CreditLimitInformation;
import cdm.event.workflow.TradeWarehouseWorkflow;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface PostContractFormationState extends ContractState {
	PostContractFormationState build();
	PostContractFormationState.PostContractFormationStateBuilder toBuilder();
	
	/**
	 * Credit limit utilization information.
	 */
	CreditLimitInformation getCreditLimitInformation();
	/**
	 * Information related to trade warehouse workflow.
	 */
	TradeWarehouseWorkflow getTradeWarehouseWorkflow();
	final static PostContractFormationStateMeta metaData = new PostContractFormationStateMeta();
	
	@Override
	default RosettaMetaData<? extends PostContractFormationState> metaData() {
		return metaData;
	} 
			
	static PostContractFormationState.PostContractFormationStateBuilder builder() {
		return new PostContractFormationState.PostContractFormationStateBuilderImpl();
	}
	
	default Class<? extends PostContractFormationState> getType() {
		return PostContractFormationState.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.event.common.ContractState.super.process(path, processor);
		
		processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.class, getCreditLimitInformation());
		processRosetta(path.newSubPath("tradeWarehouseWorkflow"), processor, TradeWarehouseWorkflow.class, getTradeWarehouseWorkflow());
	}
	
	
	interface PostContractFormationStateBuilder extends PostContractFormationState, ContractState.ContractStateBuilder, RosettaModelObjectBuilder {
		CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation();
		CreditLimitInformation.CreditLimitInformationBuilder getCreditLimitInformation();
		TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder getOrCreateTradeWarehouseWorkflow();
		TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder getTradeWarehouseWorkflow();
		PostContractFormationState.PostContractFormationStateBuilder setCreditLimitInformation(CreditLimitInformation creditLimitInformation);
		PostContractFormationState.PostContractFormationStateBuilder setTradeWarehouseWorkflow(TradeWarehouseWorkflow tradeWarehouseWorkflow);
		PostContractFormationState.PostContractFormationStateBuilder setMeta(MetaFields meta);
		PostContractFormationState.PostContractFormationStateBuilder setTrade(Trade trade);
		PostContractFormationState.PostContractFormationStateBuilder setUpdatedTrade(Trade updatedTrade);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			ContractState.ContractStateBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.CreditLimitInformationBuilder.class, getCreditLimitInformation());
			processRosetta(path.newSubPath("tradeWarehouseWorkflow"), processor, TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder.class, getTradeWarehouseWorkflow());
		}
		
	}
	
	//PostContractFormationState.PostContractFormationStateImpl
	class PostContractFormationStateImpl extends ContractState.ContractStateImpl implements PostContractFormationState {
		private final CreditLimitInformation creditLimitInformation;
		private final TradeWarehouseWorkflow tradeWarehouseWorkflow;
		
		protected PostContractFormationStateImpl(PostContractFormationState.PostContractFormationStateBuilder builder) {
			super(builder);
			this.creditLimitInformation = ofNullable(builder.getCreditLimitInformation()).map(f->f.build()).orElse(null);
			this.tradeWarehouseWorkflow = ofNullable(builder.getTradeWarehouseWorkflow()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CreditLimitInformation getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		@Override
		public TradeWarehouseWorkflow getTradeWarehouseWorkflow() {
			return tradeWarehouseWorkflow;
		}
		
		@Override
		public PostContractFormationState build() {
			return this;
		}
		
		@Override
		public PostContractFormationState.PostContractFormationStateBuilder toBuilder() {
			PostContractFormationState.PostContractFormationStateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostContractFormationState.PostContractFormationStateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCreditLimitInformation()).ifPresent(builder::setCreditLimitInformation);
			ofNullable(getTradeWarehouseWorkflow()).ifPresent(builder::setTradeWarehouseWorkflow);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PostContractFormationState _that = getType().cast(o);
		
			if (!Objects.equals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!Objects.equals(tradeWarehouseWorkflow, _that.getTradeWarehouseWorkflow())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (tradeWarehouseWorkflow != null ? tradeWarehouseWorkflow.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostContractFormationState {" +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"tradeWarehouseWorkflow=" + this.tradeWarehouseWorkflow +
			'}' + " " + super.toString();
		}
	}
	
	//PostContractFormationState.PostContractFormationStateBuilderImpl
	class PostContractFormationStateBuilderImpl extends ContractState.ContractStateBuilderImpl  implements PostContractFormationState.PostContractFormationStateBuilder {
	
		protected CreditLimitInformation.CreditLimitInformationBuilder creditLimitInformation;
		protected TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder tradeWarehouseWorkflow;
	
		public PostContractFormationStateBuilderImpl() {
		}
	
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation() {
			CreditLimitInformation.CreditLimitInformationBuilder result;
			if (creditLimitInformation!=null) {
				result = creditLimitInformation;
			}
			else {
				result = creditLimitInformation = CreditLimitInformation.builder();
			}
			
			return result;
		}
		
		@Override
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder getTradeWarehouseWorkflow() {
			return tradeWarehouseWorkflow;
		}
		
		@Override
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder getOrCreateTradeWarehouseWorkflow() {
			TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder result;
			if (tradeWarehouseWorkflow!=null) {
				result = tradeWarehouseWorkflow;
			}
			else {
				result = tradeWarehouseWorkflow = TradeWarehouseWorkflow.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PostContractFormationState.PostContractFormationStateBuilder setCreditLimitInformation(CreditLimitInformation creditLimitInformation) {
			this.creditLimitInformation = creditLimitInformation==null?null:creditLimitInformation.toBuilder();
			return this;
		}
		@Override
		public PostContractFormationState.PostContractFormationStateBuilder setTradeWarehouseWorkflow(TradeWarehouseWorkflow tradeWarehouseWorkflow) {
			this.tradeWarehouseWorkflow = tradeWarehouseWorkflow==null?null:tradeWarehouseWorkflow.toBuilder();
			return this;
		}
		@Override
		public PostContractFormationState.PostContractFormationStateBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public PostContractFormationState.PostContractFormationStateBuilder setTrade(Trade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		@Override
		public PostContractFormationState.PostContractFormationStateBuilder setUpdatedTrade(Trade updatedTrade) {
			this.updatedTrade = updatedTrade==null?null:updatedTrade.toBuilder();
			return this;
		}
		
		@Override
		public PostContractFormationState build() {
			return new PostContractFormationState.PostContractFormationStateImpl(this);
		}
		
		@Override
		public PostContractFormationState.PostContractFormationStateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostContractFormationState.PostContractFormationStateBuilder prune() {
			super.prune();
			if (creditLimitInformation!=null && !creditLimitInformation.prune().hasData()) creditLimitInformation = null;
			if (tradeWarehouseWorkflow!=null && !tradeWarehouseWorkflow.prune().hasData()) tradeWarehouseWorkflow = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCreditLimitInformation()!=null && getCreditLimitInformation().hasData()) return true;
			if (getTradeWarehouseWorkflow()!=null && getTradeWarehouseWorkflow().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostContractFormationState.PostContractFormationStateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PostContractFormationState.PostContractFormationStateBuilder o = (PostContractFormationState.PostContractFormationStateBuilder) other;
			
			merger.mergeRosetta(getCreditLimitInformation(), o.getCreditLimitInformation(), this::setCreditLimitInformation);
			merger.mergeRosetta(getTradeWarehouseWorkflow(), o.getTradeWarehouseWorkflow(), this::setTradeWarehouseWorkflow);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PostContractFormationState _that = getType().cast(o);
		
			if (!Objects.equals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!Objects.equals(tradeWarehouseWorkflow, _that.getTradeWarehouseWorkflow())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (tradeWarehouseWorkflow != null ? tradeWarehouseWorkflow.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostContractFormationStateBuilder {" +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"tradeWarehouseWorkflow=" + this.tradeWarehouseWorkflow +
			'}' + " " + super.toString();
		}
	}
}
