package cdm.event.common;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.math.Quantity;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.event.common.meta.TransferMeta;
import cdm.observable.asset.Observable;
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
 * Defines the movement of cash, securities or commodities between two parties on a date.
 * @version ${project.version}
 */
@RosettaClass

public interface Transfer extends RosettaModelObject {
	Transfer build();
	Transfer.TransferBuilder toBuilder();
	
	/**
	 * Represents a unique reference to the transfer.
	 */
	List<? extends FieldWithMetaIdentifier> getIdentifier();
	/**
	 * Represents the object that is subject to the transfer, it could be an asset or a reference.
	 */
	Observable getObservable();
	/**
	 * Represents the parties to the transfer and their role.
	 */
	PartyReferencePayerReceiver getPayerReceiver();
	/**
	 * Represents the amount of the asset to tbe transferred.
	 */
	Quantity getQuantity();
	/**
	 * Represents the date on which the transfer to due.
	 */
	AdjustableOrAdjustedOrRelativeDate getSettlementDate();
	/**
	 * Represents the origin to the transfer, whether it originated from trade level settlement terms or from payment terms on an economic payout.
	 */
	SettlementOrigin getSettlementOrigin();
	final static TransferMeta metaData = new TransferMeta();
	
	@Override
	default RosettaMetaData<? extends Transfer> metaData() {
		return metaData;
	} 
			
	static Transfer.TransferBuilder builder() {
		return new Transfer.TransferBuilderImpl();
	}
	
