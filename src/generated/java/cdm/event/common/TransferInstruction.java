package cdm.event.common;

import cdm.base.math.Quantity;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.event.common.meta.TransferInstructionMeta;
import cdm.product.template.Payout;
import cdm.product.template.Payout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import cdm.product.template.metafields.ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder;
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
 * Defines the payout on which to create a Transfer along with all necessary resets.
 * @version ${project.version}
 */
@RosettaClass

public interface TransferInstruction extends RosettaModelObject {
	TransferInstruction build();
	TransferInstruction.TransferInstructionBuilder toBuilder();
	
	/**
	 */
	PayerReceiver getPayerReceiver();
	/**
	 */
	ReferenceWithMetaPayout getPayout();
	/**
	 * Specifies quantity amount returned if not the full amount from the TradeState, e.g. partial return
	 */
	Quantity getQuantity();
	/**
	 */
	List<? extends Reset> getResets();
	final static TransferInstructionMeta metaData = new TransferInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends TransferInstruction> metaData() {
		return metaData;
	} 
			
	static TransferInstruction.TransferInstructionBuilder builder() {
		return new TransferInstruction.TransferInstructionBuilderImpl();
	}
	
	default Class<? extends TransferInstruction> getType() {
		return TransferInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("payout"), processor, ReferenceWithMetaPayout.class, getPayout());
		processRosetta(path.newSubPath("quantity"), processor, Quantity.class, getQuantity());
		processRosetta(path.newSubPath("resets"), processor, Reset.class, getResets());
	}
	
	
	interface TransferInstructionBuilder extends TransferInstruction, RosettaModelObjectBuilder {
		PayerReceiver.PayerReceiverBuilder getOrCreatePayerReceiver();
		PayerReceiver.PayerReceiverBuilder getPayerReceiver();
		ReferenceWithMetaPayoutBuilder getOrCreatePayout();
		ReferenceWithMetaPayoutBuilder getPayout();
		Quantity.QuantityBuilder getOrCreateQuantity();
		Quantity.QuantityBuilder getQuantity();
		Reset.ResetBuilder getOrCreateResets(int _index);
		List<? extends Reset.ResetBuilder> getResets();
		TransferInstruction.TransferInstructionBuilder setPayerReceiver(PayerReceiver payerReceiver);
		TransferInstruction.TransferInstructionBuilder setPayout(ReferenceWithMetaPayout payout);
		TransferInstruction.TransferInstructionBuilder setPayoutValue(Payout payout);
		TransferInstruction.TransferInstructionBuilder setQuantity(Quantity quantity);
		TransferInstruction.TransferInstructionBuilder addResets(Reset resets);
		TransferInstruction.TransferInstructionBuilder addResets(Reset resets, int _idx);
		TransferInstruction.TransferInstructionBuilder addResets(List<? extends Reset> resets);
		TransferInstruction.TransferInstructionBuilder setResets(List<? extends Reset> resets);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.PayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("payout"), processor, ReferenceWithMetaPayoutBuilder.class, getPayout());
			processRosetta(path.newSubPath("quantity"), processor, Quantity.QuantityBuilder.class, getQuantity());
			processRosetta(path.newSubPath("resets"), processor, Reset.ResetBuilder.class, getResets());
		}
		
	}
	
	//TransferInstruction.TransferInstructionImpl
	class TransferInstructionImpl implements TransferInstruction {
		private final PayerReceiver payerReceiver;
		private final ReferenceWithMetaPayout payout;
		private final Quantity quantity;
		private final List<? extends Reset> resets;
		
		protected TransferInstructionImpl(TransferInstruction.TransferInstructionBuilder builder) {
			this.payerReceiver = ofNullable(builder.getPayerReceiver()).map(f->f.build()).orElse(null);
			this.payout = ofNullable(builder.getPayout()).map(f->f.build()).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).map(f->f.build()).orElse(null);
			this.resets = ofNullable(builder.getResets()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public PayerReceiver getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public ReferenceWithMetaPayout getPayout() {
			return payout;
		}
		
		@Override
		public Quantity getQuantity() {
			return quantity;
		}
		
		@Override
		public List<? extends Reset> getResets() {
			return resets;
		}
		
		@Override
		public TransferInstruction build() {
			return this;
		}
		
		@Override
		public TransferInstruction.TransferInstructionBuilder toBuilder() {
			TransferInstruction.TransferInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransferInstruction.TransferInstructionBuilder builder) {
			ofNullable(getPayerReceiver()).ifPresent(builder::setPayerReceiver);
			ofNullable(getPayout()).ifPresent(builder::setPayout);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getResets()).ifPresent(builder::setResets);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferInstruction _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(payout, _that.getPayout())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!ListEquals.listEquals(resets, _that.getResets())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (resets != null ? resets.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferInstruction {" +
				"payerReceiver=" + this.payerReceiver + ", " +
				"payout=" + this.payout + ", " +
				"quantity=" + this.quantity + ", " +
				"resets=" + this.resets +
			'}';
		}
	}
	
	//TransferInstruction.TransferInstructionBuilderImpl
	class TransferInstructionBuilderImpl implements TransferInstruction.TransferInstructionBuilder {
	
		protected PayerReceiver.PayerReceiverBuilder payerReceiver;
		protected ReferenceWithMetaPayoutBuilder payout;
		protected Quantity.QuantityBuilder quantity;
		protected List<Reset.ResetBuilder> resets = new ArrayList<>();
	
		public TransferInstructionBuilderImpl() {
		}
	
		@Override
		public PayerReceiver.PayerReceiverBuilder getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public PayerReceiver.PayerReceiverBuilder getOrCreatePayerReceiver() {
			PayerReceiver.PayerReceiverBuilder result;
			if (payerReceiver!=null) {
				result = payerReceiver;
			}
			else {
				result = payerReceiver = PayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaPayoutBuilder getPayout() {
			return payout;
		}
		
		@Override
		public ReferenceWithMetaPayoutBuilder getOrCreatePayout() {
			ReferenceWithMetaPayoutBuilder result;
			if (payout!=null) {
				result = payout;
			}
			else {
				result = payout = ReferenceWithMetaPayout.builder();
			}
			
			return result;
		}
		
		@Override
		public Quantity.QuantityBuilder getQuantity() {
			return quantity;
		}
		
		@Override
		public Quantity.QuantityBuilder getOrCreateQuantity() {
			Quantity.QuantityBuilder result;
			if (quantity!=null) {
				result = quantity;
			}
			else {
				result = quantity = Quantity.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends Reset.ResetBuilder> getResets() {
			return resets;
		}
		
		public Reset.ResetBuilder getOrCreateResets(int _index) {
		
			if (resets==null) {
				this.resets = new ArrayList<>();
			}
			Reset.ResetBuilder result;
			return getIndex(resets, _index, () -> {
						Reset.ResetBuilder newResets = Reset.builder();
						return newResets;
					});
		}
		
	
		@Override
		public TransferInstruction.TransferInstructionBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public TransferInstruction.TransferInstructionBuilder setPayout(ReferenceWithMetaPayout payout) {
			this.payout = payout==null?null:payout.toBuilder();
			return this;
		}
		
		@Override
		public TransferInstruction.TransferInstructionBuilder setPayoutValue(Payout payout) {
			this.getOrCreatePayout().setValue(payout);
			return this;
		}
		@Override
		public TransferInstruction.TransferInstructionBuilder setQuantity(Quantity quantity) {
			this.quantity = quantity==null?null:quantity.toBuilder();
			return this;
		}
		@Override
		public TransferInstruction.TransferInstructionBuilder addResets(Reset resets) {
			if (resets!=null) this.resets.add(resets.toBuilder());
			return this;
		}
		
		@Override
		public TransferInstruction.TransferInstructionBuilder addResets(Reset resets, int _idx) {
			getIndex(this.resets, _idx, () -> resets.toBuilder());
			return this;
		}
		@Override 
		public TransferInstruction.TransferInstructionBuilder addResets(List<? extends Reset> resetss) {
			if (resetss != null) {
				for (Reset toAdd : resetss) {
					this.resets.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TransferInstruction.TransferInstructionBuilder setResets(List<? extends Reset> resetss) {
			if (resetss == null)  {
				this.resets = new ArrayList<>();
			}
			else {
				this.resets = resetss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public TransferInstruction build() {
			return new TransferInstruction.TransferInstructionImpl(this);
		}
		
		@Override
		public TransferInstruction.TransferInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferInstruction.TransferInstructionBuilder prune() {
			if (payerReceiver!=null && !payerReceiver.prune().hasData()) payerReceiver = null;
			if (payout!=null && !payout.prune().hasData()) payout = null;
			if (quantity!=null && !quantity.prune().hasData()) quantity = null;
			resets = resets.stream().filter(b->b!=null).<Reset.ResetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerReceiver()!=null && getPayerReceiver().hasData()) return true;
			if (getPayout()!=null && getPayout().hasData()) return true;
			if (getQuantity()!=null && getQuantity().hasData()) return true;
			if (getResets()!=null && getResets().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferInstruction.TransferInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransferInstruction.TransferInstructionBuilder o = (TransferInstruction.TransferInstructionBuilder) other;
			
			merger.mergeRosetta(getPayerReceiver(), o.getPayerReceiver(), this::setPayerReceiver);
			merger.mergeRosetta(getPayout(), o.getPayout(), this::setPayout);
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeRosetta(getResets(), o.getResets(), this::getOrCreateResets);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferInstruction _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(payout, _that.getPayout())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!ListEquals.listEquals(resets, _that.getResets())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (resets != null ? resets.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferInstructionBuilder {" +
				"payerReceiver=" + this.payerReceiver + ", " +
				"payout=" + this.payout + ", " +
				"quantity=" + this.quantity + ", " +
				"resets=" + this.resets +
			'}';
		}
	}
}
