package cdm.event.common;

import cdm.event.common.meta.IndexTransitionInstructionMeta;
import cdm.observable.asset.PriceQuantity;
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
 * Defines the information needed to create a Index Transition Business Event.
 * @version ${project.version}
 */
@RosettaClass

public interface IndexTransitionInstruction extends RosettaModelObject {
	IndexTransitionInstruction build();
	IndexTransitionInstruction.IndexTransitionInstructionBuilder toBuilder();
	
	/**
	 * Specifies the cash transfer that can optionally be tied to an index transition event.
	 */
	Transfer getCashTransfer();
	/**
	 * Specifies the effective date of the index transition event. This is first date on which the floating rate calculation will use the new floating rate index and adjusted spread in the floating rate calculation.
	 */
	Date getEffectiveDate();
	/**
	 * Specifies both new floating rate index and spread adjustment for each leg to be updated.  The spread adjustment accounts for the difference between the old floating rate index relative to the new one. This spread amount is added to the existing spread to determine the new spread, which is applied from the specified effective date forward. In the case of the IBOR Fallback Rate Adjustments, the adjustment spread (also known as the Fallback Adjustment) accounts for two distinctions: i) the fact that the replacement Risk-Free Rate is an overnight rate while IBORs have term structures (e.g., 1, 3, 6-month LIBOR); and (ii) the historical spread differential between IBORs and their term equivalent Overnight Risk-Free Rate compounded rates.
	 */
	List<? extends PriceQuantity> getPriceQuantity();
	final static IndexTransitionInstructionMeta metaData = new IndexTransitionInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends IndexTransitionInstruction> metaData() {
		return metaData;
	} 
			
	static IndexTransitionInstruction.IndexTransitionInstructionBuilder builder() {
		return new IndexTransitionInstruction.IndexTransitionInstructionBuilderImpl();
	}
	