	default Class<? extends Transfer> getType() {
		return Transfer.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("observable"), processor, Observable.class, getObservable());
		processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("quantity"), processor, Quantity.class, getQuantity());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementOrigin"), processor, SettlementOrigin.class, getSettlementOrigin());
	}
	
	
	interface TransferBuilder extends Transfer, RosettaModelObjectBuilder {
		FieldWithMetaIdentifierBuilder getOrCreateIdentifier(int _index);
		List<? extends FieldWithMetaIdentifierBuilder> getIdentifier();
		Observable.ObservableBuilder getOrCreateObservable();
		Observable.ObservableBuilder getObservable();
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getOrCreatePayerReceiver();
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getPayerReceiver();
		Quantity.QuantityBuilder getOrCreateQuantity();
		Quantity.QuantityBuilder getQuantity();
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getOrCreateSettlementDate();
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getSettlementDate();
		SettlementOrigin.SettlementOriginBuilder getOrCreateSettlementOrigin();
		SettlementOrigin.SettlementOriginBuilder getSettlementOrigin();
		Transfer.TransferBuilder addIdentifier(FieldWithMetaIdentifier identifier);
		Transfer.TransferBuilder addIdentifier(FieldWithMetaIdentifier identifier, int _idx);
		Transfer.TransferBuilder addIdentifierValue(Identifier identifier);
		Transfer.TransferBuilder addIdentifierValue(Identifier identifier, int _idx);
		Transfer.TransferBuilder addIdentifier(List<? extends FieldWithMetaIdentifier> identifier);
		Transfer.TransferBuilder setIdentifier(List<? extends FieldWithMetaIdentifier> identifier);
		Transfer.TransferBuilder addIdentifierValue(List<? extends Identifier> identifier);
		Transfer.TransferBuilder setIdentifierValue(List<? extends Identifier> identifier);
		Transfer.TransferBuilder setObservable(Observable observable);
		Transfer.TransferBuilder setPayerReceiver(PartyReferencePayerReceiver payerReceiver);
		Transfer.TransferBuilder setQuantity(Quantity quantity);
		Transfer.TransferBuilder setSettlementDate(AdjustableOrAdjustedOrRelativeDate settlementDate);
		Transfer.TransferBuilder setSettlementOrigin(SettlementOrigin settlementOrigin);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("observable"), processor, Observable.ObservableBuilder.class, getObservable());
			processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("quantity"), processor, Quantity.QuantityBuilder.class, getQuantity());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementOrigin"), processor, SettlementOrigin.SettlementOriginBuilder.class, getSettlementOrigin());
		}
		
	}
	
	//Transfer.TransferImpl
	class TransferImpl implements Transfer {
		private final List<? extends FieldWithMetaIdentifier> identifier;
		private final Observable observable;
		private final PartyReferencePayerReceiver payerReceiver;
		private final Quantity quantity;
		private final AdjustableOrAdjustedOrRelativeDate settlementDate;
		private final SettlementOrigin settlementOrigin;
		
		protected TransferImpl(Transfer.TransferBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.observable = ofNullable(builder.getObservable()).map(f->f.build()).orElse(null);
			this.payerReceiver = ofNullable(builder.getPayerReceiver()).map(f->f.build()).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementOrigin = ofNullable(builder.getSettlementOrigin()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends FieldWithMetaIdentifier> getIdentifier() {
			return identifier;
		}
		
		@Override
		public Observable getObservable() {
			return observable;
		}
		
		@Override
		public PartyReferencePayerReceiver getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public Quantity getQuantity() {
			return quantity;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public SettlementOrigin getSettlementOrigin() {
			return settlementOrigin;
		}
		
		@Override
		public Transfer build() {
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder toBuilder() {
			Transfer.TransferBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Transfer.TransferBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getObservable()).ifPresent(builder::setObservable);
			ofNullable(getPayerReceiver()).ifPresent(builder::setPayerReceiver);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementOrigin()).ifPresent(builder::setSettlementOrigin);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Transfer _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(observable, _that.getObservable())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementOrigin, _that.getSettlementOrigin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementOrigin != null ? settlementOrigin.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Transfer {" +
				"identifier=" + this.identifier + ", " +
				"observable=" + this.observable + ", " +
				"payerReceiver=" + this.payerReceiver + ", " +
				"quantity=" + this.quantity + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementOrigin=" + this.settlementOrigin +
			'}';
		}
	}
	
	//Transfer.TransferBuilderImpl
	class TransferBuilderImpl implements Transfer.TransferBuilder {
	
		protected List<FieldWithMetaIdentifierBuilder> identifier = new ArrayList<>();
		protected Observable.ObservableBuilder observable;
		protected PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder payerReceiver;
		protected Quantity.QuantityBuilder quantity;
		protected AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder settlementDate;
		protected SettlementOrigin.SettlementOriginBuilder settlementOrigin;
	
		public TransferBuilderImpl() {
		}
	
		@Override
		public List<? extends FieldWithMetaIdentifierBuilder> getIdentifier() {
			return identifier;
		}
		
		public FieldWithMetaIdentifierBuilder getOrCreateIdentifier(int _index) {
		
			if (identifier==null) {
				this.identifier = new ArrayList<>();
			}
			FieldWithMetaIdentifierBuilder result;
			return getIndex(identifier, _index, () -> {
						FieldWithMetaIdentifierBuilder newIdentifier = FieldWithMetaIdentifier.builder();
						return newIdentifier;
					});
		}
		
		@Override
		public Observable.ObservableBuilder getObservable() {
			return observable;
		}
		
		@Override
		public Observable.ObservableBuilder getOrCreateObservable() {
			Observable.ObservableBuilder result;
			if (observable!=null) {
				result = observable;
			}
			else {
				result = observable = Observable.builder();
			}
			
			return result;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getOrCreatePayerReceiver() {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder result;
			if (payerReceiver!=null) {
				result = payerReceiver;
			}
			else {
				result = payerReceiver = PartyReferencePayerReceiver.builder();
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
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getOrCreateSettlementDate() {
			AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrAdjustedOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder getSettlementOrigin() {
			return settlementOrigin;
		}
		
		@Override
		public SettlementOrigin.SettlementOriginBuilder getOrCreateSettlementOrigin() {
			SettlementOrigin.SettlementOriginBuilder result;
			if (settlementOrigin!=null) {
				result = settlementOrigin;
			}
			else {
				result = settlementOrigin = SettlementOrigin.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Transfer.TransferBuilder addIdentifier(FieldWithMetaIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder addIdentifier(FieldWithMetaIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		
			@Override
			public Transfer.TransferBuilder addIdentifierValue(Identifier identifier) {
				this.getOrCreateIdentifier(-1).setValue(identifier.toBuilder());
				return this;
			}
			
			@Override
			public Transfer.TransferBuilder addIdentifierValue(Identifier identifier, int _idx) {
				this.getOrCreateIdentifier(_idx).setValue(identifier.toBuilder());
				return this;
			}
		@Override 
		public Transfer.TransferBuilder addIdentifier(List<? extends FieldWithMetaIdentifier> identifiers) {
			if (identifiers != null) {
				for (FieldWithMetaIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Transfer.TransferBuilder setIdentifier(List<? extends FieldWithMetaIdentifier> identifiers) {
			if (identifiers == null)  {
				this.identifier = new ArrayList<>();
			}
			else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder addIdentifierValue(List<? extends Identifier> identifiers) {
			if (identifiers != null) {
				for (Identifier toAdd : identifiers) {
					this.addIdentifierValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder setIdentifierValue(List<? extends Identifier> identifiers) {
			this.identifier.clear();
			if (identifiers!=null) {
				identifiers.forEach(this::addIdentifierValue);
			}
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder setObservable(Observable observable) {
			this.observable = observable==null?null:observable.toBuilder();
			return this;
		}
		@Override
		public Transfer.TransferBuilder setPayerReceiver(PartyReferencePayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public Transfer.TransferBuilder setQuantity(Quantity quantity) {
			this.quantity = quantity==null?null:quantity.toBuilder();
			return this;
		}
		@Override
		public Transfer.TransferBuilder setSettlementDate(AdjustableOrAdjustedOrRelativeDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		public Transfer.TransferBuilder setSettlementOrigin(SettlementOrigin settlementOrigin) {
			this.settlementOrigin = settlementOrigin==null?null:settlementOrigin.toBuilder();
			return this;
		}
		
		@Override
		public Transfer build() {
			return new Transfer.TransferImpl(this);
		}
		
		@Override
		public Transfer.TransferBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transfer.TransferBuilder prune() {
			identifier = identifier.stream().filter(b->b!=null).<FieldWithMetaIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (observable!=null && !observable.prune().hasData()) observable = null;
			if (payerReceiver!=null && !payerReceiver.prune().hasData()) payerReceiver = null;
			if (quantity!=null && !quantity.prune().hasData()) quantity = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementOrigin!=null && !settlementOrigin.prune().hasData()) settlementOrigin = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getObservable()!=null && getObservable().hasData()) return true;
			if (getPayerReceiver()!=null && getPayerReceiver().hasData()) return true;
			if (getQuantity()!=null && getQuantity().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementOrigin()!=null && getSettlementOrigin().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transfer.TransferBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Transfer.TransferBuilder o = (Transfer.TransferBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::getOrCreateIdentifier);
			merger.mergeRosetta(getObservable(), o.getObservable(), this::setObservable);
			merger.mergeRosetta(getPayerReceiver(), o.getPayerReceiver(), this::setPayerReceiver);
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementOrigin(), o.getSettlementOrigin(), this::setSettlementOrigin);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Transfer _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(observable, _that.getObservable())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementOrigin, _that.getSettlementOrigin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementOrigin != null ? settlementOrigin.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferBuilder {" +
				"identifier=" + this.identifier + ", " +
				"observable=" + this.observable + ", " +
				"payerReceiver=" + this.payerReceiver + ", " +
				"quantity=" + this.quantity + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementOrigin=" + this.settlementOrigin +
			'}';
		}
	}
}
