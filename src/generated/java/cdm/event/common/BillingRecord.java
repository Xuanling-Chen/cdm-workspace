package cdm.event.common;

import cdm.event.common.meta.BillingRecordMeta;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder;
import cdm.observable.asset.Money;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies individual records within a billing invoice.
 * @version ${project.version}
 */
@RosettaClass

public interface BillingRecord extends RosettaModelObject {
	BillingRecord build();
	BillingRecord.BillingRecordBuilder toBuilder();
	
	/**
	 * Indicates the minimum fee amount applied to the billing record, if any.
	 */
	Money getMinimumFee();
	/**
	 * The ending date of the period described by this record
	 */
	Date getRecordEndDate();
	/**
	 * The starting date of the period described by this record
	 */
	Date getRecordStartDate();
	/**
	 * The settlement terms for the billing record
	 */
	Transfer getRecordTransfer();
	/**
	 * The trade for the individual billing record.
	 */
	ReferenceWithMetaTradeState getTradeState();
	final static BillingRecordMeta metaData = new BillingRecordMeta();
	
	@Override
	default RosettaMetaData<? extends BillingRecord> metaData() {
		return metaData;
	} 
			
	static BillingRecord.BillingRecordBuilder builder() {
		return new BillingRecord.BillingRecordBuilderImpl();
	}
	
	default Class<? extends BillingRecord> getType() {
		return BillingRecord.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("recordEndDate"), Date.class, getRecordEndDate(), this);
		processor.processBasic(path.newSubPath("recordStartDate"), Date.class, getRecordStartDate(), this);
		
