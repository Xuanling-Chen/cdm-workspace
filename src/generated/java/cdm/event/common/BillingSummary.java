package cdm.event.common;

import cdm.event.common.meta.BillingSummaryMeta;
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
 * Specifies individual summaries within a billing invoice.
 * @version ${project.version}
 */
@RosettaClass

public interface BillingSummary extends RosettaModelObject {
	BillingSummary build();
	BillingSummary.BillingSummaryBuilder toBuilder();
	
	/**
	 * The account level for the billing summary.
	 */
	RecordAmountTypeEnum getSummaryAmountType();
	/**
	 * The settlement terms for the billing summary
	 */
	Transfer getSummaryTransfer();
	final static BillingSummaryMeta metaData = new BillingSummaryMeta();
	
	@Override
	default RosettaMetaData<? extends BillingSummary> metaData() {
		return metaData;
	} 
			
	static BillingSummary.BillingSummaryBuilder builder() {
		return new BillingSummary.BillingSummaryBuilderImpl();
	}
	
	default Class<? extends BillingSummary> getType() {
		return BillingSummary.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("summaryAmountType"), RecordAmountTypeEnum.class, getSummaryAmountType(), this);
		
		processRosetta(path.newSubPath("summaryTransfer"), processor, Transfer.class, getSummaryTransfer());
	}
	
	
	interface BillingSummaryBuilder extends BillingSummary, RosettaModelObjectBuilder {
		Transfer.TransferBuilder getOrCreateSummaryTransfer();
		Transfer.TransferBuilder getSummaryTransfer();
		BillingSummary.BillingSummaryBuilder setSummaryAmountType(RecordAmountTypeEnum summaryAmountType);
		BillingSummary.BillingSummaryBuilder setSummaryTransfer(Transfer summaryTransfer);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("summaryAmountType"), RecordAmountTypeEnum.class, getSummaryAmountType(), this);
			
			processRosetta(path.newSubPath("summaryTransfer"), processor, Transfer.TransferBuilder.class, getSummaryTransfer());
		}
		
	}
	
	//BillingSummary.BillingSummaryImpl
	class BillingSummaryImpl implements BillingSummary {
		private final RecordAmountTypeEnum summaryAmountType;
		private final Transfer summaryTransfer;
		
		protected BillingSummaryImpl(BillingSummary.BillingSummaryBuilder builder) {
			this.summaryAmountType = builder.getSummaryAmountType();
			this.summaryTransfer = ofNullable(builder.getSummaryTransfer()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public RecordAmountTypeEnum getSummaryAmountType() {
			return summaryAmountType;
		}
		
		@Override
		public Transfer getSummaryTransfer() {
			return summaryTransfer;
		}
		
		@Override
		public BillingSummary build() {
			return this;
		}
		
		@Override
		public BillingSummary.BillingSummaryBuilder toBuilder() {
			BillingSummary.BillingSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BillingSummary.BillingSummaryBuilder builder) {
			ofNullable(getSummaryAmountType()).ifPresent(builder::setSummaryAmountType);
			ofNullable(getSummaryTransfer()).ifPresent(builder::setSummaryTransfer);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingSummary _that = getType().cast(o);
		
			if (!Objects.equals(summaryAmountType, _that.getSummaryAmountType())) return false;
			if (!Objects.equals(summaryTransfer, _that.getSummaryTransfer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (summaryAmountType != null ? summaryAmountType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (summaryTransfer != null ? summaryTransfer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingSummary {" +
				"summaryAmountType=" + this.summaryAmountType + ", " +
				"summaryTransfer=" + this.summaryTransfer +
			'}';
		}
	}
	
	//BillingSummary.BillingSummaryBuilderImpl
	class BillingSummaryBuilderImpl implements BillingSummary.BillingSummaryBuilder {
	
		protected RecordAmountTypeEnum summaryAmountType;
		protected Transfer.TransferBuilder summaryTransfer;
	
		public BillingSummaryBuilderImpl() {
		}
	
		@Override
		public RecordAmountTypeEnum getSummaryAmountType() {
			return summaryAmountType;
		}
		
		@Override
		public Transfer.TransferBuilder getSummaryTransfer() {
			return summaryTransfer;
		}
		
		@Override
		public Transfer.TransferBuilder getOrCreateSummaryTransfer() {
			Transfer.TransferBuilder result;
			if (summaryTransfer!=null) {
				result = summaryTransfer;
			}
			else {
				result = summaryTransfer = Transfer.builder();
			}
			
			return result;
		}
		
	
		@Override
		public BillingSummary.BillingSummaryBuilder setSummaryAmountType(RecordAmountTypeEnum summaryAmountType) {
			this.summaryAmountType = summaryAmountType==null?null:summaryAmountType;
			return this;
		}
		@Override
		public BillingSummary.BillingSummaryBuilder setSummaryTransfer(Transfer summaryTransfer) {
			this.summaryTransfer = summaryTransfer==null?null:summaryTransfer.toBuilder();
			return this;
		}
		
		@Override
		public BillingSummary build() {
			return new BillingSummary.BillingSummaryImpl(this);
		}
		
		@Override
		public BillingSummary.BillingSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingSummary.BillingSummaryBuilder prune() {
			if (summaryTransfer!=null && !summaryTransfer.prune().hasData()) summaryTransfer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSummaryAmountType()!=null) return true;
			if (getSummaryTransfer()!=null && getSummaryTransfer().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingSummary.BillingSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BillingSummary.BillingSummaryBuilder o = (BillingSummary.BillingSummaryBuilder) other;
			
			merger.mergeRosetta(getSummaryTransfer(), o.getSummaryTransfer(), this::setSummaryTransfer);
			
			merger.mergeBasic(getSummaryAmountType(), o.getSummaryAmountType(), this::setSummaryAmountType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingSummary _that = getType().cast(o);
		
			if (!Objects.equals(summaryAmountType, _that.getSummaryAmountType())) return false;
			if (!Objects.equals(summaryTransfer, _that.getSummaryTransfer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (summaryAmountType != null ? summaryAmountType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (summaryTransfer != null ? summaryTransfer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingSummaryBuilder {" +
				"summaryAmountType=" + this.summaryAmountType + ", " +
				"summaryTransfer=" + this.summaryTransfer +
			'}';
		}
	}
}
