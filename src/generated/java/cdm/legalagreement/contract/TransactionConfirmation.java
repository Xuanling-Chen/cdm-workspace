package cdm.legalagreement.contract;

import cdm.legalagreement.contract.meta.TransactionConfirmationMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;


/**
 * See existing Contract type
 * @version ${project.version}
 */
@RosettaClass

public interface TransactionConfirmation extends RosettaModelObject {
	TransactionConfirmation build();
	TransactionConfirmation.TransactionConfirmationBuilder toBuilder();
	
	final static TransactionConfirmationMeta metaData = new TransactionConfirmationMeta();
	
	@Override
	default RosettaMetaData<? extends TransactionConfirmation> metaData() {
		return metaData;
	} 
			
	static TransactionConfirmation.TransactionConfirmationBuilder builder() {
		return new TransactionConfirmation.TransactionConfirmationBuilderImpl();
	}
	
	default Class<? extends TransactionConfirmation> getType() {
		return TransactionConfirmation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
	}
	
	
	interface TransactionConfirmationBuilder extends TransactionConfirmation, RosettaModelObjectBuilder {
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
		}
		
	}
	
	//TransactionConfirmation.TransactionConfirmationImpl
	class TransactionConfirmationImpl implements TransactionConfirmation {
		
		protected TransactionConfirmationImpl(TransactionConfirmation.TransactionConfirmationBuilder builder) {
		}
		
		@Override
		public TransactionConfirmation build() {
			return this;
		}
		
		@Override
		public TransactionConfirmation.TransactionConfirmationBuilder toBuilder() {
			TransactionConfirmation.TransactionConfirmationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransactionConfirmation.TransactionConfirmationBuilder builder) {
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransactionConfirmation {" +
			'}';
		}
	}
	
	//TransactionConfirmation.TransactionConfirmationBuilderImpl
	class TransactionConfirmationBuilderImpl implements TransactionConfirmation.TransactionConfirmationBuilder {
	
	
		public TransactionConfirmationBuilderImpl() {
		}
	
	
		
		@Override
		public TransactionConfirmation build() {
			return new TransactionConfirmation.TransactionConfirmationImpl(this);
		}
		
		@Override
		public TransactionConfirmation.TransactionConfirmationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransactionConfirmation.TransactionConfirmationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransactionConfirmation.TransactionConfirmationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransactionConfirmation.TransactionConfirmationBuilder o = (TransactionConfirmation.TransactionConfirmationBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransactionConfirmationBuilder {" +
			'}';
		}
	}
}