		processRosetta(path.newSubPath("minimumFee"), processor, Money.class, getMinimumFee());
		processRosetta(path.newSubPath("recordTransfer"), processor, Transfer.class, getRecordTransfer());
		processRosetta(path.newSubPath("tradeState"), processor, ReferenceWithMetaTradeState.class, getTradeState());
	}
	
	
	interface BillingRecordBuilder extends BillingRecord, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateMinimumFee();
		Money.MoneyBuilder getMinimumFee();
		Transfer.TransferBuilder getOrCreateRecordTransfer();
		Transfer.TransferBuilder getRecordTransfer();
		ReferenceWithMetaTradeStateBuilder getOrCreateTradeState();
		ReferenceWithMetaTradeStateBuilder getTradeState();
		BillingRecord.BillingRecordBuilder setMinimumFee(Money minimumFee);
		BillingRecord.BillingRecordBuilder setRecordEndDate(Date recordEndDate);
		BillingRecord.BillingRecordBuilder setRecordStartDate(Date recordStartDate);
		BillingRecord.BillingRecordBuilder setRecordTransfer(Transfer recordTransfer);
		BillingRecord.BillingRecordBuilder setTradeState(ReferenceWithMetaTradeState tradeState);
		BillingRecord.BillingRecordBuilder setTradeStateValue(TradeState tradeState);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("recordEndDate"), Date.class, getRecordEndDate(), this);
			processor.processBasic(path.newSubPath("recordStartDate"), Date.class, getRecordStartDate(), this);
			
			processRosetta(path.newSubPath("minimumFee"), processor, Money.MoneyBuilder.class, getMinimumFee());
			processRosetta(path.newSubPath("recordTransfer"), processor, Transfer.TransferBuilder.class, getRecordTransfer());
			processRosetta(path.newSubPath("tradeState"), processor, ReferenceWithMetaTradeStateBuilder.class, getTradeState());
		}
		
	}
	
	//BillingRecord.BillingRecordImpl
	class BillingRecordImpl implements BillingRecord {
		private final Money minimumFee;
		private final Date recordEndDate;
		private final Date recordStartDate;
		private final Transfer recordTransfer;
		private final ReferenceWithMetaTradeState tradeState;
		
		protected BillingRecordImpl(BillingRecord.BillingRecordBuilder builder) {
			this.minimumFee = ofNullable(builder.getMinimumFee()).map(f->f.build()).orElse(null);
			this.recordEndDate = builder.getRecordEndDate();
			this.recordStartDate = builder.getRecordStartDate();
			this.recordTransfer = ofNullable(builder.getRecordTransfer()).map(f->f.build()).orElse(null);
			this.tradeState = ofNullable(builder.getTradeState()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Money getMinimumFee() {
			return minimumFee;
		}
		
		@Override
		public Date getRecordEndDate() {
			return recordEndDate;
		}
		
		@Override
		public Date getRecordStartDate() {
			return recordStartDate;
		}
		
		@Override
		public Transfer getRecordTransfer() {
			return recordTransfer;
		}
		
		@Override
		public ReferenceWithMetaTradeState getTradeState() {
			return tradeState;
		}
		
		@Override
		public BillingRecord build() {
			return this;
		}
		
		@Override
		public BillingRecord.BillingRecordBuilder toBuilder() {
			BillingRecord.BillingRecordBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BillingRecord.BillingRecordBuilder builder) {
			ofNullable(getMinimumFee()).ifPresent(builder::setMinimumFee);
			ofNullable(getRecordEndDate()).ifPresent(builder::setRecordEndDate);
			ofNullable(getRecordStartDate()).ifPresent(builder::setRecordStartDate);
			ofNullable(getRecordTransfer()).ifPresent(builder::setRecordTransfer);
			ofNullable(getTradeState()).ifPresent(builder::setTradeState);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingRecord _that = getType().cast(o);
		
			if (!Objects.equals(minimumFee, _that.getMinimumFee())) return false;
			if (!Objects.equals(recordEndDate, _that.getRecordEndDate())) return false;
			if (!Objects.equals(recordStartDate, _that.getRecordStartDate())) return false;
			if (!Objects.equals(recordTransfer, _that.getRecordTransfer())) return false;
			if (!Objects.equals(tradeState, _that.getTradeState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (minimumFee != null ? minimumFee.hashCode() : 0);
			_result = 31 * _result + (recordEndDate != null ? recordEndDate.hashCode() : 0);
			_result = 31 * _result + (recordStartDate != null ? recordStartDate.hashCode() : 0);
			_result = 31 * _result + (recordTransfer != null ? recordTransfer.hashCode() : 0);
			_result = 31 * _result + (tradeState != null ? tradeState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingRecord {" +
				"minimumFee=" + this.minimumFee + ", " +
				"recordEndDate=" + this.recordEndDate + ", " +
				"recordStartDate=" + this.recordStartDate + ", " +
				"recordTransfer=" + this.recordTransfer + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
	
	//BillingRecord.BillingRecordBuilderImpl
	class BillingRecordBuilderImpl implements BillingRecord.BillingRecordBuilder {
	
		protected Money.MoneyBuilder minimumFee;
		protected Date recordEndDate;
		protected Date recordStartDate;
		protected Transfer.TransferBuilder recordTransfer;
		protected ReferenceWithMetaTradeStateBuilder tradeState;
	
		public BillingRecordBuilderImpl() {
		}
	
		@Override
		public Money.MoneyBuilder getMinimumFee() {
			return minimumFee;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateMinimumFee() {
			Money.MoneyBuilder result;
			if (minimumFee!=null) {
				result = minimumFee;
			}
			else {
				result = minimumFee = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getRecordEndDate() {
			return recordEndDate;
		}
		
		@Override
		public Date getRecordStartDate() {
			return recordStartDate;
		}
		
		@Override
		public Transfer.TransferBuilder getRecordTransfer() {
			return recordTransfer;
		}
		
		@Override
		public Transfer.TransferBuilder getOrCreateRecordTransfer() {
			Transfer.TransferBuilder result;
			if (recordTransfer!=null) {
				result = recordTransfer;
			}
			else {
				result = recordTransfer = Transfer.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaTradeStateBuilder getTradeState() {
			return tradeState;
		}
		
		@Override
		public ReferenceWithMetaTradeStateBuilder getOrCreateTradeState() {
			ReferenceWithMetaTradeStateBuilder result;
			if (tradeState!=null) {
				result = tradeState;
			}
			else {
				result = tradeState = ReferenceWithMetaTradeState.builder();
			}
			
			return result;
		}
		
	
		@Override
		public BillingRecord.BillingRecordBuilder setMinimumFee(Money minimumFee) {
			this.minimumFee = minimumFee==null?null:minimumFee.toBuilder();
			return this;
		}
		@Override
		public BillingRecord.BillingRecordBuilder setRecordEndDate(Date recordEndDate) {
			this.recordEndDate = recordEndDate==null?null:recordEndDate;
			return this;
		}
		@Override
		public BillingRecord.BillingRecordBuilder setRecordStartDate(Date recordStartDate) {
			this.recordStartDate = recordStartDate==null?null:recordStartDate;
			return this;
		}
		@Override
		public BillingRecord.BillingRecordBuilder setRecordTransfer(Transfer recordTransfer) {
			this.recordTransfer = recordTransfer==null?null:recordTransfer.toBuilder();
			return this;
		}
		@Override
		public BillingRecord.BillingRecordBuilder setTradeState(ReferenceWithMetaTradeState tradeState) {
			this.tradeState = tradeState==null?null:tradeState.toBuilder();
			return this;
		}
		
		@Override
		public BillingRecord.BillingRecordBuilder setTradeStateValue(TradeState tradeState) {
			this.getOrCreateTradeState().setValue(tradeState);
			return this;
		}
		
		@Override
		public BillingRecord build() {
			return new BillingRecord.BillingRecordImpl(this);
		}
		
		@Override
		public BillingRecord.BillingRecordBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingRecord.BillingRecordBuilder prune() {
			if (minimumFee!=null && !minimumFee.prune().hasData()) minimumFee = null;
			if (recordTransfer!=null && !recordTransfer.prune().hasData()) recordTransfer = null;
			if (tradeState!=null && !tradeState.prune().hasData()) tradeState = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMinimumFee()!=null && getMinimumFee().hasData()) return true;
			if (getRecordEndDate()!=null) return true;
			if (getRecordStartDate()!=null) return true;
			if (getRecordTransfer()!=null && getRecordTransfer().hasData()) return true;
			if (getTradeState()!=null && getTradeState().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingRecord.BillingRecordBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BillingRecord.BillingRecordBuilder o = (BillingRecord.BillingRecordBuilder) other;
			
			merger.mergeRosetta(getMinimumFee(), o.getMinimumFee(), this::setMinimumFee);
			merger.mergeRosetta(getRecordTransfer(), o.getRecordTransfer(), this::setRecordTransfer);
			merger.mergeRosetta(getTradeState(), o.getTradeState(), this::setTradeState);
			
			merger.mergeBasic(getRecordEndDate(), o.getRecordEndDate(), this::setRecordEndDate);
			merger.mergeBasic(getRecordStartDate(), o.getRecordStartDate(), this::setRecordStartDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingRecord _that = getType().cast(o);
		
			if (!Objects.equals(minimumFee, _that.getMinimumFee())) return false;
			if (!Objects.equals(recordEndDate, _that.getRecordEndDate())) return false;
			if (!Objects.equals(recordStartDate, _that.getRecordStartDate())) return false;
			if (!Objects.equals(recordTransfer, _that.getRecordTransfer())) return false;
			if (!Objects.equals(tradeState, _that.getTradeState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (minimumFee != null ? minimumFee.hashCode() : 0);
			_result = 31 * _result + (recordEndDate != null ? recordEndDate.hashCode() : 0);
			_result = 31 * _result + (recordStartDate != null ? recordStartDate.hashCode() : 0);
			_result = 31 * _result + (recordTransfer != null ? recordTransfer.hashCode() : 0);
			_result = 31 * _result + (tradeState != null ? tradeState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingRecordBuilder {" +
				"minimumFee=" + this.minimumFee + ", " +
				"recordEndDate=" + this.recordEndDate + ", " +
				"recordStartDate=" + this.recordStartDate + ", " +
				"recordTransfer=" + this.recordTransfer + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
}
