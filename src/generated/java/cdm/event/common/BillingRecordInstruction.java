package cdm.event.common;

import cdm.event.common.meta.BillingRecordInstructionMeta;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder;
import cdm.observable.event.Observation;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the instructions for creation of a billing record.
 * @version ${project.version}
 */
@RosettaClass

public interface BillingRecordInstruction extends RosettaModelObject {
	BillingRecordInstruction build();
	BillingRecordInstruction.BillingRecordInstructionBuilder toBuilder();
	
	/**
	 * The observations used to calculate the billing amount.
	 */
	List<? extends Observation> getObservation();
	/**
	 * The ending date of the period described by this record
	 */
	Date getRecordEndDate();
	/**
	 * The starting date of the period described by this record
	 */
	Date getRecordStartDate();
	/**
	 * The date for settlement of the transfer.
	 */
	Date getSettlementDate();
	/**
	 * The trade for the individual billing record.
	 */
	ReferenceWithMetaTradeState getTradeState();
	final static BillingRecordInstructionMeta metaData = new BillingRecordInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends BillingRecordInstruction> metaData() {
		return metaData;
	} 
			
	static BillingRecordInstruction.BillingRecordInstructionBuilder builder() {
		return new BillingRecordInstruction.BillingRecordInstructionBuilderImpl();
	}
	
	default Class<? extends BillingRecordInstruction> getType() {
		return BillingRecordInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("recordEndDate"), Date.class, getRecordEndDate(), this);
		processor.processBasic(path.newSubPath("recordStartDate"), Date.class, getRecordStartDate(), this);
		processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
		
