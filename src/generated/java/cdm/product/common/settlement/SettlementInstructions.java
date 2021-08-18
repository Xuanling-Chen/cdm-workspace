package cdm.product.common.settlement;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.meta.SettlementInstructionsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;


/**
 * @version ${project.version}
 */
@RosettaClass

public interface SettlementInstructions extends PayoutBase {
	SettlementInstructions build();
	SettlementInstructions.SettlementInstructionsBuilder toBuilder();
	
	final static SettlementInstructionsMeta metaData = new SettlementInstructionsMeta();
	
	@Override
	default RosettaMetaData<? extends SettlementInstructions> metaData() {
		return metaData;
	} 
			
	static SettlementInstructions.SettlementInstructionsBuilder builder() {
		return new SettlementInstructions.SettlementInstructionsBuilderImpl();
	}
	
	default Class<? extends SettlementInstructions> getType() {
		return SettlementInstructions.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.common.settlement.PayoutBase.super.process(path, processor);
		
	}
	
	
	interface SettlementInstructionsBuilder extends SettlementInstructions, PayoutBase.PayoutBaseBuilder, RosettaModelObjectBuilder {
		SettlementInstructions.SettlementInstructionsBuilder setPayerReceiver(PayerReceiver payerReceiver);
		SettlementInstructions.SettlementInstructionsBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity);
		SettlementInstructions.SettlementInstructionsBuilder setSettlementTerms(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PayoutBase.PayoutBaseBuilder.super.process(path, processor);
			
			
		}
		
	}
	
	//SettlementInstructions.SettlementInstructionsImpl
	class SettlementInstructionsImpl extends PayoutBase.PayoutBaseImpl implements SettlementInstructions {
		
		protected SettlementInstructionsImpl(SettlementInstructions.SettlementInstructionsBuilder builder) {
			super(builder);
		}
		
		@Override
		public SettlementInstructions build() {
			return this;
		}
		
		@Override
		public SettlementInstructions.SettlementInstructionsBuilder toBuilder() {
			SettlementInstructions.SettlementInstructionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementInstructions.SettlementInstructionsBuilder builder) {
			super.setBuilderFields(builder);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInstructions {" +
			'}' + " " + super.toString();
		}
	}
	
	//SettlementInstructions.SettlementInstructionsBuilderImpl
	class SettlementInstructionsBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl  implements SettlementInstructions.SettlementInstructionsBuilder {
	
	
		public SettlementInstructionsBuilderImpl() {
		}
	
	
		@Override
		public SettlementInstructions.SettlementInstructionsBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public SettlementInstructions.SettlementInstructionsBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity) {
			this.payoutQuantity = payoutQuantity==null?null:payoutQuantity.toBuilder();
			return this;
		}
		@Override
		public SettlementInstructions.SettlementInstructionsBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public SettlementInstructions build() {
			return new SettlementInstructions.SettlementInstructionsImpl(this);
		}
		
		@Override
		public SettlementInstructions.SettlementInstructionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInstructions.SettlementInstructionsBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInstructions.SettlementInstructionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SettlementInstructions.SettlementInstructionsBuilder o = (SettlementInstructions.SettlementInstructionsBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInstructionsBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
