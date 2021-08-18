package cdm.event.common;

import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.event.common.TransferBase.TransferBaseBuilder;
import cdm.event.common.TransferBase.TransferBaseBuilderImpl;
import cdm.event.common.TransferBase.TransferBaseImpl;
import cdm.event.common.meta.CashTransferComponentMeta;
import cdm.observable.asset.Money;
import cdm.product.common.settlement.CashflowTypeEnum;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface CashTransferComponent extends TransferBase {
	CashTransferComponent build();
	CashTransferComponent.CashTransferComponentBuilder toBuilder();
	
	/**
	 * The currency amount.
	 */
	Money getAmount();
	/**
	 * The cash transfer breakdown, when the transfer corresponds to a net amount across several components which breakdown is deemed relevant (e.g. the net cash transfer related to several contracts, or to the net proceeds across several payout components).
	 */
	List<? extends CashTransferBreakdown> getBreakdown();
	/**
	 * The qualification of the type of cashflow, when not inferred from a derived through lineage e.g. brokerage fee, premium, upfront fee etc.
	 */
	CashflowTypeEnum getCashflowType();
	/**
	 * The payer and receiver party information.
	 */
	PartyReferencePayerReceiver getPayerReceiver();
	final static CashTransferComponentMeta metaData = new CashTransferComponentMeta();
	
	@Override
	default RosettaMetaData<? extends CashTransferComponent> metaData() {
		return metaData;
	} 
			
	static CashTransferComponent.CashTransferComponentBuilder builder() {
		return new CashTransferComponent.CashTransferComponentBuilderImpl();
	}
	
	default Class<? extends CashTransferComponent> getType() {
		return CashTransferComponent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.event.common.TransferBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("cashflowType"), CashflowTypeEnum.class, getCashflowType(), this);
		
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("breakdown"), processor, CashTransferBreakdown.class, getBreakdown());
		processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.class, getPayerReceiver());
	}
	
	
	interface CashTransferComponentBuilder extends CashTransferComponent, TransferBase.TransferBaseBuilder, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		Money.MoneyBuilder getAmount();
		CashTransferBreakdown.CashTransferBreakdownBuilder getOrCreateBreakdown(int _index);
		List<? extends CashTransferBreakdown.CashTransferBreakdownBuilder> getBreakdown();
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getOrCreatePayerReceiver();
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getPayerReceiver();
		CashTransferComponent.CashTransferComponentBuilder setAmount(Money amount);
		CashTransferComponent.CashTransferComponentBuilder addBreakdown(CashTransferBreakdown breakdown);
		CashTransferComponent.CashTransferComponentBuilder addBreakdown(CashTransferBreakdown breakdown, int _idx);
		CashTransferComponent.CashTransferComponentBuilder addBreakdown(List<? extends CashTransferBreakdown> breakdown);
		CashTransferComponent.CashTransferComponentBuilder setBreakdown(List<? extends CashTransferBreakdown> breakdown);
		CashTransferComponent.CashTransferComponentBuilder setCashflowType(CashflowTypeEnum cashflowType);
		CashTransferComponent.CashTransferComponentBuilder setPayerReceiver(PartyReferencePayerReceiver payerReceiver);
		CashTransferComponent.CashTransferComponentBuilder setIdentifier(FieldWithMetaString identifier);
		CashTransferComponent.CashTransferComponentBuilder setIdentifierValue(String identifier);
		CashTransferComponent.CashTransferComponentBuilder setTransferCalculation(TransferCalculation transferCalculation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			TransferBase.TransferBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("cashflowType"), CashflowTypeEnum.class, getCashflowType(), this);
			
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("breakdown"), processor, CashTransferBreakdown.CashTransferBreakdownBuilder.class, getBreakdown());
			processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder.class, getPayerReceiver());
		}
		
	}
	
	//CashTransferComponent.CashTransferComponentImpl
	class CashTransferComponentImpl extends TransferBase.TransferBaseImpl implements CashTransferComponent {
		private final Money amount;
		private final List<? extends CashTransferBreakdown> breakdown;
		private final CashflowTypeEnum cashflowType;
		private final PartyReferencePayerReceiver payerReceiver;
		
		protected CashTransferComponentImpl(CashTransferComponent.CashTransferComponentBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.breakdown = ofNullable(builder.getBreakdown()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cashflowType = builder.getCashflowType();
			this.payerReceiver = ofNullable(builder.getPayerReceiver()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Money getAmount() {
			return amount;
		}
		
		@Override
		public List<? extends CashTransferBreakdown> getBreakdown() {
			return breakdown;
		}
		
		@Override
		public CashflowTypeEnum getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public PartyReferencePayerReceiver getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public CashTransferComponent build() {
			return this;
		}
		
		@Override
		public CashTransferComponent.CashTransferComponentBuilder toBuilder() {
			CashTransferComponent.CashTransferComponentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashTransferComponent.CashTransferComponentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getBreakdown()).ifPresent(builder::setBreakdown);
			ofNullable(getCashflowType()).ifPresent(builder::setCashflowType);
			ofNullable(getPayerReceiver()).ifPresent(builder::setPayerReceiver);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CashTransferComponent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(breakdown, _that.getBreakdown())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (breakdown != null ? breakdown.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashTransferComponent {" +
				"amount=" + this.amount + ", " +
				"breakdown=" + this.breakdown + ", " +
				"cashflowType=" + this.cashflowType + ", " +
				"payerReceiver=" + this.payerReceiver +
			'}' + " " + super.toString();
		}
	}
	
	//CashTransferComponent.CashTransferComponentBuilderImpl
	class CashTransferComponentBuilderImpl extends TransferBase.TransferBaseBuilderImpl  implements CashTransferComponent.CashTransferComponentBuilder {
	
		protected Money.MoneyBuilder amount;
		protected List<CashTransferBreakdown.CashTransferBreakdownBuilder> breakdown = new ArrayList<>();
		protected CashflowTypeEnum cashflowType;
		protected PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder payerReceiver;
	
		public CashTransferComponentBuilderImpl() {
		}
	
		@Override
		public Money.MoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAmount() {
			Money.MoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends CashTransferBreakdown.CashTransferBreakdownBuilder> getBreakdown() {
			return breakdown;
		}
		
		public CashTransferBreakdown.CashTransferBreakdownBuilder getOrCreateBreakdown(int _index) {
		
			if (breakdown==null) {
				this.breakdown = new ArrayList<>();
			}
			CashTransferBreakdown.CashTransferBreakdownBuilder result;
			return getIndex(breakdown, _index, () -> {
						CashTransferBreakdown.CashTransferBreakdownBuilder newBreakdown = CashTransferBreakdown.builder();
						return newBreakdown;
					});
		}
		
		@Override
		public CashflowTypeEnum getCashflowType() {
			return cashflowType;
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
		public CashTransferComponent.CashTransferComponentBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		public CashTransferComponent.CashTransferComponentBuilder addBreakdown(CashTransferBreakdown breakdown) {
			if (breakdown!=null) this.breakdown.add(breakdown.toBuilder());
			return this;
		}
		
		@Override
		public CashTransferComponent.CashTransferComponentBuilder addBreakdown(CashTransferBreakdown breakdown, int _idx) {
			getIndex(this.breakdown, _idx, () -> breakdown.toBuilder());
			return this;
		}
		@Override 
		public CashTransferComponent.CashTransferComponentBuilder addBreakdown(List<? extends CashTransferBreakdown> breakdowns) {
			if (breakdowns != null) {
				for (CashTransferBreakdown toAdd : breakdowns) {
					this.breakdown.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CashTransferComponent.CashTransferComponentBuilder setBreakdown(List<? extends CashTransferBreakdown> breakdowns) {
			if (breakdowns == null)  {
				this.breakdown = new ArrayList<>();
			}
			else {
				this.breakdown = breakdowns.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CashTransferComponent.CashTransferComponentBuilder setCashflowType(CashflowTypeEnum cashflowType) {
			this.cashflowType = cashflowType==null?null:cashflowType;
			return this;
		}
		@Override
		public CashTransferComponent.CashTransferComponentBuilder setPayerReceiver(PartyReferencePayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public CashTransferComponent.CashTransferComponentBuilder setIdentifier(FieldWithMetaString identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public CashTransferComponent.CashTransferComponentBuilder setIdentifierValue(String identifier) {
			this.getOrCreateIdentifier().setValue(identifier);
			return this;
		}
		@Override
		public CashTransferComponent.CashTransferComponentBuilder setTransferCalculation(TransferCalculation transferCalculation) {
			this.transferCalculation = transferCalculation==null?null:transferCalculation.toBuilder();
			return this;
		}
		
		@Override
		public CashTransferComponent build() {
			return new CashTransferComponent.CashTransferComponentImpl(this);
		}
		
		@Override
		public CashTransferComponent.CashTransferComponentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashTransferComponent.CashTransferComponentBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			breakdown = breakdown.stream().filter(b->b!=null).<CashTransferBreakdown.CashTransferBreakdownBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (payerReceiver!=null && !payerReceiver.prune().hasData()) payerReceiver = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getBreakdown()!=null && getBreakdown().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCashflowType()!=null) return true;
			if (getPayerReceiver()!=null && getPayerReceiver().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashTransferComponent.CashTransferComponentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CashTransferComponent.CashTransferComponentBuilder o = (CashTransferComponent.CashTransferComponentBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getBreakdown(), o.getBreakdown(), this::getOrCreateBreakdown);
			merger.mergeRosetta(getPayerReceiver(), o.getPayerReceiver(), this::setPayerReceiver);
			
			merger.mergeBasic(getCashflowType(), o.getCashflowType(), this::setCashflowType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CashTransferComponent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(breakdown, _that.getBreakdown())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (breakdown != null ? breakdown.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashTransferComponentBuilder {" +
				"amount=" + this.amount + ", " +
				"breakdown=" + this.breakdown + ", " +
				"cashflowType=" + this.cashflowType + ", " +
				"payerReceiver=" + this.payerReceiver +
			'}' + " " + super.toString();
		}
	}
}