		processRosetta(path.newSubPath("observation"), processor, Observation.class, getObservation());
		processRosetta(path.newSubPath("tradeState"), processor, ReferenceWithMetaTradeState.class, getTradeState());
	}
	
	
	interface BillingRecordInstructionBuilder extends BillingRecordInstruction, RosettaModelObjectBuilder {
		Observation.ObservationBuilder getOrCreateObservation(int _index);
		List<? extends Observation.ObservationBuilder> getObservation();
		ReferenceWithMetaTradeStateBuilder getOrCreateTradeState();
		ReferenceWithMetaTradeStateBuilder getTradeState();
		BillingRecordInstruction.BillingRecordInstructionBuilder addObservation(Observation observation);
		BillingRecordInstruction.BillingRecordInstructionBuilder addObservation(Observation observation, int _idx);
		BillingRecordInstruction.BillingRecordInstructionBuilder addObservation(List<? extends Observation> observation);
		BillingRecordInstruction.BillingRecordInstructionBuilder setObservation(List<? extends Observation> observation);
		BillingRecordInstruction.BillingRecordInstructionBuilder setRecordEndDate(Date recordEndDate);
		BillingRecordInstruction.BillingRecordInstructionBuilder setRecordStartDate(Date recordStartDate);
		BillingRecordInstruction.BillingRecordInstructionBuilder setSettlementDate(Date settlementDate);
		BillingRecordInstruction.BillingRecordInstructionBuilder setTradeState(ReferenceWithMetaTradeState tradeState);
		BillingRecordInstruction.BillingRecordInstructionBuilder setTradeStateValue(TradeState tradeState);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("recordEndDate"), Date.class, getRecordEndDate(), this);
			processor.processBasic(path.newSubPath("recordStartDate"), Date.class, getRecordStartDate(), this);
			processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
			
			processRosetta(path.newSubPath("observation"), processor, Observation.ObservationBuilder.class, getObservation());
			processRosetta(path.newSubPath("tradeState"), processor, ReferenceWithMetaTradeStateBuilder.class, getTradeState());
		}
		
	}
	
	//BillingRecordInstruction.BillingRecordInstructionImpl
	class BillingRecordInstructionImpl implements BillingRecordInstruction {
		private final List<? extends Observation> observation;
		private final Date recordEndDate;
		private final Date recordStartDate;
		private final Date settlementDate;
		private final ReferenceWithMetaTradeState tradeState;
		
		protected BillingRecordInstructionImpl(BillingRecordInstruction.BillingRecordInstructionBuilder builder) {
			this.observation = ofNullable(builder.getObservation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.recordEndDate = builder.getRecordEndDate();
			this.recordStartDate = builder.getRecordStartDate();
			this.settlementDate = builder.getSettlementDate();
			this.tradeState = ofNullable(builder.getTradeState()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends Observation> getObservation() {
			return observation;
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
		public Date getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public ReferenceWithMetaTradeState getTradeState() {
			return tradeState;
		}
		
		@Override
		public BillingRecordInstruction build() {
			return this;
		}
		
		@Override
		public BillingRecordInstruction.BillingRecordInstructionBuilder toBuilder() {
			BillingRecordInstruction.BillingRecordInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BillingRecordInstruction.BillingRecordInstructionBuilder builder) {
			ofNullable(getObservation()).ifPresent(builder::setObservation);
			ofNullable(getRecordEndDate()).ifPresent(builder::setRecordEndDate);
			ofNullable(getRecordStartDate()).ifPresent(builder::setRecordStartDate);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getTradeState()).ifPresent(builder::setTradeState);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingRecordInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observation, _that.getObservation())) return false;
			if (!Objects.equals(recordEndDate, _that.getRecordEndDate())) return false;
			if (!Objects.equals(recordStartDate, _that.getRecordStartDate())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(tradeState, _that.getTradeState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observation != null ? observation.hashCode() : 0);
			_result = 31 * _result + (recordEndDate != null ? recordEndDate.hashCode() : 0);
			_result = 31 * _result + (recordStartDate != null ? recordStartDate.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (tradeState != null ? tradeState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingRecordInstruction {" +
				"observation=" + this.observation + ", " +
				"recordEndDate=" + this.recordEndDate + ", " +
				"recordStartDate=" + this.recordStartDate + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
	
	//BillingRecordInstruction.BillingRecordInstructionBuilderImpl
	class BillingRecordInstructionBuilderImpl implements BillingRecordInstruction.BillingRecordInstructionBuilder {
	
		protected List<Observation.ObservationBuilder> observation = new ArrayList<>();
		protected Date recordEndDate;
		protected Date recordStartDate;
		protected Date settlementDate;
		protected ReferenceWithMetaTradeStateBuilder tradeState;
	
		public BillingRecordInstructionBuilderImpl() {
		}
	
		@Override
		public List<? extends Observation.ObservationBuilder> getObservation() {
			return observation;
		}
		
		public Observation.ObservationBuilder getOrCreateObservation(int _index) {
		
			if (observation==null) {
				this.observation = new ArrayList<>();
			}
			Observation.ObservationBuilder result;
			return getIndex(observation, _index, () -> {
						Observation.ObservationBuilder newObservation = Observation.builder();
						return newObservation;
					});
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
		public Date getSettlementDate() {
			return settlementDate;
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
		public BillingRecordInstruction.BillingRecordInstructionBuilder addObservation(Observation observation) {
			if (observation!=null) this.observation.add(observation.toBuilder());
			return this;
		}
		
		@Override
		public BillingRecordInstruction.BillingRecordInstructionBuilder addObservation(Observation observation, int _idx) {
			getIndex(this.observation, _idx, () -> observation.toBuilder());
			return this;
		}
		@Override 
		public BillingRecordInstruction.BillingRecordInstructionBuilder addObservation(List<? extends Observation> observations) {
			if (observations != null) {
				for (Observation toAdd : observations) {
					this.observation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public BillingRecordInstruction.BillingRecordInstructionBuilder setObservation(List<? extends Observation> observations) {
			if (observations == null)  {
				this.observation = new ArrayList<>();
			}
			else {
				this.observation = observations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BillingRecordInstruction.BillingRecordInstructionBuilder setRecordEndDate(Date recordEndDate) {
			this.recordEndDate = recordEndDate==null?null:recordEndDate;
			return this;
		}
		@Override
		public BillingRecordInstruction.BillingRecordInstructionBuilder setRecordStartDate(Date recordStartDate) {
			this.recordStartDate = recordStartDate==null?null:recordStartDate;
			return this;
		}
		@Override
		public BillingRecordInstruction.BillingRecordInstructionBuilder setSettlementDate(Date settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate;
			return this;
		}
		@Override
		public BillingRecordInstruction.BillingRecordInstructionBuilder setTradeState(ReferenceWithMetaTradeState tradeState) {
			this.tradeState = tradeState==null?null:tradeState.toBuilder();
			return this;
		}
		
		@Override
		public BillingRecordInstruction.BillingRecordInstructionBuilder setTradeStateValue(TradeState tradeState) {
			this.getOrCreateTradeState().setValue(tradeState);
			return this;
		}
		
		@Override
		public BillingRecordInstruction build() {
			return new BillingRecordInstruction.BillingRecordInstructionImpl(this);
		}
		
		@Override
		public BillingRecordInstruction.BillingRecordInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingRecordInstruction.BillingRecordInstructionBuilder prune() {
			observation = observation.stream().filter(b->b!=null).<Observation.ObservationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeState!=null && !tradeState.prune().hasData()) tradeState = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservation()!=null && getObservation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRecordEndDate()!=null) return true;
			if (getRecordStartDate()!=null) return true;
			if (getSettlementDate()!=null) return true;
			if (getTradeState()!=null && getTradeState().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingRecordInstruction.BillingRecordInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BillingRecordInstruction.BillingRecordInstructionBuilder o = (BillingRecordInstruction.BillingRecordInstructionBuilder) other;
			
			merger.mergeRosetta(getObservation(), o.getObservation(), this::getOrCreateObservation);
			merger.mergeRosetta(getTradeState(), o.getTradeState(), this::setTradeState);
			
			merger.mergeBasic(getRecordEndDate(), o.getRecordEndDate(), this::setRecordEndDate);
			merger.mergeBasic(getRecordStartDate(), o.getRecordStartDate(), this::setRecordStartDate);
			merger.mergeBasic(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingRecordInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observation, _that.getObservation())) return false;
			if (!Objects.equals(recordEndDate, _that.getRecordEndDate())) return false;
			if (!Objects.equals(recordStartDate, _that.getRecordStartDate())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(tradeState, _that.getTradeState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observation != null ? observation.hashCode() : 0);
			_result = 31 * _result + (recordEndDate != null ? recordEndDate.hashCode() : 0);
			_result = 31 * _result + (recordStartDate != null ? recordStartDate.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (tradeState != null ? tradeState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingRecordInstructionBuilder {" +
				"observation=" + this.observation + ", " +
				"recordEndDate=" + this.recordEndDate + ", " +
				"recordStartDate=" + this.recordStartDate + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
}