	default Class<? extends IndexTransitionInstruction> getType() {
		return IndexTransitionInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		
		processRosetta(path.newSubPath("cashTransfer"), processor, Transfer.class, getCashTransfer());
		processRosetta(path.newSubPath("priceQuantity"), processor, PriceQuantity.class, getPriceQuantity());
	}
	
	
	interface IndexTransitionInstructionBuilder extends IndexTransitionInstruction, RosettaModelObjectBuilder {
		Transfer.TransferBuilder getOrCreateCashTransfer();
		Transfer.TransferBuilder getCashTransfer();
		PriceQuantity.PriceQuantityBuilder getOrCreatePriceQuantity(int _index);
		List<? extends PriceQuantity.PriceQuantityBuilder> getPriceQuantity();
		IndexTransitionInstruction.IndexTransitionInstructionBuilder setCashTransfer(Transfer cashTransfer);
		IndexTransitionInstruction.IndexTransitionInstructionBuilder setEffectiveDate(Date effectiveDate);
		IndexTransitionInstruction.IndexTransitionInstructionBuilder addPriceQuantity(PriceQuantity priceQuantity);
		IndexTransitionInstruction.IndexTransitionInstructionBuilder addPriceQuantity(PriceQuantity priceQuantity, int _idx);
		IndexTransitionInstruction.IndexTransitionInstructionBuilder addPriceQuantity(List<? extends PriceQuantity> priceQuantity);
		IndexTransitionInstruction.IndexTransitionInstructionBuilder setPriceQuantity(List<? extends PriceQuantity> priceQuantity);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			
			processRosetta(path.newSubPath("cashTransfer"), processor, Transfer.TransferBuilder.class, getCashTransfer());
			processRosetta(path.newSubPath("priceQuantity"), processor, PriceQuantity.PriceQuantityBuilder.class, getPriceQuantity());
		}
		
	}
	
	//IndexTransitionInstruction.IndexTransitionInstructionImpl
	class IndexTransitionInstructionImpl implements IndexTransitionInstruction {
		private final Transfer cashTransfer;
		private final Date effectiveDate;
		private final List<? extends PriceQuantity> priceQuantity;
		
		protected IndexTransitionInstructionImpl(IndexTransitionInstruction.IndexTransitionInstructionBuilder builder) {
			this.cashTransfer = ofNullable(builder.getCashTransfer()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.priceQuantity = ofNullable(builder.getPriceQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public Transfer getCashTransfer() {
			return cashTransfer;
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public List<? extends PriceQuantity> getPriceQuantity() {
			return priceQuantity;
		}
		
		@Override
		public IndexTransitionInstruction build() {
			return this;
		}
		
		@Override
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder toBuilder() {
			IndexTransitionInstruction.IndexTransitionInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexTransitionInstruction.IndexTransitionInstructionBuilder builder) {
			ofNullable(getCashTransfer()).ifPresent(builder::setCashTransfer);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getPriceQuantity()).ifPresent(builder::setPriceQuantity);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexTransitionInstruction _that = getType().cast(o);
		
			if (!Objects.equals(cashTransfer, _that.getCashTransfer())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(priceQuantity, _that.getPriceQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashTransfer != null ? cashTransfer.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (priceQuantity != null ? priceQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexTransitionInstruction {" +
				"cashTransfer=" + this.cashTransfer + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"priceQuantity=" + this.priceQuantity +
			'}';
		}
	}
	
	//IndexTransitionInstruction.IndexTransitionInstructionBuilderImpl
	class IndexTransitionInstructionBuilderImpl implements IndexTransitionInstruction.IndexTransitionInstructionBuilder {
	
		protected Transfer.TransferBuilder cashTransfer;
		protected Date effectiveDate;
		protected List<PriceQuantity.PriceQuantityBuilder> priceQuantity = new ArrayList<>();
	
		public IndexTransitionInstructionBuilderImpl() {
		}
	
		@Override
		public Transfer.TransferBuilder getCashTransfer() {
			return cashTransfer;
		}
		
		@Override
		public Transfer.TransferBuilder getOrCreateCashTransfer() {
			Transfer.TransferBuilder result;
			if (cashTransfer!=null) {
				result = cashTransfer;
			}
			else {
				result = cashTransfer = Transfer.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public List<? extends PriceQuantity.PriceQuantityBuilder> getPriceQuantity() {
			return priceQuantity;
		}
		
		public PriceQuantity.PriceQuantityBuilder getOrCreatePriceQuantity(int _index) {
		
			if (priceQuantity==null) {
				this.priceQuantity = new ArrayList<>();
			}
			PriceQuantity.PriceQuantityBuilder result;
			return getIndex(priceQuantity, _index, () -> {
						PriceQuantity.PriceQuantityBuilder newPriceQuantity = PriceQuantity.builder();
						return newPriceQuantity;
					});
		}
		
	
		@Override
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder setCashTransfer(Transfer cashTransfer) {
			this.cashTransfer = cashTransfer==null?null:cashTransfer.toBuilder();
			return this;
		}
		@Override
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder addPriceQuantity(PriceQuantity priceQuantity) {
			if (priceQuantity!=null) this.priceQuantity.add(priceQuantity.toBuilder());
			return this;
		}
		
		@Override
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder addPriceQuantity(PriceQuantity priceQuantity, int _idx) {
			getIndex(this.priceQuantity, _idx, () -> priceQuantity.toBuilder());
			return this;
		}
		@Override 
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder addPriceQuantity(List<? extends PriceQuantity> priceQuantitys) {
			if (priceQuantitys != null) {
				for (PriceQuantity toAdd : priceQuantitys) {
					this.priceQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder setPriceQuantity(List<? extends PriceQuantity> priceQuantitys) {
			if (priceQuantitys == null)  {
				this.priceQuantity = new ArrayList<>();
			}
			else {
				this.priceQuantity = priceQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public IndexTransitionInstruction build() {
			return new IndexTransitionInstruction.IndexTransitionInstructionImpl(this);
		}
		
		@Override
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder prune() {
			if (cashTransfer!=null && !cashTransfer.prune().hasData()) cashTransfer = null;
			priceQuantity = priceQuantity.stream().filter(b->b!=null).<PriceQuantity.PriceQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashTransfer()!=null && getCashTransfer().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getPriceQuantity()!=null && getPriceQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexTransitionInstruction.IndexTransitionInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexTransitionInstruction.IndexTransitionInstructionBuilder o = (IndexTransitionInstruction.IndexTransitionInstructionBuilder) other;
			
			merger.mergeRosetta(getCashTransfer(), o.getCashTransfer(), this::setCashTransfer);
			merger.mergeRosetta(getPriceQuantity(), o.getPriceQuantity(), this::getOrCreatePriceQuantity);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexTransitionInstruction _that = getType().cast(o);
		
			if (!Objects.equals(cashTransfer, _that.getCashTransfer())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(priceQuantity, _that.getPriceQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashTransfer != null ? cashTransfer.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (priceQuantity != null ? priceQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexTransitionInstructionBuilder {" +
				"cashTransfer=" + this.cashTransfer + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"priceQuantity=" + this.priceQuantity +
			'}';
		}
	}
}
