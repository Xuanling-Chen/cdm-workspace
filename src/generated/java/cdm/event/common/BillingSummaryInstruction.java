package cdm.event.common;

import cdm.event.common.meta.BillingSummaryInstructionMeta;
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
 * Specifies the instructions for creation of a billing summary.
 * @version ${project.version}
 */
@RosettaClass

public interface BillingSummaryInstruction extends RosettaModelObject {
	BillingSummaryInstruction build();
	BillingSummaryInstruction.BillingSummaryInstructionBuilder toBuilder();
	
	/**
	 * The account level for the billing summary.
	 */
	RecordAmountTypeEnum getSummaryAmountType();
	final static BillingSummaryInstructionMeta metaData = new BillingSummaryInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends BillingSummaryInstruction> metaData() {
		return metaData;
	} 
			
	static BillingSummaryInstruction.BillingSummaryInstructionBuilder builder() {
		return new BillingSummaryInstruction.BillingSummaryInstructionBuilderImpl();
	}
	
	default Class<? extends BillingSummaryInstruction> getType() {
		return BillingSummaryInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("summaryAmountType"), RecordAmountTypeEnum.class, getSummaryAmountType(), this);
		
	}
	
	
	interface BillingSummaryInstructionBuilder extends BillingSummaryInstruction, RosettaModelObjectBuilder {
		BillingSummaryInstruction.BillingSummaryInstructionBuilder setSummaryAmountType(RecordAmountTypeEnum summaryAmountType);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("summaryAmountType"), RecordAmountTypeEnum.class, getSummaryAmountType(), this);
			
		}
		
	}
	
	//BillingSummaryInstruction.BillingSummaryInstructionImpl
	class BillingSummaryInstructionImpl implements BillingSummaryInstruction {
		private final RecordAmountTypeEnum summaryAmountType;
		
		protected BillingSummaryInstructionImpl(BillingSummaryInstruction.BillingSummaryInstructionBuilder builder) {
			this.summaryAmountType = builder.getSummaryAmountType();
		}
		
		@Override
		public RecordAmountTypeEnum getSummaryAmountType() {
			return summaryAmountType;
		}
		
		@Override
		public BillingSummaryInstruction build() {
			return this;
		}
		
		@Override
		public BillingSummaryInstruction.BillingSummaryInstructionBuilder toBuilder() {
			BillingSummaryInstruction.BillingSummaryInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BillingSummaryInstruction.BillingSummaryInstructionBuilder builder) {
			ofNullable(getSummaryAmountType()).ifPresent(builder::setSummaryAmountType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingSummaryInstruction _that = getType().cast(o);
		
			if (!Objects.equals(summaryAmountType, _that.getSummaryAmountType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (summaryAmountType != null ? summaryAmountType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingSummaryInstruction {" +
				"summaryAmountType=" + this.summaryAmountType +
			'}';
		}
	}
	
	//BillingSummaryInstruction.BillingSummaryInstructionBuilderImpl
	class BillingSummaryInstructionBuilderImpl implements BillingSummaryInstruction.BillingSummaryInstructionBuilder {
	
		protected RecordAmountTypeEnum summaryAmountType;
	
		public BillingSummaryInstructionBuilderImpl() {
		}
	
		@Override
		public RecordAmountTypeEnum getSummaryAmountType() {
			return summaryAmountType;
		}
		
	
		@Override
		public BillingSummaryInstruction.BillingSummaryInstructionBuilder setSummaryAmountType(RecordAmountTypeEnum summaryAmountType) {
			this.summaryAmountType = summaryAmountType==null?null:summaryAmountType;
			return this;
		}
		
		@Override
		public BillingSummaryInstruction build() {
			return new BillingSummaryInstruction.BillingSummaryInstructionImpl(this);
		}
		
		@Override
		public BillingSummaryInstruction.BillingSummaryInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingSummaryInstruction.BillingSummaryInstructionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSummaryAmountType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingSummaryInstruction.BillingSummaryInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BillingSummaryInstruction.BillingSummaryInstructionBuilder o = (BillingSummaryInstruction.BillingSummaryInstructionBuilder) other;
			
			
			merger.mergeBasic(getSummaryAmountType(), o.getSummaryAmountType(), this::setSummaryAmountType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingSummaryInstruction _that = getType().cast(o);
		
			if (!Objects.equals(summaryAmountType, _that.getSummaryAmountType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (summaryAmountType != null ? summaryAmountType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingSummaryInstructionBuilder {" +
				"summaryAmountType=" + this.summaryAmountType +
			'}';
		}
	}
}
